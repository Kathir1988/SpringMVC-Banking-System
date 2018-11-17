package com.bank.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="Transaction")
public class Transaction implements Serializable {

	private static final long serialVersionUID = -7781726900492082094L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="trans_id")
	private int trans_id;
	
	@Column(name="trans_name")
	private String trans_name;
	
	@Column(name="trans_amount")
	private String trans_amount;
	
	@Column(name="trans_date")
	private String trans_date;
	
	@Column(name="trans_time")
	private String trans_time;
	
	@Column(name="trans_type")
	private String trans_type;
	
	@Column(name="trans_typedef")
	private  String trans_typedef;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="userid")
	private Customer userid;
	
	public Transaction(){}

	Transaction(int trans_id, String trans_name, String trans_amount, String trans_date, String trans_time,
			String trans_type, String trans_typedef, Customer userid) {
		super();
		this.trans_id = trans_id;
		this.trans_name = trans_name;
		this.trans_amount = trans_amount;
		this.trans_date = trans_date;
		this.trans_time = trans_time;
		this.trans_type = trans_type;
		this.trans_typedef = trans_typedef;
		this.userid = userid;
	}


	public int getTrans_id() {
		return trans_id;
	}

	public void setTrans_id(int trans_id) {
		this.trans_id = trans_id;
	}

	public String getTrans_name() {
		return trans_name;
	}

	public void setTrans_name(String trans_name) {
		this.trans_name = trans_name;
	}

	public String getTrans_amount() {
		return trans_amount;
	}

	public void setTrans_amount(String trans_amount) {
		this.trans_amount = trans_amount;
	}

	public String getTrans_date() {
		return trans_date;
	}

	public void setTrans_date(String trans_date) {
		this.trans_date = trans_date;
	}

	public String getTrans_time() {
		return trans_time;
	}

	public void setTrans_time(String trans_time) {
		this.trans_time = trans_time;
	}

	public String getTrans_type() {
		return trans_type;
	}

	public void setTrans_type(String trans_type) {
		this.trans_type = trans_type;
	}

	public String getTrans_typedef() {
		return trans_typedef;
	}

	public void setTrans_typedef(String trans_typedef) {
		this.trans_typedef = trans_typedef;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Customer getUserid() {
		return userid;
	}

	public void setUserid(Customer userid) {
		this.userid = userid;
	}
	
	
	
}
