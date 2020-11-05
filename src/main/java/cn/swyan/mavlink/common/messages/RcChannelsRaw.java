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
		id = 35,
		messagePayloadLength = 22,
		description = "The RAW values of the RC channels received. The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%. Individual receivers/transmitters might violate this specification."
)
public class RcChannelsRaw implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4)
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1)
	private short port;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2)
	private int chan1Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 4, typeSize = 2, streamLength = 2)
	private int chan2Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 5, typeSize = 2, streamLength = 2)
	private int chan3Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 6, typeSize = 2, streamLength = 2)
	private int chan4Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 7, typeSize = 2, streamLength = 2)
	private int chan5Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 8, typeSize = 2, streamLength = 2)
	private int chan6Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 9, typeSize = 2, streamLength = 2)
	private int chan7Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 10, typeSize = 2, streamLength = 2)
	private int chan8Raw;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 11, typeSize = 1, streamLength = 1)
	private short rssi;

	private final int messagePayloadLength = 22;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public RcChannelsRaw(long timeBootMs, short port, int chan1Raw, int chan2Raw, int chan3Raw, int chan4Raw, int chan5Raw, int chan6Raw, int chan7Raw, int chan8Raw, short rssi) {
		this.timeBootMs = timeBootMs;
		this.port = port;
		this.chan1Raw = chan1Raw;
		this.chan2Raw = chan2Raw;
		this.chan3Raw = chan3Raw;
		this.chan4Raw = chan4Raw;
		this.chan5Raw = chan5Raw;
		this.chan6Raw = chan6Raw;
		this.chan7Raw = chan7Raw;
		this.chan8Raw = chan8Raw;
		this.rssi = rssi;
	}

	public RcChannelsRaw(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 22！");
		}
		messagePayload(messagePayload);
	}

	public RcChannelsRaw(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.timeBootMs = byteArray.getUnsignedInt32(0);
		this.port = byteArray.getUnsignedInt8(4);
		this.chan1Raw = byteArray.getUnsignedInt16(5);
		this.chan2Raw = byteArray.getUnsignedInt16(7);
		this.chan3Raw = byteArray.getUnsignedInt16(9);
		this.chan4Raw = byteArray.getUnsignedInt16(11);
		this.chan5Raw = byteArray.getUnsignedInt16(13);
		this.chan6Raw = byteArray.getUnsignedInt16(15);
		this.chan7Raw = byteArray.getUnsignedInt16(17);
		this.chan8Raw = byteArray.getUnsignedInt16(19);
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

	public final RcChannelsRaw setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final RcChannelsRaw setPort(short port) {
		this.port = port;
		return this;
	}

	public final short getPort() {
		return port;
	}

	public final RcChannelsRaw setChan1Raw(int chan1Raw) {
		this.chan1Raw = chan1Raw;
		return this;
	}

	public final int getChan1Raw() {
		return chan1Raw;
	}

	public final RcChannelsRaw setChan2Raw(int chan2Raw) {
		this.chan2Raw = chan2Raw;
		return this;
	}

	public final int getChan2Raw() {
		return chan2Raw;
	}

	public final RcChannelsRaw setChan3Raw(int chan3Raw) {
		this.chan3Raw = chan3Raw;
		return this;
	}

	public final int getChan3Raw() {
		return chan3Raw;
	}

	public final RcChannelsRaw setChan4Raw(int chan4Raw) {
		this.chan4Raw = chan4Raw;
		return this;
	}

	public final int getChan4Raw() {
		return chan4Raw;
	}

	public final RcChannelsRaw setChan5Raw(int chan5Raw) {
		this.chan5Raw = chan5Raw;
		return this;
	}

	public final int getChan5Raw() {
		return chan5Raw;
	}

	public final RcChannelsRaw setChan6Raw(int chan6Raw) {
		this.chan6Raw = chan6Raw;
		return this;
	}

	public final int getChan6Raw() {
		return chan6Raw;
	}

	public final RcChannelsRaw setChan7Raw(int chan7Raw) {
		this.chan7Raw = chan7Raw;
		return this;
	}

	public final int getChan7Raw() {
		return chan7Raw;
	}

	public final RcChannelsRaw setChan8Raw(int chan8Raw) {
		this.chan8Raw = chan8Raw;
		return this;
	}

	public final int getChan8Raw() {
		return chan8Raw;
	}

	public final RcChannelsRaw setRssi(short rssi) {
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
			RcChannelsRaw other = (RcChannelsRaw)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.port, other.port)) {
				return false;
			} else if (!Objects.deepEquals(this.chan1Raw, other.chan1Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan2Raw, other.chan2Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan3Raw, other.chan3Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan4Raw, other.chan4Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan5Raw, other.chan5Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan6Raw, other.chan6Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan7Raw, other.chan7Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan8Raw, other.chan8Raw)) {
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
		result = 31 * result + Objects.hashCode(this.chan1Raw);
		result = 31 * result + Objects.hashCode(this.chan2Raw);
		result = 31 * result + Objects.hashCode(this.chan3Raw);
		result = 31 * result + Objects.hashCode(this.chan4Raw);
		result = 31 * result + Objects.hashCode(this.chan5Raw);
		result = 31 * result + Objects.hashCode(this.chan6Raw);
		result = 31 * result + Objects.hashCode(this.chan7Raw);
		result = 31 * result + Objects.hashCode(this.chan8Raw);
		result = 31 * result + Objects.hashCode(this.rssi);
		return result;
	}

	@Override
	public String toString() {
		return "RcChannelsRaw{" +
				"timeBootMs=" + timeBootMs +
				", port=" + port +
				", chan1Raw=" + chan1Raw +
				", chan2Raw=" + chan2Raw +
				", chan3Raw=" + chan3Raw +
				", chan4Raw=" + chan4Raw +
				", chan5Raw=" + chan5Raw +
				", chan6Raw=" + chan6Raw +
				", chan7Raw=" + chan7Raw +
				", chan8Raw=" + chan8Raw +
				", rssi=" + rssi +
				'}';
	}
}