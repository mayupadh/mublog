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

import com.mublog.entity.ArticleCategory;
import com.mublog.exception.InstanceNotFoundException;
import com.mublog.service.ArticleCategoryService;
  
@RestController
public class ArticleCategoryController {
  
    @Autowired
    ArticleCategoryService articleCategoryService;  //Service which will do all data retrieval/manipulation work
  
     
    //-------------------Retrieve All ArticleCategorys--------------------------------------------------------
      
    @RequestMapping(value = "/articleCategoryDetails", method = RequestMethod.GET)
    public ResponseEntity<List<ArticleCategory>> listAllArticleCategorys() {
        List<ArticleCategory> articleCategorys = articleCategoryService.findAll();
        if(articleCategorys.isEmpty()){
            return new ResponseEntity<List<ArticleCategory>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<ArticleCategory>>(articleCategorys, HttpStatus.OK);
    }
  
  
     
    //-------------------Retrieve Single ArticleCategory--------------------------------------------------------
      
    @RequestMapping(value = "/articleCategoryDetails/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArticleCategory> getArticleCategory(@PathVariable("id") long id) throws InstanceNotFoundException {
        System.out.println("Fetching ArticleCategory with id " + id);
        ArticleCategory articleCategory = articleCategoryService.findById(id);
        if (articleCategory == null) {
            System.out.println("ArticleCategory with id " + id + " not found");
            return new ResponseEntity<ArticleCategory>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ArticleCategory>(articleCategory, HttpStatus.OK);
    }
  
      
      
    //-------------------Create a ArticleCategory--------------------------------------------------------
      
    @RequestMapping(value = "/articleCategoryDetails", method = RequestMethod.POST)
    public ResponseEntity<Void> createArticleCategory(@RequestBody ArticleCategory articleCategory,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating ArticleCategory " + articleCategory.getArticleCategoryName());
  
        if (articleCategoryService.isArticleCategoryExist(articleCategory)) {
            System.out.println("A ArticleCategory with name " + articleCategory.getArticleCategoryName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
  
        articleCategoryService.save(articleCategory);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/articleCategory/{id}").buildAndExpand(articleCategory.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
     
      
    //------------------- Update a ArticleCategory --------------------------------------------------------
      
    @RequestMapping(value = "/articleCategoryDetails/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ArticleCategory> updateArticleCategory(@PathVariable("id") long id, @RequestBody ArticleCategory articleCategory) throws InstanceNotFoundException {
        System.out.println("Updating ArticleCategory " + id);
          
        ArticleCategory currentArticleCategory = articleCategoryService.findById(id);
          
        if (currentArticleCategory==null) {
            System.out.println("ArticleCategory with id " + id + " not found");
            return new ResponseEntity<ArticleCategory>(HttpStatus.NOT_FOUND);
        }
  
        currentArticleCategory.setArticleCategoryName(articleCategory.getArticleCategoryName());
     
        articleCategoryService.update(currentArticleCategory);
        return new ResponseEntity<ArticleCategory>(currentArticleCategory, HttpStatus.OK);
    }
  
     
     
    //------------------- Delete a ArticleCategory --------------------------------------------------------
      
    @RequestMapping(value = "/articleCategoryDetails/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ArticleCategory> deleteArticleCategory(@PathVariable("id") long id) throws InstanceNotFoundException {
        System.out.println("Fetching & Deleting ArticleCategory with id " + id);
  
        ArticleCategory articleCategory = articleCategoryService.findById(id);
        if (articleCategory == null) {
            System.out.println("Unable to delete. ArticleCategory with id " + id + " not found");
            return new ResponseEntity<ArticleCategory>(HttpStatus.NOT_FOUND);
        }
  
        articleCategoryService.deleteById(id);
        return new ResponseEntity<ArticleCategory>(HttpStatus.NO_CONTENT);
    }
  
      
     
    //------------------- Delete All ArticleCategorys --------------------------------------------------------
      
   /* @RequestMapping(value = "/articleCategoryDetails", method = RequestMethod.DELETE)
    public ResponseEntity<ArticleCategory> deleteAllArticleCategorys() {
        System.out.println("Deleting All ArticleCategorys");
  
        articleCategoryService.deleteAllArticleCategorys();
        return new ResponseEntity<ArticleCategory>(HttpStatus.NO_CONTENT);
    }*/
  
}
