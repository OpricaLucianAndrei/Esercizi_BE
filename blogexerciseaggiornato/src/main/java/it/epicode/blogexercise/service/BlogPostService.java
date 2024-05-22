package it.epicode.blogexercise.service;

import it.epicode.blogexercise.Dto.BlogPostDto;
import it.epicode.blogexercise.exception.AutoreNonTrovatoException;
import it.epicode.blogexercise.exception.BlogPostNonTrovatoException;
import it.epicode.blogexercise.model.Autore;
import it.epicode.blogexercise.model.BlogPost;
import it.epicode.blogexercise.repository.AutoreRepository;
import it.epicode.blogexercise.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private AutoreRepository autoreRepository;

    public String saveBlogPost(BlogPostDto blogPostDto) throws AutoreNonTrovatoException {
        BlogPost blogPost = new BlogPost();
        blogPost.setCategoria(blogPostDto.getCategoria());
        blogPost.setTitolo(blogPostDto.getTitolo());
        blogPost.setContenuto(blogPostDto.getContenuto());
        blogPost.setTempoDiLetturaMinuti(blogPostDto.getTempoDiLetturaMinuti());
        blogPost.setCover("https://picsum.photos/200/300");

        Optional<Autore> autoreOptional = autoreRepository.findById(blogPostDto.getAutoreId());

        if (autoreOptional.isPresent()) {
            Autore autore = autoreOptional.get();
            blogPost.setAutore(autore);
            blogPostRepository.save(blogPost);
            return "Post salvato con successo con id " + blogPost.getId();
        } else {
            throw new AutoreNonTrovatoException("Autore con id " + blogPost.getId() + " non trovato");
        }

    }

    public Page<BlogPost> getBlogPostList(int page, int size, String sortBy ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return blogPostRepository.findAll(pageable);
    }

    public Optional<BlogPost> getBlogPostById(int id) {
        return blogPostRepository.findById(id);
    }

    public BlogPost updateBlogPost(int id, BlogPostDto blogPostDtoUpd) throws BlogPostNonTrovatoException, AutoreNonTrovatoException {
        Optional<BlogPost> blogPostOptional = getBlogPostById(id);

        if (blogPostOptional.isPresent()) {
            BlogPost blogPost = blogPostOptional.get();
            blogPost.setCategoria(blogPostDtoUpd.getCategoria());
            blogPost.setTitolo(blogPostDtoUpd.getTitolo());
            blogPost.setCover("https://picsum.photos/200/300");
            blogPost.setContenuto(blogPostDtoUpd.getContenuto());
            blogPost.setTempoDiLetturaMinuti(blogPostDtoUpd.getTempoDiLetturaMinuti());

            Optional<Autore> autoreOptional = autoreRepository.findById(blogPostDtoUpd.getAutoreId());

            if (autoreOptional.isPresent()) {
                Autore autore = autoreOptional.get();
                blogPost.setAutore(autore);
                blogPostRepository.save(blogPost);
                return blogPost;
            } else {
                throw new AutoreNonTrovatoException("Autore con id " + blogPostDtoUpd.getAutoreId() + " non trovato");
            }

        } else {
            throw new BlogPostNonTrovatoException("Post non trovato");
        }
    }

    public String deleteBlogPost(int id) throws BlogPostNonTrovatoException {
        Optional<BlogPost> blogPostOptional = blogPostRepository.findById(id);
        if (blogPostOptional.isPresent()) {
            blogPostRepository.delete(blogPostOptional.get());
            return "Post con id "+ id +" cancellato con successo";
        } else {
            throw new BlogPostNonTrovatoException("Post con id "+ id +" non trovato");
        }
    }
}
