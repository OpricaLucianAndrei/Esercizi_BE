package it.epicode.blogexercise.Dto;


import lombok.Data;

@Data
public class BlogPostDto {
    private String categoria;
    private String titolo;
    private String contenuto;
    private double tempoDiLetturaMinuti;
    private int autoreId;

    public int getAutoreId() {
        return autoreId;
    }

    public void setAutoreId(int autoreId) {
        this.autoreId = autoreId;
    }

    public double getTempoDiLetturaMinuti() {
        return tempoDiLetturaMinuti;
    }

    public void setTempoDiLetturaMinuti(double tempoDiLetturaMinuti) {
        this.tempoDiLetturaMinuti = tempoDiLetturaMinuti;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
