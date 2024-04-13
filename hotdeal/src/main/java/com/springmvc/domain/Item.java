package com.springmvc.domain;

import java.time.LocalDateTime;

public class Item {

    private int id;
    private String user_id;
    private String title;
    private String content;
    private String url;
    private int price;
    private String category;
    private String img;
    private LocalDateTime item_created_at;
    
    public Item() {
    }

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDateTime getItem_created_at() {
		return item_created_at;
	}

	public void setItem_created_at(LocalDateTime item_created_at) {
		this.item_created_at = item_created_at;
	}

	
    
    
}