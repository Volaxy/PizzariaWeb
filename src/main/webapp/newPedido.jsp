<%@page import="br.com.etaure.daos.ClienteDAO"%>
<%@page import="br.com.etaure.entities.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
List<Cliente> clientes = ClienteDAO.findAll();
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="styles/style.css">
<link rel="stylesheet" href="styles/newPedido.css">

<link rel="shortcut icon" href="images/pizza.ico" type="image/x-icon">
<title>Novo Pedido</title>
</head>
<body>
	<form action="addPedido" name="pedidoForm">
		<label for="delivery">Tipo de Entrega</label> <select id="delivery"
			name="entrega">
			<option value="1">Entrega</option>
			<option value="2">Presencial</option>
		</select> <label for="payment">Tipo de Pagamento</label> <select id="payment"
			name="pagamento">
			<option value="1">Dinheiro</option>
			<option value="2">Cartão</option>
		</select> <label for="price">Preço</label> <input id="price" type="number"
			name="preco" min="0" placeholder="R$"> <label for="idCliente">Id
			do Cliente</label> <select id="idCliente" name="idCliente">
			<%
			for (Cliente cliente : clientes) {
			%>
				<option value="<%= cliente.getId() %>"><%= cliente.getId() %></option>
			<%
			}
			%>
		</select> <input class="addPedido" type="button" value="Adicionar"
			onclick="validar()">
	</form>

	<script src="scripts/validadorPedido.js"></script>
</body>
</html>