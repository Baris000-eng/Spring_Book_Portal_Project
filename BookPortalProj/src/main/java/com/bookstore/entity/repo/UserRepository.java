package com.bookstore.entity.repo;

import com.bookstore.entity.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long>{
    User findByUsername(String username);

    User findByEmail(String email);
}
