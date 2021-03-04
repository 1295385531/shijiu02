package com.view;

import java.util.*;
import java.sql.*;
import javax.swing.*;
import com.util.jdbc1;//�����Զ�����
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
	int stuId;// ѧ������ѧ��
	private String bnum;
	private String bname;
	private String pirce;
	private String kind;
	private String author;
	private String cbs;
	private String kssj;
	private String jssj;
	private String name;
	
	//���ѧ����Ϣ�ķ���
	public void stuAdd(String name, String sex, String birth, String home,
				String ethnic, String year, String major, String college) {
			jdbc1 DB = new jdbc1();
	//���ݲ���
			this.sName = name;	
			this.sSex = sex;
			this.sBirth = birth;	
			this.sHome = home;
			this.sEthnic = ethnic;	
			this.sYear = year;
			this.sMajor = major;	
			this.sCollege = college;

			if (sName == null || sName.equals("")) {
				JOptionPane.showMessageDialog(null, "������ѧ������", "����",JOptionPane.ERROR_MESSAGE);
//				return;
			} else {
	//�������е���ֵ����sql���
				sql = "insert into student(sname,ssex,sbirth,shome,sethnic,syear,smajor,scollege) values ('"
						+ sName+ "','"+ sSex+ "','"+ sBirth+ "','"+ sHome+ "','"
						+ sEthnic+ "','"+ sYear+ "','"+ sMajor+ "','"+ sCollege + "')";
				System.out.println(sql);
	//ִ��sql�����Ӽ�¼
				try {
					DB.OpenConn(); 	
					DB.execute(sql);
					JOptionPane.showMessageDialog(null, "�ɹ����һ���µļ�¼��");
				} catch (Exception e) {
					System.out.println(e);
					JOptionPane.showMessageDialog(null, "����ʧ��", "����",JOptionPane.ERROR_MESSAGE);
				} finally {
					DB.closeStmt();	
					DB.closeConn();
				}
			}
		}

	//�޸�ѧ����Ϣ
	public void stuModify(String num, String name, String sex, String birth,
			String home, String ethnic, String year, String major,String college) {
				jdbc1 DB = new jdbc1();//�������ݿ�
		//���ݲ���
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
					JOptionPane.showMessageDialog(null, "������ѧ������", "����",JOptionPane.ERROR_MESSAGE);
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
						JOptionPane.showMessageDialog(null, "�ɹ��޸�һ���µļ�¼��");
					} catch (Exception e) {
						System.out.println(e);
						JOptionPane.showMessageDialog(null, "����ʧ��", "����",JOptionPane.ERROR_MESSAGE);
					} finally {
						DB.closeStmt();
						DB.closeConn();
					}
				}
	}
	// ɾ��ѧ����Ϣ
	public void stuDel(String num) {
		jdbc1 DB = new jdbc1();
		this.sNum = num;
		sql = "delete from student where snum = " + Integer.parseInt(sNum) + "";
		try {
			DB.OpenConn();
			DB.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "�ɹ�ɾ��һ���µļ�¼��");
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "ɾ��ʧ��", "����",JOptionPane.ERROR_MESSAGE);
		} finally {
			DB.closeStmt();
			DB.closeConn();
		}
	}
	// ����ָ��ѧ�Ų�ѯѧ����Ϣ
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
	
	//����ָ����ѧ�ŷ�Χ��ѯѧ����Ϣ
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

