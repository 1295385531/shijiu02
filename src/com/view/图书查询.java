package com.view;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.event.*;
import java.net.*;
public class ͼ���ѯ extends JFrame {
	JLabel jLabel1 = new JLabel();	
	JButton jBExit = new JButton();
	JScrollPane jScrollPane1;	
	JTable jTabStuInfo;
	String tno;
	String[] ���� = { "ͼ����", "����", "�۸�", "����", "����","������"};
	String[][] ��ֵ;
	//String[] ��ֵ;//��ά�������
	String sColValue;	
	String sColName;
	String sFromValue;	
	String sToValue;
	public ͼ���ѯ(String colname, String colvalue) {
		this.sColValue = colvalue;		
		this.sColName = colname;
		this.setTitle("ͼ����Ϣ��ѯ���");
		// ��������λ�ã�ʹ�Ի������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int) (screenSize.width - 400) / 2,(int) (screenSize.height - 300) / 2 + 45);
		StuBean rStu = new StuBean();
		try {
			��ֵ = rStu.bookSearch1(sColName, sColValue,sFromValue);
			if (��ֵ == null) {
				JOptionPane.showMessageDialog(null, "û�з��������ļ�¼");
				this.dispose();
				//this.setVisible(true);
			} else {
				jTabStuInfo = new JTable(��ֵ, ����);//����������
				jScrollPane1 = new JScrollPane(jTabStuInfo);
				this.getContentPane().add(jScrollPane1, BorderLayout.CENTER);
				this.pack();
				this.setVisible(true);
			}
		} catch (Exception e) {e.printStackTrace();}
	}
	public ͼ���ѯ(String colname, String fromvalue, String tovalue) {
		this.sColName = colname;
		this.sFromValue = fromvalue;		
		this.sToValue = tovalue;
		this.setTitle("ͼ����Ϣ��ѯ���");
		// ��������λ�ã�ʹ�Ի������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int) (screenSize.width - 400) / 2,(int) (screenSize.height - 300) / 2 + 45);
		StuBean rStu = new StuBean();
		try {
			��ֵ = rStu.bookSearch1(sColName, sFromValue, sToValue);
			if (��ֵ == null) {
				//this.setVisible(true);
				//this.setBounds(100, 100, 500, 500);
				this.dispose();
				JOptionPane.showMessageDialog(null, "û�з��������ļ�¼");
			} else {
				jTabStuInfo = new JTable(��ֵ, ����);
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
