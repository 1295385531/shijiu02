package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.util.jdbc1;

import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField txtuser;
	private JTextField txtpassword;
String sql;
ResultSet rs =null;
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
		setTitle("\u56FE\u4E66\u8D44\u6E90\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 160, 122));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton button = new JButton("\u767B\u5F55");
		button.setForeground(new Color(0, 0, 0));
		button.setBackground(new Color(240, 248, 255));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jdbc1 DB=  new jdbc1();
				String sql = "select * from admin where username ='" + txtuser.getText().toString() +"' and password = '" + txtpassword.getText().toString()+"'";
			try {DB.OpenConn();
			rs=DB.executeQuery(sql);
			if (rs.next()) {
				this.close();
				管理员操作系统 window = new 管理员操作系统();
				window.frame.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "用户或密码错误");
			}	
			}catch(Exception e1) {
			}finally {
				DB.closeStmt();
				DB.closeConn();
			}
			}

			private void close() {
				setVisible(false);
				
			}
			
		});
		
		JLabel label = new JLabel("\u56FE\u4E66\u8D44\u6E90\u7BA1\u7406\u7CFB\u7EDF");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setFont(new Font("黑体", Font.PLAIN, 45));
		
		JButton button_1 = new JButton("\u6CE8\u518C");
		button_1.setBackground(new Color(240, 248, 255));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.close();
				zhuce window = new zhuce();
				window.frame.setVisible(true);
			}

			private void close() {
				setVisible(false);
				
			}
		});
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		label_1.setFont(new Font("黑体", Font.PLAIN, 20));
		
		JLabel label_2 = new JLabel("\u5BC6\u7801 \uFF1A");
		label_2.setFont(new Font("黑体", Font.PLAIN, 20));
		
		txtuser = new JTextField();
		txtuser.setColumns(10);
		
		txtpassword = new JTextField();
		txtpassword.setColumns(10);
		
		JButton clear1 = new JButton("\u6E05\u7A7A");
		clear1.setBackground(new Color(240, 248, 255));
		clear1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				this.clear();
			}

			private void clear() {
				  txtuser.setText("");
					txtpassword.setText("");

				
			}
		});
		
		JButton exet1 = new JButton("\u9000\u51FA");
		exet1.setBackground(new Color(240, 248, 255));
		exet1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
				this.close();
				用户类型选择界面 frame = new 用户类型选择界面();
				frame.setVisible(true);
			}

			private void close() {
				setVisible(false);
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(37)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_1)
								.addComponent(label_2)
								.addComponent(button))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(button_1)
									.addGap(18)
									.addComponent(clear1)
									.addGap(23)
									.addComponent(exet1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtuser, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
										.addComponent(txtpassword, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))))))
					.addGap(92))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addComponent(label)
					.addGap(57)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(txtuser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(txtpassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(exet1)
						.addComponent(button_1)
						.addComponent(clear1))
					.addGap(88))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
