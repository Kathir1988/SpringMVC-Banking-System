<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="Head.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Debit</title>
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
	//document.getElementById("trans_month").value = mm;
	document.getElementById("trans_time").value = time;
	//document.write("Current Time is: "+time);
}
	/* function getDateInfo(){
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth()+1; // Month start from 0.
		var yyyy = today.getFullYear();
		var time = today.getTime();
		if(dd<10){dd='0'+dd} if(mm<10){mm='0'+mm}
		today = yyyy+"/"+mm+"/"+dd;
		document.getElementById("trans_date").value = today;
		//document.getElementById("trans_month").vaue = mm;
		document.getElementById("trans_time").value = time;	
	} */
</script>
<div class="container-fluid">
		<div class ="row">
			<div class="col-md-12">
				<a href="view" class="btn btn-warning">Back</a>
			</div>
		</div>
	<div class="row">
	<form action="transaction" class="form-vertical" method="post">
		<div class="col-md-12">
			<h3>Debit Transaction</h3>
			
				<div class="form-group">
					<label for="Debit Amount">Debit Amount</label>
					<input type="text" class="form-control" name="trans_amount" id="trans_amount" placeholder="Amount" required> 
				</div>
				<div class="form-group">
					<label for="Comment">Comment:</label>
					<input type="text" class="form-control" name="trans_name"  id="trans_name"  placeholder="Comment" required>
				</div>			
		</div>
		<div class="col-md-12">
			<div class="form-group">
				<input type="submit" class="btn btn-success" value="Debit" onload="getDateInfo()"> 
			</div>
		</div>
		<div class="col-md-12">
			<div class="form-group">
				<input type="hidden" class="form-control" name="trans_type" value="dr" id="trans_type">
			</div>
			<div class="form-group">
				<input type="hidden" class="form-control" name="trans_typedef" value="Amount is Debited" id="trans_typedef">
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