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
		id = 243,
		messagePayloadLength = 61,
		description = "The position the system will return to and land on. The position is set automatically by the system during the takeoff in case it was not explicitly set by the operator before or after. The global and local positions encode the position in the respective coordinate frames, while the q parameter encodes the orientation of the surface. Under normal conditions it describes the heading and terrain slope, which can be used by the aircraft to adjust the approach. The approach 3D vector describes the point to which the system should fly in normal flight mode and then perform a landing sequence along the vector."
)
public class SetHomePosition implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID.")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 2, typeSize = 4, streamLength = 4, description = "Latitude (WGS84)", units = "degE7")
	private int latitude;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 3, typeSize = 4, streamLength = 4, description = "Longitude (WGS84)", units = "degE7")
	private int longitude;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 4, typeSize = 4, streamLength = 4, description = "Altitude (MSL). Positive for up.", units = "mm")
	private int altitude;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Local X position of this position in the local coordinate frame", units = "m")
	private float x;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Local Y position of this position in the local coordinate frame", units = "m")
	private float y;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "Local Z position of this position in the local coordinate frame", units = "m")
	private float z;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 16, description = "World to surface normal and heading transformation of the takeoff position. Used to indicate the heading and slope of the ground")
	private float[] q = new float[4];

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4, description = "Local X position of the end of the approach vector. Multicopters should set this position based on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of the takeoff, assuming the takeoff happened from the threshold / touchdown zone.", units = "m")
	private float approachX;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4, description = "Local Y position of the end of the approach vector. Multicopters should set this position based on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of the takeoff, assuming the takeoff happened from the threshold / touchdown zone.", units = "m")
	private float approachY;

	@MavlinkMessageParam(mavlinkType = "float", position = 11, typeSize = 4, streamLength = 4, description = "Local Z position of the end of the approach vector. Multicopters should set this position based on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of the takeoff, assuming the takeoff happened from the threshold / touchdown zone.", units = "m")
	private float approachZ;

	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 12, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	private final int messagePayloadLength = 61;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public SetHomePosition(short targetSystem, int latitude, int longitude, int altitude, float x, float y, float z, float[] q, float approachX, float approachY, float approachZ, BigInteger timeUsec) {
		this.targetSystem = targetSystem;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.x = x;
		this.y = y;
		this.z = z;
		this.q = q;
		this.approachX = approachX;
		this.approachY = approachY;
		this.approachZ = approachZ;
		this.timeUsec = timeUsec;
	}

	public SetHomePosition(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 61！");
		}
		messagePayload(messagePayload);
	}

	public SetHomePosition(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		latitude = byteArray.getInt32(1);
		longitude = byteArray.getInt32(5);
		altitude = byteArray.getInt32(9);
		x = byteArray.getFloat(13);
		y = byteArray.getFloat(17);
		z = byteArray.getFloat(21);
		q = byteArray.getFloatArray(25,4);
		approachX = byteArray.getFloat(41);
		approachY = byteArray.getFloat(45);
		approachZ = byteArray.getFloat(49);
		timeUsec = byteArray.getUnsignedInt64(53);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putInt32(latitude,1);
		byteArray.putInt32(longitude,5);
		byteArray.putInt32(altitude,9);
		byteArray.putFloat(x,13);
		byteArray.putFloat(y,17);
		byteArray.putFloat(z,21);
		byteArray.putFloatArray(q,25);
		byteArray.putFloat(approachX,41);
		byteArray.putFloat(approachY,45);
		byteArray.putFloat(approachZ,49);
		byteArray.putUnsignedInt64(timeUsec,53);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final SetHomePosition setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final SetHomePosition setLatitude(int latitude) {
		this.latitude = latitude;
		return this;
	}

	public final int getLatitude() {
		return latitude;
	}

	public final SetHomePosition setLongitude(int longitude) {
		this.longitude = longitude;
		return this;
	}

	public final int getLongitude() {
		return longitude;
	}

	public final SetHomePosition setAltitude(int altitude) {
		this.altitude = altitude;
		return this;
	}

	public final int getAltitude() {
		return altitude;
	}

	public final SetHomePosition setX(float x) {
		this.x = x;
		return this;
	}

	public final float getX() {
		return x;
	}

	public final SetHomePosition setY(float y) {
		this.y = y;
		return this;
	}

	public final float getY() {
		return y;
	}

	public final SetHomePosition setZ(float z) {
		this.z = z;
		return this;
	}

	public final float getZ() {
		return z;
	}

	public final SetHomePosition setQ(float[] q) {
		this.q = q;
		return this;
	}

	public final float[] getQ() {
		return q;
	}

	public final SetHomePosition setApproachX(float approachX) {
		this.approachX = approachX;
		return this;
	}

	public final float getApproachX() {
		return approachX;
	}

	public final SetHomePosition setApproachY(float approachY) {
		this.approachY = approachY;
		return this;
	}

	public final float getApproachY() {
		return approachY;
	}

	public final SetHomePosition setApproachZ(float approachZ) {
		this.approachZ = approachZ;
		return this;
	}

	public final float getApproachZ() {
		return approachZ;
	}

	public final SetHomePosition setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			SetHomePosition other = (SetHomePosition)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.latitude, other.latitude)) {
				return false;
			} else if (!Objects.deepEquals(this.longitude, other.longitude)) {
				return false;
			} else if (!Objects.deepEquals(this.altitude, other.altitude)) {
				return false;
			} else if (!Objects.deepEquals(this.x, other.x)) {
				return false;
			} else if (!Objects.deepEquals(this.y, other.y)) {
				return false;
			} else if (!Objects.deepEquals(this.z, other.z)) {
				return false;
			} else if (!Objects.deepEquals(this.q, other.q)) {
				return false;
			} else if (!Objects.deepEquals(this.approachX, other.approachX)) {
				return false;
			} else if (!Objects.deepEquals(this.approachY, other.approachY)) {
				return false;
			} else if (!Objects.deepEquals(this.approachZ, other.approachZ)) {
				return false;
			} else {
				return Objects.deepEquals(this.timeUsec, other.timeUsec);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.targetSystem);
		result = 31 * result + Objects.hashCode(this.latitude);
		result = 31 * result + Objects.hashCode(this.longitude);
		result = 31 * result + Objects.hashCode(this.altitude);
		result = 31 * result + Objects.hashCode(this.x);
		result = 31 * result + Objects.hashCode(this.y);
		result = 31 * result + Objects.hashCode(this.z);
		result = 31 * result + Objects.hashCode(this.q);
		result = 31 * result + Objects.hashCode(this.approachX);
		result = 31 * result + Objects.hashCode(this.approachY);
		result = 31 * result + Objects.hashCode(this.approachZ);
		result = 31 * result + Objects.hashCode(this.timeUsec);
		return result;
	}

	@Override
	public String toString() {
		return "SetHomePosition{" +
				"targetSystem=" + targetSystem +
				", latitude=" + latitude +
				", longitude=" + longitude +
				", altitude=" + altitude +
				", x=" + x +
				", y=" + y +
				", z=" + z +
				", q=" + Arrays.toString(q) +
				", approachX=" + approachX +
				", approachY=" + approachY +
				", approachZ=" + approachZ +
				", timeUsec=" + timeUsec +
				'}';
	}
}