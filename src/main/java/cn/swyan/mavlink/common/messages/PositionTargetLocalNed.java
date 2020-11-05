package cn.swyan.mavlink.common.messages;

import cn.swyan.mavlink.annotation.MavlinkMessage;
import cn.swyan.mavlink.annotation.MavlinkMessageParam;
import cn.swyan.mavlink.common.Message;
import cn.swyan.mavlink.common.enums.MavFrame;
import cn.swyan.mavlink.protocol.ByteArray;
import cn.swyan.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 **********************************/

@MavlinkMessage(
		id = 85,
		messagePayloadLength = 51,
		description = "Set vehicle position, velocity and acceleration setpoint in local frame."
)
public class PositionTargetLocalNed implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4)
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, enum0 = MavFrame.class)
	private short coordinateFrame;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2)
	private int typeMask;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4)
	private float x;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4)
	private float y;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4)
	private float z;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4)
	private float vx;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4)
	private float vy;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4)
	private float vz;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4)
	private float afx;

	@MavlinkMessageParam(mavlinkType = "float", position = 11, typeSize = 4, streamLength = 4)
	private float afy;

	@MavlinkMessageParam(mavlinkType = "float", position = 12, typeSize = 4, streamLength = 4)
	private float afz;

	@MavlinkMessageParam(mavlinkType = "float", position = 13, typeSize = 4, streamLength = 4)
	private float yaw;

	@MavlinkMessageParam(mavlinkType = "float", position = 14, typeSize = 4, streamLength = 4)
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
		this.timeBootMs = byteArray.getUnsignedInt32(0);
		this.coordinateFrame = byteArray.getUnsignedInt8(4);
		this.typeMask = byteArray.getUnsignedInt16(5);
		this.x = byteArray.getFloat(7);
		this.y = byteArray.getFloat(11);
		this.z = byteArray.getFloat(15);
		this.vx = byteArray.getFloat(19);
		this.vy = byteArray.getFloat(23);
		this.vz = byteArray.getFloat(27);
		this.afx = byteArray.getFloat(31);
		this.afy = byteArray.getFloat(35);
		this.afz = byteArray.getFloat(39);
		this.yaw = byteArray.getFloat(43);
		this.yawRate = byteArray.getFloat(47);
	}

	@Override
	public byte[] messagePayload() {
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