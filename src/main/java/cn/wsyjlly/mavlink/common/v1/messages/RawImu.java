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
		id = 27,
		messagePayloadLength = 26,
		description = "The RAW IMU readings for the usual 9DOF sensor setup. This message should always contain the true raw values without any scaling to allow data capture and system debugging."
)
public class RawImu implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (microseconds since UNIX epoch or microseconds since system boot)")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 2, typeSize = 2, streamLength = 2, description = "X acceleration (raw)")
	private short xacc;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 3, typeSize = 2, streamLength = 2, description = "Y acceleration (raw)")
	private short yacc;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 4, typeSize = 2, streamLength = 2, description = "Z acceleration (raw)")
	private short zacc;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 5, typeSize = 2, streamLength = 2, description = "Angular speed around X axis (raw)")
	private short xgyro;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 6, typeSize = 2, streamLength = 2, description = "Angular speed around Y axis (raw)")
	private short ygyro;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 7, typeSize = 2, streamLength = 2, description = "Angular speed around Z axis (raw)")
	private short zgyro;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 8, typeSize = 2, streamLength = 2, description = "X Magnetic field (raw)")
	private short xmag;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 9, typeSize = 2, streamLength = 2, description = "Y Magnetic field (raw)")
	private short ymag;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 10, typeSize = 2, streamLength = 2, description = "Z Magnetic field (raw)")
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
		timeUsec = byteArray.getUnsignedInt64(0);
		xacc = byteArray.getInt16(8);
		yacc = byteArray.getInt16(10);
		zacc = byteArray.getInt16(12);
		xgyro = byteArray.getInt16(14);
		ygyro = byteArray.getInt16(16);
		zgyro = byteArray.getInt16(18);
		xmag = byteArray.getInt16(20);
		ymag = byteArray.getInt16(22);
		zmag = byteArray.getInt16(24);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putInt16(xacc,8);
		byteArray.putInt16(yacc,10);
		byteArray.putInt16(zacc,12);
		byteArray.putInt16(xgyro,14);
		byteArray.putInt16(ygyro,16);
		byteArray.putInt16(zgyro,18);
		byteArray.putInt16(xmag,20);
		byteArray.putInt16(ymag,22);
		byteArray.putInt16(zmag,24);
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