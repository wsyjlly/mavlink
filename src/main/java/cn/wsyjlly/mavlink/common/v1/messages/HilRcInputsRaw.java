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
		id = 92,
		messagePayloadLength = 33,
		description = "Sent from simulation to autopilot. The RAW values of the RC channels received. The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%. Individual receivers/transmitters might violate this specification."
)
public class HilRcInputsRaw implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (microseconds since UNIX epoch or microseconds since system boot)")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 2, typeSize = 2, streamLength = 2, description = "RC channel 1 value, in microseconds")
	private int chan1Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2, description = "RC channel 2 value, in microseconds")
	private int chan2Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 4, typeSize = 2, streamLength = 2, description = "RC channel 3 value, in microseconds")
	private int chan3Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 5, typeSize = 2, streamLength = 2, description = "RC channel 4 value, in microseconds")
	private int chan4Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 6, typeSize = 2, streamLength = 2, description = "RC channel 5 value, in microseconds")
	private int chan5Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 7, typeSize = 2, streamLength = 2, description = "RC channel 6 value, in microseconds")
	private int chan6Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 8, typeSize = 2, streamLength = 2, description = "RC channel 7 value, in microseconds")
	private int chan7Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 9, typeSize = 2, streamLength = 2, description = "RC channel 8 value, in microseconds")
	private int chan8Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 10, typeSize = 2, streamLength = 2, description = "RC channel 9 value, in microseconds")
	private int chan9Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 11, typeSize = 2, streamLength = 2, description = "RC channel 10 value, in microseconds")
	private int chan10Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 12, typeSize = 2, streamLength = 2, description = "RC channel 11 value, in microseconds")
	private int chan11Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 13, typeSize = 2, streamLength = 2, description = "RC channel 12 value, in microseconds")
	private int chan12Raw;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 14, typeSize = 1, streamLength = 1, description = "Receive signal strength indicator, 0: 0%, 255: 100%")
	private short rssi;

	private final int messagePayloadLength = 33;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public HilRcInputsRaw(BigInteger timeUsec, int chan1Raw, int chan2Raw, int chan3Raw, int chan4Raw, int chan5Raw, int chan6Raw, int chan7Raw, int chan8Raw, int chan9Raw, int chan10Raw, int chan11Raw, int chan12Raw, short rssi) {
		this.timeUsec = timeUsec;
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
		this.rssi = rssi;
	}

	public HilRcInputsRaw(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 33！");
		}
		messagePayload(messagePayload);
	}

	public HilRcInputsRaw(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		chan1Raw = byteArray.getUnsignedInt16(8);
		chan2Raw = byteArray.getUnsignedInt16(10);
		chan3Raw = byteArray.getUnsignedInt16(12);
		chan4Raw = byteArray.getUnsignedInt16(14);
		chan5Raw = byteArray.getUnsignedInt16(16);
		chan6Raw = byteArray.getUnsignedInt16(18);
		chan7Raw = byteArray.getUnsignedInt16(20);
		chan8Raw = byteArray.getUnsignedInt16(22);
		chan9Raw = byteArray.getUnsignedInt16(24);
		chan10Raw = byteArray.getUnsignedInt16(26);
		chan11Raw = byteArray.getUnsignedInt16(28);
		chan12Raw = byteArray.getUnsignedInt16(30);
		rssi = byteArray.getUnsignedInt8(32);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putUnsignedInt16(chan1Raw,8);
		byteArray.putUnsignedInt16(chan2Raw,10);
		byteArray.putUnsignedInt16(chan3Raw,12);
		byteArray.putUnsignedInt16(chan4Raw,14);
		byteArray.putUnsignedInt16(chan5Raw,16);
		byteArray.putUnsignedInt16(chan6Raw,18);
		byteArray.putUnsignedInt16(chan7Raw,20);
		byteArray.putUnsignedInt16(chan8Raw,22);
		byteArray.putUnsignedInt16(chan9Raw,24);
		byteArray.putUnsignedInt16(chan10Raw,26);
		byteArray.putUnsignedInt16(chan11Raw,28);
		byteArray.putUnsignedInt16(chan12Raw,30);
		byteArray.putUnsignedInt8(rssi,32);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final HilRcInputsRaw setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final HilRcInputsRaw setChan1Raw(int chan1Raw) {
		this.chan1Raw = chan1Raw;
		return this;
	}

	public final int getChan1Raw() {
		return chan1Raw;
	}

	public final HilRcInputsRaw setChan2Raw(int chan2Raw) {
		this.chan2Raw = chan2Raw;
		return this;
	}

	public final int getChan2Raw() {
		return chan2Raw;
	}

	public final HilRcInputsRaw setChan3Raw(int chan3Raw) {
		this.chan3Raw = chan3Raw;
		return this;
	}

	public final int getChan3Raw() {
		return chan3Raw;
	}

	public final HilRcInputsRaw setChan4Raw(int chan4Raw) {
		this.chan4Raw = chan4Raw;
		return this;
	}

	public final int getChan4Raw() {
		return chan4Raw;
	}

	public final HilRcInputsRaw setChan5Raw(int chan5Raw) {
		this.chan5Raw = chan5Raw;
		return this;
	}

	public final int getChan5Raw() {
		return chan5Raw;
	}

	public final HilRcInputsRaw setChan6Raw(int chan6Raw) {
		this.chan6Raw = chan6Raw;
		return this;
	}

	public final int getChan6Raw() {
		return chan6Raw;
	}

	public final HilRcInputsRaw setChan7Raw(int chan7Raw) {
		this.chan7Raw = chan7Raw;
		return this;
	}

	public final int getChan7Raw() {
		return chan7Raw;
	}

	public final HilRcInputsRaw setChan8Raw(int chan8Raw) {
		this.chan8Raw = chan8Raw;
		return this;
	}

	public final int getChan8Raw() {
		return chan8Raw;
	}

	public final HilRcInputsRaw setChan9Raw(int chan9Raw) {
		this.chan9Raw = chan9Raw;
		return this;
	}

	public final int getChan9Raw() {
		return chan9Raw;
	}

	public final HilRcInputsRaw setChan10Raw(int chan10Raw) {
		this.chan10Raw = chan10Raw;
		return this;
	}

	public final int getChan10Raw() {
		return chan10Raw;
	}

	public final HilRcInputsRaw setChan11Raw(int chan11Raw) {
		this.chan11Raw = chan11Raw;
		return this;
	}

	public final int getChan11Raw() {
		return chan11Raw;
	}

	public final HilRcInputsRaw setChan12Raw(int chan12Raw) {
		this.chan12Raw = chan12Raw;
		return this;
	}

	public final int getChan12Raw() {
		return chan12Raw;
	}

	public final HilRcInputsRaw setRssi(short rssi) {
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
			HilRcInputsRaw other = (HilRcInputsRaw)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
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
		result = 31 * result + Objects.hashCode(this.timeUsec);
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
		result = 31 * result + Objects.hashCode(this.rssi);
		return result;
	}

	@Override
	public String toString() {
		return "HilRcInputsRaw{" +
				"timeUsec=" + timeUsec +
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
				", rssi=" + rssi +
				'}';
	}
}