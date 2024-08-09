<%@page import="com.nit.bank.Dao.NewUserDao"%>
<%@page import="com.nit.bank.bean.NewUserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance Enquiry</title>
<style type="text/css">

body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f4f4f4;
}

header {
	background-color: #333;
	color: #fff;
	padding: 20px;
	display: flex;
	align-items: center;
	justify-content: space-between;
}

.logo img {
	width: 200px;
	height: auto;
	border-radius: 50%;
}

.title {
	flex-grow: 1;
	text-align: center;
}

header h1 {
	margin: 10px 0 5px;
	font-size: 50px;
}

header p {
	margin: 0;
	font-size: 20px;
}

nav {
	background-color: #444;
	overflow: hidden;
	text-align: center;
	padding: 10px 0;
}

nav a {
	display: inline-block;
	color: #fff;
	text-decoration: none;
	padding: 10px 20px;
}

nav a:hover {
	background-color: #575757;
}

.container {
	/*display: grid;
	grid-template-columns: repeat(3, 1fr);
	padding: 20px;*/
	display: flex;
	align-items: center;
	justify-content: space-between;
}

.box {
	border: 1px solid #ccc;
	padding: 20px;
	/*box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);*/
	background-color: transparent;
}
.section ul li{
	padding: 0;
	list-style: none;
	margin-bottom: 15px;
	text-decoration: none;

}
table {
		width: 100%;
		border-collapse: collapse;
		margin-top: 20px;
	}
	th, td {
		padding: 10px;
		border: 1px solid #ddd;
		text-align: left;
	}
	th {
		background-color: #f2f2f2;
	}
.data {
	padding: 20px;
	width:100%;
	text-align: center;
	}




h1 {
	text-align: center;
}

input[type="text"], input[type="password"], input[type="number"],
	textarea {
	width: 100%;
	padding: 10px;
	margin: 10px 0;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type="submit"] {
	width: 49%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}

.clear-button {
	background-color: #f44336;
}

.clear-button:hover {
	background-color: #e53935;
}

footer {
	background-color: #333;
	color: #fff;
	padding: 20px 0;
	text-align: center;
}

.footer-content {
	display: flex;
	justify-content: space-around;
	max-width: 1200px;
	margin: 0 auto;
}

.footer-section {
	flex: 1;
	padding: 10px;
}

.footer-section h2 {
	margin-bottom: 10px;
}

.footer-section p, .footer-section ul, .footer-section li {
	margin: 0;
	padding: 0;
	list-style: none;
}

.footer-section ul li {
	margin-bottom: 5px;
}

.footer-section ul li a {
	color: #fff;
	text-decoration: none;
}

.footer-section ul li a:hover {
	text-decoration: underline;
}

.footer-bottom {
	background-color: #222;
	color: #ccc;
	padding: 10px;
	margin-top: 20px;
}




</style>
</head>
<body>
<%

NewUserBean ubean=(NewUserBean)application.getAttribute("ubean");
%>

<header>
		<div class="logo">
			<img alt="Reload"
				src="https://static.vecteezy.com/system/resources/previews/013/948/616/non_2x/bank-icon-logo-design-vector.jpg">
		</div>
		<div class="title">
			<h1>Apana-Bank</h1>
			<p>Extra Ordinary Service</p>
		</div>
	</header>
	<nav>
	<a href="index.html">Home</a> 
		<a href="newAccount.html">New Account</a> <a
			href="balanceEnquiry.html">Balance Enquiry</a> <a
			href="deposite.html">Deposite</a> <a href="withdraw.html">Withdraw</a>
		<a href="transfer.html">Transfer Money</a> <a href="accountclose.html">Account
			Close</a> <a href="about.html">About us</a>
	</nav>
	<div class="container">
	<div class="box section">
			<h3>Services</h3>
			<ul>
				<li>Trade Finance & Forex Services</li>
				<li>Insurance / Mutual Fund</li>
				<li>Apna Rupay Debit Card</li>
				<li>Safe Deposite Lockers</li>
				<li>NGRTGS/NEFT</li>
				<li>Mobile Banking IMPS</li>
			</ul>
		</div>
	
	<div class="box data">
<table>

<tr>
<th>Account Number</th>
<th>User Name</th>
<th>Amount</th>
<th>Address</th>
<th>Phone Number</th>
</tr>
<tr>
<td><%=ubean.getAccountNo() %></td>
<td><%=ubean.getUserName() %></td>

<td><%=ubean.getAmount() %></td>
<td><%=ubean.getAddress() %></td>
<td><%=ubean.getPhoneNo() %></td>

</tr>
</table>
</div>
</div>
<footer>
		<div class="footer-content">
			<div class="footer-section about">
				<h2>Description</h2>
				<p>Apana-Bank is committed to delivering extraordinary services
					to its customers with innovative banking solutions.</p>
			</div>
			<div class="footer-section links">
				<h2>Quick Links</h2>
				<ul>
					<li><a href="https://www.apnabank.co.in/services/">Services</a></li>
					<li><a
						href="https://www.apnabank.co.in/interestrates.php?category=LOANSbalanceEnquiry.html">Interest
							Rate-Loan</a></li>
					<li><a href="https://www.apnabank.co.in/privacy.php">Privacy
							Policy</a></li>
				</ul>
			</div>
			<div class="footer-section contact">
				<h2>Contact Us</h2>
				<p>Email: support@apanabank.com</p>
				<p>Phone: +123 456 7890</p>
				<p>Address: Apna Bank Bhavan Dr. S.S.Rao Road, Lalbaug, Parel,
					Mumbai 400012</p>
			</div>
		</div>
		<div class="footer-bottom">&copy; 2024 Apana-Bank. All rights
			reserved.</div>
	</footer>

</body>
</html>