package com.mublog.dao;

import java.util.List;

import com.mublog.entity.Article;

import com.mublog.exception.InstanceNotFoundException;

public interface ArticleDao {

	
    Article findById(Long id) throws InstanceNotFoundException;
    
    Article findByName (String articleName) throws InstanceNotFoundException;
    
    void save(Article article);
    
    void update(Article article);
    
    void deleteById(Long id) throws InstanceNotFoundException;
     
    List<Article> findAll();
	

}
