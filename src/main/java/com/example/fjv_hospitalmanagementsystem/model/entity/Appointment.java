package com.example.fjv_hospitalmanagementsystem.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "GROUP1_APPOINTMENT")
public class Appointment {
    @Id
    @GeneratedValue()
    private UUID  appointmentId;
    private UUID patientId;
    private UUID staffId;
    private UUID hospitalId;
    private LocalDateTime appointmentTime;
    private String appointmentReason;
    private String appointmentStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
