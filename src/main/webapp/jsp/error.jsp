<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isErrorPage = "true"%>
<!DOCTYPE html>
<html>
<head>
<title>Error Page</title>
</head>
<body>
	<h2>Application error, please contact support.</h2>
	<h3>Debug Information:</h3>
	Requested URL = ${url}<br/><br/>
	Exception = ${expection.message}<br/><br/>
	<h2>${obj1}</h2>
	<h2>${obj2}</h2>
	<!-- 
	<strong>Exception Stack Trace</strong>
	<c:forEach items="${exception.stackTrace}" var="stc">
		${stc}
	</c:forEach>
	 -->
</body>
</html>