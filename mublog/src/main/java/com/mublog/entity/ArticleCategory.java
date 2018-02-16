package com.mublog.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="article_categories")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class ArticleCategory implements Serializable {

	 /*
	  * private fields
	  */
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public String toString() {
		return "ArticleCategory [id=" + id + ",categoryName=" +categoryName + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name = "CategoryName")
	String categoryName;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getArticleCategoryName() {
		return categoryName;
	}
	public void setArticleCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	
}
