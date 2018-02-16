package com.mublog.dao.daoImpl;

import java.util.List;

import javax.persistence.NoResultException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mublog.dao.AbstractDao;
import com.mublog.dao.RoleDao;
import com.mublog.entity.Role;

import com.mublog.exception.InstanceNotFoundException;

@Repository
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao {
 
	 static final Logger logger = LoggerFactory.getLogger(RoleDaoImpl.class);
	    
		public Role findById(Long id) throws InstanceNotFoundException {
			try {
				Role role = (Role) getCurrentSession().createQuery("SELECT r FROM Role r WHERE r.id LIKE :id")
						.setParameter("id", id).uniqueResult();

				if (role == null) {
					throw new InstanceNotFoundException("Role not found for id:" + id);
				}
				return role;
			} catch (Exception e) {
				throw new InstanceNotFoundException("Role not found for id:" + id);
			}
		}

		public Role findByName(String roleName) throws InstanceNotFoundException {
			try {
				Role role = (Role) getCurrentSession().createQuery("SELECT r FROM Role r WHERE u.roleName LIKE :roleName")
						.setParameter("roleName", roleName).uniqueResult();

				return role;
			} catch (NoResultException ex) {
				throw new InstanceNotFoundException(ex);
			}
		}

		
		@SuppressWarnings("unchecked")
		public List<Role> findAll() {
			List<Role> roles = getCurrentSession().createQuery("FROM Role i ORDER BY i.id asc").list();
			return roles;
		}


		public void deleteById(Long id) throws InstanceNotFoundException {
			try {
				Role role = (Role) getCurrentSession().createQuery("SELECT r FROM Role r WHERE r.id LIKE :id")
						.setParameter("id", id).uniqueResult();
				delete(role);
			} catch (NoResultException ex) {
				throw new InstanceNotFoundException(ex);
			}
		}

    

}
