package com.example.challengetechnique.controllers;

import com.example.challengetechnique.models.User;
import com.example.challengetechnique.services.UsersGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserGeneratorController {

    private final UsersGeneratorService usersGeneratorService;

    @GetMapping("/generate")
    public ResponseEntity<List<User>> generate(@RequestParam int count) {
        return ResponseEntity.ok(usersGeneratorService.generateUsers(count));
    }

}
