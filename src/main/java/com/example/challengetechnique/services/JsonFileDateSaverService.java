package com.example.challengetechnique.services;

import com.example.challengetechnique.dtos.response.UploadResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface JsonFileDateSaverService {
    UploadResponse saveJsonFileDateToDatabase(MultipartFile jsonFile) throws IOException;
}
