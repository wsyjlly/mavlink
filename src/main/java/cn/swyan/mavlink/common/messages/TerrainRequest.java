package cn.swyan.mavlink.common.messages;

import cn.swyan.mavlink.annotation.MavlinkMessage;
import cn.swyan.mavlink.annotation.MavlinkMessageParam;
import cn.swyan.mavlink.common.Message;
import cn.swyan.mavlink.protocol.ByteArray;
import cn.swyan.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.math.BigInteger;
/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 **********************************/

@MavlinkMessage(
		id = 133,
		messagePayloadLength = 18,
		description = "Request for terrain data and terrain status"
)
public class TerrainRequest implements Message {
	@MavlinkMessageParam(mavlinkType = "int32_t", position = 1, typeSize = 4, streamLength = 4)
	private int lat;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 2, typeSize = 4, streamLength = 4)
	private int lon;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2)
	private int gridSpacing;

	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 4, typeSize = 8, streamLength = 8)
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
		this.lat = byteArray.getInt32(0);
		this.lon = byteArray.getInt32(4);
		this.gridSpacing = byteArray.getUnsignedInt16(8);
		this.mask = byteArray.getUnsignedInt64(10);
	}

	@Override
	public byte[] messagePayload() {
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