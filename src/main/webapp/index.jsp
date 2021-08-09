<%@page import="com.ecw.services.impl.OrderDetailServiceImpl"%>
<%@page import="com.ecw.services.OrderDetailsService"%>
<%@page import="com.ecw.model.OrderDetail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%
Random randomGenerator = new Random();
int randomInt = randomGenerator.nextInt(1000000);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Merchant Check Out Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR" content="Evrsoft First Page">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
</head>
<body>

	<%
OrderDetailsService orderService = new OrderDetailServiceImpl();
OrderDetail order = orderService.getOrderDetailById(15);

%>

	<h1>Merchant Check Out Page</h1>
	<pre>
	</pre>
	<form method="post" action="pgRedirect.jsp">
		<table border="1">
			<tbody>
				<tr>
					<th>S.No</th>
					<th>Label</th>
					<th>Value</th>
				</tr>
				<tr>
					<td>1</td>
					<td><label>ORDER_ID::*</label></td>
					<td><input id="ORDER_ID" tabindex="1" maxlength="20" size="20"
						name="ORDER_ID" autocomplete="off"
						value="ORDS_<%=order.getOrderId()%>"></td>
				</tr>
				<tr>
					<td>2</td>
					<td><label>CUSTID ::*</label></td>
					<td><input id="CUST_ID" tabindex="2" maxlength="30" size="12"
						name="CUST_ID" autocomplete="off"
						value=<%=order.getUser().getUserId()%>></td>
				</tr>
				<tr>
					<td>3</td>
					<td><label>INDUSTRY_TYPE_ID ::*</label></td>
					<td><input id="INDUSTRY_TYPE_ID" tabindex="4" maxlength="12"
						size="12" name="INDUSTRY_TYPE_ID" autocomplete="off"
						value="Retail"></td>
				</tr>
				<tr>
					<td>4</td>
					<td><label>Channel ::*</label></td>
					<td><input id="CHANNEL_ID" tabindex="4" maxlength="12"
						size="12" name="CHANNEL_ID" autocomplete="off" value="WEB">
					</td>
				</tr>
				<tr>
					<td>5</td>
					<td><label>txnAmount*</label></td>
					<td><input title="TXN_AMOUNT" tabindex="10" type="text"
						name="TXN_AMOUNT" value=<%=order.getAmount()%>></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><input value="CheckOut" type="submit" onclick=""></td>
				</tr>

			</tbody>

		</table>
		* - Mandatory Fields
	</form>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
		crossorigin="anonymous"></script>
</body>
</html>