package com.link.app.demo.user.infrastructure;

import com.link.app.demo.user.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    /**
     * Get user by id
     * @param id
     * @return Optional User
     */
    Optional<User> getUserById(int id);

    /**
     * All users
     * @return
     */
    List<User> getAllUsers();

    /**
     * Get all users with the page and size
     * @param page
     * @param size
     * @return
     */
    Page<User> getUsersWithPagination(int page, int size);

    /**
     * Add user without id<br>
     * Update user with id<br>
     * @param user
     */
    User addOrUpdateUser(User user);

    /**
     * Find the users by contains the search name in first name and last name
     * @param name
     * @return
     */
    List<User> searchUsers(String name);
}
