package it.epicode.blogexercise.service;


import it.epicode.blogexercise.exception.BlogPostNonTrovatoException;
import it.epicode.blogexercise.model.BlogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogPostServiceList {

    private List<BlogPost> blogPosts = new ArrayList<>();

    public Optional<BlogPost> getBlogPostById(int id){
        return blogPosts.stream().filter(blogPost -> blogPost.getId()==id).findFirst();
    }

    public List<BlogPost> getBlogPosts() {
        return blogPosts;
    }

    public String saveBlogPost(BlogPost blogPost){
        blogPosts.add(blogPost);
        return "Post creato con questo id: " + blogPost.getId();
    }

    public BlogPost updateBlogPost(int id, BlogPost blogPostUpd) throws BlogPostNonTrovatoException{
        Optional<BlogPost> blogPostOptional = getBlogPostById(id);
        if(blogPostOptional.isPresent()){
            BlogPost blogPost = blogPostOptional.get();
            blogPost.setCategoria(blogPostUpd.getCategoria());
            blogPost.setTitolo(blogPostUpd.getTitolo());
            blogPost.setCover("https://picsum.photos/200/300");
            blogPost.setContenuto(blogPostUpd.getContenuto());
            blogPost.setTempoDiLetturaMinuti(blogPostUpd.getTempoDiLetturaMinuti());
            return blogPost;
        } else {
            throw new BlogPostNonTrovatoException("Post non trovato");
        }

    }

    public String deleteBlogPost(int id) throws BlogPostNonTrovatoException{
        Optional<BlogPost> blogPostOptional = getBlogPostById(id);
        if(blogPostOptional.isPresent()){
            blogPosts.remove(blogPostOptional.get());
            return "Post cancellato";
        } else {
            throw new BlogPostNonTrovatoException("Post non trovato");
        }
    }
}
