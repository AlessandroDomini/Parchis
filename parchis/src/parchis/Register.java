package parchis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txt_user;
	private JTextField txt_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(169, 26, 93, 36);
		contentPane.add(lblNewLabel);

		JLabel label_user = new JLabel("User name");
		label_user.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_user.setBounds(69, 92, 71, 14);
		contentPane.add(label_user);

		JLabel labael_pass = new JLabel("Password");
		labael_pass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labael_pass.setBounds(69, 123, 71, 14);
		contentPane.add(labael_pass);

		txt_user = new JTextField();
		txt_user.setBounds(149, 90, 123, 20);
		contentPane.add(txt_user);
		txt_user.setColumns(10);

		txt_pass = new JTextField();
		txt_pass.setBounds(150, 121, 122, 20);
		contentPane.add(txt_pass);
		txt_pass.setColumns(10);

		JButton btn_accept = new JButton("Accept");
		btn_accept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Conexion con = new Conexion();
				con.connectDataBase();

				try {
					PreparedStatement preparedStatement = con.connect
							.prepareStatement("insert into  players (User,Password) values ( ?, ?)");
					preparedStatement.setString(1, txt_user.getText());
					preparedStatement.setString(2, txt_pass.getText());
					preparedStatement.executeUpdate();
					Login l1 = new Login();
					dispose();
					l1.setDefaultCloseOperation(HIDE_ON_CLOSE);
					l1.setVisible(true);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btn_accept.setBounds(162, 175, 89, 23);
		contentPane.add(btn_accept);
	}
}
