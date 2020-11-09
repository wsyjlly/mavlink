package cn.swyan.mavlink.protocol;

import cn.swyan.mavlink.common.Message;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.04 - 20:01
 **********************************/

public class MessageFilter {
	public final static HashSet<Class<? extends Message>> RECEIVED_MESSAGES;

	static {
		RECEIVED_MESSAGES = new HashSet<>();
	}

	public static void addFilter(Class<? extends Message>... messageType) {
		if (Objects.nonNull(messageType)) {
			RECEIVED_MESSAGES.addAll(Arrays.asList(messageType));
		}
	}
}
