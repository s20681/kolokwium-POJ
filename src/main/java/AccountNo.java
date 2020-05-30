import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = BankValidator.class)
public @interface AccountNo{
    public String key() default "";
    String message() default "Invalid account no. format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}