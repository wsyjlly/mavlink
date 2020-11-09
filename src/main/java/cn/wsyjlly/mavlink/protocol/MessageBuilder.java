package cn.wsyjlly.mavlink.protocol;

import cn.wsyjlly.mavlink.common.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static cn.wsyjlly.mavlink.protocol.Packet.readV1Packet;
import static cn.wsyjlly.mavlink.protocol.Packet.readV2Packet;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.04 - 20:02
 **********************************/

public class MessageBuilder {

	public static <T extends Message> void readMessageList(byte[] packetsBytes, Class<T> messageType, Consumer<List<T>> consumer) {
		consumer.accept(readMessageList(packetsBytes, messageType));
	}

	public static <T extends Message> List<T> readMessageList(byte[] packetsBytes, Class<T> messageType) {
		MessageInputStream stream = new MessageInputStream(packetsBytes);
		ArrayList<T> messageList = new ArrayList<>();
		while (stream.available() != 0) {
			int packageLength;
			byte[] packetBytes;
			stream.mark();
			int read = stream.read();
			if (read == 0xFE) {
				packageLength = stream.read() + 8;
				if (packageLength > 263) {
					throw new RuntimeException("载荷长度异常！");
				}
				packetBytes = new byte[packageLength];
				stream.reset();
				T message = readV1Message(stream, packageLength, packetBytes, messageType);
				if (Objects.nonNull(message)) {
					messageList.add(message);
				}
			} else if (read == 0xFD) {
				packageLength = stream.read() + 25;
				if (packageLength > 280) {
					throw new RuntimeException("载荷长度异常！");
				}
				packetBytes = new byte[packageLength];
				stream.reset();
				T message = readV2Message(stream, packageLength, packetBytes, messageType);
				if (Objects.nonNull(message)) {
					messageList.add(message);
				}
			}
		}
		return messageList;
	}

	public static <T extends Message> void readMessage(byte[] packetBytes, Class<T> messageType, Consumer<T> consumer) {
		consumer.accept(readMessage(packetBytes, messageType));
	}

	public static <T extends Message> T readMessage(byte[] packetBytes, Class<T> messageClass) {
		ByteArray bytes = new ByteArray(packetBytes);
		int versionFlag = bytes.getUnsignedInt8(0);
		int payloadLength = bytes.getUnsignedInt8(1);
		int messageId;
		byte[] payload;
		if (versionFlag == 0xFE) {
			messageId = bytes.getUnsignedInt8(5);
			payload = bytes.slice(6, payloadLength);
		} else if (versionFlag == 0xFD) {
			messageId = bytes.getUnsignedInt24(7);
			payload = bytes.slice(10, payloadLength);
		} else {
			return null;
		}
		if (Objects.nonNull(messageClass)) {
			cn.wsyjlly.mavlink.annotation.MavlinkMessage annotation = messageClass.getAnnotation(cn.wsyjlly.mavlink.annotation.MavlinkMessage.class);
			if (annotation.id() == messageId) {
				if (annotation.messagePayloadLength() == payloadLength) {
					try {
						T message = messageClass.newInstance();
						message.messagePayload(payload);
						return message;
					} catch (InstantiationException | IllegalAccessException e) {
						e.printStackTrace();
					}
				} else {
					throw new IllegalArgumentException("Byte array length is not equal to " + payloadLength + "！");
				}
			} else {
				return null;
			}
		}
		try {
			T message0 = messageClass.newInstance();
			message0.messagePayload(payload);
			return message0;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static <T extends Message> T readV1Message(MessageInputStream stream, int packageLength, byte[] packetBytes, Class<T> receiveMessage) {
		if (stream.read(packetBytes, 0, packageLength) > 0) {
			Packet<T> packet = readV1Packet(packetBytes);
			return readMessage0(packet, receiveMessage);
		}
		return null;
	}

	private static <T extends Message> T readV2Message(MessageInputStream stream, int packageLength, byte[] packetBytes, Class<T> receiveMessage) {
		if (stream.read(packetBytes, 0, packageLength) > 0) {
			Packet<T> packet = readV2Packet(packetBytes);
			return readMessage0(packet, receiveMessage);
		}
		return null;
	}

	private static <T extends Message> T readMessage0(Packet<T> packet, Class<T> messageClass) {
		if (Objects.nonNull(messageClass)) {
			cn.wsyjlly.mavlink.annotation.MavlinkMessage annotation = messageClass.getAnnotation(cn.wsyjlly.mavlink.annotation.MavlinkMessage.class);
			if (annotation.id() == packet.getMessageId()) {
				if (annotation.messagePayloadLength() == packet.getPayload().length) {
					try {
						T message = messageClass.newInstance();
						message.messagePayload(packet.getPayload());
						return message;
					} catch (InstantiationException | IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return null;
	}
}
