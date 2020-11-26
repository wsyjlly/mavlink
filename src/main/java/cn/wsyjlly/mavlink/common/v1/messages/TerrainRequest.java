package cn.wsyjlly.mavlink.common.v1.messages;

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
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkMessage(
		id = 133,
		messagePayloadLength = 18,
		description = "Request for terrain data and terrain status"
)
public class TerrainRequest implements Message {
	@MavlinkMessageParam(mavlinkType = "int32_t", position = 1, typeSize = 4, streamLength = 4, description = "Latitude of SW corner of first grid (degrees *10^7)")
	private int lat;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 2, typeSize = 4, streamLength = 4, description = "Longitude of SW corner of first grid (in degrees *10^7)")
	private int lon;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2, description = "Grid spacing in meters")
	private int gridSpacing;

	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 4, typeSize = 8, streamLength = 8, description = "Bitmask of requested 4x4 grids (row major 8x7 array of grids, 56 bits)")
	private BigInteger mask;

	private final int messagePayloadLength = 18;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public TerrainRequest(int lat, int lon, int gridSpacing, BigInteger mask) {
		this.lat = lat;
		this.lon = lon;
		this.gridSpacing = gridSpacing;
		this.mask = mask;
	}

	public TerrainRequest(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 18！");
		}
		messagePayload(messagePayload);
	}

	public TerrainRequest(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		lat = byteArray.getInt32(0);
		lon = byteArray.getInt32(4);
		gridSpacing = byteArray.getUnsignedInt16(8);
		mask = byteArray.getUnsignedInt64(10);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putInt32(lat,0);
		byteArray.putInt32(lon,4);
		byteArray.putUnsignedInt16(gridSpacing,8);
		byteArray.putUnsignedInt64(mask,10);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final TerrainRequest setLat(int lat) {
		this.lat = lat;
		return this;
	}

	public final int getLat() {
		return lat;
	}

	public final TerrainRequest setLon(int lon) {
		this.lon = lon;
		return this;
	}

	public final int getLon() {
		return lon;
	}

	public final TerrainRequest setGridSpacing(int gridSpacing) {
		this.gridSpacing = gridSpacing;
		return this;
	}

	public final int getGridSpacing() {
		return gridSpacing;
	}

	public final TerrainRequest setMask(BigInteger mask) {
		this.mask = mask;
		return this;
	}

	public final BigInteger getMask() {
		return mask;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			TerrainRequest other = (TerrainRequest)o;
			if (!Objects.deepEquals(this.lat, other.lat)) {
				return false;
			} else if (!Objects.deepEquals(this.lon, other.lon)) {
				return false;
			} else if (!Objects.deepEquals(this.gridSpacing, other.gridSpacing)) {
				return false;
			} else {
				return Objects.deepEquals(this.mask, other.mask);
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
		result = 31 * result + Objects.hashCode(this.mask);
		return result;
	}

	@Override
	public String toString() {
		return "TerrainRequest{" +
				"lat=" + lat +
				", lon=" + lon +
				", gridSpacing=" + gridSpacing +
				", mask=" + mask +
				'}';
	}
}