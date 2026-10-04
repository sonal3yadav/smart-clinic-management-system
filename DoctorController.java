package com.project.backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @GetMapping("/{doctorId}/availability")
    public ResponseEntity<?> getDoctorAvailability(
            @PathVariable Long doctorId,
            @RequestParam String date,
            @RequestHeader(value = "Authorization", required = false) String token) {

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
        response.put("doctorId", doctorId);
        response.put("date", date);
        response.put("message", "Doctor availability retrieved successfully");

        return ResponseEntity.ok(response);
    }
}
