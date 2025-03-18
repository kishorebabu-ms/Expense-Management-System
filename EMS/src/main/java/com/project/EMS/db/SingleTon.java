package com.project.EMS.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleTon {
	private static SingleTon obj;
	private Connection con;
	
	public SingleTon() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EMS","root","Gokul@11");
	}
	
	public static SingleTon getInstance() throws ClassNotFoundException, SQLException {
		if(obj==null) {
			obj=new SingleTon();
			return obj;
		}
		return obj;
	}
	
	public Connection getConnection() {
		return con;
	}
	
}
