package it.epicode.blogexercise.controller;


import it.epicode.blogexercise.Dto.AutoreDto;
import it.epicode.blogexercise.exception.AutoreNonTrovatoException;
import it.epicode.blogexercise.exception.BadRequestException;
import it.epicode.blogexercise.model.Autore;
import it.epicode.blogexercise.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @PostMapping("/api/autore")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveAutore(@RequestBody @Validated AutoreDto autoreDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream().
                    map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s+s2)));
        }
        return autoreService.saveAutore(autoreDto);
    }


    @GetMapping("/api/autore")
    public Page<Autore> getTuttiAutori(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "15") int size,
                                       @RequestParam(defaultValue = "id") String sortBy) {
        return autoreService.getAutori(page, size, sortBy);
    }

    @GetMapping("/api/autore/{id}")
    public Autore getAutoreById(@PathVariable int id) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOptional = autoreService.getAutoreById(id);
        if (autoreOptional.isPresent()) {
            return autoreOptional.get();
        } else {
            throw new AutoreNonTrovatoException("Autore con id "+ id + " non trovato");
        }
    }


    @PutMapping("/api/autore/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Autore updateAutore(@PathVariable int id, @RequestBody @Validated AutoreDto autoreDtoUpd, BindingResult bindingResult) throws AutoreNonTrovatoException {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream().
                    map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s+s2)));
        }
        return autoreService.updateAutore(id, autoreDtoUpd);
    }

    @DeleteMapping("/api/autore/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteAutore(@PathVariable int id) throws AutoreNonTrovatoException {
        return autoreService.deleteAutore(id);
    }


    @GetMapping("/api")
    public String benvenuto(){
        return "Benvenuto nell'api dei Blog";
    }

    @PatchMapping("/api/autore/{id}")
    public String patchAvatar(@RequestBody MultipartFile avatar, @PathVariable int id) throws AutoreNonTrovatoException, IOException {
        return autoreService.patchAvatarAutore(id, avatar);

    }
}
