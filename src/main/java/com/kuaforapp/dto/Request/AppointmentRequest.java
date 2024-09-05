package com.kuaforapp.dto.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class AppointmentRequest {

    private LocalDateTime appointmentTime; // LocalDateTime uyumlu hale getirildi
    private Long customerId;
    private Long offeringId; // serviceId -> offeringId olarak güncellendi
    private Long employeeId;
}
