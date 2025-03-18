package com.project.EMS.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.EMS.model.Expense;
import com.project.EMS.model.User;
import com.project.EMS.service.BussinessLogic;

public class addexpense extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pr = response.getWriter();
		
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("Uname");
		
		String date = request.getParameter("date");
		String type = request.getParameter("type");
		String description = request.getParameter("description");
		String amount1 = request.getParameter("amount");
		double amount = Double.parseDouble(amount1);
		
		User u3= new User(username);
		Expense e1 = new Expense(date, type, description, amount);
		
		BussinessLogic logic = new BussinessLogic();
		
		try {
			String result = logic.ADDExpense(e1, u3);
			System.out.println(result);
			
			if(result.contains("Expense Not Added")) {
				System.out.println("Expense Not Added");
				pr.println("<h3>Expense Not Added</h3>");
				pr.println("<h3>Something Went Wrong!!!</h3>");
				
				RequestDispatcher rs = request.getRequestDispatcher("expense.jsp");
				rs.include(request, response);	
			}
			else {
				pr.println("Expense Added Successfully");
				response.sendRedirect("expense.jsp");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
