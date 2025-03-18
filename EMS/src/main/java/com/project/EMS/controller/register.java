package com.project.EMS.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.EMS.model.User;
import com.project.EMS.service.BussinessLogic;


public class register extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pr=response.getWriter();
		
		String username = request.getParameter("username");
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User u2 = new User(username, fullname, email, password);
		BussinessLogic logic = new BussinessLogic();
		
		try {
			String result = logic.ADDUser(u2);
			System.out.println(result);
			
			if(result.contains("User not Added,Try again!")) {
				System.out.println("User not Added,Try again!");
				pr.println("<h2>User not Added,Try again!</h2>");
				
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.include(request, response);
				
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
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
