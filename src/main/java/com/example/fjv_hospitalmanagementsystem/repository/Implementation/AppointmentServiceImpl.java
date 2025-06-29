package com.example.fjv_hospitalmanagementsystem.repository.Implementation;
import com.example.fjv_hospitalmanagementsystem.constant.AppointmentStatus;
import com.example.fjv_hospitalmanagementsystem.exception.InvalidAppointmentDataException;
import com.example.fjv_hospitalmanagementsystem.mapper.AppointmentMapper;
import com.example.fjv_hospitalmanagementsystem.model.dto.request.AppointmentRequest;
import com.example.fjv_hospitalmanagementsystem.model.dto.response.AppointmentResponse;
import com.example.fjv_hospitalmanagementsystem.model.entity.Appointment;
import com.example.fjv_hospitalmanagementsystem.repository.Interface.AppointmentRepository;
import com.example.fjv_hospitalmanagementsystem.service.AppointmentService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    public AppointmentServiceImpl
            (AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }

    @Override
    public AppointmentResponse createAppointment(AppointmentRequest request) {
        validateAppointmentRequest(request);
        Appointment appointment = appointmentMapper.toAppointment(request);
        appointment.setAppointmentStatus(AppointmentStatus.SCHEDULED.name());
        appointment.setCreatedAt(LocalDateTime.now());
        appointment.setUpdatedAt(LocalDateTime.now());
        return appointmentMapper.toAppointmentResponse(appointmentRepository.save(appointment));
    }

    @Override
    public AppointmentResponse getAppointmentById(UUID appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new
                        InvalidAppointmentDataException
                        ("Appointment not found with ID: " + appointmentId));
        return appointmentMapper.toAppointmentResponse(appointment);
    }

    @Override
    public AppointmentResponse updateAppointment(UUID appointmentId, AppointmentRequest request) {
        validateAppointmentRequest(request);
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() ->
                new InvalidAppointmentDataException("Appointment not found with ID: " + appointmentId));
        Appointment updatedAppointment = appointmentMapper.toAppointment(request);
        updatedAppointment.setAppointmentId(appointment.getAppointmentId());
        updatedAppointment.setAppointmentStatus(AppointmentStatus.SCHEDULED.name());
        updatedAppointment.setCreatedAt(appointment.getCreatedAt());
        updatedAppointment.setUpdatedAt(LocalDateTime.now());
        return appointmentMapper.toAppointmentResponse
                (appointmentRepository.save(updatedAppointment));
    }

    @Override
    public AppointmentResponse rescheduleAppointment(UUID appointmentId, AppointmentRequest request) {
        validateAppointmentRequest(request);
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() ->
                new InvalidAppointmentDataException("Appointment not found with ID: " + appointmentId));
        appointment.setAppointmentTime(request.getAppointmentDateTime());
        appointment.setStaffId(request.getStaffId());
        appointment.setUpdatedAt(LocalDateTime.now());
        return appointmentMapper.toAppointmentResponse(appointmentRepository.save(appointment));
    }

    @Override
    public AppointmentResponse cancelAppointment(UUID appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() ->
                new InvalidAppointmentDataException("Appointment not found with ID: " + appointmentId));
        appointment.setAppointmentStatus(AppointmentStatus.CANCELED.name());
        appointment.setUpdatedAt(LocalDateTime.now());
        return appointmentMapper.toAppointmentResponse(appointmentRepository.save(appointment));
    }


    @Override
    public List<AppointmentResponse> getAllAppointments() {
        return appointmentRepository.findAll()
                .stream().map(appointmentMapper::toAppointmentResponse)
                .collect(Collectors.toList());
    }

    public void deleteAppointment(UUID appointmentId) {
        if (!appointmentRepository.existsById(appointmentId)) {
            throw new InvalidAppointmentDataException("Appointment not found with ID: " + appointmentId);
        }
        appointmentRepository.deleteById(appointmentId);
    }


    private void validateAppointmentRequest(AppointmentRequest request) {
        if (request.getAppointmentDateTime() == null || request.getAppointmentDateTime()
                .isBefore(LocalDateTime.now())) {
            throw new InvalidAppointmentDataException("Invalid appointment date/time");
        }
        if (request.getStaffId() == null
                || request.getPatientId() == null
                || request.getHospitalId() == null) {
            throw new InvalidAppointmentDataException
                    ("Staff ID, Patient ID, and Hospital ID are required");
        }
    }
}
