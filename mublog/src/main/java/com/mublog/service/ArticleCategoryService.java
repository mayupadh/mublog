package com.mublog.service;
import java.util.List;

import com.mublog.entity.ArticleCategory;
import com.mublog.exception.InstanceNotFoundException;

 
 
 
public interface ArticleCategoryService {
     
	ArticleCategory findById(Long id) throws InstanceNotFoundException;
	
	ArticleCategory findByName (String articleCategoryName) throws InstanceNotFoundException;
	    
    void save(ArticleCategory articleCategory);
    
    void update(ArticleCategory articleCategory);
    
    void deleteById(Long id) throws InstanceNotFoundException;
     
    List<ArticleCategory> findAll();
    
    //List<ArticleCategory> findAllActive();
     
  
    boolean isArticleCategoryExist(ArticleCategory articleCategory);
     
}