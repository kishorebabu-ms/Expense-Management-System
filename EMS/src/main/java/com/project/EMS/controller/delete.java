package com.project.EMS.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.EMS.service.BussinessLogic;


public class delete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String expenseid=request.getParameter("expenseId");
		int eid=Integer.parseInt(expenseid);
		
		System.out.println("Expense id : "+eid);
		
		response.setContentType("text/html");
		PrintWriter pr = response.getWriter();
		
		BussinessLogic logic = new BussinessLogic();
		
		try {
			String result = logic.DELETEexpense(eid);
			if(result.contains("Expense Deleted Successfully")) {
				pr.println("<h3>Expense Deleted Successfully</h3>");
				RequestDispatcher rs = request.getRequestDispatcher("expense.jsp");
				rs.include(request, response);
			}
			
			else {
				pr.println("<h3>Expense Not Deleted </h3>");
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
