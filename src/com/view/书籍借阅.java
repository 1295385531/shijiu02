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

public class 书籍借阅{

	JFrame frame;
	private JTextField bname;
	private JTextField kssj;
	private JTextField bnum;
	private JTextField jssj;
	private JTextField name;
	StuBean getSnum = new StuBean();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					书籍借阅 window = new 书籍借阅();
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
	public 书籍借阅() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 250, 240));
		frame.setTitle("\u56FE\u4E66\u501F\u9605");
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label_1 = new JLabel("\u501F\u9605\u65E5\u671F\uFF1A");
		
		JLabel label_2 = new JLabel("\u7ED3\u675F\u65E5\u671F\uFF1A");
		
		JLabel jyxm = new JLabel("\u59D3  \u540D\uFF1A");
		
		bname = new JTextField();
		bname.setColumns(10);
		
		kssj = new JTextField();
		kssj.setColumns(10);
		
		JLabel label_5 = new JLabel("\u4E66\u7C4D\u7F16\u53F7\uFF1A");
		
		JLabel label_1_1 = new JLabel("\u4E66  \u540D\uFF1A");
		
		bnum = new JTextField();
		bnum.setColumns(10);
		
		jssj = new JTextField();
		jssj.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		
		JButton addInfo = new JButton("\u589E\u52A0");
		addInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				bnum.setEnabled(false);
				bname.setEnabled(false);
				jssj.setEnabled(false);
				name.setEnabled(false);
				kssj.setEnabled(false);
				

				StuBean addStu = new StuBean();
				addStu.borrow(bnum.getText(), bname.getText(),kssj.getText(), 
					 jssj.getText(),name.getText());
			}
		});
		
		JButton clearInfo = new JButton("\u6E05\u7A7A");
		clearInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				bnum.setText(null);
				bname.setText(null);
				
				jssj.setText(null);
				name.setText(null);
				kssj.setText(null);
				
			//	sNum.setText("" + getSnum.getStuId());
			}
		});
		
		JButton eixtInfo = new JButton("\u9000\u51FA");
		eixtInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.close();
				普通用户操作系统 window = new 普通用户操作系统();
				window.frame.setVisible(true);
			}

			private void close() {
				frame.dispose();
				
			}
		});
		bnum.setEditable(true);
		bname.setEditable(true);
		jssj.setEditable(true);
		name.setEditable(true);
		kssj.setEditable(true);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.WEST, label_5, 0, SpringLayout.WEST, jyxm);
		springLayout.putConstraint(SpringLayout.NORTH, label_1_1, 3, SpringLayout.NORTH, bname);
		springLayout.putConstraint(SpringLayout.WEST, label_1_1, 14, SpringLayout.WEST, label_2);
		springLayout.putConstraint(SpringLayout.SOUTH, label_1_1, -12, SpringLayout.NORTH, label_1);
		springLayout.putConstraint(SpringLayout.EAST, label_1_1, 0, SpringLayout.EAST, addInfo);
		springLayout.putConstraint(SpringLayout.WEST, kssj, 152, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, jssj, 152, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, name, 152, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, label_1, -42, SpringLayout.WEST, kssj);
		springLayout.putConstraint(SpringLayout.EAST, label_5, -27, SpringLayout.WEST, bnum);
		springLayout.putConstraint(SpringLayout.EAST, label_2, -42, SpringLayout.WEST, jssj);
		springLayout.putConstraint(SpringLayout.EAST, jyxm, -42, SpringLayout.WEST, name);
		springLayout.putConstraint(SpringLayout.NORTH, name, 14, SpringLayout.SOUTH, jssj);
		springLayout.putConstraint(SpringLayout.EAST, name, -180, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, bname, 152, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, jyxm, 3, SpringLayout.NORTH, name);
		springLayout.putConstraint(SpringLayout.NORTH, jssj, 13, SpringLayout.SOUTH, kssj);
		springLayout.putConstraint(SpringLayout.EAST, jssj, -182, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, label_2, 3, SpringLayout.NORTH, jssj);
		springLayout.putConstraint(SpringLayout.SOUTH, bname, -249, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, kssj, 6, SpringLayout.SOUTH, bname);
		springLayout.putConstraint(SpringLayout.EAST, kssj, -182, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, label_1, 3, SpringLayout.NORTH, kssj);
		springLayout.putConstraint(SpringLayout.SOUTH, bnum, -18, SpringLayout.NORTH, bname);
		springLayout.putConstraint(SpringLayout.NORTH, label_5, 3, SpringLayout.NORTH, bnum);
		springLayout.putConstraint(SpringLayout.EAST, bname, -182, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, bnum, 152, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, bnum, -182, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, addInfo, 76, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, eixtInfo, 0, SpringLayout.NORTH, addInfo);
		springLayout.putConstraint(SpringLayout.WEST, eixtInfo, 44, SpringLayout.EAST, clearInfo);
		springLayout.putConstraint(SpringLayout.NORTH, clearInfo, 0, SpringLayout.NORTH, addInfo);
		springLayout.putConstraint(SpringLayout.WEST, clearInfo, 54, SpringLayout.EAST, addInfo);
		springLayout.putConstraint(SpringLayout.SOUTH, addInfo, -34, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().setLayout(springLayout);
		frame.getContentPane().add(jyxm);
		frame.getContentPane().add(name);
		frame.getContentPane().add(label_2);
		frame.getContentPane().add(label_1_1);
		frame.getContentPane().add(label_5);
		frame.getContentPane().add(label_1);
		frame.getContentPane().add(bnum);
		frame.getContentPane().add(kssj);
		frame.getContentPane().add(jssj);
		frame.getContentPane().add(addInfo);
		frame.getContentPane().add(clearInfo);
		frame.getContentPane().add(eixtInfo);
		frame.getContentPane().add(bname);
		
		JLabel label = new JLabel("\u56FE\u4E66\u501F\u9605");
		label.setFont(new Font("黑体", Font.PLAIN, 30));
		springLayout.putConstraint(SpringLayout.NORTH, label, 53, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, label, 170, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(label);
	}
}
