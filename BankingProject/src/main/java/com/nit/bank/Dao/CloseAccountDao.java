package com.nit.bank.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.nit.bank.connection.DBConnection;

public class CloseAccountDao {
	
		public static void closeAccount(long phno)
	{
		try {
			
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from userdetails where phoneno=?");
			ps.setLong(1, phno);
			int k=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	}

}
