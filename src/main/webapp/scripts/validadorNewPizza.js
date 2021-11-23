function validar() {
    var descricao = cadastroPizza.descricao.value;
    var preco = cadastroPizza.preco.value;

    if(descricao === "") {
        alert("Preencha o campo nome");
        cadastroPizza.descricao.focus();

        return false
    } else {

        if(preco === "") {
            alert("Preencha o campo preço");
            cadastroPizza.preco.focus();

            return false
        } else {
            document.forms["cadastroPizza"].submit();
        }

    }
}