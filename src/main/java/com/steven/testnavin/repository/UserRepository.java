package com.steven.testnavin.repository;

import com.steven.testnavin.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.firstName LIKE %:word% OR u.lastName LIKE %:word% ")
    public List<User> getAllUsersByName(@Param("word") String word);

}
