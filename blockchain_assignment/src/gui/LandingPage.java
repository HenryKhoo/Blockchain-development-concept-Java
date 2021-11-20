package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class LandingPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LandingPage window = new LandingPage();
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
	public LandingPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 499, 572);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Car Info");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(247, 259, 155, 37);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Car Registration");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_1.setBounds(39, 259, 186, 37);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Car Return");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_1_1.setBounds(39, 329, 186, 37);
		frame.getContentPane().add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_2 = new JButton("Employee");
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_1_2.setBounds(247, 329, 155, 37);
		frame.getContentPane().add(btnNewButton_1_1_2);
		
		JButton btnNewButton_1_1_3 = new JButton("Logout");
		btnNewButton_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_1_3.setBounds(178, 437, 155, 37);
		frame.getContentPane().add(btnNewButton_1_1_3);
		
		JLabel lblNewLabel = new JLabel("Main Menu");
		lblNewLabel.setFont(new Font("Sitka Heading", Font.PLAIN, 25));
		lblNewLabel.setBounds(187, 147, 117, 37);
		frame.getContentPane().add(lblNewLabel);
	}

}
