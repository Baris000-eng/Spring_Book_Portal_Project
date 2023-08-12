package com.bookstore.entity.controller;

import com.bookstore.entity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tr.com.obss.ji.bookportal.service.UserService;

import java.util.Locale;

public class MainPageController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserSecurityService userSecurityService;


    @RequestMapping("/")
    public String index() {
        return "my index";
    }


    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("classActiveLogin",true);
        return "myAccount";
    }

    @RequestMapping("/forgetPassword")
    public String forgetPassword(Model model) {
       model.addAttribute("classActiveForgetPassword",true);
       return "myAccount";
    }

@RequestMapping("/newUser")
    public String newUser(
    Locale loc, @RequestParam("token")String tok, Model model) {
    PasswordResetToken passwordResetToken = userService.getPasswordResetToken(tok);

    if(passwordResetToken == null) {
        String message = "This token is invalid !!";
        model.addAttribute("message",message);
        return "redirect:/badRequest";
    }

    User user = passwordResetToken.getUser();
    String username = user.getUsername();

    UserDetails userDetails = userSecurityService.loadUserByUsername(username);

    Authentication auth = new UsernamePasswordAuthenticationToken(userDetails,userDetails.getPassword(),userDetails.getAuthorities());

    SecurityContextHolder.getContext().setAuthentication(auth);
    model.addAttribute("classActiveEdit", true);
    return "myProfile";
}

}
