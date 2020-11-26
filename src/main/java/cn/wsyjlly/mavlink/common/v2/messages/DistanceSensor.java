package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavDistanceSensor;
import cn.wsyjlly.mavlink.common.v2.enums.MavSensorOrientation;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.util.Arrays;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 132,
		messagePayloadLength = 39,
		description = "Distance sensor information for an onboard rangefinder."
)
public class DistanceSensor implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp (time since system boot).", units = "ms")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 2, typeSize = 2, streamLength = 2, description = "Minimum distance the sensor can measure", units = "cm")
	private int minDistance;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2, description = "Maximum distance the sensor can measure", units = "cm")
	private int maxDistance;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 4, typeSize = 2, streamLength = 2, description = "Current distance reading", units = "cm")
	private int currentDistance;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1, description = "Type of distance sensor.", enum0 = MavDistanceSensor.class)
	private short type;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 1, description = "Onboard ID of the sensor")
	private short id;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 7, typeSize = 1, streamLength = 1, description = "Direction the sensor faces. downward-facing: ROTATION_PITCH_270, upward-facing: ROTATION_PITCH_90, backward-facing: ROTATION_PITCH_180, forward-facing: ROTATION_NONE, left-facing: ROTATION_YAW_90, right-facing: ROTATION_YAW_270", enum0 = MavSensorOrientation.class)
	private short orientation;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 8, typeSize = 1, streamLength = 1, description = "Measurement variance. Max standard deviation is 6cm. 255 if unknown.", units = "cm^2")
	private short covariance;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4, description = "Horizontal Field of View (angle) where the distance measurement is valid and the field of view is known. Otherwise this is set to 0.", units = "rad")
	private float horizontalFov;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4, description = "Vertical Field of View (angle) where the distance measurement is valid and the field of view is known. Otherwise this is set to 0.", units = "rad")
	private float verticalFov;

	@MavlinkMessageParam(mavlinkType = "float", position = 11, typeSize = 4, streamLength = 16, description = "Quaternion of the sensor orientation in vehicle body frame (w, x, y, z order, zero-rotation is 1, 0, 0, 0). Zero-rotation is along the vehicle body x-axis. This field is required if the orientation is set to MAV_SENSOR_ROTATION_CUSTOM. Set it to 0 if invalid.'")
	private float[] quaternion = new float[4];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 12, typeSize = 1, streamLength = 1, description = "Signal quality of the sensor. Specific to each sensor type, representing the relation of the signal strength with the target reflectivity, distance, size or aspect, but normalised as a percentage. 0 = unknown/unset signal quality, 1 = invalid signal, 100 = perfect signal.", units = "%")
	private short signalQuality;

	private final int messagePayloadLength = 39;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public DistanceSensor(long timeBootMs, int minDistance, int maxDistance, int currentDistance, short type, short id, short orientation, short covariance, float horizontalFov, float verticalFov, float[] quaternion, short signalQuality) {
		this.timeBootMs = timeBootMs;
		this.minDistance = minDistance;
		this.maxDistance = maxDistance;
		this.currentDistance = currentDistance;
		this.type = type;
		this.id = id;
		this.orientation = orientation;
		this.covariance = covariance;
		this.horizontalFov = horizontalFov;
		this.verticalFov = verticalFov;
		this.quaternion = quaternion;
		this.signalQuality = signalQuality;
	}

	public DistanceSensor(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 39！");
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
		horizontalFov = byteArray.getFloat(14);
		verticalFov = byteArray.getFloat(18);
		quaternion = byteArray.getFloatArray(22,4);
		signalQuality = byteArray.getUnsignedInt8(38);
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
		byteArray.putFloat(horizontalFov,14);
		byteArray.putFloat(verticalFov,18);
		byteArray.putFloatArray(quaternion,22);
		byteArray.putUnsignedInt8(signalQuality,38);
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

	public final DistanceSensor setHorizontalFov(float horizontalFov) {
		this.horizontalFov = horizontalFov;
		return this;
	}

	public final float getHorizontalFov() {
		return horizontalFov;
	}

	public final DistanceSensor setVerticalFov(float verticalFov) {
		this.verticalFov = verticalFov;
		return this;
	}

	public final float getVerticalFov() {
		return verticalFov;
	}

	public final DistanceSensor setQuaternion(float[] quaternion) {
		this.quaternion = quaternion;
		return this;
	}

	public final float[] getQuaternion() {
		return quaternion;
	}

	public final DistanceSensor setSignalQuality(short signalQuality) {
		this.signalQuality = signalQuality;
		return this;
	}

	public final short getSignalQuality() {
		return signalQuality;
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
			} else if (!Objects.deepEquals(this.covariance, other.covariance)) {
				return false;
			} else if (!Objects.deepEquals(this.horizontalFov, other.horizontalFov)) {
				return false;
			} else if (!Objects.deepEquals(this.verticalFov, other.verticalFov)) {
				return false;
			} else if (!Objects.deepEquals(this.quaternion, other.quaternion)) {
				return false;
			} else {
				return Objects.deepEquals(this.signalQuality, other.signalQuality);
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
		result = 31 * result + Objects.hashCode(this.horizontalFov);
		result = 31 * result + Objects.hashCode(this.verticalFov);
		result = 31 * result + Objects.hashCode(this.quaternion);
		result = 31 * result + Objects.hashCode(this.signalQuality);
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
				", horizontalFov=" + horizontalFov +
				", verticalFov=" + verticalFov +
				", quaternion=" + Arrays.toString(quaternion) +
				", signalQuality=" + signalQuality +
				'}';
	}
}