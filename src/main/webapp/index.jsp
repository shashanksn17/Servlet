<%@page import="java.time.LocalDateTime"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hii Hello</h1>
<% System.out.println("Hi Hello this is SYsout96");%>

<%! String a= "Hey Cool!!"; %>
<%=a %>
<% LocalDateTime.now(); %>
</body>
</html>