package com.kainat.learnspringbootwebservices.api.validators;

import com.kainat.learnspringbootwebservices.api.enums.Color;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidColor.Validator.class)
public @interface ValidColor {
    String message() default "Invalid module color value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    public class Validator implements ConstraintValidator<ValidColor, String> {
        @Override
        public boolean isValid(String color, ConstraintValidatorContext context) {
            try {
                Color.valueOf(color);
                return true;
            } catch (IllegalArgumentException ex) {
                return false;
            }
        }
    }

}
