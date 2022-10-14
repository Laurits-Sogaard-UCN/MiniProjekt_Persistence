package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SaleOrderController;
import model.Orderline;
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

public class GUI extends JFrame {

	private SaleOrderController saleOrderCtr;
	private JPanel contentPane;
	private JTextField textFieldPhone;
	private CardLayout cardLayout;
	private JTextArea textAreaCustomerInfo;
	private JTextField textFieldBarcode;
	private JTextField textFieldQuantity;
	private JTextArea textAreaProductsInfo;
	private JTextArea textAreaCompletionInfo;

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
		
		GridBagLayout gbl_panelMainMenu = new GridBagLayout();
		gbl_panelMainMenu.columnWidths = new int[]{0, 0};
		gbl_panelMainMenu.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelMainMenu.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelMainMenu.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panelMainMenu.setLayout(gbl_panelMainMenu);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panelMainMenu.add(panel_3, gbc_panel_3);
		
		JLabel lblHeader = new JLabel("Main Menu");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_3.add(lblHeader);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		panelMainMenu.add(panel, gbc_panel);
		
		JButton btnSaleOrder = new JButton("Sale Order");
		btnSaleOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getNextCard();
			}
		});
		panel.add(btnSaleOrder);
		
		JButton btnRental = new JButton("Rental");
		panel.add(btnRental);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		panelMainMenu.add(panel_1, gbc_panel_1);
		
		JButton btnCustomer = new JButton("Customer");
		panel_1.add(btnCustomer);
		
		JButton btnEmployee = new JButton("Employee");
		panel_1.add(btnEmployee);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 3;
		panelMainMenu.add(panel_2, gbc_panel_2);
		
		JButton btnWarehouse = new JButton("Warehouse");
		panel_2.add(btnWarehouse);
		
		JButton btnProducts = new JButton("Product");
		panel_2.add(btnProducts);
		
		JPanel panelSaleOrder = new JPanel();
		contentPane.add(panelSaleOrder, "name_665764940131700");
		panelSaleOrder.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelSaleOrder.add(panel_4, BorderLayout.SOUTH);
		
		JButton btnCancel = new JButton("Cancel");
		panel_4.add(btnCancel);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					createSaleOrder();
					getNextCard();
				} catch (DataAccessException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_4.add(btnNext);
		
		JPanel panel_6 = new JPanel();
		panelSaleOrder.add(panel_6, BorderLayout.WEST);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0, 0};
		gbl_panel_6.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
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
		gbc_textFieldPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPhone.gridx = 0;
		gbc_textFieldPhone.gridy = 1;
		panel_6.add(textFieldPhone, gbc_textFieldPhone);
		textFieldPhone.setColumns(10);
		
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
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 1;
		panel_5.add(textAreaCustomerInfo, gbc_textArea);
		
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
				try {
					addProduct();
				} catch (DataAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnAddProduct = new GridBagConstraints();
		gbc_btnAddProduct.gridx = 0;
		gbc_btnAddProduct.gridy = 5;
		panel_8.add(btnAddProduct, gbc_btnAddProduct);
		
		JPanel panel_9 = new JPanel();
		panelAddProducts.add(panel_9, BorderLayout.CENTER);
		GridBagLayout gbl_panel_9 = new GridBagLayout();
		gbl_panel_9.columnWidths = new int[]{0, 0};
		gbl_panel_9.rowHeights = new int[]{0, 0, 0};
		gbl_panel_9.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_9.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_9.setLayout(gbl_panel_9);
		
		JLabel lblProducts = new JLabel("Products:");
		GridBagConstraints gbc_lblProducts = new GridBagConstraints();
		gbc_lblProducts.anchor = GridBagConstraints.WEST;
		gbc_lblProducts.insets = new Insets(0, 0, 5, 0);
		gbc_lblProducts.gridx = 0;
		gbc_lblProducts.gridy = 0;
		panel_9.add(lblProducts, gbc_lblProducts);
		
		textAreaProductsInfo = new JTextArea();
		GridBagConstraints gbc_textArea_1 = new GridBagConstraints();
		gbc_textArea_1.fill = GridBagConstraints.BOTH;
		gbc_textArea_1.gridx = 0;
		gbc_textArea_1.gridy = 1;
		panel_9.add(textAreaProductsInfo, gbc_textArea_1);
		
		JPanel panel_10 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_10.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panelAddProducts.add(panel_10, BorderLayout.SOUTH);
		
		JButton btnCancelAddProduct = new JButton("Cancel");
		panel_10.add(btnCancelAddProduct);
		
		JButton btnComplete = new JButton("Complete");
		btnComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getNextCard();
				try {
					completeSaleOrder();
				} catch (DataAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
		GridBagConstraints gbc_textArea1 = new GridBagConstraints();
		gbc_textArea1.insets = new Insets(0, 0, 5, 0);
		gbc_textArea1.fill = GridBagConstraints.BOTH;
		gbc_textArea1.gridx = 0;
		gbc_textArea1.gridy = 1;
		panel_12.add(textAreaCompletionInfo, gbc_textArea1);
		
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
	
	/**
	 * Creates a SaleOrder object containing a Customer and Employee object.
	 * @throws DataAccessException
	 */
	private void createSaleOrder() throws DataAccessException {
		String phone = textFieldPhone.getText();
		SaleOrder saleOrder = saleOrderCtr.createSaleOrder(phone);
		String fname = saleOrder.getCustomer().getFname();
		String lname = saleOrder.getCustomer().getLname();
		textAreaCustomerInfo.setText("Name: " + fname + " " + lname);
	}
	
	private void addProduct() throws DataAccessException {
		String barcodeInput = textFieldBarcode.getText();
		int barcode = Integer.parseInt(barcodeInput);
		String quantityInput = textFieldQuantity.getText();
		int quantity = Integer.parseInt(quantityInput);
		SaleOrder saleOrder = saleOrderCtr.addProduct(barcode, quantity);
		for(Orderline element : saleOrder.getOrderlines()) {
			textAreaProductsInfo.append("Name: " + element.getBuyProduct().getName());
			textAreaProductsInfo.append("Price: " + element.getBuyProduct().getSalesPrice());
			textAreaProductsInfo.append(" \n");
		}
		textAreaProductsInfo.append("Total: " + saleOrder.getTotal());
	}
	
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

