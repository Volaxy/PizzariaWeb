function confirmarExclusao(id) {
    var resposta = confirm("Realmente deseja apagar este dado com o id: " + id);

    if(resposta === true) {
        window.location.href = "deletePizza?id=" + id;
    }
}