package com.kainat.learnspringbootwebservices.api.validators;

import com.kainat.learnspringbootwebservices.api.enums.Icon;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidIcon.Validator.class)
public @interface ValidIcon {

    String message() default "Invalid module icon value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    class Validator implements ConstraintValidator<ValidIcon, String>{
        @Override
        public boolean isValid(String icon, ConstraintValidatorContext context) {
            try{
                Icon.valueOf(icon);
                return true;
            }
            catch (IllegalArgumentException ex){
                return false;
            }
        }
    }
}
