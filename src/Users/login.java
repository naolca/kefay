package Users;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;


public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public static customer customer;
	public static Admin admin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(213, 254, 114, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(213, 287, 95, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(328, 256, 152, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(328, 287, 151, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.setIcon(new ImageIcon(login.class.getResource("/Users/login.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					if(textField.getText().isEmpty()||textField_1.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "all fields must be filled.");
						return;
					}
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/kefay";
					String uname="root";
					String pass="";
					Connection con=DriverManager.getConnection(url,uname,pass);
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from customers");
					int number_of_customers=0;
					
					
					while(rs.next())
					{
						number_of_customers++;
					}
					String[] customers=new String[number_of_customers];
					ResultSet new_rs=st.executeQuery("select * from customers");
					new_rs.next();
					for(int i = 0;i<customers.length;i++)
					{
						customers[i]=new_rs.getString("name");
						new_rs.next();
						
					}
					String username= textField.getText();
				
					
					for(int j=0;j<customers.length;j++)
					{
						if (customers[j].equals(username))
						
							
						{
							ResultSet pass_rs=st.executeQuery("select password from customers where name='"+username+"'");
							pass_rs.next();
							if(pass_rs.getString("password").equals(textField_1.getText()))
							{
							setCustomer(username,textField_1.getText());
							setVisible(false);
							new home().setVisible(true);
							return;
							}
							else
							{
								JOptionPane.showMessageDialog(null, "password incorrect.Try Again.");
								return;
							}
						}
					}
					ResultSet admin_rs=st.executeQuery("select * from admin");
					int number_of_admins=0;
					while(admin_rs.next())
					{
						number_of_admins++;
					}
					String[] admins=new String[number_of_admins];
					ResultSet ADMINS_rs= st.executeQuery("select * from admin");
					ADMINS_rs.next();
					for(int i=0;i<admins.length;i++)
					{
						admins[i]=ADMINS_rs.getString("name");
						ADMINS_rs.next();
					}
					for(int j=0;j<admins.length;j++)
					{
						if (admins[j].equals(username))
						{
							ResultSet pass_rs=st.executeQuery("select password from admin where name='"+username+"'");
							pass_rs.next();
							if(pass_rs.getString("password").equals(textField_1.getText()))
							{
							setAdmin(username,textField_1.getText());
							setVisible(false);
							new adminHome().setVisible(true);
							return;
							}
						}
					}
					JOptionPane.showMessageDialog(null, "account with this username doesn't exist,try signing up");
					
				}
				catch(Exception exepti)
				{
					exepti.printStackTrace();
				}
			}
				
			
		});
		btnNewButton.setBounds(232, 329, 89, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("close");
		btnNewButton_1.setIcon(new ImageIcon(login.class.getResource("/Users/close Jframe.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "Do you want to close the application?");
				if(a==0)
				{
					System.exit(0);
				}
			}
		});
		btnNewButton_1.setBounds(406, 329, 89, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("new? sign up");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new signup().setVisible(true);
			}
		});
		btnNewButton_2.setBounds(302, 363, 122, 36);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(login.class.getResource("/Users/login-security.png")));
		lblNewLabel_2.setBounds(-44, -44, 774, 507);
		contentPane.add(lblNewLabel_2);
	}
	public void setCustomer(String name,String password)
	{
		this.customer=new customer(name,password);
	}
	public void setAdmin(String name,String password)
	{
		this.admin=new Admin(name,password);
	}
}
