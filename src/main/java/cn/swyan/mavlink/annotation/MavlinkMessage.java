package cn.swyan.mavlink.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.10.29 - 21:19
 **********************************/

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MavlinkMessage {
	int id();
	int messagePayloadLength();
	String description() default "No description provided";
}