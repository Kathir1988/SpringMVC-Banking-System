<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
 <%@ page import="java.util.*" %>
 <%@ page import="com.bank.entity.Transaction" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<jsp:include page="Head.jsp"/>
<title>Search</title>

<script type="text/javascript">
	$(document).ready(function(){
		$('#export').datepicker({dateFormat:'yy/mm/dd'});
	    $('.datepicker').datepicker();
	});
</script>
</head>

<body>

<div class="row">
	<div class="navbar navbar-invserse">
		<div class="container-fluid">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#" class="active">Welcome ${customername}</a></li>
				<li><a href="Logout" class="glyphicon glyphicon-log-out">logout</a></li>
			</ul>
		</div>
	</div>
</div>
<div class="container-fluid">
	<div class="row">
		<form action="export" class="from-vertical" method="get">
			<div class="col-md-12">
				<a href="view" class="btn btn-warning">Back</a>		
			</div>
			<div class="col-md-12">
				<div class="form-group">
					<label for="Date">Select date:</label>
					<input type="text" name="export" class="form-control" id="export" placeholder="Select date" required>
				</div>
			</div>
			<div class="col-md-12">
				<input type="submit" class="btn btn-primary" value="Search">
			</div>
		</form>
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
						ArrayList<Transaction> list = new ArrayList<Transaction>();
						list = (ArrayList<Transaction>) request.getAttribute("transactions");
						for(Transaction tr : list){
							String s = tr.getTrans_type();
							if(s.equalsIgnoreCase("dr")){
					%>		<tr class="danger">
								<td><%=tr.getTrans_date() %></td>
								<td><%=tr.getTrans_amount() %></td>
								<td><%=tr.getTrans_name() %></td>
							</tr>
					<%
							}						
						else
						{
					%>
							<tr class="success">
								<td><%=tr.getTrans_date() %></td>
								<td><%=tr.getTrans_amount() %></td>
								<td><%=tr.getTrans_name() %></td>
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