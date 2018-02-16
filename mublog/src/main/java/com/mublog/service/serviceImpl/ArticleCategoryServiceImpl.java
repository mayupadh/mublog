package com.mublog.service.serviceImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mublog.dao.ArticleCategoryDao;
import com.mublog.entity.ArticleCategory;
import com.mublog.exception.InstanceNotFoundException;
import com.mublog.service.ArticleCategoryService;

 
@Service("articleCategoryService")
@Transactional
public class ArticleCategoryServiceImpl implements ArticleCategoryService{
     
	@Autowired
	ArticleCategoryDao articleCategoryDao;


	public ArticleCategory findById(Long i) throws InstanceNotFoundException {
		return articleCategoryDao.findById(i);
	}

	public ArticleCategory findByName(String articleCategoryName) throws InstanceNotFoundException {
		return articleCategoryDao.findByName(articleCategoryName);
	}


	public void save(ArticleCategory articleCategory) {
		articleCategoryDao.save(articleCategory);
	}

	public void update(ArticleCategory articleCategory) {
		articleCategoryDao.update(articleCategory);
	}

	public void deleteById(Long id) throws InstanceNotFoundException {
		articleCategoryDao.deleteById(id);
	}

	public List<ArticleCategory> findAll() {
		List<ArticleCategory> articleCategorys = articleCategoryDao.findAll();
		return articleCategorys;
	}

	/*public List<ArticleCategory> findAllActive() {
		List<ArticleCategory> articleCategorys = articleCategoryDao.findAllActive();
		return convertToDiscountApliedArticleCategoryList(articleCategorys);
	}*/
	
	public boolean isArticleCategoryExist(ArticleCategory articleCategory) {
		boolean flag = false;
		try {
			 flag = findById(articleCategory.getId()) != null?true:false;
		} catch (InstanceNotFoundException ex) {
			return flag;
		}
		return flag;
	}

}