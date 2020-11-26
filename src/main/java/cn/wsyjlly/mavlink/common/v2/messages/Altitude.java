package cn.wsyjlly.mavlink.common.v2.messages;

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
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 141,
		messagePayloadLength = 32,
		description = "The current system altitude."
)
public class Altitude implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4, description = "This altitude measure is initialized on system boot and monotonic (it is never reset, but represents the local altitude change). The only guarantee on this field is that it will never be reset and is consistent within a flight. The recommended value for this field is the uncorrected barometric altitude at boot time. This altitude will also drift and vary between flights.", units = "m")
	private float altitudeMonotonic;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4, description = "This altitude measure is strictly above mean sea level and might be non-monotonic (it might reset on events like GPS lock or when a new QNH value is set). It should be the altitude to which global altitude waypoints are compared to. Note that it is *not* the GPS altitude, however, most GPS modules already output MSL by default and not the WGS84 altitude.", units = "m")
	private float altitudeAmsl;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "This is the local altitude in the local coordinate frame. It is not the altitude above home, but in reference to the coordinate origin (0, 0, 0). It is up-positive.", units = "m")
	private float altitudeLocal;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "This is the altitude above the home position. It resets on each change of the current home position.", units = "m")
	private float altitudeRelative;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "This is the altitude above terrain. It might be fed by a terrain database or an altimeter. Values smaller than -1000 should be interpreted as unknown.", units = "m")
	private float altitudeTerrain;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "This is not the altitude, but the clear space below the system according to the fused clearance estimate. It generally should max out at the maximum range of e.g. the laser altimeter. It is generally a moving target. A negative value indicates no measurement available.", units = "m")
	private float bottomClearance;

	private final int messagePayloadLength = 32;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public Altitude(BigInteger timeUsec, float altitudeMonotonic, float altitudeAmsl, float altitudeLocal, float altitudeRelative, float altitudeTerrain, float bottomClearance) {
		this.timeUsec = timeUsec;
		this.altitudeMonotonic = altitudeMonotonic;
		this.altitudeAmsl = altitudeAmsl;
		this.altitudeLocal = altitudeLocal;
		this.altitudeRelative = altitudeRelative;
		this.altitudeTerrain = altitudeTerrain;
		this.bottomClearance = bottomClearance;
	}

	public Altitude(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 32！");
		}
		messagePayload(messagePayload);
	}

	public Altitude(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		altitudeMonotonic = byteArray.getFloat(8);
		altitudeAmsl = byteArray.getFloat(12);
		altitudeLocal = byteArray.getFloat(16);
		altitudeRelative = byteArray.getFloat(20);
		altitudeTerrain = byteArray.getFloat(24);
		bottomClearance = byteArray.getFloat(28);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putFloat(altitudeMonotonic,8);
		byteArray.putFloat(altitudeAmsl,12);
		byteArray.putFloat(altitudeLocal,16);
		byteArray.putFloat(altitudeRelative,20);
		byteArray.putFloat(altitudeTerrain,24);
		byteArray.putFloat(bottomClearance,28);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final Altitude setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final Altitude setAltitudeMonotonic(float altitudeMonotonic) {
		this.altitudeMonotonic = altitudeMonotonic;
		return this;
	}

	public final float getAltitudeMonotonic() {
		return altitudeMonotonic;
	}

	public final Altitude setAltitudeAmsl(float altitudeAmsl) {
		this.altitudeAmsl = altitudeAmsl;
		return this;
	}

	public final float getAltitudeAmsl() {
		return altitudeAmsl;
	}

	public final Altitude setAltitudeLocal(float altitudeLocal) {
		this.altitudeLocal = altitudeLocal;
		return this;
	}

	public final float getAltitudeLocal() {
		return altitudeLocal;
	}

	public final Altitude setAltitudeRelative(float altitudeRelative) {
		this.altitudeRelative = altitudeRelative;
		return this;
	}

	public final float getAltitudeRelative() {
		return altitudeRelative;
	}

	public final Altitude setAltitudeTerrain(float altitudeTerrain) {
		this.altitudeTerrain = altitudeTerrain;
		return this;
	}

	public final float getAltitudeTerrain() {
		return altitudeTerrain;
	}

	public final Altitude setBottomClearance(float bottomClearance) {
		this.bottomClearance = bottomClearance;
		return this;
	}

	public final float getBottomClearance() {
		return bottomClearance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			Altitude other = (Altitude)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.altitudeMonotonic, other.altitudeMonotonic)) {
				return false;
			} else if (!Objects.deepEquals(this.altitudeAmsl, other.altitudeAmsl)) {
				return false;
			} else if (!Objects.deepEquals(this.altitudeLocal, other.altitudeLocal)) {
				return false;
			} else if (!Objects.deepEquals(this.altitudeRelative, other.altitudeRelative)) {
				return false;
			} else if (!Objects.deepEquals(this.altitudeTerrain, other.altitudeTerrain)) {
				return false;
			} else {
				return Objects.deepEquals(this.bottomClearance, other.bottomClearance);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.altitudeMonotonic);
		result = 31 * result + Objects.hashCode(this.altitudeAmsl);
		result = 31 * result + Objects.hashCode(this.altitudeLocal);
		result = 31 * result + Objects.hashCode(this.altitudeRelative);
		result = 31 * result + Objects.hashCode(this.altitudeTerrain);
		result = 31 * result + Objects.hashCode(this.bottomClearance);
		return result;
	}

	@Override
	public String toString() {
		return "Altitude{" +
				"timeUsec=" + timeUsec +
				", altitudeMonotonic=" + altitudeMonotonic +
				", altitudeAmsl=" + altitudeAmsl +
				", altitudeLocal=" + altitudeLocal +
				", altitudeRelative=" + altitudeRelative +
				", altitudeTerrain=" + altitudeTerrain +
				", bottomClearance=" + bottomClearance +
				'}';
	}
}