package services;

import daos.SignupDaoImpl;
import entities.User;
import servicesInterfaces.LoginService;

public class LoginServiceImpl extends BasicServiceImpl<User> implements LoginService {

	@Override
	public SignupDaoImpl getDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
