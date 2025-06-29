package com.example.fjv_hospitalmanagementsystem.model.dto.request;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AppointmentRequest {
    private UUID patientId;
    private UUID staffId;
    private UUID hospitalId;
    private LocalDateTime appointmentDateTime;
}
