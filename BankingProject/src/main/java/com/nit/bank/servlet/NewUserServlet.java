package com.nit.bank.servlet;

import java.io.IOException;

import com.nit.bank.Dao.NewUserDao;
import com.nit.bank.bean.NewUserBean;
import com.nit.bank.connection.DBConnection;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Reg")
public class NewUserServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		NewUserBean ubean=new NewUserBean();
		ubean.setUserName(req.getParameter("name"));
		ubean.setPassword(req.getParameter("repassword"));
		ubean.setAddress(req.getParameter("address"));
		ubean.setAmount(Double.parseDouble(req.getParameter("amount")));
		ubean.setPhoneNo(Long.parseLong(req.getParameter("phone")));
		ubean.setAccountNo((long)(Math.random()*10000000000L));
		int k=new NewUserDao().addUser(ubean);
		if(k>0)
		{
			ServletContext sct=req.getServletContext();
		sct.setAttribute("ubean", ubean);
		
		
			req.setAttribute("msg", "Account Created...");
			req.getRequestDispatcher("accountCreated.jsp").forward(req, resp);
		}
		
		
	}

}
