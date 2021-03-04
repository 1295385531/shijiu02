package com.view;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
 
 
 
public class bb {
 
 
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			System.out.println("Success loading MySQL Drive");
		}catch(Exception e){
			System.out.println("Error loading MySQL Driver!");
			e.printStackTrace();
		}
		try{
			Connection connect=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/stu?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8", "root",
					"123456");
			/*
			int num=200;
					PreparedStatement Statement=connect.prepareStatement("INSERT INTO user VALUES(?,?)");
					for(int i=0;i<num;i++){	
						Statement.setString(1,"chong"+i);
						Statement.setString(2,"b"+i);
						Statement.executeUpdate();
					}*/
			
		  }catch(SQLException e){}
	}
}

