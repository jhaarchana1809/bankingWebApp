package com.nit.bank.servlet;

import java.io.IOException;

import com.nit.bank.Dao.AccountDetailsDao;
import com.nit.bank.Dao.BalanceEnquiryDao;
import com.nit.bank.Dao.UpdateAmountDao;
import com.nit.bank.bean.NewUserBean;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/transfer")
public class TransferMoneyServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long accno=Long.parseLong(req.getParameter("accno"));
		long taccno=Long.parseLong(req.getParameter("taccno"));
		String uname=req.getParameter("uname");
		String password=req.getParameter("password");
		
		NewUserBean nb=new BalanceEnquiryDao().getUserDetails(accno, uname, password);
		NewUserBean tnb=new AccountDetailsDao().getUserDetails(taccno);
		if(nb==null)
		{
			req.setAttribute("msg", "Invalid username or password!!");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
		else if(tnb==null)
		{
			req.setAttribute("msg", "Target account does not exits...");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);

		}
		else
		{
			double amount=Double.parseDouble(req.getParameter("amount"));
			nb.setAmount(nb.getAmount()-amount);
			tnb.setAmount(tnb.getAmount()+amount);
			UpdateAmountDao.updateAmount(accno, nb.getAmount());
			UpdateAmountDao.updateAmount(taccno, tnb.getAmount());
			ServletContext sct=req.getServletContext();
			sct.setAttribute("ubean", nb);
			sct.setAttribute("tubean", tnb);
			req.setAttribute("amount", amount);
			req.setAttribute("msg", "Money Transferd Successfully...");
			req.getRequestDispatcher("MoneyTransfer.jsp").forward(req, resp);
			
		}

	}
	

}
