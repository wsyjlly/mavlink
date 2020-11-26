package cn.wsyjlly.mavlink.common.v1.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.util.Arrays;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkMessage(
		id = 134,
		messagePayloadLength = 43,
		description = "Terrain data sent from GCS. The lat/lon and grid_spacing must be the same as a lat/lon from a TERRAIN_REQUEST"
)
public class TerrainData implements Message {
	@MavlinkMessageParam(mavlinkType = "int32_t", position = 1, typeSize = 4, streamLength = 4, description = "Latitude of SW corner of first grid (degrees *10^7)")
	private int lat;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 2, typeSize = 4, streamLength = 4, description = "Longitude of SW corner of first grid (in degrees *10^7)")
	private int lon;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2, description = "Grid spacing in meters")
	private int gridSpacing;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "bit within the terrain request mask")
	private short gridbit;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 5, typeSize = 2, streamLength = 32, description = "Terrain data in meters AMSL")
	private short[] data = new short[16];

	private final int messagePayloadLength = 43;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public TerrainData(int lat, int lon, int gridSpacing, short gridbit, short[] data) {
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
		lat = byteArray.getInt32(0);
		lon = byteArray.getInt32(4);
		gridSpacing = byteArray.getUnsignedInt16(8);
		gridbit = byteArray.getUnsignedInt8(10);
		data = byteArray.getInt16Array(11,16);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putInt32(lat,0);
		byteArray.putInt32(lon,4);
		byteArray.putUnsignedInt16(gridSpacing,8);
		byteArray.putUnsignedInt8(gridbit,10);
		byteArray.putInt16Array(data,11);
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

	public final TerrainData setData(short[] data) {
		this.data = data;
		return this;
	}

	public final short[] getData() {
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
				", data=" + Arrays.toString(data) +
				'}';
	}
}