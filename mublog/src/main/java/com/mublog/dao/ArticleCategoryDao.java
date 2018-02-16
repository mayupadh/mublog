package com.mublog.dao;

import java.util.List;

import com.mublog.entity.ArticleCategory;

import com.mublog.exception.InstanceNotFoundException;

public interface ArticleCategoryDao {

	
    ArticleCategory findById(Long id) throws InstanceNotFoundException;
    
    ArticleCategory findByName (String articleCategoryName) throws InstanceNotFoundException;
    
    void save(ArticleCategory articleCategory);
    
    void update(ArticleCategory articleCategory);
    
    void deleteById(Long id) throws InstanceNotFoundException;
     
    List<ArticleCategory> findAll();
	

}
