package Users;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class signup extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws  ClassNotFoundException,SQLException,SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
					frame.setVisible(true);
				} catch (Exception ClassNotFoundException)
				{
					JOptionPane.showMessageDialog(null, "phone number already exists,try again");
				}
			
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public signup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = 	new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("user name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(33, 89, 114, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(33, 119, 114, 21);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(157, 94, 150, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 120, 150, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("phone NO");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(33, 156, 114, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(157, 157, 150, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("signup");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				String url="jdbc:mysql://localhost:3306/kefay";
				String uname="root";
				String pass="";
				
				String name=textField.getText();
				String password=textField_1.getText();
				String phoneNO=textField_2.getText();
				try
				{
					if (name.isEmpty()||password.isEmpty()||phoneNO.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "all fields must be filled");
						return;
					}
					if(phoneNO.length()<10||phoneNO.length()>10)
					{
					 JOptionPane.showMessageDialog(null, "the phone number you entered is not correct");
					}
					else {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection(url,uname,pass);
					Statement st=con.createStatement();
					st.executeUpdate(" insert into customers(name,password,phoneNO) values('"+name+"','"+ password+ "','"+phoneNO+"')");
					JOptionPane.showMessageDialog(null, "signUp successful!");
					}
				}
				
				catch(Exception SQLException)
				{
					JOptionPane.showMessageDialog(null, "phone number already exists,try again");
					
				}
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(75, 188, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "do you really want to cancle signing up?");
				if(a==0)
				{
					setVisible(false);
					new login().setVisible(true);
				}
			}
		});
		btnNewButton_1.setBounds(218, 188, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(signup.class.getResource("/Users/login-security.png")));
		lblNewLabel_3.setBounds(0, 3, 448, 261);
		contentPane.add(lblNewLabel_3);
		
		
	}

}
