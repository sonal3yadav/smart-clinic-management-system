package com.project.backend.services;

import com.project.backend.models.Appointment;
import com.project.backend.models.Doctor;
import com.project.backend.models.Patient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentService {

    private final List<Appointment> appointments = new ArrayList<>();

    // Books and saves an appointment
    public Appointment bookAppointment(
            Doctor doctor,
            Patient patient,
            LocalDateTime appointmentTime) {

        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setAppointmentTime(appointmentTime);
        appointment.setStatus("BOOKED");

        appointments.add(appointment);

        return appointment;
    }

    // Retrieves appointments for a doctor on a specific date
    public List<Appointment> getAppointmentsByDoctorAndDate(
            Doctor doctor,
            LocalDate date) {

        List<Appointment> result = new ArrayList<>();

        for (Appointment appointment : appointments) {
            if (appointment.getDoctor() != null
                    && appointment.getDoctor().equals(doctor)
                    && appointment.getAppointmentTime() != null
                    && appointment.getAppointmentTime().toLocalDate().equals(date)) {

                result.add(appointment);
            }
        }

        return result;
    }
}
