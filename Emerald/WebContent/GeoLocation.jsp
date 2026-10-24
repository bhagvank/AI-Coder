<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<button onclick="getLocation()">Get Location</button>
<span id="latitude"> </p>
<script>

var y = document.getElementById("latitude");
function getLocation()
{
	
	//alert("get Location");
   if(navigator.geolocation)
	   {
	     //alert("geolocation");
	      navigator.geolocation.getCurrentPosition(showPosition,errorHandler);
	   }
   else
	   {
	     //alert("not supported");
	     y.innerHTML = "GeoLocation not supported";
	   }
}

function showPosition(position)
{
	//alert("show position");
	
	// y.innerHTML = "position";
	y.innerHTML = "Latitude: "+position.coords.latitude + "<br>Longitude: "+ position.coords.longitude;
	
}

function errorHandler(error)
{
  if(err.code ==1)
	  {
	    alert("access denied");
	  }
 	
}

</script>

</body>
</html>