package cn.wsyjlly.mavlink.common.v1.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v1.enums.MavFrame;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkMessage(
		id = 85,
		messagePayloadLength = 51,
		description = "Set vehicle position, velocity and acceleration setpoint in local frame."
)
public class PositionTargetLocalNed implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp in milliseconds since system boot")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Valid options are: MAV_FRAME_LOCAL_NED = 1, MAV_FRAME_LOCAL_OFFSET_NED = 7, MAV_FRAME_BODY_NED = 8, MAV_FRAME_BODY_OFFSET_NED = 9", enum0 = MavFrame.class)
	private short coordinateFrame;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2, description = "Bitmask to indicate which dimensions should be ignored by the vehicle: a value of 0b0000000000000000 or 0b0000001000000000 indicates that none of the setpoint dimensions should be ignored. If bit 10 is set the floats afx afy afz should be interpreted as force instead of acceleration. Mapping: bit 1: x, bit 2: y, bit 3: z, bit 4: vx, bit 5: vy, bit 6: vz, bit 7: ax, bit 8: ay, bit 9: az, bit 10: is force setpoint, bit 11: yaw, bit 12: yaw rate")
	private int typeMask;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "X Position in NED frame in meters")
	private float x;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Y Position in NED frame in meters")
	private float y;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Z Position in NED frame in meters (note, altitude is negative in NED)")
	private float z;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "X velocity in NED frame in meter / s")
	private float vx;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "Y velocity in NED frame in meter / s")
	private float vy;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4, description = "Z velocity in NED frame in meter / s")
	private float vz;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4, description = "X acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N")
	private float afx;

	@MavlinkMessageParam(mavlinkType = "float", position = 11, typeSize = 4, streamLength = 4, description = "Y acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N")
	private float afy;

	@MavlinkMessageParam(mavlinkType = "float", position = 12, typeSize = 4, streamLength = 4, description = "Z acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N")
	private float afz;

	@MavlinkMessageParam(mavlinkType = "float", position = 13, typeSize = 4, streamLength = 4, description = "yaw setpoint in rad")
	private float yaw;

	@MavlinkMessageParam(mavlinkType = "float", position = 14, typeSize = 4, streamLength = 4, description = "yaw rate setpoint in rad/s")
	private float yawRate;

	private final int messagePayloadLength = 51;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public PositionTargetLocalNed(long timeBootMs, short coordinateFrame, int typeMask, float x, float y, float z, float vx, float vy, float vz, float afx, float afy, float afz, float yaw, float yawRate) {
		this.timeBootMs = timeBootMs;
		this.coordinateFrame = coordinateFrame;
		this.typeMask = typeMask;
		this.x = x;
		this.y = y;
		this.z = z;
		this.vx = vx;
		this.vy = vy;
		this.vz = vz;
		this.afx = afx;
		this.afy = afy;
		this.afz = afz;
		this.yaw = yaw;
		this.yawRate = yawRate;
	}

	public PositionTargetLocalNed(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 51！");
		}
		messagePayload(messagePayload);
	}

	public PositionTargetLocalNed(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeBootMs = byteArray.getUnsignedInt32(0);
		coordinateFrame = byteArray.getUnsignedInt8(4);
		typeMask = byteArray.getUnsignedInt16(5);
		x = byteArray.getFloat(7);
		y = byteArray.getFloat(11);
		z = byteArray.getFloat(15);
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
		byteArray.putFloat(x,7);
		byteArray.putFloat(y,11);
		byteArray.putFloat(z,15);
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

	public final PositionTargetLocalNed setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final PositionTargetLocalNed setCoordinateFrame(short coordinateFrame) {
		this.coordinateFrame = coordinateFrame;
		return this;
	}

	public final short getCoordinateFrame() {
		return coordinateFrame;
	}

	public final PositionTargetLocalNed setTypeMask(int typeMask) {
		this.typeMask = typeMask;
		return this;
	}

	public final int getTypeMask() {
		return typeMask;
	}

	public final PositionTargetLocalNed setX(float x) {
		this.x = x;
		return this;
	}

	public final float getX() {
		return x;
	}

	public final PositionTargetLocalNed setY(float y) {
		this.y = y;
		return this;
	}

	public final float getY() {
		return y;
	}

	public final PositionTargetLocalNed setZ(float z) {
		this.z = z;
		return this;
	}

	public final float getZ() {
		return z;
	}

	public final PositionTargetLocalNed setVx(float vx) {
		this.vx = vx;
		return this;
	}

	public final float getVx() {
		return vx;
	}

	public final PositionTargetLocalNed setVy(float vy) {
		this.vy = vy;
		return this;
	}

	public final float getVy() {
		return vy;
	}

	public final PositionTargetLocalNed setVz(float vz) {
		this.vz = vz;
		return this;
	}

	public final float getVz() {
		return vz;
	}

	public final PositionTargetLocalNed setAfx(float afx) {
		this.afx = afx;
		return this;
	}

	public final float getAfx() {
		return afx;
	}

	public final PositionTargetLocalNed setAfy(float afy) {
		this.afy = afy;
		return this;
	}

	public final float getAfy() {
		return afy;
	}

	public final PositionTargetLocalNed setAfz(float afz) {
		this.afz = afz;
		return this;
	}

	public final float getAfz() {
		return afz;
	}

	public final PositionTargetLocalNed setYaw(float yaw) {
		this.yaw = yaw;
		return this;
	}

	public final float getYaw() {
		return yaw;
	}

	public final PositionTargetLocalNed setYawRate(float yawRate) {
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
			PositionTargetLocalNed other = (PositionTargetLocalNed)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.coordinateFrame, other.coordinateFrame)) {
				return false;
			} else if (!Objects.deepEquals(this.typeMask, other.typeMask)) {
				return false;
			} else if (!Objects.deepEquals(this.x, other.x)) {
				return false;
			} else if (!Objects.deepEquals(this.y, other.y)) {
				return false;
			} else if (!Objects.deepEquals(this.z, other.z)) {
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
		result = 31 * result + Objects.hashCode(this.x);
		result = 31 * result + Objects.hashCode(this.y);
		result = 31 * result + Objects.hashCode(this.z);
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
		return "PositionTargetLocalNed{" +
				"timeBootMs=" + timeBootMs +
				", coordinateFrame=" + coordinateFrame +
				", typeMask=" + typeMask +
				", x=" + x +
				", y=" + y +
				", z=" + z +
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