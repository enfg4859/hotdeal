package com.springmvc.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springmvc.domain.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	// JDBC
	private JdbcTemplate template;

	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
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
		String sql = "insert into User values(?,?,?,?,?,?)";
		template.update(sql, null, user.getUser_id(), user.getPassword(), user.getNickname(), user.getEmail(), LocalDateTime.now());
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
