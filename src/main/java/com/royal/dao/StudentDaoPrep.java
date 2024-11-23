package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.royal.bean.StudentBean;
import com.royal.util.DBConnection;

// PreparedStatement
public class StudentDaoPrep 
{
	public int insertStudent(StudentBean sbean) 
	{
		String insertQuery = "INSERT INTO student(name,std,marks) VALUES(?,?,?)";
		
		System.out.println("insertQuery : " + insertQuery);
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		int rowsAffected = 0;
		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(insertQuery);

				pstmt.setString(1, sbean.getName());
				pstmt.setInt(2, sbean.getStd());
				pstmt.setInt(3, sbean.getMarks());
				
				rowsAffected = pstmt.executeUpdate();
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("StudentDaoPrep --insertStudent()---Db not connected");
		}
		return rowsAffected;
	}
	public int deleteStudent(int rno) 
	{
		String deleteQuery = "DELETE FROM student WHERE rno=?";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		int rowsAffected = 0 ;
		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(deleteQuery);
				
				pstmt.setInt(1, rno);
				
				rowsAffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			} 
		} else 
		{
			System.out.println("Dnb not connected : " + conn);
		}
		return rowsAffected;
	}
	public ArrayList<StudentBean> getAllRecords() 
	{
		String selectQuery = "SELECT rno,name,std,marks FROM student";
		ArrayList<StudentBean> list = new ArrayList<StudentBean>();
		StudentBean sbean  = null;
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(selectQuery);
			
				rs = pstmt.executeQuery();
				
				while(rs.next()) 
				{
					int rno = rs.getInt(1);
					String name = rs.getString(2);
					int std = rs.getInt(3);
					int marks = rs.getInt(4);
					
//					System.out.println("===>"+rno+" " + name+" " + std+" " + marks);
					
					sbean  = new StudentBean(rno, name, std, marks);
					list.add(sbean);
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("Db not connected ");
		}
		return list;
	}
	
	public int updateStudent(StudentBean sbean , int rno) 
	{
		String updateQuery = "UPDATE student SET name=?, std=?,marks=? WHERE rno=?";
		
		Connection conn =  DBConnection.getConnection();
		PreparedStatement pstmt = null;
		int rowsAffected = 0 ;
		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(updateQuery);
			
				pstmt.setString(1, sbean.getName());
				pstmt.setInt(2, sbean.getStd());
				pstmt.setInt(3, sbean.getMarks());
				pstmt.setInt(4, rno);
				
				rowsAffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("Db not connected");
		}
		return rowsAffected;
	}

	void test1() 
	{
		
	}
	// get Student record by id 
	public Object getStudentByRno(int rno1) 
	{
		String selectStudentByRno = "SELECT * FROM student WHERE rno=?";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt  = null; 
		ResultSet rs = null;
		StudentBean sbean = null;
		
		if (conn!=null) 
		{
			try 
			{
				pstmt  = conn.prepareStatement(selectStudentByRno);
			
				pstmt.setInt(1, rno1);
				
				rs = pstmt.executeQuery();
				if (rs.next()) 
				{
					int rno = rs.getInt(1);
					String name = rs.getString(2);
					int std = rs.getInt(3);
					int marks = rs.getInt(4);
					
					sbean = new StudentBean(rno,name, std , marks);
					
					return sbean;
				} else 
				{
					System.out.println("Student record not found");
					return false;
				} 
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("Db not conncected");
		}
		return false; 
	}
	public static void main(String[] args) 
	{
		Scanner sc  = new  Scanner(System.in);
		System.out.println("Enter Rno which you want to Get  : ");
		int rno = sc.nextInt();
		
		StudentDaoPrep dao = new StudentDaoPrep();
		
		Object object = dao.getStudentByRno(rno);// false / sbean
		
		if (object instanceof StudentBean) 
		{
			StudentBean sbean = (StudentBean)object;
			
			System.out.println(sbean.getRno()+" " + sbean.getName()+" " + sbean.getStd()+" " + sbean.getMarks());
			
		} else if(object instanceof Boolean)
		{
			System.out.println("Student record not found");
		}
		
		//-------------UPDATE Student--------------		
		
		
/*		Scanner sc  = new  Scanner(System.in);
		System.out.println("Enter Rno which you want to update  : ");
		int rno = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Name : ");
		String name = sc.nextLine();
		System.out.println("Enter Std : ");
		int std = sc.nextInt();
		System.out.println("Enter Marks : ");
		int marks = sc.nextInt();
		
		StudentBean sbean = new StudentBean(0, name, std, marks);

		StudentDaoPrep dao = new StudentDaoPrep();
		
		int rowsAffected = dao.updateStudent(sbean, rno);
		
		if (rowsAffected > 0) 
		{
			System.out.println("Student record successfully updated : " + rowsAffected);
			
		} else 
		{
			System.out.println("Student record not updated : " + rowsAffected);
		}
		
		
		
		//-------------SELECT Student--------------		
			StudentDaoPrep dao = new StudentDaoPrep();
		ArrayList<StudentBean> list = dao.getAllRecords();
		
		System.out.println("Total Rows : " + list.size());
		
		for (int i = 0; i < list.size(); i++) 
		{
			StudentBean s = list.get(i);
			
			System.out.println(s.getRno()+" " + s.getName()+" " + s.getStd()+" " + s.getMarks());
		}
		
	
		//-------------DELETE Student--------------		
		Scanner sc  = new  Scanner(System.in);
		System.out.println("Enter Rno which you want to delete  : ");
		int rno = sc.nextInt();
		
		StudentDaoPrep dao = new StudentDaoPrep();
		
		int rowsAffected =dao.deleteStudent(rno);
		
		if (rowsAffected > 0) 
		{
			System.out.println("Student record successfully Deleted : " + rowsAffected);
			
		} else 
		{
			System.out.println("Student record not Deleted : " + rowsAffected);
		}
		
		//-------------INSERT Student--------------
		Scanner sc  = new  Scanner(System.in);
		System.out.println("Enter Name : ");
		String name = sc.nextLine();
		System.out.println("Enter Std : ");
		int std = sc.nextInt();
		System.out.println("Enter Marks : ");
		int marks = sc.nextInt();
		
		StudentBean sbean = new StudentBean(0, name, std, marks);
				
		StudentDaoPrep dao = new StudentDaoPrep();
		
		int rowsAffected = dao.insertStudent(sbean);
		
		if (rowsAffected > 0) 
		{
			System.out.println("Student record successfully Inserted : " + rowsAffected);
			
		} else 
		{
			System.out.println("Student record not Inserted : " + rowsAffected);
		}
*/	}
}
