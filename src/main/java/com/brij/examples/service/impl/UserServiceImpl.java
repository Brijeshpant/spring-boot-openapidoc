package com.brij.examples.service.impl;

import com.brij.examples.resource.UserCreationResponse;
import com.brij.examples.resource.domain.CreateUserRequest;
import com.brij.examples.resource.domain.User;
import com.brij.examples.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserCreationResponse createUser(CreateUserRequest user) {
        UserCreationResponse userCreationResponse = new UserCreationResponse();
        userCreationResponse.setUserId(new Random().nextLong());
        userCreationResponse.setMessage("User successfully created");
        return userCreationResponse;
    }

    @Override
    public User getUser(Long userId) {
        User user = new User();
        user.setUserId(userId);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setMiddleName("mid");
        user.setEmail("test@gmail.com");
        return user;
    }
}
