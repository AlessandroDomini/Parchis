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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class Login extends JFrame {

	private JPanel contentPane;
	private  JTextField text_User;
	private JTextField text_Password;
	private JTextField txt_port;
	private JTextField txt_ipv4;
	private JComboBox combo_color;
	BufferedReader input;
	PrintStream output;
	Socket socket;

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
		lblNewLabel.setBounds(163, 0, 102, 47);
		contentPane.add(lblNewLabel);
		
		JLabel label_User = new JLabel("User");
		label_User.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_User.setHorizontalAlignment(SwingConstants.CENTER);
		label_User.setBounds(76, 56, 46, 14);
		contentPane.add(label_User);
		
		JLabel label_Password = new JLabel("Password");
		label_Password.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_Password.setHorizontalAlignment(SwingConstants.CENTER);
		label_Password.setBounds(62, 81, 65, 14);
		contentPane.add(label_Password);
		
		combo_color = new JComboBox();
		combo_color.setModel(new DefaultComboBoxModel(new String[] {"Red", "Blue", "Yellow", "Green"}));
		combo_color.setToolTipText("");
		combo_color.setBounds(163, 174, 102, 22);
		contentPane.add(combo_color);
		
		text_User = new JTextField();
		text_User.setBounds(141, 54, 157, 20);
		contentPane.add(text_User);
		text_User.setColumns(10);
		
		text_Password = new JTextField();
		text_Password.setBounds(141, 79, 157, 20);
		contentPane.add(text_Password);
		text_Password.setColumns(10);
		
		JLabel lab_port = new JLabel("Port");
		lab_port.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lab_port.setHorizontalAlignment(SwingConstants.CENTER);
		lab_port.setBounds(72, 116, 46, 14);
		contentPane.add(lab_port);
		
		JLabel lab_ip = new JLabel("IPV4");
		lab_ip.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lab_ip.setHorizontalAlignment(SwingConstants.CENTER);
		lab_ip.setBounds(76, 141, 46, 14);
		contentPane.add(lab_ip);
		
		txt_port = new JTextField();
		txt_port.setBounds(141, 110, 157, 20);
		contentPane.add(txt_port);
		txt_port.setColumns(10);
		
		txt_ipv4 = new JTextField();
		txt_ipv4.setBounds(141, 139, 157, 20);
		contentPane.add(txt_ipv4);
		txt_ipv4.setColumns(10);
		
		
		JButton btn_Cancel = new JButton("Cancel");
		btn_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				text_User.setText("");
				text_Password.setText("");
				txt_port.setText("");
				txt_ipv4.setText("");
				
			}
		});
		btn_Cancel.setBounds(283, 227, 89, 23);
		contentPane.add(btn_Cancel);
		
		JButton btn_Accept = new JButton("Accept");		
		btn_Accept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(contentPane, "Waiting to the other player...");

				Conexion con = new Conexion();
				String user=text_User.getText();
				String pass=text_Password.getText();
				con.connectDataBase();
				
				String SQL="select * from players where User='"+user+"' and Password='"+pass+"'";

				try {
					con.rs=con.statement.executeQuery(SQL);
					if (con.rs.next()){
						int portn = Integer.parseInt(txt_port.getText());
						socket = new Socket(txt_ipv4.getText(), portn );
						input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						output = new PrintStream(socket.getOutputStream());
						output.println(text_User.getText()+" with color "+(String) combo_color.getSelectedItem());
						String n1 =input.readLine();
						Game g1=new Game();
						dispose();
						g1.setDefaultCloseOperation(HIDE_ON_CLOSE);
						g1.setVisible(true);
						g1.usr_1.setText("Player "+n1+" is online");
						PreparedStatement preparedStatement = con.connect.prepareStatement("Update players set Color=? WHERE User='"+text_User.getText()+"'");
						 preparedStatement.setString(1, (String) combo_color.getSelectedItem());
					     preparedStatement.executeUpdate();

					}
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btn_Accept.setBounds(76, 227, 89, 23);
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
		btnNewButton.setBounds(322, 56, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Color");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(76, 177, 46, 14);
		contentPane.add(lblNewLabel_1);
		
	
	}
}
