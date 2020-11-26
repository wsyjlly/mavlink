package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavFrame;
import cn.wsyjlly.mavlink.common.v2.enums.MavDistanceSensor;
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
		id = 330,
		messagePayloadLength = 167,
		description = "Obstacle distances in front of the sensor, starting from the left in increment degrees to the right"
)
public class ObstacleDistance implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Class id of the distance sensor type.", enum0 = MavDistanceSensor.class)
	private short sensorType;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 144, description = "Distance of obstacles around the vehicle with index 0 corresponding to north + angle_offset, unless otherwise specified in the frame. A value of 0 is valid and means that the obstacle is practically touching the sensor. A value of max_distance +1 means no obstacle is present. A value of UINT16_MAX for unknown/not used. In a array element, one unit corresponds to 1cm.", units = "cm")
	private int[] distances = new int[72];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "Angular width in degrees of each array element. Increment direction is clockwise. This field is ignored if increment_f is non-zero.", units = "deg")
	private short increment;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 5, typeSize = 2, streamLength = 2, description = "Minimum distance the sensor can measure.", units = "cm")
	private int minDistance;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 6, typeSize = 2, streamLength = 2, description = "Maximum distance the sensor can measure.", units = "cm")
	private int maxDistance;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "Angular width in degrees of each array element as a float. If non-zero then this value is used instead of the uint8_t increment field. Positive is clockwise direction, negative is counter-clockwise.", units = "deg")
	private float incrementF;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "Relative angle offset of the 0-index element in the distances array. Value of 0 corresponds to forward. Positive is clockwise direction, negative is counter-clockwise.", units = "deg")
	private float angleOffset;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 9, typeSize = 1, streamLength = 1, description = "Coordinate frame of reference for the yaw rotation and offset of the sensor data. Defaults to MAV_FRAME_GLOBAL, which is north aligned. For body-mounted sensors use MAV_FRAME_BODY_FRD, which is vehicle front aligned.", enum0 = MavFrame.class)
	private short frame;

	private final int messagePayloadLength = 167;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ObstacleDistance(BigInteger timeUsec, short sensorType, int[] distances, short increment, int minDistance, int maxDistance, float incrementF, float angleOffset, short frame) {
		this.timeUsec = timeUsec;
		this.sensorType = sensorType;
		this.distances = distances;
		this.increment = increment;
		this.minDistance = minDistance;
		this.maxDistance = maxDistance;
		this.incrementF = incrementF;
		this.angleOffset = angleOffset;
		this.frame = frame;
	}

	public ObstacleDistance(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 167！");
		}
		messagePayload(messagePayload);
	}

	public ObstacleDistance(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		sensorType = byteArray.getUnsignedInt8(8);
		distances = byteArray.getUnsignedInt16Array(9,72);
		increment = byteArray.getUnsignedInt8(153);
		minDistance = byteArray.getUnsignedInt16(154);
		maxDistance = byteArray.getUnsignedInt16(156);
		incrementF = byteArray.getFloat(158);
		angleOffset = byteArray.getFloat(162);
		frame = byteArray.getUnsignedInt8(166);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putUnsignedInt8(sensorType,8);
		byteArray.putUnsignedInt16Array(distances,9);
		byteArray.putUnsignedInt8(increment,153);
		byteArray.putUnsignedInt16(minDistance,154);
		byteArray.putUnsignedInt16(maxDistance,156);
		byteArray.putFloat(incrementF,158);
		byteArray.putFloat(angleOffset,162);
		byteArray.putUnsignedInt8(frame,166);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ObstacleDistance setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final ObstacleDistance setSensorType(short sensorType) {
		this.sensorType = sensorType;
		return this;
	}

	public final short getSensorType() {
		return sensorType;
	}

	public final ObstacleDistance setDistances(int[] distances) {
		this.distances = distances;
		return this;
	}

	public final int[] getDistances() {
		return distances;
	}

	public final ObstacleDistance setIncrement(short increment) {
		this.increment = increment;
		return this;
	}

	public final short getIncrement() {
		return increment;
	}

	public final ObstacleDistance setMinDistance(int minDistance) {
		this.minDistance = minDistance;
		return this;
	}

	public final int getMinDistance() {
		return minDistance;
	}

	public final ObstacleDistance setMaxDistance(int maxDistance) {
		this.maxDistance = maxDistance;
		return this;
	}

	public final int getMaxDistance() {
		return maxDistance;
	}

	public final ObstacleDistance setIncrementF(float incrementF) {
		this.incrementF = incrementF;
		return this;
	}

	public final float getIncrementF() {
		return incrementF;
	}

	public final ObstacleDistance setAngleOffset(float angleOffset) {
		this.angleOffset = angleOffset;
		return this;
	}

	public final float getAngleOffset() {
		return angleOffset;
	}

	public final ObstacleDistance setFrame(short frame) {
		this.frame = frame;
		return this;
	}

	public final short getFrame() {
		return frame;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ObstacleDistance other = (ObstacleDistance)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.sensorType, other.sensorType)) {
				return false;
			} else if (!Objects.deepEquals(this.distances, other.distances)) {
				return false;
			} else if (!Objects.deepEquals(this.increment, other.increment)) {
				return false;
			} else if (!Objects.deepEquals(this.minDistance, other.minDistance)) {
				return false;
			} else if (!Objects.deepEquals(this.maxDistance, other.maxDistance)) {
				return false;
			} else if (!Objects.deepEquals(this.incrementF, other.incrementF)) {
				return false;
			} else if (!Objects.deepEquals(this.angleOffset, other.angleOffset)) {
				return false;
			} else {
				return Objects.deepEquals(this.frame, other.frame);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.sensorType);
		result = 31 * result + Objects.hashCode(this.distances);
		result = 31 * result + Objects.hashCode(this.increment);
		result = 31 * result + Objects.hashCode(this.minDistance);
		result = 31 * result + Objects.hashCode(this.maxDistance);
		result = 31 * result + Objects.hashCode(this.incrementF);
		result = 31 * result + Objects.hashCode(this.angleOffset);
		result = 31 * result + Objects.hashCode(this.frame);
		return result;
	}

	@Override
	public String toString() {
		return "ObstacleDistance{" +
				"timeUsec=" + timeUsec +
				", sensorType=" + sensorType +
				", distances=" + Arrays.toString(distances) +
				", increment=" + increment +
				", minDistance=" + minDistance +
				", maxDistance=" + maxDistance +
				", incrementF=" + incrementF +
				", angleOffset=" + angleOffset +
				", frame=" + frame +
				'}';
	}
}