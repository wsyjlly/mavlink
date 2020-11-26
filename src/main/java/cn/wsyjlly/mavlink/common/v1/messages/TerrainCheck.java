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
		id = 135,
		messagePayloadLength = 8,
		description = "Request that the vehicle report terrain height at the given location. Used by GCS to check if vehicle has all terrain data needed for a mission."
)
public class TerrainCheck implements Message {
	@MavlinkMessageParam(mavlinkType = "int32_t", position = 1, typeSize = 4, streamLength = 4, description = "Latitude (degrees *10^7)")
	private int lat;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 2, typeSize = 4, streamLength = 4, description = "Longitude (degrees *10^7)")
	private int lon;

	private final int messagePayloadLength = 8;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public TerrainCheck(int lat, int lon) {
		this.lat = lat;
		this.lon = lon;
	}

	public TerrainCheck(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 8！");
		}
		messagePayload(messagePayload);
	}

	public TerrainCheck(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		lat = byteArray.getInt32(0);
		lon = byteArray.getInt32(4);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putInt32(lat,0);
		byteArray.putInt32(lon,4);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final TerrainCheck setLat(int lat) {
		this.lat = lat;
		return this;
	}

	public final int getLat() {
		return lat;
	}

	public final TerrainCheck setLon(int lon) {
		this.lon = lon;
		return this;
	}

	public final int getLon() {
		return lon;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			TerrainCheck other = (TerrainCheck)o;
			if (!Objects.deepEquals(this.lat, other.lat)) {
				return false;
			} else {
				return Objects.deepEquals(this.lon, other.lon);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.lat);
		result = 31 * result + Objects.hashCode(this.lon);
		return result;
	}

	@Override
	public String toString() {
		return "TerrainCheck{" +
				"lat=" + lat +
				", lon=" + lon +
				'}';
	}
}