package com.steven.testnavin.service.impl;

import com.steven.testnavin.comparator.UserOrderedByFirstName;
import com.steven.testnavin.controller.UserController;
import com.steven.testnavin.entity.User;
import com.steven.testnavin.exception.GetUserException;
import com.steven.testnavin.repository.UserRepository;
import com.steven.testnavin.request.UserRequest;
import com.steven.testnavin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        throw new GetUserException("User not found - Check");
    }

    @Override
    public User createUser(UserRequest userRequest) {
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user = userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(Integer id, UserRequest userRequest) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setEmail(userRequest.getEmail());
            user.setFirstName(userRequest.getFirstName());
            user.setLastName(userRequest.getLastName());
            userRepository.save(user);
            return user;
        }
        throw new GetUserException("User not found for update - Check");
    }

    @Override
    public Set<User> getAllUsers() {
        Iterable<User> users = userRepository.findAll();
        Set<User> userSet = new TreeSet<>(new UserOrderedByFirstName());
        users.forEach(user -> userSet.add(user));
        return userSet;
    }

    @Override
    public List<User> getAllUsersByName(String name) {
        List<User> userList = userRepository.getAllUsersByName(name);
        Collections.sort(userList, new UserOrderedByFirstName());
        return userList;
    }

}
