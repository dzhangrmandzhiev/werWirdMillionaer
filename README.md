# Wer wird Millionär - Dokumentation

## Überblick

Das Programm "Wer wird Millionär" ist ein textbasiertes Quizspiel, das auf dem bekannten Fernsehformat basiert. Der Spieler muss eine Reihe von Fragen beantworten, um Geldpreise zu gewinnen. Der Spieler kann verschiedene Joker verwenden, um ihm bei der Beantwortung der Fragen zu helfen.

## Struktur

Das Programm ist in die Klasse `WerWirdMillionaer` organisiert. Die Hauptlogik des Spiels befindet sich in dieser Klasse, und die wichtigsten Funktionen sind in statischen Methoden implementiert.

### Globale Variablen

- **FRAGEN**: Ein zweidimensionales Array, das die Fragen, Antwortmöglichkeiten und die korrekte Antwort speichert.
- **GEWINNSTUFEN**: Ein Array, das die Geldbeträge speichert, die der Spieler für jede Frage gewinnen kann.
- **ERSTE_SICHERHEITSSTUFE** und **ZWEITE_SICHERHEITSSTUFE**: Konstanten, die die Sicherheitsstufen für das Spiel definieren.
- **jokerVerfuegbar**: Ein Array, das den Status der verfügbaren Joker speichert.
- **aktuelleFrage**: Ein Zähler, der die aktuelle Frage verfolgt.
- **aktuellerGewinn**: Ein Zähler für den aktuellen Gewinn des Spielers.

### Hauptmethode

```java
public static void main(String[] args)
Die main-Methode ist der Einstiegspunkt des Programms. Hier wird eine Schleife gestartet, die das Spiel steuert, bis der Spieler entscheidet, das Spiel zu beenden.

# Spielablauf

## Hauptmethode
Die `main`-Methode ist der Einstiegspunkt des Programms. Hier wird eine Schleife gestartet, die das Spiel steuert, bis der Spieler entscheidet, das Spiel zu beenden.

## Spiel starten
- Der Spieler wird mit einer Begrüßung begrüßt.
- Das Spiel wird gestartet, und eine Schleife wird initiiert, um die Fragen nacheinander zu stellen, solange der Spieler weiter spielen möchte.

## Fragen stellen
- Die Methode `spieleFrage(Scanner scanner)` zeigt die aktuelle Frage zusammen mit den vier möglichen Antworten an.
- Der aktuelle Gewinn des Spielers wird angezeigt.
- Der Spieler hat die Möglichkeit, einen Joker zu verwenden oder eine Antwort einzugeben.
- Der Spieler kann auch das Spiel mit der Eingabe von "beenden" verlassen.

## Antwort prüfen
- Nachdem der Spieler eine Antwort eingegeben hat, wird diese mit der richtigen Antwort verglichen.
- Wenn die Antwort korrekt ist:
  - Der Gewinn wird aktualisiert.
  - Die nächste Frage wird geladen.
  - Wenn der Spieler die letzte Frage korrekt beantwortet, wird eine Gewinnmeldung angezeigt.
- Wenn die Antwort falsch ist, wird die Methode `berechneVerlust()` aufgerufen, um den Verlust zu berechnen.

## Verlustberechnung
Wenn der Spieler eine falsche Antwort gibt, wird sein Gewinn basierend auf den definierten Sicherheitsstufen berechnet:
- Liegt der Gewinn unter 1000€, erhält der Spieler 0€.
- Liegt der Gewinn zwischen 1000€ und 32000€, erhält der Spieler 1000€.
- Liegt der Gewinn über 32000€, erhält der Spieler 32000€.
- Eine entsprechende Nachricht wird ausgegeben, und das Spiel endet.

## Joker-Mechanik
Das Spiel bietet mehrere Joker, die den Spielern helfen können:

1. **50:50 Joker**  
   Entfernt zwei falsche Antworten. Der Spieler sieht nur die richtige Antwort und eine falsche Antwort.

2. **Publikumsjoker**  
   Simuliert eine Publikumsabstimmung, bei der die prozentuale Unterstützung für jede Antwort angezeigt wird.

3. **Telefonjoker**  
   Der Spieler ruft einen Freund an, der ihm eine Antwort gibt. Es besteht eine 50%-Chance, dass der Freund die richtige Antwort nennt.

4. **Sonderjoker**  
   Gibt einen zusätzlichen Hinweis zur Frage, der den Spieler unterstützen kann.

5. **Schere-Stein-Papier Joker**  
   Der Spieler spielt gegen den Moderator. Wenn der Spieler 3 Runden gewinnt, erhält er die richtige Antwort zur aktuellen Frage.
