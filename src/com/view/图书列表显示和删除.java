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

public class 图书列表显示和删除 extends JFrame{
	 
	private Connection con;//数据库连接
	private PreparedStatement pstmt;
	private JTable table;//表格
	private DefaultTableModel model;//表格数据模型
	private JTextField delete_text;//输入框
	private JButton delete_button;//按钮
	private ResultSet set=null;
	Object frame;
	//界面初始化
	public 图书列表显示和删除() {
		getContentPane().setBackground(new Color(245, 245, 245));
		setTitle("\u56FE\u4E66\u4FE1\u606F\u67E5\u770B\u4EE5\u53CA\u5220\u9664");
		// TODO Auto-generated constructor stub
		this.setBounds(500, 400, 600, 400);
		getContentPane().setLayout(null);
		table=new JTable();
		model=new DefaultTableModel();
		table.setModel(model);
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(0, 0, 600, 200);
		getContentPane().add(jsp);
		delete_text=new JTextField();
		JLabel jl=new JLabel("第几行:");
		jl.setBounds(120, 220,50,30);
		getContentPane().add(jl);
		delete_text=new JTextField();
		delete_text.setBounds(200, 220, 50, 30);
		getContentPane().add(delete_text);
		delete_button=new JButton("删除");
		delete_button.setBackground(new Color(245, 245, 245));
		delete_button.setBounds(280, 220, 70, 30);
		getContentPane().add(delete_button);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.close();
				管理员操作系统 window = new 管理员操作系统();
				window.frame.setVisible(true);
			}

			private void close() {
				setVisible(false);
				
			}
		});
		btnNewButton.setBounds(364, 219, 81, 30);
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
    	String sql="select * from book";
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
    	delete_button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					//获取要删除的行数
					int row=Integer.parseInt(delete_text.getText());
					//获取要删除的行的学生id号
				//	String stu_id=(String)model.getValueAt(row-1, 0);
					String bnum=(String)model.getValueAt(row-1, 0);
					//从数据库删除数据
				//	String sql="delete from stu_info where stu_Id=?";
					String sql="delete from book where bnum=?";
					pstmt=con.prepareStatement(sql);
					//pstmt.setString(1,stu_id);
					pstmt.setString(1,bnum);
					if(pstmt.executeUpdate()==1){
						System.out.println("删除成功");
						//本地删除数据
						model.removeRow(row-1);}
					else
						System.out.println("删除失败");
				}catch(Exception a){
					System.out.println("删除数据出错");
					a.printStackTrace();
				}
			}
		});
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new 图书列表显示和删除();
	}
 
}
