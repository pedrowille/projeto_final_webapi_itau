$(() => {
    function carregaDados() {
        $.ajax({
            method: "GET",
            url: "http://localhost:8080/contas",
           
        })
            .done((data) => {
                if (Array.isArray(data)) {
                    data.forEach((response) => {
                        $("#tblContas tbody").append(`<tr >
                            <td id="+response[i].numero+" >${response.numero}</td>
                            <td>${response.agencia}</td>
                            <td>${response.tipo === 0 ? "Conta Corrente" : response.tipo === 1 ? "Poupança" : "Investimento"}</td>
                            <td>${new Intl.NumberFormat('pt-br', { style: 'currency', currency: 'BRL' }).format(response.saldo)}</td>
                            <td>${response.titular.nome + ", CPF: " + response.titular.cpf + ", Telefone: " + response.titular.telefone + ", Email: " + response.titular.email}</td>
                           
                            
                        </tr>`)
                    })
                }
            })
            .fail((jqXHR, textStatus, msg) => {
                alert("Erro");
            })
    }

    carregaDados()
})


