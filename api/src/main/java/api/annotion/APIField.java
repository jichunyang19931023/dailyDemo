package api.annotion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Inherited
public @interface APIField {
    // 可否为空
    boolean isRequired() default false;
    // 参数类型
    String type() default "";
    // 参数说明，备注
    String remark() default "";
}