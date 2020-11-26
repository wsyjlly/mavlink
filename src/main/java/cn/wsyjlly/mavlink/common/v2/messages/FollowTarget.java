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
		id = 144,
		messagePayloadLength = 93,
		description = "Current motion information from a designated system"
)
public class FollowTarget implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (time since system boot).", units = "ms")
	private BigInteger timestamp;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "bit positions for tracker reporting capabilities (POS = 0, VEL = 1, ACCEL = 2, ATT + RATES = 3)")
	private short estCapabilities;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 3, typeSize = 4, streamLength = 4, description = "Latitude (WGS84)", units = "degE7")
	private int lat;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 4, typeSize = 4, streamLength = 4, description = "Longitude (WGS84)", units = "degE7")
	private int lon;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Altitude (MSL)", units = "m")
	private float alt;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 12, description = "target velocity (0,0,0) for unknown", units = "m/s")
	private float[] vel = new float[3];

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 12, description = "linear target acceleration (0,0,0) for unknown", units = "m/s/s")
	private float[] acc = new float[3];

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 16, description = "(1 0 0 0 for unknown)")
	private float[] attitudeQ = new float[4];

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 12, description = "(0 0 0 for unknown)")
	private float[] rates = new float[3];

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 12, description = "eph epv")
	private float[] positionCov = new float[3];

	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 11, typeSize = 8, streamLength = 8, description = "button states or switches of a tracker device")
	private BigInteger customState;

	private final int messagePayloadLength = 93;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public FollowTarget(BigInteger timestamp, short estCapabilities, int lat, int lon, float alt, float[] vel, float[] acc, float[] attitudeQ, float[] rates, float[] positionCov, BigInteger customState) {
		this.timestamp = timestamp;
		this.estCapabilities = estCapabilities;
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
		this.vel = vel;
		this.acc = acc;
		this.attitudeQ = attitudeQ;
		this.rates = rates;
		this.positionCov = positionCov;
		this.customState = customState;
	}

	public FollowTarget(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 93！");
		}
		messagePayload(messagePayload);
	}

	public FollowTarget(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timestamp = byteArray.getUnsignedInt64(0);
		estCapabilities = byteArray.getUnsignedInt8(8);
		lat = byteArray.getInt32(9);
		lon = byteArray.getInt32(13);
		alt = byteArray.getFloat(17);
		vel = byteArray.getFloatArray(21,3);
		acc = byteArray.getFloatArray(33,3);
		attitudeQ = byteArray.getFloatArray(45,4);
		rates = byteArray.getFloatArray(61,3);
		positionCov = byteArray.getFloatArray(73,3);
		customState = byteArray.getUnsignedInt64(85);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timestamp,0);
		byteArray.putUnsignedInt8(estCapabilities,8);
		byteArray.putInt32(lat,9);
		byteArray.putInt32(lon,13);
		byteArray.putFloat(alt,17);
		byteArray.putFloatArray(vel,21);
		byteArray.putFloatArray(acc,33);
		byteArray.putFloatArray(attitudeQ,45);
		byteArray.putFloatArray(rates,61);
		byteArray.putFloatArray(positionCov,73);
		byteArray.putUnsignedInt64(customState,85);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final FollowTarget setTimestamp(BigInteger timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	public final BigInteger getTimestamp() {
		return timestamp;
	}

	public final FollowTarget setEstCapabilities(short estCapabilities) {
		this.estCapabilities = estCapabilities;
		return this;
	}

	public final short getEstCapabilities() {
		return estCapabilities;
	}

	public final FollowTarget setLat(int lat) {
		this.lat = lat;
		return this;
	}

	public final int getLat() {
		return lat;
	}

	public final FollowTarget setLon(int lon) {
		this.lon = lon;
		return this;
	}

	public final int getLon() {
		return lon;
	}

	public final FollowTarget setAlt(float alt) {
		this.alt = alt;
		return this;
	}

	public final float getAlt() {
		return alt;
	}

	public final FollowTarget setVel(float[] vel) {
		this.vel = vel;
		return this;
	}

	public final float[] getVel() {
		return vel;
	}

	public final FollowTarget setAcc(float[] acc) {
		this.acc = acc;
		return this;
	}

	public final float[] getAcc() {
		return acc;
	}

	public final FollowTarget setAttitudeQ(float[] attitudeQ) {
		this.attitudeQ = attitudeQ;
		return this;
	}

	public final float[] getAttitudeQ() {
		return attitudeQ;
	}

	public final FollowTarget setRates(float[] rates) {
		this.rates = rates;
		return this;
	}

	public final float[] getRates() {
		return rates;
	}

	public final FollowTarget setPositionCov(float[] positionCov) {
		this.positionCov = positionCov;
		return this;
	}

	public final float[] getPositionCov() {
		return positionCov;
	}

	public final FollowTarget setCustomState(BigInteger customState) {
		this.customState = customState;
		return this;
	}

	public final BigInteger getCustomState() {
		return customState;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			FollowTarget other = (FollowTarget)o;
			if (!Objects.deepEquals(this.timestamp, other.timestamp)) {
				return false;
			} else if (!Objects.deepEquals(this.estCapabilities, other.estCapabilities)) {
				return false;
			} else if (!Objects.deepEquals(this.lat, other.lat)) {
				return false;
			} else if (!Objects.deepEquals(this.lon, other.lon)) {
				return false;
			} else if (!Objects.deepEquals(this.alt, other.alt)) {
				return false;
			} else if (!Objects.deepEquals(this.vel, other.vel)) {
				return false;
			} else if (!Objects.deepEquals(this.acc, other.acc)) {
				return false;
			} else if (!Objects.deepEquals(this.attitudeQ, other.attitudeQ)) {
				return false;
			} else if (!Objects.deepEquals(this.rates, other.rates)) {
				return false;
			} else if (!Objects.deepEquals(this.positionCov, other.positionCov)) {
				return false;
			} else {
				return Objects.deepEquals(this.customState, other.customState);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timestamp);
		result = 31 * result + Objects.hashCode(this.estCapabilities);
		result = 31 * result + Objects.hashCode(this.lat);
		result = 31 * result + Objects.hashCode(this.lon);
		result = 31 * result + Objects.hashCode(this.alt);
		result = 31 * result + Objects.hashCode(this.vel);
		result = 31 * result + Objects.hashCode(this.acc);
		result = 31 * result + Objects.hashCode(this.attitudeQ);
		result = 31 * result + Objects.hashCode(this.rates);
		result = 31 * result + Objects.hashCode(this.positionCov);
		result = 31 * result + Objects.hashCode(this.customState);
		return result;
	}

	@Override
	public String toString() {
		return "FollowTarget{" +
				"timestamp=" + timestamp +
				", estCapabilities=" + estCapabilities +
				", lat=" + lat +
				", lon=" + lon +
				", alt=" + alt +
				", vel=" + Arrays.toString(vel) +
				", acc=" + Arrays.toString(acc) +
				", attitudeQ=" + Arrays.toString(attitudeQ) +
				", rates=" + Arrays.toString(rates) +
				", positionCov=" + Arrays.toString(positionCov) +
				", customState=" + customState +
				'}';
	}
}