package org.example;

import java.util.*;

public class WerWirdMillionaer {

    // Globale Variablen
    static final String[][] FRAGEN = {
            {"Frage 1: Welches Land hat die längste Küstenlinie der Welt?", "1) Russland", "2) Kanada", "3) Australien", "4) USA", "2"},
            {"Frage 2: In welchem Jahr endete der Zweite Weltkrieg?", "1) 1943", "2) 1944", "3) 1945", "4) 1946", "3"},
            {"Frage 3: Was ist die Quadratwurzel von 256?", "1) 14", "2) 15", "3) 16", "4) 17", "3"},
            {"Frage 4: Wer entdeckte die Relativitätstheorie?", "1) Isaac Newton", "2) Albert Einstein", "3) Nikola Tesla", "4) Max Planck", "2"},
            {"Frage 5: Wie heißt das kleinste Land der Welt?", "1) Monaco", "2) San Marino", "3) Liechtenstein", "4) Vatikanstadt", "4"},
            {"Frage 6: Welches Element hat die Ordnungszahl 79 im Periodensystem?", "1) Silber", "2) Gold", "3) Blei", "4) Platin", "2"},
            {"Frage 7: Was ist die Hauptsprache in Brasilien?", "1) Spanisch", "2) Portugiesisch", "3) Französisch", "4) Englisch", "2"},
            {"Frage 8: Wer war der erste Mensch im All?", "1) Yuri Gagarin", "2) Neil Armstrong", "3) Alexei Leonov", "4) Alan Shepard", "1"},
            {"Frage 9: Was ist die größte Wüste der Welt?", "1) Sahara", "2) Antarktis", "3) Gobi", "4) Kalahari", "2"},
            {"Frage 10: In welchem Jahr landeten die Menschen erstmals auf dem Mond?", "1) 1967", "2) 1968", "3) 1969", "4) 1970", "3"},
            {"Frage 11: Wie viele Knochen hat ein erwachsener Mensch?", "1) 202", "2) 204", "3) 206", "4) 208", "3"},
            {"Frage 12: Was ist der längste Fluss Europas?", "1) Donau", "2) Dnepr", "3) Wolga", "4) Rhein", "3"},
            {"Frage 13: Welches Land hat die meisten Nachbarländer in Europa?", "1) Deutschland", "2) Russland", "3) Frankreich", "4) Österreich", "1"},
            {"Frage 14: Welcher Physiker legte den Grundstein für die Quantenmechanik?", "1) Niels Bohr", "2) Erwin Schrödinger", "3) Max Planck", "4) Werner Heisenberg", "3"},
            {"Frage 15: Welches ist das kälteste bekannte Objekt im Universum?", "1) Supernova", "2) Boomerang-Nebel", "3) Kuiper-Gürtel", "4) Weißer Zwergstern", "2"}
    };
    static final int[] GEWINNSTUFEN = {50, 100, 200, 300, 500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 125000, 500000, 1000000};
    static final int ERSTE_SICHERHEITSSTUFE = 1000;
    static final int ZWEITE_SICHERHEITSSTUFE = 32000;
    static boolean[] jokerVerfuegbar = {true, true, true, true, true}; // 50:50, Publikumsjoker, Telefonjoker, Sonderjoker, Schere-Stein-Papier-Joker
    static int aktuelleFrage = 0;
    static int aktuellerGewinn = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean weiterspielen = true;

        System.out.println("Willkommen bei 'Wer wird Millionär'!\n");

        while (weiterspielen) {
            spieleFrage(scanner);
        }

