package servicesInterfaces;

import javax.ejb.Local;

import entities.User;

public interface SignupService extends BasicService<User> {

	public void registerUser(User user);
	
	public void customDMD();
}
