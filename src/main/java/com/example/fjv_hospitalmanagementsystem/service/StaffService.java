package com.example.fjv_hospitalmanagementsystem.service;

import com.example.fjv_hospitalmanagementsystem.model.dto.request.StaffRequest;
import com.example.fjv_hospitalmanagementsystem.model.dto.response.StaffResponse;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service

public interface StaffService {
   StaffResponse createStaff(StaffRequest request);

   StaffResponse updateStaff(UUID staffId, StaffRequest request);

   StaffResponse getStaffById(UUID staffId);

   List<StaffResponse> getStaffByStaffHospitalId(UUID hospitalId);

   void deleteStaffById(UUID staffId);
}
