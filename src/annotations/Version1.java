package annotations;
import java.lang.annotation.*;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Version1 {
    String number();
    String date();
    Class<?> previous() default Void.class;
}