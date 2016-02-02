package org.fjzzy.library;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView {

	private JFrame frame;
	private JTextField txt_name;
	private JTextField txt_passwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
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
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 453, 322);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_title = new JLabel("\u6B22\u8FCE\u767B\u9646");
		lbl_title.setFont(new Font("宋体", Font.BOLD, 24));
		lbl_title.setBounds(167, 48, 105, 48);
		frame.getContentPane().add(lbl_title);
		
		JLabel lbl_name = new JLabel("\u7528\u6237\u53F7:");
		lbl_name.setBounds(114, 118, 54, 15);
		frame.getContentPane().add(lbl_name);
		
		JLabel lbl_passwd = new JLabel("\u5BC6\u3000\u7801:");
		lbl_passwd.setBounds(114, 164, 54, 15);
		frame.getContentPane().add(lbl_passwd);
		
		txt_name = new JTextField();
		txt_name.setBounds(177, 115, 105, 21);
		frame.getContentPane().add(txt_name);
		txt_name.setColumns(10);
		
		txt_passwd = new JTextField();
		txt_passwd.setBounds(178, 161, 105, 18);
		frame.getContentPane().add(txt_passwd);
		txt_passwd.setColumns(10);
		
		JButton btn_login = new JButton("\u767B\u5F55");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				String sql = "select * from master where Id =? and Password =?";
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=master", "sa", "87373773");
					ps = conn.prepareStatement(sql);
					ps.setString(1, txt_name.getText());
					ps.setString(2, txt_passwd.getText());
					rs = ps.executeQuery();
					if(rs.next()){
						MainForm form = new MainForm();

					}else{
						JOptionPane.showMessageDialog(frame, "登录失败");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_login.setBounds(114, 209, 62, 23);
		frame.getContentPane().add(btn_login);
		
		JButton btn_cancel = new JButton("\u53D6\u6D88");
		btn_cancel.setBounds(220, 209, 62, 23);
		frame.getContentPane().add(btn_cancel);
	}
}
