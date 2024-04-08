package com.springmvc.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
	public User loginUser(String user_id, String password) {
		String sql = "SELECT * FROM User WHERE user_id = ? AND password = ?";
		return template.queryForObject(sql, new Object[] { user_id, password }, (rs, rowNum) -> {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUser_id(rs.getString("user_id"));
			user.setPassword(rs.getString("password"));
			user.setNickname(rs.getString("nickname"));
			user.setEmail(rs.getString("email"));
			user.setJoin_datetime(rs.getTimestamp("join_datetime").toLocalDateTime());
			return user;
		});
	}

	@Override
	public User getUserById(Long id) {
		return null;
	}

	@Override
	public User createUser(User user) {
		String sql = "insert into User values(?,?,?,?,?,?)";
		template.update(sql, null, user.getUser_id(), user.getPassword(), user.getNickname(), user.getEmail(),
				LocalDateTime.now());
		return user;
	}

	@Override
	public User updateUser(Long id, User user) {
		return null;
	}

	@Override
	public void deleteUser(Long id) {

	}

}
