package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavLandedState;
import cn.wsyjlly.mavlink.common.v2.enums.MavModeFlag;
import cn.wsyjlly.mavlink.common.v2.enums.GpsFixType;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 234,
		messagePayloadLength = 40,
		description = "Message appropriate for high latency connections like Iridium"
)
public class HighLatency implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "Bitmap of enabled system modes.", enum0 = MavModeFlag.class)
	private short baseMode;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 2, typeSize = 4, streamLength = 4, description = "A bitfield for use for autopilot-specific flags.")
	private long customMode;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown.", enum0 = MavLandedState.class)
	private short landedState;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 4, typeSize = 2, streamLength = 2, description = "roll", units = "cdeg")
	private short roll;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 5, typeSize = 2, streamLength = 2, description = "pitch", units = "cdeg")
	private short pitch;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 6, typeSize = 2, streamLength = 2, description = "heading", units = "cdeg")
	private int heading;

	@MavlinkMessageParam(mavlinkType = "int8_t", position = 7, typeSize = 1, streamLength = 1, description = "throttle (percentage)", units = "%")
	private byte throttle;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 8, typeSize = 2, streamLength = 2, description = "heading setpoint", units = "cdeg")
	private short headingSp;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 9, typeSize = 4, streamLength = 4, description = "Latitude", units = "degE7")
	private int latitude;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 10, typeSize = 4, streamLength = 4, description = "Longitude", units = "degE7")
	private int longitude;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 11, typeSize = 2, streamLength = 2, description = "Altitude above mean sea level", units = "m")
	private short altitudeAmsl;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 12, typeSize = 2, streamLength = 2, description = "Altitude setpoint relative to the home position", units = "m")
	private short altitudeSp;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 13, typeSize = 1, streamLength = 1, description = "airspeed", units = "m/s")
	private short airspeed;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 14, typeSize = 1, streamLength = 1, description = "airspeed setpoint", units = "m/s")
	private short airspeedSp;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 15, typeSize = 1, streamLength = 1, description = "groundspeed", units = "m/s")
	private short groundspeed;

	@MavlinkMessageParam(mavlinkType = "int8_t", position = 16, typeSize = 1, streamLength = 1, description = "climb rate", units = "m/s")
	private byte climbRate;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 17, typeSize = 1, streamLength = 1, description = "Number of satellites visible. If unknown, set to 255")
	private short gpsNsat;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 18, typeSize = 1, streamLength = 1, description = "GPS Fix type.", enum0 = GpsFixType.class)
	private short gpsFixType;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 19, typeSize = 1, streamLength = 1, description = "Remaining battery (percentage)", units = "%")
	private short batteryRemaining;

	@MavlinkMessageParam(mavlinkType = "int8_t", position = 20, typeSize = 1, streamLength = 1, description = "Autopilot temperature (degrees C)", units = "degC")
	private byte temperature;

	@MavlinkMessageParam(mavlinkType = "int8_t", position = 21, typeSize = 1, streamLength = 1, description = "Air temperature (degrees C) from airspeed sensor", units = "degC")
	private byte temperatureAir;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 22, typeSize = 1, streamLength = 1, description = "failsafe (each bit represents a failsafe where 0=ok, 1=failsafe active (bit0:RC, bit1:batt, bit2:GPS, bit3:GCS, bit4:fence)")
	private short failsafe;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 23, typeSize = 1, streamLength = 1, description = "current waypoint number")
	private short wpNum;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 24, typeSize = 2, streamLength = 2, description = "distance to target", units = "m")
	private int wpDistance;

	private final int messagePayloadLength = 40;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public HighLatency(short baseMode, long customMode, short landedState, short roll, short pitch, int heading, byte throttle, short headingSp, int latitude, int longitude, short altitudeAmsl, short altitudeSp, short airspeed, short airspeedSp, short groundspeed, byte climbRate, short gpsNsat, short gpsFixType, short batteryRemaining, byte temperature, byte temperatureAir, short failsafe, short wpNum, int wpDistance) {
		this.baseMode = baseMode;
		this.customMode = customMode;
		this.landedState = landedState;
		this.roll = roll;
		this.pitch = pitch;
		this.heading = heading;
		this.throttle = throttle;
		this.headingSp = headingSp;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitudeAmsl = altitudeAmsl;
		this.altitudeSp = altitudeSp;
		this.airspeed = airspeed;
		this.airspeedSp = airspeedSp;
		this.groundspeed = groundspeed;
		this.climbRate = climbRate;
		this.gpsNsat = gpsNsat;
		this.gpsFixType = gpsFixType;
		this.batteryRemaining = batteryRemaining;
		this.temperature = temperature;
		this.temperatureAir = temperatureAir;
		this.failsafe = failsafe;
		this.wpNum = wpNum;
		this.wpDistance = wpDistance;
	}

	public HighLatency(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 40！");
		}
		messagePayload(messagePayload);
	}

	public HighLatency(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		baseMode = byteArray.getUnsignedInt8(0);
		customMode = byteArray.getUnsignedInt32(1);
		landedState = byteArray.getUnsignedInt8(5);
		roll = byteArray.getInt16(6);
		pitch = byteArray.getInt16(8);
		heading = byteArray.getUnsignedInt16(10);
		throttle = byteArray.getInt8(12);
		headingSp = byteArray.getInt16(13);
		latitude = byteArray.getInt32(15);
		longitude = byteArray.getInt32(19);
		altitudeAmsl = byteArray.getInt16(23);
		altitudeSp = byteArray.getInt16(25);
		airspeed = byteArray.getUnsignedInt8(27);
		airspeedSp = byteArray.getUnsignedInt8(28);
		groundspeed = byteArray.getUnsignedInt8(29);
		climbRate = byteArray.getInt8(30);
		gpsNsat = byteArray.getUnsignedInt8(31);
		gpsFixType = byteArray.getUnsignedInt8(32);
		batteryRemaining = byteArray.getUnsignedInt8(33);
		temperature = byteArray.getInt8(34);
		temperatureAir = byteArray.getInt8(35);
		failsafe = byteArray.getUnsignedInt8(36);
		wpNum = byteArray.getUnsignedInt8(37);
		wpDistance = byteArray.getUnsignedInt16(38);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(baseMode,0);
		byteArray.putUnsignedInt32(customMode,1);
		byteArray.putUnsignedInt8(landedState,5);
		byteArray.putInt16(roll,6);
		byteArray.putInt16(pitch,8);
		byteArray.putUnsignedInt16(heading,10);
		byteArray.putInt8(throttle,12);
		byteArray.putInt16(headingSp,13);
		byteArray.putInt32(latitude,15);
		byteArray.putInt32(longitude,19);
		byteArray.putInt16(altitudeAmsl,23);
		byteArray.putInt16(altitudeSp,25);
		byteArray.putUnsignedInt8(airspeed,27);
		byteArray.putUnsignedInt8(airspeedSp,28);
		byteArray.putUnsignedInt8(groundspeed,29);
		byteArray.putInt8(climbRate,30);
		byteArray.putUnsignedInt8(gpsNsat,31);
		byteArray.putUnsignedInt8(gpsFixType,32);
		byteArray.putUnsignedInt8(batteryRemaining,33);
		byteArray.putInt8(temperature,34);
		byteArray.putInt8(temperatureAir,35);
		byteArray.putUnsignedInt8(failsafe,36);
		byteArray.putUnsignedInt8(wpNum,37);
		byteArray.putUnsignedInt16(wpDistance,38);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final HighLatency setBaseMode(short baseMode) {
		this.baseMode = baseMode;
		return this;
	}

	public final short getBaseMode() {
		return baseMode;
	}

	public final HighLatency setCustomMode(long customMode) {
		this.customMode = customMode;
		return this;
	}

	public final long getCustomMode() {
		return customMode;
	}

	public final HighLatency setLandedState(short landedState) {
		this.landedState = landedState;
		return this;
	}

	public final short getLandedState() {
		return landedState;
	}

	public final HighLatency setRoll(short roll) {
		this.roll = roll;
		return this;
	}

	public final short getRoll() {
		return roll;
	}

	public final HighLatency setPitch(short pitch) {
		this.pitch = pitch;
		return this;
	}

	public final short getPitch() {
		return pitch;
	}

	public final HighLatency setHeading(int heading) {
		this.heading = heading;
		return this;
	}

	public final int getHeading() {
		return heading;
	}

	public final HighLatency setThrottle(byte throttle) {
		this.throttle = throttle;
		return this;
	}

	public final byte getThrottle() {
		return throttle;
	}

	public final HighLatency setHeadingSp(short headingSp) {
		this.headingSp = headingSp;
		return this;
	}

	public final short getHeadingSp() {
		return headingSp;
	}

	public final HighLatency setLatitude(int latitude) {
		this.latitude = latitude;
		return this;
	}

	public final int getLatitude() {
		return latitude;
	}

	public final HighLatency setLongitude(int longitude) {
		this.longitude = longitude;
		return this;
	}

	public final int getLongitude() {
		return longitude;
	}

	public final HighLatency setAltitudeAmsl(short altitudeAmsl) {
		this.altitudeAmsl = altitudeAmsl;
		return this;
	}

	public final short getAltitudeAmsl() {
		return altitudeAmsl;
	}

	public final HighLatency setAltitudeSp(short altitudeSp) {
		this.altitudeSp = altitudeSp;
		return this;
	}

	public final short getAltitudeSp() {
		return altitudeSp;
	}

	public final HighLatency setAirspeed(short airspeed) {
		this.airspeed = airspeed;
		return this;
	}

	public final short getAirspeed() {
		return airspeed;
	}

	public final HighLatency setAirspeedSp(short airspeedSp) {
		this.airspeedSp = airspeedSp;
		return this;
	}

	public final short getAirspeedSp() {
		return airspeedSp;
	}

	public final HighLatency setGroundspeed(short groundspeed) {
		this.groundspeed = groundspeed;
		return this;
	}

	public final short getGroundspeed() {
		return groundspeed;
	}

	public final HighLatency setClimbRate(byte climbRate) {
		this.climbRate = climbRate;
		return this;
	}

	public final byte getClimbRate() {
		return climbRate;
	}

	public final HighLatency setGpsNsat(short gpsNsat) {
		this.gpsNsat = gpsNsat;
		return this;
	}

	public final short getGpsNsat() {
		return gpsNsat;
	}

	public final HighLatency setGpsFixType(short gpsFixType) {
		this.gpsFixType = gpsFixType;
		return this;
	}

	public final short getGpsFixType() {
		return gpsFixType;
	}

	public final HighLatency setBatteryRemaining(short batteryRemaining) {
		this.batteryRemaining = batteryRemaining;
		return this;
	}

	public final short getBatteryRemaining() {
		return batteryRemaining;
	}

	public final HighLatency setTemperature(byte temperature) {
		this.temperature = temperature;
		return this;
	}

	public final byte getTemperature() {
		return temperature;
	}

	public final HighLatency setTemperatureAir(byte temperatureAir) {
		this.temperatureAir = temperatureAir;
		return this;
	}

	public final byte getTemperatureAir() {
		return temperatureAir;
	}

	public final HighLatency setFailsafe(short failsafe) {
		this.failsafe = failsafe;
		return this;
	}

	public final short getFailsafe() {
		return failsafe;
	}

	public final HighLatency setWpNum(short wpNum) {
		this.wpNum = wpNum;
		return this;
	}

	public final short getWpNum() {
		return wpNum;
	}

	public final HighLatency setWpDistance(int wpDistance) {
		this.wpDistance = wpDistance;
		return this;
	}

	public final int getWpDistance() {
		return wpDistance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			HighLatency other = (HighLatency)o;
			if (!Objects.deepEquals(this.baseMode, other.baseMode)) {
				return false;
			} else if (!Objects.deepEquals(this.customMode, other.customMode)) {
				return false;
			} else if (!Objects.deepEquals(this.landedState, other.landedState)) {
				return false;
			} else if (!Objects.deepEquals(this.roll, other.roll)) {
				return false;
			} else if (!Objects.deepEquals(this.pitch, other.pitch)) {
				return false;
			} else if (!Objects.deepEquals(this.heading, other.heading)) {
				return false;
			} else if (!Objects.deepEquals(this.throttle, other.throttle)) {
				return false;
			} else if (!Objects.deepEquals(this.headingSp, other.headingSp)) {
				return false;
			} else if (!Objects.deepEquals(this.latitude, other.latitude)) {
				return false;
			} else if (!Objects.deepEquals(this.longitude, other.longitude)) {
				return false;
			} else if (!Objects.deepEquals(this.altitudeAmsl, other.altitudeAmsl)) {
				return false;
			} else if (!Objects.deepEquals(this.altitudeSp, other.altitudeSp)) {
				return false;
			} else if (!Objects.deepEquals(this.airspeed, other.airspeed)) {
				return false;
			} else if (!Objects.deepEquals(this.airspeedSp, other.airspeedSp)) {
				return false;
			} else if (!Objects.deepEquals(this.groundspeed, other.groundspeed)) {
				return false;
			} else if (!Objects.deepEquals(this.climbRate, other.climbRate)) {
				return false;
			} else if (!Objects.deepEquals(this.gpsNsat, other.gpsNsat)) {
				return false;
			} else if (!Objects.deepEquals(this.gpsFixType, other.gpsFixType)) {
				return false;
			} else if (!Objects.deepEquals(this.batteryRemaining, other.batteryRemaining)) {
				return false;
			} else if (!Objects.deepEquals(this.temperature, other.temperature)) {
				return false;
			} else if (!Objects.deepEquals(this.temperatureAir, other.temperatureAir)) {
				return false;
			} else if (!Objects.deepEquals(this.failsafe, other.failsafe)) {
				return false;
			} else if (!Objects.deepEquals(this.wpNum, other.wpNum)) {
				return false;
			} else {
				return Objects.deepEquals(this.wpDistance, other.wpDistance);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.baseMode);
		result = 31 * result + Objects.hashCode(this.customMode);
		result = 31 * result + Objects.hashCode(this.landedState);
		result = 31 * result + Objects.hashCode(this.roll);
		result = 31 * result + Objects.hashCode(this.pitch);
		result = 31 * result + Objects.hashCode(this.heading);
		result = 31 * result + Objects.hashCode(this.throttle);
		result = 31 * result + Objects.hashCode(this.headingSp);
		result = 31 * result + Objects.hashCode(this.latitude);
		result = 31 * result + Objects.hashCode(this.longitude);
		result = 31 * result + Objects.hashCode(this.altitudeAmsl);
		result = 31 * result + Objects.hashCode(this.altitudeSp);
		result = 31 * result + Objects.hashCode(this.airspeed);
		result = 31 * result + Objects.hashCode(this.airspeedSp);
		result = 31 * result + Objects.hashCode(this.groundspeed);
		result = 31 * result + Objects.hashCode(this.climbRate);
		result = 31 * result + Objects.hashCode(this.gpsNsat);
		result = 31 * result + Objects.hashCode(this.gpsFixType);
		result = 31 * result + Objects.hashCode(this.batteryRemaining);
		result = 31 * result + Objects.hashCode(this.temperature);
		result = 31 * result + Objects.hashCode(this.temperatureAir);
		result = 31 * result + Objects.hashCode(this.failsafe);
		result = 31 * result + Objects.hashCode(this.wpNum);
		result = 31 * result + Objects.hashCode(this.wpDistance);
		return result;
	}

	@Override
	public String toString() {
		return "HighLatency{" +
				"baseMode=" + baseMode +
				", customMode=" + customMode +
				", landedState=" + landedState +
				", roll=" + roll +
				", pitch=" + pitch +
				", heading=" + heading +
				", throttle=" + throttle +
				", headingSp=" + headingSp +
				", latitude=" + latitude +
				", longitude=" + longitude +
				", altitudeAmsl=" + altitudeAmsl +
				", altitudeSp=" + altitudeSp +
				", airspeed=" + airspeed +
				", airspeedSp=" + airspeedSp +
				", groundspeed=" + groundspeed +
				", climbRate=" + climbRate +
				", gpsNsat=" + gpsNsat +
				", gpsFixType=" + gpsFixType +
				", batteryRemaining=" + batteryRemaining +
				", temperature=" + temperature +
				", temperatureAir=" + temperatureAir +
				", failsafe=" + failsafe +
				", wpNum=" + wpNum +
				", wpDistance=" + wpDistance +
				'}';
	}
}