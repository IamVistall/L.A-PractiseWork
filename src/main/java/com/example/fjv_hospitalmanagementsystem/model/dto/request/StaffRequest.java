package com.example.fjv_hospitalmanagementsystem.model.dto.request;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Data

public class StaffRequest {
    private UUID staffId;
    private String staffFirstName;
    private String staffLastName;
    private String staffOtherNames;
    private LocalDateTime staffBirthDate;
    private String staffGender;
    private String staffEmail;
    private String staffPhone;
    private String staffRole;
    private String staffAddress;
    private String staffDepartment;
    private String staffHospitalId;

}
