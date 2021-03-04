package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window;
import javax.swing.LayoutStyle.ComponentPlacement;

public class 普通用户操作系统 {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					普通用户操作系统 window = new 普通用户操作系统();
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
	public 普通用户操作系统() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u666E\u901A\u7528\u6237\u64CD\u4F5C\u754C\u9762");
		frame.getContentPane().setBackground(new Color(255, 250, 240));
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("\u4E66\u7C4D\u8D44\u6E90");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.close();
				书籍资源查看 window = new 书籍资源查看();
				((Window) window.frame).setVisible(true);
			}

			private void close() {
				frame.dispose();
			}
		});
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 16));
		btnNewButton.setForeground(new Color(0, 0, 0));
		
		JButton btnNewButton_1 = new JButton("\u56FE\u4E66\u501F\u9605");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.close();
				书籍借阅 window = new 书籍借阅();
				window.frame.setVisible(true);
			}

			private void close() {
				frame.dispose();
				
			}
		});
		btnNewButton_1.setBackground(new Color(245, 245, 245));
		btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 16));
		
		JButton btnNewButton_2 = new JButton("\u5BC6\u7801\u4FEE\u6539");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.close();
				普通用户密码修改 frame = new 普通用户密码修改();
				frame.setVisible(true);
				
			}

			private void close() {
				frame.dispose();
				
			}
		});
		btnNewButton_2.setBackground(new Color(245, 245, 245));
		btnNewButton_2.setFont(new Font("黑体", Font.PLAIN, 16));
		
		JButton btnNewButton_3 = new JButton("\u501F\u9605\u4FE1\u606F");
		btnNewButton_3.setBackground(new Color(245, 245, 245));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.close();
				借阅信息显示 window = new 借阅信息显示();
				((Window) window.frame).setVisible(true);
			}

			private void close() {
				frame.dispose();
				
			}
		});
		btnNewButton_3.setFont(new Font("黑体", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_3)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(59)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
					.addGap(157))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(108)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
						.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
					.addGap(46)
					.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(101))
		);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u7CFB\u7EDF\u7BA1\u7406");
		menuBar.add(menu);
		
		JMenuItem exitInfo = new JMenuItem("\u9000\u51FA");
		exitInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenuItem menuItem_1 = new JMenuItem("\u8FD4\u56DE\u767B\u5165\u754C\u9762");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.close();
				用户类型选择界面 frame = new 用户类型选择界面();
				frame.setVisible(true);
			}

			private void close() {
				
				frame.dispose();
			
			}
		});
		menu.add(menuItem_1);
		menu.add(exitInfo);
		
		JMenu menu_1 = new JMenu("\u7528\u6237\u7BA1\u7406");
		menuBar.add(menu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4E66\u7C4D\u8D44\u6E90\u7BA1\u7406");
		menu_1.add(mntmNewMenuItem);
	}

	public void setVisible(boolean b) {
		// TODO 自动生成的方法存根
		
	}
}
