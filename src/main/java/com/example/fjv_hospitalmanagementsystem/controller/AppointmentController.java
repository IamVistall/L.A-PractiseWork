package com.example.fjv_hospitalmanagementsystem.controller;

import com.example.fjv_hospitalmanagementsystem.model.dto.request.AppointmentRequest;
import com.example.fjv_hospitalmanagementsystem.model.dto.response.AppointmentResponse;
import com.example.fjv_hospitalmanagementsystem.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @Operation(summary = "Create a new appointment")
    @ApiResponse(responseCode = "201", description = "Appointment created successfully")
    @PostMapping
    public ResponseEntity<AppointmentResponse> createAppointment(@RequestBody AppointmentRequest request) {
        return new ResponseEntity<>(appointmentService.createAppointment(request), HttpStatus.CREATED);
    }

    @Operation(summary = "Get appointment by ID")
    @ApiResponse(responseCode = "200", description = "Appointment found")
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponse> getAppointmentById(@PathVariable("id") UUID appointmentId) {
        return ResponseEntity.ok(appointmentService.getAppointmentById(appointmentId));
    }

    @Operation(summary = "Update appointment by ID")
    @ApiResponse(responseCode = "200", description = "Appointment updated successfully")
    @PutMapping("/{id}")
    public ResponseEntity<AppointmentResponse> updateAppointment(@PathVariable("id") UUID appointmentId, @RequestBody AppointmentRequest request) {
        return ResponseEntity.ok(appointmentService.updateAppointment(appointmentId, request));
    }

    @Operation(summary = "Delete appointment by ID")
    @ApiResponse(responseCode = "204", description = "Appointment deleted successfully")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable("id") UUID appointmentId) {
        appointmentService.deleteAppointment(appointmentId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Reschedule appointment by ID")
    @ApiResponse(responseCode = "200", description = "Appointment rescheduled successfully")
    @PutMapping("/{id}/reschedule")
    public ResponseEntity<AppointmentResponse> rescheduleAppointment(@PathVariable("id") UUID appointmentId, @RequestBody AppointmentRequest request) {
        return ResponseEntity.ok(appointmentService.rescheduleAppointment(appointmentId, request));
    }

    @Operation(summary = "Cancel appointment by ID")
    @ApiResponse(responseCode = "200", description = "Appointment canceled successfully")
    @PatchMapping("/{id}/cancel")
    public ResponseEntity<AppointmentResponse> cancelAppointment(@PathVariable("id") UUID appointmentId) {
        return ResponseEntity.ok(appointmentService.cancelAppointment(appointmentId));
    }

    @Operation(summary = "Get all appointments")
    @ApiResponse(responseCode = "200", description = "List of appointments retrieved")
    @GetMapping
    public ResponseEntity<List<AppointmentResponse>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

}
