package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.GimbalDeviceCapFlags;
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
		id = 283,
		messagePayloadLength = 144,
		description = "Information about a low level gimbal. This message should be requested by the gimbal manager or a ground station using MAV_CMD_REQUEST_MESSAGE. The maximum angles and rates are the limits by hardware. However, the limits by software used are likely different/smaller and dependent on mode/settings/etc.."
)
public class GimbalDeviceInformation implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp (time since system boot).", units = "ms")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "char", position = 2, typeSize = 1, streamLength = 32, description = "Name of the gimbal vendor.")
	private String vendorName;

	@MavlinkMessageParam(mavlinkType = "char", position = 3, typeSize = 1, streamLength = 32, description = "Name of the gimbal model.")
	private String modelName;

	@MavlinkMessageParam(mavlinkType = "char", position = 4, typeSize = 1, streamLength = 32, description = "Custom name of the gimbal given to it by the user.")
	private String customName;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 5, typeSize = 4, streamLength = 4, description = "Version of the gimbal firmware, encoded as: (Dev & 0xff) << 24 | (Patch & 0xff) << 16 | (Minor & 0xff) << 8 | (Major & 0xff).")
	private long firmwareVersion;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 6, typeSize = 4, streamLength = 4, description = "Version of the gimbal hardware, encoded as: (Dev & 0xff) << 24 | (Patch & 0xff) << 16 | (Minor & 0xff) << 8 | (Major & 0xff).")
	private long hardwareVersion;

	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 7, typeSize = 8, streamLength = 8, description = "UID of gimbal hardware (0 if unknown).")
	private BigInteger uid;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 8, typeSize = 2, streamLength = 2, description = "Bitmap of gimbal capability flags.", enum0 = GimbalDeviceCapFlags.class)
	private int capFlags;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 9, typeSize = 2, streamLength = 2, description = "Bitmap for use for gimbal-specific capability flags.")
	private int customCapFlags;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4, description = "Minimum hardware roll angle (positive: rolling to the right, negative: rolling to the left)", units = "rad")
	private float rollMin;

	@MavlinkMessageParam(mavlinkType = "float", position = 11, typeSize = 4, streamLength = 4, description = "Maximum hardware roll angle (positive: rolling to the right, negative: rolling to the left)", units = "rad")
	private float rollMax;

	@MavlinkMessageParam(mavlinkType = "float", position = 12, typeSize = 4, streamLength = 4, description = "Minimum hardware pitch angle (positive: up, negative: down)", units = "rad")
	private float pitchMin;

	@MavlinkMessageParam(mavlinkType = "float", position = 13, typeSize = 4, streamLength = 4, description = "Maximum hardware pitch angle (positive: up, negative: down)", units = "rad")
	private float pitchMax;

	@MavlinkMessageParam(mavlinkType = "float", position = 14, typeSize = 4, streamLength = 4, description = "Minimum hardware yaw angle (positive: to the right, negative: to the left)", units = "rad")
	private float yawMin;

	@MavlinkMessageParam(mavlinkType = "float", position = 15, typeSize = 4, streamLength = 4, description = "Maximum hardware yaw angle (positive: to the right, negative: to the left)", units = "rad")
	private float yawMax;

	private final int messagePayloadLength = 144;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public GimbalDeviceInformation(long timeBootMs, String vendorName, String modelName, String customName, long firmwareVersion, long hardwareVersion, BigInteger uid, int capFlags, int customCapFlags, float rollMin, float rollMax, float pitchMin, float pitchMax, float yawMin, float yawMax) {
		this.timeBootMs = timeBootMs;
		this.vendorName = vendorName;
		this.modelName = modelName;
		this.customName = customName;
		this.firmwareVersion = firmwareVersion;
		this.hardwareVersion = hardwareVersion;
		this.uid = uid;
		this.capFlags = capFlags;
		this.customCapFlags = customCapFlags;
		this.rollMin = rollMin;
		this.rollMax = rollMax;
		this.pitchMin = pitchMin;
		this.pitchMax = pitchMax;
		this.yawMin = yawMin;
		this.yawMax = yawMax;
	}

	public GimbalDeviceInformation(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 144！");
		}
		messagePayload(messagePayload);
	}

	public GimbalDeviceInformation(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeBootMs = byteArray.getUnsignedInt32(0);
		vendorName = byteArray.getChars(4,32);
		modelName = byteArray.getChars(36,32);
		customName = byteArray.getChars(68,32);
		firmwareVersion = byteArray.getUnsignedInt32(100);
		hardwareVersion = byteArray.getUnsignedInt32(104);
		uid = byteArray.getUnsignedInt64(108);
		capFlags = byteArray.getUnsignedInt16(116);
		customCapFlags = byteArray.getUnsignedInt16(118);
		rollMin = byteArray.getFloat(120);
		rollMax = byteArray.getFloat(124);
		pitchMin = byteArray.getFloat(128);
		pitchMax = byteArray.getFloat(132);
		yawMin = byteArray.getFloat(136);
		yawMax = byteArray.getFloat(140);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeBootMs,0);
		byteArray.putChars(vendorName,4);
		byteArray.putChars(modelName,36);
		byteArray.putChars(customName,68);
		byteArray.putUnsignedInt32(firmwareVersion,100);
		byteArray.putUnsignedInt32(hardwareVersion,104);
		byteArray.putUnsignedInt64(uid,108);
		byteArray.putUnsignedInt16(capFlags,116);
		byteArray.putUnsignedInt16(customCapFlags,118);
		byteArray.putFloat(rollMin,120);
		byteArray.putFloat(rollMax,124);
		byteArray.putFloat(pitchMin,128);
		byteArray.putFloat(pitchMax,132);
		byteArray.putFloat(yawMin,136);
		byteArray.putFloat(yawMax,140);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final GimbalDeviceInformation setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final GimbalDeviceInformation setVendorName(String vendorName) {
		this.vendorName = vendorName;
		return this;
	}

	public final String getVendorName() {
		return vendorName;
	}

	public final GimbalDeviceInformation setModelName(String modelName) {
		this.modelName = modelName;
		return this;
	}

	public final String getModelName() {
		return modelName;
	}

	public final GimbalDeviceInformation setCustomName(String customName) {
		this.customName = customName;
		return this;
	}

	public final String getCustomName() {
		return customName;
	}

	public final GimbalDeviceInformation setFirmwareVersion(long firmwareVersion) {
		this.firmwareVersion = firmwareVersion;
		return this;
	}

	public final long getFirmwareVersion() {
		return firmwareVersion;
	}

	public final GimbalDeviceInformation setHardwareVersion(long hardwareVersion) {
		this.hardwareVersion = hardwareVersion;
		return this;
	}

	public final long getHardwareVersion() {
		return hardwareVersion;
	}

	public final GimbalDeviceInformation setUid(BigInteger uid) {
		this.uid = uid;
		return this;
	}

	public final BigInteger getUid() {
		return uid;
	}

	public final GimbalDeviceInformation setCapFlags(int capFlags) {
		this.capFlags = capFlags;
		return this;
	}

	public final int getCapFlags() {
		return capFlags;
	}

	public final GimbalDeviceInformation setCustomCapFlags(int customCapFlags) {
		this.customCapFlags = customCapFlags;
		return this;
	}

	public final int getCustomCapFlags() {
		return customCapFlags;
	}

	public final GimbalDeviceInformation setRollMin(float rollMin) {
		this.rollMin = rollMin;
		return this;
	}

	public final float getRollMin() {
		return rollMin;
	}

	public final GimbalDeviceInformation setRollMax(float rollMax) {
		this.rollMax = rollMax;
		return this;
	}

	public final float getRollMax() {
		return rollMax;
	}

	public final GimbalDeviceInformation setPitchMin(float pitchMin) {
		this.pitchMin = pitchMin;
		return this;
	}

	public final float getPitchMin() {
		return pitchMin;
	}

	public final GimbalDeviceInformation setPitchMax(float pitchMax) {
		this.pitchMax = pitchMax;
		return this;
	}

	public final float getPitchMax() {
		return pitchMax;
	}

	public final GimbalDeviceInformation setYawMin(float yawMin) {
		this.yawMin = yawMin;
		return this;
	}

	public final float getYawMin() {
		return yawMin;
	}

	public final GimbalDeviceInformation setYawMax(float yawMax) {
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
			GimbalDeviceInformation other = (GimbalDeviceInformation)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.vendorName, other.vendorName)) {
				return false;
			} else if (!Objects.deepEquals(this.modelName, other.modelName)) {
				return false;
			} else if (!Objects.deepEquals(this.customName, other.customName)) {
				return false;
			} else if (!Objects.deepEquals(this.firmwareVersion, other.firmwareVersion)) {
				return false;
			} else if (!Objects.deepEquals(this.hardwareVersion, other.hardwareVersion)) {
				return false;
			} else if (!Objects.deepEquals(this.uid, other.uid)) {
				return false;
			} else if (!Objects.deepEquals(this.capFlags, other.capFlags)) {
				return false;
			} else if (!Objects.deepEquals(this.customCapFlags, other.customCapFlags)) {
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
		result = 31 * result + Objects.hashCode(this.vendorName);
		result = 31 * result + Objects.hashCode(this.modelName);
		result = 31 * result + Objects.hashCode(this.customName);
		result = 31 * result + Objects.hashCode(this.firmwareVersion);
		result = 31 * result + Objects.hashCode(this.hardwareVersion);
		result = 31 * result + Objects.hashCode(this.uid);
		result = 31 * result + Objects.hashCode(this.capFlags);
		result = 31 * result + Objects.hashCode(this.customCapFlags);
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
		return "GimbalDeviceInformation{" +
				"timeBootMs=" + timeBootMs +
				", vendorName=" + vendorName +
				", modelName=" + modelName +
				", customName=" + customName +
				", firmwareVersion=" + firmwareVersion +
				", hardwareVersion=" + hardwareVersion +
				", uid=" + uid +
				", capFlags=" + capFlags +
				", customCapFlags=" + customCapFlags +
				", rollMin=" + rollMin +
				", rollMax=" + rollMax +
				", pitchMin=" + pitchMin +
				", pitchMax=" + pitchMax +
				", yawMin=" + yawMin +
				", yawMax=" + yawMax +
				'}';
	}
}