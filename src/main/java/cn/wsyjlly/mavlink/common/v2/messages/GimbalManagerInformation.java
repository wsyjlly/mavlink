package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.GimbalManagerCapFlags;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 280,
		messagePayloadLength = 33,
		description = "Information about a high level gimbal manager. This message should be requested by a ground station using MAV_CMD_REQUEST_MESSAGE."
)
public class GimbalManagerInformation implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp (time since system boot).", units = "ms")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 2, typeSize = 4, streamLength = 4, description = "Bitmap of gimbal capability flags.", enum0 = GimbalManagerCapFlags.class)
	private long capFlags;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Gimbal device ID that this gimbal manager is responsible for.")
	private short gimbalDeviceId;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "Minimum hardware roll angle (positive: rolling to the right, negative: rolling to the left)", units = "rad")
	private float rollMin;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Maximum hardware roll angle (positive: rolling to the right, negative: rolling to the left)", units = "rad")
	private float rollMax;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Minimum pitch angle (positive: up, negative: down)", units = "rad")
	private float pitchMin;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "Maximum pitch angle (positive: up, negative: down)", units = "rad")
	private float pitchMax;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "Minimum yaw angle (positive: to the right, negative: to the left)", units = "rad")
	private float yawMin;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4, description = "Maximum yaw angle (positive: to the right, negative: to the left)", units = "rad")
	private float yawMax;

	private final int messagePayloadLength = 33;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public GimbalManagerInformation(long timeBootMs, long capFlags, short gimbalDeviceId, float rollMin, float rollMax, float pitchMin, float pitchMax, float yawMin, float yawMax) {
		this.timeBootMs = timeBootMs;
		this.capFlags = capFlags;
		this.gimbalDeviceId = gimbalDeviceId;
		this.rollMin = rollMin;
		this.rollMax = rollMax;
		this.pitchMin = pitchMin;
		this.pitchMax = pitchMax;
		this.yawMin = yawMin;
		this.yawMax = yawMax;
	}

	public GimbalManagerInformation(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 33！");
		}
		messagePayload(messagePayload);
	}

	public GimbalManagerInformation(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeBootMs = byteArray.getUnsignedInt32(0);
		capFlags = byteArray.getUnsignedInt32(4);
		gimbalDeviceId = byteArray.getUnsignedInt8(8);
		rollMin = byteArray.getFloat(9);
		rollMax = byteArray.getFloat(13);
		pitchMin = byteArray.getFloat(17);
		pitchMax = byteArray.getFloat(21);
		yawMin = byteArray.getFloat(25);
		yawMax = byteArray.getFloat(29);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeBootMs,0);
		byteArray.putUnsignedInt32(capFlags,4);
		byteArray.putUnsignedInt8(gimbalDeviceId,8);
		byteArray.putFloat(rollMin,9);
		byteArray.putFloat(rollMax,13);
		byteArray.putFloat(pitchMin,17);
		byteArray.putFloat(pitchMax,21);
		byteArray.putFloat(yawMin,25);
		byteArray.putFloat(yawMax,29);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final GimbalManagerInformation setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final GimbalManagerInformation setCapFlags(long capFlags) {
		this.capFlags = capFlags;
		return this;
	}

	public final long getCapFlags() {
		return capFlags;
	}

	public final GimbalManagerInformation setGimbalDeviceId(short gimbalDeviceId) {
		this.gimbalDeviceId = gimbalDeviceId;
		return this;
	}

	public final short getGimbalDeviceId() {
		return gimbalDeviceId;
	}

	public final GimbalManagerInformation setRollMin(float rollMin) {
		this.rollMin = rollMin;
		return this;
	}

	public final float getRollMin() {
		return rollMin;
	}

	public final GimbalManagerInformation setRollMax(float rollMax) {
		this.rollMax = rollMax;
		return this;
	}

	public final float getRollMax() {
		return rollMax;
	}

	public final GimbalManagerInformation setPitchMin(float pitchMin) {
		this.pitchMin = pitchMin;
		return this;
	}

	public final float getPitchMin() {
		return pitchMin;
	}

	public final GimbalManagerInformation setPitchMax(float pitchMax) {
		this.pitchMax = pitchMax;
		return this;
	}

	public final float getPitchMax() {
		return pitchMax;
	}

	public final GimbalManagerInformation setYawMin(float yawMin) {
		this.yawMin = yawMin;
		return this;
	}

	public final float getYawMin() {
		return yawMin;
	}

	public final GimbalManagerInformation setYawMax(float yawMax) {
		this.yawMax = yawMax;
		return this;
	}

	public final float getYawMax() {
		return yawMax;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			GimbalManagerInformation other = (GimbalManagerInformation)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.capFlags, other.capFlags)) {
				return false;
			} else if (!Objects.deepEquals(this.gimbalDeviceId, other.gimbalDeviceId)) {
				return false;
			} else if (!Objects.deepEquals(this.rollMin, other.rollMin)) {
				return false;
			} else if (!Objects.deepEquals(this.rollMax, other.rollMax)) {
				return false;
			} else if (!Objects.deepEquals(this.pitchMin, other.pitchMin)) {
				return false;
			} else if (!Objects.deepEquals(this.pitchMax, other.pitchMax)) {
				return false;
			} else if (!Objects.deepEquals(this.yawMin, other.yawMin)) {
				return false;
			} else {
				return Objects.deepEquals(this.yawMax, other.yawMax);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeBootMs);
		result = 31 * result + Objects.hashCode(this.capFlags);
		result = 31 * result + Objects.hashCode(this.gimbalDeviceId);
		result = 31 * result + Objects.hashCode(this.rollMin);
		result = 31 * result + Objects.hashCode(this.rollMax);
		result = 31 * result + Objects.hashCode(this.pitchMin);
		result = 31 * result + Objects.hashCode(this.pitchMax);
		result = 31 * result + Objects.hashCode(this.yawMin);
		result = 31 * result + Objects.hashCode(this.yawMax);
		return result;
	}

	@Override
	public String toString() {
		return "GimbalManagerInformation{" +
				"timeBootMs=" + timeBootMs +
				", capFlags=" + capFlags +
				", gimbalDeviceId=" + gimbalDeviceId +
				", rollMin=" + rollMin +
				", rollMax=" + rollMax +
				", pitchMin=" + pitchMin +
				", pitchMax=" + pitchMax +
				", yawMin=" + yawMin +
				", yawMax=" + yawMax +
				'}';
	}
}