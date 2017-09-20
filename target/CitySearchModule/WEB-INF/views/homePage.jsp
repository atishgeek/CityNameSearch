
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Welcome to City Search</h1>
<br>
Please enter the parameters
<br>
<label> City Name:  </label> <input type="text" id="city"/>
<label> Range:  </label> <input type="text" id="range"/>
<input type="submit" onclick="javascript:getSuggestedCities()" value="Submit"/>

 

</body>
</html>

<script>
function getSuggestedCities(){
	
	var city= document.getElementById('city').value;
	var range= document.getElementById('range').value;
	
	window.location = "suggest_cities?start="+city+"&atmost="+range;
}

</script>