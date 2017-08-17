package com.mublog.dao.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mublog.dao.AbstractDao;
import com.mublog.dao.RoleDao;
import com.mublog.entity.Role;

@Repository
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao {
 
    static final Logger logger = LoggerFactory.getLogger(RoleDaoImpl.class);
     
    public Role findById(int id) {
        Role role = getByKey(id);
        if(role!=null){
            Hibernate.initialize(role.getRoleProfiles());
        }
        return role;
    }
 
    /*public Role findBySSO(String sso) {
        logger.info("SSO : {}", sso);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        Role role = (Role)crit.uniqueResult();
        if(role!=null){
            Hibernate.initialize(role.getRoleProfiles());
        }
        return role;
    }*/
 
    @SuppressWarnings("unchecked")
    public List<Role> getRoleList() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("roleName"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Role> roles = (List<Role>) criteria.list();
         
        // No need to fetch roleProfiles since we are not showing them on list page. Let them lazy load. 
        // Uncomment below lines for eagerly fetching of roleProfiles if you want.
        /*
        for(Role role : roles){
            Hibernate.initialize(role.getRoleProfiles());
        }*/
        System.out.println("roles--"+roles.toString());
        return roles;
    }
 
    public void save(Role role) {
        persist(role);
    }

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}
 
    /*public void deleteBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        Role role = (Role)crit.uniqueResult();
        delete(role);
    }*/

}
