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
		id = 132,
		messagePayloadLength = 14,
		description = "RTK GPS data. Gives information on the relative baseline calculation the GPS is reporting"
)
public class DistanceSensor implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Time since system boot")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 2, typeSize = 2, streamLength = 2, description = "Minimum distance the sensor can measure in centimeters")
	private int minDistance;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2, description = "Maximum distance the sensor can measure in centimeters")
	private int maxDistance;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 4, typeSize = 2, streamLength = 2, description = "Current distance reading")
	private int currentDistance;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1, description = "Type from MAV_DISTANCE_SENSOR enum.")
	private short type;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 1, description = "Onboard ID of the sensor")
	private short id;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 7, typeSize = 1, streamLength = 1, description = "Direction the sensor faces from FIXME enum.")
	private short orientation;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 8, typeSize = 1, streamLength = 1, description = "Measurement covariance in centimeters, 0 for unknown / invalid readings")
	private short covariance;

	private final int messagePayloadLength = 14;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public DistanceSensor(long timeBootMs, int minDistance, int maxDistance, int currentDistance, short type, short id, short orientation, short covariance) {
		this.timeBootMs = timeBootMs;
		this.minDistance = minDistance;
		this.maxDistance = maxDistance;
		this.currentDistance = currentDistance;
		this.type = type;
		this.id = id;
		this.orientation = orientation;
		this.covariance = covariance;
	}

	public DistanceSensor(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 14！");
		}
		messagePayload(messagePayload);
	}

	public DistanceSensor(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeBootMs = byteArray.getUnsignedInt32(0);
		minDistance = byteArray.getUnsignedInt16(4);
		maxDistance = byteArray.getUnsignedInt16(6);
		currentDistance = byteArray.getUnsignedInt16(8);
		type = byteArray.getUnsignedInt8(10);
		id = byteArray.getUnsignedInt8(11);
		orientation = byteArray.getUnsignedInt8(12);
		covariance = byteArray.getUnsignedInt8(13);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeBootMs,0);
		byteArray.putUnsignedInt16(minDistance,4);
		byteArray.putUnsignedInt16(maxDistance,6);
		byteArray.putUnsignedInt16(currentDistance,8);
		byteArray.putUnsignedInt8(type,10);
		byteArray.putUnsignedInt8(id,11);
		byteArray.putUnsignedInt8(orientation,12);
		byteArray.putUnsignedInt8(covariance,13);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final DistanceSensor setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final DistanceSensor setMinDistance(int minDistance) {
		this.minDistance = minDistance;
		return this;
	}

	public final int getMinDistance() {
		return minDistance;
	}

	public final DistanceSensor setMaxDistance(int maxDistance) {
		this.maxDistance = maxDistance;
		return this;
	}

	public final int getMaxDistance() {
		return maxDistance;
	}

	public final DistanceSensor setCurrentDistance(int currentDistance) {
		this.currentDistance = currentDistance;
		return this;
	}

	public final int getCurrentDistance() {
		return currentDistance;
	}

	public final DistanceSensor setType(short type) {
		this.type = type;
		return this;
	}

	public final short getType() {
		return type;
	}

	public final DistanceSensor setId(short id) {
		this.id = id;
		return this;
	}

	public final short getId() {
		return id;
	}

	public final DistanceSensor setOrientation(short orientation) {
		this.orientation = orientation;
		return this;
	}

	public final short getOrientation() {
		return orientation;
	}

	public final DistanceSensor setCovariance(short covariance) {
		this.covariance = covariance;
		return this;
	}

	public final short getCovariance() {
		return covariance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			DistanceSensor other = (DistanceSensor)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.minDistance, other.minDistance)) {
				return false;
			} else if (!Objects.deepEquals(this.maxDistance, other.maxDistance)) {
				return false;
			} else if (!Objects.deepEquals(this.currentDistance, other.currentDistance)) {
				return false;
			} else if (!Objects.deepEquals(this.type, other.type)) {
				return false;
			} else if (!Objects.deepEquals(this.id, other.id)) {
				return false;
			} else if (!Objects.deepEquals(this.orientation, other.orientation)) {
				return false;
			} else {
				return Objects.deepEquals(this.covariance, other.covariance);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeBootMs);
		result = 31 * result + Objects.hashCode(this.minDistance);
		result = 31 * result + Objects.hashCode(this.maxDistance);
		result = 31 * result + Objects.hashCode(this.currentDistance);
		result = 31 * result + Objects.hashCode(this.type);
		result = 31 * result + Objects.hashCode(this.id);
		result = 31 * result + Objects.hashCode(this.orientation);
		result = 31 * result + Objects.hashCode(this.covariance);
		return result;
	}

	@Override
	public String toString() {
		return "DistanceSensor{" +
				"timeBootMs=" + timeBootMs +
				", minDistance=" + minDistance +
				", maxDistance=" + maxDistance +
				", currentDistance=" + currentDistance +
				", type=" + type +
				", id=" + id +
				", orientation=" + orientation +
				", covariance=" + covariance +
				'}';
	}
}