package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.User;
import com.springmvc.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
    	return null;
    }

    @Override
    public User getUserById(Long id) {
    	return null;
    }

    @Override
    public User createUser(User user) {
    	userRepository.createUser(user);
    	return null;
    }

    @Override
    public User updateUser(Long id, User user) {
    	return null;
    }

    @Override
    public void deleteUser(Long id) {
    }
}
