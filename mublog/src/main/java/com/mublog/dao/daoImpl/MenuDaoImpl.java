package com.mublog.dao.daoImpl;

import java.util.List;

import javax.persistence.NoResultException;
import com.mublog.exception.InstanceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mublog.dao.AbstractDao;
import com.mublog.dao.MenuDao;
import com.mublog.entity.Menu;

@Repository
public class MenuDaoImpl extends AbstractDao<Long, Menu> implements MenuDao {
 
    static final Logger logger = LoggerFactory.getLogger(MenuDaoImpl.class);
    
	public Menu findById(Long id) throws InstanceNotFoundException {
		try {
			Menu menu = (Menu) getCurrentSession().createQuery("SELECT u FROM Menu u WHERE u.id LIKE :id")
					.setParameter("id", id).uniqueResult();

			if (menu == null) {
				throw new InstanceNotFoundException("Menu not found for id:" + id);
			}
			return menu;
		} catch (Exception e) {
			throw new InstanceNotFoundException("Menu not found for id:" + id);
		}
	}

	public Menu findByName(String menuName) throws InstanceNotFoundException {
		try {
			logger.debug("Inside findByName method , where menu name is "+menuName+".");
			Menu menu = (Menu) getCurrentSession().createQuery("SELECT u FROM Menu u WHERE u.menuName LIKE :menuName")
					.setParameter("menuName", menuName).uniqueResult();

			return menu;
		} catch (NoResultException ex) {
			throw new InstanceNotFoundException(ex);
		}
	}

	
	@SuppressWarnings("unchecked")
	public List<Menu> findAll() {
		List<Menu> menus = getCurrentSession().createQuery("FROM Menu i ORDER BY i.id asc").list();
		return menus;
	}


	public void deleteById(Long id) throws InstanceNotFoundException {
		try {
			Menu menu = (Menu) getCurrentSession().createQuery("SELECT u FROM Menu u WHERE u.id LIKE :id")
					.setParameter("id", id).uniqueResult();
			delete(menu);
		} catch (NoResultException ex) {
			throw new InstanceNotFoundException(ex);
		}
	}



	
     
}
