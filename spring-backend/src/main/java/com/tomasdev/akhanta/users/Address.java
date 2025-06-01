package com.tomasdev.akhanta.users;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Address {
    @NotBlank(message = "Por favor, introduzca el nombre de calle")
    private String street;
    @NotBlank(message = "Por favor, introduzca el número del edificio")
    private String buildingNumber;
    private String apartmentNumber;
    private String city;
    private String country;
    private String zipCode;
}
