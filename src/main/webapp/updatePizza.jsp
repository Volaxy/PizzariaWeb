<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="styles/updatePizza.css">

    <link rel="shortcut icon" href="images/pizza.ico" type="image/x-icon">
    <title>Editar Pizza</title>
</head>
<body>
    <form action="updateOldPizza" name="pizzaForm">
    	<label for="id">Identificação</label>
    	<input id="id" type="text" name="id" value="<% out.print(request.getAttribute("id")); %>" readonly>
    
        <label for="name">Nome da Pizza</label>
        <input id="name" type="text" name="descricao" placeholder="Nome da Pizza" value="<% out.print(request.getAttribute("name")); %>">

        <label for="size">Tamanho da Pizza</label>
        <select id="size" name="tamanho">
        	<% int value = Integer.valueOf((Integer) request.getAttribute("size")); int i = 1; %>
            <option value="1" <% if(value == i++) {out.print("selected");} %>>Pequena</option>
            <option value="2" <% if(value == i++) {out.print("selected");} %>>Média</option>
            <option value="3" <% if(value == i++) {out.print("selected");} %>>Grande</option>
        </select>

        <label for="price">Preço</label>
        <input id="price" type="number" name="preco" min="0" placeholder="R$"  value="<% out.print(request.getAttribute("price")); %>">

        <input class="updatePizza" type="button" value="Atualizar" onclick="validar()">
    </form>

    <script src="scripts/validador.js"></script>
</body>
</html>