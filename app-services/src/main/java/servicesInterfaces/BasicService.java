package servicesInterfaces;

public interface BasicService<T> {
	
	public void add(T entity);
	
	public T findById(Long id);
	
	public void update(T oldEntity, T newEntity);
	
	public void delete(T entity);
}
