package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.GridBagLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class 用户类型选择界面 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					用户类型选择界面 frame = new 用户类型选择界面();
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
	public 用户类型选择界面() {
		setBackground(new Color(112, 128, 144));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel yhlxxz = new JLabel("\u7528\u6237\u7C7B\u578B\u9009\u62E9");
		yhlxxz.setForeground(new Color(0, 0, 0));
		yhlxxz.setFont(new Font("黑体", Font.PLAIN, 36));
		
		JButton adminyh = new JButton("\u7BA1\u7406\u5458\u7528\u6237");
		adminyh.setBackground(new Color(245, 245, 245));
		adminyh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				this.close1();
				login frame = new login();
				frame.setVisible(true);
			}

			private void close1() {
				setVisible(false);
				
			}
		});
		
		JButton ptyh = new JButton("\u666E\u901A\u4EBA\u7528\u6237");
		ptyh.setBackground(new Color(245, 245, 245));
		ptyh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.close();
				普通用户登入界面 frame = new 普通用户登入界面();
				frame.setVisible(true);
			}

			private void close() {
				setVisible(false);
				
			}
		});
		
		JButton exet0 = new JButton("\u9000\u51FA");
		exet0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exet0.setBackground(new Color(245, 245, 245));
		
		JButton btnNewButton = new JButton("\u5F53\u524D\u65F6\u95F4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.close();
				当前时间 window = new 当前时间();
				((Window) window.frame).setVisible(true);
			}

			private void close() {
				setVisible(false);
				
			}
		});
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(245, 245, 245));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(70)
					.addComponent(adminyh)
					.addPreferredGap(ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
					.addComponent(ptyh)
					.addGap(70))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(131, Short.MAX_VALUE)
					.addComponent(yhlxxz)
					.addGap(125))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(208, Short.MAX_VALUE)
					.addComponent(exet0)
					.addGap(201))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton)
					.addContainerGap(359, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(46)
					.addComponent(yhlxxz, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(213)
							.addComponent(exet0))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(67)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(adminyh, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
								.addComponent(ptyh, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
					.addComponent(btnNewButton))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
