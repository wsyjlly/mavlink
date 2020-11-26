package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavFrame;
import cn.wsyjlly.mavlink.common.v2.enums.PositionTargetTypemask;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 87,
		messagePayloadLength = 51,
		description = "Reports the current commanded vehicle position, velocity, and acceleration as specified by the autopilot. This should match the commands sent in SET_POSITION_TARGET_GLOBAL_INT if the vehicle is being controlled this way."
)
public class PositionTargetGlobalInt implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp (time since system boot). The rationale for the timestamp in the setpoint is to allow the system to compensate for the transport delay of the setpoint. This allows the system to compensate processing latency.", units = "ms")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Valid options are: MAV_FRAME_GLOBAL_INT = 5, MAV_FRAME_GLOBAL_RELATIVE_ALT_INT = 6, MAV_FRAME_GLOBAL_TERRAIN_ALT_INT = 11", enum0 = MavFrame.class)
	private short coordinateFrame;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2, description = "Bitmap to indicate which dimensions should be ignored by the vehicle.", enum0 = PositionTargetTypemask.class)
	private int typeMask;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 4, typeSize = 4, streamLength = 4, description = "X Position in WGS84 frame", units = "degE7")
	private int latInt;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 5, typeSize = 4, streamLength = 4, description = "Y Position in WGS84 frame", units = "degE7")
	private int lonInt;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Altitude (MSL, AGL or relative to home altitude, depending on frame)", units = "m")
	private float alt;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "X velocity in NED frame", units = "m/s")
	private float vx;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "Y velocity in NED frame", units = "m/s")
	private float vy;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4, description = "Z velocity in NED frame", units = "m/s")
	private float vz;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4, description = "X acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N", units = "m/s/s")
	private float afx;

	@MavlinkMessageParam(mavlinkType = "float", position = 11, typeSize = 4, streamLength = 4, description = "Y acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N", units = "m/s/s")
	private float afy;

	@MavlinkMessageParam(mavlinkType = "float", position = 12, typeSize = 4, streamLength = 4, description = "Z acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N", units = "m/s/s")
	private float afz;

	@MavlinkMessageParam(mavlinkType = "float", position = 13, typeSize = 4, streamLength = 4, description = "yaw setpoint", units = "rad")
	private float yaw;

	@MavlinkMessageParam(mavlinkType = "float", position = 14, typeSize = 4, streamLength = 4, description = "yaw rate setpoint", units = "rad/s")
	private float yawRate;

	private final int messagePayloadLength = 51;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public PositionTargetGlobalInt(long timeBootMs, short coordinateFrame, int typeMask, int latInt, int lonInt, float alt, float vx, float vy, float vz, float afx, float afy, float afz, float yaw, float yawRate) {
		this.timeBootMs = timeBootMs;
		this.coordinateFrame = coordinateFrame;
		this.typeMask = typeMask;
		this.latInt = latInt;
		this.lonInt = lonInt;
		this.alt = alt;
		this.vx = vx;
		this.vy = vy;
		this.vz = vz;
		this.afx = afx;
		this.afy = afy;
		this.afz = afz;
		this.yaw = yaw;
		this.yawRate = yawRate;
	}

	public PositionTargetGlobalInt(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 51！");
		}
		messagePayload(messagePayload);
	}

	public PositionTargetGlobalInt(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeBootMs = byteArray.getUnsignedInt32(0);
		coordinateFrame = byteArray.getUnsignedInt8(4);
		typeMask = byteArray.getUnsignedInt16(5);
		latInt = byteArray.getInt32(7);
		lonInt = byteArray.getInt32(11);
		alt = byteArray.getFloat(15);
		vx = byteArray.getFloat(19);
		vy = byteArray.getFloat(23);
		vz = byteArray.getFloat(27);
		afx = byteArray.getFloat(31);
		afy = byteArray.getFloat(35);
		afz = byteArray.getFloat(39);
		yaw = byteArray.getFloat(43);
		yawRate = byteArray.getFloat(47);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeBootMs,0);
		byteArray.putUnsignedInt8(coordinateFrame,4);
		byteArray.putUnsignedInt16(typeMask,5);
		byteArray.putInt32(latInt,7);
		byteArray.putInt32(lonInt,11);
		byteArray.putFloat(alt,15);
		byteArray.putFloat(vx,19);
		byteArray.putFloat(vy,23);
		byteArray.putFloat(vz,27);
		byteArray.putFloat(afx,31);
		byteArray.putFloat(afy,35);
		byteArray.putFloat(afz,39);
		byteArray.putFloat(yaw,43);
		byteArray.putFloat(yawRate,47);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final PositionTargetGlobalInt setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final PositionTargetGlobalInt setCoordinateFrame(short coordinateFrame) {
		this.coordinateFrame = coordinateFrame;
		return this;
	}

	public final short getCoordinateFrame() {
		return coordinateFrame;
	}

	public final PositionTargetGlobalInt setTypeMask(int typeMask) {
		this.typeMask = typeMask;
		return this;
	}

	public final int getTypeMask() {
		return typeMask;
	}

	public final PositionTargetGlobalInt setLatInt(int latInt) {
		this.latInt = latInt;
		return this;
	}

	public final int getLatInt() {
		return latInt;
	}

	public final PositionTargetGlobalInt setLonInt(int lonInt) {
		this.lonInt = lonInt;
		return this;
	}

	public final int getLonInt() {
		return lonInt;
	}

	public final PositionTargetGlobalInt setAlt(float alt) {
		this.alt = alt;
		return this;
	}

	public final float getAlt() {
		return alt;
	}

	public final PositionTargetGlobalInt setVx(float vx) {
		this.vx = vx;
		return this;
	}

	public final float getVx() {
		return vx;
	}

	public final PositionTargetGlobalInt setVy(float vy) {
		this.vy = vy;
		return this;
	}

	public final float getVy() {
		return vy;
	}

	public final PositionTargetGlobalInt setVz(float vz) {
		this.vz = vz;
		return this;
	}

	public final float getVz() {
		return vz;
	}

	public final PositionTargetGlobalInt setAfx(float afx) {
		this.afx = afx;
		return this;
	}

	public final float getAfx() {
		return afx;
	}

	public final PositionTargetGlobalInt setAfy(float afy) {
		this.afy = afy;
		return this;
	}

	public final float getAfy() {
		return afy;
	}

	public final PositionTargetGlobalInt setAfz(float afz) {
		this.afz = afz;
		return this;
	}

	public final float getAfz() {
		return afz;
	}

	public final PositionTargetGlobalInt setYaw(float yaw) {
		this.yaw = yaw;
		return this;
	}

	public final float getYaw() {
		return yaw;
	}

	public final PositionTargetGlobalInt setYawRate(float yawRate) {
		this.yawRate = yawRate;
		return this;
	}

	public final float getYawRate() {
		return yawRate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			PositionTargetGlobalInt other = (PositionTargetGlobalInt)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.coordinateFrame, other.coordinateFrame)) {
				return false;
			} else if (!Objects.deepEquals(this.typeMask, other.typeMask)) {
				return false;
			} else if (!Objects.deepEquals(this.latInt, other.latInt)) {
				return false;
			} else if (!Objects.deepEquals(this.lonInt, other.lonInt)) {
				return false;
			} else if (!Objects.deepEquals(this.alt, other.alt)) {
				return false;
			} else if (!Objects.deepEquals(this.vx, other.vx)) {
				return false;
			} else if (!Objects.deepEquals(this.vy, other.vy)) {
				return false;
			} else if (!Objects.deepEquals(this.vz, other.vz)) {
				return false;
			} else if (!Objects.deepEquals(this.afx, other.afx)) {
				return false;
			} else if (!Objects.deepEquals(this.afy, other.afy)) {
				return false;
			} else if (!Objects.deepEquals(this.afz, other.afz)) {
				return false;
			} else if (!Objects.deepEquals(this.yaw, other.yaw)) {
				return false;
			} else {
				return Objects.deepEquals(this.yawRate, other.yawRate);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeBootMs);
		result = 31 * result + Objects.hashCode(this.coordinateFrame);
		result = 31 * result + Objects.hashCode(this.typeMask);
		result = 31 * result + Objects.hashCode(this.latInt);
		result = 31 * result + Objects.hashCode(this.lonInt);
		result = 31 * result + Objects.hashCode(this.alt);
		result = 31 * result + Objects.hashCode(this.vx);
		result = 31 * result + Objects.hashCode(this.vy);
		result = 31 * result + Objects.hashCode(this.vz);
		result = 31 * result + Objects.hashCode(this.afx);
		result = 31 * result + Objects.hashCode(this.afy);
		result = 31 * result + Objects.hashCode(this.afz);
		result = 31 * result + Objects.hashCode(this.yaw);
		result = 31 * result + Objects.hashCode(this.yawRate);
		return result;
	}

	@Override
	public String toString() {
		return "PositionTargetGlobalInt{" +
				"timeBootMs=" + timeBootMs +
				", coordinateFrame=" + coordinateFrame +
				", typeMask=" + typeMask +
				", latInt=" + latInt +
				", lonInt=" + lonInt +
				", alt=" + alt +
				", vx=" + vx +
				", vy=" + vy +
				", vz=" + vz +
				", afx=" + afx +
				", afy=" + afy +
				", afz=" + afz +
				", yaw=" + yaw +
				", yawRate=" + yawRate +
				'}';
	}
}