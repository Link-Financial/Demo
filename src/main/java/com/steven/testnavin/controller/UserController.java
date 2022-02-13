package com.steven.testnavin.controller;

import com.steven.testnavin.entity.User;
import com.steven.testnavin.request.UserRequest;
import com.steven.testnavin.response.HttpBaseResponse;
import com.steven.testnavin.response.HttpListUsersResponse;
import com.steven.testnavin.response.HttpUserResponse;
import com.steven.testnavin.response.HttpUsersResponse;
import com.steven.testnavin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpBaseResponse getUser(@PathVariable(value="id") Integer id) {
        User user = userService.getUserById(id);
        return new HttpUserResponse("get", user, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpBaseResponse createUser(@RequestBody UserRequest userRequest) {
        User user = userService.createUser(userRequest);
        return new HttpUserResponse("User - Created", user, HttpStatus.OK);
    }

    @PutMapping(value ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpBaseResponse updateUser(@PathVariable(value="id") Integer id, @RequestBody UserRequest userRequest) {
        User user = userService.updateUser(id, userRequest);
        return new HttpUserResponse("User - Updated", user, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpBaseResponse getAllUsers() {
        Set<User> users = userService.getAllUsers();
        return new HttpUsersResponse("All Users", users, HttpStatus.OK);
    }

    @GetMapping(value= "/q", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpBaseResponse getAllUsersByName(@RequestParam String name) {
        List<User> users = userService.getAllUsersByName(name);
        return new HttpListUsersResponse("All Users By Name : " + name, users, HttpStatus.OK);
    }

}
