const myResult = document.querySelector("#result");

    const myBody = document.querySelector("body");
    const myTable = document.querySelector("#temperatura");
    const myTitoli = document.querySelector("#titoli");

    var misurazioni=[];

    function fetchElenco() {
        let url = "http://localhost:5000";
        fetch(url)
        .then(response => response.json())
        .then(data =>  {
            misurazioni = data;
            misurazioni = misurazioni_convertite();
            tabella(misurazioni);
            //console.log(misurazioni);
          });
      }
      
    
    
    function misurazioni_convertite(){
        var convertite = [];
        let l = misurazioni.length;
        for(let i=0;i<l;i++){
            convertite.push(misurazioni[i]);
            converti(convertite[i].giorno);
            converti(convertite[i].ora);
        }
        console.log(convertite);

        return convertite;
    }


    function converti(g){
        let giorno = new Date(g);
        giorno = giorno.toLocaleDateString('it-IT', {day:"numeric",month:"short",year:"numeric"});
    }
    function tabella(conv){
        let lunghezza = conv.length;

        let tr_titoli = document.createElement("tr");
            
        // Aggiunge titoli alle colonne
        let titoli = ['ID', 'Aula', 'Data', 'Ora', 'Valore'];
        for (let titolo of titoli) {
            let th = document.createElement("th");
            th.textContent = titolo;
            tr_titoli.appendChild(th);
        }
        myTitoli.appendChild(tr_titoli);
        
        for(let j=0; j< lunghezza ;j++){
        
            let tr = document.createElement("tr");
               
            for(let i = 0; i<1; i++){        
                for(let k = 0; k<5;k++){
                    let td = document.createElement("td");
                    switch(k){
                        case 0:
                            td.append(conv[j].id);
                            break;
                        case 1:
                            td.append(conv[j].aula);
                            break;
                        case 2:
                            td.append(conv[j].giorno);
                            break;
                        case 3:
                            td.append(conv[j].ora);
                            break;
                        case 4:
                            td.append(conv[j].valore);
                            break;
                    }
                    tr.append(td);
                }
            }
        
        myTable.append(tr);
        }
    }
    
    fetchElenco();
