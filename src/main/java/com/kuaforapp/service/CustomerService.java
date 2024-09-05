package com.kuaforapp.service;

import com.kuaforapp.dto.Request.CustomerRequest;
import com.kuaforapp.dto.Response.CustomerResponse;
import com.kuaforapp.entity.Customer;
import com.kuaforapp.mapper.Mapper;
import com.kuaforapp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final Mapper mapper;

    // Yeni müşteri oluşturma
    public CustomerResponse createCustomer(CustomerRequest request) {
        Customer customer = mapper.requestToCustomer(request);
        customer = customerRepository.save(customer);
        return mapper.customerToResponse(customer);
    }

    // Tüm müşterileri getirme
    public List<CustomerResponse> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(mapper::customerToResponse) // mapper.toDTO yerine mapper.customerToResponse kullanıyoruz
                .collect(Collectors.toList());
    }
}
/*package com.kuaforapp.service;

import com.kuaforapp.dto.Request.AppointmentRequest;
import com.kuaforapp.dto.Response.AppointmentResponse;
import com.kuaforapp.entity.Appointment;
import com.kuaforapp.entity.Customer;
import com.kuaforapp.entity.Service;
import com.kuaforapp.entity.Employee;
import com.kuaforapp.mapper.Mapper;
import com.kuaforapp.repository.AppointmentRepository;
import com.kuaforapp.repository.CustomerRepository;
import com.kuaforapp.repository.ServiceRepository;
import com.kuaforapp.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final CustomerRepository customerRepository;
    private final ServiceRepository serviceRepository;
    private final EmployeeRepository employeeRepository;
    private final Mapper mapper;

    // Randevu oluşturma
    public AppointmentResponse createAppointment(AppointmentRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Service service = serviceRepository.findById(request.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service not found"));
        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Appointment appointment = mapper.requestToAppointment(request, customer, service, employee);
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
*/