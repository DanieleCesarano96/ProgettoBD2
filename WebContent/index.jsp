<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="mongodb.*" %>
<%
	ConnectToDB connect=new ConnectToDB();
	if(connect.Connessione())
		System.out.println("Tutto apposto");
	else
		System.out.println("Nessuna connessione");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>

<body>

</body>
</html>