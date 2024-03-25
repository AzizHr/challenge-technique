package com.example.challengetechnique.controllers;

import com.example.challengetechnique.dtos.response.UploadResponse;
import com.example.challengetechnique.services.JsonFileDateSaverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class JsonFileDataSaverController {

    private final JsonFileDateSaverService jsonFileDateSaverService;

    // Endpoint to handle batch upload of users from JSON file
    @PostMapping(value = "/batch", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<UploadResponse> uploadUsers(@RequestParam("file") MultipartFile file) throws IOException {
        // Delegate file processing to service and return response entity
        return ResponseEntity.ok(jsonFileDateSaverService.saveJsonFileDateToDatabase(file));
    }

}