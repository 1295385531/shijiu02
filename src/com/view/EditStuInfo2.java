package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditStuInfo2 {

	JFrame frame;
	private JTextField sSex;
	private JTextField sHome;
	private JTextField sCollege;
	private JTextField sBirth;
	private JTextField sNum;
	private JTextField sName;
	private JTextField sEthnic;
	private JTextField sYear;
	private JTextField sMajor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditStuInfo2 window = new EditStuInfo2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public EditStuInfo2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 446, 305);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		sSex = new JTextField();
		sSex.setEditable(true);
		sSex.setColumns(10);
		
		JLabel label = new JLabel("\u5B66    \u53F7\uFF1A");
		
		JLabel label_1 = new JLabel("\u6027    \u522B\uFF1A");
		
		JLabel label_2 = new JLabel("\u51FA\u751F\u65E5\u671F\uFF1A");
		
		JLabel label_3 = new JLabel("\u5B66    \u9662\uFF1A");
		
		JLabel label_4 = new JLabel("\u7C4D    \u8D2F\uFF1A");
		
		sHome = new JTextField();
		sHome.setEditable(true);
		sHome.setColumns(10);
		
		sCollege = new JTextField();
		sCollege.setEditable(true);
		sCollege.setColumns(10);
		
		sBirth = new JTextField();
		sBirth.setEditable(true);
		sBirth.setColumns(10);
		
		sNum = new JTextField();
		sNum.setEditable(false);
		sNum.setColumns(10);
		
		sName = new JTextField();
		sName.setEditable(true);
		sName.setColumns(10);
		
		sEthnic = new JTextField();
		sEthnic.setEditable(true);
		sEthnic.setColumns(10);
		
		JLabel label_5 = new JLabel("\u59D3    \u540D\uFF1A");
		
		JLabel label_1_1 = new JLabel("\u6C11    \u65CF\uFF1A");
		
		JLabel label_2_1 = new JLabel("\u5165\u5B66\u65F6\u95F4\uFF1A");
		
		sYear = new JTextField();
		sYear.setEditable(true);
		sYear.setColumns(10);
		
		sMajor = new JTextField();
		sMajor.setEditable(true);
		sMajor.setColumns(10);
		
		JLabel label_3_1 = new JLabel("\u4E13    \u4E1A\uFF1A");

		JButton modifyInfo = new JButton("\u4FEE\u6539");
		modifyInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StuBean modifyStu = new StuBean();
				String[] s = new String[8];
				//利用StuBean的stuModify方法执行修改操作
				modifyStu.stuModify(sNum.getText(), sName.getText(),sSex.getText(), 
									sBirth.getText(), sHome.getText(), sEthnic.getText(), 
									sYear.getText(), sMajor.getText(),sCollege.getText());
				s=modifyStu.stuSearch(sNum.getText());
				//将窗口中的值修改为操作后的值
				sName.setText(s[0]);	
				sSex.setText(s[1]);
				sEthnic.setText(s[2]);	
				sHome.setText(s[3]);
				sYear.setText(s[4]);   
				sMajor.setText(s[5]);
				sCollege.setText(s[6]);	
				sBirth.setText(s[7]);
			}
		});
		
		JButton clearInfo = new JButton("\u6E05\u7A7A");
		clearInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sNum.setText("请查询学号");
				sName.setText("");		
				sSex.setText("");
				sEthnic.setText("");	
				sHome.setText("");
				sYear.setText("");		
				sMajor.setText("");
				sCollege.setText("");		
				sBirth.setText("");
				sName.setEditable(false);	
				sSex.setEditable(false);
				sEthnic.setEditable(false);	
				sBirth.setEditable(false);
				sYear.setEditable(false);		
				sMajor.setEditable(false);
				sCollege.setEditable(false);	
				sHome.setEditable(false);
				modifyInfo.setEnabled(false);
			}
		});
		
		JButton eixtInfo = new JButton("\u9000\u51FA");
		eixtInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton searchInfo = new JButton("\u5B66\u53F7\u67E5\u8BE2");
		searchInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StuInfoSearchSnum siss = new StuInfoSearchSnum(frame);
				siss.pack();
				siss.setVisible(true);
				String sNum_str = "";
				String[] s = new String[8];
				try {
					sNum_str = siss.getSnum();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "没有查找到该学号！");
				}
	//执行查询操作
				StuBean searchStu = new StuBean();
				s = searchStu.stuSearch(sNum_str);
				if (s == null) {
					JOptionPane.showMessageDialog(null, "记录不存在！");
					sNum.setText("请查询学号");
	//清空窗口
					sName.setText("");		
					sSex.setText("");
					sEthnic.setText("");	
					sHome.setText("");
					sYear.setText("");		
					sMajor.setText("");
					sCollege.setText("");		
					sBirth.setText("");
	//将窗口中的组件设置为不可操作
					sName.setEditable(false);	
					sSex.setEditable(false);
					sEthnic.setEditable(false);	
					sBirth.setEditable(false);
					sYear.setEditable(false);		
					sMajor.setEditable(false);
					sCollege.setEditable(false);	
					sHome.setEditable(false);
					modifyInfo.setEnabled(false);
					return;
				} else {
	//将窗口组件的值设置为查询到的结果
					sNum.setText(sNum_str);	sName.setText(s[0]);
					sSex.setText(s[1]);			
					sEthnic.setText(s[2]);
					sHome.setText(s[3]);		
					sYear.setText(s[4]);
					sMajor.setText(s[5]);		
					sCollege.setText(s[6]);
					sBirth.setText(s[7]);
	//将窗口的组件设置为可操作的状态
					sName.setEditable(true);		
					sSex.setEditable(true);
					sEthnic.setEditable(true);	
					sBirth.setEditable(true);
					sYear.setEditable(true);		
					sMajor.setEditable(true);
					sCollege.setEditable(true);	
					sHome.setEditable(true);
					modifyInfo.setEnabled(true);
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(sNum, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(sName, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(sSex, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(label_1_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(sEthnic, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(sBirth, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(label_2_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(sYear, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(sCollege, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(label_3_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(sMajor, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(sHome, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(searchInfo)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(modifyInfo, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(clearInfo, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(eixtInfo, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(43, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(sNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_5))
						.addComponent(sName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_1))
						.addComponent(sSex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_1_1))
						.addComponent(sEthnic, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_2))
						.addComponent(sBirth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_2_1))
						.addComponent(sYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(label_3))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(sCollege, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_3_1))
						.addComponent(sMajor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_4))
						.addComponent(sHome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(eixtInfo)
								.addComponent(clearInfo)
								.addComponent(modifyInfo)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(searchInfo)))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
		sNum.setEditable(false);
		sNum.setText("请查询学号");
		sName.setEditable(false);
		sSex.setEditable(false);
		sEthnic.setEditable(false);
		sBirth.setEditable(false);
		sYear.setEditable(false);
		sMajor.setEditable(false);
		sCollege.setEditable(false);
		sHome.setEditable(false);
		
		searchInfo.setEnabled(true);
		modifyInfo.setEnabled(false);
		clearInfo.setEnabled(true);
		eixtInfo.setEnabled(true);
	}

}
