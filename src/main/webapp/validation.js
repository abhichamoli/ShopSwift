
 	function emptyChecker(value){
 		
 		return value == ""
 	}

 	function AlphaChecker(value){
 		
 		return /^[A-Za-z\s]*$/.test(value);
 	}

 	function numChecker(value){
 		
 		return /^\d+$/.test(value);
 	}



 	function validate(){
 		
 		var title = document.forms["pform"]["title"];
 		var quantity = document.forms["pform"]["quantity"];
 		var size = document.forms["pform"]["size"];
 		
 		if(emptyChecker(title.value)){
 			alert("title cannot be empty!");
 			return false;
 		}
 			
 		if(emptyChecker(quantity.value)){
 			alert("quantity cannot be empty!");
 			return false;
 		}
 			
 		if(emptyChecker(size.value)){
 			alert("size cannot be empty!");
 			return false;
 		}
 		
 		if(!AlphaChecker(title.value)){
 			alert("title can only have alphabets!");
 			return false;
 		}
 		
 		if(!numChecker(quantity.value)){
 			alert("quantity can only have integer values!");
 			return false;
 		}
 		
 		if(!numChecker(size.value)){
 			alert("size can only have integer values!");
 			return false;
 		}

 	}		


 	

function editvalidate(){
	
	var title = document.forms["editform"]["title"];
	var quantity = document.forms["editform"]["quantity"];
	var size = document.forms["editform"]["size"];
	
	
	if(!emptyChecker(title.value)&&!AlphaChecker(title.value)){
		alert("title can only have alphabets!");
		return false;
	}
	
	if(!emptyChecker(quantity.value) && !numChecker(quantity.value)){
		alert("quantity can only have integer values!");
		return false;
	}
	
	if(!emptyChecker(size.value) && !numChecker(size.value)){
		alert("size can only have integer values!");
		return false;
	}
	
}