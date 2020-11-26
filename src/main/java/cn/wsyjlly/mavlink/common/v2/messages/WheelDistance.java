package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.util.Arrays;
import java.math.BigInteger;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 9000,
		messagePayloadLength = 137,
		description = "Cumulative distance traveled for each reported wheel."
)
public class WheelDistance implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (synced to UNIX time or since system boot).", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Number of wheels reported.")
	private short count;

	@MavlinkMessageParam(mavlinkType = "double", position = 3, typeSize = 8, streamLength = 128, description = "Distance reported by individual wheel encoders. Forward rotations increase values, reverse rotations decrease them. Not all wheels will necessarily have wheel encoders; the mapping of encoders to wheel positions must be agreed/understood by the endpoints.", units = "m")
	private double[] distance = new double[16];

	private final int messagePayloadLength = 137;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public WheelDistance(BigInteger timeUsec, short count, double[] distance) {
		this.timeUsec = timeUsec;
		this.count = count;
		this.distance = distance;
	}

	public WheelDistance(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 137！");
		}
		messagePayload(messagePayload);
	}

	public WheelDistance(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		count = byteArray.getUnsignedInt8(8);
		distance = byteArray.getDoubleArray(9,16);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putUnsignedInt8(count,8);
		byteArray.putDoubleArray(distance,9);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final WheelDistance setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final WheelDistance setCount(short count) {
		this.count = count;
		return this;
	}

	public final short getCount() {
		return count;
	}

	public final WheelDistance setDistance(double[] distance) {
		this.distance = distance;
		return this;
	}

	public final double[] getDistance() {
		return distance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			WheelDistance other = (WheelDistance)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.count, other.count)) {
				return false;
			} else {
				return Objects.deepEquals(this.distance, other.distance);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.count);
		result = 31 * result + Objects.hashCode(this.distance);
		return result;
	}

	@Override
	public String toString() {
		return "WheelDistance{" +
				"timeUsec=" + timeUsec +
				", count=" + count +
				", distance=" + Arrays.toString(distance) +
				'}';
	}
}