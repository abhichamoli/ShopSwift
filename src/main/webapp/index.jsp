<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.nagarro.eshopping.model.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>home page</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script src="validation.js"></script>
<style>
#ptable {
	width: 100%;
	margin-top: 50px;
	border-collapse: collapse;
	z-index:3;
}

#header{
	z-index:-1;
}

table, td, th {
	border: 1px solid black;
	text-align: center;
}
</style>

<script type="text/javascript">

function validateImageAndSize() {
	    var formData = new FormData(); 
	    var file = document.getElementById("image").files[0]; 
	    formData.append("Filedata", file);
	    
	    var t = file.type.split('/').pop().toLowerCase(); 
	    if (t != "jpeg" && t != "jpg" && t != "png" && t!="jfif") {
	        alert('Please select a valid image file');
	        document.getElementById("image").value = ''; 
	        return false; 
	    } 
	    
	    var fsize = (file.size / 1024 / 1024).toFixed(2); 
	    if (fsize > 1 ) {
	        alert('Max Upload size is 1MB only'); 
	        document.getElementById("image").value = ''; 
	        return false; 
	    } 

	    if (${totalsize}+fsize>10){
	    	 alert('Total uploadsize cannot excced 10 MB'); 
	    	 return false;
		}

	    return true;
	}



</script>


</head>
<body>

	<%
		if(session.getAttribute("username")==null){
			
			response.sendRedirect("signin.jsp");
		}
		
	%>

	<div id=header>
		<div id="pheading">Product Management Tool</div>
		<div id="usergreeting">Hi! ${username}</div>
		<form action="Logout" method="post">
			<input type="submit" value="logout" id="logoutbtn">
		</form>

	</div>


	<h3 style="margin-top: 100px">Please enter product detail to add
		to stock</h3>

	<form action="Product" method="post" id="pform"
		onsubmit="return validate()" name="pform"
		enctype="multipart/form-data">

		<label for="title">Title</label> <input style="margin-left: 43px"
			type="text" name="title" id="title" /><br>
		<br> <label for="quantity">Quantity</label> <input
			style="margin-left: 18px" type="text" name="quantity" id="quantity" /><br>
		<br> <label for="size">Size</label> <input
			style="margin-left: 46px" type="text" name="size" id="size" /><br>
		<br> <label>Image</label> <input style="margin-left: 33px"
			type="file" value="browse" name="image" id="image" onchange="validateImageAndSize()" accept="image/*"/> <br>
		<br> <input style="margin-left: 100px" type="submit" />

	</form>

	<table id="ptable">
		<tr>
			<th>S.NO</th>
			<th>Title</th>
			<th>quantity</th>
			<th>size</th>
			<th>image</th>
			<th>Actions</th>
		</tr>

		<% int sno=1; %>

		<c:forEach items="${sessionScope.plist}" var="product">
			<tr>
				<td><%=sno%></td>
				<td><c:out value="${product.getTitle()}" /></td>
				<td><c:out value="${product.getQuantity()}" /></td>
				<td><c:out value="${product.getSize()}" /></td>
				<td><img src="<c:out value="${product.getImageurl()}"/>"
					height='80' width='80' /></td>
				<td>
					<div style="margin-left: 20px">
						<form style="float: left" action="EditItem.jsp" method="post">
							<input type="hidden" value="${product.getS_no()}" name="sno"
								id="sno">
							<button type="submit">
								<img height='20' width='20'
									src="<c:out value='images/edit.png'/>" />
							</button>

						</form>

						<form style="float: left margin-left:50px" action="DeleteItem"
							method="post">
							<input type="hidden" value="${product.getS_no()}" name="sno"
								id="sno">
							<button type="submit">
								<img height='20' width='20'
									src="<c:out value='images/delete.jpg'/>" />
							</button>
						</form>
					</div>
				</td>
			</tr>

			<% sno += 1; %>

		</c:forEach>


	</table>
	
	<div style="color:red; margin-top:15px">TotalItems = ${totalitems}</div>
	<div style="color:red; margin-top:5px;">TotalSize = ${totalsize} MB</div>
	

</body>
</html>