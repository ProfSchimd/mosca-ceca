# Mosca Ceca
Repository del progetto **Mosca Ceca**

## Progetto Mosca Ceca

### Scacchiera di gioco
Il gioco si svolge su una scacchiera di ``n`` righe e ``n`` colonne che rappresenta il mondo all’interno del quale gli agenti si muovono.
Ogni casella della scacchiera può essere:
* libera,
* occupata da un agente,
* occupata da una risorsa.

### Scopo del gioco
Lo scopo del gioco è conquistare quanto più territorio possibile entro un certo tempo o un certo numero di turni, tempo e/o turni sono stabiliti all’inizio della partita.

### Comportamento agenti
Ad ogni turno un agente può eseguire una sola delle seguenti mosse.
* Spostarsi verso una casella (destra, sinistra, su, giù e diagonale) che non sia occupata da un altro agente.
* Piantare una bandiera se si trova in una casella libera.
* Consumare un'unità di risorsa se si trova su una casella "risorsa".
Inoltre gli agenti sono soggetti alle seguenti regole.
* Ogni agente ha un livello di energia da ``0`` a ``100`` che deve mantenere sopra a 0 altrimenti si spegne.
* Ogni movimento sulla scacchiera ed ogni bandiera piantata consumano un’unità di energia.
* Alcune caselle risorse contengono “Colonne di ricarica”, un agente che si trova in una di esse aumenta di 10 unità la sua energia ad ogni turno (fino a raggiungere un massimo di 100).
* Un agente può attaccare un altro agente che si trovi su un proprio territorio. Se l’attacco va a buon fine, la vittima perde 5 unità di stoffa (perde tutte le unità, se ne possiede meno di 5). L’attaccante consuma 2 unità di energia per ogni attacco. L’esito dell’attacco a casuale (50-50).

### Informazione degli agenti
Ogni agente in ogni momento conosce:
* dove si trova e quanto mosse dista la colonnina di ricarica più vicina;
* lo stato delle caselle adiacenti;
* tutte le caselle (posizione e numero) che hanno una sua bandiera.

### Utilizzo delle risorse
Sono presenti due tipi di **risorse**
* *Energia*, presente nelle colonne di ricarica. Le colonne di ricarica hanno una quantità infinita di energia, ma ne trasferiscono 10 unità ad ogni turno.
* *Stoffa*, presente in alcuni punti della mappa. La quantità di stoffa presente in un punto è limitata ed ogni volta che un agente ne raccoglie un’unità, la risorsa corrispondente diminuisce di un’unità. Quando questa quantità raggiunge ``0``, la
casella diventa libera e non è più una casella risorsa (quindi diventa conquistabile)
* Per poter piantare una bandiera è necessario avere 4 unità di stoffa, se c’è un’altra bandiera propria in una casella adiacente, altrimenti servono 8 unità. Una volta piantata una bandiera, le unità di stoffa dell’agente diminuiscono di un numero di unità corrispondente a quello necessario per posizionare la bandiera.
Le risorse, che sono generate in modo casuale all’inizio della partita, possono essere utilizzate secondo le seguenti regole
* Un solo agente per volta può usare la risorsa (se disponibile)
* L'agente che vuole utilizzare una risorsa deve posizionarsi sulla casella risorse corrispondente
* Gli agenti su una casella risorsa non possono essere attaccati
* Un agente che si trova su una casella risorsa **deve** consumare la risorsa (cioé non si possono usare le caselle risorse
solo per ripararsi). 
* Un agente che raggiunge energia massima (valore ``100``) viene spostato da una casella colonna di ricarica in una casella
adiacente casuale e valida. Solo se questa operazione è impossibile l'agente può rimanere nella casella pur non utilizzando la risorsa.
