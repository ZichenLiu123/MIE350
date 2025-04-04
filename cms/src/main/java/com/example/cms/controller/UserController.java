package com.example.cms.controller;

import com.example.cms.model.entities.User;
import com.example.cms.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/auth/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        // search username in the database
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // verify password
        if (!password.equals(user.getPassword())){
            return ResponseEntity.status(401).body(Map.of(
                    "status", "error",
                    "message", "Invalid username or password"));
        }

        // optionally, generate session token for Appsmith
        String sessionToken = UUID.randomUUID().toString();
        return ResponseEntity.ok(Map.of(
                "username", username,
                "status", "success",
                "token", sessionToken,
                "isAdmin", user.getIsAdmin()));
    }

}
