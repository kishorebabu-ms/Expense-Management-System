package com.project.EMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.EMS.db.SingleTon;
import com.project.EMS.model.Expense;
import com.project.EMS.model.User;

public class DAO implements IDAO {

	@Override
	public boolean ckeckUser(User u1) throws ClassNotFoundException, SQLException {
		Connection con = SingleTon.getInstance().getConnection();
		PreparedStatement pstmt;
		String query="select * from users where username=? and password=?";
		
		pstmt=con.prepareStatement(query);
		
		pstmt.setString(1,u1.getUserName());
		pstmt.setString(2, u1.getPassword());
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			return true;
		}
		return false;
	}

	@Override
	public int addUser(User u2) throws ClassNotFoundException, SQLException {
		Connection con= SingleTon.getInstance().getConnection();
		PreparedStatement pstmt;
		String query="insert into users (username,fullname,email,password) values(?,?,?,?)";
		
		pstmt=con.prepareStatement(query);
		pstmt.setString(1,u2.getUserName());
		pstmt.setString(2, u2.getFullName());
		pstmt.setString(3,u2.getEmail());
		pstmt.setString(4,u2.getPassword());
		
		int rs= pstmt.executeUpdate();
		if(rs==1) {
			return 1;
			
		}
		return 0;
	}

	@Override
	public int addExpense(Expense expense, User user) throws ClassNotFoundException, SQLException {
		
		Connection con =SingleTon.getInstance().getConnection();
		
		//for getting userid
		PreparedStatement pstmt1;
		String query1 = "select userid from users where username=?";
		
		pstmt1 = con.prepareStatement(query1);
		pstmt1.setString(1, user.getUserName());
		
		ResultSet rs1 = pstmt1.executeQuery();
		int userid = 0;
		while(rs1.next()) {
			userid=rs1.getInt(1);
		}
		
		//add expense to table using userid
		
		PreparedStatement pstmt2;
		String query2 = "insert into user_expense(expensedate,expensetype,expensedescription,expenseamount,userid) values (?,?,?,?,?)";
		pstmt2 = con.prepareStatement(query2);
		pstmt2.setString(1,expense.getDate());
		pstmt2.setString(2,expense.getType());
		pstmt2.setString(3,expense.getDescription());
		pstmt2.setDouble(4,expense.getAmount());
		pstmt2.setInt(5,userid);
		
		
		int rs2 = pstmt2.executeUpdate();
		if(rs2==1) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public List<Expense> viewExpense(User user) throws ClassNotFoundException, SQLException {
		List<Expense> elist = new ArrayList<Expense>();
		Connection con = SingleTon.getInstance().getConnection();
		
		//for getting userid
		PreparedStatement pstmt1;
		String query1 = "select userid from users where username=?";
		
		pstmt1 = con.prepareStatement(query1);
		pstmt1.setString(1, user.getUserName());
		
		ResultSet rs1 = pstmt1.executeQuery();
		int userid = 0;
		while(rs1.next()) {
			userid=rs1.getInt(1);
		}
		//to get table by userid
		PreparedStatement pstmt2;
		String query2="select expenseid,expensedate,expensetype,expensedescription,expenseamount from user_expense where userid=?";
		pstmt2=con.prepareStatement(query2);
		pstmt2.setInt(1, userid);
		
		 ResultSet rs2 = pstmt2.executeQuery();
		 Expense ex2;
		 while(rs2.next()) {
			 int eid=rs2.getInt(1);
			 String edate=rs2.getString(2);
			 String etype=rs2.getString(3);
			 String edescrition=rs2.getString(4);
			 String amount=rs2.getString(5);
			 double eamount=Double.parseDouble(amount);
			 
			 ex2=new Expense(edate, etype, edescrition, eamount, eid);
			 elist.add(ex2);

		 }
		 return elist;
	}

	@Override
	public int deleteExpense(int expenseid) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt;
		Connection con = SingleTon.getInstance().getConnection();
		String query = "delete from user_expense where expenseid = ?";
		pstmt=con.prepareStatement(query);
		pstmt.setInt(1, expenseid);
		int rs=pstmt.executeUpdate();
		if(rs==1) {
			return 1;
		}
		return 0;
	}

}
