package com.mublog.service.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mublog.dao.MenuDao;
import com.mublog.entity.Menu;
import com.mublog.exception.InstanceNotFoundException;
import com.mublog.service.MenuService;
 
@Service
@Transactional
public class MenuServiceImpl implements MenuService{
     
	@Autowired
	MenuDao menuDao;


	public Menu findById(Long id) throws InstanceNotFoundException {
		return menuDao.findById(id);
	}

	public Menu findByName(String menuName) throws InstanceNotFoundException {
		return menuDao.findByName(menuName);
	}

	/*public Menu findByBarCode(String barCode) throws InstanceNotFoundException {
		return menuDao.findByBarCode(barCode);
	}*/

	public void save(Menu menu) {
		menuDao.save(menu);
	}

	public void update(Menu menu) {
		menuDao.update(menu);
	}

	public void deleteById(Long id) throws InstanceNotFoundException {
		menuDao.deleteById(id);
	}

	public List<Menu> findAll() {
		List<Menu> menus = menuDao.findAll();
		return menus;
	}

	/*public List<Menu> findAllActive() {
		List<Menu> menus = menuDao.findAllActive();
		return convertToDiscountApliedMenuList(menus);
	}*/
	
	public boolean isMenuExist(Menu menu) {
		boolean flag = false;
		try {
			 flag = findById(menu.getId()) != null?true:false;
		} catch (InstanceNotFoundException ex) {
			return flag;
		}
		return flag;
	}
	
	/*
	 * @Override public String uploadMenuIconImage(String strPath) throws Exception
	 * { String message = ""; message = menuDao.uploadMenuIconImage(strPath); return
	 * message; }
	 */
}