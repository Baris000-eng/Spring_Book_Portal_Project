package com.bookstore.entity.cache;

import com.bookstore.entity.model.UserDTO;

import java.util.Map;

public interface UserCache {

    void put(UserDTO dto);

    Map<String,UserDTO> getMap();

    void destroy();

}
