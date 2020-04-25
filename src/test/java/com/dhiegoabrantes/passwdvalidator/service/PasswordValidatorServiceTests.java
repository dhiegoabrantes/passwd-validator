package com.dhiegoabrantes.passwdvalidator.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class PasswordValidatorServiceTests {

    @Autowired
    private PasswordValidatorService passwordValidatorService;

    static Stream<String> blankStrings() {
        return Stream.of("", "   ", null);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "aA", "aA@", "aA@123ab", "sR9v`!G~", "z*q.2P(Q"} )
    @MethodSource("blankStrings")
    public void invalidCasesTest(String input) {
        assertFalse(passwordValidatorService.isValid(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"AbTp9!foo", "aA@123abc", "BhUv##8%y%", "nw@&g*7*WW", "juFYv7x7&_", "#@@J8a$USD@"} )
    public void validCasesTest(String input){
        assertTrue(passwordValidatorService.isValid(input));
    }


}
