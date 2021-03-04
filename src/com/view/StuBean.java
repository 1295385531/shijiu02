package com.view;

import java.util.*;
import java.sql.*;
import javax.swing.*;
import com.util.jdbc1;//引入自定义类
public class StuBean {
	String sql;	
	ResultSet rs = null;
	String sNum;
	String sName;
	String sSex;
	String sBirth;	
	String sHome;
	String sEthnic;	
	String sYear;
	String sMajor;
	String sCollege;	
	String colName; 
	String colValue;	//
	String colValue2; //
	String username;
	String password;
	int stuId;// 学生的新学号
	private String bnum;
	private String bname;
	private String pirce;
	private String kind;
	private String author;
	private String cbs;
	private String kssj;
	private String jssj;
	private String name;
	
	//添加学生信息的方法
	public void stuAdd(String name, String sex, String birth, String home,
				String ethnic, String year, String major, String college) {
			jdbc1 DB = new jdbc1();
	//传递参数
			this.sName = name;	
			this.sSex = sex;
			this.sBirth = birth;	
			this.sHome = home;
			this.sEthnic = ethnic;	
			this.sYear = year;
			this.sMajor = major;	
			this.sCollege = college;

			if (sName == null || sName.equals("")) {
				JOptionPane.showMessageDialog(null, "请输入学生姓名", "错误",JOptionPane.ERROR_MESSAGE);
//				return;
			} else {
	//将窗口中的数值存入sql语句
				sql = "insert into student(sname,ssex,sbirth,shome,sethnic,syear,smajor,scollege) values ('"
						+ sName+ "','"+ sSex+ "','"+ sBirth+ "','"+ sHome+ "','"
						+ sEthnic+ "','"+ sYear+ "','"+ sMajor+ "','"+ sCollege + "')";
				System.out.println(sql);
	//执行sql语句添加记录
				try {
					DB.OpenConn(); 	
					DB.execute(sql);
					JOptionPane.showMessageDialog(null, "成功添加一条新的纪录！");
				} catch (Exception e) {
					System.out.println(e);
					JOptionPane.showMessageDialog(null, "保存失败", "错误",JOptionPane.ERROR_MESSAGE);
				} finally {
					DB.closeStmt();	
					DB.closeConn();
				}
			}
		}

	//修改学生信息
	public void stuModify(String num, String name, String sex, String birth,
			String home, String ethnic, String year, String major,String college) {
				jdbc1 DB = new jdbc1();//连接数据库
		//传递参数
				this.sNum = num;	
				this.sName = name;
				this.sSex = sex;	
				this.sBirth = birth;
				this.sHome = home;	
				this.sEthnic = ethnic;
				this.sYear = year;	
				this.sMajor = major;
				this.sCollege = college;
				if (sName == null || sName.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入学生姓名", "错误",JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					sql = "update student set sname = '" + sName + "', ssex = '" + sSex
							+ "', sbirth = '" + sBirth + "', shome = '" + sHome
							+ "', sethnic = '" + sEthnic + "', syear = '" + sYear
							+ "', smajor = '" + sMajor + "', scollege = '" + sCollege
							+ "' where snum = " + Integer.parseInt(sNum) + "";
					try {
						DB.OpenConn();
						DB.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "成功修改一条新的纪录！");
					} catch (Exception e) {
						System.out.println(e);
						JOptionPane.showMessageDialog(null, "更新失败", "错误",JOptionPane.ERROR_MESSAGE);
					} finally {
						DB.closeStmt();
						DB.closeConn();
					}
				}
	}
	// 删除学生信息
	public void stuDel(String num) {
		jdbc1 DB = new jdbc1();
		this.sNum = num;
		sql = "delete from student where snum = " + Integer.parseInt(sNum) + "";
		try {
			DB.OpenConn();
			DB.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "成功删除一条新的纪录！");
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "删除失败", "错误",JOptionPane.ERROR_MESSAGE);
		} finally {
			DB.closeStmt();
			DB.closeConn();
		}
	}
	// 根据指定学号查询学生信息
	 public String[] stuSearch(String num) {
		 jdbc1 DB = new jdbc1();
		this.sNum = num;
		String[] s = new String[8];
		sql = "select * from student where snum = " + Integer.parseInt(sNum)+ "";
		try {DB.OpenConn();
			rs = DB.executeQuery(sql);
			if (rs.next()) {
				s[0] = rs.getString("sname");	
				s[1] = rs.getString("ssex");
				s[2] = rs.getString("sethnic");	
				s[3] = rs.getString("shome");
				s[4] = rs.getString("syear");	
				s[5] = rs.getString("smajor");
				s[6] = rs.getString("scollege");
				s[7] = rs.getString("sbirth");
			} else	s = null;
		} catch (Exception e) {
			
		} finally {	
			DB.closeStmt();	
			DB.closeConn();
		}
		return s;
	}
	
	//根据指定的学号范围查询学生信息
	public String[][] stuAllSearch1(String xh, String h1,String h2){
		this.colName = xh;
		this.colValue = h1;
		this.colValue2 = h2;
		jdbc1 DB = new jdbc1();
		String[][] sn = null;	
		int row = 0;
		int i = 0;
		sql = "select * from student where " + colName + " between " + colValue+ " and " + colValue2 + "";
		try {DB.OpenConn();
			rs = DB.executeQuery(sql);
			if (rs.last()) {
				row = rs.getRow();
			}
			if (row == 0) {	
				sn = null;
			} else {
				sn = new String[row][9];
				rs.first();	
				rs.previous();
				while (rs.next()) {
					sn[i][0] = rs.getString("snum");
					sn[i][1] = rs.getString("sname");
					sn[i][2] = rs.getString("ssex");
					sn[i][3] = rs.getString("sethnic");
					sn[i][4] = rs.getString("shome");
					sn[i][5] = rs.getString("syear");
					sn[i][6] = rs.getString("smajor");
					sn[i][7] = rs.getString("scollege");
					sn[i][8] = rs.getString("sbirth");
					i++;
				}
			}
		} catch (Exception e) {
			
		} finally {	
			DB.closeStmt();	
			DB.closeConn();
		}
		return sn;
	}

