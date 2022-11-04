package Users;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class WIFI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WIFI frame = new WIFI();
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
	public WIFI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WIFI Bill Payment Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(49, 22, 345, 58);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(186, 91, 126, 22);
		contentPane.add(comboBox);
		comboBox.addItem("Jan");
		comboBox.addItem("Feb");
		comboBox.addItem("Mar");
		comboBox.addItem("Apr");
		comboBox.addItem("May");
		comboBox.addItem("June");
		comboBox.addItem("July");
		comboBox.addItem("Aug");
		comboBox.addItem("Sep");
		comboBox.addItem("Oct");
		comboBox.addItem("Nov");
		comboBox.addItem("Dec");
		
		JLabel lblNewLabel_1 = new JLabel("Month");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(100, 99, 101, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Payed Amount");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(10, 125, 163, 21);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(186, 122, 126, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Transaction Code");
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(12, 157, 189, 27);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(186, 164, 126, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("make payment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/kefay";
					String uname="root";
					String pass="";
					Connection con=DriverManager.getConnection(url,uname,pass);
					Statement st=con.createStatement();
					int count=st.executeUpdate("update customers set  WIFI_paid_month='"+comboBox.getSelectedItem()+"', WIFI_payment_code='"+textField_1.getText()+"', WIFI_paid_amount='"+textField.getText()+"'where name='"+login.customer.getName()+"'");
					JOptionPane.showMessageDialog(null, "your payment has been recorded, check later for confirmation");
					
						
					
				}
				catch(Exception exception)
				{
					exception.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(38, 195, 114, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new choosePayment().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(277, 195, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(WIFI.class.getResource("/Users/0-7334_espias-wifi-transparent-background-wifi-icon-png-png.jpeg")));
		lblNewLabel_4.setBounds(20, -152, 794, 597);
		contentPane.add(lblNewLabel_4);
	}
}
