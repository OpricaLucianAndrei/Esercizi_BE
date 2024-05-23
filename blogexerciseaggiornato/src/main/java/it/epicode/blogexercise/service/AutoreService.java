package it.epicode.blogexercise.service;


import com.cloudinary.Cloudinary;
import it.epicode.blogexercise.Dto.AutoreDto;
import it.epicode.blogexercise.exception.AutoreNonTrovatoException;
import it.epicode.blogexercise.model.Autore;
import it.epicode.blogexercise.repository.AutoreRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;

    private String generateAvatarUrl(String nome, String cognome) {
        return "https://ui-avatars.com/api/?name=" + nome + "+" + cognome;
    }

    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private JavaMailSenderImpl javaMailSender;

    public String saveAutore(AutoreDto autoreDto) {
        Autore autore = new Autore();
        autore.setNome(autoreDto.getNome());
        autore.setCognome(autoreDto.getCognome());
        autore.setEmail(autoreDto.getEmail());
        autore.setDataDiNascita(autoreDto.getDataDiNascita());
        autore.setAvatar(generateAvatarUrl(autore.getNome(), autore.getCognome()));
        autoreRepository.save(autore);
        sendMail(autore.getEmail());
        return "Autore con id: " + autore.getId() + " creato con successo";
    }


    public Page<Autore> getAutori(int page, int size, String sortBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return autoreRepository.findAll(pageable);
    }

    public Optional<Autore> getAutoreById(int id){
        return autoreRepository.findById(id);
    }

    public Autore updateAutore(int id, AutoreDto autoreDto) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOptional = getAutoreById(id);
        if (autoreOptional.isPresent()) {
            Autore autore = autoreOptional.get();
            autore.setNome(autoreDto.getNome());
            autore.setCognome(autoreDto.getCognome());
            autore.setEmail(autoreDto.getEmail());
            autore.setDataDiNascita(autoreDto.getDataDiNascita());
            autore.setAvatar(generateAvatarUrl(autore.getNome(), autore.getCognome()));
            autoreRepository.save(autore);
            return autore;
        } else {
            throw new AutoreNonTrovatoException("Autore con id "+ id + " non trovato");
        }
    }

    public String deleteAutore(int id) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOptional = getAutoreById(id);
        if (autoreOptional.isPresent()) {
            autoreRepository.delete(autoreOptional.get());
            return "Autore con id "+ id +" eliminato con successo";
        } else {
            throw new AutoreNonTrovatoException("Autore con id" + id + " non trovato");
        }
    }

    public String patchAvatarAutore (int id, MultipartFile avatar) throws AutoreNonTrovatoException, IOException {
        Optional<Autore> autoreOptional = getAutoreById(id);
        if (autoreOptional.isPresent()) {
            String url = (String) cloudinary.uploader().upload(avatar.getBytes(), Collections.emptyMap()).get("url");
            Autore autore = autoreOptional.get();
            autore.setAvatar(url);
            autoreRepository.save(autore);
            return "Autore con id " + id + " aggiornato con successo con la foto inviata";
        } else {
            throw new AutoreNonTrovatoException("Autore con id "+ id + " non trovato");
        }
    }

    private void sendMail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Registrazione BLOG");
        message.setText("Registrazione al servizio BLOG avvenuta con successo");

        javaMailSender.send(message);
    }
}
