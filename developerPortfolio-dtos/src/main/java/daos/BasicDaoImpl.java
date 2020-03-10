package daos;

import org.hibernate.Session;

import daoInterfaces.BasicDao;
import utils.HibernateUtils;

public abstract class BasicDaoImpl<T> implements BasicDao<T> {
	
	HibernateUtils persistanceContext;

	public void add(T entity) {
		// TODO Auto-generated method stub
		Session session = persistanceContext.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(entity);
		
		session.getTransaction().commit();
		session.close();
	}

	public T findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(T oldEntity, T newEntity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}
}
