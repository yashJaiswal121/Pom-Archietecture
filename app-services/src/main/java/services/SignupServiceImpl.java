package services;

import entities.User;
import servicesInterfaces.SignupService;
import servicesInterfaces.UserService;

public class SignupServiceImpl implements SignupService {

    private UserService userService = new UserServiceImpl();

    public void registerUser(User newUser) {
        userService.add(newUser);
    }
}
