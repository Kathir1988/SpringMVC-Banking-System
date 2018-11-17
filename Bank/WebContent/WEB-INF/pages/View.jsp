<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bank.entity.Transaction" %>
<%@ page import="java.util.*" %>
<head>
<jsp:include page="Head.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>View</title>
</head>
<body>
	
	<div class="row">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<ul class="nav navbar-nav navbar-right">
					<li><a class="active" href="">Welcome ${customername}</a></li>
					<li><a href="logout"><span class="glyphicon glyphicon-log-out">logout</span></a></li>
				</ul>
			</div>
		</nav>
	</div>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<a href="credit" class="btn btn-success">Credit</a>
				<a href="debit" class="btn btn-warning">Debit</a>
				<a href="search" class="btn btn-primary">Search</a>
			</div>
			<div class="col-md-12">
				<div class="pull-right">
				
					<div class="col-md-4">
						<h3>Total Credit: ${datedebits}Rs.</h3>					
					</div>
					<div class="col-md-4">
						<h3>Total Debit: ${monthdebits}Rs.</h3>
												  
					</div>
					
					<div class="col-md-4">
						<h3 class="text-success">Current Balance: ${balance}Rs.</h3>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table">
					<thead>
						<tr>
							<th>Date</th>
							<th>Amount</th>
							<th>Description</th>
						</tr>
					</thead>
					<tbody>
						<%
							ArrayList<Transaction> list = new ArrayList();
							list = (ArrayList<Transaction>) request.getAttribute("transactions");
							for(Transaction tr : list){
								String s = tr.getTrans_type();
								if(s.equalsIgnoreCase("dr")){
								%>
									<tr class="danger">
										<td><%=tr.getTrans_date() %></td>
										<td><%=tr.getTrans_amount() %></td>
										<td><%=tr.getTrans_typedef() %></td>
									</tr>
								
								<% 	
								}
								else{
								%>
									<tr class="success">
										<td><%=tr.getTrans_date() %></td>
										<td><%=tr.getTrans_amount() %></td>
										<td><%=tr.getTrans_typedef() %></td>
									</tr>						
									<%
								}
							}
							
							 %>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>