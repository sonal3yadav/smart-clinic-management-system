package com.project.backend.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @PostMapping
    public ResponseEntity<?> savePrescription(
            @RequestHeader(value = "Authorization", required = false) String token,
            @Valid @RequestBody Map<String, Object> requestBody) {

        if (token == null || token.isBlank()) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Authorization token is required");

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(response);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Prescription saved successfully");
        response.put("data", requestBody);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
