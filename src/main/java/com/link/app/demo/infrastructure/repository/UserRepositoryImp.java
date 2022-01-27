package com.link.app.demo.infrastructure.repository;

import com.link.app.demo.infrastructure.h2db.UserRepository;
import com.link.app.demo.user.entity.User;
import com.link.app.demo.user.infrastructure.IUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserRepositoryImp implements IUserRepository {

    private final UserRepository repository;

    public UserRepositoryImp(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> getUserById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public Page<User> getUsersWithPagination(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        return repository.findAll(paging);
    }

    @Override
    public User addOrUpdateUser(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> searchUsers(String name) {
        return repository.findByFirstNameContainsOrLastNameContainsIgnoreCase(name,name);
    }
}
