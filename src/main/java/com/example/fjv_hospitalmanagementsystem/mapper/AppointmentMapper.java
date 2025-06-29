package com.example.fjv_hospitalmanagementsystem.mapper;

import com.example.fjv_hospitalmanagementsystem.model.dto.request.AppointmentRequest;
import com.example.fjv_hospitalmanagementsystem.model.dto.response.AppointmentResponse;
import com.example.fjv_hospitalmanagementsystem.model.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    @Mapping(target = "appointmentId", ignore = true)
    @Mapping(target = "appointmentStatus", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Appointment toAppointment(AppointmentRequest request);
    AppointmentResponse toAppointmentResponse(Appointment appointment);
    List<Appointment> toAppointmentList(List<AppointmentRequest> requestList);
}
