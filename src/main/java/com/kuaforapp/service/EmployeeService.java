package com.kuaforapp.service;

import com.kuaforapp.dto.Request.EmployeeRequest;
import com.kuaforapp.dto.Response.EmployeeResponse;
import com.kuaforapp.entity.Employee;
import com.kuaforapp.mapper.Mapper;
import com.kuaforapp.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final Mapper mapper; // Mapper sınıfını kullanıyoruz

    // Yeni çalışan oluşturma
    public EmployeeResponse createEmployee(EmployeeRequest request) {
        Employee employee = mapper.requestToEmployee(request); // Mapper'dan dönüşüm yapıyoruz
        employee = employeeRepository.save(employee);
        return mapper.employeeToResponse(employee); // Mapper'dan dönüşüm yapıyoruz
    }

    // Tüm çalışanları getirme
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(mapper::employeeToResponse) // Mapper'dan dönüşüm yapıyoruz
                .collect(Collectors.toList());
    }
}
