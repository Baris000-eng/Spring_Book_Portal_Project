package com.bookstore.entity.controller;

import com.bookstore.entity.entity.User;
import com.bookstore.entity.model.UserDTO;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.bookstore.entity.model.UserUpdateDTO;
import tr.com.obss.ji.bookportal.service.UserService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    //controller class for users..

    //GET, POST, PUT, PATCH, DELETE, OPTIONS, HEAD
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    //@Autowired
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<User>>getUsers() {
        LOGGER.info("A get request has been sent !!! \n\n");
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/with-dao-pagination")
    public ResponseEntity<List<User>>getUsersWithDaoPagination(
            @RequestParam(name= "pageSize",defaultValue = "5") int pageSize,
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber
    ) {
        return ResponseEntity.ok(service.findAllDaoPagination(pageNumber,pageSize));
    }

    @GetMapping("/with-jpa-pagination")
    public ResponseEntity<Page<User>>getUsersWithJpaPagination(
            @RequestParam(name= "pageSize",defaultValue = "5") int pageSize,
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber
    ) {
        return ResponseEntity.ok(service.findAllWithJpaPagination(pageNumber,pageSize));
    }


    @GetMapping("/has-role-user")
    public ResponseEntity<List<User>>getUsersWithUserRole(){
        return ResponseEntity.ok(service.getUsersWithRole(List.of("ROLE_USER")));
    }

    @GetMapping("/by-hql/{userId}")
    public ResponseEntity<User>getUserByHQL(@PathVariable(name = "userId") long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/by-native-sql/{userId}")
    public ResponseEntity<User>getUserByNativeSQL(@PathVariable(name = "userId") long id){
        return ResponseEntity.ok(service.getByIdNative(id));
    }




    //For searchUsers() method, we should send the get request from Postman by using the full gmail.
    @GetMapping("/by-username")
    public ResponseEntity<User> searchUsers(@RequestParam (name = "username",defaultValue = "") String username){
        return ResponseEntity.ok(service.findByUsername(username));
    }

    //For searchAllUsers() method, we can send the get request from Postman
    // either by using the full gmail or the part/name before the "@"
    // symbol.
    @GetMapping("/all-by-username")
    public ResponseEntity<List<User>>searchAllUsers(@RequestParam (name = "username",defaultValue = "") String username){
        return ResponseEntity.ok(service.findAllByUsername(username));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable(name = "userId") long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User>updateUser(@PathVariable(name="userId") long id, @Valid @RequestBody
    UserUpdateDTO userUpdateDTO) {
        return ResponseEntity.ok(service.update(id,userUpdateDTO));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<User>removeUser(@PathVariable(name="userId") long id) {
        return ResponseEntity.ok(service.remove(id));
    }

    /*@GetMapping("/search")
    public ResponseEntity<?> getUsers() {
        LOGGER.info("A get request has been sent !!! \n\n");
        try {
            int i = 7 / 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // http://localhost:8081/api/v1/users/search
        return ResponseEntity.ok("A successful get request! \n");
    }*/



    @PostMapping("/create")
    public ResponseEntity<User>createUser(@Valid @RequestBody UserDTO userDTO){
        LOGGER.info("User info: {} {}",userDTO.getUsername(),userDTO.getPassword());
        return ResponseEntity.ok(service.save(userDTO));
        // http://localhost:8081/api/v1/users/create
        //return ResponseEntity.ok("A successful post request ! \n");
    }



}
