package com.dhiegoabrantes.passwdvalidator.controller;

import com.dhiegoabrantes.passwdvalidator.dto.PasswordValidationRequest;
import com.dhiegoabrantes.passwdvalidator.dto.PasswordValidationResponse;
import com.dhiegoabrantes.passwdvalidator.service.ValidatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = PasswordValidatorController.PATH)
public class PasswordValidatorController {

    public static final String PATH = "/passwd-validator";

    private final ValidatorService<String> validatorService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PasswordValidationResponse> validate(@RequestBody PasswordValidationRequest passwordValidationRequest){
        final PasswordValidationResponse response = PasswordValidationResponse
                .builder()
                .isValid(validatorService.isValid(passwordValidationRequest.getWord()))
                .build();
        return ResponseEntity.ok(response);
    }

}
