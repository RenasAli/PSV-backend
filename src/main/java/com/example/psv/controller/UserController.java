package com.example.psv.controller;

import com.example.psv.model.User;
import com.example.psv.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok().body( userService.saveUser(user));
    }
   @GetMapping("/username/{username}")
    public ResponseEntity <User> findUserByUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(userService.getUserByUsername(username).orElse(null));
    }



    @GetMapping("/userid/{userId}")
    public ResponseEntity <User> findUserByUserId(@PathVariable("userId") Long userId) {

        return ResponseEntity.ok().body(userService.getUserById(userId));
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable("userId") Long userId){
        userService.deleteUserById(userId);
    }
}
