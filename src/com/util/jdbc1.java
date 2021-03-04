package com.util;
import java.sql.*;

public class jdbc1 {
	private Connection conn=null;
	Statement stmt;
	ResultSet rs;
	String sql;
	/**
	 * ���ݿ����Ӳ�������openConn()
	 */
	public void OpenConn() throws Exception{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/stu?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
			String username="root";
			String password="123456";
			conn=DriverManager.getConnection(url,username,password);
			
		}catch(Exception e){
			System.err.println("���ݿ����ӣ�"+e.getMessage()+"\n");
		}
	}
	public ResultSet executeQuery(String sql) {
		stmt=null;
		rs=null;
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
		}catch(SQLException e){
			System.err.println("��ѯ���ݣ�"+e.getMessage());
		}
		return rs;
	}
	public void execute(String sql) {
		stmt=null;
		rs=null;
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);
		}catch(SQLException e){
			System.err.println(e.getMessage());
		}
	}
	public void executeUpdate(String sql) {
		stmt=null;
		rs=null;
		try {
			stmt=conn.createStatement();
			stmt.executeUpdate(sql);
//			conn.commit();
		}catch(SQLException e){
			System.err.println("�������ݣ�"+e.getMessage());
		}
	}
	public void closeStmt() {
		try {
			stmt.close();
		}catch(SQLException e) {
			System.err.println("�ͷŶ���"+e.getMessage());
		}
	}
	public void closeConn() {
		try {
			conn.close();
		}catch(SQLException ex) {
			System.err.println("�ͷŶ���"+ex.getMessage());
		}
	}
	public static void main(String[] args) {
	
	}
}
