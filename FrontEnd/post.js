
function fazPost(url, body) {
    console.log("Body=", body)
    let request = new XMLHttpRequest()
    request.open("POST", url, true)
    request.setRequestHeader("Content-type", "application/json")
    request.send(JSON.stringify(body))

    request.onload = function() {
        console.log(this.responseText)
    }

    return request.responseText
}


function cadastraUsuario() {
    event.preventDefault()
    let url = "http://localhost:8080/contas/"
    let numero = document.getElementById("numero").value
    let agencia = document.getElementById("agencia").value
    let tipo = document.getElementById("tipo").value
    let saldo = document.getElementById("saldo").value
    console.log(numero)
    console.log(agencia)
    console.log(tipo)
    console.log(saldo)

    body = {
        "numero": numero,
        "agencia": agencia,
        "tipo": agencia,
        "saldo": agencia,
        "titular":{
            "id":1,
            "nome":"TESTE",
            "cpf":"12345678910",
            "telefone":"91234599",
            "email":"teste@rubens.com"
         }
         
    }

    fazPost(url, body)
}