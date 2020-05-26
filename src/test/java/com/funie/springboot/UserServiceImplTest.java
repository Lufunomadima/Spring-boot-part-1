package com.funie.springboot;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.funie.springboot.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@EnableAutoConfiguration
@SpringBootTest(classes = SpringbootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)


class UserServiceImplTest {
    // user details
    private final String  name;
    private final String surname;

    private UserService userService;

    UserServiceImplTest() {
        name = "Lufuno";
        surname = "Madima";
    }
    @Test
    void addUser() {
        assertEquals("Lufuno", userService.addUser(1,name, surname));
    }
    @Test
    void remove() {
    }
    @Test
    void getUser() {
        User user =  new User();
        user.setName(name);
        user.setSurname(surname);
        user.setId(1);
        assertEquals(user.getId(), userService.getUser(1));
    }
}

