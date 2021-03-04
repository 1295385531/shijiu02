package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class ������Ϣ��ʾ extends JFrame{
	 
	private Connection con;//���ݿ�����
	private PreparedStatement pstmt;
	private JTable table;//���
	private DefaultTableModel model;//�������ģ��
	private JTextField delete_text;//�����
	private ResultSet set=null;
	Object frame;
	//�����ʼ��
	public ������Ϣ��ʾ() {
		getContentPane().setBackground(new Color(255, 250, 240));
		setTitle("\u501F\u9605\u4FE1\u606F\u67E5\u8BE2");
		// TODO Auto-generated constructor stub
		this.setBounds(500, 400, 600, 400);
		getContentPane().setLayout(null);
		table=new JTable();
		model=new DefaultTableModel();
		table.setModel(model);
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(0, 0, 600, 277);
		getContentPane().add(jsp);
		delete_text=new JTextField();
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.close();
				��ͨ�û�����ϵͳ window = new ��ͨ�û�����ϵͳ();
				window.frame.setVisible(true);
			}

			private void close() {
				setVisible(false);
				
			}
		});
		btnNewButton.setBounds(254, 290, 81, 30);
		getContentPane().add(btnNewButton);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		try{
			
		initConnection();
		queryData();
		}catch(Exception e){
			e.printStackTrace();
		}
		addListenter();
	}
	//��ʼ�����ݿ�����
    public void initConnection()throws Exception{
    	//����
    	String drivename="com.mysql.cj.jdbc.Driver";
    	//��ַ��dateNameΪ���ݿ���
    	String dbURL="jdbc:mysql://localhost:3306/stu?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
    	//�û�����
    	String username="root";
    	String password="123456";
    	getClass().forName(drivename);
    	//��ȡ����
    	con=DriverManager.getConnection(dbURL,username,password);
    	if(con!=null){
    		System.out.println("success");
    		
    		}
    	else
    		System.out.println("fail");
    }
    //�ر����ݿ�����
    public void closeCon(){
    	try{
    	if(pstmt!=null)
    		pstmt.close();
    	if(con!=null)
    		con.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
   
    //��ѯ����
    public void queryData()throws Exception{
    	//String sql="select * from stu_info";
    	String sql="select * from borrow";
       //ִ�в�ѯ����ȡ���
    	pstmt=con.prepareStatement(sql);
    	set=pstmt.executeQuery();
    	
    	//��ȡ������������������Ϊ�������ı���
    	ResultSetMetaData rsmd=set.getMetaData();
    	//�������
    	int count=rsmd.getColumnCount();
    	//��������ӵ����ģ����Ϊ����
    	for(int i=1;i<=count;i++){
    		model.addColumn(rsmd.getColumnName(i));
    	}
    	//ÿ������һ������
    	String[] row=new String[count];
    	while(set.next()){
    		//����ѯ����ÿ�����ݸ���������
    		for(int i=0;i<count;i++)
    			row[i]=set.getString(i+1);
    		//����һ��
    		model.addRow(row);
    	}
    	//�ر�����
    	set.close();
    	
    }
    
    public void addListenter(){
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ������Ϣ��ʾ();
	}
 
}
