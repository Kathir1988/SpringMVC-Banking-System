package com.bank.dao;

import java.util.List;

import com.bank.entity.Customer;
import com.bank.entity.Transaction;

public interface BankDAOInterface {
	
	public void createCustomer(Customer customer);

	public Customer getCustomer(Customer customer);
	
	public double getTransaction(Transaction trans, Customer cust);
	
	public List<Transaction> listTransaction(Transaction trans, Customer cust);
	
	public double getMonthDefensive(Transaction trans, Customer cust);
	
	public double getDateDefensive(Transaction trans, Customer cust);

	public void createTransaction(Transaction trans, Customer cust);
	
	public List<Transaction> listExViTransaction(Customer customer,Transaction trans,String date);
	
	public Customer checkEmail(Customer email);
	
	public Customer checkUsername(Customer username);
}

