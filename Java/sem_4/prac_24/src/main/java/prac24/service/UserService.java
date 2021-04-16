package prac24.service;

import prac24.model.User;
import prac24.controllers.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByLogin(String login);

    User save(UserRegistrationDto registration, String cookie);
}
