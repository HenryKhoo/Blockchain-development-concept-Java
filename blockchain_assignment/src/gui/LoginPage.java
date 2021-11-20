package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import blockchain_operation.Password;

public class LoginPage {

	private JFrame frame;
	private JTextField userID;
	private JTextField password;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.PLAIN, 16));
		lblNewLabel.setBounds(412, 167, 77, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(412, 217, 77, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		userID = new JTextField();
		userID.setBounds(500, 165, 160, 26);
		frame.getContentPane().add(userID);
		userID.setColumns(10);
		
		password = new JTextField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 16));
		password.setBounds(500, 214, 160, 26);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//login action
				String id = userID.getText();
				String pw = password.getText();

				//login logic
				Password p = new Password();
				if(p.compare(id, pw)) {
					JOptionPane.showMessageDialog(frame, "Login successful");
				}
				else {
					JOptionPane.showMessageDialog(frame, "Invalid ID or password");
				}
			}
		});
		btnNewButton.setBounds(424, 298, 115, 51);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Henry\\eclipse-workspace\\blockchain_assignment\\img\\carRental.jpg"));
		
		
		lblNewLabel_2.setBounds(37, 69, 300, 280);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Car Management System");
		lblNewLabel_3.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(424, 91, 207, 41);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//register user
				String id = userID.getText();
				String pw = password.getText();
				Password p = new Password();
				p.create(id, pw);
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRegister.setBounds(558, 298, 115, 51);
		frame.getContentPane().add(btnRegister);
		frame.setBounds(100, 100, 728, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