//////////////////////////////ͼ���ѯ
	
	
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
	
	
	
	
	
	
	public int getStuId() {//����µ�ѧ��
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
	//���student���е�����ѧ��snum
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
	//���ݲ���
			this.username = usename;	
			this.password = password;
		
			if (username == null || username.equals("")) {
				JOptionPane.showMessageDialog(null, "�������û���", "����",JOptionPane.ERROR_MESSAGE);
//				return;
			} else {
	//�������е���ֵ����sql���
				sql = "insert into admin(username,password) values ('"
						+ username+ "','"+ password+ "')";
				System.out.println(sql);
	//ִ��sql�����Ӽ�¼
				try {
					DB.OpenConn(); 	
					DB.execute(sql);
					JOptionPane.showMessageDialog(null, "�ɹ�ע��һ���û���");
				} catch (Exception e) {
					System.out.println(e);
					JOptionPane.showMessageDialog(null, "ע��ʧ��", "����",JOptionPane.ERROR_MESSAGE);
				} finally {
					DB.closeStmt();	
					DB.closeConn();
				}
			}
			}
	//��ͨ�û�ע��ķ���
	public void userzhuce(String usename, String password) {
		
		jdbc1 DB = new jdbc1();
//���ݲ���
		this.username = usename;	
		this.password = password;
	
		if (username == null || username.equals("")) {
			JOptionPane.showMessageDialog(null, "�������û���", "����",JOptionPane.ERROR_MESSAGE);
//			return;
		} else {
//�������е���ֵ����sql���
			sql = "insert into useradmin(username,password) values ('"
					+ username+ "','"+ password+ "')";
			System.out.println(sql);
//ִ��sql�����Ӽ�¼
			try {
				DB.OpenConn(); 	
				DB.execute(sql);
				JOptionPane.showMessageDialog(null, "�ɹ�ע��һ���û���");
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "ע��ʧ��", "����",JOptionPane.ERROR_MESSAGE);
			} finally {
				DB.closeStmt();	
				DB.closeConn();
			}
		}
		}

	public void bookAdd(String bnum, String bname, String pirce, String kind, String author, String cbs) {
		jdbc1 DB = new jdbc1();
//���ݲ���
		this.bnum = bnum;	
		this.bname = bname;
		this.pirce = pirce;	
		this.kind =kind;
		this.author = author;	
		this.cbs = cbs;
		

		if (bnum == null || bnum.equals("")) {
			JOptionPane.showMessageDialog(null, "������ͼ����", "����",JOptionPane.ERROR_MESSAGE);
//			return;
		} else {
//�������е���ֵ����sql���
			sql = "insert into book(bnum,bname,pirce,kind,author,cbs) values ('"
					+ bnum+ "','"+ bname+ "','"+ pirce + "','"+ kind+ "','"
					+ author+ "','"+ cbs+ "'"
							+ ")";
			System.out.println(sql);
//ִ��sql�����Ӽ�¼
			try {
				DB.OpenConn(); 	
				DB.execute(sql);
				JOptionPane.showMessageDialog(null, "�ɹ����һ���µļ�¼��");
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "����ʧ��", "����",JOptionPane.ERROR_MESSAGE);
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
	//����ָ����Χ��ѯ��Ϣ
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
		//�޸�
		public void xg(String bnum, String bname, String pirce, String kind,
				String author, String cbs ) {
					jdbc1 DB = new jdbc1();//�������ݿ�
			//���ݲ���
					this.bnum = bnum;	
					this.bname = bname;
					this.pirce = pirce;	
					this.kind =kind;
					this.author = author;	
					this.cbs = cbs;
					if (bnum == null || bnum.equals("")) {
						JOptionPane.showMessageDialog(null, "������ͼ����Ϣ", "����",JOptionPane.ERROR_MESSAGE);
						return;
					} else {
						sql = "update book set bname = '" + bname + "', pirce = '" + pirce
								+ "', kind = '" + kind + "', author = '" + author
								+ "', cbs = '" + cbs+ "' where bnum = " + Integer.parseInt(bnum) + "";
						try {
							DB.OpenConn();
							DB.executeUpdate(sql);
							JOptionPane.showMessageDialog(null, "�ɹ��޸�һ���µļ�¼��");
						} catch (Exception e) {
							System.out.println(e);
							JOptionPane.showMessageDialog(null, "����ʧ��", "����",JOptionPane.ERROR_MESSAGE);
						} finally {
							DB.closeStmt();
							DB.closeConn();
						}
					}
		}
		//�޸�����
		public void xgmm(String username, String password ) {
					jdbc1 DB = new jdbc1();//�������ݿ�
			//���ݲ���
					this.username = username;	
					this.password = password;
					
					
					if (username == null || username.equals("")) {
						JOptionPane.showMessageDialog(null, "������ͼ����Ϣ", "����",JOptionPane.ERROR_MESSAGE);
						return;
					} else {
						sql = "update admin set password = '" + password + "' where username = " + Integer.parseInt(username) + "";
						try {
							DB.OpenConn();
							DB.executeUpdate(sql);
							JOptionPane.showMessageDialog(null, "�ɹ��޸����룡");
						} catch (Exception e) {
							System.out.println(e);
							JOptionPane.showMessageDialog(null, "�޸�ʧ��", "����",JOptionPane.ERROR_MESSAGE);
						} finally {
							DB.closeStmt();
							DB.closeConn();
						}
					}
		}
		
		
		//��ͨ�û��޸�����
				public void ptxgmm(String username, String password ) {
							jdbc1 DB = new jdbc1();//�������ݿ�
					//���ݲ���
							this.username = username;	
							this.password = password;
							
							
							if (username == null || username.equals("")) {
								JOptionPane.showMessageDialog(null, "������ͼ����Ϣ", "����",JOptionPane.ERROR_MESSAGE);
								return;
							} else {
								sql = "update useradmin set password = '" + password + "' where username = " + Integer.parseInt(username) + "";
								try {
									DB.OpenConn();
									DB.executeUpdate(sql);
									JOptionPane.showMessageDialog(null, "�ɹ��޸����룡");
								} catch (Exception e) {
									System.out.println(e);
									JOptionPane.showMessageDialog(null, "�޸�ʧ��", "����",JOptionPane.ERROR_MESSAGE);
								} finally {
									DB.closeStmt();
									DB.closeConn();
								}
							}
				}

		public void borrow(String bnum, String bname, String kssj, String jssj, String name) {
			jdbc1 DB = new jdbc1();
	//���ݲ���
			this.bnum = bnum;	
			this.bname = bname;
			this.kssj = kssj;	
			this.jssj =jssj;
			this.name = name;	
		
			

			if (bnum == null || bnum.equals("")) {
				JOptionPane.showMessageDialog(null, "������ͼ����", "����",JOptionPane.ERROR_MESSAGE);
//				return;
			} else {
	//�������е���ֵ����sql���
				sql = "insert into borrow(bnum,bname,kssj,jssj,name) values ('"
						+ bnum+ "','"+ bname+ "','"+ kssj + "','"+ jssj+ "','"
						+ name+ "')";
				System.out.println(sql);
	//ִ��sql�����Ӽ�¼
				try {
					DB.OpenConn(); 	
					DB.execute(sql);
					JOptionPane.showMessageDialog(null, "�ɹ����һ���µļ�¼��");
				} catch (Exception e) {
					System.out.println(e);
					JOptionPane.showMessageDialog(null, "����ʧ��", "����",JOptionPane.ERROR_MESSAGE);
				} finally {
					DB.closeStmt();	
					DB.closeConn();
				}
			}
			
		}
		}
		
	



	

