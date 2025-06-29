package com.example.fjv_hospitalmanagementsystem.mapper;


import com.example.fjv_hospitalmanagementsystem.model.dto.request.StaffRequest;
import com.example.fjv_hospitalmanagementsystem.model.dto.response.StaffResponse;
import com.example.fjv_hospitalmanagementsystem.model.entity.Staff;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StaffMapper {
    @Mapping(target = "staffId", ignore = true)
    @Mapping(target = "staffCreatedAt", ignore = true)
    @Mapping(target = "staffUpdatedAt", ignore = true)
    Staff toStaff(StaffRequest request);

    StaffResponse toStaffResponse(Staff staff);

    List<Staff> toStaffList(List<StaffRequest> staffRequestList);
}
