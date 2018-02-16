package com.mublog.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="articles")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Article implements Serializable {

	 /*
	  * private fields
	  */
	
	
	/**
	 * 
	 */
	//`Article_Id`, `Title`, `Article_Desc`, `Category_Id`, `Articles_Image`, `Article_Content`, `User_Id`
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long article_Id;
	
	@Column(name = "Title")
	String title;
	
	@Column(name = "Article_Desc")
	String article_Des;
	
	@Column(name = "Category_Id")
	String category_Id;
	
	@Column(name = "Articles_Image")
	Byte[] articles_Image;
	
	@Column(name = "Article_Content")
	String article_Content;
	
	@Column(name = "User_Id")
	Long user_Id;
	
	@Column(name = "Created_Date")
	Date created_Date;

	public String getArticle_Content() {
		return article_Content;
	}

	public void setArticle_Content(String article_Content) {
		this.article_Content = article_Content;
	}

	public Long getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(Long user_Id) {
		this.user_Id = user_Id;
	}

	public Date getCreated_Date() {
		return created_Date;
	}

	public void setCreated_Date(Date created_Date) {
		this.created_Date = created_Date;
	}

	public Long getArticle_Id() {
		return article_Id;
	}

	public void setArticle_Id(Long article_Id) {
		this.article_Id = article_Id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArticle_Des() {
		return article_Des;
	}

	public void setArticle_Des(String article_Des) {
		this.article_Des = article_Des;
	}

	public String getCategory_Id() {
		return category_Id;
	}

	public void setCategory_Id(String category_Id) {
		this.category_Id = category_Id;
	}

	public Byte[] getArticles_Image() {
		return articles_Image;
	}

	public void setArticles_Image(Byte[] articles_Image) {
		this.articles_Image = articles_Image;
	}
	
	
	
	
	
}
