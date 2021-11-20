package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;

public class CarRental {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarRental window = new CarRental();
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
	public CarRental() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 662, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(46, 43, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(46, 61, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setBounds(46, 84, 45, 13);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.setBounds(46, 104, 45, 13);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		table = new JTable();
		table.setBounds(368, 213, 206, -185);
		frame.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(26, 141, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(137, 141, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("New button");
		btnNewButton_1_1.setBounds(26, 182, 85, 21);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("New button");
		btnNewButton_1_1_1.setBounds(137, 182, 85, 21);
		frame.getContentPane().add(btnNewButton_1_1_1);
	}
}
