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

public class ͼ���б���ʾ��ɾ�� extends JFrame{
	 
	private Connection con;//���ݿ�����
	private PreparedStatement pstmt;
	private JTable table;//���
	private DefaultTableModel model;//�������ģ��
	private JTextField delete_text;//�����
	private JButton delete_button;//��ť
	private ResultSet set=null;
	Object frame;
	//�����ʼ��
	public ͼ���б���ʾ��ɾ��() {
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
		JLabel jl=new JLabel("�ڼ���:");
		jl.setBounds(120, 220,50,30);
		getContentPane().add(jl);
		delete_text=new JTextField();
		delete_text.setBounds(200, 220, 50, 30);
		getContentPane().add(delete_text);
		delete_button=new JButton("ɾ��");
		delete_button.setBackground(new Color(245, 245, 245));
		delete_button.setBounds(280, 220, 70, 30);
		getContentPane().add(delete_button);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.close();
				����Ա����ϵͳ window = new ����Ա����ϵͳ();
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
    	String sql="select * from book";
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
    	delete_button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					//��ȡҪɾ��������
					int row=Integer.parseInt(delete_text.getText());
					//��ȡҪɾ�����е�ѧ��id��
				//	String stu_id=(String)model.getValueAt(row-1, 0);
					String bnum=(String)model.getValueAt(row-1, 0);
					//�����ݿ�ɾ������
				//	String sql="delete from stu_info where stu_Id=?";
					String sql="delete from book where bnum=?";
					pstmt=con.prepareStatement(sql);
					//pstmt.setString(1,stu_id);
					pstmt.setString(1,bnum);
					if(pstmt.executeUpdate()==1){
						System.out.println("ɾ���ɹ�");
						//����ɾ������
						model.removeRow(row-1);}
					else
						System.out.println("ɾ��ʧ��");
				}catch(Exception a){
					System.out.println("ɾ�����ݳ���");
					a.printStackTrace();
				}
			}
		});
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ͼ���б���ʾ��ɾ��();
	}
 
}
