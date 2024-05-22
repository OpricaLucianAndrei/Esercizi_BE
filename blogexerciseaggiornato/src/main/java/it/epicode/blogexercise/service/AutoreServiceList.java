package it.epicode.blogexercise.service;


import it.epicode.blogexercise.exception.AutoreNonTrovatoException;
import it.epicode.blogexercise.model.Autore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutoreServiceList {

    private List<Autore> autori = new ArrayList<>();

    public Optional<Autore> getAutoreById(int id) {
        return autori.stream().filter(autore -> autore.getId() == id).findFirst();
    }

    public List<Autore> getAutori() {
        return autori;
    }

    private String generateAvatarUrl(String nome, String cognome) {
        return "https://ui-avatars.com/api/?name=" + nome + "+" + cognome;
    }


    public String saveAutore(Autore autore) {
        autori.add(autore);
        autore.setAvatar(generateAvatarUrl(autore.getNome(), autore.getCognome()));
        return "Autore creato con id: " + autore.getId();
    }

    public Autore updateAutore(int id, Autore autoreUpd) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOptional = getAutoreById(id);
        if (autoreOptional.isPresent()) {
            Autore autore = autoreOptional.get();
            autore.setNome(autoreUpd.getNome());
            autore.setCognome(autoreUpd.getCognome());
            autore.setEmail(autoreUpd.getEmail());
            autore.setDataDiNascita(autoreUpd.getDataDiNascita());
            autore.setAvatar(generateAvatarUrl(autore.getNome(), autore.getCognome()));
            return autore;
        } else {
            throw new AutoreNonTrovatoException("Autore non trovato");
        }
    }

    public String deleteAutore(int id) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOptional = getAutoreById(id);
        if (autoreOptional.isPresent()) {
            autori.remove(autoreOptional.get());
            return "Autore eliminato";
        } else {
            throw new AutoreNonTrovatoException("Autore non trovato");
        }
    }

}
