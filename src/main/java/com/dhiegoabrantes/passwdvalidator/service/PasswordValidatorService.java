package com.dhiegoabrantes.passwdvalidator.service;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PasswordValidatorService implements ValidatorService<String> {

    /**
     * Min size = 9
     * At least one digit
     * At least one lower case letter
     * At least one upper case letter
     * At least one special caracter
     */
    private final String VALID_VALUE_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%&*_])[A-Za-z\\d!@#$%&*_]{9,}$";

    public boolean isValid(String valueToValidate){
        return Objects.nonNull(valueToValidate) && valueToValidate.matches(VALID_VALUE_REGEX);
    }

}
