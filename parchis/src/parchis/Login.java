package parchis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


public class Login extends JFrame {

	private JPanel contentPane;
	private  JTextField text_User;
	private JTextField text_Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(163, 24, 102, 47);
		contentPane.add(lblNewLabel);
		
		JLabel label_User = new JLabel("User");
		label_User.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_User.setHorizontalAlignment(SwingConstants.CENTER);
		label_User.setBounds(85, 97, 46, 14);
		contentPane.add(label_User);
		
		JLabel label_Password = new JLabel("Password");
		label_Password.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_Password.setHorizontalAlignment(SwingConstants.CENTER);
		label_Password.setBounds(72, 134, 65, 14);
		contentPane.add(label_Password);
		
		JButton btn_Cancel = new JButton("Cancel");
		btn_Cancel.setBounds(241, 197, 89, 23);
		contentPane.add(btn_Cancel);
		
		text_User = new JTextField();
		text_User.setBounds(147, 95, 151, 20);
		contentPane.add(text_User);
		text_User.setColumns(10);
		
		text_Password = new JTextField();
		text_Password.setBounds(147, 132, 151, 20);
		contentPane.add(text_Password);
		text_Password.setColumns(10);
		
		JButton btn_Accept = new JButton("Accept");		
		btn_Accept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Conexion con = new Conexion();
				String user=text_User.getText();
				String pass=text_Password.getText();
				con.connectDataBase();
				
				String SQL="select * from players where User='"+user+"' and Password='"+pass+"'";
				try {
					con.rs=con.statement.executeQuery(SQL);
					if (con.rs.next()){
						Game g1=new Game();
						dispose();
						g1.setDefaultCloseOperation(HIDE_ON_CLOSE);
						g1.setVisible(true);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btn_Accept.setBounds(111, 197, 89, 23);
		contentPane.add(btn_Accept);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Register r1=new Register();
				dispose();
				r1.setDefaultCloseOperation(HIDE_ON_CLOSE);
				r1.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(321, 109, 89, 23);
		contentPane.add(btnNewButton);
	}
}
