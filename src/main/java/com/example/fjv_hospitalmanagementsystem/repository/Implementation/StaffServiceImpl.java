package com.example.fjv_hospitalmanagementsystem.repository.Implementation;
import com.example.fjv_hospitalmanagementsystem.exception.InvalidStaffDataException;
import com.example.fjv_hospitalmanagementsystem.mapper.StaffMapper;
import com.example.fjv_hospitalmanagementsystem.model.dto.request.StaffRequest;
import com.example.fjv_hospitalmanagementsystem.model.dto.response.StaffResponse;
import com.example.fjv_hospitalmanagementsystem.model.entity.Staff;
import com.example.fjv_hospitalmanagementsystem.repository.Interface.StaffRepository;
import com.example.fjv_hospitalmanagementsystem.service.StaffService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper;

    public StaffServiceImpl(StaffRepository staffRepository, StaffMapper staffMapper) {
        this.staffRepository = staffRepository;
        this.staffMapper = staffMapper;
    }

    @Override
    public StaffResponse createStaff(StaffRequest request) {
        validateStaffRequest(request);
        Staff staff = staffMapper.toStaff(request);
        staff.setStaffId(UUID.randomUUID());
        staff.setStaffCreatedAt(LocalDateTime.now());
        staff.setStaffUpdatedAt(LocalDateTime.now());
        return staffMapper.toStaffResponse(staffRepository.save(staff));
    }

    @Override
    public StaffResponse updateStaff(UUID staffId, StaffRequest request) {
        validateStaffRequest(request);
        Staff staff = staffRepository.getByStaffId(staffId);
        if (staff == null) {
            throw new InvalidStaffDataException("Staff not found with id " + staffId);
        }
        staff.setStaffFirstName(request.getStaffFirstName());
        staff.setStaffLastName(request.getStaffLastName());
        staff.setStaffUpdatedAt(LocalDateTime.now());
        staffRepository.save(staff);
        return staffMapper.toStaffResponse(staff);
    }

    @Override
    public StaffResponse getStaffById(UUID staffId) {
        Staff staff = staffRepository.getByStaffId(staffId);
        if (staff == null) {
            throw new InvalidStaffDataException("Invalid staff data");
        }
        return staffMapper.toStaffResponse(staff);
    }

    @Override
    public List<StaffResponse> getStaffByStaffHospitalId(UUID hospitalId) {
        return staffRepository.getStaffByStaffHospitalId(hospitalId)
                .stream().map(staffMapper::toStaffResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteStaffById(UUID staffId) {
        validateDeleteStaffRequest(staffId);
        staffRepository.deleteById(staffId);
    }


    private void validateDeleteStaffRequest(UUID staffId) {
        if (!staffRepository.existsByStaffId(staffId)) {
            throw new InvalidStaffDataException("Staff not found with ID: " + staffId);
        }
    }

    private void validateStaffRequest(StaffRequest request) {
        if (request.getStaffHospitalId() == null) {
            throw new InvalidStaffDataException("Invalid Staff Hospital ID");
        }
        if (request.getStaffFirstName() == null) {
            throw new InvalidStaffDataException("First and are required");
        }
        if (request.getStaffLastName() == null) {
            throw new InvalidStaffDataException("Last names are required");
        }
        try {
            staffRepository.getByStaffId(request.getStaffId());
        } catch (IllegalArgumentException e) {
            throw new InvalidStaffDataException(e.getMessage());
        }
    }

}
