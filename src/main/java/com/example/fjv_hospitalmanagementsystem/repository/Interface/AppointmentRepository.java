package com.example.fjv_hospitalmanagementsystem.repository.Interface;

import com.example.fjv_hospitalmanagementsystem.model.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    List<Appointment> findByStaffId(UUID staffId);
}
