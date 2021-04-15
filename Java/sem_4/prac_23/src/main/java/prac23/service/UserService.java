package prac23.service;

import prac23.model.User;
import prac23.controllers.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByLogin(String login);

    User save(UserRegistrationDto registration, String cookie);
}
