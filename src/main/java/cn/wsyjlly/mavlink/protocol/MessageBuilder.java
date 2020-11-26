package cn.wsyjlly.mavlink.protocol;

import cn.wsyjlly.mavlink.common.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

import static cn.wsyjlly.mavlink.protocol.Packet.readV1Packet;
import static cn.wsyjlly.mavlink.protocol.Packet.readV2Packet;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.04 - 20:02
 **********************************/

public class MessageBuilder {

	public static void readPacketBytesList(byte[] packetsBytes, Consumer<List<byte[]>> consumer) {
		consumer.accept(readPacketBytesList(packetsBytes));
	}

	public static List<byte[]> readPacketBytesList(byte[] packetsBytes) {
		MessageInputStream stream = new MessageInputStream(packetsBytes);
		ArrayList<byte[]> messageList = new ArrayList<>();
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
				if (stream.read(packetBytes, 0, packageLength) == packageLength){
					messageList.add(packetBytes);
				}
			} else if (read == 0xFD) {
				packageLength = stream.read() + 12;
				if (packageLength > 267) {
					throw new RuntimeException("载荷长度异常！");
				}
				packetBytes = new byte[packageLength];
				stream.reset();
				if (stream.read(packetBytes, 0, packageLength) == packageLength){
					messageList.add(packetBytes);
				}
			}
		}
		return messageList;
	}

	public static void readPacketList(byte[] packetsBytes, Consumer<List<Packet<?>>> consumer) {
		consumer.accept(readPacketList(packetsBytes));
	}

	public static List<Packet<?>> readPacketList(byte[] packetsBytes) {
		MessageInputStream stream = new MessageInputStream(packetsBytes);
		ArrayList<Packet<?>> messageList = new ArrayList<>();
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
				if (stream.read(packetBytes, 0, packageLength) == packageLength){
					readV1Packet(packetBytes,(packet -> {
						if (Objects.nonNull(packet)) {
							messageList.add(packet);
						}
					}));
				}
			} else if (read == 0xFD) {
				packageLength = stream.read() + 12;
				if (packageLength > 267) {
					throw new RuntimeException("载荷长度异常！");
				}
				packetBytes = new byte[packageLength];
				stream.reset();
				if (stream.read(packetBytes, 0, packageLength) == packageLength){
					readV2Packet(packetBytes,(packet -> {
						if (Objects.nonNull(packet)) {
							messageList.add(packet);
						}
					}));
				}
			}
		}
		return messageList;
	}

	public static void readFilterMessageList(byte[] packetsBytes, Set<Class<? extends Message>> filter, Consumer<List<Message>> consumer) {
		consumer.accept(readFilterMessageList(packetsBytes,filter));
	}

	public static List<Message> readFilterMessageList(byte[] packetsBytes, Set<Class<? extends Message>> filter) {
		MessageInputStream stream = new MessageInputStream(packetsBytes);
		ArrayList<Message> messageList = new ArrayList<>();
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
				Message message = readV1Message(stream, packageLength, packetBytes,filter);
				if (Objects.nonNull(message)) {
					messageList.add(message);
				}
			} else if (read == 0xFD) {
				packageLength = stream.read() + 12;
				if (packageLength > 267) {
					throw new RuntimeException("载荷长度异常！");
				}
				packetBytes = new byte[packageLength];
				stream.reset();
				Message message = readV2Message(stream, packageLength, packetBytes,filter);
				if (Objects.nonNull(message)) {
					messageList.add(message);
				}
			}
		}
		return messageList;
	}

	public static void readAnyMessageList(byte[] packetsBytes, Consumer<List<Message>> consumer) {
		consumer.accept(readAnyMessageList(packetsBytes));
	}

	public static List<Message> readAnyMessageList(byte[] packetsBytes) {
		MessageInputStream stream = new MessageInputStream(packetsBytes);
		ArrayList<Message> messageList = new ArrayList<>();
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
				Message message = readV1Message(stream, packageLength, packetBytes);
				if (Objects.nonNull(message)) {
					messageList.add(message);
				}
			} else if (read == 0xFD) {
				packageLength = stream.read() + 12;
				if (packageLength > 267) {
					throw new RuntimeException("载荷长度异常！");
				}
				packetBytes = new byte[packageLength];
				stream.reset();
				Message message = readV2Message(stream, packageLength, packetBytes);
				if (Objects.nonNull(message)) {
					messageList.add(message);
				}
			}
		}
		return messageList;
	}

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
				packageLength = stream.read() + 12;
				if (packageLength > 267) {
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

	public static void readAnyMessage(byte[] packetBytes, Consumer<Message> consumer) {
		consumer.accept(readAnyMessage(packetBytes));
	}

	public static Message readAnyMessage(byte[] packetBytes) {
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
		Class<? extends Message> messageClass = MavlinkConfig.allType().get(messageId);
		if (Objects.nonNull(messageClass)) {
			cn.wsyjlly.mavlink.annotation.MavlinkMessage annotation = messageClass.getAnnotation(cn.wsyjlly.mavlink.annotation.MavlinkMessage.class);
			if (annotation.id() == messageId) {
				if (annotation.messagePayloadLength() == payloadLength) {
					try {
						Message message = messageClass.newInstance();
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
		return null;
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
		return null;
	}

	private static Message readV1Message(MessageInputStream stream, int packageLength, byte[] packetBytes) {
		if (stream.read(packetBytes, 0, packageLength) == packageLength) {
			Packet<Message> packet = readV1Packet(packetBytes);
			return readMessage0(packet);
		}
		return null;
	}

	private static Message readV2Message(MessageInputStream stream, int packageLength, byte[] packetBytes) {
		if (stream.read(packetBytes, 0, packageLength) == packageLength) {
			Packet<Message> packet = readV2Packet(packetBytes);
			return readMessage0(packet);
		}
		return null;
	}

	private static <T extends Message> T readV1Message(MessageInputStream stream, int packageLength, byte[] packetBytes, Class<T> receiveMessage) {
		if (stream.read(packetBytes, 0, packageLength) == packageLength) {
			Packet<T> packet = readV1Packet(packetBytes);
			return readMessage0(packet, receiveMessage);
		}
		return null;
	}

	private static <T extends Message> T readV2Message(MessageInputStream stream, int packageLength, byte[] packetBytes, Class<T> receiveMessage) {
		if (stream.read(packetBytes, 0, packageLength) == packageLength) {
			Packet<T> packet = readV2Packet(packetBytes);
			return readMessage0(packet, receiveMessage);
		}
		return null;
	}

	private static Message readV1Message(MessageInputStream stream, int packageLength, byte[] packetBytes, Set<Class<? extends Message>> filter) {
		if (stream.read(packetBytes, 0, packageLength) == packageLength) {
			Packet<Message> packet = readV1Packet(packetBytes);
			return readMessage0(packet, filter);
		}
		return null;
	}

	private static Message readV2Message(MessageInputStream stream, int packageLength, byte[] packetBytes, Set<Class<? extends Message>> filter) {
		if (stream.read(packetBytes, 0, packageLength) == packageLength) {
			Packet<Message> packet = readV2Packet(packetBytes);
			return readMessage0(packet, filter);
		}
		return null;
	}

	private static Message readMessage0(Packet<Message> packet) {
		Class<? extends Message> messageClass = MavlinkConfig.allType().get(packet.getMessageId());
		if (Objects.nonNull(messageClass)) {
			cn.wsyjlly.mavlink.annotation.MavlinkMessage annotation = messageClass.getAnnotation(cn.wsyjlly.mavlink.annotation.MavlinkMessage.class);
			if (annotation.id() == packet.getMessageId()) {
				if (annotation.messagePayloadLength() == packet.getPayload().length) {
					try {
						Message message = messageClass.newInstance();
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

	private static Message readMessage0(Packet<Message> packet, Set<Class<? extends Message>> filter) {
		Message message = null;
		for (Class<? extends Message> messageClass : filter){
			if (Objects.nonNull(messageClass)) {
				cn.wsyjlly.mavlink.annotation.MavlinkMessage annotation = messageClass.getAnnotation(cn.wsyjlly.mavlink.annotation.MavlinkMessage.class);
				if (annotation.id() == packet.getMessageId()) {
					if (annotation.messagePayloadLength() == packet.getPayload().length) {
						try {
							message = messageClass.newInstance();
							message.messagePayload(packet.getPayload());
							break;
						} catch (InstantiationException | IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return message;
	}
}
