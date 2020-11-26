package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.AisNavStatus;
import cn.wsyjlly.mavlink.common.v2.enums.AisFlags;
import cn.wsyjlly.mavlink.common.v2.enums.AisType;
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
		id = 301,
		messagePayloadLength = 58,
		description = "The location and information of an AIS vessel"
)
public class AisVessel implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Mobile Marine Service Identifier, 9 decimal digits")
	private long mmsi;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 2, typeSize = 4, streamLength = 4, description = "Latitude", units = "degE7")
	private int lat;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 3, typeSize = 4, streamLength = 4, description = "Longitude", units = "degE7")
	private int lon;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 4, typeSize = 2, streamLength = 2, description = "Course over ground", units = "cdeg")
	private int cog;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 5, typeSize = 2, streamLength = 2, description = "True heading", units = "cdeg")
	private int heading;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 6, typeSize = 2, streamLength = 2, description = "Speed over ground", units = "cm/s")
	private int velocity;

	@MavlinkMessageParam(mavlinkType = "int8_t", position = 7, typeSize = 1, streamLength = 1, description = "Turn rate", units = "cdeg/s")
	private byte turnRate;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 8, typeSize = 1, streamLength = 1, description = "Navigational status", enum0 = AisNavStatus.class)
	private short navigationalStatus;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 9, typeSize = 1, streamLength = 1, description = "Type of vessels", enum0 = AisType.class)
	private short type;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 10, typeSize = 2, streamLength = 2, description = "Distance from lat/lon location to bow", units = "m")
	private int dimensionBow;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 11, typeSize = 2, streamLength = 2, description = "Distance from lat/lon location to stern", units = "m")
	private int dimensionStern;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 12, typeSize = 1, streamLength = 1, description = "Distance from lat/lon location to port side", units = "m")
	private short dimensionPort;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 13, typeSize = 1, streamLength = 1, description = "Distance from lat/lon location to starboard side", units = "m")
	private short dimensionStarboard;

	@MavlinkMessageParam(mavlinkType = "char", position = 14, typeSize = 1, streamLength = 7, description = "The vessel callsign")
	private String callsign;

	@MavlinkMessageParam(mavlinkType = "char", position = 15, typeSize = 1, streamLength = 20, description = "The vessel name")
	private String name;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 16, typeSize = 2, streamLength = 2, description = "Time since last communication in seconds", units = "s")
	private int tslc;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 17, typeSize = 2, streamLength = 2, description = "Bitmask to indicate various statuses including valid data fields", enum0 = AisFlags.class)
	private int flags;

	private final int messagePayloadLength = 58;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public AisVessel(long mmsi, int lat, int lon, int cog, int heading, int velocity, byte turnRate, short navigationalStatus, short type, int dimensionBow, int dimensionStern, short dimensionPort, short dimensionStarboard, String callsign, String name, int tslc, int flags) {
		this.mmsi = mmsi;
		this.lat = lat;
		this.lon = lon;
		this.cog = cog;
		this.heading = heading;
		this.velocity = velocity;
		this.turnRate = turnRate;
		this.navigationalStatus = navigationalStatus;
		this.type = type;
		this.dimensionBow = dimensionBow;
		this.dimensionStern = dimensionStern;
		this.dimensionPort = dimensionPort;
		this.dimensionStarboard = dimensionStarboard;
		this.callsign = callsign;
		this.name = name;
		this.tslc = tslc;
		this.flags = flags;
	}

	public AisVessel(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 58！");
		}
		messagePayload(messagePayload);
	}

	public AisVessel(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		mmsi = byteArray.getUnsignedInt32(0);
		lat = byteArray.getInt32(4);
		lon = byteArray.getInt32(8);
		cog = byteArray.getUnsignedInt16(12);
		heading = byteArray.getUnsignedInt16(14);
		velocity = byteArray.getUnsignedInt16(16);
		turnRate = byteArray.getInt8(18);
		navigationalStatus = byteArray.getUnsignedInt8(19);
		type = byteArray.getUnsignedInt8(20);
		dimensionBow = byteArray.getUnsignedInt16(21);
		dimensionStern = byteArray.getUnsignedInt16(23);
		dimensionPort = byteArray.getUnsignedInt8(25);
		dimensionStarboard = byteArray.getUnsignedInt8(26);
		callsign = byteArray.getChars(27,7);
		name = byteArray.getChars(34,20);
		tslc = byteArray.getUnsignedInt16(54);
		flags = byteArray.getUnsignedInt16(56);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(mmsi,0);
		byteArray.putInt32(lat,4);
		byteArray.putInt32(lon,8);
		byteArray.putUnsignedInt16(cog,12);
		byteArray.putUnsignedInt16(heading,14);
		byteArray.putUnsignedInt16(velocity,16);
		byteArray.putInt8(turnRate,18);
		byteArray.putUnsignedInt8(navigationalStatus,19);
		byteArray.putUnsignedInt8(type,20);
		byteArray.putUnsignedInt16(dimensionBow,21);
		byteArray.putUnsignedInt16(dimensionStern,23);
		byteArray.putUnsignedInt8(dimensionPort,25);
		byteArray.putUnsignedInt8(dimensionStarboard,26);
		byteArray.putChars(callsign,27);
		byteArray.putChars(name,34);
		byteArray.putUnsignedInt16(tslc,54);
		byteArray.putUnsignedInt16(flags,56);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final AisVessel setMmsi(long mmsi) {
		this.mmsi = mmsi;
		return this;
	}

	public final long getMmsi() {
		return mmsi;
	}

	public final AisVessel setLat(int lat) {
		this.lat = lat;
		return this;
	}

	public final int getLat() {
		return lat;
	}

	public final AisVessel setLon(int lon) {
		this.lon = lon;
		return this;
	}

	public final int getLon() {
		return lon;
	}

	public final AisVessel setCog(int cog) {
		this.cog = cog;
		return this;
	}

	public final int getCog() {
		return cog;
	}

	public final AisVessel setHeading(int heading) {
		this.heading = heading;
		return this;
	}

	public final int getHeading() {
		return heading;
	}

	public final AisVessel setVelocity(int velocity) {
		this.velocity = velocity;
		return this;
	}

	public final int getVelocity() {
		return velocity;
	}

	public final AisVessel setTurnRate(byte turnRate) {
		this.turnRate = turnRate;
		return this;
	}

	public final byte getTurnRate() {
		return turnRate;
	}

	public final AisVessel setNavigationalStatus(short navigationalStatus) {
		this.navigationalStatus = navigationalStatus;
		return this;
	}

	public final short getNavigationalStatus() {
		return navigationalStatus;
	}

	public final AisVessel setType(short type) {
		this.type = type;
		return this;
	}

	public final short getType() {
		return type;
	}

	public final AisVessel setDimensionBow(int dimensionBow) {
		this.dimensionBow = dimensionBow;
		return this;
	}

	public final int getDimensionBow() {
		return dimensionBow;
	}

	public final AisVessel setDimensionStern(int dimensionStern) {
		this.dimensionStern = dimensionStern;
		return this;
	}

	public final int getDimensionStern() {
		return dimensionStern;
	}

	public final AisVessel setDimensionPort(short dimensionPort) {
		this.dimensionPort = dimensionPort;
		return this;
	}

	public final short getDimensionPort() {
		return dimensionPort;
	}

	public final AisVessel setDimensionStarboard(short dimensionStarboard) {
		this.dimensionStarboard = dimensionStarboard;
		return this;
	}

	public final short getDimensionStarboard() {
		return dimensionStarboard;
	}

	public final AisVessel setCallsign(String callsign) {
		this.callsign = callsign;
		return this;
	}

	public final String getCallsign() {
		return callsign;
	}

	public final AisVessel setName(String name) {
		this.name = name;
		return this;
	}

	public final String getName() {
		return name;
	}

	public final AisVessel setTslc(int tslc) {
		this.tslc = tslc;
		return this;
	}

	public final int getTslc() {
		return tslc;
	}

	public final AisVessel setFlags(int flags) {
		this.flags = flags;
		return this;
	}

	public final int getFlags() {
		return flags;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			AisVessel other = (AisVessel)o;
			if (!Objects.deepEquals(this.mmsi, other.mmsi)) {
				return false;
			} else if (!Objects.deepEquals(this.lat, other.lat)) {
				return false;
			} else if (!Objects.deepEquals(this.lon, other.lon)) {
				return false;
			} else if (!Objects.deepEquals(this.cog, other.cog)) {
				return false;
			} else if (!Objects.deepEquals(this.heading, other.heading)) {
				return false;
			} else if (!Objects.deepEquals(this.velocity, other.velocity)) {
				return false;
			} else if (!Objects.deepEquals(this.turnRate, other.turnRate)) {
				return false;
			} else if (!Objects.deepEquals(this.navigationalStatus, other.navigationalStatus)) {
				return false;
			} else if (!Objects.deepEquals(this.type, other.type)) {
				return false;
			} else if (!Objects.deepEquals(this.dimensionBow, other.dimensionBow)) {
				return false;
			} else if (!Objects.deepEquals(this.dimensionStern, other.dimensionStern)) {
				return false;
			} else if (!Objects.deepEquals(this.dimensionPort, other.dimensionPort)) {
				return false;
			} else if (!Objects.deepEquals(this.dimensionStarboard, other.dimensionStarboard)) {
				return false;
			} else if (!Objects.deepEquals(this.callsign, other.callsign)) {
				return false;
			} else if (!Objects.deepEquals(this.name, other.name)) {
				return false;
			} else if (!Objects.deepEquals(this.tslc, other.tslc)) {
				return false;
			} else {
				return Objects.deepEquals(this.flags, other.flags);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.mmsi);
		result = 31 * result + Objects.hashCode(this.lat);
		result = 31 * result + Objects.hashCode(this.lon);
		result = 31 * result + Objects.hashCode(this.cog);
		result = 31 * result + Objects.hashCode(this.heading);
		result = 31 * result + Objects.hashCode(this.velocity);
		result = 31 * result + Objects.hashCode(this.turnRate);
		result = 31 * result + Objects.hashCode(this.navigationalStatus);
		result = 31 * result + Objects.hashCode(this.type);
		result = 31 * result + Objects.hashCode(this.dimensionBow);
		result = 31 * result + Objects.hashCode(this.dimensionStern);
		result = 31 * result + Objects.hashCode(this.dimensionPort);
		result = 31 * result + Objects.hashCode(this.dimensionStarboard);
		result = 31 * result + Objects.hashCode(this.callsign);
		result = 31 * result + Objects.hashCode(this.name);
		result = 31 * result + Objects.hashCode(this.tslc);
		result = 31 * result + Objects.hashCode(this.flags);
		return result;
	}

	@Override
	public String toString() {
		return "AisVessel{" +
				"mmsi=" + mmsi +
				", lat=" + lat +
				", lon=" + lon +
				", cog=" + cog +
				", heading=" + heading +
				", velocity=" + velocity +
				", turnRate=" + turnRate +
				", navigationalStatus=" + navigationalStatus +
				", type=" + type +
				", dimensionBow=" + dimensionBow +
				", dimensionStern=" + dimensionStern +
				", dimensionPort=" + dimensionPort +
				", dimensionStarboard=" + dimensionStarboard +
				", callsign=" + callsign +
				", name=" + name +
				", tslc=" + tslc +
				", flags=" + flags +
				'}';
	}
}