package com.project.EMS.service;

import com.project.EMS.dao.IDAO;

import java.sql.SQLException;
import java.util.List;

import com.project.EMS.dao.DAO;
import com.project.EMS.model.Expense;
import com.project.EMS.model.User;

public class BussinessLogic {
	
	public String CHECKUser(User user) throws ClassNotFoundException, SQLException {
		IDAO USER = new DAO();
		boolean output = USER.ckeckUser(user);
		if(output) {
			return"User is Valid";	
		}
		else {
			return"User is not Valid";
		}
		
		
	}
	
	public String ADDUser(User user) throws ClassNotFoundException, SQLException {
		IDAO USER=new DAO();
		int output = USER.addUser(user);
		if(output==1) {
			return"User Added Successfully";	
		}
		else {
			return"User not Added,Try again!";
		}
		
	}
	
	public String ADDExpense(Expense expense,User user) throws ClassNotFoundException, SQLException {
		IDAO EXPENSE = new DAO();
		int output = EXPENSE.addExpense(expense, user);
		if(output==1) {
			return "Expense Added";	
		}
		else {
			return"Expense Not Added";
		}
	}
	
	public List DISPLAYexpense(User user) throws ClassNotFoundException, SQLException {
		IDAO DISPLAY = new DAO();
		List<Expense> output = DISPLAY.viewExpense(user);
		return output;
	}
	
	public String DELETEexpense(int Expenseid) throws ClassNotFoundException, SQLException {
		IDAO DELETE = new DAO();
		int output = DELETE.deleteExpense(Expenseid);
		if(output==1) {
			return"Expense Deleted Successfully";
		
		}
		return"Expense Not Deleted";
	}
}
