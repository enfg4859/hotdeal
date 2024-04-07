package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.domain.User;
import com.springmvc.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // 모든 사용자 조회
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // 특정 사용자 조회
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // 새로운 사용자 생성
    @PostMapping
    public User createUser(@ModelAttribute("user") User user) {
    	System.out.println("생성");
    	System.out.println(user.getUser_id());
    	System.out.println(user.getPassword());
    	System.out.println(user.getNickname());
    	System.out.println(user.getEmail());
        return userService.createUser(user);
    }

    // 사용자 정보 업데이트
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @ModelAttribute("user") User user) {
        return userService.updateUser(id, user);
    }

    // 사용자 삭제
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}