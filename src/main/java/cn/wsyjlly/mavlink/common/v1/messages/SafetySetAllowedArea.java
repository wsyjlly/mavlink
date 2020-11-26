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
		id = 54,
		messagePayloadLength = 27,
		description = "Set a safety zone (volume), which is defined by two corners of a cube. This message can be used to tell the MAV which setpoints/MISSIONs to accept and which to reject. Safety areas are often enforced by national or competition regulations."
)
public class SafetySetAllowedArea implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Coordinate frame, as defined by MAV_FRAME enum in mavlink_types.h. Can be either global, GPS, right-handed with Z axis up or local, right handed, Z axis down.", enum0 = MavFrame.class)
	private short frame;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "x position 1 / Latitude 1")
	private float p1x;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "y position 1 / Longitude 1")
	private float p1y;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "z position 1 / Altitude 1")
	private float p1z;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "x position 2 / Latitude 2")
	private float p2x;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "y position 2 / Longitude 2")
	private float p2y;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4, description = "z position 2 / Altitude 2")
	private float p2z;

	private final int messagePayloadLength = 27;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public SafetySetAllowedArea(short targetSystem, short targetComponent, short frame, float p1x, float p1y, float p1z, float p2x, float p2y, float p2z) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.frame = frame;
		this.p1x = p1x;
		this.p1y = p1y;
		this.p1z = p1z;
		this.p2x = p2x;
		this.p2y = p2y;
		this.p2z = p2z;
	}

	public SafetySetAllowedArea(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 27！");
		}
		messagePayload(messagePayload);
	}

	public SafetySetAllowedArea(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		frame = byteArray.getUnsignedInt8(2);
		p1x = byteArray.getFloat(3);
		p1y = byteArray.getFloat(7);
		p1z = byteArray.getFloat(11);
		p2x = byteArray.getFloat(15);
		p2y = byteArray.getFloat(19);
		p2z = byteArray.getFloat(23);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putUnsignedInt8(frame,2);
		byteArray.putFloat(p1x,3);
		byteArray.putFloat(p1y,7);
		byteArray.putFloat(p1z,11);
		byteArray.putFloat(p2x,15);
		byteArray.putFloat(p2y,19);
		byteArray.putFloat(p2z,23);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final SafetySetAllowedArea setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final SafetySetAllowedArea setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final SafetySetAllowedArea setFrame(short frame) {
		this.frame = frame;
		return this;
	}

	public final short getFrame() {
		return frame;
	}

	public final SafetySetAllowedArea setP1x(float p1x) {
		this.p1x = p1x;
		return this;
	}

	public final float getP1x() {
		return p1x;
	}

	public final SafetySetAllowedArea setP1y(float p1y) {
		this.p1y = p1y;
		return this;
	}

	public final float getP1y() {
		return p1y;
	}

	public final SafetySetAllowedArea setP1z(float p1z) {
		this.p1z = p1z;
		return this;
	}

	public final float getP1z() {
		return p1z;
	}

	public final SafetySetAllowedArea setP2x(float p2x) {
		this.p2x = p2x;
		return this;
	}

	public final float getP2x() {
		return p2x;
	}

	public final SafetySetAllowedArea setP2y(float p2y) {
		this.p2y = p2y;
		return this;
	}

	public final float getP2y() {
		return p2y;
	}

	public final SafetySetAllowedArea setP2z(float p2z) {
		this.p2z = p2z;
		return this;
	}

	public final float getP2z() {
		return p2z;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			SafetySetAllowedArea other = (SafetySetAllowedArea)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.frame, other.frame)) {
				return false;
			} else if (!Objects.deepEquals(this.p1x, other.p1x)) {
				return false;
			} else if (!Objects.deepEquals(this.p1y, other.p1y)) {
				return false;
			} else if (!Objects.deepEquals(this.p1z, other.p1z)) {
				return false;
			} else if (!Objects.deepEquals(this.p2x, other.p2x)) {
				return false;
			} else if (!Objects.deepEquals(this.p2y, other.p2y)) {
				return false;
			} else {
				return Objects.deepEquals(this.p2z, other.p2z);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.targetSystem);
		result = 31 * result + Objects.hashCode(this.targetComponent);
		result = 31 * result + Objects.hashCode(this.frame);
		result = 31 * result + Objects.hashCode(this.p1x);
		result = 31 * result + Objects.hashCode(this.p1y);
		result = 31 * result + Objects.hashCode(this.p1z);
		result = 31 * result + Objects.hashCode(this.p2x);
		result = 31 * result + Objects.hashCode(this.p2y);
		result = 31 * result + Objects.hashCode(this.p2z);
		return result;
	}

	@Override
	public String toString() {
		return "SafetySetAllowedArea{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", frame=" + frame +
				", p1x=" + p1x +
				", p1y=" + p1y +
				", p1z=" + p1z +
				", p2x=" + p2x +
				", p2y=" + p2y +
				", p2z=" + p2z +
				'}';
	}
}