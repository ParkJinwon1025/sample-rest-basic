package com.ubisam.demo.api.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ubisam.demo.domain.User;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository; 

    @Test
	void contextLoads() {

        User u1 = new User();
        u1.setName("Alice");
        userRepository.save(u1);

        Object r1=userRepository.findAll();
        System.out.println(r1);

	}

}
