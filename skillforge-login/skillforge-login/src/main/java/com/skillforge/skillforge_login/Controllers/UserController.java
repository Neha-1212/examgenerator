package com.skillforge.skillforge_login.Controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.skillforge.skillforge_login.model.User;
import com.skillforge.skillforge_login.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // Constructor injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CREATE
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    // LOGIN
    @PostMapping("/loginuser")
    public String loginUser(@RequestBody User user) {
        boolean success = userService.loginUser(user.getEmail(), user.getPassword());
        if (success) {
            return "Login successful!";
        } else {
            return "Invalid email or password!";
        }
    }

    // READ all
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // READ one
    @GetMapping("/{id}")
    public User getUserById(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id ,@RequestBody User userDetails) {
        return userService.updateUser(id ,userDetails);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}

