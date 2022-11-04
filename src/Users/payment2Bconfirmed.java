package Users;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.ImageIcon;
import java.awt.Color;

public class payment2Bconfirmed extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payment2Bconfirmed frame = new payment2Bconfirmed();
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
	public payment2Bconfirmed() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("For which customer do you want to");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(30, 11, 404, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("confirm payment?");
		lblNewLabel_1.setBackground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(116, 40, 237, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("username");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(30, 84, 124, 21);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(152, 85, 128, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm for");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 116, 183, 14);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(152, 109, 128, 22);
		contentPane.add(comboBox);
		comboBox.addItem("Electricity");
		comboBox.addItem("WIFI");
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					if(textField.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "you didn't enter a username");
						return;
					}
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/kefay";
					String uname="root";
					String pass="";
					Connection con=DriverManager.getConnection(url,uname,pass);
					Statement st=con.createStatement();
					if(comboBox.getSelectedItem()=="Electricity")
					{
						int count= st.executeUpdate("update customers set electricity_bill='paid' where name='"+textField.getText()+"'");
						JOptionPane.showMessageDialog(null, "electricity bill payment confirmed succesfully");
					}
					if(comboBox.getSelectedItem()=="WIFI")
					{
						int count= st.executeUpdate("update customers set WIFI_Bill='paid' where name='"+textField.getText()+"'");
						JOptionPane.showMessageDialog(null, "WIFI bill payment confirmed succesfully");
						
					
					}
					
					
					
					
				}
				catch(Exception excep)
				{
				excep.printStackTrace();	
				}
			}
		});
		btnNewButton.setBounds(69, 156, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new adminHome().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(276, 156, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setIcon(new ImageIcon(payment2Bconfirmed.class.getResource("/Users/login-security.png")));
		lblNewLabel_4.setBounds(0, 0, 434, 272);
		contentPane.add(lblNewLabel_4);
	}

}
