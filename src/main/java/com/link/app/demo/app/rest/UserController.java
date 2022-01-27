package com.link.app.demo.app.rest;

import com.link.app.demo.app.request.AddUserRequest;
import com.link.app.demo.app.request.UpdateUserRequest;
import com.link.app.demo.user.presentation.user.AddUserResponse;
import com.link.app.demo.user.presentation.user.GetUserResponse;
import com.link.app.demo.user.presentation.user.GetUsersResponse;
import com.link.app.demo.user.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/users")
public class UserController {

    private final IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<GetUsersResponse>> getAllUsers(){
        var users = service.getAllUsers();
        return new ResponseEntity(users, HttpStatus.OK);
    }
    @GetMapping("/p")
    ResponseEntity<List<GetUsersResponse>> getAllUsersWithPaging(@RequestParam int page,@RequestParam int size){
        var users = service.getAllUsersWithPaging(page,size);
        return new ResponseEntity(users,HttpStatus.OK);
    }
    @GetMapping("/q")
    ResponseEntity<List<GetUsersResponse>> searchUsers(@RequestParam String name){
        var users = service.searchUsers(name);
        return new ResponseEntity(users, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    ResponseEntity<GetUserResponse> getUser(@PathVariable int id){
        return new ResponseEntity(service.getUserById(id),HttpStatus.OK);
    }
    @PostMapping
    ResponseEntity<AddUserResponse> addUser(@Valid @RequestBody AddUserRequest userRequest){
        var response = service.addUser(userRequest);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    ResponseEntity updateUser(@PathVariable int id, @Valid @RequestBody UpdateUserRequest userRequest){
        service.updateUser(id,userRequest);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
