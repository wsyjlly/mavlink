package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.math.BigInteger;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 48,
		messagePayloadLength = 21,
		description = "Sets the GPS co-ordinates of the vehicle local origin (0,0,0) position. Vehicle should emit GPS_GLOBAL_ORIGIN irrespective of whether the origin is changed. This enables transform between the local coordinate frame and the global (GPS) coordinate frame, which may be necessary when (for example) indoor and outdoor settings are connected and the MAV should move from in- to outdoor."
)
public class SetGpsGlobalOrigin implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 2, typeSize = 4, streamLength = 4, description = "Latitude (WGS84)", units = "degE7")
	private int latitude;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 3, typeSize = 4, streamLength = 4, description = "Longitude (WGS84)", units = "degE7")
	private int longitude;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 4, typeSize = 4, streamLength = 4, description = "Altitude (MSL). Positive for up.", units = "mm")
	private int altitude;

	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 5, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	private final int messagePayloadLength = 21;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public SetGpsGlobalOrigin(short targetSystem, int latitude, int longitude, int altitude, BigInteger timeUsec) {
		this.targetSystem = targetSystem;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.timeUsec = timeUsec;
	}

	public SetGpsGlobalOrigin(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 21！");
		}
		messagePayload(messagePayload);
	}

	public SetGpsGlobalOrigin(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		latitude = byteArray.getInt32(1);
		longitude = byteArray.getInt32(5);
		altitude = byteArray.getInt32(9);
		timeUsec = byteArray.getUnsignedInt64(13);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putInt32(latitude,1);
		byteArray.putInt32(longitude,5);
		byteArray.putInt32(altitude,9);
		byteArray.putUnsignedInt64(timeUsec,13);
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

	public final SetGpsGlobalOrigin setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
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
			} else if (!Objects.deepEquals(this.altitude, other.altitude)) {
				return false;
			} else {
				return Objects.deepEquals(this.timeUsec, other.timeUsec);
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
		result = 31 * result + Objects.hashCode(this.timeUsec);
		return result;
	}

	@Override
	public String toString() {
		return "SetGpsGlobalOrigin{" +
				"targetSystem=" + targetSystem +
				", latitude=" + latitude +
				", longitude=" + longitude +
				", altitude=" + altitude +
				", timeUsec=" + timeUsec +
				'}';
	}
}