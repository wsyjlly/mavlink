package cn.wsyjlly.mavlink.common.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.09 - 03:37
 **********************************/

@MavlinkMessage(
		id = 136,
		messagePayloadLength = 22,
		description = "Response from a TERRAIN_CHECK request"
)
public class TerrainReport implements Message {
	@MavlinkMessageParam(mavlinkType = "int32_t", position = 1, typeSize = 4, streamLength = 4)
	private int lat;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 2, typeSize = 4, streamLength = 4)
	private int lon;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2)
	private int spacing;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4)
	private float terrainHeight;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4)
	private float currentHeight;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 6, typeSize = 2, streamLength = 2)
	private int pending;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 7, typeSize = 2, streamLength = 2)
	private int loaded;

	private final int messagePayloadLength = 22;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public TerrainReport(int lat, int lon, int spacing, float terrainHeight, float currentHeight, int pending, int loaded) {
		this.lat = lat;
		this.lon = lon;
		this.spacing = spacing;
		this.terrainHeight = terrainHeight;
		this.currentHeight = currentHeight;
		this.pending = pending;
		this.loaded = loaded;
	}

	public TerrainReport(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 22！");
		}
		messagePayload(messagePayload);
	}

	public TerrainReport(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.lat = byteArray.getInt32(0);
		this.lon = byteArray.getInt32(4);
		this.spacing = byteArray.getUnsignedInt16(8);
		this.terrainHeight = byteArray.getFloat(10);
		this.currentHeight = byteArray.getFloat(14);
		this.pending = byteArray.getUnsignedInt16(18);
		this.loaded = byteArray.getUnsignedInt16(20);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final TerrainReport setLat(int lat) {
		this.lat = lat;
		return this;
	}

	public final int getLat() {
		return lat;
	}

	public final TerrainReport setLon(int lon) {
		this.lon = lon;
		return this;
	}

	public final int getLon() {
		return lon;
	}

	public final TerrainReport setSpacing(int spacing) {
		this.spacing = spacing;
		return this;
	}

	public final int getSpacing() {
		return spacing;
	}

	public final TerrainReport setTerrainHeight(float terrainHeight) {
		this.terrainHeight = terrainHeight;
		return this;
	}

	public final float getTerrainHeight() {
		return terrainHeight;
	}

	public final TerrainReport setCurrentHeight(float currentHeight) {
		this.currentHeight = currentHeight;
		return this;
	}

	public final float getCurrentHeight() {
		return currentHeight;
	}

	public final TerrainReport setPending(int pending) {
		this.pending = pending;
		return this;
	}

	public final int getPending() {
		return pending;
	}

	public final TerrainReport setLoaded(int loaded) {
		this.loaded = loaded;
		return this;
	}

	public final int getLoaded() {
		return loaded;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			TerrainReport other = (TerrainReport)o;
			if (!Objects.deepEquals(this.lat, other.lat)) {
				return false;
			} else if (!Objects.deepEquals(this.lon, other.lon)) {
				return false;
			} else if (!Objects.deepEquals(this.spacing, other.spacing)) {
				return false;
			} else if (!Objects.deepEquals(this.terrainHeight, other.terrainHeight)) {
				return false;
			} else if (!Objects.deepEquals(this.currentHeight, other.currentHeight)) {
				return false;
			} else if (!Objects.deepEquals(this.pending, other.pending)) {
				return false;
			} else {
				return Objects.deepEquals(this.loaded, other.loaded);
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
		result = 31 * result + Objects.hashCode(this.spacing);
		result = 31 * result + Objects.hashCode(this.terrainHeight);
		result = 31 * result + Objects.hashCode(this.currentHeight);
		result = 31 * result + Objects.hashCode(this.pending);
		result = 31 * result + Objects.hashCode(this.loaded);
		return result;
	}

	@Override
	public String toString() {
		return "TerrainReport{" +
				"lat=" + lat +
				", lon=" + lon +
				", spacing=" + spacing +
				", terrainHeight=" + terrainHeight +
				", currentHeight=" + currentHeight +
				", pending=" + pending +
				", loaded=" + loaded +
				'}';
	}
}