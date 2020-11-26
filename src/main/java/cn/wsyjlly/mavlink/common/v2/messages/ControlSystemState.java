package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.util.Arrays;
import java.math.BigInteger;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 146,
		messagePayloadLength = 100,
		description = "The smoothed, monotonic system state used to feed the control loops of the system."
)
public class ControlSystemState implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4, description = "X acceleration in body frame", units = "m/s/s")
	private float xAcc;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4, description = "Y acceleration in body frame", units = "m/s/s")
	private float yAcc;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "Z acceleration in body frame", units = "m/s/s")
	private float zAcc;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "X velocity in body frame", units = "m/s")
	private float xVel;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Y velocity in body frame", units = "m/s")
	private float yVel;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "Z velocity in body frame", units = "m/s")
	private float zVel;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "X position in local frame", units = "m")
	private float xPos;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4, description = "Y position in local frame", units = "m")
	private float yPos;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4, description = "Z position in local frame", units = "m")
	private float zPos;

	@MavlinkMessageParam(mavlinkType = "float", position = 11, typeSize = 4, streamLength = 4, description = "Airspeed, set to -1 if unknown", units = "m/s")
	private float airspeed;

	@MavlinkMessageParam(mavlinkType = "float", position = 12, typeSize = 4, streamLength = 12, description = "Variance of body velocity estimate")
	private float[] velVariance = new float[3];

	@MavlinkMessageParam(mavlinkType = "float", position = 13, typeSize = 4, streamLength = 12, description = "Variance in local position")
	private float[] posVariance = new float[3];

	@MavlinkMessageParam(mavlinkType = "float", position = 14, typeSize = 4, streamLength = 16, description = "The attitude, represented as Quaternion")
	private float[] q = new float[4];

	@MavlinkMessageParam(mavlinkType = "float", position = 15, typeSize = 4, streamLength = 4, description = "Angular rate in roll axis", units = "rad/s")
	private float rollRate;

	@MavlinkMessageParam(mavlinkType = "float", position = 16, typeSize = 4, streamLength = 4, description = "Angular rate in pitch axis", units = "rad/s")
	private float pitchRate;

	@MavlinkMessageParam(mavlinkType = "float", position = 17, typeSize = 4, streamLength = 4, description = "Angular rate in yaw axis", units = "rad/s")
	private float yawRate;

	private final int messagePayloadLength = 100;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ControlSystemState(BigInteger timeUsec, float xAcc, float yAcc, float zAcc, float xVel, float yVel, float zVel, float xPos, float yPos, float zPos, float airspeed, float[] velVariance, float[] posVariance, float[] q, float rollRate, float pitchRate, float yawRate) {
		this.timeUsec = timeUsec;
		this.xAcc = xAcc;
		this.yAcc = yAcc;
		this.zAcc = zAcc;
		this.xVel = xVel;
		this.yVel = yVel;
		this.zVel = zVel;
		this.xPos = xPos;
		this.yPos = yPos;
		this.zPos = zPos;
		this.airspeed = airspeed;
		this.velVariance = velVariance;
		this.posVariance = posVariance;
		this.q = q;
		this.rollRate = rollRate;
		this.pitchRate = pitchRate;
		this.yawRate = yawRate;
	}

	public ControlSystemState(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 100！");
		}
		messagePayload(messagePayload);
	}

	public ControlSystemState(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		xAcc = byteArray.getFloat(8);
		yAcc = byteArray.getFloat(12);
		zAcc = byteArray.getFloat(16);
		xVel = byteArray.getFloat(20);
		yVel = byteArray.getFloat(24);
		zVel = byteArray.getFloat(28);
		xPos = byteArray.getFloat(32);
		yPos = byteArray.getFloat(36);
		zPos = byteArray.getFloat(40);
		airspeed = byteArray.getFloat(44);
		velVariance = byteArray.getFloatArray(48,3);
		posVariance = byteArray.getFloatArray(60,3);
		q = byteArray.getFloatArray(72,4);
		rollRate = byteArray.getFloat(88);
		pitchRate = byteArray.getFloat(92);
		yawRate = byteArray.getFloat(96);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putFloat(xAcc,8);
		byteArray.putFloat(yAcc,12);
		byteArray.putFloat(zAcc,16);
		byteArray.putFloat(xVel,20);
		byteArray.putFloat(yVel,24);
		byteArray.putFloat(zVel,28);
		byteArray.putFloat(xPos,32);
		byteArray.putFloat(yPos,36);
		byteArray.putFloat(zPos,40);
		byteArray.putFloat(airspeed,44);
		byteArray.putFloatArray(velVariance,48);
		byteArray.putFloatArray(posVariance,60);
		byteArray.putFloatArray(q,72);
		byteArray.putFloat(rollRate,88);
		byteArray.putFloat(pitchRate,92);
		byteArray.putFloat(yawRate,96);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ControlSystemState setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final ControlSystemState setXAcc(float xAcc) {
		this.xAcc = xAcc;
		return this;
	}

	public final float getXAcc() {
		return xAcc;
	}

	public final ControlSystemState setYAcc(float yAcc) {
		this.yAcc = yAcc;
		return this;
	}

	public final float getYAcc() {
		return yAcc;
	}

	public final ControlSystemState setZAcc(float zAcc) {
		this.zAcc = zAcc;
		return this;
	}

	public final float getZAcc() {
		return zAcc;
	}

	public final ControlSystemState setXVel(float xVel) {
		this.xVel = xVel;
		return this;
	}

	public final float getXVel() {
		return xVel;
	}

	public final ControlSystemState setYVel(float yVel) {
		this.yVel = yVel;
		return this;
	}

	public final float getYVel() {
		return yVel;
	}

	public final ControlSystemState setZVel(float zVel) {
		this.zVel = zVel;
		return this;
	}

	public final float getZVel() {
		return zVel;
	}

	public final ControlSystemState setXPos(float xPos) {
		this.xPos = xPos;
		return this;
	}

	public final float getXPos() {
		return xPos;
	}

	public final ControlSystemState setYPos(float yPos) {
		this.yPos = yPos;
		return this;
	}

	public final float getYPos() {
		return yPos;
	}

	public final ControlSystemState setZPos(float zPos) {
		this.zPos = zPos;
		return this;
	}

	public final float getZPos() {
		return zPos;
	}

	public final ControlSystemState setAirspeed(float airspeed) {
		this.airspeed = airspeed;
		return this;
	}

	public final float getAirspeed() {
		return airspeed;
	}

	public final ControlSystemState setVelVariance(float[] velVariance) {
		this.velVariance = velVariance;
		return this;
	}

	public final float[] getVelVariance() {
		return velVariance;
	}

	public final ControlSystemState setPosVariance(float[] posVariance) {
		this.posVariance = posVariance;
		return this;
	}

	public final float[] getPosVariance() {
		return posVariance;
	}

	public final ControlSystemState setQ(float[] q) {
		this.q = q;
		return this;
	}

	public final float[] getQ() {
		return q;
	}

	public final ControlSystemState setRollRate(float rollRate) {
		this.rollRate = rollRate;
		return this;
	}

	public final float getRollRate() {
		return rollRate;
	}

	public final ControlSystemState setPitchRate(float pitchRate) {
		this.pitchRate = pitchRate;
		return this;
	}

	public final float getPitchRate() {
		return pitchRate;
	}

	public final ControlSystemState setYawRate(float yawRate) {
		this.yawRate = yawRate;
		return this;
	}

	public final float getYawRate() {
		return yawRate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ControlSystemState other = (ControlSystemState)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.xAcc, other.xAcc)) {
				return false;
			} else if (!Objects.deepEquals(this.yAcc, other.yAcc)) {
				return false;
			} else if (!Objects.deepEquals(this.zAcc, other.zAcc)) {
				return false;
			} else if (!Objects.deepEquals(this.xVel, other.xVel)) {
				return false;
			} else if (!Objects.deepEquals(this.yVel, other.yVel)) {
				return false;
			} else if (!Objects.deepEquals(this.zVel, other.zVel)) {
				return false;
			} else if (!Objects.deepEquals(this.xPos, other.xPos)) {
				return false;
			} else if (!Objects.deepEquals(this.yPos, other.yPos)) {
				return false;
			} else if (!Objects.deepEquals(this.zPos, other.zPos)) {
				return false;
			} else if (!Objects.deepEquals(this.airspeed, other.airspeed)) {
				return false;
			} else if (!Objects.deepEquals(this.velVariance, other.velVariance)) {
				return false;
			} else if (!Objects.deepEquals(this.posVariance, other.posVariance)) {
				return false;
			} else if (!Objects.deepEquals(this.q, other.q)) {
				return false;
			} else if (!Objects.deepEquals(this.rollRate, other.rollRate)) {
				return false;
			} else if (!Objects.deepEquals(this.pitchRate, other.pitchRate)) {
				return false;
			} else {
				return Objects.deepEquals(this.yawRate, other.yawRate);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.xAcc);
		result = 31 * result + Objects.hashCode(this.yAcc);
		result = 31 * result + Objects.hashCode(this.zAcc);
		result = 31 * result + Objects.hashCode(this.xVel);
		result = 31 * result + Objects.hashCode(this.yVel);
		result = 31 * result + Objects.hashCode(this.zVel);
		result = 31 * result + Objects.hashCode(this.xPos);
		result = 31 * result + Objects.hashCode(this.yPos);
		result = 31 * result + Objects.hashCode(this.zPos);
		result = 31 * result + Objects.hashCode(this.airspeed);
		result = 31 * result + Objects.hashCode(this.velVariance);
		result = 31 * result + Objects.hashCode(this.posVariance);
		result = 31 * result + Objects.hashCode(this.q);
		result = 31 * result + Objects.hashCode(this.rollRate);
		result = 31 * result + Objects.hashCode(this.pitchRate);
		result = 31 * result + Objects.hashCode(this.yawRate);
		return result;
	}

	@Override
	public String toString() {
		return "ControlSystemState{" +
				"timeUsec=" + timeUsec +
				", xAcc=" + xAcc +
				", yAcc=" + yAcc +
				", zAcc=" + zAcc +
				", xVel=" + xVel +
				", yVel=" + yVel +
				", zVel=" + zVel +
				", xPos=" + xPos +
				", yPos=" + yPos +
				", zPos=" + zPos +
				", airspeed=" + airspeed +
				", velVariance=" + Arrays.toString(velVariance) +
				", posVariance=" + Arrays.toString(posVariance) +
				", q=" + Arrays.toString(q) +
				", rollRate=" + rollRate +
				", pitchRate=" + pitchRate +
				", yawRate=" + yawRate +
				'}';
	}
}