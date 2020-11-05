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
		id = 108,
		messagePayloadLength = 84,
		description = "Status of simulation environment, if used"
)
public class SimState implements Message {
	@MavlinkMessageParam(mavlinkType = "float", position = 1, typeSize = 4, streamLength = 4)
	private float q1;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4)
	private float q2;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4)
	private float q3;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4)
	private float q4;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4)
	private float roll;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4)
	private float pitch;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4)
	private float yaw;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4)
	private float xacc;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4)
	private float yacc;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4)
	private float zacc;

	@MavlinkMessageParam(mavlinkType = "float", position = 11, typeSize = 4, streamLength = 4)
	private float xgyro;

	@MavlinkMessageParam(mavlinkType = "float", position = 12, typeSize = 4, streamLength = 4)
	private float ygyro;

	@MavlinkMessageParam(mavlinkType = "float", position = 13, typeSize = 4, streamLength = 4)
	private float zgyro;

	@MavlinkMessageParam(mavlinkType = "float", position = 14, typeSize = 4, streamLength = 4)
	private float lat;

	@MavlinkMessageParam(mavlinkType = "float", position = 15, typeSize = 4, streamLength = 4)
	private float lon;

	@MavlinkMessageParam(mavlinkType = "float", position = 16, typeSize = 4, streamLength = 4)
	private float alt;

	@MavlinkMessageParam(mavlinkType = "float", position = 17, typeSize = 4, streamLength = 4)
	private float stdDevHorz;

	@MavlinkMessageParam(mavlinkType = "float", position = 18, typeSize = 4, streamLength = 4)
	private float stdDevVert;

	@MavlinkMessageParam(mavlinkType = "float", position = 19, typeSize = 4, streamLength = 4)
	private float vn;

	@MavlinkMessageParam(mavlinkType = "float", position = 20, typeSize = 4, streamLength = 4)
	private float ve;

	@MavlinkMessageParam(mavlinkType = "float", position = 21, typeSize = 4, streamLength = 4)
	private float vd;

	private final int messagePayloadLength = 84;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public SimState(float q1, float q2, float q3, float q4, float roll, float pitch, float yaw, float xacc, float yacc, float zacc, float xgyro, float ygyro, float zgyro, float lat, float lon, float alt, float stdDevHorz, float stdDevVert, float vn, float ve, float vd) {
		this.q1 = q1;
		this.q2 = q2;
		this.q3 = q3;
		this.q4 = q4;
		this.roll = roll;
		this.pitch = pitch;
		this.yaw = yaw;
		this.xacc = xacc;
		this.yacc = yacc;
		this.zacc = zacc;
		this.xgyro = xgyro;
		this.ygyro = ygyro;
		this.zgyro = zgyro;
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
		this.stdDevHorz = stdDevHorz;
		this.stdDevVert = stdDevVert;
		this.vn = vn;
		this.ve = ve;
		this.vd = vd;
	}

	public SimState(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 84！");
		}
		messagePayload(messagePayload);
	}

	public SimState(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.q1 = byteArray.getFloat(0);
		this.q2 = byteArray.getFloat(4);
		this.q3 = byteArray.getFloat(8);
		this.q4 = byteArray.getFloat(12);
		this.roll = byteArray.getFloat(16);
		this.pitch = byteArray.getFloat(20);
		this.yaw = byteArray.getFloat(24);
		this.xacc = byteArray.getFloat(28);
		this.yacc = byteArray.getFloat(32);
		this.zacc = byteArray.getFloat(36);
		this.xgyro = byteArray.getFloat(40);
		this.ygyro = byteArray.getFloat(44);
		this.zgyro = byteArray.getFloat(48);
		this.lat = byteArray.getFloat(52);
		this.lon = byteArray.getFloat(56);
		this.alt = byteArray.getFloat(60);
		this.stdDevHorz = byteArray.getFloat(64);
		this.stdDevVert = byteArray.getFloat(68);
		this.vn = byteArray.getFloat(72);
		this.ve = byteArray.getFloat(76);
		this.vd = byteArray.getFloat(80);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final SimState setQ1(float q1) {
		this.q1 = q1;
		return this;
	}

	public final float getQ1() {
		return q1;
	}

	public final SimState setQ2(float q2) {
		this.q2 = q2;
		return this;
	}

	public final float getQ2() {
		return q2;
	}

	public final SimState setQ3(float q3) {
		this.q3 = q3;
		return this;
	}

	public final float getQ3() {
		return q3;
	}

	public final SimState setQ4(float q4) {
		this.q4 = q4;
		return this;
	}

	public final float getQ4() {
		return q4;
	}

	public final SimState setRoll(float roll) {
		this.roll = roll;
		return this;
	}

	public final float getRoll() {
		return roll;
	}

	public final SimState setPitch(float pitch) {
		this.pitch = pitch;
		return this;
	}

	public final float getPitch() {
		return pitch;
	}

	public final SimState setYaw(float yaw) {
		this.yaw = yaw;
		return this;
	}

	public final float getYaw() {
		return yaw;
	}

	public final SimState setXacc(float xacc) {
		this.xacc = xacc;
		return this;
	}

	public final float getXacc() {
		return xacc;
	}

	public final SimState setYacc(float yacc) {
		this.yacc = yacc;
		return this;
	}

	public final float getYacc() {
		return yacc;
	}

	public final SimState setZacc(float zacc) {
		this.zacc = zacc;
		return this;
	}

	public final float getZacc() {
		return zacc;
	}

	public final SimState setXgyro(float xgyro) {
		this.xgyro = xgyro;
		return this;
	}

	public final float getXgyro() {
		return xgyro;
	}

	public final SimState setYgyro(float ygyro) {
		this.ygyro = ygyro;
		return this;
	}

	public final float getYgyro() {
		return ygyro;
	}

	public final SimState setZgyro(float zgyro) {
		this.zgyro = zgyro;
		return this;
	}

	public final float getZgyro() {
		return zgyro;
	}

	public final SimState setLat(float lat) {
		this.lat = lat;
		return this;
	}

	public final float getLat() {
		return lat;
	}

	public final SimState setLon(float lon) {
		this.lon = lon;
		return this;
	}

	public final float getLon() {
		return lon;
	}

	public final SimState setAlt(float alt) {
		this.alt = alt;
		return this;
	}

	public final float getAlt() {
		return alt;
	}

	public final SimState setStdDevHorz(float stdDevHorz) {
		this.stdDevHorz = stdDevHorz;
		return this;
	}

	public final float getStdDevHorz() {
		return stdDevHorz;
	}

	public final SimState setStdDevVert(float stdDevVert) {
		this.stdDevVert = stdDevVert;
		return this;
	}

	public final float getStdDevVert() {
		return stdDevVert;
	}

	public final SimState setVn(float vn) {
		this.vn = vn;
		return this;
	}

	public final float getVn() {
		return vn;
	}

	public final SimState setVe(float ve) {
		this.ve = ve;
		return this;
	}

	public final float getVe() {
		return ve;
	}

	public final SimState setVd(float vd) {
		this.vd = vd;
		return this;
	}

	public final float getVd() {
		return vd;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			SimState other = (SimState)o;
			if (!Objects.deepEquals(this.q1, other.q1)) {
				return false;
			} else if (!Objects.deepEquals(this.q2, other.q2)) {
				return false;
			} else if (!Objects.deepEquals(this.q3, other.q3)) {
				return false;
			} else if (!Objects.deepEquals(this.q4, other.q4)) {
				return false;
			} else if (!Objects.deepEquals(this.roll, other.roll)) {
				return false;
			} else if (!Objects.deepEquals(this.pitch, other.pitch)) {
				return false;
			} else if (!Objects.deepEquals(this.yaw, other.yaw)) {
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
			} else if (!Objects.deepEquals(this.lat, other.lat)) {
				return false;
			} else if (!Objects.deepEquals(this.lon, other.lon)) {
				return false;
			} else if (!Objects.deepEquals(this.alt, other.alt)) {
				return false;
			} else if (!Objects.deepEquals(this.stdDevHorz, other.stdDevHorz)) {
				return false;
			} else if (!Objects.deepEquals(this.stdDevVert, other.stdDevVert)) {
				return false;
			} else if (!Objects.deepEquals(this.vn, other.vn)) {
				return false;
			} else if (!Objects.deepEquals(this.ve, other.ve)) {
				return false;
			} else {
				return Objects.deepEquals(this.vd, other.vd);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.q1);
		result = 31 * result + Objects.hashCode(this.q2);
		result = 31 * result + Objects.hashCode(this.q3);
		result = 31 * result + Objects.hashCode(this.q4);
		result = 31 * result + Objects.hashCode(this.roll);
		result = 31 * result + Objects.hashCode(this.pitch);
		result = 31 * result + Objects.hashCode(this.yaw);
		result = 31 * result + Objects.hashCode(this.xacc);
		result = 31 * result + Objects.hashCode(this.yacc);
		result = 31 * result + Objects.hashCode(this.zacc);
		result = 31 * result + Objects.hashCode(this.xgyro);
		result = 31 * result + Objects.hashCode(this.ygyro);
		result = 31 * result + Objects.hashCode(this.zgyro);
		result = 31 * result + Objects.hashCode(this.lat);
		result = 31 * result + Objects.hashCode(this.lon);
		result = 31 * result + Objects.hashCode(this.alt);
		result = 31 * result + Objects.hashCode(this.stdDevHorz);
		result = 31 * result + Objects.hashCode(this.stdDevVert);
		result = 31 * result + Objects.hashCode(this.vn);
		result = 31 * result + Objects.hashCode(this.ve);
		result = 31 * result + Objects.hashCode(this.vd);
		return result;
	}

	@Override
	public String toString() {
		return "SimState{" +
				"q1=" + q1 +
				", q2=" + q2 +
				", q3=" + q3 +
				", q4=" + q4 +
				", roll=" + roll +
				", pitch=" + pitch +
				", yaw=" + yaw +
				", xacc=" + xacc +
				", yacc=" + yacc +
				", zacc=" + zacc +
				", xgyro=" + xgyro +
				", ygyro=" + ygyro +
				", zgyro=" + zgyro +
				", lat=" + lat +
				", lon=" + lon +
				", alt=" + alt +
				", stdDevHorz=" + stdDevHorz +
				", stdDevVert=" + stdDevVert +
				", vn=" + vn +
				", ve=" + ve +
				", vd=" + vd +
				'}';
	}
}