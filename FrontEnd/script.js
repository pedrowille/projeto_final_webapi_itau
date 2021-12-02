
        function ajax(config){
            const xhr = new XMLHttpRequest()
                xhr.open("GET",config.url,true)

                xhr.onload =  e =>{
                    if (xhr.status === 200){
                        config.sucesso(xhr.response)

                    } else if(xhr.status >= 400){
                        config.erro({

                        codigo: xhr.status,
                        text: xhr.statusText

                        })
                    }
                }
           xhr.send()
        }

        ajax({

            url:"http://localhost:8080/contas/",
            metodo: "get",
            sucesso(resposta){

                const estados = JSON.parse(resposta)

                const linhas = estados.map(estado =>{

                    const tdNum = document.createElement('td')
                    tdNum.innerHTML = estado.numero

                    const tdAg = document.createElement('td')
                    tdAg.innerHTML = estado.agencia

                    const tdTipo = document.createElement('td')
                    tdTipo.innerHTML = estado.tipo

                    const tdSaldo = document.createElement('td')
                    tdSaldo.innerHTML = estado.saldo

                    const tdId = document.createElement('td')
                    tdId.innerHTML = estado.titular.id

                    const tdNome = document.createElement('td')
                    tdNome.innerHTML = estado.titular.nome

                    const tdCpf = document.createElement('td')
                    tdCpf.innerHTML = estado.titular.cpf

                    const tdTelefone = document.createElement('td')
                    tdTelefone.innerHTML = estado.titular.telefone

                    const tdEmail = document.createElement('td')
                    tdEmail.innerHTML = estado.titular.email

                   

                   

                    const tr = document.createElement('tr')
                    tr.appendChild(tdNum)
                    tr.appendChild(tdAg)
                    tr.appendChild(tdTipo)
                    tr.appendChild(tdSaldo )
                    tr.appendChild(tdId)
                    tr.appendChild(tdNome)
                    tr.appendChild(tdCpf)
                    tr.appendChild(tdTelefone)
                    tr.appendChild(tdEmail)

                    return tr


                } )

                const tabela = document.createElement('table')
                linhas.forEach(linha => tabela.appendChild(linha))
                document.body.appendChild(tabela)
            },
            erro(e){
                const msg = document.createTextNode(`${e.codigo}: ${e.text}`)
                document.body.appendChild(msg)
            }
        }

        )
 