package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.BankDAOInterface;
import com.bank.entity.Customer;
import com.bank.entity.Transaction;

@Service
public class BankServiceImpl implements BankServiceInterface {
	
	@Autowired
	BankDAOInterface bdi;
	
	@Override @Transactional
	public void createCustomer(Customer customer) {
		bdi.createCustomer(customer);
	}

	@Override @Transactional
	public Customer getCustomer(Customer customer) {
		return bdi.getCustomer(customer);
	}
	
	@Override @Transactional
	public double getTransaction(Transaction trans, Customer cust){
		return bdi.getTransaction(trans,cust);
	}
	
	@Override @Transactional
	public List<Transaction> listTransaction(Transaction trans, Customer cust){
		return bdi.listTransaction(trans,cust);
	}
	
	
	@Override @Transactional
	public double getMonthDefensive(Transaction trans, Customer cust){
		return bdi.getMonthDefensive(trans,cust);
		
	}
	
	@Override @Transactional
	public double getDateDefensive(Transaction trans, Customer cust){
		return bdi.getDateDefensive(trans,cust);
	}
	
	@Override @Transactional
	public void createTransaction(Transaction trans,Customer customer){
		bdi.createTransaction(trans,customer);
	}
	
	@Override @Transactional
	public List<Transaction> listExViTransaction(Customer customer,Transaction trans,String date){
		return bdi.listExViTransaction(customer,trans,date);
	}

	@Override @Transactional
	public Customer checkEmail(Customer email) {
		// TODO Auto-generated method stub
		return bdi.checkEmail(email);
	}

	@Override @Transactional
	public Customer checkUsername(Customer username) {
		// TODO Auto-generated method stub
		return bdi.checkUsername(username);
	}

}
