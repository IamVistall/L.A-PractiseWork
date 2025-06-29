package com.example.fjv_hospitalmanagementsystem.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StaffResponse {
    private UUID staffId;
    private String staffFirstName;
    private String staffLastName;
    private String staffOtherNames;
    private LocalDateTime staffDateOfBirth;
    private String staffGender;
    private String staffPhone;
    private String staffEmail;
    private String staffAddress;
    private String staffRole;
    private String staffDepartment;
    private UUID staffHospitalId;
    private LocalDateTime staffCreatedAt;
    private LocalDateTime staffUpdatedAt;

}
