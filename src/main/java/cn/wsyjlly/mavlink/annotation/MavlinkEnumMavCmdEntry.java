package cn.wsyjlly.mavlink.annotation;

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
@Target({ElementType.TYPE})
public @interface MavlinkEnumMavCmdEntry {
	int value() default 0;
	String name() default "";
	String hasLocation() default "";
	String isDestination() default "";
	String description() default "";
}