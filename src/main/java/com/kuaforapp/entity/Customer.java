package com.kuaforapp.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

import java.util.List;

@Data
@Builder
@Entity
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
