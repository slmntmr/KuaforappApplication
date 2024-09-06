package com.kuaforapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity // Bu sınıfın bir JPA varlığı olduğunu belirtir.
@Getter // Lombok tarafından getter metodlarını otomatik olarak oluşturur.
@Setter // Lombok tarafından setter metodlarını otomatik olarak oluşturur.
@AllArgsConstructor // Lombok tarafından tüm alanları içeren bir yapıcı (constructor) oluşturur.
@NoArgsConstructor // Lombok tarafından parametresiz bir yapıcı (constructor) oluşturur.
@Builder(toBuilder = true)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "customer")
    private List<Appointment> appointments;
}
