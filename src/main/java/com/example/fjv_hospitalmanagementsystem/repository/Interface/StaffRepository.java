package com.example.fjv_hospitalmanagementsystem.repository.Interface;
import com.example.fjv_hospitalmanagementsystem.model.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StaffRepository extends JpaRepository<Staff, UUID> {
    List<Staff> getStaffByStaffHospitalId(UUID hospitalId);
    Staff getByStaffId(UUID staffId);
    boolean existsByStaffId(UUID staffId);
    @Override
    Optional<Staff> findById(UUID uuid);
}
