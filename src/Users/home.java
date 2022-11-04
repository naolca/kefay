package Users;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	public home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new selfDetails().setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(home.class.getResource("/Users/buyer Details.png")));
		btnNewButton_2.setBounds(41, 119, 89, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new choosePayment().setVisible(true);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(home.class.getResource("/Users/new product.png")));
		btnNewButton_3.setBounds(41, 159, 89, 29);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "do you really want to logout?");
				if (a==0)
				{
					setVisible(false);
					new login().setVisible(true);
					
				}
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(home.class.getResource("/Users/logout.png")));
		btnNewButton_4.setBounds(41, 199, 89, 29);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_1 = new JLabel("make payments");
		lblNewLabel_1.setBounds(140, 166, 132, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("log out");
		lblNewLabel_2.setBounds(140, 206, 61, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("see personal details");
		lblNewLabel_3.setBounds(140, 110, 132, 47);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Welcome Dear Customer");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4.setBounds(25, 11, 474, 127);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(home.class.getResource("/Users/pngtree-vector-business-mobile-payment-poster-image_261492.jpg")));
		lblNewLabel.setBounds(-20, -64, 713, 394);
		contentPane.add(lblNewLabel);
	}
}
