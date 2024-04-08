package com.springmvc.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Item;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Item> findAll() {
        String sql = "SELECT * FROM Item";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Item.class));
    }

    @Override
    public Item findById(int id) {
        String sql = "SELECT * FROM Item WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Item.class));
    }

    @Override
    public Item save(Item item) {
        String sql = "INSERT INTO Item (user_id, title, content, url, price, item_created_at) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, item.getUser_id(), item.getTitle(), item.getContent(), item.getUrl(), item.getPrice(), item.getItem_created_at());
        return null;
    }

    @Override
    public Item update(Item item) {
        String sql = "UPDATE Item SET user_id = ?, title = ?, url = ?, price = ?, item_created_at = ? WHERE id = ?";
        jdbcTemplate.update(sql, item.getUser_id(), item.getTitle(), item.getUrl(), item.getPrice(), item.getItem_created_at(), item.getId());
        return null;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM Item WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
