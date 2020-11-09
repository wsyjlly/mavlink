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
		id = 34,
		messagePayloadLength = 22,
		description = "The scaled values of the RC channels received. (-100%) -10000, (0%) 0, (100%) 10000. Channels that are inactive should be set to UINT16_MAX."
)
public class RcChannelsScaled implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4)
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1)
	private short port;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 3, typeSize = 2, streamLength = 2)
	private short chan1Scaled;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 4, typeSize = 2, streamLength = 2)
	private short chan2Scaled;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 5, typeSize = 2, streamLength = 2)
	private short chan3Scaled;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 6, typeSize = 2, streamLength = 2)
	private short chan4Scaled;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 7, typeSize = 2, streamLength = 2)
	private short chan5Scaled;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 8, typeSize = 2, streamLength = 2)
	private short chan6Scaled;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 9, typeSize = 2, streamLength = 2)
	private short chan7Scaled;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 10, typeSize = 2, streamLength = 2)
	private short chan8Scaled;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 11, typeSize = 1, streamLength = 1)
	private short rssi;

	private final int messagePayloadLength = 22;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public RcChannelsScaled(long timeBootMs, short port, short chan1Scaled, short chan2Scaled, short chan3Scaled, short chan4Scaled, short chan5Scaled, short chan6Scaled, short chan7Scaled, short chan8Scaled, short rssi) {
		this.timeBootMs = timeBootMs;
		this.port = port;
		this.chan1Scaled = chan1Scaled;
		this.chan2Scaled = chan2Scaled;
		this.chan3Scaled = chan3Scaled;
		this.chan4Scaled = chan4Scaled;
		this.chan5Scaled = chan5Scaled;
		this.chan6Scaled = chan6Scaled;
		this.chan7Scaled = chan7Scaled;
		this.chan8Scaled = chan8Scaled;
		this.rssi = rssi;
	}

	public RcChannelsScaled(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 22！");
		}
		messagePayload(messagePayload);
	}

	public RcChannelsScaled(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.timeBootMs = byteArray.getUnsignedInt32(0);
		this.port = byteArray.getUnsignedInt8(4);
		this.chan1Scaled = byteArray.getInt16(5);
		this.chan2Scaled = byteArray.getInt16(7);
		this.chan3Scaled = byteArray.getInt16(9);
		this.chan4Scaled = byteArray.getInt16(11);
		this.chan5Scaled = byteArray.getInt16(13);
		this.chan6Scaled = byteArray.getInt16(15);
		this.chan7Scaled = byteArray.getInt16(17);
		this.chan8Scaled = byteArray.getInt16(19);
		this.rssi = byteArray.getUnsignedInt8(21);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final RcChannelsScaled setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final RcChannelsScaled setPort(short port) {
		this.port = port;
		return this;
	}

	public final short getPort() {
		return port;
	}

	public final RcChannelsScaled setChan1Scaled(short chan1Scaled) {
		this.chan1Scaled = chan1Scaled;
		return this;
	}

	public final short getChan1Scaled() {
		return chan1Scaled;
	}

	public final RcChannelsScaled setChan2Scaled(short chan2Scaled) {
		this.chan2Scaled = chan2Scaled;
		return this;
	}

	public final short getChan2Scaled() {
		return chan2Scaled;
	}

	public final RcChannelsScaled setChan3Scaled(short chan3Scaled) {
		this.chan3Scaled = chan3Scaled;
		return this;
	}

	public final short getChan3Scaled() {
		return chan3Scaled;
	}

	public final RcChannelsScaled setChan4Scaled(short chan4Scaled) {
		this.chan4Scaled = chan4Scaled;
		return this;
	}

	public final short getChan4Scaled() {
		return chan4Scaled;
	}

	public final RcChannelsScaled setChan5Scaled(short chan5Scaled) {
		this.chan5Scaled = chan5Scaled;
		return this;
	}

	public final short getChan5Scaled() {
		return chan5Scaled;
	}

	public final RcChannelsScaled setChan6Scaled(short chan6Scaled) {
		this.chan6Scaled = chan6Scaled;
		return this;
	}

	public final short getChan6Scaled() {
		return chan6Scaled;
	}

	public final RcChannelsScaled setChan7Scaled(short chan7Scaled) {
		this.chan7Scaled = chan7Scaled;
		return this;
	}

	public final short getChan7Scaled() {
		return chan7Scaled;
	}

	public final RcChannelsScaled setChan8Scaled(short chan8Scaled) {
		this.chan8Scaled = chan8Scaled;
		return this;
	}

	public final short getChan8Scaled() {
		return chan8Scaled;
	}

	public final RcChannelsScaled setRssi(short rssi) {
		this.rssi = rssi;
		return this;
	}

	public final short getRssi() {
		return rssi;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			RcChannelsScaled other = (RcChannelsScaled)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.port, other.port)) {
				return false;
			} else if (!Objects.deepEquals(this.chan1Scaled, other.chan1Scaled)) {
				return false;
			} else if (!Objects.deepEquals(this.chan2Scaled, other.chan2Scaled)) {
				return false;
			} else if (!Objects.deepEquals(this.chan3Scaled, other.chan3Scaled)) {
				return false;
			} else if (!Objects.deepEquals(this.chan4Scaled, other.chan4Scaled)) {
				return false;
			} else if (!Objects.deepEquals(this.chan5Scaled, other.chan5Scaled)) {
				return false;
			} else if (!Objects.deepEquals(this.chan6Scaled, other.chan6Scaled)) {
				return false;
			} else if (!Objects.deepEquals(this.chan7Scaled, other.chan7Scaled)) {
				return false;
			} else if (!Objects.deepEquals(this.chan8Scaled, other.chan8Scaled)) {
				return false;
			} else {
				return Objects.deepEquals(this.rssi, other.rssi);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeBootMs);
		result = 31 * result + Objects.hashCode(this.port);
		result = 31 * result + Objects.hashCode(this.chan1Scaled);
		result = 31 * result + Objects.hashCode(this.chan2Scaled);
		result = 31 * result + Objects.hashCode(this.chan3Scaled);
		result = 31 * result + Objects.hashCode(this.chan4Scaled);
		result = 31 * result + Objects.hashCode(this.chan5Scaled);
		result = 31 * result + Objects.hashCode(this.chan6Scaled);
		result = 31 * result + Objects.hashCode(this.chan7Scaled);
		result = 31 * result + Objects.hashCode(this.chan8Scaled);
		result = 31 * result + Objects.hashCode(this.rssi);
		return result;
	}

	@Override
	public String toString() {
		return "RcChannelsScaled{" +
				"timeBootMs=" + timeBootMs +
				", port=" + port +
				", chan1Scaled=" + chan1Scaled +
				", chan2Scaled=" + chan2Scaled +
				", chan3Scaled=" + chan3Scaled +
				", chan4Scaled=" + chan4Scaled +
				", chan5Scaled=" + chan5Scaled +
				", chan6Scaled=" + chan6Scaled +
				", chan7Scaled=" + chan7Scaled +
				", chan8Scaled=" + chan8Scaled +
				", rssi=" + rssi +
				'}';
	}
}