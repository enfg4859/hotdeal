package com.springmvc.domain;

import java.time.LocalDateTime;

public class User {

    private Long id;
    private String user_id;
    private String password;
    private String nickname;
    private String email;
    private LocalDateTime join_datetime;
    
    public User() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getJoin_datetime() {
		return join_datetime;
	}

	public void setJoin_datetime(LocalDateTime join_datetime) {
		this.join_datetime = join_datetime;
	}
    
    
}