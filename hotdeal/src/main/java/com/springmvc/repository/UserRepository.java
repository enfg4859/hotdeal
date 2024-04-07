package com.springmvc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.domain.User;

@Repository
public interface UserRepository {

    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
