<%@ page isELIgnored="false" %>
<!DOCTYPE html>  
<html>
<head>
	<title>Login Form</title>    
    <link rel="stylesheet" type="text/css" href="css/styles.css">
 	<script type="text/javascript">

			function checkInvalid(){
				if("${username}"==="invalid"){
					console.log("${username}");
					var label = document.getElementById('invalidtag')
					label.innerHTML = "invalid credentials !!";
				}

			}
		
	</script>
 	
</head>


<body onload="checkInvalid()">
	<div id="login">
		<h2 id="ltag">Login</h2>
		<label style="margin-left:450px; color:red;" id="invalidtag"></label>
		<form action="Login" id="loginform" method="post">
			<label style="margin-left:8px" for="uname">Username</label>
			<span style="color:red; margin-left:40px">*</span> <input style="margin-left:20px" type="text" name="uname" id="uname"><br><br>
			<label style="margin-left:8px" for="pwd">Password</label>
			<span style="color:red; margin-left:44px">*</span><input style="margin-left:22px" type="password" name="pwd" id="pwd" placeholder=""><br><br>
			<div style="background-color:#4DC7C7; width:600px; margin-top:8px">
				<input id="sbutton" type="submit" value="Login">
			</div>
		</form>
	</div>
	
	
</body>
</html>
