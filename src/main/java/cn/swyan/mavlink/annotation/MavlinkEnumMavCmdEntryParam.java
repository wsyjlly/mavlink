package cn.swyan.mavlink.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**********************************
 * Author YSW
 * Description
 * Date 2020.10.29 - 21:17
 **********************************/

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface MavlinkEnumMavCmdEntryParam {
	int index() default 0;
	String label() default "";
	int minValue() default 0;
	int maxValue() default 0;
	int increment() default 0;
	String reserved() default "";
	String default0() default "";
	String units() default "";
	Class<?> enum0() default void.class;
}