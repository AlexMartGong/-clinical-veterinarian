package org.ax.springboot.clinicalveterinarian.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.ax.springboot.clinicalveterinarian.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExistsUsernameValidation implements ConstraintValidator<ExistsUsername, String> {

    @Autowired
    private UserService userService;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !userService.existsByUsername(s);
    }
}
