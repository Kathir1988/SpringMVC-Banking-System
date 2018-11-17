$(document).ready(function() {
	
	$("#name_error_message").hide();
	$("#username_error_message").hide();
	$("#password_error_message").hide();
	$("#confirm_password_error_message").hide();
	$("#email_error_message").hide();
		
	
	var error_name = false;
	var error_username = false;
	var error_password = false;
	var error_confirm_password = false;
	var error_email = false;	
	
	$("#form_name").focusout(function(){
		check_name();
	});
	$("#form_username").focusout(function(){
		check_username();
	});
	$("#form_password").focusout(function(){
		check_password();
	});
	$("#form_confirm_password").focusout(function(){
		check_confirm_password();
	});
	$("#form_email").focusout(function(){
		check_email();
	});
	
	
	function check_name(){
		var pattern = /^[a-zA-Z]*$/;
		var name = $("#form_name").val();
		if(name == ''){
			$("#name_error_message").html("Enter your name");
			$("#name_error_message").show();
			$("#form_name").css("border-bottom", "2px solid #F90A0A");
			return error_name = true;

		}
		else if(pattern.test(name)){
			$("#name_error_message").hide();
			$("#form_name").css("border-bottom", "2px solid #34F458");
		}
		else {
			$("#name_error_message").html("should contain only character");
			$("#name_error_message").show();
			$("#form_name").css("border-bottom", "2px solid #F90A0A");
			return error_name = true;
		}
	}
	function check_username(){
		var pattern = /^(?=.*\d).{5,12}$/;
		var username = $("#form_username").val();
		if(username == ''){
			$("#username_error_message").html("Enter the username");
			$("#username_error_message").show();
			$("#form_username").css("border-bottom","2px solid #F90A0A");
			return error_username = true;

		}

		else if(pattern.test(username)){
			$("#username_error_message").hide();
			$("#form_username").css("border-bottom","2px solid #34F458");
		}
		else{
			$("#username_error_message").html("username contain any char, max 2 digit & No special char are not allowed");
			$("#username_error_message").show();
			$("#form_username").css("border-bottom","2px solid #F90A0A");
			return error_username = true;
		}
	}
	function check_password(){
		var pattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{5,12}/;
		var password = $("#form_password").val();
		if(password == ''){
			$("#password_error_message").html("Enter the password");
			$("#password_error_message").show();
			$("#form_password").css("border-bottom","2px solid #F90A0A");
			return error_password = true;

		}
		else if(pattern.test(password)){
			$("#password_error_message").hide();
			$("#form_password").css("border-bottom", "2px solid #34F458");
		}
		else{
			$("#password_error_message").html("password must be 1 special char,1 number & 1 char")
			$("#password_error_message").show();
			$("#form_password").css("border-bottom","2px solid #F90A0A");
			return error_password = true;
		}		
	}
	function check_confirm_password(){
		var password = $("#form_password").val();
		var confirm_password = $("#form_confirm_password").val();
		if(confirm_password == ''){
			$("#confirm_password_error_message").html("Enter the confirm-password");
			$("#confirm_password_error_message").show();
			$("#form_confirm_password").css("border-bottom", "2px solid #F90A0A");
			return error_confirm_password = true;
		}
		else if(password == confirm_password){
			$("#confirm_password_error_message").hide();
			$("#form_confirm_password").css("border-bottom","2px solid #34F458");
		}
		else{
			$("#confirm_password_error_message").html("password not matched");
			$("#confirm_password_error_message").show();
			$("#form_confirm_password").css("border-bottom", "2px solid #F90A0A");
			return confirm_password = true;
		}
	}
	function check_email(){
		var pattern = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/;
		var email = $("#form_email").val();
		if(email == ''){
			$("#email_error_message").html("Enter your Mail-id");
			$("#email_error_message").show();
			$("#form_email").css("border-bottom","2px solid #F90A0A");	
			return error_email=true;
		}
		else if(pattern.test(email)){
			$("#email_error_message").hide();
			$("#form_email").css("border-bottom","2px solid #34F458");
		}
		else {
			$("#email_error_message").html("In-valid email id");
			$("#email_error_message").show();
			$("#form_email").css("border-bottom","2px solid #F90A0A");
			return error_email=true;
		}
	}
	
});
