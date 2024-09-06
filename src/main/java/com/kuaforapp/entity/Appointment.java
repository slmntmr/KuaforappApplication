package com.kuaforapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity // Bu sınıfın bir JPA varlığı olduğunu belirtir.
@Getter // Lombok tarafından getter metodlarını otomatik olarak oluşturur.
@Setter // Lombok tarafından setter metodlarını otomatik olarak oluşturur.
@AllArgsConstructor // Lombok tarafından tüm alanları içeren bir yapıcı (constructor) oluşturur.
@NoArgsConstructor // Lombok tarafından parametresiz bir yapıcı (constructor) oluşturur.
@Builder(toBuilder = true)
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
