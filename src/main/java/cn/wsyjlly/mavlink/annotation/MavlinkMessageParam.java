package cn.wsyjlly.mavlink.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**********************************
 * Author YSW
 * Description
 * Date 2020.10.29 - 21:19
 **********************************/

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MavlinkMessageParam {
	String mavlinkType();
	int position();
	int typeSize();
	int streamLength();
	String units() default "";
	Class<?> enum0() default void.class;
	String description() default "No description provided";
}