package com.kuaforapp.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Entity
public class Offering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String offeringName; // "serviceName" -> "offeringName" olarak değiştirildi

    private Double price;

    @OneToMany(mappedBy = "offering")
    private List<Appointment> appointments;
}
