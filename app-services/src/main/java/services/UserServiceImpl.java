package services;

import daoInterfaces.BasicDao;
import daoInterfaces.UserDao;
import daos.UserDaoImpl;
import entities.User;
import servicesInterfaces.UserService;


public class UserServiceImpl extends BasicServiceImpl<User> implements UserService {

	UserDao dao = new UserDaoImpl();

//	public void registerUser(User user) {
//		super.add(user);
//	}
	
	public void customDMD() {
		dao.dmdCheck();
	}
	
	@Override
	public BasicDao getDao(){
		return dao;
	}

}
