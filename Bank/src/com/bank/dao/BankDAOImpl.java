package com.bank.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bank.entity.Customer;
import com.bank.entity.Transaction;

@Repository
public class BankDAOImpl implements BankDAOInterface {

	@Autowired
	SessionFactory sessionfactory;
	
	//1.Create New Customer
	public void createCustomer(Customer customer){
		sessionfactory.getCurrentSession().saveOrUpdate(customer);
	}
	
	//2.Check Customer login authentication
	public Customer getCustomer(Customer customer){
		
		return (Customer) sessionfactory.getCurrentSession().createCriteria(Customer.class)
				.add(Restrictions.eq("username", customer.getUsername()))
				.add(Restrictions.eq("password", customer.getPassword()))
				.setMaxResults(1).uniqueResult();
	}
	
	//3.Calculate Customer Bank Balance
	public double getTransaction(Transaction trans, Customer cust){
		
		Criteria user = null;
		Criteria credit = null;
		double balance = 0;
	try{
		if(trans.getUserid()==null){
		//Method-1
		/*Customer cus = (Customer)sessionfactory.getCurrentSession().createCriteria(Customer.class)
		.add(Restrictions.eq("username", cust.getUsername())).uniqueResult();
		trans.setUserid(cus);*/
			
		//Method-2   ---- Both are same
		user = sessionfactory.getCurrentSession().createCriteria(Customer.class);
		Criterion criterion = Restrictions.eq("username", cust.getUsername());
		user.add(criterion);
		Customer cus = (Customer)user.uniqueResult();
		System.out.println("UniqueResult values: ");
		System.out.println(cus.getUserid());
		System.out.println(cus.getUsername());
		System.out.println(cus.getEmail());
		trans.setUserid(cus);
		}
		//Method-1
		/*String cre = (String) sessionfactory.getCurrentSession().createCriteria(Transaction.class)
		.add(Restrictions.eq("userid", trans.getUserid())).add(Restrictions.eq("type", "cr"))
		.setProjection(Projections.sum("amount")).uniqueResult();*/
		
		//Method-2
		credit= sessionfactory.getCurrentSession().createCriteria(Transaction.class);
		Criterion criter1 = Restrictions.eq("userid", trans.getUserid()); System.out.println(trans.getUserid());
		Criterion criter2 = Restrictions.eq("trans_type", "cr");
		credit.add(criter1).add(criter2);
		credit.setProjection(Projections.sum("trans_amount"));
		String cre = (String)credit.uniqueResult();
		if(cre == null){
			cre="0";
		}
		double c = Double.parseDouble(cre);
		//int c = Integer.valueOf(cre);
		
		String deb = (String)sessionfactory.getCurrentSession().createCriteria(Transaction.class)
		.add(Restrictions.eq("userid", trans.getUserid())).add(Restrictions.eq("trans_type", "dr"))
		.setProjection(Projections.sum("trans_amount")).uniqueResult();
		if(deb == null){
			deb="0";
		}
		double d = Double.parseDouble(deb);
		//int d = Integer.valueOf(deb);
		balance = c-d;
		System.out.println("The Balance amount is:"+balance);
	}catch(Exception ex){
		ex.printStackTrace();
	}
		return balance;
	}
	
	
	//4.Find the list of Transaction per Customer
	@SuppressWarnings("unchecked")
	public List<Transaction> listTransaction(Transaction trans, Customer cust){
		List<Transaction> tr = null;
		try{
			if(trans.getUserid() == null){
				Customer cus = (Customer)sessionfactory.getCurrentSession().createCriteria(Customer.class)
						.add(Restrictions.eq("username", cust.getUsername()))
						.uniqueResult();
				trans.setUserid(cus);
			}
			tr = (List<Transaction>) sessionfactory.getCurrentSession().createCriteria(Transaction.class)
			.add(Restrictions.eq("userid", trans.getUserid()))
			.addOrder(Order.desc("trans_date")).setFirstResult(0).setMaxResults(5).list();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return tr;
	}
	
	//5.Find the Customer Transation by Month

	public double getMonthDefensive(Transaction trans, Customer cust){
		double yeardef = 0;
	try{
		if(trans.getUserid() == null){
			trans.setUserid( (Customer) sessionfactory.getCurrentSession().createCriteria(Customer.class)
			.add(Restrictions.eq("username", cust.getUsername())).uniqueResult() );
		}
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		String cdate = year+ "/" +month+ "/" +day;
		
		//Customer cus = trans.getUserid();
		//int userid = cus.getUserid();
		//String hql1="select sum(amount)from transaction transac where userid="+userid+" and month(date)="+month+" and year(date)="+year+" and type='dr'";
		//String hql = "select sum(trans_amount) from transaction where userid="+userid+" and month(trans_date)="+month+" and year(trans_date)="+year+" and trans_type='dr'";
		//Query query = sessionfactory.getCurrentSession().createSQLQuery(hql);
		//String num = (String) query.uniqueResult();
		
		String num = (String) sessionfactory.getCurrentSession().createCriteria(Transaction.class)
				.add(Restrictions.eq("userid", trans.getUserid()))
				.add(Restrictions.eq("trans_type", "dr"))
				.add(Restrictions.eq("trans_date",cdate))
				.setProjection(Projections.sum("trans_amount")).uniqueResult();
		System.out.println("Kathir:" +trans.getUserid()+"______");
		
		if(num==null)
		{
			num="0";
		}
		yeardef = Double.parseDouble(num);
		
	}catch(Exception ex){
		ex.printStackTrace();		
	}
		return yeardef;
		
	} 
	
	//6.Find the Customer Transation by Date
	public double getDateDefensive(Transaction trans, Customer cust){
		
		if(trans.getUserid() == null){
			trans.setUserid( (Customer) sessionfactory.getCurrentSession().createCriteria(Customer.class)
			.add(Restrictions.eq("username", cust.getUsername())).uniqueResult() );
		}
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		 int month = cal.get(Calendar.MONTH)+1;
		 int day = cal.get(Calendar.DAY_OF_MONTH);
		 String cdate = year+ "/" +month+ "/" +day;
		 
		System.out.println("The Current date is:*** "+cdate);
		String st = (String) sessionfactory.getCurrentSession().createCriteria(Transaction.class)
				.add(Restrictions.eq("userid", trans.getUserid()))
				.add(Restrictions.eq("trans_type", "cr"))
				.add(Restrictions.eq("trans_date",cdate))
				.setProjection(Projections.sum("trans_amount")).uniqueResult();
		if(st == null){
			
			st = "0";
		}
		double datedef = Double.parseDouble(st);
		return datedef;
				
		
	}
	
	// 7. Create Transaction by Customer Id
	public void createTransaction(Transaction trans,Customer customer){
		
		// Validate the Customer
		Customer cust = (Customer) sessionfactory.getCurrentSession().createCriteria(Customer.class)
		.add(Restrictions.eq("username", customer.getUsername())).uniqueResult();
		trans.setUserid(cust);
		// Save Customer Transaction per customer id.
		sessionfactory.getCurrentSession().saveOrUpdate(trans);
	}
	//8. Generate List of External Transaction Reports
	@SuppressWarnings("unchecked")
	public List<Transaction> listExViTransaction(Customer customer,Transaction trans,String date){
		List<Transaction> tr = null;
		System.out.println("Customer name is: "+customer.getUsername()+" Date is: "+date);
		try
		{
			if(trans.getUserid() == null){
				trans.setUserid( (Customer)sessionfactory.getCurrentSession().createCriteria(Customer.class)
					 .add(Restrictions.eq("username", customer.getUsername())).uniqueResult() );
			}
			tr = (List<Transaction>) sessionfactory.getCurrentSession().createCriteria(Transaction.class)
					.add(Restrictions.eq("userid", trans.getUserid()))
					.addOrder(Order.desc("trans_time")).add(Restrictions.like("trans_date", date, MatchMode.START))
					.setFirstResult(0).setMaxResults(50).list();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		 return tr;
	}
	//9.Check Email for the Customer
	public Customer checkEmail(Customer email){
		return (Customer) sessionfactory.getCurrentSession().createCriteria(Customer.class)
				.add(Restrictions.eq("email", email.getEmail())).setMaxResults(1).uniqueResult();
		
	}
	
	//10.Check Username exist for Customer 
	public Customer checkUsername(Customer username){
		return (Customer) sessionfactory.getCurrentSession().createCriteria(Customer.class)
				.add(Restrictions.eq("username", username.getUsername())).setMaxResults(1).uniqueResult();
	}
}
