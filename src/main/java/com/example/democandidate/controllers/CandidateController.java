package com.example.democandidate.controllers;

import com.example.democandidate.models.dto.req.CandidateCreateDTO;
import com.example.democandidate.models.dto.wrapper.ApiResponse;
import com.example.democandidate.models.services.CandidateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/candidates")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService candidateService;

    @PostMapping
    ResponseEntity<?> create(@Valid @RequestBody CandidateCreateDTO request, BindingResult result){
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            List<FieldError> fieldErrors = result.getFieldErrors();

            fieldErrors.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(
                    ApiResponse.builder()
                            .status(HttpStatus.BAD_REQUEST.name())
                            .message("Data Failed")
                            .data(errors)
                            .build()
            );
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.builder()
                        .status(HttpStatus.CREATED.name())
                        .message("Successfully")
                        .data(candidateService.create(request))
                        .build()
                );

    }
}
