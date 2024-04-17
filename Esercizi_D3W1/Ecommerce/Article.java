package Ecommerce;

public class Article {
    private int codiceArticolo;
    private String descrizioneArticolo;
    private double prezzoArticolo;
    private int quantitaArticolo;

    public Article(int codiceArticolo, String descrizioneArticolo, double prezzoArticolo, int quantitaArticolo) {
        this.codiceArticolo = codiceArticolo;
        this.descrizioneArticolo = descrizioneArticolo;
        this.prezzoArticolo = prezzoArticolo;
        this.quantitaArticolo = quantitaArticolo;
    }
    public int getCodiceArticolo() {
        return codiceArticolo;
    }
    public String getDescrizioneArticolo() {
        return descrizioneArticolo;
    }
    public double getPrezzoArticolo() {
        return prezzoArticolo;
    }
    public int getQuantitaArticolo() {
        return quantitaArticolo;
    }

    public void setQuantitaArticolo(int quantitaArticolo) {
        this.quantitaArticolo = quantitaArticolo;
    }
}
