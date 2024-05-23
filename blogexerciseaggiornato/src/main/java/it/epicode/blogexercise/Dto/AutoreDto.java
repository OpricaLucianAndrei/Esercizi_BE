package it.epicode.blogexercise.Dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class AutoreDto {
    @NotNull(message = "Il campo nome non può essere null")
    @Size(min = 2, max = 30)
    private String nome;
    private String cognome;
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    @NotNull(message = "Il campo email non può essere null")
    @Size(min = 8, max = 30)
    private String email;
    private LocalDate dataDiNascita;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }
}
