# Comunicazione Client-Server

Il progetto `mosca-ceca` prevede due programmi: un *server* e un *client*.
In questo modo è possibile creare un gioco multiplayer e multi-piattaforma
che, tuttavia, necessita di un protocollo prestabilito. In questa pagina 
si procede con la definizione di tal protocollo.

* Comandi `client -> server` servono al client per comunicare informazioni 
  al server ad esempio: connessione, update stato, ... Inoltre tali richieste
  possono essere utilizzate per recuperare informazione dal server ad esempio:
  stato del gioco, scacchiera, ...
  
* Comandi `server -> client` servono al server per comunicare informazioni
  al client ad esempio: prossima mossa, fine gioco, attacco, ...
  
## Generalità sul protocollo
* La comunicazione avviene mediante il protocollo TCP
* Il server ascolta sulla porta `41041`
* La comunicazione avviene mediante lo scambio di stringhe

  

## Comandi dal client

* `connect` si connette al server deve fornire: nome agente, se è già esistente un agente con lo stesso nome la connsessione verrà interrotta.
* `status` ottiene informazioni generali sul gioco: turni rimasi.
* `board` ottiene informazioni sulla stato delle caselle adiacenti all'agente.

## Comandi dal server

* `move` richiede una mossa al client
* `end` interrompe la comunicazione