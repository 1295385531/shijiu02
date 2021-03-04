package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class 普通用户注册界面 {

	JFrame frame;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					普通用户注册界面 window = new 普通用户注册界面();
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
	public 普通用户注册界面() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 250, 240));
		frame.setTitle("\u56FE\u666E\u901A\u7528\u6237\u6CE8\u518C\u9875\u9762");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("\u6CE8\u518C\u7528\u6237\u540D\uFF1A");
		
		JLabel label_1 = new JLabel("\u6CE8\u518C\u5BC6\u7801\uFF1A");
		
		username = new JTextField();
		username.setColumns(10);
		
		password = new JTextField();
		password.setColumns(10);
		
		JButton button = new JButton("\u786E\u8BA4\u6CE8\u518C");
		button.setBackground(new Color(240, 248, 255));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				username.setEnabled(false);
				password.setEnabled(false);
			

				StuBean addUSERADM = new StuBean();
				addUSERADM.userzhuce(username.getText(), password.getText());
				
			}
		});
		
		JButton zucetuic = new JButton("\u9000\u51FA");
		zucetuic.setBackground(new Color(240, 248, 255));
		zucetuic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			System.exit(0);
			}
		});
		
		JButton zcback = new JButton("\u8FD4\u56DE");
		zcback.setBackground(new Color(240, 248, 255));
		zcback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				普通用户登入界面 frame = new 普通用户登入界面();
				frame.setVisible(true);
				
			}

			private void closeThis() {
				frame.dispose();
				//setVisible(true);
			}
		});
		
		JButton btnNewButton = new JButton("\u6E05\u7A7A");
		btnNewButton.setBackground(new Color(240, 128, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.clear();
			}

			private void clear() {
			     username.setText("");
				password.setText("");
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addComponent(button)
							.addGap(41)
							.addComponent(zucetuic))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1)
								.addComponent(label))
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(password)
								.addComponent(username, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
							.addComponent(zcback, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(55))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label))
							.addGap(46)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(64)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(zucetuic)
						.addComponent(zcback)))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
