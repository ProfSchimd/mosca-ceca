# Analisi dei requisiti del progetto MC

## GUI

### Interfaccia di gioco

### Interfaccia di accesso al server
Solo per la App `Client`, bisogna prevedere un menù di *connessione
al server*. Questo menù deve permettere di:
* indicare l'indirizzo IP del server;
* salvare un indirizzo nei **preferiti**;
* scegliere il server dai preferiti.

In caso di errore nella connessione al server, l'interfaccia deve
fornire un messaggio di errore e permettere l'inserimento un nuovo
IP.

### Interfaccia per le impostazioni
Solo per la App `Client`, deve essere possibile visualizzare un
interfaccia di **impostazione** nel quale il giocatore inserisce:
* il nome di gioco;
* un *avatar* che può
  * essere selezionato da una lista di avatar predefiniti oppure
  * caricato sotto forma di un file immagine;
* una *intelligenza artificiale* che può
    * essere scelta da una lista di AI predefinite oppure
    * essere caricata mediante file.

## Server

### Avvio di un gioco
Il `Server` deve fornire un'interfaccia grafica "basilare" che
permetta di
* avviare un nuovo server di gioco su una porta specifica
  (di default questa sarè `41041`);
* selezionare una cartella su cui salvare i dati del gioco;
* impostare le caratteristiche del server
    * pubblico o privato
    * numero massimo di giocatori ammessi
    * dettagli sulla generazione delle risorse.

Inoltre l'interfaccia del server deve avere comandi per
* avviare il server (nuovo o da una directory selezionata);
* fermare il server;
* mettere un pausa il server.