package com.mublog.dao.daoImpl;

import java.util.List;

import javax.persistence.NoResultException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mublog.dao.AbstractDao;
import com.mublog.dao.ArticleCategoryDao;
import com.mublog.entity.ArticleCategory;

import com.mublog.exception.InstanceNotFoundException;

@Repository
public class ArticleCategoryDaoImpl extends AbstractDao<Integer, ArticleCategory> implements ArticleCategoryDao {
 
	 static final Logger logger = LoggerFactory.getLogger(ArticleCategoryDaoImpl.class);
	    
		public ArticleCategory findById(Long id) throws InstanceNotFoundException {
			try {
				ArticleCategory articleCategory = (ArticleCategory) getCurrentSession().createQuery("SELECT ac FROM ArticleCategory ac WHERE ac.id LIKE :id")
						.setParameter("id", id).uniqueResult();

				if (articleCategory == null) {
					throw new InstanceNotFoundException("ArticleCategory not found for id:" + id);
				}
				return articleCategory;
			} catch (Exception e) {
				throw new InstanceNotFoundException("ArticleCategory not found for id:" + id);
			}
		}

		public ArticleCategory findByName(String articleCategoryName) throws InstanceNotFoundException {
			try {
				ArticleCategory articleCategory = (ArticleCategory) getCurrentSession().createQuery("SELECT ac FROM ArticleCategory ac WHERE ac.articleCategoryName LIKE :articleCategoryName")
						.setParameter("articleCategoryName", articleCategoryName).uniqueResult();

				return articleCategory;
			} catch (NoResultException ex) {
				throw new InstanceNotFoundException(ex);
			}
		}

		
		@SuppressWarnings("unchecked")
		public List<ArticleCategory> findAll() {
			List<ArticleCategory> articleCategories = getCurrentSession().createQuery("FROM ArticleCategory i ORDER BY i.id asc").list();
			return articleCategories;
		}


		public void deleteById(Long id) throws InstanceNotFoundException {
			try {
				ArticleCategory articleCategory = (ArticleCategory) getCurrentSession().createQuery("SELECT r FROM ArticleCategory r WHERE r.id LIKE :id")
						.setParameter("id", id).uniqueResult();
				delete(articleCategory);
			} catch (NoResultException ex) {
				throw new InstanceNotFoundException(ex);
			}
		}

    

}
