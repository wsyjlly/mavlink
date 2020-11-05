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
		id = 27,
		messagePayloadLength = 26,
		description = "The RAW IMU readings for the usual 9DOF sensor setup. This message should always contain the true raw values without any scaling to allow data capture and system debugging."
)
public class RawImu implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8)
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 2, typeSize = 2, streamLength = 2)
	private short xacc;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 3, typeSize = 2, streamLength = 2)
	private short yacc;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 4, typeSize = 2, streamLength = 2)
	private short zacc;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 5, typeSize = 2, streamLength = 2)
	private short xgyro;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 6, typeSize = 2, streamLength = 2)
	private short ygyro;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 7, typeSize = 2, streamLength = 2)
	private short zgyro;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 8, typeSize = 2, streamLength = 2)
	private short xmag;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 9, typeSize = 2, streamLength = 2)
	private short ymag;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 10, typeSize = 2, streamLength = 2)
	private short zmag;

	private final int messagePayloadLength = 26;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public RawImu(BigInteger timeUsec, short xacc, short yacc, short zacc, short xgyro, short ygyro, short zgyro, short xmag, short ymag, short zmag) {
		this.timeUsec = timeUsec;
		this.xacc = xacc;
		this.yacc = yacc;
		this.zacc = zacc;
		this.xgyro = xgyro;
		this.ygyro = ygyro;
		this.zgyro = zgyro;
		this.xmag = xmag;
		this.ymag = ymag;
		this.zmag = zmag;
	}

	public RawImu(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 26！");
		}
		messagePayload(messagePayload);
	}

	public RawImu(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.timeUsec = byteArray.getUnsignedInt64(0);
		this.xacc = byteArray.getInt16(8);
		this.yacc = byteArray.getInt16(10);
		this.zacc = byteArray.getInt16(12);
		this.xgyro = byteArray.getInt16(14);
		this.ygyro = byteArray.getInt16(16);
		this.zgyro = byteArray.getInt16(18);
		this.xmag = byteArray.getInt16(20);
		this.ymag = byteArray.getInt16(22);
		this.zmag = byteArray.getInt16(24);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final RawImu setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final RawImu setXacc(short xacc) {
		this.xacc = xacc;
		return this;
	}

	public final short getXacc() {
		return xacc;
	}

	public final RawImu setYacc(short yacc) {
		this.yacc = yacc;
		return this;
	}

	public final short getYacc() {
		return yacc;
	}

	public final RawImu setZacc(short zacc) {
		this.zacc = zacc;
		return this;
	}

	public final short getZacc() {
		return zacc;
	}

	public final RawImu setXgyro(short xgyro) {
		this.xgyro = xgyro;
		return this;
	}

	public final short getXgyro() {
		return xgyro;
	}

	public final RawImu setYgyro(short ygyro) {
		this.ygyro = ygyro;
		return this;
	}

	public final short getYgyro() {
		return ygyro;
	}

	public final RawImu setZgyro(short zgyro) {
		this.zgyro = zgyro;
		return this;
	}

	public final short getZgyro() {
		return zgyro;
	}

	public final RawImu setXmag(short xmag) {
		this.xmag = xmag;
		return this;
	}

	public final short getXmag() {
		return xmag;
	}

	public final RawImu setYmag(short ymag) {
		this.ymag = ymag;
		return this;
	}

	public final short getYmag() {
		return ymag;
	}

	public final RawImu setZmag(short zmag) {
		this.zmag = zmag;
		return this;
	}

	public final short getZmag() {
		return zmag;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			RawImu other = (RawImu)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.xacc, other.xacc)) {
				return false;
			} else if (!Objects.deepEquals(this.yacc, other.yacc)) {
				return false;
			} else if (!Objects.deepEquals(this.zacc, other.zacc)) {
				return false;
			} else if (!Objects.deepEquals(this.xgyro, other.xgyro)) {
				return false;
			} else if (!Objects.deepEquals(this.ygyro, other.ygyro)) {
				return false;
			} else if (!Objects.deepEquals(this.zgyro, other.zgyro)) {
				return false;
			} else if (!Objects.deepEquals(this.xmag, other.xmag)) {
				return false;
			} else if (!Objects.deepEquals(this.ymag, other.ymag)) {
				return false;
			} else {
				return Objects.deepEquals(this.zmag, other.zmag);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.xacc);
		result = 31 * result + Objects.hashCode(this.yacc);
		result = 31 * result + Objects.hashCode(this.zacc);
		result = 31 * result + Objects.hashCode(this.xgyro);
		result = 31 * result + Objects.hashCode(this.ygyro);
		result = 31 * result + Objects.hashCode(this.zgyro);
		result = 31 * result + Objects.hashCode(this.xmag);
		result = 31 * result + Objects.hashCode(this.ymag);
		result = 31 * result + Objects.hashCode(this.zmag);
		return result;
	}

	@Override
	public String toString() {
		return "RawImu{" +
				"timeUsec=" + timeUsec +
				", xacc=" + xacc +
				", yacc=" + yacc +
				", zacc=" + zacc +
				", xgyro=" + xgyro +
				", ygyro=" + ygyro +
				", zgyro=" + zgyro +
				", xmag=" + xmag +
				", ymag=" + ymag +
				", zmag=" + zmag +
				'}';
	}
}