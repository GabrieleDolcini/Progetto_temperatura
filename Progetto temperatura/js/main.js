const myResult = document.querySelector("#result");
/*var misurazioni = [

    {id:1, aula: 'MM2', giorno: '2024-01-23', ora:'10:23', valore: 20.5 },
    
    {id:2, aula: 'MM2', giorno: '2024-01-23', ora:'11:23', valore: 21.5 },
    
    {id:3, aula: 'MM1', giorno: '2024-01-22', ora:'10:00', valore: 18.5 },
    
    {id:4, aula: 'MM2', giorno: '2024-01-23', ora:'10:23', valore: 20.5 },
    
    {id:5, aula: 'MM2', giorno: '2024-01-23', ora:'11:23', valore: 21.5 },
    
    {id:6, aula: 'MM1', giorno: '2024-01-22', ora:'10:00', valore: 18.5 },

    {id:7, aula: 'MM2', giorno: '2024-01-23', ora:'10:23', valore: 20.5 },
    
    {id:8, aula: 'MM2', giorno: '2024-01-23', ora:'11:23', valore: 21.5 },
    
    {id:9, aula: 'MM1', giorno: '2024-01-22', ora:'10:00', valore: 18.5 },

     {id:9, aula: 'MM1', giorno: '2024-01-22', ora:'10:00', valore: 18.5 },
    ]*/

    var misurazioni=[];

    function fetchElenco() {
        let url = "http://localhost:5000";
        fetch(url)
        .then(response => response.json())
        .then(data =>  {
            misurazioni = data;
            misurazioni = misurazioni_convertite();
            myResult.append(tabella(misurazioni));

            //console.log(misurazioni);
          });
      }
      
    fetchElenco();
    
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
        new Date(g);
    }
    function tabella(conv){
        let lunghezza = conv.length;

        let table = document.createElement("table");
        let tr_titoli = document.createElement("tr");
        
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
        
        table.append(tr);
        }
        return table;
    }
    const myBody = document.querySelector("body");
    


/*
var datetime = new Date();
var giorno_settimana = datetime.getDay();
var time = datetime.getHours() + ":" + datetime.getMinutes();
var data = datetime.getDate() + "/" + (datetime.getMonth() + 1) + "/" + datetime.getFullYear();
document.write("Oggi è : " + giorno_settimana + " " + data + "Ore: " + time);




var data = new Date();
var Hh, Mm, Ss, mm;
Hh = data.getHours() + ":";
Mm = data.getMinutes() + ":";
Ss = data.getSeconds() + ":";
mm = data.getMilliseconds() + ":";
document.write("Sono le ore " + Hh + Mm + Ss + mm);
var gg, mm, aaaa;
gg = data.getDate() + "/";
mm = data.getMonth() + 1 + "/";
aaaa = data.getFullYear();
document.write("Oggi è il " + gg + mm + aaaa);
*/
