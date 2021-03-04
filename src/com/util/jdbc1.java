package com.util;
import java.sql.*;

public class jdbc1 {
	private Connection conn=null;
	Statement stmt;
	ResultSet rs;
	String sql;
	/**
	 * 数据库连接操作方法openConn()
	 */
	public void OpenConn() throws Exception{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/stu?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
			String username="root";
			String password="123456";
			conn=DriverManager.getConnection(url,username,password);
			
		}catch(Exception e){
			System.err.println("数据库连接："+e.getMessage()+"\n");
		}
	}
	public ResultSet executeQuery(String sql) {
		stmt=null;
		rs=null;
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
		}catch(SQLException e){
			System.err.println("查询数据："+e.getMessage());
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
			System.err.println("更新数据："+e.getMessage());
		}
	}
	public void closeStmt() {
		try {
			stmt.close();
		}catch(SQLException e) {
			System.err.println("释放对象："+e.getMessage());
		}
	}
	public void closeConn() {
		try {
			conn.close();
		}catch(SQLException ex) {
			System.err.println("释放对象："+ex.getMessage());
		}
	}
	public static void main(String[] args) {
	
	}
}
