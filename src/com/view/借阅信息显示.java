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

public class 借阅信息显示 extends JFrame{
	 
	private Connection con;//数据库连接
	private PreparedStatement pstmt;
	private JTable table;//表格
	private DefaultTableModel model;//表格数据模型
	private JTextField delete_text;//输入框
	private ResultSet set=null;
	Object frame;
	//界面初始化
	public 借阅信息显示() {
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
				普通用户操作系统 window = new 普通用户操作系统();
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
	//初始化数据库连接
    public void initConnection()throws Exception{
    	//驱动
    	String drivename="com.mysql.cj.jdbc.Driver";
    	//地址，dateName为数据库名
    	String dbURL="jdbc:mysql://localhost:3306/stu?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
    	//用户密码
    	String username="root";
    	String password="123456";
    	getClass().forName(drivename);
    	//获取连接
    	con=DriverManager.getConnection(dbURL,username,password);
    	if(con!=null){
    		System.out.println("success");
    		
    		}
    	else
    		System.out.println("fail");
    }
    //关闭数据库连接
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
   
    //查询数据
    public void queryData()throws Exception{
    	//String sql="select * from stu_info";
    	String sql="select * from borrow";
       //执行查询语句获取结果
    	pstmt=con.prepareStatement(sql);
    	set=pstmt.executeQuery();
    	
    	//获取表中列数及列名，作为表格组件的标题
    	ResultSetMetaData rsmd=set.getMetaData();
    	//获得列数
    	int count=rsmd.getColumnCount();
    	//将列名添加到表格模型作为标题
    	for(int i=1;i<=count;i++){
    		model.addColumn(rsmd.getColumnName(i));
    	}
    	//每行设置一个数组
    	String[] row=new String[count];
    	while(set.next()){
    		//将查询到的每行数据赋入数组内
    		for(int i=0;i<count;i++)
    			row[i]=set.getString(i+1);
    		//增加一行
    		model.addRow(row);
    	}
    	//关闭连接
    	set.close();
    	
    }
    
    public void addListenter(){
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new 借阅信息显示();
	}
 
}
