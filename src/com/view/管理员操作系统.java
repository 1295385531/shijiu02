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
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window;
import javax.swing.LayoutStyle.ComponentPlacement;

public class 管理员操作系统 {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					管理员操作系统 window = new 管理员操作系统();
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
	public 管理员操作系统() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u7BA1\u7406\u5458\u64CD\u4F5C\u754C\u9762");
		frame.getContentPane().setBackground(new Color(255, 160, 122));
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button_addbook = new JButton("\u4E66\u7C4D\u5165\u5E93");
		button_addbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.close();
				AddStuInfo1 window = new AddStuInfo1();
				window.frame.setVisible(true);
				
			}

			private void close() {
				frame.dispose();
				
			}
		});
		button_addbook.setBackground(new Color(245, 245, 245));
		button_addbook.setFont(new Font("黑体", Font.PLAIN, 16));
		
		JButton btnNewButton = new JButton("\u4E66\u7C4D\u7BA1\u7406");
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.close();
				图书列表显示和删除 window = new 图书列表显示和删除();
				((Window) window.frame).setVisible(true);
			}

			private void close() {
				frame.dispose();
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u4E66\u7C4D\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.close();
				修改书籍 window = new 修改书籍();
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
				管理员密码修改 frame = new 管理员密码修改();
			frame.setVisible(true);
			}

			private void close() {
				frame.dispose();
				
			}
		});
		btnNewButton_2.setFont(new Font("黑体", Font.PLAIN, 16));
		btnNewButton_2.setBackground(new Color(245, 245, 245));
		
		JButton btnNewButton_3 = new JButton("\u501F\u9605\u67E5\u8BE2");
		btnNewButton_3.setBackground(new Color(245, 245, 245));
		btnNewButton_3.setFont(new Font("黑体", Font.PLAIN, 16));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.close();
				借阅记录 window = new 借阅记录();
				((Window) window.frame).setVisible(true);
			}

			private void close() {
				frame.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(70)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(button_addbook, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
					.addGap(88)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
					.addContainerGap(110, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_addbook, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(122, Short.MAX_VALUE))
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
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u8FD4\u56DE\u767B\u5165\u754C\u9762");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.close();
				用户类型选择界面 frame = new 用户类型选择界面();
				frame.setVisible(true);
			}

			private void close() {
				
				frame.dispose();
			}
		});
		menu.add(mntmNewMenuItem);
		menu.add(exitInfo);
		
		JMenu menu_1 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		menuBar.add(menu_1);
		
		JMenuItem itemadd = new JMenuItem("\u589E\u52A0");
		itemadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.close();
				AddStuInfo1 window = new AddStuInfo1();
				window.frame.setVisible(true);
				
			}

			private void close() {
				frame.dispose();
				
				
			}
			
		});
		menu_1.add(itemadd);
		
		JMenuItem menuItem_2 = new JMenuItem("\u4FEE\u6539");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.close();
				修改书籍 window = new 修改书籍();
				window.frame.setVisible(true);
			}

			private void close() {
				frame.dispose();
				
			
			}
		});
		menu_1.add(menuItem_2);
		
		JMenuItem clearInfo = new JMenuItem("\u5220\u9664");
		clearInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.close();
				图书列表显示和删除 window = new 图书列表显示和删除();
				((Window) window.frame).setVisible(true);
			}

			private void close() {
				frame.dispose();
				
			
			}
		});
		menu_1.add(clearInfo);
		
		JMenuItem menuItem = new JMenuItem("\u67E5\u627E");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.close();
				图书列表显示和删除 window = new 图书列表显示和删除();
				((Window) window.frame).setVisible(true);
			}

			private void close() {
				frame.dispose();
				
			}
				
			
		});
		menu_1.add(menuItem);
	}

	public void setVisible(boolean b) {
		// TODO 自动生成的方法存根
		
	}
}

