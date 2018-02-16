package com.mublog.dao.daoImpl;

import java.util.List;

import javax.persistence.NoResultException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mublog.dao.AbstractDao;
import com.mublog.dao.ArticleDao;
import com.mublog.entity.Article;

import com.mublog.exception.InstanceNotFoundException;

@Repository
public class ArticleDaoImpl extends AbstractDao<Integer, Article> implements ArticleDao {
 
	 static final Logger logger = LoggerFactory.getLogger(ArticleDaoImpl.class);
	    
		public Article findById(Long id) throws InstanceNotFoundException {
			try {
				Article article = (Article) getCurrentSession().createQuery("SELECT ac FROM Article ac WHERE ac.id LIKE :id")
						.setParameter("id", id).uniqueResult();

				if (article == null) {
					throw new InstanceNotFoundException("Article not found for id:" + id);
				}
				return article;
			} catch (Exception e) {
				throw new InstanceNotFoundException("Article not found for id:" + id);
			}
		}

		public Article findByName(String articleName) throws InstanceNotFoundException {
			try {
				Article article = (Article) getCurrentSession().createQuery("SELECT ac FROM Article ac WHERE ac.articleName LIKE :articleName")
						.setParameter("articleName", articleName).uniqueResult();

				return article;
			} catch (NoResultException ex) {
				throw new InstanceNotFoundException(ex);
			}
		}

		
		@SuppressWarnings("unchecked")
		public List<Article> findAll() {
			List<Article> articleCategories = getCurrentSession().createQuery("FROM Article i ORDER BY i.id asc").list();
			return articleCategories;
		}


		public void deleteById(Long id) throws InstanceNotFoundException {
			try {
				Article article = (Article) getCurrentSession().createQuery("SELECT r FROM Article r WHERE r.id LIKE :id")
						.setParameter("id", id).uniqueResult();
				delete(article);
			} catch (NoResultException ex) {
				throw new InstanceNotFoundException(ex);
			}
		}

    

}
