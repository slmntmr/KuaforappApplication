package com.kuaforapp.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime appointmentTime; // String yerine LocalDateTime

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "offering_id") // service -> offering
    private Offering offering;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
