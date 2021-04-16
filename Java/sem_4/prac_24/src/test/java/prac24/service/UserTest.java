package prac24.service;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import prac24.model.User;
import prac24.repositories.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {
    @Mock
    private UserRepository userRepository;
    private UserService userService;
    private PasswordEncoder passwordEncoder;

    @Captor
    private ArgumentCaptor<User> captor;

    @Autowired
    public void setUserAuthService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Before
    public void setUp() {
        User user = new User();
        user.setLogin("user");
        user.setPassword("password");
        user.setId(1L);

        when(userRepository.findByLogin(user.getLogin())).thenReturn(user);
    }

    @Test
    public void UserShouldBeRegister() {
        String encodedPassword = passwordEncoder.encode("qwerty");
        User newUser = new User();
        newUser.setLogin("test");
        newUser.setPassword(encodedPassword);
        newUser.setId(2L);

        when(userRepository.save(any(User.class))).thenReturn(newUser);
        User user = userRepository.save(newUser);

        assertThat(user).isNotNull();
        verify(userRepository).save(captor.capture());
        User captured = captor.getValue();
        assertEquals(newUser.getLogin(), captured.getLogin());
    }

    @Test
    public void UserShouldBeFound() {
        String username = "test";

        UserDetails userDetails = userService.loadUserByUsername(username);
        assertEquals(username, userDetails.getUsername());
    }
}
