<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pedido = (String) request.getAttribute("pedido");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Novos pedidos</title>
</head>
<body>
	<h1>Novos Pedidos</h1>
	<pre>
		<%= pedido %>
	</pre>
</body>
</html>