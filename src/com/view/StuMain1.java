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

public class StuMain1 {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuMain1 window = new StuMain1();
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
	public StuMain1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u4E3B\u754C\u9762");
		frame.getContentPane().setBackground(new Color(255, 160, 122));
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 262, Short.MAX_VALUE)
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
		menu.add(exitInfo);
		
		JMenuItem search = new JMenuItem("\u67E5\u8BE2");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StuSearchSnum1 window = new StuSearchSnum1();
				window.frame.setVisible(true);
			}
		});
		menu.add(search);
		
		JMenu menu_1 = new JMenu("\u5B66\u751F\u7BA1\u7406");
		menuBar.add(menu_1);
		
		JMenuItem itemadd = new JMenuItem("\u589E\u52A0");
		itemadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStuInfo1 window = new AddStuInfo1();
				window.frame.setVisible(true);
			}
		});
		menu_1.add(itemadd);
		
		JMenuItem menuItem_2 = new JMenuItem("\u4FEE\u6539");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menu_1.add(menuItem_2);
		
		JMenuItem clearInfo = new JMenuItem("\u5220\u9664");
		clearInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStuInfo1 window = new AddStuInfo1();
				window.frame.setVisible(true);
			}
		});
		menu_1.add(clearInfo);
		
		JMenuItem menuItem = new JMenuItem("\u67E5\u627E");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StuSearchSnum1 window = new StuSearchSnum1();
				window.frame.setVisible(true);
				
			}
		});
		menu_1.add(menuItem);
	}

	public void setVisible(boolean b) {
		// TODO 自动生成的方法存根
		
	}
}
