package com.mublog.service;
import java.util.List;

import com.mublog.entity.Article;
import com.mublog.exception.InstanceNotFoundException;

 
 
 
public interface ArticleService {
     
	Article findById(Long id) throws InstanceNotFoundException;
	
	Article findByName (String articleName) throws InstanceNotFoundException;
	    
    void save(Article article);
    
    void update(Article article);
    
    void deleteById(Long id) throws InstanceNotFoundException;
     
    List<Article> findAll();
    
    //List<Article> findAllActive();
     
  
    boolean isArticleExist(Article article);
     
}