package com.mublog.dao.daoImpl;

import java.util.List;

import javax.persistence.NoResultException;
import com.mublog.exception.InstanceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mublog.dao.AbstractDao;
import com.mublog.dao.UserDao;
import com.mublog.entity.User;

@Repository
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {
 
    static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    
	public User findById(Long id) throws InstanceNotFoundException {
		try {
			User user = (User) getCurrentSession().createQuery("SELECT u FROM User u WHERE u.id LIKE :id")
					.setParameter("id", id).uniqueResult();

			if (user == null) {
				throw new InstanceNotFoundException("User not found for id:" + id);
			}
			return user;
		} catch (Exception e) {
			throw new InstanceNotFoundException("User not found for id:" + id);
		}
	}

	public User findByName(String userName) throws InstanceNotFoundException {
		try {
			User user = (User) getCurrentSession().createQuery("SELECT u FROM User u WHERE u.userName LIKE :userName")
					.setParameter("userName", userName).uniqueResult();

			return user;
		} catch (NoResultException ex) {
			throw new InstanceNotFoundException(ex);
		}
	}

	
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		List<User> users = getCurrentSession().createQuery("FROM User i ORDER BY i.id asc").list();
		return users;
	}


	public void deleteById(Long id) throws InstanceNotFoundException {
		try {
			User user = (User) getCurrentSession().createQuery("SELECT u FROM User u WHERE u.id LIKE :id")
					.setParameter("id", id).uniqueResult();
			delete(user);
		} catch (NoResultException ex) {
			throw new InstanceNotFoundException(ex);
		}
	}



	
     
}
