package cn.wsyjlly.mavlink.common.v1.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkMessage(
		id = 49,
		messagePayloadLength = 12,
		description = "Once the MAV sets a new GPS-Local correspondence, this message announces the origin (0,0,0) position"
)
public class GpsGlobalOrigin implements Message {
	@MavlinkMessageParam(mavlinkType = "int32_t", position = 1, typeSize = 4, streamLength = 4, description = "Latitude (WGS84), in degrees * 1E7")
	private int latitude;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 2, typeSize = 4, streamLength = 4, description = "Longitude (WGS84), in degrees * 1E7")
	private int longitude;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 3, typeSize = 4, streamLength = 4, description = "Altitude (WGS84), in meters * 1000 (positive for up)")
	private int altitude;

	private final int messagePayloadLength = 12;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public GpsGlobalOrigin(int latitude, int longitude, int altitude) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
	}

	public GpsGlobalOrigin(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 12！");
		}
		messagePayload(messagePayload);
	}

	public GpsGlobalOrigin(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		latitude = byteArray.getInt32(0);
		longitude = byteArray.getInt32(4);
		altitude = byteArray.getInt32(8);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putInt32(latitude,0);
		byteArray.putInt32(longitude,4);
		byteArray.putInt32(altitude,8);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final GpsGlobalOrigin setLatitude(int latitude) {
		this.latitude = latitude;
		return this;
	}

	public final int getLatitude() {
		return latitude;
	}

	public final GpsGlobalOrigin setLongitude(int longitude) {
		this.longitude = longitude;
		return this;
	}

	public final int getLongitude() {
		return longitude;
	}

	public final GpsGlobalOrigin setAltitude(int altitude) {
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
			GpsGlobalOrigin other = (GpsGlobalOrigin)o;
			if (!Objects.deepEquals(this.latitude, other.latitude)) {
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
		result = 31 * result + Objects.hashCode(this.latitude);
		result = 31 * result + Objects.hashCode(this.longitude);
		result = 31 * result + Objects.hashCode(this.altitude);
		return result;
	}

	@Override
	public String toString() {
		return "GpsGlobalOrigin{" +
				"latitude=" + latitude +
				", longitude=" + longitude +
				", altitude=" + altitude +
				'}';
	}
}