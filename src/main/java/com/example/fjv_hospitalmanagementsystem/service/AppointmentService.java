package com.example.fjv_hospitalmanagementsystem.service;

import com.example.fjv_hospitalmanagementsystem.model.dto.request.AppointmentRequest;
import com.example.fjv_hospitalmanagementsystem.model.dto.response.AppointmentResponse;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service

public interface AppointmentService {
    AppointmentResponse createAppointment(AppointmentRequest request);

    AppointmentResponse getAppointmentById(UUID appointmentId);

    AppointmentResponse updateAppointment(UUID appointmentId, AppointmentRequest request);

    AppointmentResponse rescheduleAppointment(UUID appointmentId, AppointmentRequest request);

    AppointmentResponse cancelAppointment(UUID appointmentId);

    void deleteAppointment(UUID appointmentId);

    List<AppointmentResponse> getAllAppointments();
}
