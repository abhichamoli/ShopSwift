<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Items page</title>
<script src="validation.js"></script>

	<style>
		
		#editform{
			position:fixed;
			top:25%;
			left:30%;
			background-color:#B8F3F3;
			border:1px black solid;
		}
	
	</style>

</head>
<body>
	
	<form id="editform" name="editform" action="Edit" method="post" enctype="multipart/form-data" onsubmit="return editvalidate()">
		
		<fieldset>
		
		 <legend>EDIT PRODUCT DETAILS:</legend>
		
		<input type="hidden" value="${param.sno}" name="sno" id="sno">
		<label for="title">Title</label>
		<input style="margin-left:43px" type="text" name="title" id="title"/><br><br>
		<label for="quantity">Quantity</label>
		<input style="margin-left:18px" type="text" name="quantity" id="quantity"/><br><br>
		<label for="size">Size</label>
		<input style="margin-left:46px" type="text" name="size" id="size"/><br><br>
		<label>Image</label>
		<input style="margin-left:33px"type="file" value="browse" name="image" id="image"/>
		<br><br>
		<input	style="margin-left:100px" type="submit" />
	
		</fieldset>
		
	</form>

</body>
</html>