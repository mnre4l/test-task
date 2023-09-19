package t1consulting.testtask.service.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OneWordValidator.class)
public @interface OneWord {
    String message() default "Bad string format: should be no spaces and no null";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
