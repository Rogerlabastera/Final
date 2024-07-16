package com.labasterasign.upsign.controll;

import com.labasterasign.upsign.model.OrderItem;
import com.labasterasign.upsign.model.User;
import com.labasterasign.upsign.repository.UserRepo;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
public class UserControll {

    @Autowired
    private UserRepo userRepo;
    private OrderItem item;


    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException{
        response.sendRedirect("/swagger-ui.html");
    }



    // Get all users
    @GetMapping("/users-with-orders")
    public List<User> getAllUsersWithOrders() {
        List<User> users = userRepo.findAll();
        for (User user : users) {
            user.getOrders().size(); // This fetches orders eagerly if using lazy loading
        }
        return users;
    }

    // User signup
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
        if (isEmpty(user.getUsername(), user.getPassword(), user.getEmail(), user.getConfirmPass())) {
            return ResponseEntity.badRequest().body("All fields must be filled");
        }

        if (userRepo.existsByUsername(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        }

        userRepo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    // User login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        User existingUser = userRepo.findByUsername(username);

        if (existingUser != null && existingUser.getPassword().equals(password)) {
            return ResponseEntity.ok("Login Success");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    // Helper method to check if any string is empty
    private boolean isEmpty(String... strings) {
        for (String str : strings) {
            if (str == null || str.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }
    @PostMapping("/order")
    public ResponseEntity<String> inputOrder(@RequestParam String userName, @RequestBody OrderItem recipe) {
        // Find user by username from MongoDB
        User existingUser = userRepo.findByUsername(userName);

        // Check if user exists
        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        // Add order to user's orders
        else {
            item.setOrderDate(new Date()); // Set current date as order date
            existingUser.addOrder(item);

            // Save updated user in MongoDB
            userRepo.save(existingUser);
            return ResponseEntity.ok("Item ordered successfully");
        }

    }

}


