package com.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.domain.User;
import com.springmvc.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	// 모든 사용자 조회
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	// 로그인
	@GetMapping("/login")
	@ResponseBody
	public String loginUser(@RequestParam("user_id") String user_id, @RequestParam("password") String password,
			HttpServletRequest request) {
		boolean loginSuccess = userService.loginUser(user_id, password);
		if (loginSuccess) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user_id);
			return "true";
		} else {
			return "false";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}

	// 특정 사용자 조회
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	// 새로운 사용자 생성
	@PostMapping
	public String createUser(@ModelAttribute("user") User user) {
		userService.createUser(user);
		return "main";
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