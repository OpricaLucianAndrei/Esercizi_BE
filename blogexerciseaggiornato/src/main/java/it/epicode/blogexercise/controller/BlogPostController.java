package it.epicode.blogexercise.controller;


import it.epicode.blogexercise.Dto.BlogPostDto;
import it.epicode.blogexercise.exception.AutoreNonTrovatoException;
import it.epicode.blogexercise.exception.BlogPostNonTrovatoException;
import it.epicode.blogexercise.model.BlogPost;
import it.epicode.blogexercise.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    @PostMapping("/api/blogpost")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveBlogPosts(@RequestBody BlogPostDto blogPostDto) throws AutoreNonTrovatoException {
        return blogPostService.saveBlogPost(blogPostDto);
    }

    @GetMapping("/api/blogpost")
    public Page<BlogPost> getAllBlogPost(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "15") int size,
                                         @RequestParam(defaultValue = "id") String sortBy){

        return blogPostService.getBlogPostList(page, size, sortBy);
    }

    @GetMapping("/api/blogpost/{id}")
    public BlogPost getBlogPostById(@PathVariable int id) throws BlogPostNonTrovatoException {
        Optional<BlogPost> blogPostOptional = blogPostService.getBlogPostById(id);

        if (blogPostOptional.isPresent()) {
            return blogPostOptional.get();
        } else {
            throw new BlogPostNonTrovatoException("Post con id " + id + " non trovato");
        }
    }

    @PutMapping(path = "/api/blogpost/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BlogPost updateBlogPost(@PathVariable int id, @RequestBody BlogPostDto blogPostDtoUpd) throws BlogPostNonTrovatoException, AutoreNonTrovatoException {
        return blogPostService.updateBlogPost(id, blogPostDtoUpd);
    }


    @DeleteMapping("/api/blogpost/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteBlogPost(@PathVariable int id) throws BlogPostNonTrovatoException {
        return blogPostService.deleteBlogPost(id);
    }





}
