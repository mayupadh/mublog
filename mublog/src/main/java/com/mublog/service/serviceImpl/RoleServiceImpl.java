package com.mublog.service.serviceImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mublog.dao.RoleDao;
import com.mublog.entity.Role;
import com.mublog.exception.InstanceNotFoundException;
import com.mublog.service.RoleService;

 
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService{
     
	@Autowired
	RoleDao roleDao;


	public Role findById(Long i) throws InstanceNotFoundException {
		return roleDao.findById(i);
	}

	public Role findByName(String roleName) throws InstanceNotFoundException {
		return roleDao.findByName(roleName);
	}


	public void save(Role role) {
		roleDao.save(role);
	}

	public void update(Role role) {
		roleDao.update(role);
	}

	public void deleteById(Long id) throws InstanceNotFoundException {
		roleDao.deleteById(id);
	}

	public List<Role> findAll() {
		List<Role> roles = roleDao.findAll();
		return roles;
	}

	/*public List<Role> findAllActive() {
		List<Role> roles = roleDao.findAllActive();
		return convertToDiscountApliedRoleList(roles);
	}*/
	
	public boolean isRoleExist(Role role) {
		boolean flag = false;
		try {
			 flag = findById(role.getId()) != null?true:false;
		} catch (InstanceNotFoundException ex) {
			return flag;
		}
		return flag;
	}

}