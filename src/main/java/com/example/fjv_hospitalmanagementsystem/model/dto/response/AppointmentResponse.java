package com.example.fjv_hospitalmanagementsystem.model.dto.response;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AppointmentResponse {
    private UUID appointmentId;
    private UUID patientId;
    private UUID staffId;
    private UUID hospitalId;
    private LocalDateTime appointmentDateTime;
    private String appointmentStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
