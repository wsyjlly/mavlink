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
		id = 134,
		messagePayloadLength = 43,
		description = "Terrain data sent from GCS. The lat/lon and grid_spacing must be the same as a lat/lon from a TERRAIN_REQUEST"
)
public class TerrainData implements Message {
	@MavlinkMessageParam(mavlinkType = "int32_t", position = 1, typeSize = 4, streamLength = 4)
	private int lat;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 2, typeSize = 4, streamLength = 4)
	private int lon;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2)
	private int gridSpacing;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1)
	private short gridbit;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 5, typeSize = 2, streamLength = 32)
	private short data;

	private final int messagePayloadLength = 43;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public TerrainData(int lat, int lon, int gridSpacing, short gridbit, short data) {
		this.lat = lat;
		this.lon = lon;
		this.gridSpacing = gridSpacing;
		this.gridbit = gridbit;
		this.data = data;
	}

	public TerrainData(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 43！");
		}
		messagePayload(messagePayload);
	}

	public TerrainData(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.lat = byteArray.getInt32(0);
		this.lon = byteArray.getInt32(4);
		this.gridSpacing = byteArray.getUnsignedInt16(8);
		this.gridbit = byteArray.getUnsignedInt8(10);
		this.data = byteArray.getInt16(11);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final TerrainData setLat(int lat) {
		this.lat = lat;
		return this;
	}

	public final int getLat() {
		return lat;
	}

	public final TerrainData setLon(int lon) {
		this.lon = lon;
		return this;
	}

	public final int getLon() {
		return lon;
	}

	public final TerrainData setGridSpacing(int gridSpacing) {
		this.gridSpacing = gridSpacing;
		return this;
	}

	public final int getGridSpacing() {
		return gridSpacing;
	}

	public final TerrainData setGridbit(short gridbit) {
		this.gridbit = gridbit;
		return this;
	}

	public final short getGridbit() {
		return gridbit;
	}

	public final TerrainData setData(short data) {
		this.data = data;
		return this;
	}

	public final short getData() {
		return data;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			TerrainData other = (TerrainData)o;
			if (!Objects.deepEquals(this.lat, other.lat)) {
				return false;
			} else if (!Objects.deepEquals(this.lon, other.lon)) {
				return false;
			} else if (!Objects.deepEquals(this.gridSpacing, other.gridSpacing)) {
				return false;
			} else if (!Objects.deepEquals(this.gridbit, other.gridbit)) {
				return false;
			} else {
				return Objects.deepEquals(this.data, other.data);
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
		result = 31 * result + Objects.hashCode(this.gridSpacing);
		result = 31 * result + Objects.hashCode(this.gridbit);
		result = 31 * result + Objects.hashCode(this.data);
		return result;
	}

	@Override
	public String toString() {
		return "TerrainData{" +
				"lat=" + lat +
				", lon=" + lon +
				", gridSpacing=" + gridSpacing +
				", gridbit=" + gridbit +
				", data=" + data +
				'}';
	}
}