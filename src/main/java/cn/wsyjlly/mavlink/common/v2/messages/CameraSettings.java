package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.CameraMode;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 260,
		messagePayloadLength = 13,
		description = "Settings of a camera. Can be requested with a MAV_CMD_REQUEST_MESSAGE command."
)
public class CameraSettings implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp (time since system boot).", units = "ms")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Camera mode", enum0 = CameraMode.class)
	private short modeId;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4, description = "Current zoom level (0.0 to 100.0, NaN if not known)")
	private float zoomlevel;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "Current focus level (0.0 to 100.0, NaN if not known)")
	private float focuslevel;

	private final int messagePayloadLength = 13;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public CameraSettings(long timeBootMs, short modeId, float zoomlevel, float focuslevel) {
		this.timeBootMs = timeBootMs;
		this.modeId = modeId;
		this.zoomlevel = zoomlevel;
		this.focuslevel = focuslevel;
	}

	public CameraSettings(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 13！");
		}
		messagePayload(messagePayload);
	}

	public CameraSettings(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeBootMs = byteArray.getUnsignedInt32(0);
		modeId = byteArray.getUnsignedInt8(4);
		zoomlevel = byteArray.getFloat(5);
		focuslevel = byteArray.getFloat(9);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeBootMs,0);
		byteArray.putUnsignedInt8(modeId,4);
		byteArray.putFloat(zoomlevel,5);
		byteArray.putFloat(focuslevel,9);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final CameraSettings setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final CameraSettings setModeId(short modeId) {
		this.modeId = modeId;
		return this;
	}

	public final short getModeId() {
		return modeId;
	}

	public final CameraSettings setZoomlevel(float zoomlevel) {
		this.zoomlevel = zoomlevel;
		return this;
	}

	public final float getZoomlevel() {
		return zoomlevel;
	}

	public final CameraSettings setFocuslevel(float focuslevel) {
		this.focuslevel = focuslevel;
		return this;
	}

	public final float getFocuslevel() {
		return focuslevel;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			CameraSettings other = (CameraSettings)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.modeId, other.modeId)) {
				return false;
			} else if (!Objects.deepEquals(this.zoomlevel, other.zoomlevel)) {
				return false;
			} else {
				return Objects.deepEquals(this.focuslevel, other.focuslevel);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeBootMs);
		result = 31 * result + Objects.hashCode(this.modeId);
		result = 31 * result + Objects.hashCode(this.zoomlevel);
		result = 31 * result + Objects.hashCode(this.focuslevel);
		return result;
	}

	@Override
	public String toString() {
		return "CameraSettings{" +
				"timeBootMs=" + timeBootMs +
				", modeId=" + modeId +
				", zoomlevel=" + zoomlevel +
				", focuslevel=" + focuslevel +
				'}';
	}
}