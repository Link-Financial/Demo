package com.steven.testnavin.service;

import com.steven.testnavin.entity.User;
import com.steven.testnavin.request.UserRequest;

import java.util.List;
import java.util.Set;

public interface UserService {

    User getUserById(Integer id);

    User createUser(UserRequest userRequest);

    User updateUser(Integer id, UserRequest userRequest);

    Set<User> getAllUsers();

    List<User> getAllUsersByName(String name);

}
