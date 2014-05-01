<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html 
     PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
     "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="<c:url value="/styles/springsource.css"/>" type="text/css"/>
    <title>mvc-1-solution: Location Details</title>
</head>

<body>
<div id="main_wrapper">
    <h1>Location Details</h1>
	<table>
	    <tr><td>
	        <table>
	            <tr>
	                <td>Location:</td>
	                <td>${locationDetails.city}</td>
	            </tr>
	        </table>
	    </td></tr>
	</table>
</div>
</body>

</html>