package com.example.challengetechnique.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UploadResponse {
    private int totalRecords;
    private int importedRecords;
    private int failedRecords;
}
