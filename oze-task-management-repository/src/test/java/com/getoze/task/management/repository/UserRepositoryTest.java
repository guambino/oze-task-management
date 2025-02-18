package com.getoze.task.management.repository;

import com.getoze.task.management.domain.repository.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void save(){
        User user = userRepository.save(getUser());
        assertNotNull(user);
        assertNotNull(user.getUserId());
    }

    @Test
    public void findByEmail(){
        Optional<User> user = userRepository.findByEmail("tony.starks@marvel.com");
        assertTrue(user.isPresent());
    }

    @Test
    public void existsByEmail(){
        Boolean exists = userRepository.existsByEmail("tony.starks@marvel.com");
        assertTrue(exists);

        exists = userRepository.existsByEmail("iron.man@marvel.com");
        assertFalse(exists);
    }


    private User getUser(){
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john@doe.com");
        user.setPassword("password");
        return user;
    }
}
