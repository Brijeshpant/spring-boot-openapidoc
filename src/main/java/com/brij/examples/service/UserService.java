package com.brij.examples.service;

import com.brij.examples.resource.UserCreationResponse;
import com.brij.examples.resource.domain.CreateUserRequest;
import com.brij.examples.resource.domain.User;

public interface UserService {
    UserCreationResponse createUser(CreateUserRequest user);

    User getUser(Long userId);
}
