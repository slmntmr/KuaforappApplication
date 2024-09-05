package com.kuaforapp.dto.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class OfferingRequest  {

    private String offeringName; // Entity ile uyumlu hale getirildi
    private Double price;
}
