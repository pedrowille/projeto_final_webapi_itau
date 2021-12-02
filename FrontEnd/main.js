const conta = document.querySelector("#conta")


/* Aqui é pra tratar o resultado da pesuisa que veio no json*/ 
const showData = (result)=>{
    /* Para cada campo do resultado e valida se tem no meu formuario */
    for(const campo in result){
        /*eu valida SE tem um campo de mesmo ID no meu formuario*/
        if(document.querySelector("#"+campo)){
            /*Para os  campo que tiverem o mesmo ID no meu formuario,preencha com o resultado da consulta*/
            document.querySelector("#"+campo).value = result[campo]
        }
    }
}


/* esse evento bluré pra quando desfocar ler ovaor do campo */
conta.addEventListener("blur", function (e) {

    /* armazenei o valor do campo na vairavel sechae e use o metodo replcae pra
    subistituit o - por nada pq tenho que deixar numeros*/
    let search = conta.value.replace("-", "");

    const options = {
        method: 'GET',
        mode: 'cors',
        cache: 'default'
    };

    fetch(`http://localhost:8080/contas/${search}/`, options)
    .then(response => {
        response.json()
        .then(data => showData(data));
    })
    .catch((e) => console.log('Deu Erro: ' + e, message));
})