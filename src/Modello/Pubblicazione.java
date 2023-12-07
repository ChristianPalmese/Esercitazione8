package Modello;

import java.util.List;

public class Pubblicazione {
    private String codice;
    private String titolo;
    private List<String> nomiAutori;
    private int data;

    public Pubblicazione(String codice, String titolo, List<String> nomiAutori, int data) {
        this.codice = codice;
        this.titolo = titolo;
        this.nomiAutori = nomiAutori;
        this.data = data;
    }

    public String getCodice() {
        return codice;
    }

    public String getTitolo() {
        return titolo;
    }

    public List<String> getNomiAutori() {
        return nomiAutori;
    }

    public int getData() {
        return data;
    }
}
