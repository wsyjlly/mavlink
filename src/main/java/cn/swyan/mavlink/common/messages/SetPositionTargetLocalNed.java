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
		id = 84,
		messagePayloadLength = 53,
		description = "Set vehicle position, velocity and acceleration setpoint in local frame."
)
public class SetPositionTargetLocalNed implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4)
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1)
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1)
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, enum0 = MavFrame.class)
	private short coordinateFrame;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 5, typeSize = 2, streamLength = 2)
	private int typeMask;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4)
	private float x;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4)
	private float y;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4)
	private float z;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4)
	private float vx;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4)
	private float vy;

	@MavlinkMessageParam(mavlinkType = "float", position = 11, typeSize = 4, streamLength = 4)
	private float vz;

	@MavlinkMessageParam(mavlinkType = "float", position = 12, typeSize = 4, streamLength = 4)
	private float afx;

	@MavlinkMessageParam(mavlinkType = "float", position = 13, typeSize = 4, streamLength = 4)
	private float afy;

	@MavlinkMessageParam(mavlinkType = "float", position = 14, typeSize = 4, streamLength = 4)
	private float afz;

	@MavlinkMessageParam(mavlinkType = "float", position = 15, typeSize = 4, streamLength = 4)
	private float yaw;

	@MavlinkMessageParam(mavlinkType = "float", position = 16, typeSize = 4, streamLength = 4)
	private float yawRate;

	private final int messagePayloadLength = 53;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public SetPositionTargetLocalNed(long timeBootMs, short targetSystem, short targetComponent, short coordinateFrame, int typeMask, float x, float y, float z, float vx, float vy, float vz, float afx, float afy, float afz, float yaw, float yawRate) {
		this.timeBootMs = timeBootMs;
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
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

	public SetPositionTargetLocalNed(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 53！");
		}
		messagePayload(messagePayload);
	}

	public SetPositionTargetLocalNed(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.timeBootMs = byteArray.getUnsignedInt32(0);
		this.targetSystem = byteArray.getUnsignedInt8(4);
		this.targetComponent = byteArray.getUnsignedInt8(5);
		this.coordinateFrame = byteArray.getUnsignedInt8(6);
		this.typeMask = byteArray.getUnsignedInt16(7);
		this.x = byteArray.getFloat(9);
		this.y = byteArray.getFloat(13);
		this.z = byteArray.getFloat(17);
		this.vx = byteArray.getFloat(21);
		this.vy = byteArray.getFloat(25);
		this.vz = byteArray.getFloat(29);
		this.afx = byteArray.getFloat(33);
		this.afy = byteArray.getFloat(37);
		this.afz = byteArray.getFloat(41);
		this.yaw = byteArray.getFloat(45);
		this.yawRate = byteArray.getFloat(49);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final SetPositionTargetLocalNed setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final SetPositionTargetLocalNed setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final SetPositionTargetLocalNed setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final SetPositionTargetLocalNed setCoordinateFrame(short coordinateFrame) {
		this.coordinateFrame = coordinateFrame;
		return this;
	}

	public final short getCoordinateFrame() {
		return coordinateFrame;
	}

	public final SetPositionTargetLocalNed setTypeMask(int typeMask) {
		this.typeMask = typeMask;
		return this;
	}

	public final int getTypeMask() {
		return typeMask;
	}

	public final SetPositionTargetLocalNed setX(float x) {
		this.x = x;
		return this;
	}

	public final float getX() {
		return x;
	}

	public final SetPositionTargetLocalNed setY(float y) {
		this.y = y;
		return this;
	}

	public final float getY() {
		return y;
	}

	public final SetPositionTargetLocalNed setZ(float z) {
		this.z = z;
		return this;
	}

	public final float getZ() {
		return z;
	}

	public final SetPositionTargetLocalNed setVx(float vx) {
		this.vx = vx;
		return this;
	}

	public final float getVx() {
		return vx;
	}

	public final SetPositionTargetLocalNed setVy(float vy) {
		this.vy = vy;
		return this;
	}

	public final float getVy() {
		return vy;
	}

	public final SetPositionTargetLocalNed setVz(float vz) {
		this.vz = vz;
		return this;
	}

	public final float getVz() {
		return vz;
	}

	public final SetPositionTargetLocalNed setAfx(float afx) {
		this.afx = afx;
		return this;
	}

	public final float getAfx() {
		return afx;
	}

	public final SetPositionTargetLocalNed setAfy(float afy) {
		this.afy = afy;
		return this;
	}

	public final float getAfy() {
		return afy;
	}

	public final SetPositionTargetLocalNed setAfz(float afz) {
		this.afz = afz;
		return this;
	}

	public final float getAfz() {
		return afz;
	}

	public final SetPositionTargetLocalNed setYaw(float yaw) {
		this.yaw = yaw;
		return this;
	}

	public final float getYaw() {
		return yaw;
	}

	public final SetPositionTargetLocalNed setYawRate(float yawRate) {
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
			SetPositionTargetLocalNed other = (SetPositionTargetLocalNed)o;
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
		result = 31 * result + Objects.hashCode(this.targetSystem);
		result = 31 * result + Objects.hashCode(this.targetComponent);
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
		return "SetPositionTargetLocalNed{" +
				"timeBootMs=" + timeBootMs +
				", targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
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