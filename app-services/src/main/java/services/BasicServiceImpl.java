package services;

import daoInterfaces.BasicDao;
import servicesInterfaces.BasicService;

public abstract class BasicServiceImpl<T> implements BasicService<T> {

	public void add(T entity) {
		
		getDao().add(entity);
		
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
	
	public abstract BasicDao getDao();

}
