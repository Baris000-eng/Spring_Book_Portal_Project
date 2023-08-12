package com.bookstore.entity.cache;

import com.bookstore.entity.model.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;


@Component("userCacheSingleton")
@Scope("singleton")
public class UserCacheSingleton implements UserCache{
    private static final Logger LOGGER = LoggerFactory.getLogger(UserCachePrototype.class);
    public Map<String, UserDTO> users;


    @PostConstruct
    public void init() {
        LOGGER.info("Singleton bean constructed !!!");
        users = new HashMap<>();
    }

    @Override
    public void put(UserDTO dto) {
        users.put(dto.getUsername(),dto);
    }

    @Override
    public void destroy() {
        LOGGER.info("Singleton bean is destroyed !!");
    }


    @Override
    public Map<String, UserDTO> getMap() {
       return users;
    }
}
