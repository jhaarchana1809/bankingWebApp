package com.nit.bank.bean;

import java.io.Serializable;

public class NewUserBean implements Serializable{
	
	private String UserName;
	private String password;
	private double amount;
	private String address;
	private long phoneNo;
	private long accountNo;
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public NewUserBean() {
		super();
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Override
	public String toString() {
		return "NewUserBean [UserName=" + UserName + ", password=" + password + ", amount=" + amount + ", address="
				+ address + ", phoneNo=" + phoneNo + "]";
	}
	

}
