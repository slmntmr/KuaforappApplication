package com.kuaforapp.dto.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OfferingResponse  {

    private Long id;
    private String offeringName; // Entity ile uyumlu hale getirildi
    private Double price;
}
