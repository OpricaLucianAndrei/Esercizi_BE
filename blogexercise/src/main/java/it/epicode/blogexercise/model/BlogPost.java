package it.epicode.blogexercise.model;


import lombok.Data;

@Data
public class BlogPost {
    private int id;
    private static int cont;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private double tempoDiLetturaMinuti;

    public BlogPost(String categoria, String titolo, String cover, String contenuto, double tempoDiLetturaMinuti) {
        cont++;
        id=cont;
        this.categoria = categoria;
        this.titolo = titolo;
        this.cover = cover;
        this.contenuto = contenuto;
        this.tempoDiLetturaMinuti = tempoDiLetturaMinuti;
    }

    public int getId() {
        return id;
    }


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public double getTempoDiLetturaMinuti() {
        return tempoDiLetturaMinuti;
    }

    public void setTempoDiLetturaMinuti(double tempoDiLetturaMinuti) {
        this.tempoDiLetturaMinuti = tempoDiLetturaMinuti;
    }
}
