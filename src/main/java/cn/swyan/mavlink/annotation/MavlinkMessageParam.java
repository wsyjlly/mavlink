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
@Target(ElementType.FIELD)
public @interface MavlinkMessageParam {
	/**
	 * Mavlink字段类型
	 * @return
	 */
	String mavlinkType();

	/**
	 * 在载荷中的位置序号
	 * @return
	 */
	int position();

	/**
	 * 类型字节长度
	 * @return
	 */
	int typeSize();

	/**
	 * 字节流长度
	 * @return
	 */
	int streamLength();
	/**
	 * Mavlink字段单位
	 * @return
	 */
	String units() default "";
	Class<?> enum0() default void.class;
	String description() default "No description provided";
}