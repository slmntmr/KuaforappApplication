package com.kuaforapp.dto.Request;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class CustomerRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
