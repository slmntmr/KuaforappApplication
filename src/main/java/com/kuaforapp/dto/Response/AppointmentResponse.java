package com.kuaforapp.dto.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppointmentResponse {

    private Long id;
    private LocalDateTime appointmentTime; // LocalDateTime uyumlu hale getirildi
    private CustomerResponse customer;
    private OfferingResponse offering; // service -> offering olarak güncellendi
    private EmployeeResponse employee;
}
