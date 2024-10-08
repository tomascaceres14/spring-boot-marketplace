package com.tomasdev.akhanta.exceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter @Setter
@AllArgsConstructor
public class ErrorResponseDTO {

    private List<String> errors;
}
