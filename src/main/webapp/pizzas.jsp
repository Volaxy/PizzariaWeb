<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>
<%@ page import="br.com.etaure.entities.Pizza" %>
<%@ page import="java.util.ArrayList" %>
<%
	List<Pizza> pizzas = (ArrayList<Pizza>) request.getAttribute("pizzas");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link rel="stylesheet" href="styles/style.css">
	<link rel="stylesheet" href="styles/pizzas.css">
	
	<link rel="shortcut icon" href="images/pizza.ico" type="image/x-icon">
	<title>Pizzas</title>
</head>
<body>
	<table class="tablePedidos">
		<caption>Pedidos</caption>

		<thead>
			<tr>
				<th>Nº</th>
				<th>Entrega</th>
				<th>Pagamento</th>
				<th>R$</th>
				<th>Cliente</th>
			</tr>
		</thead>

		<tbody>
			<tr>
				<td>1</td>
				<td>Presencial</td>
				<td>Dinheiro</td>
				<td>20,00</td>
				<td>Ana Maria</td>
			</tr>
		</tbody>
	</table>

	<div class="div__pizzas">
		<table class="tablePizzas">
			<caption>Pizzas</caption>
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Tamanho</th>
					<th>R$</th>
				</tr>
			</thead>
			<tbody>
				<% for(Pizza pizza : pizzas) { %>
					<tr>
						<td><%= pizza.getId() %></td>
						<td><%= pizza.getDescricao() %></td>
						<td><%= pizza.getTamanho() %></td>
						<td><%= pizza.getPreco() %></td>
						<td> <a class="div__pizzas__update button__link" href="updatePizza?id=<%= pizza.getId() %>">Atualizar</a> </td>
						<td> <a class="div__pizzas__delete button__link" href="javascript: confirmarExclusao(<%= pizza.getId() %>)">Excluir</a> </td>
					</tr>
				<% } %>
			</tbody>
		</table>

		<a class="div__pizzas__add button__link" href="newPizza.html">Adicionar Pizza</a>
	</div>

	<script src="scripts/confirmador.js"></script>
</body>
</html>