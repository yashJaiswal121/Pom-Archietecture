package services;

import entities.User;
import servicesInterfaces.SignupService;
import javax.ejb.Stateless;

import daoInterfaces.BasicDao;
import daoInterfaces.SignupDao;
import daos.SignupDaoImpl;


public class SignupServiceImpl extends BasicServiceImpl<User> implements SignupService {

	SignupDao dao = new SignupDaoImpl();
	
	public void registerUser(User user) {
		super.add(user);
	}
	
	public void customDMD() {
		dao.dmdCheck();
	}
	
	@Override
	public BasicDao getDao(){	
		return dao;
	}

}
