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
		id = 86,
		messagePayloadLength = 53,
		description = "Sets a desired vehicle position, velocity, and/or acceleration in a global coordinate system (WGS84). Used by an external controller to command the vehicle (manual controller or other system)."
)
public class SetPositionTargetGlobalInt implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp (time since system boot). The rationale for the timestamp in the setpoint is to allow the system to compensate for the transport delay of the setpoint. This allows the system to compensate processing latency.", units = "ms")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "System ID")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Component ID")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "Valid options are: MAV_FRAME_GLOBAL_INT = 5, MAV_FRAME_GLOBAL_RELATIVE_ALT_INT = 6, MAV_FRAME_GLOBAL_TERRAIN_ALT_INT = 11", enum0 = MavFrame.class)
	private short coordinateFrame;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 5, typeSize = 2, streamLength = 2, description = "Bitmap to indicate which dimensions should be ignored by the vehicle.", enum0 = PositionTargetTypemask.class)
	private int typeMask;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 6, typeSize = 4, streamLength = 4, description = "X Position in WGS84 frame", units = "degE7")
	private int latInt;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 7, typeSize = 4, streamLength = 4, description = "Y Position in WGS84 frame", units = "degE7")
	private int lonInt;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "Altitude (MSL, Relative to home, or AGL - depending on frame)", units = "m")
	private float alt;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4, description = "X velocity in NED frame", units = "m/s")
	private float vx;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4, description = "Y velocity in NED frame", units = "m/s")
	private float vy;

	@MavlinkMessageParam(mavlinkType = "float", position = 11, typeSize = 4, streamLength = 4, description = "Z velocity in NED frame", units = "m/s")
	private float vz;

	@MavlinkMessageParam(mavlinkType = "float", position = 12, typeSize = 4, streamLength = 4, description = "X acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N", units = "m/s/s")
	private float afx;

	@MavlinkMessageParam(mavlinkType = "float", position = 13, typeSize = 4, streamLength = 4, description = "Y acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N", units = "m/s/s")
	private float afy;

	@MavlinkMessageParam(mavlinkType = "float", position = 14, typeSize = 4, streamLength = 4, description = "Z acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N", units = "m/s/s")
	private float afz;

	@MavlinkMessageParam(mavlinkType = "float", position = 15, typeSize = 4, streamLength = 4, description = "yaw setpoint", units = "rad")
	private float yaw;

	@MavlinkMessageParam(mavlinkType = "float", position = 16, typeSize = 4, streamLength = 4, description = "yaw rate setpoint", units = "rad/s")
	private float yawRate;

	private final int messagePayloadLength = 53;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public SetPositionTargetGlobalInt(long timeBootMs, short targetSystem, short targetComponent, short coordinateFrame, int typeMask, int latInt, int lonInt, float alt, float vx, float vy, float vz, float afx, float afy, float afz, float yaw, float yawRate) {
		this.timeBootMs = timeBootMs;
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
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

	public SetPositionTargetGlobalInt(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 53！");
		}
		messagePayload(messagePayload);
	}

	public SetPositionTargetGlobalInt(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeBootMs = byteArray.getUnsignedInt32(0);
		targetSystem = byteArray.getUnsignedInt8(4);
		targetComponent = byteArray.getUnsignedInt8(5);
		coordinateFrame = byteArray.getUnsignedInt8(6);
		typeMask = byteArray.getUnsignedInt16(7);
		latInt = byteArray.getInt32(9);
		lonInt = byteArray.getInt32(13);
		alt = byteArray.getFloat(17);
		vx = byteArray.getFloat(21);
		vy = byteArray.getFloat(25);
		vz = byteArray.getFloat(29);
		afx = byteArray.getFloat(33);
		afy = byteArray.getFloat(37);
		afz = byteArray.getFloat(41);
		yaw = byteArray.getFloat(45);
		yawRate = byteArray.getFloat(49);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeBootMs,0);
		byteArray.putUnsignedInt8(targetSystem,4);
		byteArray.putUnsignedInt8(targetComponent,5);
		byteArray.putUnsignedInt8(coordinateFrame,6);
		byteArray.putUnsignedInt16(typeMask,7);
		byteArray.putInt32(latInt,9);
		byteArray.putInt32(lonInt,13);
		byteArray.putFloat(alt,17);
		byteArray.putFloat(vx,21);
		byteArray.putFloat(vy,25);
		byteArray.putFloat(vz,29);
		byteArray.putFloat(afx,33);
		byteArray.putFloat(afy,37);
		byteArray.putFloat(afz,41);
		byteArray.putFloat(yaw,45);
		byteArray.putFloat(yawRate,49);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final SetPositionTargetGlobalInt setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final SetPositionTargetGlobalInt setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final SetPositionTargetGlobalInt setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final SetPositionTargetGlobalInt setCoordinateFrame(short coordinateFrame) {
		this.coordinateFrame = coordinateFrame;
		return this;
	}

	public final short getCoordinateFrame() {
		return coordinateFrame;
	}

	public final SetPositionTargetGlobalInt setTypeMask(int typeMask) {
		this.typeMask = typeMask;
		return this;
	}

	public final int getTypeMask() {
		return typeMask;
	}

	public final SetPositionTargetGlobalInt setLatInt(int latInt) {
		this.latInt = latInt;
		return this;
	}

	public final int getLatInt() {
		return latInt;
	}

	public final SetPositionTargetGlobalInt setLonInt(int lonInt) {
		this.lonInt = lonInt;
		return this;
	}

	public final int getLonInt() {
		return lonInt;
	}

	public final SetPositionTargetGlobalInt setAlt(float alt) {
		this.alt = alt;
		return this;
	}

	public final float getAlt() {
		return alt;
	}

	public final SetPositionTargetGlobalInt setVx(float vx) {
		this.vx = vx;
		return this;
	}

	public final float getVx() {
		return vx;
	}

	public final SetPositionTargetGlobalInt setVy(float vy) {
		this.vy = vy;
		return this;
	}

	public final float getVy() {
		return vy;
	}

	public final SetPositionTargetGlobalInt setVz(float vz) {
		this.vz = vz;
		return this;
	}

	public final float getVz() {
		return vz;
	}

	public final SetPositionTargetGlobalInt setAfx(float afx) {
		this.afx = afx;
		return this;
	}

	public final float getAfx() {
		return afx;
	}

	public final SetPositionTargetGlobalInt setAfy(float afy) {
		this.afy = afy;
		return this;
	}

	public final float getAfy() {
		return afy;
	}

	public final SetPositionTargetGlobalInt setAfz(float afz) {
		this.afz = afz;
		return this;
	}

	public final float getAfz() {
		return afz;
	}

	public final SetPositionTargetGlobalInt setYaw(float yaw) {
		this.yaw = yaw;
		return this;
	}

	public final float getYaw() {
		return yaw;
	}

	public final SetPositionTargetGlobalInt setYawRate(float yawRate) {
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
			SetPositionTargetGlobalInt other = (SetPositionTargetGlobalInt)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
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
		result = 31 * result + Objects.hashCode(this.targetSystem);
		result = 31 * result + Objects.hashCode(this.targetComponent);
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
		return "SetPositionTargetGlobalInt{" +
				"timeBootMs=" + timeBootMs +
				", targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
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