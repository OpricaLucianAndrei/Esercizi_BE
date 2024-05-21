package it.epicode.blogexercise.controller;


import it.epicode.blogexercise.exception.BlogPostNonTrovatoException;
import it.epicode.blogexercise.model.BlogPost;
import it.epicode.blogexercise.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    @PostMapping("/api/blogpost")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveBlogPost(@RequestBody BlogPost blogPost){
        return blogPostService.saveBlogPost(blogPost);
    }

    @GetMapping("/api/blogpost")
    public List<BlogPost> getAllBlogPost(){
        return blogPostService.getBlogPosts();
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

    @PutMapping(path = "/api/blogpost/{id}",produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BlogPost updateBlogPost(@PathVariable int id, @RequestBody BlogPost blogPostUpd) throws BlogPostNonTrovatoException {
        return blogPostService.updateBlogPost(id, blogPostUpd);
    }


    @DeleteMapping("/api/blogpost/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteBlogPost(@PathVariable int id) throws BlogPostNonTrovatoException {
        return blogPostService.deleteBlogPost(id);
    }





}
