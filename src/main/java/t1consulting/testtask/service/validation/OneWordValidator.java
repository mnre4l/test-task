package t1consulting.testtask.service.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * Класс предназначен для определения условий валидации, накладываемых на входную строку
 */
public class OneWordValidator implements ConstraintValidator<OneWord, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return ((!s.isBlank()) && (!s.contains(" ")));
    }
}
