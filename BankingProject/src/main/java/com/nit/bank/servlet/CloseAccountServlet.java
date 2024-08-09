package com.nit.bank.servlet;

import java.io.IOException;

import com.nit.bank.Dao.BalanceEnquiryDao;
import com.nit.bank.Dao.CloseAccountDao;
import com.nit.bank.bean.NewUserBean;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/closeaccount")
public class CloseAccountServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		long accno=Long.parseLong(req.getParameter("accno"));
		String uname=req.getParameter("uname");
		String password=req.getParameter("password");
		
		NewUserBean nb=new BalanceEnquiryDao().getUserDetails(accno, uname, password);
		
		System.out.println(nb);
		if(nb==null)
		{
			req.setAttribute("msg", "Invalid username or password!!");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
		else
		{
			CloseAccountDao.closeAccount(nb.getPhoneNo());
			req.setAttribute("msg", "Account has been closed!!");
			System.out.println(req.getAttribute("msg"));
			req.getRequestDispatcher("msg.jsp").forward(req, resp);

			
			
		}
	
	}

}
