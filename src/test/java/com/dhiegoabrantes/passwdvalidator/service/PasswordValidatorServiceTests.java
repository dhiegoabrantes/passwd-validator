package com.dhiegoabrantes.passwdvalidator.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class PasswordValidatorServiceTests {

    @Autowired
    private PasswordValidatorService passwordValidatorService;

    @Test
    public void invalidCasesTest(){
        assertFalse(passwordValidatorService.isValid(null));
        assertFalse(passwordValidatorService.isValid(""));
        assertFalse(passwordValidatorService.isValid("a"));
        assertFalse(passwordValidatorService.isValid("aA"));
        assertFalse(passwordValidatorService.isValid("aA@"));
        assertFalse(passwordValidatorService.isValid("aA@123ab"));
        assertFalse(passwordValidatorService.isValid("sR9v`!G~"));
        assertFalse(passwordValidatorService.isValid("z*q.2P(Q"));
    }

    @Test
    public void validCasesTest(){
        assertTrue(passwordValidatorService.isValid("AbTp9!foo"));
        assertTrue(passwordValidatorService.isValid("aA@123abc"));
        assertTrue(passwordValidatorService.isValid("BhUv##8%y%"));
        assertTrue(passwordValidatorService.isValid("nw@&g*7*WW"));
        assertTrue(passwordValidatorService.isValid("juFYv7x7&_"));
        assertTrue(passwordValidatorService.isValid("#@@J8a$USD@"));

    }


}
