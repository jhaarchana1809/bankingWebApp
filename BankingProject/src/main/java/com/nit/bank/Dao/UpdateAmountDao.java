package com.nit.bank.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.nit.bank.connection.DBConnection;

public class UpdateAmountDao {
	
	
	public static void updateAmount(long accno, double amount)
	{
		try {
			
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("update userdetails set amount=? where accountno=?");
			ps.setDouble(1, amount);
			ps.setLong(2, accno);
			int k=ps.executeUpdate();
			
			
		} catch (Exception e) {
			
		e.printStackTrace();
		}
		
	}
	

}
