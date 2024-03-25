package com.example.challengetechnique.controllers;

import com.example.challengetechnique.models.User;
import com.example.challengetechnique.services.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // Endpoint to get the current user's profile
    @GetMapping("/me")
    @PreAuthorize("hasAuthority('USER')") // Only users with authority 'USER' can access
    public ResponseEntity<User> getCurrentUser() {
        // Retrieve current user's username from authentication context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Retrieve and return the user's profile
        return ResponseEntity.ok(userService.profile(username));
    }

    // Endpoint to get a user's profile by username
    @GetMapping("/{username}")
    @PreAuthorize("hasAuthority('ADMIN')") // Only users with authority 'ADMIN' can access
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        // Retrieve the user's profile by username and return it
        User user = userService.profile(username);
        return ResponseEntity.ok(user);
    }
}
