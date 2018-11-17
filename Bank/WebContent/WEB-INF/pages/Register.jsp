<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Head.jsp"/>
<!-- CSS file included for style -->
<link rel="stylesheet" href="resources/demo/style.css">
<!-- Jquery Validation -->
<script type="text/javascript" src="resources/demo/jquery_form_validation.js"></script>
<!-- Email Availability Check -->
<script type="text/javascript" src="resources/demo/register.js"></script>
<!-- Jquery CDN -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<form action="saveRegister" class="form-vertical" method="post">
			<div class="col-md-7">
				<h3>Welcome to our site registration</h3>
				
					<p class="text-justify">
						Anything that customers purchases affects environment by means of delivery, 
						whether they have the product shipped at home or drive to a brick and mortar store(supermarket). 
						In earlier days people used to go to different shops before purchasing as they didn’t have a great deal of 
						easy access to information on products. Due to the development of World Wide Web
						 it has now become easy to access the products available worldwide without wasting time, 
						 money and other resources apart from helping environment. 
						 Centre for Energy and Climate Solutions suggests that we can protect land and save energy by shopping online. 
					</p>
			</div>
			<div class="col-md-4">
				<div class="row">
					<div class="col-md-6">
						<h4 class="text-left">Registration</h4>
					</div>
					<div class="col-md-6">
						<span class="glyphicon glyphicon-pencil"></span>
					</div>
				</div>
				<hr>
				
					<div class="row">
						<div class="form-group">
							<label class="label col-md-3 label-control">Name</label>
							<div class="col-md-9">
								<input type="text" name="name" class="form-control" id="form_name" placeholder="Name" required>
								<span class="error_form" id="name_error_message"></span>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label class="label col-md-3 label-control">Username</label>
							<div class="col-md-9">
								<input type="text" name="username" class="form-control" id="form_username" placeholder="Username" required>
								<span class="error_form" id="username_error_message"></span>
								<span id="check_username_availability"></span>
							</div>
						</div>						
					</div>
					<div class="row">
						<div class="form-group">
							<label class="label col-md-3 label-control">Password</label>
							<div class="col-md-9">
								<input type="password" name="password" class="form-control" id="form_password" placeholder="Password" required>
								<span class="error_form" id="password_error_message"></span>
							</div>
						</div>						
					</div>
					<div class="row">
						<div class="form-group">
							<label class="label col-md-3 label-control">R-Password</label>
							<div class="col-md-9">
								<input type="password" name=confirm_password class="form-control" id="form_confirm_password" placeholder="Confirm Password" required>
								<span class="error_form" id="confirm_password_error_message"></span>
							</div>
						</div>						
					</div>
					<div class="row">
						<div class="form-group">
							<label class="label col-md-3 label-control">E-mail</label>
							<div class="col-md-9">
								<input type="email" name="email" class="form-control" id="form_email" placeholder="E-Mail" required>
								<span class="error_form" id="email_error_message"></span>
							</div>
						</div>						
					</div>
					<br>
					<div class="row">
						<div class="form-group">
							<!-- CheckEmail Availability find on *** register.js ***  -->
							<div class="col-md-offset-3 col-md-6">
								<button class="btn btn-success" id="check_email">Check Availability!</button>
							</div>
							<div class="col-md-3">
								<p><span id="check_email_message"></span></p>
								<!-- <p><span id="check_username_message"></span></p> -->
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<div class="col-md-offset-3 col-md-3">
								<input type="submit" class="btn btn-primary" value="Register">
							</div>
							<div class="col-md-6">
								<a href="signin" class="btn btn-warning" id="login">Back to Login</a>
							</div>
						</div>
					</div>		
			</div>
		</form>
	</div>
	
</div>
</body>
</html>