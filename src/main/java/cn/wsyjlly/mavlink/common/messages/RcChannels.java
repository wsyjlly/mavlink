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
		id = 65,
		messagePayloadLength = 42,
		description = "The PPM values of the RC channels received. The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%. Individual receivers/transmitters might violate this specification."
)
public class RcChannels implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4)
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1)
	private short chancount;

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

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 11, typeSize = 2, streamLength = 2)
	private int chan9Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 12, typeSize = 2, streamLength = 2)
	private int chan10Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 13, typeSize = 2, streamLength = 2)
	private int chan11Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 14, typeSize = 2, streamLength = 2)
	private int chan12Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 15, typeSize = 2, streamLength = 2)
	private int chan13Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 16, typeSize = 2, streamLength = 2)
	private int chan14Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 17, typeSize = 2, streamLength = 2)
	private int chan15Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 18, typeSize = 2, streamLength = 2)
	private int chan16Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 19, typeSize = 2, streamLength = 2)
	private int chan17Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 20, typeSize = 2, streamLength = 2)
	private int chan18Raw;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 21, typeSize = 1, streamLength = 1)
	private short rssi;

	private final int messagePayloadLength = 42;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public RcChannels(long timeBootMs, short chancount, int chan1Raw, int chan2Raw, int chan3Raw, int chan4Raw, int chan5Raw, int chan6Raw, int chan7Raw, int chan8Raw, int chan9Raw, int chan10Raw, int chan11Raw, int chan12Raw, int chan13Raw, int chan14Raw, int chan15Raw, int chan16Raw, int chan17Raw, int chan18Raw, short rssi) {
		this.timeBootMs = timeBootMs;
		this.chancount = chancount;
		this.chan1Raw = chan1Raw;
		this.chan2Raw = chan2Raw;
		this.chan3Raw = chan3Raw;
		this.chan4Raw = chan4Raw;
		this.chan5Raw = chan5Raw;
		this.chan6Raw = chan6Raw;
		this.chan7Raw = chan7Raw;
		this.chan8Raw = chan8Raw;
		this.chan9Raw = chan9Raw;
		this.chan10Raw = chan10Raw;
		this.chan11Raw = chan11Raw;
		this.chan12Raw = chan12Raw;
		this.chan13Raw = chan13Raw;
		this.chan14Raw = chan14Raw;
		this.chan15Raw = chan15Raw;
		this.chan16Raw = chan16Raw;
		this.chan17Raw = chan17Raw;
		this.chan18Raw = chan18Raw;
		this.rssi = rssi;
	}

	public RcChannels(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 42！");
		}
		messagePayload(messagePayload);
	}

	public RcChannels(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.timeBootMs = byteArray.getUnsignedInt32(0);
		this.chancount = byteArray.getUnsignedInt8(4);
		this.chan1Raw = byteArray.getUnsignedInt16(5);
		this.chan2Raw = byteArray.getUnsignedInt16(7);
		this.chan3Raw = byteArray.getUnsignedInt16(9);
		this.chan4Raw = byteArray.getUnsignedInt16(11);
		this.chan5Raw = byteArray.getUnsignedInt16(13);
		this.chan6Raw = byteArray.getUnsignedInt16(15);
		this.chan7Raw = byteArray.getUnsignedInt16(17);
		this.chan8Raw = byteArray.getUnsignedInt16(19);
		this.chan9Raw = byteArray.getUnsignedInt16(21);
		this.chan10Raw = byteArray.getUnsignedInt16(23);
		this.chan11Raw = byteArray.getUnsignedInt16(25);
		this.chan12Raw = byteArray.getUnsignedInt16(27);
		this.chan13Raw = byteArray.getUnsignedInt16(29);
		this.chan14Raw = byteArray.getUnsignedInt16(31);
		this.chan15Raw = byteArray.getUnsignedInt16(33);
		this.chan16Raw = byteArray.getUnsignedInt16(35);
		this.chan17Raw = byteArray.getUnsignedInt16(37);
		this.chan18Raw = byteArray.getUnsignedInt16(39);
		this.rssi = byteArray.getUnsignedInt8(41);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final RcChannels setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final RcChannels setChancount(short chancount) {
		this.chancount = chancount;
		return this;
	}

	public final short getChancount() {
		return chancount;
	}

	public final RcChannels setChan1Raw(int chan1Raw) {
		this.chan1Raw = chan1Raw;
		return this;
	}

	public final int getChan1Raw() {
		return chan1Raw;
	}

	public final RcChannels setChan2Raw(int chan2Raw) {
		this.chan2Raw = chan2Raw;
		return this;
	}

	public final int getChan2Raw() {
		return chan2Raw;
	}

	public final RcChannels setChan3Raw(int chan3Raw) {
		this.chan3Raw = chan3Raw;
		return this;
	}

	public final int getChan3Raw() {
		return chan3Raw;
	}

	public final RcChannels setChan4Raw(int chan4Raw) {
		this.chan4Raw = chan4Raw;
		return this;
	}

	public final int getChan4Raw() {
		return chan4Raw;
	}

	public final RcChannels setChan5Raw(int chan5Raw) {
		this.chan5Raw = chan5Raw;
		return this;
	}

	public final int getChan5Raw() {
		return chan5Raw;
	}

	public final RcChannels setChan6Raw(int chan6Raw) {
		this.chan6Raw = chan6Raw;
		return this;
	}

	public final int getChan6Raw() {
		return chan6Raw;
	}

	public final RcChannels setChan7Raw(int chan7Raw) {
		this.chan7Raw = chan7Raw;
		return this;
	}

	public final int getChan7Raw() {
		return chan7Raw;
	}

	public final RcChannels setChan8Raw(int chan8Raw) {
		this.chan8Raw = chan8Raw;
		return this;
	}

	public final int getChan8Raw() {
		return chan8Raw;
	}

	public final RcChannels setChan9Raw(int chan9Raw) {
		this.chan9Raw = chan9Raw;
		return this;
	}

	public final int getChan9Raw() {
		return chan9Raw;
	}

	public final RcChannels setChan10Raw(int chan10Raw) {
		this.chan10Raw = chan10Raw;
		return this;
	}

	public final int getChan10Raw() {
		return chan10Raw;
	}

	public final RcChannels setChan11Raw(int chan11Raw) {
		this.chan11Raw = chan11Raw;
		return this;
	}

	public final int getChan11Raw() {
		return chan11Raw;
	}

	public final RcChannels setChan12Raw(int chan12Raw) {
		this.chan12Raw = chan12Raw;
		return this;
	}

	public final int getChan12Raw() {
		return chan12Raw;
	}

	public final RcChannels setChan13Raw(int chan13Raw) {
		this.chan13Raw = chan13Raw;
		return this;
	}

	public final int getChan13Raw() {
		return chan13Raw;
	}

	public final RcChannels setChan14Raw(int chan14Raw) {
		this.chan14Raw = chan14Raw;
		return this;
	}

	public final int getChan14Raw() {
		return chan14Raw;
	}

	public final RcChannels setChan15Raw(int chan15Raw) {
		this.chan15Raw = chan15Raw;
		return this;
	}

	public final int getChan15Raw() {
		return chan15Raw;
	}

	public final RcChannels setChan16Raw(int chan16Raw) {
		this.chan16Raw = chan16Raw;
		return this;
	}

	public final int getChan16Raw() {
		return chan16Raw;
	}

	public final RcChannels setChan17Raw(int chan17Raw) {
		this.chan17Raw = chan17Raw;
		return this;
	}

	public final int getChan17Raw() {
		return chan17Raw;
	}

	public final RcChannels setChan18Raw(int chan18Raw) {
		this.chan18Raw = chan18Raw;
		return this;
	}

	public final int getChan18Raw() {
		return chan18Raw;
	}

	public final RcChannels setRssi(short rssi) {
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
			RcChannels other = (RcChannels)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.chancount, other.chancount)) {
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
			} else if (!Objects.deepEquals(this.chan9Raw, other.chan9Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan10Raw, other.chan10Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan11Raw, other.chan11Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan12Raw, other.chan12Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan13Raw, other.chan13Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan14Raw, other.chan14Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan15Raw, other.chan15Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan16Raw, other.chan16Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan17Raw, other.chan17Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan18Raw, other.chan18Raw)) {
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
		result = 31 * result + Objects.hashCode(this.chancount);
		result = 31 * result + Objects.hashCode(this.chan1Raw);
		result = 31 * result + Objects.hashCode(this.chan2Raw);
		result = 31 * result + Objects.hashCode(this.chan3Raw);
		result = 31 * result + Objects.hashCode(this.chan4Raw);
		result = 31 * result + Objects.hashCode(this.chan5Raw);
		result = 31 * result + Objects.hashCode(this.chan6Raw);
		result = 31 * result + Objects.hashCode(this.chan7Raw);
		result = 31 * result + Objects.hashCode(this.chan8Raw);
		result = 31 * result + Objects.hashCode(this.chan9Raw);
		result = 31 * result + Objects.hashCode(this.chan10Raw);
		result = 31 * result + Objects.hashCode(this.chan11Raw);
		result = 31 * result + Objects.hashCode(this.chan12Raw);
		result = 31 * result + Objects.hashCode(this.chan13Raw);
		result = 31 * result + Objects.hashCode(this.chan14Raw);
		result = 31 * result + Objects.hashCode(this.chan15Raw);
		result = 31 * result + Objects.hashCode(this.chan16Raw);
		result = 31 * result + Objects.hashCode(this.chan17Raw);
		result = 31 * result + Objects.hashCode(this.chan18Raw);
		result = 31 * result + Objects.hashCode(this.rssi);
		return result;
	}

	@Override
	public String toString() {
		return "RcChannels{" +
				"timeBootMs=" + timeBootMs +
				", chancount=" + chancount +
				", chan1Raw=" + chan1Raw +
				", chan2Raw=" + chan2Raw +
				", chan3Raw=" + chan3Raw +
				", chan4Raw=" + chan4Raw +
				", chan5Raw=" + chan5Raw +
				", chan6Raw=" + chan6Raw +
				", chan7Raw=" + chan7Raw +
				", chan8Raw=" + chan8Raw +
				", chan9Raw=" + chan9Raw +
				", chan10Raw=" + chan10Raw +
				", chan11Raw=" + chan11Raw +
				", chan12Raw=" + chan12Raw +
				", chan13Raw=" + chan13Raw +
				", chan14Raw=" + chan14Raw +
				", chan15Raw=" + chan15Raw +
				", chan16Raw=" + chan16Raw +
				", chan17Raw=" + chan17Raw +
				", chan18Raw=" + chan18Raw +
				", rssi=" + rssi +
				'}';
	}
}