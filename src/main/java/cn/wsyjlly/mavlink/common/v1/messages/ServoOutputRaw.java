package cn.wsyjlly.mavlink.common.v1.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkMessage(
		id = 36,
		messagePayloadLength = 21,
		description = "The RAW values of the servo outputs (for RC input from the remote, use the RC_CHANNELS messages). The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%."
)
public class ServoOutputRaw implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp (microseconds since system boot)")
	private long timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Servo output port (set of 8 outputs = 1 port). Most MAVs will just use one, but this allows to encode more than 8 servos.")
	private short port;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2, description = "Servo output 1 value, in microseconds")
	private int servo1Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 4, typeSize = 2, streamLength = 2, description = "Servo output 2 value, in microseconds")
	private int servo2Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 5, typeSize = 2, streamLength = 2, description = "Servo output 3 value, in microseconds")
	private int servo3Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 6, typeSize = 2, streamLength = 2, description = "Servo output 4 value, in microseconds")
	private int servo4Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 7, typeSize = 2, streamLength = 2, description = "Servo output 5 value, in microseconds")
	private int servo5Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 8, typeSize = 2, streamLength = 2, description = "Servo output 6 value, in microseconds")
	private int servo6Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 9, typeSize = 2, streamLength = 2, description = "Servo output 7 value, in microseconds")
	private int servo7Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 10, typeSize = 2, streamLength = 2, description = "Servo output 8 value, in microseconds")
	private int servo8Raw;

	private final int messagePayloadLength = 21;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ServoOutputRaw(long timeUsec, short port, int servo1Raw, int servo2Raw, int servo3Raw, int servo4Raw, int servo5Raw, int servo6Raw, int servo7Raw, int servo8Raw) {
		this.timeUsec = timeUsec;
		this.port = port;
		this.servo1Raw = servo1Raw;
		this.servo2Raw = servo2Raw;
		this.servo3Raw = servo3Raw;
		this.servo4Raw = servo4Raw;
		this.servo5Raw = servo5Raw;
		this.servo6Raw = servo6Raw;
		this.servo7Raw = servo7Raw;
		this.servo8Raw = servo8Raw;
	}

	public ServoOutputRaw(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 21！");
		}
		messagePayload(messagePayload);
	}

	public ServoOutputRaw(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt32(0);
		port = byteArray.getUnsignedInt8(4);
		servo1Raw = byteArray.getUnsignedInt16(5);
		servo2Raw = byteArray.getUnsignedInt16(7);
		servo3Raw = byteArray.getUnsignedInt16(9);
		servo4Raw = byteArray.getUnsignedInt16(11);
		servo5Raw = byteArray.getUnsignedInt16(13);
		servo6Raw = byteArray.getUnsignedInt16(15);
		servo7Raw = byteArray.getUnsignedInt16(17);
		servo8Raw = byteArray.getUnsignedInt16(19);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeUsec,0);
		byteArray.putUnsignedInt8(port,4);
		byteArray.putUnsignedInt16(servo1Raw,5);
		byteArray.putUnsignedInt16(servo2Raw,7);
		byteArray.putUnsignedInt16(servo3Raw,9);
		byteArray.putUnsignedInt16(servo4Raw,11);
		byteArray.putUnsignedInt16(servo5Raw,13);
		byteArray.putUnsignedInt16(servo6Raw,15);
		byteArray.putUnsignedInt16(servo7Raw,17);
		byteArray.putUnsignedInt16(servo8Raw,19);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ServoOutputRaw setTimeUsec(long timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final long getTimeUsec() {
		return timeUsec;
	}

	public final ServoOutputRaw setPort(short port) {
		this.port = port;
		return this;
	}

	public final short getPort() {
		return port;
	}

	public final ServoOutputRaw setServo1Raw(int servo1Raw) {
		this.servo1Raw = servo1Raw;
		return this;
	}

	public final int getServo1Raw() {
		return servo1Raw;
	}

	public final ServoOutputRaw setServo2Raw(int servo2Raw) {
		this.servo2Raw = servo2Raw;
		return this;
	}

	public final int getServo2Raw() {
		return servo2Raw;
	}

	public final ServoOutputRaw setServo3Raw(int servo3Raw) {
		this.servo3Raw = servo3Raw;
		return this;
	}

	public final int getServo3Raw() {
		return servo3Raw;
	}

	public final ServoOutputRaw setServo4Raw(int servo4Raw) {
		this.servo4Raw = servo4Raw;
		return this;
	}

	public final int getServo4Raw() {
		return servo4Raw;
	}

	public final ServoOutputRaw setServo5Raw(int servo5Raw) {
		this.servo5Raw = servo5Raw;
		return this;
	}

	public final int getServo5Raw() {
		return servo5Raw;
	}

	public final ServoOutputRaw setServo6Raw(int servo6Raw) {
		this.servo6Raw = servo6Raw;
		return this;
	}

	public final int getServo6Raw() {
		return servo6Raw;
	}

	public final ServoOutputRaw setServo7Raw(int servo7Raw) {
		this.servo7Raw = servo7Raw;
		return this;
	}

	public final int getServo7Raw() {
		return servo7Raw;
	}

	public final ServoOutputRaw setServo8Raw(int servo8Raw) {
		this.servo8Raw = servo8Raw;
		return this;
	}

	public final int getServo8Raw() {
		return servo8Raw;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ServoOutputRaw other = (ServoOutputRaw)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.port, other.port)) {
				return false;
			} else if (!Objects.deepEquals(this.servo1Raw, other.servo1Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.servo2Raw, other.servo2Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.servo3Raw, other.servo3Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.servo4Raw, other.servo4Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.servo5Raw, other.servo5Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.servo6Raw, other.servo6Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.servo7Raw, other.servo7Raw)) {
				return false;
			} else {
				return Objects.deepEquals(this.servo8Raw, other.servo8Raw);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.port);
		result = 31 * result + Objects.hashCode(this.servo1Raw);
		result = 31 * result + Objects.hashCode(this.servo2Raw);
		result = 31 * result + Objects.hashCode(this.servo3Raw);
		result = 31 * result + Objects.hashCode(this.servo4Raw);
		result = 31 * result + Objects.hashCode(this.servo5Raw);
		result = 31 * result + Objects.hashCode(this.servo6Raw);
		result = 31 * result + Objects.hashCode(this.servo7Raw);
		result = 31 * result + Objects.hashCode(this.servo8Raw);
		return result;
	}

	@Override
	public String toString() {
		return "ServoOutputRaw{" +
				"timeUsec=" + timeUsec +
				", port=" + port +
				", servo1Raw=" + servo1Raw +
				", servo2Raw=" + servo2Raw +
				", servo3Raw=" + servo3Raw +
				", servo4Raw=" + servo4Raw +
				", servo5Raw=" + servo5Raw +
				", servo6Raw=" + servo6Raw +
				", servo7Raw=" + servo7Raw +
				", servo8Raw=" + servo8Raw +
				'}';
	}
}