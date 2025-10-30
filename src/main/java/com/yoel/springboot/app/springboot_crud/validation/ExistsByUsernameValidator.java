package com.yoel.springboot.app.springboot_crud.validation;

import org.springframework.stereotype.Component;

import com.yoel.springboot.app.springboot_crud.services.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class ExistsByUsernameValidator implements ConstraintValidator<ExistsByUsername, String>{

    private final UserService userService;

    public ExistsByUsernameValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !userService.existsByUsername(value) ;
    }
}
