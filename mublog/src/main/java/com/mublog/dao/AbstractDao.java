package com.mublog.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

 
public abstract class AbstractDao<PK extends Serializable, T> {
     
	private Class< T > clazz;
	 
	   @Autowired
	   SessionFactory sessionFactory;
	   
	   @Autowired
	   HibernateTemplate hibernateTemplate;
	 
	   public final void setClazz( Class< T > clazzToSet ){
	      this.clazz = clazzToSet;
	   }
	 
	   public T findOne( long id ){
	      return (T) getCurrentSession().get( clazz, id );
	   }
	   
	   @SuppressWarnings("unchecked")
	   public List< T > findAll(){
	      return getCurrentSession().createQuery( "from " + clazz.getName() ).list();
	   }
	 
	   public void save( T entity ){
	      getCurrentSession().persist( entity );
	   }
	 
	   public void update( T entity ){
	      getCurrentSession().merge( entity );
	   }
	 
	   public void delete( T entity ){
	      getCurrentSession().delete( entity );
	   }
	   public void deleteById( long entityId ) {
	      T entity = findOne( entityId );
	      delete( entity );
	   }
	 
	   protected final Session getCurrentSession(){
	      return sessionFactory.getCurrentSession();
	   }

		@SuppressWarnings("unchecked")
		public boolean isObjectExists(String hqlQuery,Object... values) {
			List<T> list = (List<T>) hibernateTemplate.findByNamedQuery(hqlQuery,values);
			return list.size() > 0 ? true : false;
		}
		
		public boolean isExists(Class<?> clazz,String attribute ,Object idValue) {
		    return getCurrentSession().createCriteria(clazz)
		            .add(Restrictions.eq(attribute, idValue))
		            .setProjection(Projections.id())
		            .uniqueResult() != null;
		}

 
}
