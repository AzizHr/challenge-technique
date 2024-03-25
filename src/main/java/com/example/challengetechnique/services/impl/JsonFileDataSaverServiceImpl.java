package com.example.challengetechnique.services.impl;

import com.example.challengetechnique.dtos.response.UploadResponse;
import com.example.challengetechnique.models.User;
import com.example.challengetechnique.repositories.UserRepository;
import com.example.challengetechnique.services.JsonFileDateSaverService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class JsonFileDataSaverServiceImpl implements JsonFileDateSaverService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UploadResponse saveJsonFileDateToDatabase(MultipartFile jsonFile) throws IOException {
        if (!Objects.equals(jsonFile.getContentType(), "application/json")) {
            throw new BadRequestException("Must be a JSON format");
        }

        List<User> users = new ObjectMapper().readValue(jsonFile.getInputStream(), new TypeReference<List<User>>(){});

        List<User> savedUsers = new ArrayList<>();
        List<User> failedUsers = new ArrayList<>();
        for (User user : users) {
            try {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                savedUsers.add(userRepository.save(user));
            } catch (Exception e) {
                failedUsers.add(user);
            }
        }

        UploadResponse response = new UploadResponse();
        response.setTotalRecords(users.size());
        response.setImportedRecords(savedUsers.size());
        response.setFailedRecords(failedUsers.size());
        return response;
    }
}
