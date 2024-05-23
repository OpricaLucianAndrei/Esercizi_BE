package it.epicode.blogexercise.Dto;


import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class BlogPostDto {
    @NotNull(message = "Il campo categoria non può essere null")
    @Size(min = 3, max = 20)
    private String categoria;
    @NotNull(message = "Il campo titolo non può essere null")
    @Size(min = 3)
    private String titolo;
    @NotNull(message = "Il campo contenuto non può essere null")
    @Size(min = 50)
    private String contenuto;
    @NotNull(message = "Il campo tempoDiLetturaMinuti non può essere null")
    private double tempoDiLetturaMinuti;
    @NotNull(message = "Il campo autoreId non può essere null")
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
