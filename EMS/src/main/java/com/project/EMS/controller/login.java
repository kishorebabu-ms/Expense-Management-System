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

import com.project.EMS.model.User;
import com.project.EMS.service.BussinessLogic;


public class login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pr = response.getWriter();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		HttpSession session = request.getSession();
		session.setAttribute("Uname",username);
		
		
		User u1= new User(username,password);
		BussinessLogic logic = new BussinessLogic();
		
		try {
			String result = logic.CHECKUser(u1);
			System.out.println(result);
			
			if(result.contains("User is not Valid")) {
				System.out.println("Invalid Credentials");
				pr.println("<h3>Invalid User</h3>");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			}
			else {
				
				RequestDispatcher rd = request.getRequestDispatcher("expense.jsp");
				rd.include(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
