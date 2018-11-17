<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="Head.jsp"/>
<title>Credit</title>
</head>
<body onload="getDateInfo()">
	<script>
		function getDateInfo(){
			var today = new Date();
			var dd = today.getDate();
			var mm = today.getMonth()+1; //Month start from 0.
			var yyyy = today.getFullYear();
			var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
			today = yyyy+"/"+mm+"/"+dd;
			document.getElementById("trans_date").value = today;
			//document.getElementById("trans_month").vaue = mm;
			document.getElementById("trans_time").value = time;
			//document.write("Current Time is: "+time);
		}
		
		
	</script>
	<div class="container-fluid">
		<div class ="row">
			<div class="col-md-12">
				<a href="view" class="btn btn-warning">Back</a>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<h3>Credit Transactions</h3>
			</div>
			<form action="transaction" class="form-vertical" method="post">
				<div class="col-md-12">
					<div class=="form-group">
						<label for="Credit Amount">Credit Amount:</label>
						<input type="text" name="trans_amount" class="form-control" id="trans_amount" placeholder="Credit Amount" required>
					</div>
					<div class="form-group">
						<label for="Comment">Comment</label>
						<input type="text" name="trans_name" class="form-control" id="trans_name" placeholder="Comment" required>
					</div>
				</div>
				<div class="col-md-12">
					<input type="submit" class="btn btn-success" value="Credit" onload="getDateInfo()">
				</div>
				<div class="col-12-md">
					<div class="form-group">
						<input type="hidden" class="form-control" name="trans_type" id="trans_type" value="cr">
					</div>
					<div class="form-group">
						<input type="hidden" class="form-control" name="trans_typedef" id="trans_typedef" value="Amount is credited">
					</div>
					<div class="form-group">
						<input type="hidden" class="form-control" name="trans_date" id="trans_date">
					</div>
					<div class="form-group">
						<input type="hidden" class="form-control" name="trans_time" id="trans_time">
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>