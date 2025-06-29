package com.example.fjv_hospitalmanagementsystem.controller;

import com.example.fjv_hospitalmanagementsystem.exception.InvalidStaffDataException;
import com.example.fjv_hospitalmanagementsystem.model.dto.request.StaffRequest;
import com.example.fjv_hospitalmanagementsystem.model.dto.response.StaffResponse;
import com.example.fjv_hospitalmanagementsystem.service.StaffService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
public class StaffController {
    private StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }
    @Operation(summary = "Create a new Staff Member")
    @ApiResponse(responseCode = "201", description = "Staff created successfully")
    @PostMapping
    public ResponseEntity<StaffResponse> createStaff(@RequestBody StaffRequest request) {
        return  new ResponseEntity<>(staffService.createStaff(request), HttpStatus.CREATED);
    }

    @Operation(summary = "Get staff by ID")
    @ApiResponse(responseCode = "200", description = "Staff found")
    @GetMapping("/{id}")
    public ResponseEntity<StaffResponse> getStaffById(@PathVariable UUID id) {
        return ResponseEntity.ok(staffService.getStaffById(id));
    }

    @ExceptionHandler(InvalidStaffDataException.class)
    public ResponseEntity<String> handleInvalidStaffDataException(InvalidStaffDataException ex) {
        if (ex.getMessage().contains("not found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @Operation(summary = "Update staff by ID")
    @ApiResponse(responseCode = "200", description = "Staff updated successfully")
    @PutMapping("/{id}")
    public ResponseEntity<StaffResponse> updateStaff(@PathVariable UUID id, @RequestBody StaffRequest request) {
        return ResponseEntity.ok(staffService.updateStaff(id, request));
    }

    @Operation(summary = "Get staff by hospital ID")
    @ApiResponse(responseCode = "200", description = "Staff list retrieved")
    @GetMapping
    public ResponseEntity<List<StaffResponse>> getStaffByStaffHospitalId(@RequestParam UUID hospitalId) {
        return ResponseEntity.ok(staffService.getStaffByStaffHospitalId(hospitalId));
    }

    @Operation(summary = "Delete staff by ID")
    @ApiResponse(responseCode = "204", description = "Staff deleted successfully")
    @DeleteMapping("/staff/delete")
    public ResponseEntity<Void> deleteStaffById(@RequestParam(name = "staffId") UUID staffId) {
        staffService.deleteStaffById(staffId);
        return ResponseEntity.noContent().build();
    }


}
