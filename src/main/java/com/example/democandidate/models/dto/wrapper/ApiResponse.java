package com.example.democandidate.models.dto.wrapper;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ApiResponse<T> {
    private String status;
    private String message;
    private T data;
}
