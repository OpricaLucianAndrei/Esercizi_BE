package it.epicode.blogexercise.controller;


import it.epicode.blogexercise.exception.AutoreNonTrovatoException;
import it.epicode.blogexercise.exception.BlogPostNonTrovatoException;
import it.epicode.blogexercise.model.Autore;
import it.epicode.blogexercise.model.BlogPost;
import it.epicode.blogexercise.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @PostMapping("/api/autore")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveAutore(@RequestBody Autore autore) {
        return autoreService.saveAutore(autore);
    }


    @GetMapping("/api/autore")
    public List<Autore> getTuttiAutori() {
        return autoreService.getAutori();
    }

    @GetMapping("/api/autore/{id}")
    public Autore getAutoreById(@PathVariable int id) throws AutoreNonTrovatoException {
        Optional<Autore> autore = autoreService.getAutoreById(id);
        if (autore.isPresent()) {
            return autore.get();
        } else {
            throw new AutoreNonTrovatoException("Autore con id "+ id + " non trovato");
        }
    }


    @PutMapping(path = "/api/autore/{id}",produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Autore updateAutore(@PathVariable int id, @RequestBody Autore autoreUpd) throws AutoreNonTrovatoException {
        return autoreService.updateAutore(id, autoreUpd);
    }

    @DeleteMapping("/api/autore/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAutore(@PathVariable int id) throws AutoreNonTrovatoException {
        autoreService.deleteAutore(id);
    }


    @GetMapping("/api")
    public String benvenuto(){
        return "benvenuto";
    }
}
