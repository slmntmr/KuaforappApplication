package com.kuaforapp.controller;

import com.kuaforapp.dto.Request.EmployeeRequest;
import com.kuaforapp.dto.Response.EmployeeResponse;
import com.kuaforapp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/createEmployee") // http://localhost:8080/employees/createEmployee + POST + JSON
    public EmployeeResponse createEmployee(@RequestBody EmployeeRequest request) {
        return employeeService.createEmployee(request);
    }

    @GetMapping("/getAllEmployees") // http://localhost:8080/employees/getAllEmployees + GET
    public List<EmployeeResponse> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