//////////////////////////////图书查询
	
	
	public String[][] bookSearch1(String xh, String h1,String h2){
		this.colName = xh;
		this.colValue = h1;
		this.colValue2 = h2;
		jdbc1 DB = new jdbc1();
		String[][] sn = null;	
		int row = 0;
		int i = 0;
		sql = "select * from book where " + colName + " between " + colValue+ " and " + colValue2 + "";
		//sql = "select * from book where " + colName + " between " + colValue+ " and " + colValue2 + "";
		try {DB.OpenConn();
			rs = DB.executeQuery(sql);
			if (rs.last()) {
				row = rs.getRow();
			}
			if (row == 0) {	
				sn = null;
			} else {
				sn = new String[row][9];
				rs.first();	
				rs.previous();
				while (rs.next()) {
					sn[i][0] = rs.getString("bnum");
					sn[i][1] = rs.getString("bname");
					sn[i][2] = rs.getString("pirce");
					sn[i][3] = rs.getString("kind");
					sn[i][4] = rs.getString("author");
					sn[i][5] = rs.getString("cbs");
					i++;
				}
			}
		} catch (Exception e) {
			
		} finally {	
			DB.closeStmt();	
			DB.closeConn();
		}
		return sn;
	}
	
	
	
	
	
	
	public int getStuId() {//获得新的学号
		jdbc1 DB = new jdbc1();
		sql = "select max(snum) from student";
		try {DB.OpenConn();
			rs = DB.executeQuery(sql);
			if (rs.next()) {
				stuId = rs.getInt(1) + 1;
			} else	
				stuId = 1;
		} catch (Exception e) {

		} finally {	
			DB.closeStmt();	
			DB.closeConn();	
		}
		return stuId;
	}
	//获得student表中的所有学号snum
	public String[] getAllId() {
		String[] s = null;
		int row = 0;
		int i = 0;
		jdbc1 DB = new jdbc1();
		sql = "select snum from student";
		try {DB.OpenConn();
			rs = DB.executeQuery(sql);
			if (rs.last()) {
				row = rs.getRow();
				}
			if (row == 0) {	
				s = null;
			} else {
				s = new String[row];
				rs.first();
				rs.previous();
				while (rs.next()) {	
					s[i] = rs.getString(1);	
					i++;
				}
			}
		} catch (Exception e) {	
			System.out.println(e);
		} finally {	
			DB.closeStmt();	
			DB.closeConn();	
		}
		return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void zhuce(String usename, String password) {
		
			jdbc1 DB = new jdbc1();
	//传递参数
			this.username = usename;	
			this.password = password;
		
			if (username == null || username.equals("")) {
				JOptionPane.showMessageDialog(null, "请输入用户名", "错误",JOptionPane.ERROR_MESSAGE);
//				return;
			} else {
	//将窗口中的数值存入sql语句
				sql = "insert into admin(username,password) values ('"
						+ username+ "','"+ password+ "')";
				System.out.println(sql);
	//执行sql语句添加记录
				try {
					DB.OpenConn(); 	
					DB.execute(sql);
					JOptionPane.showMessageDialog(null, "成功注册一个用户！");
				} catch (Exception e) {
					System.out.println(e);
					JOptionPane.showMessageDialog(null, "注册失败", "错误",JOptionPane.ERROR_MESSAGE);
				} finally {
					DB.closeStmt();	
					DB.closeConn();
				}
			}
			}
	//普通用户注册的方法
	public void userzhuce(String usename, String password) {
		
		jdbc1 DB = new jdbc1();
//传递参数
		this.username = usename;	
		this.password = password;
	
		if (username == null || username.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入用户名", "错误",JOptionPane.ERROR_MESSAGE);
//			return;
		} else {
//将窗口中的数值存入sql语句
			sql = "insert into useradmin(username,password) values ('"
					+ username+ "','"+ password+ "')";
			System.out.println(sql);
//执行sql语句添加记录
			try {
				DB.OpenConn(); 	
				DB.execute(sql);
				JOptionPane.showMessageDialog(null, "成功注册一个用户！");
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "注册失败", "错误",JOptionPane.ERROR_MESSAGE);
			} finally {
				DB.closeStmt();	
				DB.closeConn();
			}
		}
		}

	public void bookAdd(String bnum, String bname, String pirce, String kind, String author, String cbs) {
		jdbc1 DB = new jdbc1();
//传递参数
		this.bnum = bnum;	
		this.bname = bname;
		this.pirce = pirce;	
		this.kind =kind;
		this.author = author;	
		this.cbs = cbs;
		

		if (bnum == null || bnum.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入图书编号", "错误",JOptionPane.ERROR_MESSAGE);
//			return;
		} else {
//将窗口中的数值存入sql语句
			sql = "insert into book(bnum,bname,pirce,kind,author,cbs) values ('"
					+ bnum+ "','"+ bname+ "','"+ pirce + "','"+ kind+ "','"
					+ author+ "','"+ cbs+ "'"
							+ ")";
			System.out.println(sql);
//执行sql语句添加记录
			try {
				DB.OpenConn(); 	
				DB.execute(sql);
				JOptionPane.showMessageDialog(null, "成功添加一条新的纪录！");
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "保存失败", "错误",JOptionPane.ERROR_MESSAGE);
			} finally {
				DB.closeStmt();	
				DB.closeConn();
			}
		}
		
	}
	///
	 public String[] cx(String num) {
		 jdbc1 DB = new jdbc1();
		this.sNum = num;
		String[] s = new String[8];
		sql = "select * from student where book = " + Integer.parseInt(bnum)+ "";
		try {DB.OpenConn();
			rs = DB.executeQuery(sql);
			if (rs.next()) {
				s[0] = rs.getString("bname");	
				s[1] = rs.getString("pirec");
				s[2] = rs.getString("kind");	
				s[3] = rs.getString("author");
				s[4] = rs.getString("cbs");	
				
			} else	s = null;
		} catch (Exception e) {
			
		} finally {	
			DB.closeStmt();	
			DB.closeConn();
		}
		return s;
	}
	//根据指定范围查询信息
		public String[][] stuAllSearch(String xh, String h1,String h2){
			this.colName = xh;
			this.colValue = h1;
			this.colValue2 = h2;
			jdbc1 DB = new jdbc1();
			String[][] sn = null;	
			int row = 0;
			int i = 0;
			sql = "select * from book where " + colName + " between " + colValue+ " and " + colValue2 + "";
			try {DB.OpenConn();
				rs = DB.executeQuery(sql);
				if (rs.last()) {
					row = rs.getRow();
				}
				if (row == 0) {	
					sn = null;
				} else {
					sn = new String[row][9];
					rs.first();	
					rs.previous();
					while (rs.next()) {
						sn[i][0] = rs.getString("bnum");
						sn[i][1] = rs.getString("bname");
						sn[i][2] = rs.getString("pirce");
						sn[i][3] = rs.getString("kind");
						sn[i][4] = rs.getString("author");
						sn[i][5] = rs.getString("cbs");
						
						i++;
					}
				}
			} catch (Exception e) {
				
			} finally {	
				DB.closeStmt();	
				DB.closeConn();
			}
			return sn;
		}
		//修改
		public void xg(String bnum, String bname, String pirce, String kind,
				String author, String cbs ) {
					jdbc1 DB = new jdbc1();//连接数据库
			//传递参数
					this.bnum = bnum;	
					this.bname = bname;
					this.pirce = pirce;	
					this.kind =kind;
					this.author = author;	
					this.cbs = cbs;
					if (bnum == null || bnum.equals("")) {
						JOptionPane.showMessageDialog(null, "请输入图书信息", "错误",JOptionPane.ERROR_MESSAGE);
						return;
					} else {
						sql = "update book set bname = '" + bname + "', pirce = '" + pirce
								+ "', kind = '" + kind + "', author = '" + author
								+ "', cbs = '" + cbs+ "' where bnum = " + Integer.parseInt(bnum) + "";
						try {
							DB.OpenConn();
							DB.executeUpdate(sql);
							JOptionPane.showMessageDialog(null, "成功修改一条新的纪录！");
						} catch (Exception e) {
							System.out.println(e);
							JOptionPane.showMessageDialog(null, "更新失败", "错误",JOptionPane.ERROR_MESSAGE);
						} finally {
							DB.closeStmt();
							DB.closeConn();
						}
					}
		}
		//修改密码
		public void xgmm(String username, String password ) {
					jdbc1 DB = new jdbc1();//连接数据库
			//传递参数
					this.username = username;	
					this.password = password;
					
					
					if (username == null || username.equals("")) {
						JOptionPane.showMessageDialog(null, "请输入图书信息", "错误",JOptionPane.ERROR_MESSAGE);
						return;
					} else {
						sql = "update admin set password = '" + password + "' where username = " + Integer.parseInt(username) + "";
						try {
							DB.OpenConn();
							DB.executeUpdate(sql);
							JOptionPane.showMessageDialog(null, "成功修改密码！");
						} catch (Exception e) {
							System.out.println(e);
							JOptionPane.showMessageDialog(null, "修改失败", "错误",JOptionPane.ERROR_MESSAGE);
						} finally {
							DB.closeStmt();
							DB.closeConn();
						}
					}
		}
		
		
		//普通用户修改密码
				public void ptxgmm(String username, String password ) {
							jdbc1 DB = new jdbc1();//连接数据库
					//传递参数
							this.username = username;	
							this.password = password;
							
							
							if (username == null || username.equals("")) {
								JOptionPane.showMessageDialog(null, "请输入图书信息", "错误",JOptionPane.ERROR_MESSAGE);
								return;
							} else {
								sql = "update useradmin set password = '" + password + "' where username = " + Integer.parseInt(username) + "";
								try {
									DB.OpenConn();
									DB.executeUpdate(sql);
									JOptionPane.showMessageDialog(null, "成功修改密码！");
								} catch (Exception e) {
									System.out.println(e);
									JOptionPane.showMessageDialog(null, "修改失败", "错误",JOptionPane.ERROR_MESSAGE);
								} finally {
									DB.closeStmt();
									DB.closeConn();
								}
							}
				}

		public void borrow(String bnum, String bname, String kssj, String jssj, String name) {
			jdbc1 DB = new jdbc1();
	//传递参数
			this.bnum = bnum;	
			this.bname = bname;
			this.kssj = kssj;	
			this.jssj =jssj;
			this.name = name;	
		
			

			if (bnum == null || bnum.equals("")) {
				JOptionPane.showMessageDialog(null, "请输入图书编号", "错误",JOptionPane.ERROR_MESSAGE);
//				return;
			} else {
	//将窗口中的数值存入sql语句
				sql = "insert into borrow(bnum,bname,kssj,jssj,name) values ('"
						+ bnum+ "','"+ bname+ "','"+ kssj + "','"+ jssj+ "','"
						+ name+ "')";
				System.out.println(sql);
	//执行sql语句添加记录
				try {
					DB.OpenConn(); 	
					DB.execute(sql);
					JOptionPane.showMessageDialog(null, "成功添加一条新的纪录！");
				} catch (Exception e) {
					System.out.println(e);
					JOptionPane.showMessageDialog(null, "保存失败", "错误",JOptionPane.ERROR_MESSAGE);
				} finally {
					DB.closeStmt();	
					DB.closeConn();
				}
			}
			
		}
		}
		
	



	

