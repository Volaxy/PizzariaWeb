function validar() {
    var preco = pedidoForm.preco.value;

    if(preco === "") {
        alert("Preencha o campo preço");
        pedidoForm.preco.focus();

        return false;
    } else {
        document.forms["pedidoForm"].submit();
    }
}