<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
				<th>Nº do Pedido</th>
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
				<tr>
					<th>1</th>
					<th>Calabresa</th>
					<th>Pequena</th>
					<th>10,00</th>
				</tr>
			</tbody>
		</table>

		<a class="div__pizzas__a button__link" href="newPizza.html">Adicionar Pizza</a>
	</div>
</body>
</html>