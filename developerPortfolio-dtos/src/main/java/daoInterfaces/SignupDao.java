package daoInterfaces;

import javax.ejb.Local;

import entities.User;

//@Local
public interface SignupDao extends BasicDao<User> {

	public void dmdCheck();
	
}
