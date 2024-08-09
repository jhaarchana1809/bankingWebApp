package com.nit.bank.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nit.bank.bean.NewUserBean;
import com.nit.bank.connection.DBConnection;

public class BalanceEnquiryDao {
	NewUserBean nb=null;
	
	public NewUserBean getUserDetails(long accno, String uname, String pwd)
	{
		try {
			
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from userdetails where accountno=? AND username=? AND password=?");
			ps.setLong(1, accno);
			ps.setString(2, uname);
			ps.setString(3, pwd);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				nb=new NewUserBean();
				nb.setUserName(rs.getString(1));
				nb.setAmount(rs.getDouble(3));
				nb.setAccountNo(rs.getLong(6));
				nb.setAddress(rs.getString(4));
				nb.setPhoneNo(rs.getLong(5));
			}
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nb;
	}

}
