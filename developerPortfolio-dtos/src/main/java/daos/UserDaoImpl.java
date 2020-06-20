package daos;

import javax.ejb.Stateless;

import daoInterfaces.UserDao;
import entities.User;

public class UserDaoImpl extends BasicDaoImpl<User> implements UserDao {

	public void dmdCheck() {
		System.out.println("cszdvxdvzdfzf");
	}

}
