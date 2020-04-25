package com.dhiegoabrantes.passwdvalidator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PasswordValidationRequest {

    private String word;

}
