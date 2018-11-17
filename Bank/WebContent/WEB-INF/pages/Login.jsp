<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
  <!-- ttttttt --> 
<!DOCTYPE html>
<html>
<head>
<style>
*{
	margin: 0px;
	padding: 0px;
}
body{
	background-image: url(log.jpeg);
	background-size: cover;
	background-attachment: fixed;
}
	.col-md-6{
		margin-top: 20px;
		color:fuchsia;
	}
	.glyphicon-pencil{
		margin-top: 35px;
		font-size:17px;
		color:fuchsia;
	}
	.col-md-3{
	margin-top: 10px;
	margin-bottom: 10px;
	}

	.col-md-9{
	margin-top: 10px;
	margin-bottom: 10px;
	}
	col-md-offset-3{
	margin-top: 30px;
	margin-bottom: 30px;
	}
	#center{
	margin-left: 400px;
	}
	#label{
	color: navy;
	font-size: 17px;
	margin-top: 15px;
	}
</style>
<jsp:include page="Head.jsp"/>
</head>
<!-- <body 	style="background-image: url(log.jpeg)"> -->
<body>
	<div class="container-fluid">
		<div class="row">
			<form action="checkLogin" class="form-vertical" method="post">
				<div class="col-md-offset-4"></div>
				<div class="col-md-4" id="center">
					<div class="row">
						<div class="col-md-6">
							<h1 class="text-right">Login</h1>
						</div>
						<div class="text-right col-md-6">
							<span class="glyphicon glyphicon-pencil"></span>
						</div>
					</div> <hr>
					<h6 style="color:red; font-size:17px" align="center">
							<c:if test="${not empty login_failed}">${login_failed}</c:if>
					</h6>
					<div class="row">
						<label class="label col-md-3 label-control" id="label" >Username</label>
						<div class="col-md-9">
							<div class="form-group input-group">
								<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
								<input type="text" name="username" id="username" class="form-control" placeholder="Username">
							</div>
						</div>
					</div>
					<div class="row">
						<label class="label col-md-3 label-control" id="label">Password</label>
						<div class="col-md-9">
							<div class="form-group input-group">
								<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
								<input type="password" name="password" id="password" class="form-control" placeholder="Password">
							</div>	
							<label><input type="checkbox">Remember me</label>						
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-offset-3 col-md-4">
							<input type="submit" class="btn btn-primary" value="Sign-in">
						</div>
						<div class="col-md-5">
							<a href="addCustomer">New Customer?</a>
						</div>
					</div>
				</div>
				<div class="col-md-offset-4"></div>
			</form>
		</div>
	</div>

</body>
</html>