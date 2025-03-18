package com.project.EMS.model;

public class Expense {
	
	private String date;
	private String type;
	private String description;
	private double amount;
	
	public Expense(String date, String type, String description, double amount, int expenseid) {
		super();
		this.date = date;
		this.type = type;
		this.description = description;
		this.amount = amount;
		this.expenseid = expenseid;
	}
	
	public Expense(String date, String type, String description, double amount) {
		super();
		this.date = date;
		this.type = type;
		this.description = description;
		this.amount = amount;
		
	}
	public Expense() {
		super();
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getExpenseid() {
		return expenseid;
	}
	public void setExpenseid(int expenseid) {
		this.expenseid = expenseid;
	}
	private int expenseid;
}
