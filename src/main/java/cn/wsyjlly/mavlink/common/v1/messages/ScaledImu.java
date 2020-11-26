package cn.wsyjlly.mavlink.common.v1.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkMessage(
		id = 26,
		messagePayloadLength = 22,
		description = "The RAW IMU readings for the usual 9DOF sensor setup. This message should contain the scaled values to the described units"
)
public class ScaledImu implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp (milliseconds since system boot)")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 2, typeSize = 2, streamLength = 2, description = "X acceleration (mg)")
	private short xacc;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 3, typeSize = 2, streamLength = 2, description = "Y acceleration (mg)")
	private short yacc;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 4, typeSize = 2, streamLength = 2, description = "Z acceleration (mg)")
	private short zacc;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 5, typeSize = 2, streamLength = 2, description = "Angular speed around X axis (millirad /sec)")
	private short xgyro;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 6, typeSize = 2, streamLength = 2, description = "Angular speed around Y axis (millirad /sec)")
	private short ygyro;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 7, typeSize = 2, streamLength = 2, description = "Angular speed around Z axis (millirad /sec)")
	private short zgyro;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 8, typeSize = 2, streamLength = 2, description = "X Magnetic field (milli tesla)")
	private short xmag;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 9, typeSize = 2, streamLength = 2, description = "Y Magnetic field (milli tesla)")
	private short ymag;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 10, typeSize = 2, streamLength = 2, description = "Z Magnetic field (milli tesla)")
	private short zmag;

	private final int messagePayloadLength = 22;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ScaledImu(long timeBootMs, short xacc, short yacc, short zacc, short xgyro, short ygyro, short zgyro, short xmag, short ymag, short zmag) {
		this.timeBootMs = timeBootMs;
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

	public ScaledImu(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 22！");
		}
		messagePayload(messagePayload);
	}

	public ScaledImu(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeBootMs = byteArray.getUnsignedInt32(0);
		xacc = byteArray.getInt16(4);
		yacc = byteArray.getInt16(6);
		zacc = byteArray.getInt16(8);
		xgyro = byteArray.getInt16(10);
		ygyro = byteArray.getInt16(12);
		zgyro = byteArray.getInt16(14);
		xmag = byteArray.getInt16(16);
		ymag = byteArray.getInt16(18);
		zmag = byteArray.getInt16(20);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeBootMs,0);
		byteArray.putInt16(xacc,4);
		byteArray.putInt16(yacc,6);
		byteArray.putInt16(zacc,8);
		byteArray.putInt16(xgyro,10);
		byteArray.putInt16(ygyro,12);
		byteArray.putInt16(zgyro,14);
		byteArray.putInt16(xmag,16);
		byteArray.putInt16(ymag,18);
		byteArray.putInt16(zmag,20);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ScaledImu setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final ScaledImu setXacc(short xacc) {
		this.xacc = xacc;
		return this;
	}

	public final short getXacc() {
		return xacc;
	}

	public final ScaledImu setYacc(short yacc) {
		this.yacc = yacc;
		return this;
	}

	public final short getYacc() {
		return yacc;
	}

	public final ScaledImu setZacc(short zacc) {
		this.zacc = zacc;
		return this;
	}

	public final short getZacc() {
		return zacc;
	}

	public final ScaledImu setXgyro(short xgyro) {
		this.xgyro = xgyro;
		return this;
	}

	public final short getXgyro() {
		return xgyro;
	}

	public final ScaledImu setYgyro(short ygyro) {
		this.ygyro = ygyro;
		return this;
	}

	public final short getYgyro() {
		return ygyro;
	}

	public final ScaledImu setZgyro(short zgyro) {
		this.zgyro = zgyro;
		return this;
	}

	public final short getZgyro() {
		return zgyro;
	}

	public final ScaledImu setXmag(short xmag) {
		this.xmag = xmag;
		return this;
	}

	public final short getXmag() {
		return xmag;
	}

	public final ScaledImu setYmag(short ymag) {
		this.ymag = ymag;
		return this;
	}

	public final short getYmag() {
		return ymag;
	}

	public final ScaledImu setZmag(short zmag) {
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
			ScaledImu other = (ScaledImu)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
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
		result = 31 * result + Objects.hashCode(this.timeBootMs);
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
		return "ScaledImu{" +
				"timeBootMs=" + timeBootMs +
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