package com.kuaforapp.controller;

import com.kuaforapp.dto.Request.AppointmentRequest;
import com.kuaforapp.dto.Response.AppointmentResponse;
import com.kuaforapp.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping("/createAppointment") // http://localhost:8080/appointments/createAppointment + POST + JSON
    public AppointmentResponse createAppointment(@RequestBody AppointmentRequest request) {
        return appointmentService.createAppointment(request);
    }

    @GetMapping("/getAllAppointments") // http://localhost:8080/appointments/getAllAppointments + GET
    public List<AppointmentResponse> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }
}
