package com.view;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.event.*;
import java.net.*;
public class 图书查询 extends JFrame {
	JLabel jLabel1 = new JLabel();	
	JButton jBExit = new JButton();
	JScrollPane jScrollPane1;	
	JTable jTabStuInfo;
	String tno;
	String[] 列名 = { "图书编号", "书名", "价格", "种类", "作者","出版社"};
	String[][] 列值;
	//String[] 列值;//二维数组变量
	String sColValue;	
	String sColName;
	String sFromValue;	
	String sToValue;
	public 图书查询(String colname, String colvalue) {
		this.sColValue = colvalue;		
		this.sColName = colname;
		this.setTitle("图书信息查询结果");
		// 设置运行位置，使对话框居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int) (screenSize.width - 400) / 2,(int) (screenSize.height - 300) / 2 + 45);
		StuBean rStu = new StuBean();
		try {
			列值 = rStu.bookSearch1(sColName, sColValue,sFromValue);
			if (列值 == null) {
				JOptionPane.showMessageDialog(null, "没有符合条件的记录");
				this.dispose();
				//this.setVisible(true);
			} else {
				jTabStuInfo = new JTable(列值, 列名);//创建表格对象
				jScrollPane1 = new JScrollPane(jTabStuInfo);
				this.getContentPane().add(jScrollPane1, BorderLayout.CENTER);
				this.pack();
				this.setVisible(true);
			}
		} catch (Exception e) {e.printStackTrace();}
	}
	public 图书查询(String colname, String fromvalue, String tovalue) {
		this.sColName = colname;
		this.sFromValue = fromvalue;		
		this.sToValue = tovalue;
		this.setTitle("图书信息查询结果");
		// 设置运行位置，使对话框居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int) (screenSize.width - 400) / 2,(int) (screenSize.height - 300) / 2 + 45);
		StuBean rStu = new StuBean();
		try {
			列值 = rStu.bookSearch1(sColName, sFromValue, sToValue);
			if (列值 == null) {
				//this.setVisible(true);
				//this.setBounds(100, 100, 500, 500);
				this.dispose();
				JOptionPane.showMessageDialog(null, "没有符合条件的记录");
			} else {
				jTabStuInfo = new JTable(列值, 列名);
				jScrollPane1 = new JScrollPane(jTabStuInfo);
				this.getContentPane().add(jScrollPane1, BorderLayout.CENTER);
				this.pack();
				this.setVisible(true);
			}
		} catch (Exception e) {e.printStackTrace();	}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
