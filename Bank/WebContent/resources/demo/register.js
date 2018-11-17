//1.To Check Email Availability using Jquery Ajax call
$(document).ready(function(){
		//alert("Welcome to Registeration");
		//var email = document.reg.email.value;
		$("#check_email").click(function(){
			//alert("Button Cliked!!!");
			$.ajax({
				url : 'checkEmail',
				data : {"email" : $("#form_email").val()},
				success : function(data){
					$("#check_email_message").html(data);
				}			
			});
		});
	});

//2.To Check username Availability using Jquery Ajax call
$(document).ready(function(){
	
	$("#form_username").focusout(function(){
		checkUsernameExist();
	});
	function checkUsernameExist(){
		//alert("Check Username Exist!!!")
		//var username = $("#form_username").val();
		$.ajax({
				url : 'checkUsername',
				data : {"username" : $("#form_username").val()},
				success : function(data){
					$("#check_username_availability").html(data);
				}			
			});					
	}
});