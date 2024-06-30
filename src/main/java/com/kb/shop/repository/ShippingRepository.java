package com.kb.shop.repository;

import com.kb.shop.domain.ShippingInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShippingRepository {

    private final JdbcTemplate jdbcTemplate;

    public ShippingRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public ShippingInfo selectShippingInfo(Long id){
        String sql = "SELECT * FROM shipping_info WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(ShippingInfo.class));
    }

    public void setShippingInfo(ShippingInfo shippingInfo){
        String sql = "INSERT INTO shipping_info (status) VALUES (?)";
        jdbcTemplate.update(sql, shippingInfo.getStatus());
    }


}
