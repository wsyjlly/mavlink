package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavType;
import cn.wsyjlly.mavlink.common.v2.enums.MavAutopilot;
import cn.wsyjlly.mavlink.common.v2.enums.HlFailureFlag;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 235,
		messagePayloadLength = 42,
		description = "Message appropriate for high latency connections like Iridium (version 2)"
)
public class HighLatency2 implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp (milliseconds since boot or Unix epoch)", units = "ms")
	private long timestamp;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Type of the MAV (quadrotor, helicopter, etc.)", enum0 = MavType.class)
	private short type;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not flight controllers.", enum0 = MavAutopilot.class)
	private short autopilot;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 4, typeSize = 2, streamLength = 2, description = "A bitfield for use for autopilot-specific flags (2 byte version).")
	private int customMode;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 5, typeSize = 4, streamLength = 4, description = "Latitude", units = "degE7")
	private int latitude;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 6, typeSize = 4, streamLength = 4, description = "Longitude", units = "degE7")
	private int longitude;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 7, typeSize = 2, streamLength = 2, description = "Altitude above mean sea level", units = "m")
	private short altitude;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 8, typeSize = 2, streamLength = 2, description = "Altitude setpoint", units = "m")
	private short targetAltitude;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 9, typeSize = 1, streamLength = 1, description = "Heading", units = "deg/2")
	private short heading;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 10, typeSize = 1, streamLength = 1, description = "Heading setpoint", units = "deg/2")
	private short targetHeading;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 11, typeSize = 2, streamLength = 2, description = "Distance to target waypoint or position", units = "dam")
	private int targetDistance;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 12, typeSize = 1, streamLength = 1, description = "Throttle", units = "%")
	private short throttle;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 13, typeSize = 1, streamLength = 1, description = "Airspeed", units = "m/s*5")
	private short airspeed;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 14, typeSize = 1, streamLength = 1, description = "Airspeed setpoint", units = "m/s*5")
	private short airspeedSp;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 15, typeSize = 1, streamLength = 1, description = "Groundspeed", units = "m/s*5")
	private short groundspeed;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 16, typeSize = 1, streamLength = 1, description = "Windspeed", units = "m/s*5")
	private short windspeed;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 17, typeSize = 1, streamLength = 1, description = "Wind heading", units = "deg/2")
	private short windHeading;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 18, typeSize = 1, streamLength = 1, description = "Maximum error horizontal position since last message", units = "dm")
	private short eph;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 19, typeSize = 1, streamLength = 1, description = "Maximum error vertical position since last message", units = "dm")
	private short epv;

	@MavlinkMessageParam(mavlinkType = "int8_t", position = 20, typeSize = 1, streamLength = 1, description = "Air temperature from airspeed sensor", units = "degC")
	private byte temperatureAir;

	@MavlinkMessageParam(mavlinkType = "int8_t", position = 21, typeSize = 1, streamLength = 1, description = "Maximum climb rate magnitude since last message", units = "dm/s")
	private byte climbRate;

	@MavlinkMessageParam(mavlinkType = "int8_t", position = 22, typeSize = 1, streamLength = 1, description = "Battery level (-1 if field not provided).", units = "%")
	private byte battery;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 23, typeSize = 2, streamLength = 2, description = "Current waypoint number")
	private int wpNum;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 24, typeSize = 2, streamLength = 2, description = "Bitmap of failure flags.", enum0 = HlFailureFlag.class)
	private int failureFlags;

	@MavlinkMessageParam(mavlinkType = "int8_t", position = 25, typeSize = 1, streamLength = 1, description = "Field for custom payload.")
	private byte custom0;

	@MavlinkMessageParam(mavlinkType = "int8_t", position = 26, typeSize = 1, streamLength = 1, description = "Field for custom payload.")
	private byte custom1;

	@MavlinkMessageParam(mavlinkType = "int8_t", position = 27, typeSize = 1, streamLength = 1, description = "Field for custom payload.")
	private byte custom2;

	private final int messagePayloadLength = 42;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public HighLatency2(long timestamp, short type, short autopilot, int customMode, int latitude, int longitude, short altitude, short targetAltitude, short heading, short targetHeading, int targetDistance, short throttle, short airspeed, short airspeedSp, short groundspeed, short windspeed, short windHeading, short eph, short epv, byte temperatureAir, byte climbRate, byte battery, int wpNum, int failureFlags, byte custom0, byte custom1, byte custom2) {
		this.timestamp = timestamp;
		this.type = type;
		this.autopilot = autopilot;
		this.customMode = customMode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.targetAltitude = targetAltitude;
		this.heading = heading;
		this.targetHeading = targetHeading;
		this.targetDistance = targetDistance;
		this.throttle = throttle;
		this.airspeed = airspeed;
		this.airspeedSp = airspeedSp;
		this.groundspeed = groundspeed;
		this.windspeed = windspeed;
		this.windHeading = windHeading;
		this.eph = eph;
		this.epv = epv;
		this.temperatureAir = temperatureAir;
		this.climbRate = climbRate;
		this.battery = battery;
		this.wpNum = wpNum;
		this.failureFlags = failureFlags;
		this.custom0 = custom0;
		this.custom1 = custom1;
		this.custom2 = custom2;
	}

	public HighLatency2(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 42！");
		}
		messagePayload(messagePayload);
	}

	public HighLatency2(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timestamp = byteArray.getUnsignedInt32(0);
		type = byteArray.getUnsignedInt8(4);
		autopilot = byteArray.getUnsignedInt8(5);
		customMode = byteArray.getUnsignedInt16(6);
		latitude = byteArray.getInt32(8);
		longitude = byteArray.getInt32(12);
		altitude = byteArray.getInt16(16);
		targetAltitude = byteArray.getInt16(18);
		heading = byteArray.getUnsignedInt8(20);
		targetHeading = byteArray.getUnsignedInt8(21);
		targetDistance = byteArray.getUnsignedInt16(22);
		throttle = byteArray.getUnsignedInt8(24);
		airspeed = byteArray.getUnsignedInt8(25);
		airspeedSp = byteArray.getUnsignedInt8(26);
		groundspeed = byteArray.getUnsignedInt8(27);
		windspeed = byteArray.getUnsignedInt8(28);
		windHeading = byteArray.getUnsignedInt8(29);
		eph = byteArray.getUnsignedInt8(30);
		epv = byteArray.getUnsignedInt8(31);
		temperatureAir = byteArray.getInt8(32);
		climbRate = byteArray.getInt8(33);
		battery = byteArray.getInt8(34);
		wpNum = byteArray.getUnsignedInt16(35);
		failureFlags = byteArray.getUnsignedInt16(37);
		custom0 = byteArray.getInt8(39);
		custom1 = byteArray.getInt8(40);
		custom2 = byteArray.getInt8(41);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timestamp,0);
		byteArray.putUnsignedInt8(type,4);
		byteArray.putUnsignedInt8(autopilot,5);
		byteArray.putUnsignedInt16(customMode,6);
		byteArray.putInt32(latitude,8);
		byteArray.putInt32(longitude,12);
		byteArray.putInt16(altitude,16);
		byteArray.putInt16(targetAltitude,18);
		byteArray.putUnsignedInt8(heading,20);
		byteArray.putUnsignedInt8(targetHeading,21);
		byteArray.putUnsignedInt16(targetDistance,22);
		byteArray.putUnsignedInt8(throttle,24);
		byteArray.putUnsignedInt8(airspeed,25);
		byteArray.putUnsignedInt8(airspeedSp,26);
		byteArray.putUnsignedInt8(groundspeed,27);
		byteArray.putUnsignedInt8(windspeed,28);
		byteArray.putUnsignedInt8(windHeading,29);
		byteArray.putUnsignedInt8(eph,30);
		byteArray.putUnsignedInt8(epv,31);
		byteArray.putInt8(temperatureAir,32);
		byteArray.putInt8(climbRate,33);
		byteArray.putInt8(battery,34);
		byteArray.putUnsignedInt16(wpNum,35);
		byteArray.putUnsignedInt16(failureFlags,37);
		byteArray.putInt8(custom0,39);
		byteArray.putInt8(custom1,40);
		byteArray.putInt8(custom2,41);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final HighLatency2 setTimestamp(long timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	public final long getTimestamp() {
		return timestamp;
	}

	public final HighLatency2 setType(short type) {
		this.type = type;
		return this;
	}

	public final short getType() {
		return type;
	}

	public final HighLatency2 setAutopilot(short autopilot) {
		this.autopilot = autopilot;
		return this;
	}

	public final short getAutopilot() {
		return autopilot;
	}

	public final HighLatency2 setCustomMode(int customMode) {
		this.customMode = customMode;
		return this;
	}

	public final int getCustomMode() {
		return customMode;
	}

	public final HighLatency2 setLatitude(int latitude) {
		this.latitude = latitude;
		return this;
	}

	public final int getLatitude() {
		return latitude;
	}

	public final HighLatency2 setLongitude(int longitude) {
		this.longitude = longitude;
		return this;
	}

	public final int getLongitude() {
		return longitude;
	}

	public final HighLatency2 setAltitude(short altitude) {
		this.altitude = altitude;
		return this;
	}

	public final short getAltitude() {
		return altitude;
	}

	public final HighLatency2 setTargetAltitude(short targetAltitude) {
		this.targetAltitude = targetAltitude;
		return this;
	}

	public final short getTargetAltitude() {
		return targetAltitude;
	}

	public final HighLatency2 setHeading(short heading) {
		this.heading = heading;
		return this;
	}

	public final short getHeading() {
		return heading;
	}

	public final HighLatency2 setTargetHeading(short targetHeading) {
		this.targetHeading = targetHeading;
		return this;
	}

	public final short getTargetHeading() {
		return targetHeading;
	}

	public final HighLatency2 setTargetDistance(int targetDistance) {
		this.targetDistance = targetDistance;
		return this;
	}

	public final int getTargetDistance() {
		return targetDistance;
	}

	public final HighLatency2 setThrottle(short throttle) {
		this.throttle = throttle;
		return this;
	}

	public final short getThrottle() {
		return throttle;
	}

	public final HighLatency2 setAirspeed(short airspeed) {
		this.airspeed = airspeed;
		return this;
	}

	public final short getAirspeed() {
		return airspeed;
	}

	public final HighLatency2 setAirspeedSp(short airspeedSp) {
		this.airspeedSp = airspeedSp;
		return this;
	}

	public final short getAirspeedSp() {
		return airspeedSp;
	}

	public final HighLatency2 setGroundspeed(short groundspeed) {
		this.groundspeed = groundspeed;
		return this;
	}

	public final short getGroundspeed() {
		return groundspeed;
	}

	public final HighLatency2 setWindspeed(short windspeed) {
		this.windspeed = windspeed;
		return this;
	}

	public final short getWindspeed() {
		return windspeed;
	}

	public final HighLatency2 setWindHeading(short windHeading) {
		this.windHeading = windHeading;
		return this;
	}

	public final short getWindHeading() {
		return windHeading;
	}

	public final HighLatency2 setEph(short eph) {
		this.eph = eph;
		return this;
	}

	public final short getEph() {
		return eph;
	}

	public final HighLatency2 setEpv(short epv) {
		this.epv = epv;
		return this;
	}

	public final short getEpv() {
		return epv;
	}

	public final HighLatency2 setTemperatureAir(byte temperatureAir) {
		this.temperatureAir = temperatureAir;
		return this;
	}

	public final byte getTemperatureAir() {
		return temperatureAir;
	}

	public final HighLatency2 setClimbRate(byte climbRate) {
		this.climbRate = climbRate;
		return this;
	}

	public final byte getClimbRate() {
		return climbRate;
	}

	public final HighLatency2 setBattery(byte battery) {
		this.battery = battery;
		return this;
	}

	public final byte getBattery() {
		return battery;
	}

	public final HighLatency2 setWpNum(int wpNum) {
		this.wpNum = wpNum;
		return this;
	}

	public final int getWpNum() {
		return wpNum;
	}

	public final HighLatency2 setFailureFlags(int failureFlags) {
		this.failureFlags = failureFlags;
		return this;
	}

	public final int getFailureFlags() {
		return failureFlags;
	}

	public final HighLatency2 setCustom0(byte custom0) {
		this.custom0 = custom0;
		return this;
	}

	public final byte getCustom0() {
		return custom0;
	}

	public final HighLatency2 setCustom1(byte custom1) {
		this.custom1 = custom1;
		return this;
	}

	public final byte getCustom1() {
		return custom1;
	}

	public final HighLatency2 setCustom2(byte custom2) {
		this.custom2 = custom2;
		return this;
	}

	public final byte getCustom2() {
		return custom2;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			HighLatency2 other = (HighLatency2)o;
			if (!Objects.deepEquals(this.timestamp, other.timestamp)) {
				return false;
			} else if (!Objects.deepEquals(this.type, other.type)) {
				return false;
			} else if (!Objects.deepEquals(this.autopilot, other.autopilot)) {
				return false;
			} else if (!Objects.deepEquals(this.customMode, other.customMode)) {
				return false;
			} else if (!Objects.deepEquals(this.latitude, other.latitude)) {
				return false;
			} else if (!Objects.deepEquals(this.longitude, other.longitude)) {
				return false;
			} else if (!Objects.deepEquals(this.altitude, other.altitude)) {
				return false;
			} else if (!Objects.deepEquals(this.targetAltitude, other.targetAltitude)) {
				return false;
			} else if (!Objects.deepEquals(this.heading, other.heading)) {
				return false;
			} else if (!Objects.deepEquals(this.targetHeading, other.targetHeading)) {
				return false;
			} else if (!Objects.deepEquals(this.targetDistance, other.targetDistance)) {
				return false;
			} else if (!Objects.deepEquals(this.throttle, other.throttle)) {
				return false;
			} else if (!Objects.deepEquals(this.airspeed, other.airspeed)) {
				return false;
			} else if (!Objects.deepEquals(this.airspeedSp, other.airspeedSp)) {
				return false;
			} else if (!Objects.deepEquals(this.groundspeed, other.groundspeed)) {
				return false;
			} else if (!Objects.deepEquals(this.windspeed, other.windspeed)) {
				return false;
			} else if (!Objects.deepEquals(this.windHeading, other.windHeading)) {
				return false;
			} else if (!Objects.deepEquals(this.eph, other.eph)) {
				return false;
			} else if (!Objects.deepEquals(this.epv, other.epv)) {
				return false;
			} else if (!Objects.deepEquals(this.temperatureAir, other.temperatureAir)) {
				return false;
			} else if (!Objects.deepEquals(this.climbRate, other.climbRate)) {
				return false;
			} else if (!Objects.deepEquals(this.battery, other.battery)) {
				return false;
			} else if (!Objects.deepEquals(this.wpNum, other.wpNum)) {
				return false;
			} else if (!Objects.deepEquals(this.failureFlags, other.failureFlags)) {
				return false;
			} else if (!Objects.deepEquals(this.custom0, other.custom0)) {
				return false;
			} else if (!Objects.deepEquals(this.custom1, other.custom1)) {
				return false;
			} else {
				return Objects.deepEquals(this.custom2, other.custom2);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timestamp);
		result = 31 * result + Objects.hashCode(this.type);
		result = 31 * result + Objects.hashCode(this.autopilot);
		result = 31 * result + Objects.hashCode(this.customMode);
		result = 31 * result + Objects.hashCode(this.latitude);
		result = 31 * result + Objects.hashCode(this.longitude);
		result = 31 * result + Objects.hashCode(this.altitude);
		result = 31 * result + Objects.hashCode(this.targetAltitude);
		result = 31 * result + Objects.hashCode(this.heading);
		result = 31 * result + Objects.hashCode(this.targetHeading);
		result = 31 * result + Objects.hashCode(this.targetDistance);
		result = 31 * result + Objects.hashCode(this.throttle);
		result = 31 * result + Objects.hashCode(this.airspeed);
		result = 31 * result + Objects.hashCode(this.airspeedSp);
		result = 31 * result + Objects.hashCode(this.groundspeed);
		result = 31 * result + Objects.hashCode(this.windspeed);
		result = 31 * result + Objects.hashCode(this.windHeading);
		result = 31 * result + Objects.hashCode(this.eph);
		result = 31 * result + Objects.hashCode(this.epv);
		result = 31 * result + Objects.hashCode(this.temperatureAir);
		result = 31 * result + Objects.hashCode(this.climbRate);
		result = 31 * result + Objects.hashCode(this.battery);
		result = 31 * result + Objects.hashCode(this.wpNum);
		result = 31 * result + Objects.hashCode(this.failureFlags);
		result = 31 * result + Objects.hashCode(this.custom0);
		result = 31 * result + Objects.hashCode(this.custom1);
		result = 31 * result + Objects.hashCode(this.custom2);
		return result;
	}

	@Override
	public String toString() {
		return "HighLatency2{" +
				"timestamp=" + timestamp +
				", type=" + type +
				", autopilot=" + autopilot +
				", customMode=" + customMode +
				", latitude=" + latitude +
				", longitude=" + longitude +
				", altitude=" + altitude +
				", targetAltitude=" + targetAltitude +
				", heading=" + heading +
				", targetHeading=" + targetHeading +
				", targetDistance=" + targetDistance +
				", throttle=" + throttle +
				", airspeed=" + airspeed +
				", airspeedSp=" + airspeedSp +
				", groundspeed=" + groundspeed +
				", windspeed=" + windspeed +
				", windHeading=" + windHeading +
				", eph=" + eph +
				", epv=" + epv +
				", temperatureAir=" + temperatureAir +
				", climbRate=" + climbRate +
				", battery=" + battery +
				", wpNum=" + wpNum +
				", failureFlags=" + failureFlags +
				", custom0=" + custom0 +
				", custom1=" + custom1 +
				", custom2=" + custom2 +
				'}';
	}
}