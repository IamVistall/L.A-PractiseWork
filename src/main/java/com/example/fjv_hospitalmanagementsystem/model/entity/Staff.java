package com.example.fjv_hospitalmanagementsystem.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table (name = "GROUP1_STAFF")
public class Staff {
   @Id
   @Column(unique = true, nullable = false)
   private UUID staffId;
   @Column(name = "staffFirstName")
   private String staffFirstName;
   private String staffLastName;
   private String staffOtherNames;
   private LocalDateTime staffDateOfBirth;
   private String staffGender;
   private String staffPhone;
   private String staffEmail;
   private String staffAddress;
   private String staffStatus;
   private String staffDepartment;
   private UUID staffHospitalId;
   private LocalDateTime staffCreatedAt;
   private LocalDateTime staffUpdatedAt;
}
