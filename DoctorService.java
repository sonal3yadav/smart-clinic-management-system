package com.project.backend.services;

import com.project.backend.models.Doctor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorService {

    // Returns available time slots for a doctor on a given date
    public List<String> getAvailableTimeSlots(Doctor doctor, LocalDate date) {

        if (doctor == null || date == null) {
            return new ArrayList<>();
        }

        if (doctor.getAvailableTimes() == null) {
            return new ArrayList<>();
        }

        return new ArrayList<>(doctor.getAvailableTimes());
    }

    // Validates doctor login credentials and returns a structured response
    public Map<String, Object> validateDoctorLogin(
            Doctor doctor,
            String email,
            String password) {

        Map<String, Object> response = new HashMap<>();

        if (doctor == null) {
            response.put("success", false);
            response.put("message", "Doctor not found");
            return response;
        }

        if (doctor.getEmail().equals(email)
                && doctor.getPassword().equals(password)) {

            response.put("success", true);
            response.put("message", "Doctor login successful");
            response.put("doctorId", doctor.getDoctorId());
            response.put("email", doctor.getEmail());

        } else {
            response.put("success", false);
            response.put("message", "Invalid doctor credentials");
        }

        return response;
    }
}
