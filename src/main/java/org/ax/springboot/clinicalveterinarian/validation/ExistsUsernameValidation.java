package org.ax.springboot.clinicalveterinarian.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.ax.springboot.clinicalveterinarian.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExistsUsernameValidation implements ConstraintValidator<ExistsUsername, String> {

    private UserService userService;

    // This constructor is for when Spring creates the instance
    @Autowired
    public ExistsUsernameValidation(UserService userService) {
        this.userService = userService;
    }

    // This constructor is for when Hibernate Validator creates the instance
    public ExistsUsernameValidation() {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (userService == null) {
            return true;
        }
        return !userService.existsByUsername(s);
    }
}