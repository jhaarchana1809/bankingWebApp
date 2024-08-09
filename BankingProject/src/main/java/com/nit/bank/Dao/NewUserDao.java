package com.nit.bank.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nit.bank.bean.NewUserBean;
import com.nit.bank.connection.DBConnection;

public class NewUserDao {
	static Connection con = null;
	int k = 0;
	
	public int addUser(NewUserBean ub) {
		try {
			con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into userdetails values(?,?,?,?,?,?)");
			ps.setString(1, ub.getUserName());
			ps.setString(2, ub.getPassword());
			ps.setDouble(3, ub.getAmount());
			ps.setString(4, ub.getAddress());
			ps.setLong(5, ub.getPhoneNo());
			
			ps.setLong(6, ub.getAccountNo());
			k = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;

	}

}