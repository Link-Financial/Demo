package com.link.app.demo.user.service;

import com.link.app.demo.app.exception.UserNotFoundException;
import com.link.app.demo.app.request.AddUserRequest;
import com.link.app.demo.app.request.UpdateUserRequest;
import com.link.app.demo.user.entity.User;
import com.link.app.demo.user.infrastructure.IUserRepository;
import com.link.app.demo.user.presentation.user.AddUserResponse;
import com.link.app.demo.user.presentation.user.GetUserResponse;
import com.link.app.demo.user.presentation.user.GetUsersResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    private final IUserRepository repository;
    private final ModelMapper mapper;

    public UserService(IUserRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<GetUsersResponse> getAllUsers() {
        List<User> userList = repository.getAllUsers();
        return userList.stream().map(x-> mapper.map(x,GetUsersResponse.class)).toList();
    }

    @Override
    public List<GetUsersResponse> getAllUsersWithPaging(int page, int size) {
        var usersList = repository.getUsersWithPagination(page,size);
        return usersList.get().map(x->mapper.map(x,GetUsersResponse.class)).toList();
    }

    @Override
    public List<GetUsersResponse> searchUsers(String name) {
        var userList = repository.searchUsers(name);
        return userList.stream().map(x->mapper.map(x,GetUsersResponse.class)).toList();
    }

    @Override
    public GetUserResponse getUserById(int id) {
        var user = getUser(id);
        return mapper.map(user,GetUserResponse.class);
    }

    @Override
    public AddUserResponse addUser(AddUserRequest userRequest) {
        var user = mapper.map(userRequest,User.class);
        var userResponse = repository.addOrUpdateUser(user);
        return mapper.map(userResponse,AddUserResponse.class);
    }

    @Override
    public void updateUser(int id,UpdateUserRequest userRequest) {
        var user = getUser(id);
        user.updateUser(userRequest.getFirstName(),userRequest.getLastName(), userRequest.getEmail());
        repository.addOrUpdateUser(user);
    }
    private User getUser(int id){
        var user = repository.getUserById(id).get();
        if(user == null) throw new UserNotFoundException();
        return user;
    }
}
