package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SaleOrderController;
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

public class GUI extends JFrame {

	private SaleOrderController saleOrderCtr;
	private JPanel contentPane;
	private JTextField textFieldPhone;
	private CardLayout cardLayout;
	private JTextArea textArea;

	/**
	 * Launch the application.
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
	 * Create the frame.
	 */
	public GUI() {
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
		
		textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 1;
		panel_5.add(textArea, gbc_textArea);
		
		JPanel panel_7 = new JPanel();
		panelSaleOrder.add(panel_7, BorderLayout.NORTH);
		
		JLabel lblSaleHeader = new JLabel("Sale Order");
		panel_7.add(lblSaleHeader);
		
		Container container = getContentPane();
		container.add("MainMenu", panelMainMenu);
		container.add("SaleOrder", panelSaleOrder);

	}

	private void getNextCard() {
		cardLayout.next(contentPane);
	}
	
	private void createSaleOrder() throws DataAccessException {
		String phone = textFieldPhone.getText();
		SaleOrder saleOrder = saleOrderCtr.createSaleOrder(phone);
	}
}

