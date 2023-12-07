package Controllo;

import java.util.ArrayList;
import java.util.List;

import Modello.Autore;
import Modello.Pubblicazione;
import Modello.Sistema;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        // Creazione degli autori
        Autore a1 = new Autore("Rossi", "Roma");
        Autore a2 = new Autore("Bianchi", "Torino");
        Autore a3 = new Autore("Verdi", "Cosenza");
        Autore a4 = new Autore("Neri", "Cosenza");
        Autore a5 = new Autore("Marroni", "Milano");
        Autore a6 = new Autore("Gialli", "Milano");

        // Aggiunta degli autori al sistema
        sistema.aggiungiAutore(a1);
        sistema.aggiungiAutore(a2);
        sistema.aggiungiAutore(a3);
        sistema.aggiungiAutore(a4);
        sistema.aggiungiAutore(a5);
        sistema.aggiungiAutore(a6);

        // Creazione delle pubblicazioni
        Pubblicazione p1 = new Pubblicazione("pub1", "Titolo di p1", List.of("Rossi", "Bianchi", "Neri"), 1);
        Pubblicazione p2 = new Pubblicazione("pub2", "Titolo di p2", List.of("Bianchi", "Neri"), 2);
        Pubblicazione p3 = new Pubblicazione("pub3", "Titolo di p3", List.of("Gialli", "Marroni"), 2);
        Pubblicazione p4 = new Pubblicazione("pub4", "Titolo di p4", List.of("Gialli"), 2);
        Pubblicazione p5 = new Pubblicazione("pub5", "Titolo di p5", List.of("Neri", "Verdi"), 1);
        Pubblicazione p6 = new Pubblicazione("pub6", "Titolo di p6", List.of("Bianchi"), 1);
        Pubblicazione p7 = new Pubblicazione("pub7", "Titolo di p7", List.of("Gialli", "Rossi", "Bianchi", "Neri"), 2);
        Pubblicazione p8 = new Pubblicazione("pub8", "Titolo di p8", List.of("Verdi"), 3);

        // Aggiunta delle pubblicazioni al sistema
        sistema.aggiungiPubblicazione(p1);
        sistema.aggiungiPubblicazione(p2);
        sistema.aggiungiPubblicazione(p3);
        sistema.aggiungiPubblicazione(p4);
        sistema.aggiungiPubblicazione(p5);
        sistema.aggiungiPubblicazione(p6);
        sistema.aggiungiPubblicazione(p7);
        sistema.aggiungiPubblicazione(p8);

        // Esempio utilizzo dei metodi richiesti
        ArrayList<String> pubblicazioniCitta = sistema.pubblicazioniCitta("Milano");
        System.out.println("Pubblicazioni scritte solo da autori residenti a Cosenza:");
        for (String codicePubblicazione : pubblicazioniCitta) {
            System.out.println("Codice: " + codicePubblicazione);
        }

        ArrayList<Autore> autoriIndividuali = sistema.individuali(2, 3);
        System.out.println("\nAutori di pubblicazioni individuali nel periodo compreso tra le date 2 e 3:");
        for (Autore autore : autoriIndividuali) {
            System.out.println("Nome: " + autore.getNome() + ", Città: " + autore.getCittàResidenza());
        }

        Autore autore1 = a2; // Si può cambiare con altri autori
        Autore autore2 = a4; // Si può cambiare con altri autori
        ArrayList<Pubblicazione> pubblicazioniCoautori = sistema.coautori(autore1, autore2);
        System.out.println("\nPubblicazioni scritte congiuntamente dagli autori " + autore1.getNome() + " e " + autore2.getNome() + ":");
        for (Pubblicazione pubblicazione : pubblicazioniCoautori) {
            System.out.println("Codice: " + pubblicazione.getCodice() + ", Titolo: " + pubblicazione.getTitolo());
        }
    }
}