        scanner.close();
    }

    static void spieleFrage(Scanner scanner) {
        System.out.println(FRAGEN[aktuelleFrage][0]);
        for (int i = 1; i <= 4; i++) {
            System.out.println(FRAGEN[aktuelleFrage][i]);
        }
        System.out.println("\nAktueller Gewinn: " + aktuellerGewinn + "€");
        zeigeJoker();

        System.out.print("Ihre Antwort (oder 'beenden' zum Aussteigen): ");
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("beenden")) {
            System.out.println("Sie haben mit " + aktuellerGewinn + "€ aufgehört. Herzlichen Glückwunsch!");
            System.exit(0);
        }

        if (input.startsWith("joker")) {
            verwendeJoker(input, scanner);
            return;
        }

        pruefeAntwort(input);
    }

    static void zeigeJoker() {
        System.out.println("Joker verfügbar: 1) 50:50  2) Publikumsjoker  3) Telefonjoker  4) Sonderjoker  5) Schere-Stein-Papier-Joker");
        System.out.println("(Joker können durch Eingabe von 'joker x' aktiviert werden, z.B. 'joker 1')");
    }

    static void pruefeAntwort(String input) {
        if (input.equals(FRAGEN[aktuelleFrage][5])) {
            aktuellerGewinn = GEWINNSTUFEN[aktuelleFrage];
            aktuelleFrage++;
            if (aktuelleFrage == FRAGEN.length) {
                System.out.println("Glückwunsch! Sie haben die Millionenfrage richtig beantwortet und 1.000.000€ gewonnen!");
                System.exit(0);
            }
        } else {
            berechneVerlust();
        }
    }

    static void berechneVerlust() {
        if (aktuellerGewinn < ERSTE_SICHERHEITSSTUFE) {
            aktuellerGewinn = 0;
        } else if (aktuellerGewinn < ZWEITE_SICHERHEITSSTUFE) {
            aktuellerGewinn = ERSTE_SICHERHEITSSTUFE;
        } else {
            aktuellerGewinn = ZWEITE_SICHERHEITSSTUFE;
        }
        System.out.println("Leider falsch! Sie gehen mit " + aktuellerGewinn + "€ nach Hause.");
        System.exit(0);
    }

    static void verwendeJoker(String input, Scanner scanner) {
        try {
            int jokerNummer = Integer.parseInt(input.split(" ")[1]) - 1;
            jokerEinsatz(jokerNummer, scanner);
        } catch (Exception e) {
            System.out.println("Ungültige Eingabe. Bitte geben Sie eine gültige Joker-Nummer ein (z. B. 'joker 1').");
        }
    }

    static void jokerEinsatz(int jokerNummer, Scanner scanner) {
        if (jokerNummer < 0 || jokerNummer >= jokerVerfuegbar.length || !jokerVerfuegbar[jokerNummer]) {
            System.out.println("Dieser Joker ist nicht verfügbar oder wurde bereits benutzt.");
            return;
        }

        switch (jokerNummer) {
            case 0:
                joker50zu50();
                break;
            case 1:
                jokerPublikumsjoker();
                break;
            case 2:
                jokerTelefonjoker();
                break;
            case 3:
                jokerSonderjoker();
                break;
            case 4:
                jokerSchereSteinPapier(scanner);
                break;
            default:
                System.out.println("Unbekannter Joker.");
                break;
        }
    }

    static void joker50zu50() {
        System.out.println("50:50 Joker aktiviert! Zwei falsche Antworten werden entfernt.");
        jokerVerfuegbar[0] = false; // Joker wurde verwendet
        Set<Integer> falscheAntworten = new HashSet<>();
        Random rand = new Random();

        // Falsche Antworten finden
        while (falscheAntworten.size() < 2) {
            int index = rand.nextInt(4) + 1;
            if (!FRAGEN[aktuelleFrage][5].equals(String.valueOf(index))) {
                falscheAntworten.add(index);
            }
        }

        // Antworten anzeigen
        for (int i = 1; i <= 4; i++) {
            if (!falscheAntworten.contains(i) || FRAGEN[aktuelleFrage][5].equals(String.valueOf(i))) {
                System.out.println(FRAGEN[aktuelleFrage][i]);
            }
        }
    }

    static void jokerPublikumsjoker() {
        System.out.println("Publikumsjoker aktiviert! Das Publikum stimmt ab...");
        jokerVerfuegbar[1] = false; // Joker wurde verwendet
        Random rand = new Random();
        int richtigeAntwort = Integer.parseInt(FRAGEN[aktuelleFrage][5]);

        // Zufällige Wahrscheinlichkeiten für Antworten
        int[] stimmen = new int[4];
        stimmen[richtigeAntwort - 1] = rand.nextInt(51) + 50; // Richtige Antwort: 50-100%
        int verbleibend = 100 - stimmen[richtigeAntwort - 1];

        for (int i = 0; i < 4; i++) {
            if (i != richtigeAntwort - 1) {
                stimmen[i] = rand.nextInt(verbleibend + 1);
                verbleibend -= stimmen[i];
            }
        }

        System.out.println("Abstimmungsergebnisse:");
        for (int i = 0; i < 4; i++) {
            System.out.println((i + 1) + ": " + stimmen[i] + "%");
        }
    }

    static void jokerTelefonjoker() {
        System.out.println("Telefonjoker aktiviert! Sie rufen eine bekannte Person an...");
        jokerVerfuegbar[2] = false; // Joker wurde verwendet
        Random rand = new Random();
        int richtigeAntwort = Integer.parseInt(FRAGEN[aktuelleFrage][5]);
        boolean korrekt = rand.nextBoolean();

        if (korrekt) {
            System.out.println("Ihr Telefonjoker sagt: 'Ich bin mir ziemlich sicher, die richtige Antwort ist: " + FRAGEN[aktuelleFrage][richtigeAntwort] + "'");
        } else {
            int falscheAntwort = rand.nextInt(4) + 1;
            while (falscheAntwort == richtigeAntwort) {
                falscheAntwort = rand.nextInt(4) + 1;
            }
            System.out.println("Ihr Telefonjoker sagt: Ich bin mir ziemlich sicher, die richtige Antwort ist: " + falscheAntwort + "'");
        }
    }

    static void jokerSonderjoker() {
        System.out.println("Sonderjoker aktiviert! Ein zusätzlicher Hinweis wird gegeben...");
        jokerVerfuegbar[3] = false;

        switch (aktuelleFrage) {
            case 0:
                System.out.println("Hinweis: Dieses Land liegt in Nordamerika und hat viele Seen.");
                break;
            case 1:
                System.out.println("Hinweis: Dies ist eine gerade Zahl.");
                break;
            case 2:
                System.out.println("Hinweis: Diese Zahl ist ein Vielfaches von 4.");
                break;
            case 3:
                System.out.println("Hinweis: Dieser Wissenschaftler ist auch für die Formel E=mc² bekannt.");
                break;
            case 4:
                System.out.println("Hinweis: Dieses Land ist von Italien umgeben.");
                break;
            case 5:
                System.out.println("Hinweis: Dieses Element wird oft mit Reichtum assoziiert.");
                break;
            case 6:
                System.out.println("Hinweis: Sparche, auf welcher sprach Vasco Da Gama");
                break;
            case 7:
                System.out.println("Hinweis: Dieser Mensch war ein sowjetischer Kosmonaut.");
                break;
            case 8:
                System.out.println("Hinweis: Wüsten sind nicht immer heiss.");
                break;
            case 9:
                System.out.println("Hinweis: Dieses Ereignis fand während der Apollo-11-Mission statt.");
                break;
            case 10:
                System.out.println("Hinweis: Diese Anzahl liegt knapp über 200.");
                break;
            case 11:
                System.out.println("Hinweis: Dieser Fluss fließt durch Russland.");
                break;
            case 12:
                System.out.println("Hinweis: Dieses Land grenzt an neun andere europäische Länder.");
                break;
            case 13:
                System.out.println("Hinweis: Dieser Physiker legte die Grundlage für die Quantentheorie.");
                break;
            case 14:
                System.out.println("Hinweis: Dieses Objekt ist ein planetarischer Nebel..");
                break;
            default:
                System.out.println("Kein spezifischer Hinweis verfügbar.");
                break;
        }
    }
    // Mein Joker
    static void jokerSchereSteinPapier(Scanner scanner) {
        System.out.println("Schere-Stein-Papier Joker aktiviert! Sie spielen gegen den Moderator.");
        jokerVerfuegbar[4] = false; // Joker wurde verwendet

        int spielerPunkte = 0;
        int moderatorPunkte = 0;
        String[] optionen = {"Schere", "Stein", "Papier"};

        while (spielerPunkte < 3 && moderatorPunkte < 3) {
            System.out.print("Wählen Sie 'Schere', 'Stein' oder 'Papier': ");
            String spielerWahl = scanner.nextLine().trim().toLowerCase();

            int moderatorWahl = new Random().nextInt(3);
            System.out.println("Moderator wählt: " + optionen[moderatorWahl]);

            if (spielerWahl.equals("schere") && optionen[moderatorWahl].equals("Papier") ||
                    spielerWahl.equals("stein") && optionen[moderatorWahl].equals("Schere") ||
                    spielerWahl.equals("papier") && optionen[moderatorWahl].equals("Stein")) {
                System.out.println("Sie gewinnen diese Runde!");
                spielerPunkte++;
            } else if (spielerWahl.equals(optionen[moderatorWahl].toLowerCase())) {
                System.out.println("Unentschieden!");
            } else {
                System.out.println("Moderator gewinnt diese Runde!");
                moderatorPunkte++;
            }

            System.out.println("Spielstand - Sie: " + spielerPunkte + " | Moderator: " + moderatorPunkte);
        }

        if (spielerPunkte == 3) {
            System.out.println("Herzlichen Glückwunsch! Sie haben gewonnen. Die richtige Antwort lautet: " + FRAGEN[aktuelleFrage][5]);
        } else {
            System.out.println("Leider haben Sie verloren! Sie dürfen die richtige Antwort nicht sehen.");
        }
    }
}
