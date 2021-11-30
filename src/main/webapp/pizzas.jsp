<%@page import="br.com.etaure.daos.PedidoDAO"%>
<%@page import="br.com.etaure.entities.dto.PedidoComNomeClienteDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="br.com.etaure.entities.Pizza"%>
<%@ page import="java.util.ArrayList"%>
<%
List<Pizza> pizzas = (ArrayList<Pizza>) request.getAttribute("pizzas");
List<PedidoComNomeClienteDTO> pedidos = (ArrayList<PedidoComNomeClienteDTO>) request.getAttribute("pedidos");
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
<title>Pedidos e Pizzas</title>
</head>
<body>
	<div class="pedidos">
		<!-- Tabela de Pedidos -->
		<table class="tablePedidos">
			<caption>Pedidos</caption>
			<thead>
				<tr>
					<th style="border-top-left-radius: 4px;">Nº</th>
					<th>Entrega</th>
					<th>Pagamento</th>
					<th>R$</th>
					<th style="border-top-right-radius: 4px;">Cliente</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (PedidoComNomeClienteDTO pedido : pedidos) {
				%>
				<tr>
					<td><%=pedido.getId()%></td>
					<td><%=pedido.getTipoPedido()%></td>
					<td><%=pedido.getTipoPagamento()%></td>
					<td><%=pedido.getTotal()%></td>
					<td><%=pedido.getNomeCliente()%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>

		<div class="buttonsPedidos">
			<a class="divPedidos__filter button__link" href="javascript: presencial()">
				Presencial
			</a>
			<a class="divPedidos__filter button__link" href="javascript: entrega()">
				Entrega
			</a>
			<a class="divPedidos__add button__link" href="newPedido.jsp">
				Registrar Pedido
			</a>
		</div>

		<a class="divPedidos__viewNewRequests button__link" href="newRequests">
			Ver novos pedidos
		</a>
	</div>

	<!-- Tabela de Pizzas -->
	<table class="tablePizzas">
		<caption>Pizzas</caption>
		<thead>
			<tr>
				<th>Nº</th>
				<th>Nome</th>
				<th>Tamanho</th>
				<th>R$</th>
				<th colspan="2">Operações</th>
			</tr>
		</thead>

		<tbody>
			<%
				for (Pizza pizza : pizzas) {
			%>
			<tr>
				<td><%=pizza.getId()%></td>
				<td><%=pizza.getDescricao()%></td>
				<td><%=pizza.getTamanho()%></td>
				<td><%=pizza.getPreco()%></td>
				<td><a class="pizzasUpdate button__link"
					href="updatePizzaPage?id=<%=pizza.getId()%>">Editar</a></td>
				<td><a class="pizzasDelete button__link"
					href="javascript: confirmarExclusao(<%=pizza.getId()%>)">Excluir</a>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>

	<a class="pizzasAdd button__link" href="newPizza.html">
		Adicionar Pizza
	</a>

	<script src="scripts/confirmador.js"></script>
	<script src="scripts/filtrarTipoPedido.js"></script>
</body>
</html>