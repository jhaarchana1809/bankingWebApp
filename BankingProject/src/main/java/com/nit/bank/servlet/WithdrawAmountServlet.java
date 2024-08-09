package com.nit.bank.servlet;

import java.io.IOException;

import com.nit.bank.Dao.BalanceEnquiryDao;
import com.nit.bank.Dao.UpdateAmountDao;
import com.nit.bank.bean.NewUserBean;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/withdraw")
public class WithdrawAmountServlet extends HttpServlet{
	
	
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
			double amount=Double.parseDouble(req.getParameter("amount"));
			nb.setAmount(nb.getAmount()-amount);
			
			UpdateAmountDao.updateAmount(accno, nb.getAmount());
			ServletContext sct=req.getServletContext();
			sct.setAttribute("ubean", nb);
			req.setAttribute("amount", amount);
			req.setAttribute("msg", "Amount withdraw successfully...");
			req.getRequestDispatcher("withdraw.jsp").forward(req, resp);
			
		}

	}

}
