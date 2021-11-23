function validar() {
    var descricao = pizzaForm.descricao.value;
    var preco = pizzaForm.preco.value;

    if(descricao === "") {
        alert("Preencha o campo nome");
        pizzaForm.descricao.focus();

        return false
    } else {

        if(preco === "") {
            alert("Preencha o campo preço");
            pizzaForm.preco.focus();

            return false
        } else {
            document.forms["pizzaForm"].submit();
        }

    }
}