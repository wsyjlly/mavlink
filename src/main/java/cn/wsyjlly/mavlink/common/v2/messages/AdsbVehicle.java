package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.AdsbEmitterType;
import cn.wsyjlly.mavlink.common.v2.enums.AdsbAltitudeType;
import cn.wsyjlly.mavlink.common.v2.enums.AdsbFlags;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.util.Arrays;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 246,
		messagePayloadLength = 38,
		description = "The location and information of an ADSB vehicle"
)
public class AdsbVehicle implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "ICAO address")
	private long icaoAddress;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 2, typeSize = 4, streamLength = 4, description = "Latitude", units = "degE7")
	private int lat;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 3, typeSize = 4, streamLength = 4, description = "Longitude", units = "degE7")
	private int lon;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "ADSB altitude type.", enum0 = AdsbAltitudeType.class)
	private short altitudeType;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 5, typeSize = 4, streamLength = 4, description = "Altitude(ASL)", units = "mm")
	private int altitude;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 6, typeSize = 2, streamLength = 2, description = "Course over ground", units = "cdeg")
	private int heading;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 7, typeSize = 2, streamLength = 2, description = "The horizontal velocity", units = "cm/s")
	private int horVelocity;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 8, typeSize = 2, streamLength = 2, description = "The vertical velocity. Positive is up", units = "cm/s")
	private short verVelocity;

	@MavlinkMessageParam(mavlinkType = "char", position = 9, typeSize = 1, streamLength = 9, description = "The callsign, 8+null")
	private String callsign;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 10, typeSize = 1, streamLength = 1, description = "ADSB emitter type.", enum0 = AdsbEmitterType.class)
	private short emitterType;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 11, typeSize = 1, streamLength = 1, description = "Time since last communication in seconds", units = "s")
	private short tslc;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 12, typeSize = 2, streamLength = 2, description = "Bitmap to indicate various statuses including valid data fields", enum0 = AdsbFlags.class)
	private int flags;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 13, typeSize = 2, streamLength = 2, description = "Squawk code")
	private int squawk;

	private final int messagePayloadLength = 38;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public AdsbVehicle(long icaoAddress, int lat, int lon, short altitudeType, int altitude, int heading, int horVelocity, short verVelocity, String callsign, short emitterType, short tslc, int flags, int squawk) {
		this.icaoAddress = icaoAddress;
		this.lat = lat;
		this.lon = lon;
		this.altitudeType = altitudeType;
		this.altitude = altitude;
		this.heading = heading;
		this.horVelocity = horVelocity;
		this.verVelocity = verVelocity;
		this.callsign = callsign;
		this.emitterType = emitterType;
		this.tslc = tslc;
		this.flags = flags;
		this.squawk = squawk;
	}

	public AdsbVehicle(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 38！");
		}
		messagePayload(messagePayload);
	}

	public AdsbVehicle(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		icaoAddress = byteArray.getUnsignedInt32(0);
		lat = byteArray.getInt32(4);
		lon = byteArray.getInt32(8);
		altitudeType = byteArray.getUnsignedInt8(12);
		altitude = byteArray.getInt32(13);
		heading = byteArray.getUnsignedInt16(17);
		horVelocity = byteArray.getUnsignedInt16(19);
		verVelocity = byteArray.getInt16(21);
		callsign = byteArray.getChars(23,9);
		emitterType = byteArray.getUnsignedInt8(32);
		tslc = byteArray.getUnsignedInt8(33);
		flags = byteArray.getUnsignedInt16(34);
		squawk = byteArray.getUnsignedInt16(36);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(icaoAddress,0);
		byteArray.putInt32(lat,4);
		byteArray.putInt32(lon,8);
		byteArray.putUnsignedInt8(altitudeType,12);
		byteArray.putInt32(altitude,13);
		byteArray.putUnsignedInt16(heading,17);
		byteArray.putUnsignedInt16(horVelocity,19);
		byteArray.putInt16(verVelocity,21);
		byteArray.putChars(callsign,23);
		byteArray.putUnsignedInt8(emitterType,32);
		byteArray.putUnsignedInt8(tslc,33);
		byteArray.putUnsignedInt16(flags,34);
		byteArray.putUnsignedInt16(squawk,36);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final AdsbVehicle setIcaoAddress(long icaoAddress) {
		this.icaoAddress = icaoAddress;
		return this;
	}

	public final long getIcaoAddress() {
		return icaoAddress;
	}

	public final AdsbVehicle setLat(int lat) {
		this.lat = lat;
		return this;
	}

	public final int getLat() {
		return lat;
	}

	public final AdsbVehicle setLon(int lon) {
		this.lon = lon;
		return this;
	}

	public final int getLon() {
		return lon;
	}

	public final AdsbVehicle setAltitudeType(short altitudeType) {
		this.altitudeType = altitudeType;
		return this;
	}

	public final short getAltitudeType() {
		return altitudeType;
	}

	public final AdsbVehicle setAltitude(int altitude) {
		this.altitude = altitude;
		return this;
	}

	public final int getAltitude() {
		return altitude;
	}

	public final AdsbVehicle setHeading(int heading) {
		this.heading = heading;
		return this;
	}

	public final int getHeading() {
		return heading;
	}

	public final AdsbVehicle setHorVelocity(int horVelocity) {
		this.horVelocity = horVelocity;
		return this;
	}

	public final int getHorVelocity() {
		return horVelocity;
	}

	public final AdsbVehicle setVerVelocity(short verVelocity) {
		this.verVelocity = verVelocity;
		return this;
	}

	public final short getVerVelocity() {
		return verVelocity;
	}

	public final AdsbVehicle setCallsign(String callsign) {
		this.callsign = callsign;
		return this;
	}

	public final String getCallsign() {
		return callsign;
	}

	public final AdsbVehicle setEmitterType(short emitterType) {
		this.emitterType = emitterType;
		return this;
	}

	public final short getEmitterType() {
		return emitterType;
	}

	public final AdsbVehicle setTslc(short tslc) {
		this.tslc = tslc;
		return this;
	}

	public final short getTslc() {
		return tslc;
	}

	public final AdsbVehicle setFlags(int flags) {
		this.flags = flags;
		return this;
	}

	public final int getFlags() {
		return flags;
	}

	public final AdsbVehicle setSquawk(int squawk) {
		this.squawk = squawk;
		return this;
	}

	public final int getSquawk() {
		return squawk;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			AdsbVehicle other = (AdsbVehicle)o;
			if (!Objects.deepEquals(this.icaoAddress, other.icaoAddress)) {
				return false;
			} else if (!Objects.deepEquals(this.lat, other.lat)) {
				return false;
			} else if (!Objects.deepEquals(this.lon, other.lon)) {
				return false;
			} else if (!Objects.deepEquals(this.altitudeType, other.altitudeType)) {
				return false;
			} else if (!Objects.deepEquals(this.altitude, other.altitude)) {
				return false;
			} else if (!Objects.deepEquals(this.heading, other.heading)) {
				return false;
			} else if (!Objects.deepEquals(this.horVelocity, other.horVelocity)) {
				return false;
			} else if (!Objects.deepEquals(this.verVelocity, other.verVelocity)) {
				return false;
			} else if (!Objects.deepEquals(this.callsign, other.callsign)) {
				return false;
			} else if (!Objects.deepEquals(this.emitterType, other.emitterType)) {
				return false;
			} else if (!Objects.deepEquals(this.tslc, other.tslc)) {
				return false;
			} else if (!Objects.deepEquals(this.flags, other.flags)) {
				return false;
			} else {
				return Objects.deepEquals(this.squawk, other.squawk);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.icaoAddress);
		result = 31 * result + Objects.hashCode(this.lat);
		result = 31 * result + Objects.hashCode(this.lon);
		result = 31 * result + Objects.hashCode(this.altitudeType);
		result = 31 * result + Objects.hashCode(this.altitude);
		result = 31 * result + Objects.hashCode(this.heading);
		result = 31 * result + Objects.hashCode(this.horVelocity);
		result = 31 * result + Objects.hashCode(this.verVelocity);
		result = 31 * result + Objects.hashCode(this.callsign);
		result = 31 * result + Objects.hashCode(this.emitterType);
		result = 31 * result + Objects.hashCode(this.tslc);
		result = 31 * result + Objects.hashCode(this.flags);
		result = 31 * result + Objects.hashCode(this.squawk);
		return result;
	}

	@Override
	public String toString() {
		return "AdsbVehicle{" +
				"icaoAddress=" + icaoAddress +
				", lat=" + lat +
				", lon=" + lon +
				", altitudeType=" + altitudeType +
				", altitude=" + altitude +
				", heading=" + heading +
				", horVelocity=" + horVelocity +
				", verVelocity=" + verVelocity +
				", callsign=" + callsign +
				", emitterType=" + emitterType +
				", tslc=" + tslc +
				", flags=" + flags +
				", squawk=" + squawk +
				'}';
	}
}