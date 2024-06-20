package com.tao.taodemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tao.taodemo.model.AppUser;
import com.tao.taodemo.service.UserService;

/**
 * http://localhost:8080/swagger-ui/index.html
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/users/create")
	public Map<String, String> createUser(@RequestBody Map<String, String> parameter) {
		String userName = parameter.get("userName");
		String role = parameter.get("role");
		String password = parameter.get("password");
		userService.createUser(userName, role, password);
		return parameter;
	}

	@GetMapping("/users/all")
	public List<AppUser> getAllUsers() {
		return userService.findAllUser();
	}

	@PostMapping("/user/login")
	public ResponseEntity<Object> login(@RequestBody Map<String, String> parameter) {
		String username = parameter.get("username").toString();
		String password = parameter.get("password").toString();
		Map<String, String> resultMap = new HashMap<>();
		Optional<AppUser> userList = null;
		try {
			userList = userService.userLogin(username, password);
			if (userList.isEmpty() || userList == null) {
				resultMap.put("message", "Not Fuond");
				new ResponseEntity<>(resultMap, HttpStatus.NOT_FOUND);
			} else {
				resultMap.put("message", "Login successful");
			}
		} catch (Exception e) {
			resultMap.put("message", "Login error");
		}

		return new ResponseEntity<>(resultMap, HttpStatus.OK);
	}

}
