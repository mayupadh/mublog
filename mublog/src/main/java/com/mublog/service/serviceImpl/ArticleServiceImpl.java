package com.mublog.service.serviceImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mublog.dao.ArticleDao;
import com.mublog.entity.Article;
import com.mublog.exception.InstanceNotFoundException;
import com.mublog.service.ArticleService;

 
@Service("articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService{
     
	@Autowired
	ArticleDao articleDao;


	public Article findById(Long i) throws InstanceNotFoundException {
		return articleDao.findById(i);
	}

	public Article findByName(String articleName) throws InstanceNotFoundException {
		return articleDao.findByName(articleName);
	}


	public void save(Article article) {
		articleDao.save(article);
	}

	public void update(Article article) {
		articleDao.update(article);
	}

	public void deleteById(Long id) throws InstanceNotFoundException {
		articleDao.deleteById(id);
	}

	public List<Article> findAll() {
		List<Article> articles = articleDao.findAll();
		return articles;
	}

	/*public List<Article> findAllActive() {
		List<Article> articles = articleDao.findAllActive();
		return convertToDiscountApliedArticleList(articles);
	}*/
	
	public boolean isArticleExist(Article article) {
		boolean flag = false;
		try {
			 flag = findById(article.getArticle_Id()) != null?true:false;
		} catch (InstanceNotFoundException ex) {
			return flag;
		}
		return flag;
	}

}