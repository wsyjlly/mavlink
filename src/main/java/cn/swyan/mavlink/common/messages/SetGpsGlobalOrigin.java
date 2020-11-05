package cn.swyan.mavlink.common.messages;

import cn.swyan.mavlink.annotation.MavlinkMessage;
import cn.swyan.mavlink.annotation.MavlinkMessageParam;
import cn.swyan.mavlink.common.Message;
import cn.swyan.mavlink.protocol.ByteArray;
import cn.swyan.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 **********************************/

@MavlinkMessage(
		id = 48,
		messagePayloadLength = 13,
		description = "As local waypoints exist, the global MISSION reference allows to transform between the local coordinate frame and the global (GPS) coordinate frame. This can be necessary when e.g. in- and outdoor settings are connected and the MAV should move from in- to outdoor."
)
public class SetGpsGlobalOrigin implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1)
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 2, typeSize = 4, streamLength = 4)
	private int latitude;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 3, typeSize = 4, streamLength = 4)
	private int longitude;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 4, typeSize = 4, streamLength = 4)
	private int altitude;

	private final int messagePayloadLength = 13;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public SetGpsGlobalOrigin(short targetSystem, int latitude, int longitude, int altitude) {
		this.targetSystem = targetSystem;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
	}

	public SetGpsGlobalOrigin(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 13！");
		}
		messagePayload(messagePayload);
	}

	public SetGpsGlobalOrigin(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.targetSystem = byteArray.getUnsignedInt8(0);
		this.latitude = byteArray.getInt32(1);
		this.longitude = byteArray.getInt32(5);
		this.altitude = byteArray.getInt32(9);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final SetGpsGlobalOrigin setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final SetGpsGlobalOrigin setLatitude(int latitude) {
		this.latitude = latitude;
		return this;
	}

	public final int getLatitude() {
		return latitude;
	}

	public final SetGpsGlobalOrigin setLongitude(int longitude) {
		this.longitude = longitude;
		return this;
	}

	public final int getLongitude() {
		return longitude;
	}

	public final SetGpsGlobalOrigin setAltitude(int altitude) {
		this.altitude = altitude;
		return this;
	}

	public final int getAltitude() {
		return altitude;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			SetGpsGlobalOrigin other = (SetGpsGlobalOrigin)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.latitude, other.latitude)) {
				return false;
			} else if (!Objects.deepEquals(this.longitude, other.longitude)) {
				return false;
			} else {
				return Objects.deepEquals(this.altitude, other.altitude);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.targetSystem);
		result = 31 * result + Objects.hashCode(this.latitude);
		result = 31 * result + Objects.hashCode(this.longitude);
		result = 31 * result + Objects.hashCode(this.altitude);
		return result;
	}

	@Override
	public String toString() {
		return "SetGpsGlobalOrigin{" +
				"targetSystem=" + targetSystem +
				", latitude=" + latitude +
				", longitude=" + longitude +
				", altitude=" + altitude +
				'}';
	}
}