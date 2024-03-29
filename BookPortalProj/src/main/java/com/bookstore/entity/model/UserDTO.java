package com.bookstore.entity.model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/users")
public class UserDTO {

    @NotBlank
    @Size(max=255,min=3,message = "Please enter a valid username")
    @Email
    private String username;
    @NotBlank
    @Size(max=255,min=3,message = "Please enter a valid password")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
