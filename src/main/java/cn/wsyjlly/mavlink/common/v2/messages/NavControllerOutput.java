package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 62,
		messagePayloadLength = 26,
		description = "The state of the fixed wing navigation and position controller."
)
public class NavControllerOutput implements Message {
	@MavlinkMessageParam(mavlinkType = "float", position = 1, typeSize = 4, streamLength = 4, description = "Current desired roll", units = "deg")
	private float navRoll;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4, description = "Current desired pitch", units = "deg")
	private float navPitch;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 3, typeSize = 2, streamLength = 2, description = "Current desired heading", units = "deg")
	private short navBearing;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 4, typeSize = 2, streamLength = 2, description = "Bearing to current waypoint/target", units = "deg")
	private short targetBearing;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 5, typeSize = 2, streamLength = 2, description = "Distance to active waypoint", units = "m")
	private int wpDist;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Current altitude error", units = "m")
	private float altError;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "Current airspeed error", units = "m/s")
	private float aspdError;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "Current crosstrack error on x-y plane", units = "m")
	private float xtrackError;

	private final int messagePayloadLength = 26;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public NavControllerOutput(float navRoll, float navPitch, short navBearing, short targetBearing, int wpDist, float altError, float aspdError, float xtrackError) {
		this.navRoll = navRoll;
		this.navPitch = navPitch;
		this.navBearing = navBearing;
		this.targetBearing = targetBearing;
		this.wpDist = wpDist;
		this.altError = altError;
		this.aspdError = aspdError;
		this.xtrackError = xtrackError;
	}

	public NavControllerOutput(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 26！");
		}
		messagePayload(messagePayload);
	}

	public NavControllerOutput(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		navRoll = byteArray.getFloat(0);
		navPitch = byteArray.getFloat(4);
		navBearing = byteArray.getInt16(8);
		targetBearing = byteArray.getInt16(10);
		wpDist = byteArray.getUnsignedInt16(12);
		altError = byteArray.getFloat(14);
		aspdError = byteArray.getFloat(18);
		xtrackError = byteArray.getFloat(22);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putFloat(navRoll,0);
		byteArray.putFloat(navPitch,4);
		byteArray.putInt16(navBearing,8);
		byteArray.putInt16(targetBearing,10);
		byteArray.putUnsignedInt16(wpDist,12);
		byteArray.putFloat(altError,14);
		byteArray.putFloat(aspdError,18);
		byteArray.putFloat(xtrackError,22);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final NavControllerOutput setNavRoll(float navRoll) {
		this.navRoll = navRoll;
		return this;
	}

	public final float getNavRoll() {
		return navRoll;
	}

	public final NavControllerOutput setNavPitch(float navPitch) {
		this.navPitch = navPitch;
		return this;
	}

	public final float getNavPitch() {
		return navPitch;
	}

	public final NavControllerOutput setNavBearing(short navBearing) {
		this.navBearing = navBearing;
		return this;
	}

	public final short getNavBearing() {
		return navBearing;
	}

	public final NavControllerOutput setTargetBearing(short targetBearing) {
		this.targetBearing = targetBearing;
		return this;
	}

	public final short getTargetBearing() {
		return targetBearing;
	}

	public final NavControllerOutput setWpDist(int wpDist) {
		this.wpDist = wpDist;
		return this;
	}

	public final int getWpDist() {
		return wpDist;
	}

	public final NavControllerOutput setAltError(float altError) {
		this.altError = altError;
		return this;
	}

	public final float getAltError() {
		return altError;
	}

	public final NavControllerOutput setAspdError(float aspdError) {
		this.aspdError = aspdError;
		return this;
	}

	public final float getAspdError() {
		return aspdError;
	}

	public final NavControllerOutput setXtrackError(float xtrackError) {
		this.xtrackError = xtrackError;
		return this;
	}

	public final float getXtrackError() {
		return xtrackError;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			NavControllerOutput other = (NavControllerOutput)o;
			if (!Objects.deepEquals(this.navRoll, other.navRoll)) {
				return false;
			} else if (!Objects.deepEquals(this.navPitch, other.navPitch)) {
				return false;
			} else if (!Objects.deepEquals(this.navBearing, other.navBearing)) {
				return false;
			} else if (!Objects.deepEquals(this.targetBearing, other.targetBearing)) {
				return false;
			} else if (!Objects.deepEquals(this.wpDist, other.wpDist)) {
				return false;
			} else if (!Objects.deepEquals(this.altError, other.altError)) {
				return false;
			} else if (!Objects.deepEquals(this.aspdError, other.aspdError)) {
				return false;
			} else {
				return Objects.deepEquals(this.xtrackError, other.xtrackError);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.navRoll);
		result = 31 * result + Objects.hashCode(this.navPitch);
		result = 31 * result + Objects.hashCode(this.navBearing);
		result = 31 * result + Objects.hashCode(this.targetBearing);
		result = 31 * result + Objects.hashCode(this.wpDist);
		result = 31 * result + Objects.hashCode(this.altError);
		result = 31 * result + Objects.hashCode(this.aspdError);
		result = 31 * result + Objects.hashCode(this.xtrackError);
		return result;
	}

	@Override
	public String toString() {
		return "NavControllerOutput{" +
				"navRoll=" + navRoll +
				", navPitch=" + navPitch +
				", navBearing=" + navBearing +
				", targetBearing=" + targetBearing +
				", wpDist=" + wpDist +
				", altError=" + altError +
				", aspdError=" + aspdError +
				", xtrackError=" + xtrackError +
				'}';
	}
}