package com.dhiegoabrantes.passwdvalidator.service;

public interface ValidatorService<T> {

    boolean isValid(T valueToValidate);

}
