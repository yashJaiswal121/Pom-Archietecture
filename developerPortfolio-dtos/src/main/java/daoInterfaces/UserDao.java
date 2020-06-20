package daoInterfaces;

import javax.ejb.Local;

import entities.User;

//@Local
public interface UserDao extends BasicDao<User> {

	public void dmdCheck();
	
}
