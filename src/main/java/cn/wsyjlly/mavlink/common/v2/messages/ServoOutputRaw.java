package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 36,
		messagePayloadLength = 37,
		description = "Superseded by ACTUATOR_OUTPUT_STATUS. The RAW values of the servo outputs (for RC input from the remote, use the RC_CHANNELS messages). The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%."
)
public class ServoOutputRaw implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private long timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Servo output port (set of 8 outputs = 1 port). Flight stacks running on Pixhawk should use: 0 = MAIN, 1 = AUX.")
	private short port;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2, description = "Servo output 1 value", units = "us")
	private int servo1Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 4, typeSize = 2, streamLength = 2, description = "Servo output 2 value", units = "us")
	private int servo2Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 5, typeSize = 2, streamLength = 2, description = "Servo output 3 value", units = "us")
	private int servo3Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 6, typeSize = 2, streamLength = 2, description = "Servo output 4 value", units = "us")
	private int servo4Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 7, typeSize = 2, streamLength = 2, description = "Servo output 5 value", units = "us")
	private int servo5Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 8, typeSize = 2, streamLength = 2, description = "Servo output 6 value", units = "us")
	private int servo6Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 9, typeSize = 2, streamLength = 2, description = "Servo output 7 value", units = "us")
	private int servo7Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 10, typeSize = 2, streamLength = 2, description = "Servo output 8 value", units = "us")
	private int servo8Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 11, typeSize = 2, streamLength = 2, description = "Servo output 9 value", units = "us")
	private int servo9Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 12, typeSize = 2, streamLength = 2, description = "Servo output 10 value", units = "us")
	private int servo10Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 13, typeSize = 2, streamLength = 2, description = "Servo output 11 value", units = "us")
	private int servo11Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 14, typeSize = 2, streamLength = 2, description = "Servo output 12 value", units = "us")
	private int servo12Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 15, typeSize = 2, streamLength = 2, description = "Servo output 13 value", units = "us")
	private int servo13Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 16, typeSize = 2, streamLength = 2, description = "Servo output 14 value", units = "us")
	private int servo14Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 17, typeSize = 2, streamLength = 2, description = "Servo output 15 value", units = "us")
	private int servo15Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 18, typeSize = 2, streamLength = 2, description = "Servo output 16 value", units = "us")
	private int servo16Raw;

	private final int messagePayloadLength = 37;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ServoOutputRaw(long timeUsec, short port, int servo1Raw, int servo2Raw, int servo3Raw, int servo4Raw, int servo5Raw, int servo6Raw, int servo7Raw, int servo8Raw, int servo9Raw, int servo10Raw, int servo11Raw, int servo12Raw, int servo13Raw, int servo14Raw, int servo15Raw, int servo16Raw) {
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
		this.servo9Raw = servo9Raw;
		this.servo10Raw = servo10Raw;
		this.servo11Raw = servo11Raw;
		this.servo12Raw = servo12Raw;
		this.servo13Raw = servo13Raw;
		this.servo14Raw = servo14Raw;
		this.servo15Raw = servo15Raw;
		this.servo16Raw = servo16Raw;
	}

	public ServoOutputRaw(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 37！");
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
		servo9Raw = byteArray.getUnsignedInt16(21);
		servo10Raw = byteArray.getUnsignedInt16(23);
		servo11Raw = byteArray.getUnsignedInt16(25);
		servo12Raw = byteArray.getUnsignedInt16(27);
		servo13Raw = byteArray.getUnsignedInt16(29);
		servo14Raw = byteArray.getUnsignedInt16(31);
		servo15Raw = byteArray.getUnsignedInt16(33);
		servo16Raw = byteArray.getUnsignedInt16(35);
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
		byteArray.putUnsignedInt16(servo9Raw,21);
		byteArray.putUnsignedInt16(servo10Raw,23);
		byteArray.putUnsignedInt16(servo11Raw,25);
		byteArray.putUnsignedInt16(servo12Raw,27);
		byteArray.putUnsignedInt16(servo13Raw,29);
		byteArray.putUnsignedInt16(servo14Raw,31);
		byteArray.putUnsignedInt16(servo15Raw,33);
		byteArray.putUnsignedInt16(servo16Raw,35);
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

	public final ServoOutputRaw setServo9Raw(int servo9Raw) {
		this.servo9Raw = servo9Raw;
		return this;
	}

	public final int getServo9Raw() {
		return servo9Raw;
	}

	public final ServoOutputRaw setServo10Raw(int servo10Raw) {
		this.servo10Raw = servo10Raw;
		return this;
	}

	public final int getServo10Raw() {
		return servo10Raw;
	}

	public final ServoOutputRaw setServo11Raw(int servo11Raw) {
		this.servo11Raw = servo11Raw;
		return this;
	}

	public final int getServo11Raw() {
		return servo11Raw;
	}

	public final ServoOutputRaw setServo12Raw(int servo12Raw) {
		this.servo12Raw = servo12Raw;
		return this;
	}

	public final int getServo12Raw() {
		return servo12Raw;
	}

	public final ServoOutputRaw setServo13Raw(int servo13Raw) {
		this.servo13Raw = servo13Raw;
		return this;
	}

	public final int getServo13Raw() {
		return servo13Raw;
	}

	public final ServoOutputRaw setServo14Raw(int servo14Raw) {
		this.servo14Raw = servo14Raw;
		return this;
	}

	public final int getServo14Raw() {
		return servo14Raw;
	}

	public final ServoOutputRaw setServo15Raw(int servo15Raw) {
		this.servo15Raw = servo15Raw;
		return this;
	}

	public final int getServo15Raw() {
		return servo15Raw;
	}

	public final ServoOutputRaw setServo16Raw(int servo16Raw) {
		this.servo16Raw = servo16Raw;
		return this;
	}

	public final int getServo16Raw() {
		return servo16Raw;
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
			} else if (!Objects.deepEquals(this.servo8Raw, other.servo8Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.servo9Raw, other.servo9Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.servo10Raw, other.servo10Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.servo11Raw, other.servo11Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.servo12Raw, other.servo12Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.servo13Raw, other.servo13Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.servo14Raw, other.servo14Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.servo15Raw, other.servo15Raw)) {
				return false;
			} else {
				return Objects.deepEquals(this.servo16Raw, other.servo16Raw);
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
		result = 31 * result + Objects.hashCode(this.servo9Raw);
		result = 31 * result + Objects.hashCode(this.servo10Raw);
		result = 31 * result + Objects.hashCode(this.servo11Raw);
		result = 31 * result + Objects.hashCode(this.servo12Raw);
		result = 31 * result + Objects.hashCode(this.servo13Raw);
		result = 31 * result + Objects.hashCode(this.servo14Raw);
		result = 31 * result + Objects.hashCode(this.servo15Raw);
		result = 31 * result + Objects.hashCode(this.servo16Raw);
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
				", servo9Raw=" + servo9Raw +
				", servo10Raw=" + servo10Raw +
				", servo11Raw=" + servo11Raw +
				", servo12Raw=" + servo12Raw +
				", servo13Raw=" + servo13Raw +
				", servo14Raw=" + servo14Raw +
				", servo15Raw=" + servo15Raw +
				", servo16Raw=" + servo16Raw +
				'}';
	}
}