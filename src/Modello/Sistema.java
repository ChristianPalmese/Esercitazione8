package Modello;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Autore> listaAutori;
    private List<Pubblicazione> listaPubblicazioni;
    
   

    public Sistema() {
        listaAutori = new ArrayList<>();
        listaPubblicazioni = new ArrayList<>();
    }
    





	public void aggiungiAutore(Autore autore) {
        listaAutori.add(autore);
    }

    public void aggiungiPubblicazione(Pubblicazione pubblicazione) {
        listaPubblicazioni.add(pubblicazione);
    }

    public ArrayList<String> pubblicazioniCitta(String s) {
        ArrayList<String> pubblicazioni = new ArrayList<>();
        for (Pubblicazione pubblicazione : listaPubblicazioni) {
            boolean tuttiNellaCitta = true;
            for (String nomeAutore : pubblicazione.getNomiAutori()) {
                boolean trovato = false;
                for (Autore autore : listaAutori) {
                    if (autore.getNome().equals(nomeAutore) && !autore.getCittàResidenza().equals(s)) {
                        tuttiNellaCitta = false;
                        break;
                    }
                    if (autore.getNome().equals(nomeAutore) && autore.getCittàResidenza().equals(s)) {
                        trovato = true;
                        break;
                    }
                }
                if (!trovato) {
                    tuttiNellaCitta = false;
                    break;
                }
            }
            if (tuttiNellaCitta) {
                pubblicazioni.add(pubblicazione.getCodice());
            }
        }
        return pubblicazioni;
    }

    public ArrayList<Autore> individuali(int d1, int d2) {
        ArrayList<Autore> autoriIndividuali = new ArrayList<>();
        for (Pubblicazione pubblicazione : listaPubblicazioni) {
            if (pubblicazione.getData() >= d1 && pubblicazione.getData() <= d2 && pubblicazione.getNomiAutori().size() == 1) {
                String nomeAutore = pubblicazione.getNomiAutori().get(0);
                for (Autore autore : listaAutori) {
                    if (autore.getNome().equals(nomeAutore)) {
                        autoriIndividuali.add(autore);
                        break;
                    }
                }
            }
        }
        return autoriIndividuali;
    }

    public ArrayList<Pubblicazione> coautori(Autore a, Autore b) {
        ArrayList<Pubblicazione> pubblicazioniComuni = new ArrayList<>();
        for (Pubblicazione pubblicazione : listaPubblicazioni) {
            if (pubblicazione.getNomiAutori().contains(a.getNome()) && pubblicazione.getNomiAutori().contains(b.getNome())) {
                pubblicazioniComuni.add(pubblicazione);
            }
        }
        pubblicazioniComuni.sort((p1, p2) -> Integer.compare(p1.getData(), p2.getData()));
        return pubblicazioniComuni;
    }
}
