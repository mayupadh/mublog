package com.mublog.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="menu_master")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@Column(name = "ParentId")
	long parentId;
	
	
	@Column(name = "MenuType")
	String menuType;
	
	@Column(name = "State")
	String state;
	
	@Column(name = "MenuName")
	String menuName;
	
	@Column(name = "MenuDesc")
	String menuDesc;
	
	@Column(name = "IconName")
	String iconName;
	
	@Lob
    @Column(name="MenuIcon", columnDefinition="longblob")
    private byte[] menuIcon;
	
	@Column(name = "CreatedDate",columnDefinition = "DATE DEFAULT CURRENT_DATE", length = 19)
	 @Temporal(TemporalType.TIMESTAMP)
	Date createdDate;
	
	@Column(name = "UpdatedDate")
	@Temporal(TemporalType.TIMESTAMP)
	Date updatedDate;
	
	
	@Column(name = "CreatedBy")
	String createdBy;
	
	@Column(name = "UpdatedBy")
	String updatedBy;
	
	@ManyToOne(cascade ={CascadeType.ALL})
	@JoinColumn(name="ParentId")
	@Transient
	transient private Menu parentMenu;

	
	@OneToMany(mappedBy="parentMenu")
	transient private Set<Menu> subMenusSet = new HashSet<Menu>();
	
	
	public String getIconName() {
		return iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	public byte[] getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(byte[] menuIcon) {
		this.menuIcon = menuIcon;
	}

	
	public Menu getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}

	public Set<Menu> getSubMenusSet() {
		return subMenusSet;
	}

	public void setSubMenusSet(Set<Menu> subMenusSet) {
		this.subMenusSet = subMenusSet;
	}

	public Date getCreatedDate() {
		 return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public String getState() {
		return state;
	}

	
	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuDesc() {
		return menuDesc;
	}

	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}

	
	public Set<Menu> getSubMenuSet() {
		return this.subMenusSet;
	}

	public void setSubMenuSet(Set<Menu> subMenuSet) {
		this.subMenusSet = subMenuSet;
	}
	
	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}


}
