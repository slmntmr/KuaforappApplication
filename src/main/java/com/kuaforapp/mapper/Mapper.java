package com.kuaforapp.mapper;

import com.kuaforapp.dto.Request.AppointmentRequest;
import com.kuaforapp.dto.Request.CustomerRequest;
import com.kuaforapp.dto.Request.EmployeeRequest;
import com.kuaforapp.dto.Request.OfferingRequest;
import com.kuaforapp.dto.Response.AppointmentResponse;
import com.kuaforapp.dto.Response.CustomerResponse;
import com.kuaforapp.dto.Response.EmployeeResponse;
import com.kuaforapp.dto.Response.OfferingResponse;
import com.kuaforapp.entity.Appointment;
import com.kuaforapp.entity.Customer;
import com.kuaforapp.entity.Employee;
import com.kuaforapp.entity.Offering;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    // Appointment Request --> Appointment Entity
    public Appointment requestToAppointment(AppointmentRequest appointmentRequest, Customer customer, Offering offering, Employee employee) {
        return Appointment.builder()
                .appointmentTime(appointmentRequest.getAppointmentTime())
                .customer(customer)
                .offering(offering)
                .employee(employee)
                .build();
    }

    // Appointment Entity --> Appointment Response
    public AppointmentResponse appointmentToResponse(Appointment appointment) {
        return AppointmentResponse.builder()
                .id(appointment.getId())
                .appointmentTime(appointment.getAppointmentTime())
                .customer(customerToResponse(appointment.getCustomer()))
                .offering(offeringToResponse(appointment.getOffering()))
                .employee(employeeToResponse(appointment.getEmployee()))
                .build();
    }

    // Customer Request --> Customer Entity
    public Customer requestToCustomer(CustomerRequest customerRequest) {
        return Customer.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .email(customerRequest.getEmail())
                .phone(customerRequest.getPhone())
                .build();
    }

    // Customer Entity --> Customer Response
    public CustomerResponse customerToResponse(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .build();
    }

    // Employee Request --> Employee Entity
    public Employee requestToEmployee(EmployeeRequest employeeRequest) {
        return Employee.builder()
                .firstName(employeeRequest.getFirstName())
                .lastName(employeeRequest.getLastName())
                .phone(employeeRequest.getPhone())
                .email(employeeRequest.getEmail())
                .build();
    }

    // Employee Entity --> Employee Response
    public EmployeeResponse employeeToResponse(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .phone(employee.getPhone())
                .email(employee.getEmail())
                .build();
    }

    // Offering Request --> Offering Entity
    public Offering requestToOffering(OfferingRequest offeringRequest) {
        return Offering.builder()
                .offeringName(offeringRequest.getOfferingName())
                .price(offeringRequest.getPrice())
                .build();
    }

    // Offering Entity --> Offering Response
    public OfferingResponse offeringToResponse(Offering offering) {
        return OfferingResponse.builder()
                .id(offering.getId())
                .offeringName(offering.getOfferingName())
                .price(offering.getPrice())
                .build();
    }
}
