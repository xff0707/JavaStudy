package supplementary.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//@Inherited
//@Repeatable(MyAnnotations.class)
//@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_PARAMETER,ElementType.TYPE_USE})
public @interface MyAnnotation {
    String value() default "hello";
}
