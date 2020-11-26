package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.math.BigInteger;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 241,
		messagePayloadLength = 32,
		description = "Vibration levels and accelerometer clipping"
)
public class Vibration implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4, description = "Vibration levels on X-axis")
	private float vibrationX;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4, description = "Vibration levels on Y-axis")
	private float vibrationY;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "Vibration levels on Z-axis")
	private float vibrationZ;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 5, typeSize = 4, streamLength = 4, description = "first accelerometer clipping count")
	private long clipping0;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 6, typeSize = 4, streamLength = 4, description = "second accelerometer clipping count")
	private long clipping1;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 7, typeSize = 4, streamLength = 4, description = "third accelerometer clipping count")
	private long clipping2;

	private final int messagePayloadLength = 32;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public Vibration(BigInteger timeUsec, float vibrationX, float vibrationY, float vibrationZ, long clipping0, long clipping1, long clipping2) {
		this.timeUsec = timeUsec;
		this.vibrationX = vibrationX;
		this.vibrationY = vibrationY;
		this.vibrationZ = vibrationZ;
		this.clipping0 = clipping0;
		this.clipping1 = clipping1;
		this.clipping2 = clipping2;
	}

	public Vibration(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 32！");
		}
		messagePayload(messagePayload);
	}

	public Vibration(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		vibrationX = byteArray.getFloat(8);
		vibrationY = byteArray.getFloat(12);
		vibrationZ = byteArray.getFloat(16);
		clipping0 = byteArray.getUnsignedInt32(20);
		clipping1 = byteArray.getUnsignedInt32(24);
		clipping2 = byteArray.getUnsignedInt32(28);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putFloat(vibrationX,8);
		byteArray.putFloat(vibrationY,12);
		byteArray.putFloat(vibrationZ,16);
		byteArray.putUnsignedInt32(clipping0,20);
		byteArray.putUnsignedInt32(clipping1,24);
		byteArray.putUnsignedInt32(clipping2,28);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final Vibration setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final Vibration setVibrationX(float vibrationX) {
		this.vibrationX = vibrationX;
		return this;
	}

	public final float getVibrationX() {
		return vibrationX;
	}

	public final Vibration setVibrationY(float vibrationY) {
		this.vibrationY = vibrationY;
		return this;
	}

	public final float getVibrationY() {
		return vibrationY;
	}

	public final Vibration setVibrationZ(float vibrationZ) {
		this.vibrationZ = vibrationZ;
		return this;
	}

	public final float getVibrationZ() {
		return vibrationZ;
	}

	public final Vibration setClipping0(long clipping0) {
		this.clipping0 = clipping0;
		return this;
	}

	public final long getClipping0() {
		return clipping0;
	}

	public final Vibration setClipping1(long clipping1) {
		this.clipping1 = clipping1;
		return this;
	}

	public final long getClipping1() {
		return clipping1;
	}

	public final Vibration setClipping2(long clipping2) {
		this.clipping2 = clipping2;
		return this;
	}

	public final long getClipping2() {
		return clipping2;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			Vibration other = (Vibration)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.vibrationX, other.vibrationX)) {
				return false;
			} else if (!Objects.deepEquals(this.vibrationY, other.vibrationY)) {
				return false;
			} else if (!Objects.deepEquals(this.vibrationZ, other.vibrationZ)) {
				return false;
			} else if (!Objects.deepEquals(this.clipping0, other.clipping0)) {
				return false;
			} else if (!Objects.deepEquals(this.clipping1, other.clipping1)) {
				return false;
			} else {
				return Objects.deepEquals(this.clipping2, other.clipping2);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.vibrationX);
		result = 31 * result + Objects.hashCode(this.vibrationY);
		result = 31 * result + Objects.hashCode(this.vibrationZ);
		result = 31 * result + Objects.hashCode(this.clipping0);
		result = 31 * result + Objects.hashCode(this.clipping1);
		result = 31 * result + Objects.hashCode(this.clipping2);
		return result;
	}

	@Override
	public String toString() {
		return "Vibration{" +
				"timeUsec=" + timeUsec +
				", vibrationX=" + vibrationX +
				", vibrationY=" + vibrationY +
				", vibrationZ=" + vibrationZ +
				", clipping0=" + clipping0 +
				", clipping1=" + clipping1 +
				", clipping2=" + clipping2 +
				'}';
	}
}