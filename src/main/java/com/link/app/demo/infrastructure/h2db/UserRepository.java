package com.link.app.demo.infrastructure.h2db;

import com.link.app.demo.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    /**
     * Find the users by contains the search name in first name and last name
     * @param firstname
     * @param lastname
     * @return List of user
     */
    List<User> findByFirstNameContainsOrLastNameContainsIgnoreCase(String firstname,String lastname);
}
