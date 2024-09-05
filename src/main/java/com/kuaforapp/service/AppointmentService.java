package com.kuaforapp.service;

import com.kuaforapp.dto.Request.AppointmentRequest;
import com.kuaforapp.dto.Response.AppointmentResponse;
import com.kuaforapp.entity.Appointment;
import com.kuaforapp.entity.Customer;
import com.kuaforapp.entity.Employee;
import com.kuaforapp.entity.Offering;
import com.kuaforapp.mapper.Mapper;
import com.kuaforapp.repository.AppointmentRepository;
import com.kuaforapp.repository.CustomerRepository;
import com.kuaforapp.repository.EmployeeRepository;
import com.kuaforapp.repository.OfferingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final CustomerRepository customerRepository;
    private final OfferingRepository offeringRepository;
    private final EmployeeRepository employeeRepository;
    private final Mapper mapper;

    // Randevu oluşturma
    public AppointmentResponse createAppointment(AppointmentRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Offering offering = offeringRepository.findById(request.getServiceId())
                .orElseThrow(() -> new RuntimeException("Offering not found"));
        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Appointment appointment = mapper.requestToAppointment(request, customer, offering, employee);
        appointment = appointmentRepository.save(appointment);
        return mapper.appointmentToResponse(appointment);
    }

    // Tüm randevuları getirme
    public List<AppointmentResponse> getAllAppointments() {
        return appointmentRepository.findAll().stream()
                .map(mapper::appointmentToResponse)
                .collect(Collectors.toList());
    }
}
