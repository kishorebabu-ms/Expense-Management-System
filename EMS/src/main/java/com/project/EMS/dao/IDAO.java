package com.project.EMS.dao;

import java.sql.SQLException;
import java.util.List;

import com.project.EMS.model.Expense;
import com.project.EMS.model.User;

public interface IDAO {
	
	boolean ckeckUser(User user) throws ClassNotFoundException, SQLException;
	int addUser(User user) throws ClassNotFoundException, SQLException; 
	
	int addExpense(Expense expense,User user) throws ClassNotFoundException, SQLException;
	List<Expense> viewExpense(User user) throws ClassNotFoundException, SQLException;
	
	int deleteExpense(int expenseid) throws ClassNotFoundException, SQLException;
}
