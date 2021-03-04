package com.view;
import java.awt.event.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import java.awt.Font;
import java.awt.Color;

public class 修改书籍{

	JFrame frame;
	private JTextField bname;
	private JTextField pirce;
	private JTextField cbs;
	private JTextField bnum;
	private JTextField kind;
	private JTextField author;
	StuBean getSnum = new StuBean();
	protected StuBean xg;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					修改书籍 window = new 修改书籍();
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
	public 修改书籍() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 160, 122));
		frame.setTitle("\u4E66\u7C4D\u5165\u5E93");
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label_1 = new JLabel("\u4EF7\u683C\uFF1A");
		
		JLabel label_2 = new JLabel("\u79CD\u7C7B\uFF1A");
		
		JLabel label_3 = new JLabel("\u4F5C\u8005\uFF1A");
		
		JLabel label_4 = new JLabel("\u51FA\u7248\u793E\uFF1A");
		
		bname = new JTextField();
		bname.setColumns(10);
		
		pirce = new JTextField();
		pirce.setColumns(10);
		
		cbs = new JTextField();
		cbs.setColumns(10);
		
		JLabel label_5 = new JLabel("\u4E66\u7C4D\u7F16\u53F7\uFF1A");
		
		JLabel label_1_1 = new JLabel("\u4E66\u540D\uFF1A");
		
		bnum = new JTextField();
		bnum.setColumns(10);
		
		kind = new JTextField();
		kind.setColumns(10);
		
		author = new JTextField();
		author.setColumns(10);
		
		JButton xiugai = new JButton("\u4FEE\u6539");
		xiugai.setBackground(new Color(245, 245, 245));
		xiugai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StuBean 修改 = new StuBean();
				String[] s = new String[6];
				//利用StuBean的stuModify方法执行修改操作
				修改.xg(bnum.getText(), bname.getText(),pirce.getText(), 
									kind.getText(), pirce.getText(), cbs.getText());
				s=xg.stuSearch(bnum.getText());
				//将窗口中的值修改为操作后的值
				bname.setText(s[0]);	
				pirce.setText(s[1]);
				kind.setText(s[2]);	
				author.setText(s[3]);
				cbs.setText(s[4]);   
			
			}
		});
		
		JButton clearInfo = new JButton("\u6E05\u7A7A");
		clearInfo.setBackground(new Color(245, 245, 245));
		clearInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				bnum.setText(null);
				bname.setText(null);
				
				kind.setText(null);
				author.setText(null);
				pirce.setText(null);
				cbs.setText(null);
			//	sNum.setText("" + getSnum.getStuId());
			}
		});
		
		JButton eixtInfo = new JButton("\u9000\u51FA");
		eixtInfo.setBackground(new Color(245, 245, 245));
		eixtInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.close();
				管理员操作系统 window = new 管理员操作系统();
				window.frame.setVisible(true);
			}

			private void close() {
				frame.dispose();
				
			}
		});
		bnum.setEditable(true);
		bname.setEditable(true);
		kind.setEditable(true);
		author.setEditable(true);
		pirce.setEditable(true);
		cbs.setEditable(true);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.WEST, bname, 152, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, label_1_1, 65, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, label_1_1, -27, SpringLayout.WEST, bname);
		springLayout.putConstraint(SpringLayout.SOUTH, author, -6, SpringLayout.NORTH, cbs);
		springLayout.putConstraint(SpringLayout.NORTH, label_3, 3, SpringLayout.NORTH, author);
		springLayout.putConstraint(SpringLayout.WEST, label_3, 0, SpringLayout.WEST, label_4);
		springLayout.putConstraint(SpringLayout.NORTH, kind, 13, SpringLayout.SOUTH, pirce);
		springLayout.putConstraint(SpringLayout.WEST, kind, 42, SpringLayout.EAST, label_2);
		springLayout.putConstraint(SpringLayout.EAST, kind, -182, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, label_2, 3, SpringLayout.NORTH, kind);
		springLayout.putConstraint(SpringLayout.WEST, label_2, 0, SpringLayout.WEST, label_4);
		springLayout.putConstraint(SpringLayout.SOUTH, bname, -249, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, pirce, 6, SpringLayout.SOUTH, bname);
		springLayout.putConstraint(SpringLayout.WEST, pirce, 42, SpringLayout.EAST, label_1);
		springLayout.putConstraint(SpringLayout.EAST, pirce, -182, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, label_1_1, 30, SpringLayout.SOUTH, label_5);
		springLayout.putConstraint(SpringLayout.SOUTH, label_1_1, -6, SpringLayout.NORTH, label_1);
		springLayout.putConstraint(SpringLayout.NORTH, label_1, 3, SpringLayout.NORTH, pirce);
		springLayout.putConstraint(SpringLayout.WEST, label_1, 0, SpringLayout.WEST, label_4);
		springLayout.putConstraint(SpringLayout.SOUTH, bnum, -18, SpringLayout.NORTH, bname);
		springLayout.putConstraint(SpringLayout.NORTH, label_5, 3, SpringLayout.NORTH, bnum);
		springLayout.putConstraint(SpringLayout.WEST, label_5, 0, SpringLayout.WEST, label_4);
		springLayout.putConstraint(SpringLayout.EAST, label_5, -27, SpringLayout.WEST, bnum);
		springLayout.putConstraint(SpringLayout.EAST, bname, -182, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, bnum, 152, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, bnum, -182, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, author, 0, SpringLayout.WEST, cbs);
		springLayout.putConstraint(SpringLayout.EAST, author, 2, SpringLayout.EAST, kind);
		springLayout.putConstraint(SpringLayout.WEST, cbs, 152, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, label_4, -27, SpringLayout.WEST, cbs);
		springLayout.putConstraint(SpringLayout.NORTH, cbs, 315, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, xiugai, 76, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, eixtInfo, 0, SpringLayout.NORTH, xiugai);
		springLayout.putConstraint(SpringLayout.WEST, eixtInfo, 44, SpringLayout.EAST, clearInfo);
		springLayout.putConstraint(SpringLayout.NORTH, clearInfo, 0, SpringLayout.NORTH, xiugai);
		springLayout.putConstraint(SpringLayout.WEST, clearInfo, 54, SpringLayout.EAST, xiugai);
		springLayout.putConstraint(SpringLayout.SOUTH, xiugai, -34, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, cbs, -57, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, label_4, 3, SpringLayout.NORTH, cbs);
		frame.getContentPane().setLayout(springLayout);
		frame.getContentPane().add(label_3);
		frame.getContentPane().add(label_4);
		frame.getContentPane().add(cbs);
		frame.getContentPane().add(author);
		frame.getContentPane().add(label_2);
		frame.getContentPane().add(label_1_1);
		frame.getContentPane().add(label_5);
		frame.getContentPane().add(label_1);
		frame.getContentPane().add(bnum);
		frame.getContentPane().add(pirce);
		frame.getContentPane().add(kind);
		frame.getContentPane().add(xiugai);
		frame.getContentPane().add(clearInfo);
		frame.getContentPane().add(eixtInfo);
		frame.getContentPane().add(bname);
		
		JLabel label = new JLabel("\u56FE\u4E66\u5165\u5E93");
		label.setFont(new Font("黑体", Font.PLAIN, 30));
		springLayout.putConstraint(SpringLayout.NORTH, label, 53, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, label, 170, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(label);
	}
}
