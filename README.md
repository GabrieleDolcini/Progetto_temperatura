# PROGETTO TEMPERATURA

## Sommario

- [Introduzione e Obiettivi](#introduzione-e-obiettivi)
- [Metodologia](#metodologia)
- [Contenuti del progetto](#contenuti-del-progetto)
- [Struttura dei file](#struttura-dei-file)
- [Conclusioni](#conclusioni)
- [Realizzatori](#realizzatori)

## Introduzione e Obiettivi

Questo progetto si propone di monitorare e registrare le temperature all'interno delle aule di una scuola utilizzando un sensore DHT22 collegato a un microcontrollore ESP32. Le temperature rilevate vengono quindi inviate a un server Flask che le memorizza in un file CSV. Inoltre, è stato creato un'applicazione web utilizzando HTML, CSS e JavaScript per visualizzare i dati sotto forma di tabella. Gli obiettivi specifici includono:

1. Acquisizione dei dati di temperatura e umidità utilizzando un sensore DHT22 collegato a un microcontrollore ESP32.
2. Memorizzazione delle misurazioni di temperatura in un file CSV tramite un server Flask.
3. Visualizzazione dei dati di temperatura registrati tramite un'interfaccia web.

## Metodologia

Il raggiungimento degli obiettivi del progetto è stato suddiviso nei seguenti passaggi:

1. **Sviluppo dell'Interfaccia Web**: Creazione di un'interfaccia web utilizzando HTML, CSS e JavaScript per visualizzare i dati di temperatura in forma tabellare,

2. **Implementazione del Server Flask**: Creazione di un server Flask in grado di gestire le richieste HTTP provenienti dall'ESP32 per aggiungere nuove misurazioni di temperatura e restituire i dati al client.

3. **Configurazione Hardware**: Collegamento del sensore DHT22 all'ESP32 e programmazione dell'ESP32 per acquisire i dati di temperatura e umidità.

4. **Aggiunta di bootstrap**: Implementazione della libreria bootstrap nell'interfaccia Web  

5. **Test e Ottimizzazione**: Verifica del corretto funzionamento dell'intero sistema, inclusi il sensore DHT22, l'ESP32, il server Flask e l'interfaccia web. Ottimizzazione del codice e risoluzione di eventuali problemi riscontrati durante i test.

## Contenuti del Progetto

Il progetto comprende diversi componenti:

1. **ESP32 con Sensore DHT22**: Il microcontrollore ESP32 è utilizzato per acquisire i dati di temperatura e umidità all'interno delle aule della scuola tramite il sensore DHT22.

2. **Server Flask**: Un server Flask è implementato per gestire le richieste HTTP provenienti dall'ESP32 e memorizzare i dati di temperatura in un file CSV.

3. **Applicazione Web**: Un'interfaccia web è stata sviluppata utilizzando HTML, CSS e JavaScript per visualizzare i dati di temperatura registrati in forma di tabella. Questa interfaccia fornisce informazioni utili per monitorare le variazioni di temperatura all'interno delle aule scolastiche.

## Struttura dei File

Il progetto è organizzato nei seguenti file:

1. **`index.html`**: Questo file contiene la struttura HTML per l'interfaccia web che visualizza i dati di temperatura. 
[Link del file](Progetto%20temperatura/index.html)

2. **`style.css`**: Il file CSS definisce lo stile dell'applicazione web per renderla più accattivante e leggibile.
[Link del file](Progetto%20temperatura/css/style.css)

3. **`main.js`**: Questo file contiene il codice JavaScript per caricare dinamicamente i dati di temperatura nella tabella dell'interfaccia web. Qui viene effettuato il fetch che permette la lettura e inserimento dei dati nel file HTML.
[Link del file](Progetto%20temperatura/js/main.js)

4. **`serverdati.py`**: Questo file Python implementa il server Flask che gestisce le richieste HTTP per aggiungere nuove misurazioni di temperatura e restituire i dati al client.
[Link del file](Progetto%20temperatura/serverdati.py)

5. **`dati.csv`**: Il file CSV contiene i dati di temperatura registrati, memorizzati secondo il formato: `ID, Aula, Giorno, Ora, Temperatura`.
[Link del file](Progetto%20temperatura/dati.csv)

6. **`rilevazione_temperatura.ino`**: Questo file contiene il codice Arduino IDE che viene caricato sull'ESP32 per acquisire e inviare i dati di temperatura al server Flask.
[Link del file](Progetto%20temperatura/arduino/rilevazione_temperatura.ino)


## Conclusioni
Le principali conclusioni del progetto includono:

- **Affidabilità del Sistema**: Il sistema implementato si è dimostrato affidabile nel rilevare e registrare le variazioni di temperatura all'interno delle aule scolastiche.
- **Utilità dei Dati Raccolti**: I dati di temperatura raccolti possono essere utilizzati per valutare il comfort termico degli studenti e adottare eventuali misure correttive per migliorare l'ambiente di apprendimento.
- **Possibilità di Miglioramento**: Nonostante il successo del progetto, ci sono ancora aree di miglioramento possibili, come l'aggiunta di funzionalità avanzate all'interfaccia web (come la ricerca specifica di misurazioni nella tabella). Inoltre la misurazione delle temperature avviene per un intervallo di temppo definoto nel file 'rilevazioni_temperature.ino'
- **Server Locale**: Per verificare il corretto funzionamento del sistema si è basato il tutto su il server 'localhost:5000' ,ovvero al localhost. Quindi si potevano visualizzare i risultati solamente se il server è in esecuzione sul dispositivo stesso che si sta utilizzando. Quindi abbiamo assegnato a ogni gruppo un numero di porta riservato per l'avvio del server per fare in modo che il sito web sia accessibile anche da remoto. Il nostro dovrebbe utilizzare la porta 5010.

## Realizzatori

Questo progetto è stato realizzato da:

- Dolcini Gabriele
- Ceccarelli Ruben
- Benedetti Nicolo
