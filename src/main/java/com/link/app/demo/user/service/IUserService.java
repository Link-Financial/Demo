package com.link.app.demo.user.service;

import com.link.app.demo.app.request.AddUserRequest;
import com.link.app.demo.app.request.UpdateUserRequest;
import com.link.app.demo.user.presentation.user.AddUserResponse;
import com.link.app.demo.user.presentation.user.GetUserResponse;
import com.link.app.demo.user.presentation.user.GetUsersResponse;

import java.util.List;

public interface IUserService {
    /**
     * Return all users in {@link GetUserResponse}
     * @see GetUserResponse
     * @return
     */
    List<GetUsersResponse> getAllUsers();
    /**
     * Return all users with page and size in {@link GetUserResponse}
     * @see GetUserResponse
     * @return
     */
    List<GetUsersResponse> getAllUsersWithPaging(int page,int size);
    /**
     * Find the users by contains the search name in first name and last name
     * @param name
     * @return
     */
    List<GetUsersResponse> searchUsers(String name);
    /**
     * Get user by id
     * @param id
     * @return Optional<User>
     */
    GetUserResponse getUserById(int id);

    /**
     * Add user
     * @see AddUserRequest
     * @param userRequest
     */
    AddUserResponse addUser(AddUserRequest userRequest);

    /**
     * Update user
     * @param id
     * @param userRequest
     * @see UpdateUserRequest
     */
    void updateUser(int id,UpdateUserRequest userRequest);
}
