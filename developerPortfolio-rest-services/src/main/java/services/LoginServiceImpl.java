package services;

import daoInterfaces.BasicDao;
import entities.User;
import servicesInterfaces.LoginService;

public class LoginServiceImpl extends BasicServiceImpl<User> implements LoginService {

	@Override
	public BasicDao getDao() {
		// TODO Will have to return LoginDao instance here...
		return null;
	}

}
