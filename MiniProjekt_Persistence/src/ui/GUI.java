package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SaleOrderController;
import model.BusinessCustomer;
import model.Customer;
import model.Orderline;
import model.PrivateCustomer;
import model.SaleOrder;
import utility.DataAccessException;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class GUI extends JFrame {

	private SaleOrderController saleOrderCtr;
	private JPanel contentPane;
	private JTextField textFieldPhone;
	private CardLayout cardLayout;
	private JTextArea textAreaCustomerInfo;
	private JTextField textFieldBarcode;
	private JTextField textFieldQuantity;
	private JTextArea textAreaCompletionInfo;
	private GridBagConstraints gbc_textAreaProductsInfo;
	private JTextArea textAreaProductsInfo;
	private JTextArea textAreaPrice;
	private JTextArea textAreaTotal;

	/**
	 * Main method to launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor to create the frame.
	 * @throws DataAccessException 
	 */
	public GUI() throws DataAccessException {
		this.saleOrderCtr = new SaleOrderController();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		cardLayout = new CardLayout(0, 0);
		contentPane.setLayout(cardLayout);
		
		JPanel panelMainMenu = new JPanel();
		contentPane.add(panelMainMenu, "name_664142124683100");
		
		JPanel panelSaleOrder = new JPanel();
		contentPane.add(panelSaleOrder, "name_665764940131700");
		panelSaleOrder.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelSaleOrder.add(panel_4, BorderLayout.SOUTH);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(saleOrderCtr.getSaleOrder() == null) {
					getMainMenuCard();
				}
				else {
					textAreaCustomerInfo.setText("");
					textAreaCustomerInfo.append("This is an alternative flow that has not been implemented.");
					textAreaCustomerInfo.append(" \n");
					textAreaCustomerInfo.append("Continue processing SaleOrder or terminate program.");
				}
			}
		});
		panel_4.add(btnCancel);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(saleOrderCtr.getSaleOrder() != null) {
					getNextCard();
				}
				else {
					textAreaCustomerInfo.setText("");
					textAreaCustomerInfo.append("Error!");
					textAreaCustomerInfo.append(" \n");
					textAreaCustomerInfo.append("Search for a customer and press create before continuing");
				}
			}
		});
		panel_4.add(btnNext);
		
		JPanel panel_6 = new JPanel();
		panelSaleOrder.add(panel_6, BorderLayout.WEST);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_6.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		JLabel lblCustomerPhone = new JLabel("Customer phone:");
		GridBagConstraints gbc_lblCustomerPhone = new GridBagConstraints();
		gbc_lblCustomerPhone.anchor = GridBagConstraints.WEST;
		gbc_lblCustomerPhone.insets = new Insets(0, 0, 5, 0);
		gbc_lblCustomerPhone.gridx = 0;
		gbc_lblCustomerPhone.gridy = 0;
		panel_6.add(lblCustomerPhone, gbc_lblCustomerPhone);
		
		textFieldPhone = new JTextField();
		GridBagConstraints gbc_textFieldPhone = new GridBagConstraints();
		gbc_textFieldPhone.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPhone.gridx = 0;
		gbc_textFieldPhone.gridy = 1;
		panel_6.add(textFieldPhone, gbc_textFieldPhone);
		textFieldPhone.setColumns(10);
		
		JButton btnCreateSaleOrder = new JButton("Create");
		btnCreateSaleOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldPhone.getText().isBlank()) {
					try {
						createSaleOrder();
					} catch (DataAccessException e1) {
						e1.printStackTrace();
					}
				}
				else {
					textAreaCustomerInfo.setText("Error! No phone input");
				}
			}
		});
		GridBagConstraints gbc_btnCreateSaleOrder = new GridBagConstraints();
		gbc_btnCreateSaleOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreateSaleOrder.gridx = 0;
		gbc_btnCreateSaleOrder.gridy = 3;
		panel_6.add(btnCreateSaleOrder, gbc_btnCreateSaleOrder);
		
		JPanel panel_5 = new JPanel();
		panelSaleOrder.add(panel_5, BorderLayout.CENTER);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel lblNewLabel = new JLabel("Customer info:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_5.add(lblNewLabel, gbc_lblNewLabel);
		
		textAreaCustomerInfo = new JTextArea();
		GridBagConstraints gbc_textAreaTotal = new GridBagConstraints();
		gbc_textAreaTotal.fill = GridBagConstraints.BOTH;
		gbc_textAreaTotal.gridx = 0;
		gbc_textAreaTotal.gridy = 1;
		panel_5.add(textAreaCustomerInfo, gbc_textAreaTotal);
		
		JPanel panel_7 = new JPanel();
		panelSaleOrder.add(panel_7, BorderLayout.NORTH);
		
		JLabel lblSaleHeader = new JLabel("Sale Order");
		panel_7.add(lblSaleHeader);
		
		JPanel panelAddProducts = new JPanel();
		contentPane.add(panelAddProducts, "name_756254638347500");
		panelAddProducts.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panelAddProducts.add(panel_8, BorderLayout.WEST);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{0, 0};
		gbl_panel_8.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_8.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_8.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_8.setLayout(gbl_panel_8);
		
		JLabel lblBarcode = new JLabel("Barcode:");
		GridBagConstraints gbc_lblBarcode = new GridBagConstraints();
		gbc_lblBarcode.anchor = GridBagConstraints.WEST;
		gbc_lblBarcode.insets = new Insets(0, 0, 5, 0);
		gbc_lblBarcode.gridx = 0;
		gbc_lblBarcode.gridy = 0;
		panel_8.add(lblBarcode, gbc_lblBarcode);
		
		textFieldBarcode = new JTextField();
		GridBagConstraints gbc_textFieldBarcode = new GridBagConstraints();
		gbc_textFieldBarcode.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldBarcode.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBarcode.gridx = 0;
		gbc_textFieldBarcode.gridy = 1;
		panel_8.add(textFieldBarcode, gbc_textFieldBarcode);
		textFieldBarcode.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		GridBagConstraints gbc_lblQuantity = new GridBagConstraints();
		gbc_lblQuantity.anchor = GridBagConstraints.WEST;
		gbc_lblQuantity.insets = new Insets(0, 0, 5, 0);
		gbc_lblQuantity.gridx = 0;
		gbc_lblQuantity.gridy = 2;
		panel_8.add(lblQuantity, gbc_lblQuantity);
		
		textFieldQuantity = new JTextField();
		GridBagConstraints gbc_textFieldQuantity = new GridBagConstraints();
		gbc_textFieldQuantity.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldQuantity.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldQuantity.gridx = 0;
		gbc_textFieldQuantity.gridy = 3;
		panel_8.add(textFieldQuantity, gbc_textFieldQuantity);
		textFieldQuantity.setColumns(10);
		
		JButton btnAddProduct = new JButton("Add product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldBarcode.getText().isBlank() && !textFieldQuantity.getText().isBlank()) {
					try {
						addProduct();
					} catch (DataAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(textFieldBarcode.getText().isBlank()) {
					textAreaProductsInfo.setText("");
					textAreaProductsInfo.append("Error! No barcode input");
				}
				if(textFieldQuantity.getText().isBlank()) {
					textAreaProductsInfo.setText("");
					textAreaProductsInfo.append("Error! No quantity input");
				}
				if(textFieldBarcode.getText().isBlank() && textFieldQuantity.getText().isBlank()) {
					textAreaProductsInfo.setText("");
					textAreaProductsInfo.append("Error! No barcode and quantity input");
				}
			}
		});
		
		GridBagConstraints gbc_btnAddProduct = new GridBagConstraints();
		gbc_btnAddProduct.gridx = 0;
		gbc_btnAddProduct.gridy = 5;
		panel_8.add(btnAddProduct, gbc_btnAddProduct);
		
		JPanel panel_9 = new JPanel();
		panelAddProducts.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_13 = new JPanel();
		panel_9.add(panel_13, BorderLayout.EAST);
		GridBagLayout gbl_panel_13 = new GridBagLayout();
		gbl_panel_13.columnWidths = new int[]{0, 0};
		gbl_panel_13.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_13.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_13.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_13.setLayout(gbl_panel_13);
		
		JLabel lblPrice = new JLabel("Product price:");
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.anchor = GridBagConstraints.WEST;
		gbc_lblPrice.insets = new Insets(0, 0, 5, 0);
		gbc_lblPrice.gridx = 0;
		gbc_lblPrice.gridy = 0;
		panel_13.add(lblPrice, gbc_lblPrice);
		
		textAreaPrice = new JTextArea();
		GridBagConstraints gbc_textAreaPrice = new GridBagConstraints();
		gbc_textAreaPrice.insets = new Insets(0, 0, 5, 0);
		gbc_textAreaPrice.fill = GridBagConstraints.BOTH;
		gbc_textAreaPrice.gridx = 0;
		gbc_textAreaPrice.gridy = 1;
		panel_13.add(textAreaPrice, gbc_textAreaPrice);
		
		textAreaTotal = new JTextArea();
		GridBagConstraints gbc_textAreaTotal1 = new GridBagConstraints();
		gbc_textAreaTotal1.fill = GridBagConstraints.BOTH;
		gbc_textAreaTotal1.gridx = 0;
		gbc_textAreaTotal1.gridy = 2;
		panel_13.add(textAreaTotal, gbc_textAreaTotal1);
		
		JPanel panel_15 = new JPanel();
		panel_9.add(panel_15, BorderLayout.CENTER);
		GridBagLayout gbl_panel_15 = new GridBagLayout();
		gbl_panel_15.columnWidths = new int[]{0, 0};
		gbl_panel_15.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_15.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_15.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_15.setLayout(gbl_panel_15);
		
		JLabel lblProductInfo = new JLabel("Product info:");
		GridBagConstraints gbc_lblProductInfo = new GridBagConstraints();
		gbc_lblProductInfo.anchor = GridBagConstraints.WEST;
		gbc_lblProductInfo.insets = new Insets(0, 0, 5, 0);
		gbc_lblProductInfo.gridx = 0;
		gbc_lblProductInfo.gridy = 0;
		panel_15.add(lblProductInfo, gbc_lblProductInfo);
		
		textAreaProductsInfo = new JTextArea();
		GridBagConstraints gbc_textArea1;
		gbc_textAreaProductsInfo = new GridBagConstraints();
		gbc_textAreaProductsInfo.insets = new Insets(0, 0, 5, 0);
		gbc_textAreaProductsInfo.fill = GridBagConstraints.BOTH;
		gbc_textAreaProductsInfo.gridx = 0;
		gbc_textAreaProductsInfo.gridy = 1;
		panel_15.add(textAreaProductsInfo, gbc_textAreaProductsInfo);
		
		JLabel lblTotal = new JLabel("Total:");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.WEST;
		gbc_lblTotal.gridx = 0;
		gbc_lblTotal.gridy = 2;
		panel_15.add(lblTotal, gbc_lblTotal);
		
		JPanel panel_10 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_10.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panelAddProducts.add(panel_10, BorderLayout.SOUTH);
		
		JButton btnCancelAddProduct = new JButton("Cancel");
		btnCancelAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(saleOrderCtr.getSaleOrder() == null) {
					getMainMenuCard();
				}
				else {
					textAreaProductsInfo.setText("");
					textAreaProductsInfo.append("This is an alternative flow that has not been implemented.");
					textAreaProductsInfo.append(" \n");
					textAreaProductsInfo.append("Continue processing SaleOrder or terminate program.");
				}
			}
		});
		panel_10.add(btnCancelAddProduct);
		
		JButton btnComplete = new JButton("Complete");
		btnComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(saleOrderCtr.getSaleOrder().getOrderlines().isEmpty() == false) {
					try {
						getNextCard();
						completeSaleOrder();
					} catch (DataAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					textAreaProductsInfo.append("Error!");
					textAreaProductsInfo.append(" \n");
					textAreaProductsInfo.append("Input barcode and quantity and press add before continuing");
				}
			}
		});
		panel_10.add(btnComplete);
		
		JPanel panel_11 = new JPanel();
		panelAddProducts.add(panel_11, BorderLayout.NORTH);
		
		JLabel lblAddproductsHeader = new JLabel("Add products");
		panel_11.add(lblAddproductsHeader);
		
		JPanel panelCompleteOrder = new JPanel();
		contentPane.add(panelCompleteOrder, "name_758081808222800");
		panelCompleteOrder.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12 = new JPanel();
		panelCompleteOrder.add(panel_12, BorderLayout.CENTER);
		GridBagLayout gbl_panel_12 = new GridBagLayout();
		gbl_panel_12.columnWidths = new int[]{0, 0};
		gbl_panel_12.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_12.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_12.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_12.setLayout(gbl_panel_12);
		
		JLabel lblCompletionInfo = new JLabel("Info:");
		GridBagConstraints gbc_lblCompletionInfo = new GridBagConstraints();
		gbc_lblCompletionInfo.anchor = GridBagConstraints.WEST;
		gbc_lblCompletionInfo.insets = new Insets(0, 0, 5, 0);
		gbc_lblCompletionInfo.gridx = 0;
		gbc_lblCompletionInfo.gridy = 0;
		panel_12.add(lblCompletionInfo, gbc_lblCompletionInfo);
		
		textAreaCompletionInfo = new JTextArea();
		GridBagConstraints gbc_textArea11 = new GridBagConstraints();
		gbc_textArea11.insets = new Insets(0, 0, 5, 0);
		gbc_textArea11.fill = GridBagConstraints.BOTH;
		gbc_textArea11.gridx = 0;
		gbc_textArea11.gridy = 1;
		panel_12.add(textAreaCompletionInfo, gbc_textArea11);
		
		JButton btnSendReceipt = new JButton("Send to email");
		GridBagConstraints gbc_btnSendReceipt = new GridBagConstraints();
		gbc_btnSendReceipt.gridx = 0;
		gbc_btnSendReceipt.gridy = 2;
		panel_12.add(btnSendReceipt, gbc_btnSendReceipt);
		
		JPanel panel_14 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_14.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panelCompleteOrder.add(panel_14, BorderLayout.SOUTH);
		
		JButton btnOK = new JButton("OK");
		panel_14.add(btnOK);
		
		panelMainMenu.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panelMainMenu.add(panel, BorderLayout.NORTH);
		
		JLabel lblHeader = new JLabel("Main Menu");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblHeader);
		
		JPanel panel_1 = new JPanel();
		panelMainMenu.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 50));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] {0, 0};
		gbl_panel_2.rowHeights = new int[] {0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JButton btnSaleOrder = new JButton("Sale Order");
		btnSaleOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getNextCard();
			}
		});
		btnSaleOrder.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnSaleOrder = new GridBagConstraints();
		gbc_btnSaleOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSaleOrder.insets = new Insets(0, 0, 5, 0);
		gbc_btnSaleOrder.gridx = 0;
		gbc_btnSaleOrder.gridy = 0;
		panel_2.add(btnSaleOrder, gbc_btnSaleOrder);
		
		JButton btnNewButton_1 = new JButton("Customer");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		panel_2.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Warehouse");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 2;
		panel_2.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btnRental = new JButton("Rental");
		btnRental.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnRental = new GridBagConstraints();
		gbc_btnRental.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRental.insets = new Insets(0, 0, 5, 0);
		gbc_btnRental.gridx = 0;
		gbc_btnRental.gridy = 0;
		panel_3.add(btnRental, gbc_btnRental);
		
		JButton btnNewButton_4 = new JButton("Employee");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 1;
		panel_3.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Product");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_5.gridx = 0;
		gbc_btnNewButton_5.gridy = 2;
		panel_3.add(btnNewButton_5, gbc_btnNewButton_5);
		
		Container container = getContentPane();
		container.add("MainMenu", panelMainMenu);
		container.add("SaleOrder", panelSaleOrder);
		container.add("AddProduct", panelAddProducts);
		container.add("CompleteOrder", panelCompleteOrder);

	}

	/**
	 * Changes GUI layout to show next panel in container.
	 */
	private void getNextCard() {
		cardLayout.next(contentPane);
	}
	
	private void getMainMenuCard() {
		cardLayout.first(contentPane);
	}
	
	/**
	 * Creates a SaleOrder object containing a Customer and Employee object.
	 * Prints info on Customer.
	 * @throws DataAccessException
	 */
	private void createSaleOrder() throws DataAccessException {
		String phone = textFieldPhone.getText();
		SaleOrder saleOrder = saleOrderCtr.createSaleOrder(phone);
		String fname = saleOrder.getCustomer().getFname();
		String lname = saleOrder.getCustomer().getLname();
		String address = saleOrder.getCustomer().getAddress();
		String city = saleOrder.getCustomer().getCity();
		int zipcode = saleOrder.getCustomer().getZipcode();
		String email = saleOrder.getCustomer().getEmail();
		String phoneNumber = saleOrder.getCustomer().getPhone();
		String customerType = null;
		if(saleOrder.getCustomer() instanceof PrivateCustomer) {
			customerType = "Private customer";
		}
		else if(saleOrder.getCustomer() instanceof BusinessCustomer) {
			customerType = "Business customer";
		}
		textAreaCustomerInfo.setText("");
		textAreaCustomerInfo.append("Name: " + fname + " " + lname);
		textAreaCustomerInfo.append(" \n");
		textAreaCustomerInfo.append("Email: " + email);
		textAreaCustomerInfo.append(" \n");
		textAreaCustomerInfo.append("Phone number: " + phoneNumber);
		textAreaCustomerInfo.append(" \n");
		textAreaCustomerInfo.append("Address: " + address + " " + zipcode + " " + city);
		textAreaCustomerInfo.append(" \n");
		textAreaCustomerInfo.append("Customer type: " + customerType);
	}
	
	/**
	 * Adds Orderline object containing a Product to SaleOrder object.
	 * Prints info on Product and SaleOrder total.
	 * @throws DataAccessException
	 */
	private void addProduct() throws DataAccessException {
		String barcodeInput = textFieldBarcode.getText();
		int barcode = Integer.parseInt(barcodeInput);
		String quantityInput = textFieldQuantity.getText();
		int quantity = Integer.parseInt(quantityInput);
		SaleOrder saleOrder = saleOrderCtr.addProduct(barcode, quantity);
		textAreaProductsInfo.setText("");
		textAreaPrice.setText("");
		textAreaTotal.setText("");
		for(Orderline element : saleOrder.getOrderlines()) {
			textAreaProductsInfo.append("Name: " + element.getBuyProduct().getName());
			textAreaProductsInfo.append(" \n");
			textAreaPrice.append("Price: " + element.getBuyProduct().getSalesPrice());
			textAreaPrice.append(" \n");
		}
		textAreaTotal.setText("Total: " + saleOrder.getTotal());
	}
	
	/**
	 * Completes SaleOrder by saving SaleOrder objects data in database.
	 * Prints confirmation.
	 * @throws DataAccessException
	 */
	private void completeSaleOrder() throws DataAccessException {
		boolean completed = saleOrderCtr.completeSaleOrder();
		if(completed) {
			textAreaCompletionInfo.append("Sale order completed successfully");
			textAreaCompletionInfo.append("Receipt has been printed");
		}
		else {
			textAreaCompletionInfo.append("Sale order completion failed. Start over.");
		}
	}
	
	
}

