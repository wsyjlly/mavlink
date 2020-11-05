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
		id = 107,
		messagePayloadLength = 64,
		description = "The IMU readings in SI units in NED body frame"
)
public class HilSensor implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8)
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4)
	private float xacc;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4)
	private float yacc;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4)
	private float zacc;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4)
	private float xgyro;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4)
	private float ygyro;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4)
	private float zgyro;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4)
	private float xmag;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4)
	private float ymag;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4)
	private float zmag;

	@MavlinkMessageParam(mavlinkType = "float", position = 11, typeSize = 4, streamLength = 4)
	private float absPressure;

	@MavlinkMessageParam(mavlinkType = "float", position = 12, typeSize = 4, streamLength = 4)
	private float diffPressure;

	@MavlinkMessageParam(mavlinkType = "float", position = 13, typeSize = 4, streamLength = 4)
	private float pressureAlt;

	@MavlinkMessageParam(mavlinkType = "float", position = 14, typeSize = 4, streamLength = 4)
	private float temperature;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 15, typeSize = 4, streamLength = 4)
	private long fieldsUpdated;

	private final int messagePayloadLength = 64;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public HilSensor(BigInteger timeUsec, float xacc, float yacc, float zacc, float xgyro, float ygyro, float zgyro, float xmag, float ymag, float zmag, float absPressure, float diffPressure, float pressureAlt, float temperature, long fieldsUpdated) {
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
		this.absPressure = absPressure;
		this.diffPressure = diffPressure;
		this.pressureAlt = pressureAlt;
		this.temperature = temperature;
		this.fieldsUpdated = fieldsUpdated;
	}

	public HilSensor(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 64！");
		}
		messagePayload(messagePayload);
	}

	public HilSensor(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.timeUsec = byteArray.getUnsignedInt64(0);
		this.xacc = byteArray.getFloat(8);
		this.yacc = byteArray.getFloat(12);
		this.zacc = byteArray.getFloat(16);
		this.xgyro = byteArray.getFloat(20);
		this.ygyro = byteArray.getFloat(24);
		this.zgyro = byteArray.getFloat(28);
		this.xmag = byteArray.getFloat(32);
		this.ymag = byteArray.getFloat(36);
		this.zmag = byteArray.getFloat(40);
		this.absPressure = byteArray.getFloat(44);
		this.diffPressure = byteArray.getFloat(48);
		this.pressureAlt = byteArray.getFloat(52);
		this.temperature = byteArray.getFloat(56);
		this.fieldsUpdated = byteArray.getUnsignedInt32(60);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final HilSensor setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final HilSensor setXacc(float xacc) {
		this.xacc = xacc;
		return this;
	}

	public final float getXacc() {
		return xacc;
	}

	public final HilSensor setYacc(float yacc) {
		this.yacc = yacc;
		return this;
	}

	public final float getYacc() {
		return yacc;
	}

	public final HilSensor setZacc(float zacc) {
		this.zacc = zacc;
		return this;
	}

	public final float getZacc() {
		return zacc;
	}

	public final HilSensor setXgyro(float xgyro) {
		this.xgyro = xgyro;
		return this;
	}

	public final float getXgyro() {
		return xgyro;
	}

	public final HilSensor setYgyro(float ygyro) {
		this.ygyro = ygyro;
		return this;
	}

	public final float getYgyro() {
		return ygyro;
	}

	public final HilSensor setZgyro(float zgyro) {
		this.zgyro = zgyro;
		return this;
	}

	public final float getZgyro() {
		return zgyro;
	}

	public final HilSensor setXmag(float xmag) {
		this.xmag = xmag;
		return this;
	}

	public final float getXmag() {
		return xmag;
	}

	public final HilSensor setYmag(float ymag) {
		this.ymag = ymag;
		return this;
	}

	public final float getYmag() {
		return ymag;
	}

	public final HilSensor setZmag(float zmag) {
		this.zmag = zmag;
		return this;
	}

	public final float getZmag() {
		return zmag;
	}

	public final HilSensor setAbsPressure(float absPressure) {
		this.absPressure = absPressure;
		return this;
	}

	public final float getAbsPressure() {
		return absPressure;
	}

	public final HilSensor setDiffPressure(float diffPressure) {
		this.diffPressure = diffPressure;
		return this;
	}

	public final float getDiffPressure() {
		return diffPressure;
	}

	public final HilSensor setPressureAlt(float pressureAlt) {
		this.pressureAlt = pressureAlt;
		return this;
	}

	public final float getPressureAlt() {
		return pressureAlt;
	}

	public final HilSensor setTemperature(float temperature) {
		this.temperature = temperature;
		return this;
	}

	public final float getTemperature() {
		return temperature;
	}

	public final HilSensor setFieldsUpdated(long fieldsUpdated) {
		this.fieldsUpdated = fieldsUpdated;
		return this;
	}

	public final long getFieldsUpdated() {
		return fieldsUpdated;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			HilSensor other = (HilSensor)o;
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
			} else if (!Objects.deepEquals(this.zmag, other.zmag)) {
				return false;
			} else if (!Objects.deepEquals(this.absPressure, other.absPressure)) {
				return false;
			} else if (!Objects.deepEquals(this.diffPressure, other.diffPressure)) {
				return false;
			} else if (!Objects.deepEquals(this.pressureAlt, other.pressureAlt)) {
				return false;
			} else if (!Objects.deepEquals(this.temperature, other.temperature)) {
				return false;
			} else {
				return Objects.deepEquals(this.fieldsUpdated, other.fieldsUpdated);
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
		result = 31 * result + Objects.hashCode(this.absPressure);
		result = 31 * result + Objects.hashCode(this.diffPressure);
		result = 31 * result + Objects.hashCode(this.pressureAlt);
		result = 31 * result + Objects.hashCode(this.temperature);
		result = 31 * result + Objects.hashCode(this.fieldsUpdated);
		return result;
	}

	@Override
	public String toString() {
		return "HilSensor{" +
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
				", absPressure=" + absPressure +
				", diffPressure=" + diffPressure +
				", pressureAlt=" + pressureAlt +
				", temperature=" + temperature +
				", fieldsUpdated=" + fieldsUpdated +
				'}';
	}
}