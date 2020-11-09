package cn.wsyjlly.mavlink.common.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.09 - 03:37
 **********************************/

@MavlinkMessage(
		id = 126,
		messagePayloadLength = 79,
		description = "Control a serial port. This can be used for raw access to an onboard serial peripheral such as a GPS or telemetry radio. It is designed to make it possible to update the devices firmware via MAVLink messages or change the devices settings. A message with zero bytes can be used to change just the baudrate."
)
public class SerialControl implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1)
	private short device;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1)
	private short flags;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2)
	private int timeout;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 4, typeSize = 4, streamLength = 4)
	private long baudrate;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1)
	private short count;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 70)
	private short data;

	private final int messagePayloadLength = 79;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public SerialControl(short device, short flags, int timeout, long baudrate, short count, short data) {
		this.device = device;
		this.flags = flags;
		this.timeout = timeout;
		this.baudrate = baudrate;
		this.count = count;
		this.data = data;
	}

	public SerialControl(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 79！");
		}
		messagePayload(messagePayload);
	}

	public SerialControl(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.device = byteArray.getUnsignedInt8(0);
		this.flags = byteArray.getUnsignedInt8(1);
		this.timeout = byteArray.getUnsignedInt16(2);
		this.baudrate = byteArray.getUnsignedInt32(4);
		this.count = byteArray.getUnsignedInt8(8);
		this.data = byteArray.getUnsignedInt8(9);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final SerialControl setDevice(short device) {
		this.device = device;
		return this;
	}

	public final short getDevice() {
		return device;
	}

	public final SerialControl setFlags(short flags) {
		this.flags = flags;
		return this;
	}

	public final short getFlags() {
		return flags;
	}

	public final SerialControl setTimeout(int timeout) {
		this.timeout = timeout;
		return this;
	}

	public final int getTimeout() {
		return timeout;
	}

	public final SerialControl setBaudrate(long baudrate) {
		this.baudrate = baudrate;
		return this;
	}

	public final long getBaudrate() {
		return baudrate;
	}

	public final SerialControl setCount(short count) {
		this.count = count;
		return this;
	}

	public final short getCount() {
		return count;
	}

	public final SerialControl setData(short data) {
		this.data = data;
		return this;
	}

	public final short getData() {
		return data;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			SerialControl other = (SerialControl)o;
			if (!Objects.deepEquals(this.device, other.device)) {
				return false;
			} else if (!Objects.deepEquals(this.flags, other.flags)) {
				return false;
			} else if (!Objects.deepEquals(this.timeout, other.timeout)) {
				return false;
			} else if (!Objects.deepEquals(this.baudrate, other.baudrate)) {
				return false;
			} else if (!Objects.deepEquals(this.count, other.count)) {
				return false;
			} else {
				return Objects.deepEquals(this.data, other.data);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.device);
		result = 31 * result + Objects.hashCode(this.flags);
		result = 31 * result + Objects.hashCode(this.timeout);
		result = 31 * result + Objects.hashCode(this.baudrate);
		result = 31 * result + Objects.hashCode(this.count);
		result = 31 * result + Objects.hashCode(this.data);
		return result;
	}

	@Override
	public String toString() {
		return "SerialControl{" +
				"device=" + device +
				", flags=" + flags +
				", timeout=" + timeout +
				", baudrate=" + baudrate +
				", count=" + count +
				", data=" + data +
				'}';
	}
}