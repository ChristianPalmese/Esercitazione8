package Modello;

public class Autore {
    private String nome;
    private String cittàResidenza;

    public Autore(String nome, String cittàResidenza) {
        this.nome = nome;
        this.cittàResidenza = cittàResidenza;
    }

    public String getNome() {
        return nome;
    }

    public String getCittàResidenza() {
        return cittàResidenza;
    }
}
