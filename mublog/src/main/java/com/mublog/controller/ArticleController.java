package com.mublog.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mublog.entity.Article;
import com.mublog.exception.InstanceNotFoundException;
import com.mublog.service.ArticleService;
  
@RestController
public class ArticleController {
  
    @Autowired
    ArticleService articleService;  //Service which will do all data retrieval/manipulation work
  
     
    //-------------------Retrieve All Articles--------------------------------------------------------
      
    @RequestMapping(value = "/articleDetails", method = RequestMethod.GET)
    public ResponseEntity<List<Article>> listAllArticles() {
        List<Article> articles = articleService.findAll();
        if(articles.isEmpty()){
            return new ResponseEntity<List<Article>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Article>>(articles, HttpStatus.OK);
    }
  
  
     
    //-------------------Retrieve Single Article--------------------------------------------------------
      
    @RequestMapping(value = "/articleDetails/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Article> getArticle(@PathVariable("id") long id) throws InstanceNotFoundException {
        System.out.println("Fetching Article with id " + id);
        Article article = articleService.findById(id);
        if (article == null) {
            System.out.println("Article with id " + id + " not found");
            return new ResponseEntity<Article>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Article>(article, HttpStatus.OK);
    }
  
      
      
    //-------------------Create a Article--------------------------------------------------------
      
    @RequestMapping(value = "/articleDetails", method = RequestMethod.POST)
    public ResponseEntity<Void> createArticle(@RequestBody Article article,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Article " + article.getTitle());
  
        if (articleService.isArticleExist(article)) {
            System.out.println("A Article with name " + article.getTitle() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
  
        articleService.save(article);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/article/{id}").buildAndExpand(article.getArticle_Id()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
     
      
    //------------------- Update a Article --------------------------------------------------------
      
    @RequestMapping(value = "/articleDetails/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Article> updateArticle(@PathVariable("id") long id, @RequestBody Article article) throws InstanceNotFoundException {
        System.out.println("Updating Article " + id);
          
        Article currentArticle = articleService.findById(id);
          
        if (currentArticle==null) {
            System.out.println("Article with id " + id + " not found");
            return new ResponseEntity<Article>(HttpStatus.NOT_FOUND);
        }
  
        currentArticle.setTitle(article.getTitle());
        
     
        articleService.update(currentArticle);
        return new ResponseEntity<Article>(currentArticle, HttpStatus.OK);
    }
  
     
     
    //------------------- Delete a Article --------------------------------------------------------
      
    @RequestMapping(value = "/articleDetails/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Article> deleteArticle(@PathVariable("id") long id) throws InstanceNotFoundException {
        System.out.println("Fetching & Deleting Article with id " + id);
  
        Article article = articleService.findById(id);
        if (article == null) {
            System.out.println("Unable to delete. Article with id " + id + " not found");
            return new ResponseEntity<Article>(HttpStatus.NOT_FOUND);
        }
  
        articleService.deleteById(id);
        return new ResponseEntity<Article>(HttpStatus.NO_CONTENT);
    }
  
      
     
    //------------------- Delete All Articles --------------------------------------------------------
      
   /* @RequestMapping(value = "/articleDetails", method = RequestMethod.DELETE)
    public ResponseEntity<Article> deleteAllArticles() {
        System.out.println("Deleting All Articles");
  
        articleService.deleteAllArticles();
        return new ResponseEntity<Article>(HttpStatus.NO_CONTENT);
    }*/
  
}
