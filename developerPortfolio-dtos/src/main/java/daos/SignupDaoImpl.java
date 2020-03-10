package daos;

import javax.ejb.Stateless;

import daoInterfaces.SignupDao;
import entities.User;

public class SignupDaoImpl<T> extends BasicDaoImpl<User> implements SignupDao {

	public void dmdCheck() {
		System.out.println("cszdvxdvzdfzf");
	}

	
}
