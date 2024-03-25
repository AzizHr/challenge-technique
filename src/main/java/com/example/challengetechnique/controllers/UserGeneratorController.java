package com.example.challengetechnique.controllers;

import com.example.challengetechnique.exceptions.InvalidCountValueException;
import com.example.challengetechnique.models.User;
import com.example.challengetechnique.services.UsersGeneratorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserGeneratorController {

    private final UsersGeneratorService usersGeneratorService;

    @GetMapping("/generate")
    public ResponseEntity<Object> generate(@RequestParam int count) throws IOException, InvalidCountValueException {
        List<User> users = usersGeneratorService.generateUsers(count);

        // Serialize users to JSON
        String jsonContent = new ObjectMapper().writeValueAsString(users);

        // Create response headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setContentDispositionFormData("attachment", "users.json");

        // Return ResponseEntity with JSON content and headers
        return ResponseEntity.ok()
                .headers(headers)
                .body(jsonContent);
    }

}
