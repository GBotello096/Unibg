# Riconoscimento di figure geometriche con classificazione Weka

Questo codice implementa un'applicazione per il riconoscimento di figure geometriche, in particolare rettangoli e quadrati, utilizzando il framework Weka per la classificazione. L'applicazione disegna casualmente una figura (rettangolo o quadrato) e chiede all'utente di riconoscerla. I dati delle figure vengono salvati in due file ARFF separati: "Dataset.arff" e "Test.arff".

## Dipendenze
- Weka: Il codice fa uso del framework Weka per la classificazione. Assicurarsi di avere Weka installato o di includere le dipendenze necessarie nel progetto.

## Esecuzione del codice
1. Compilare il codice sorgente fornito e assicurarsi di aver configurato correttamente le dipendenze di Weka.
2. Eseguire il programma e seguirne le istruzioni.
3. Durante l'esecuzione, il programma visualizzerà una finestra che disegna una figura (rettangolo o quadrato).
4. L'utente dovrà inserire "1" se la figura è un rettangolo o "2" se è un quadrato.
5. Il programma salverà i dati della figura nel file "Dataset.arff" insieme alla risposta dell'utente.
6. Il programma salverà anche i dati della figura nel file "Test.arff" per l'uso successivo nella classificazione.
7. Il ciclo si ripeterà fino a quando non vengono generate e classificate 20 figure.

## Struttura del codice
- La classe `AI` estende `Canvas` e gestisce la logica principale dell'applicazione.
- All'interno del metodo `main`, viene avviato un ciclo che genera e classifica 20 figure geometriche.
- Durante ogni iterazione del ciclo:
  - Viene creata una finestra `JFrame` per disegnare la figura.
  - La figura viene disegnata casualmente come un rettangolo o un quadrato utilizzando la classe `Rectangle2D`.
  - I vertici della figura vengono salvati e scritti nel file "Test.arff" per la successiva classificazione.
  - Viene chiesto all'utente di riconoscere la figura (rettangolo o quadrato).
  - La classificazione viene eseguita utilizzando la classe `Weka`.
  - La figura e la risposta dell'utente vengono salvate nel file "Dataset.arff".
  - La finestra viene pulita per mostrare la prossima figura.
- Una volta completato il ciclo, il programma termina.

È importante notare che per eseguire correttamente il codice, è necessario avere una corretta configurazione di Weka e le dipendenze corrispondenti. Assicurarsi di aver letto la documentazione di Weka e di avere una buona comprensione di come funzionano gli algoritmi di classificazione per adattare il codice alle proprie esigenze.

Si consiglia inoltre di gestire le eccezioni in modo appropriato durante l'esecuzione del codice per garantire una gestione degli errori adeguata.
