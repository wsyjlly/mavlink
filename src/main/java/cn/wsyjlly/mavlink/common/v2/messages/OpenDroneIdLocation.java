package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavOdidStatus;
import cn.wsyjlly.mavlink.common.v2.enums.MavOdidVerAcc;
import cn.wsyjlly.mavlink.common.v2.enums.MavOdidHorAcc;
import cn.wsyjlly.mavlink.common.v2.enums.MavOdidTimeAcc;
import cn.wsyjlly.mavlink.common.v2.enums.MavOdidSpeedAcc;
import cn.wsyjlly.mavlink.common.v2.enums.MavOdidHeightRef;
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
		id = 12901,
		messagePayloadLength = 59,
		description = "Data for filling the OpenDroneID Location message. The float data types are 32-bit IEEE 754. The Location message provides the location, altitude, direction and speed of the aircraft."
)
public class OpenDroneIdLocation implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID (0 for broadcast).")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID (0 for broadcast).")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 20, description = "Only used for drone ID data received from other UAs. See detailed description at https://mavlink.io/en/services/opendroneid.html.")
	private short[] idOrMac = new short[20];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "Indicates whether the unmanned aircraft is on the ground or in the air.", enum0 = MavOdidStatus.class)
	private short status;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 5, typeSize = 2, streamLength = 2, description = "Direction over ground (not heading, but direction of movement) measured clockwise from true North: 0 - 35999 centi-degrees. If unknown: 36100 centi-degrees.", units = "cdeg")
	private int direction;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 6, typeSize = 2, streamLength = 2, description = "Ground speed. Positive only. If unknown: 25500 cm/s. If speed is larger than 25425 cm/s, use 25425 cm/s.", units = "cm/s")
	private int speedHorizontal;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 7, typeSize = 2, streamLength = 2, description = "The vertical speed. Up is positive. If unknown: 6300 cm/s. If speed is larger than 6200 cm/s, use 6200 cm/s. If lower than -6200 cm/s, use -6200 cm/s.", units = "cm/s")
	private short speedVertical;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 8, typeSize = 4, streamLength = 4, description = "Current latitude of the unmanned aircraft. If unknown: 0 (both Lat/Lon).", units = "degE7")
	private int latitude;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 9, typeSize = 4, streamLength = 4, description = "Current longitude of the unmanned aircraft. If unknown: 0 (both Lat/Lon).", units = "degE7")
	private int longitude;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4, description = "The altitude calculated from the barometric pressue. Reference is against 29.92inHg or 1013.2mb. If unknown: -1000 m.", units = "m")
	private float altitudeBarometric;

	@MavlinkMessageParam(mavlinkType = "float", position = 11, typeSize = 4, streamLength = 4, description = "The geodetic altitude as defined by WGS84. If unknown: -1000 m.", units = "m")
	private float altitudeGeodetic;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 12, typeSize = 1, streamLength = 1, description = "Indicates the reference point for the height field.", enum0 = MavOdidHeightRef.class)
	private short heightReference;

	@MavlinkMessageParam(mavlinkType = "float", position = 13, typeSize = 4, streamLength = 4, description = "The current height of the unmanned aircraft above the take-off location or the ground as indicated by height_reference. If unknown: -1000 m.", units = "m")
	private float height;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 14, typeSize = 1, streamLength = 1, description = "The accuracy of the horizontal position.", enum0 = MavOdidHorAcc.class)
	private short horizontalAccuracy;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 15, typeSize = 1, streamLength = 1, description = "The accuracy of the vertical position.", enum0 = MavOdidVerAcc.class)
	private short verticalAccuracy;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 16, typeSize = 1, streamLength = 1, description = "The accuracy of the barometric altitude.", enum0 = MavOdidVerAcc.class)
	private short barometerAccuracy;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 17, typeSize = 1, streamLength = 1, description = "The accuracy of the horizontal and vertical speed.", enum0 = MavOdidSpeedAcc.class)
	private short speedAccuracy;

	@MavlinkMessageParam(mavlinkType = "float", position = 18, typeSize = 4, streamLength = 4, description = "Seconds after the full hour with reference to UTC time. Typically the GPS outputs a time-of-week value in milliseconds. First convert that to UTC and then convert for this field using ((float) (time_week_ms % (60*60*1000))) / 1000.", units = "s")
	private float timestamp;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 19, typeSize = 1, streamLength = 1, description = "The accuracy of the timestamps.", enum0 = MavOdidTimeAcc.class)
	private short timestampAccuracy;

	private final int messagePayloadLength = 59;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public OpenDroneIdLocation(short targetSystem, short targetComponent, short[] idOrMac, short status, int direction, int speedHorizontal, short speedVertical, int latitude, int longitude, float altitudeBarometric, float altitudeGeodetic, short heightReference, float height, short horizontalAccuracy, short verticalAccuracy, short barometerAccuracy, short speedAccuracy, float timestamp, short timestampAccuracy) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.idOrMac = idOrMac;
		this.status = status;
		this.direction = direction;
		this.speedHorizontal = speedHorizontal;
		this.speedVertical = speedVertical;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitudeBarometric = altitudeBarometric;
		this.altitudeGeodetic = altitudeGeodetic;
		this.heightReference = heightReference;
		this.height = height;
		this.horizontalAccuracy = horizontalAccuracy;
		this.verticalAccuracy = verticalAccuracy;
		this.barometerAccuracy = barometerAccuracy;
		this.speedAccuracy = speedAccuracy;
		this.timestamp = timestamp;
		this.timestampAccuracy = timestampAccuracy;
	}

	public OpenDroneIdLocation(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 59！");
		}
		messagePayload(messagePayload);
	}

	public OpenDroneIdLocation(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		idOrMac = byteArray.getUnsignedInt8Array(2,20);
		status = byteArray.getUnsignedInt8(22);
		direction = byteArray.getUnsignedInt16(23);
		speedHorizontal = byteArray.getUnsignedInt16(25);
		speedVertical = byteArray.getInt16(27);
		latitude = byteArray.getInt32(29);
		longitude = byteArray.getInt32(33);
		altitudeBarometric = byteArray.getFloat(37);
		altitudeGeodetic = byteArray.getFloat(41);
		heightReference = byteArray.getUnsignedInt8(45);
		height = byteArray.getFloat(46);
		horizontalAccuracy = byteArray.getUnsignedInt8(50);
		verticalAccuracy = byteArray.getUnsignedInt8(51);
		barometerAccuracy = byteArray.getUnsignedInt8(52);
		speedAccuracy = byteArray.getUnsignedInt8(53);
		timestamp = byteArray.getFloat(54);
		timestampAccuracy = byteArray.getUnsignedInt8(58);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putUnsignedInt8Array(idOrMac,2);
		byteArray.putUnsignedInt8(status,22);
		byteArray.putUnsignedInt16(direction,23);
		byteArray.putUnsignedInt16(speedHorizontal,25);
		byteArray.putInt16(speedVertical,27);
		byteArray.putInt32(latitude,29);
		byteArray.putInt32(longitude,33);
		byteArray.putFloat(altitudeBarometric,37);
		byteArray.putFloat(altitudeGeodetic,41);
		byteArray.putUnsignedInt8(heightReference,45);
		byteArray.putFloat(height,46);
		byteArray.putUnsignedInt8(horizontalAccuracy,50);
		byteArray.putUnsignedInt8(verticalAccuracy,51);
		byteArray.putUnsignedInt8(barometerAccuracy,52);
		byteArray.putUnsignedInt8(speedAccuracy,53);
		byteArray.putFloat(timestamp,54);
		byteArray.putUnsignedInt8(timestampAccuracy,58);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final OpenDroneIdLocation setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final OpenDroneIdLocation setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final OpenDroneIdLocation setIdOrMac(short[] idOrMac) {
		this.idOrMac = idOrMac;
		return this;
	}

	public final short[] getIdOrMac() {
		return idOrMac;
	}

	public final OpenDroneIdLocation setStatus(short status) {
		this.status = status;
		return this;
	}

	public final short getStatus() {
		return status;
	}

	public final OpenDroneIdLocation setDirection(int direction) {
		this.direction = direction;
		return this;
	}

	public final int getDirection() {
		return direction;
	}

	public final OpenDroneIdLocation setSpeedHorizontal(int speedHorizontal) {
		this.speedHorizontal = speedHorizontal;
		return this;
	}

	public final int getSpeedHorizontal() {
		return speedHorizontal;
	}

	public final OpenDroneIdLocation setSpeedVertical(short speedVertical) {
		this.speedVertical = speedVertical;
		return this;
	}

	public final short getSpeedVertical() {
		return speedVertical;
	}

	public final OpenDroneIdLocation setLatitude(int latitude) {
		this.latitude = latitude;
		return this;
	}

	public final int getLatitude() {
		return latitude;
	}

	public final OpenDroneIdLocation setLongitude(int longitude) {
		this.longitude = longitude;
		return this;
	}

	public final int getLongitude() {
		return longitude;
	}

	public final OpenDroneIdLocation setAltitudeBarometric(float altitudeBarometric) {
		this.altitudeBarometric = altitudeBarometric;
		return this;
	}

	public final float getAltitudeBarometric() {
		return altitudeBarometric;
	}

	public final OpenDroneIdLocation setAltitudeGeodetic(float altitudeGeodetic) {
		this.altitudeGeodetic = altitudeGeodetic;
		return this;
	}

	public final float getAltitudeGeodetic() {
		return altitudeGeodetic;
	}

	public final OpenDroneIdLocation setHeightReference(short heightReference) {
		this.heightReference = heightReference;
		return this;
	}

	public final short getHeightReference() {
		return heightReference;
	}

	public final OpenDroneIdLocation setHeight(float height) {
		this.height = height;
		return this;
	}

	public final float getHeight() {
		return height;
	}

	public final OpenDroneIdLocation setHorizontalAccuracy(short horizontalAccuracy) {
		this.horizontalAccuracy = horizontalAccuracy;
		return this;
	}

	public final short getHorizontalAccuracy() {
		return horizontalAccuracy;
	}

	public final OpenDroneIdLocation setVerticalAccuracy(short verticalAccuracy) {
		this.verticalAccuracy = verticalAccuracy;
		return this;
	}

	public final short getVerticalAccuracy() {
		return verticalAccuracy;
	}

	public final OpenDroneIdLocation setBarometerAccuracy(short barometerAccuracy) {
		this.barometerAccuracy = barometerAccuracy;
		return this;
	}

	public final short getBarometerAccuracy() {
		return barometerAccuracy;
	}

	public final OpenDroneIdLocation setSpeedAccuracy(short speedAccuracy) {
		this.speedAccuracy = speedAccuracy;
		return this;
	}

	public final short getSpeedAccuracy() {
		return speedAccuracy;
	}

	public final OpenDroneIdLocation setTimestamp(float timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	public final float getTimestamp() {
		return timestamp;
	}

	public final OpenDroneIdLocation setTimestampAccuracy(short timestampAccuracy) {
		this.timestampAccuracy = timestampAccuracy;
		return this;
	}

	public final short getTimestampAccuracy() {
		return timestampAccuracy;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			OpenDroneIdLocation other = (OpenDroneIdLocation)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.idOrMac, other.idOrMac)) {
				return false;
			} else if (!Objects.deepEquals(this.status, other.status)) {
				return false;
			} else if (!Objects.deepEquals(this.direction, other.direction)) {
				return false;
			} else if (!Objects.deepEquals(this.speedHorizontal, other.speedHorizontal)) {
				return false;
			} else if (!Objects.deepEquals(this.speedVertical, other.speedVertical)) {
				return false;
			} else if (!Objects.deepEquals(this.latitude, other.latitude)) {
				return false;
			} else if (!Objects.deepEquals(this.longitude, other.longitude)) {
				return false;
			} else if (!Objects.deepEquals(this.altitudeBarometric, other.altitudeBarometric)) {
				return false;
			} else if (!Objects.deepEquals(this.altitudeGeodetic, other.altitudeGeodetic)) {
				return false;
			} else if (!Objects.deepEquals(this.heightReference, other.heightReference)) {
				return false;
			} else if (!Objects.deepEquals(this.height, other.height)) {
				return false;
			} else if (!Objects.deepEquals(this.horizontalAccuracy, other.horizontalAccuracy)) {
				return false;
			} else if (!Objects.deepEquals(this.verticalAccuracy, other.verticalAccuracy)) {
				return false;
			} else if (!Objects.deepEquals(this.barometerAccuracy, other.barometerAccuracy)) {
				return false;
			} else if (!Objects.deepEquals(this.speedAccuracy, other.speedAccuracy)) {
				return false;
			} else if (!Objects.deepEquals(this.timestamp, other.timestamp)) {
				return false;
			} else {
				return Objects.deepEquals(this.timestampAccuracy, other.timestampAccuracy);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.targetSystem);
		result = 31 * result + Objects.hashCode(this.targetComponent);
		result = 31 * result + Objects.hashCode(this.idOrMac);
		result = 31 * result + Objects.hashCode(this.status);
		result = 31 * result + Objects.hashCode(this.direction);
		result = 31 * result + Objects.hashCode(this.speedHorizontal);
		result = 31 * result + Objects.hashCode(this.speedVertical);
		result = 31 * result + Objects.hashCode(this.latitude);
		result = 31 * result + Objects.hashCode(this.longitude);
		result = 31 * result + Objects.hashCode(this.altitudeBarometric);
		result = 31 * result + Objects.hashCode(this.altitudeGeodetic);
		result = 31 * result + Objects.hashCode(this.heightReference);
		result = 31 * result + Objects.hashCode(this.height);
		result = 31 * result + Objects.hashCode(this.horizontalAccuracy);
		result = 31 * result + Objects.hashCode(this.verticalAccuracy);
		result = 31 * result + Objects.hashCode(this.barometerAccuracy);
		result = 31 * result + Objects.hashCode(this.speedAccuracy);
		result = 31 * result + Objects.hashCode(this.timestamp);
		result = 31 * result + Objects.hashCode(this.timestampAccuracy);
		return result;
	}

	@Override
	public String toString() {
		return "OpenDroneIdLocation{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", idOrMac=" + Arrays.toString(idOrMac) +
				", status=" + status +
				", direction=" + direction +
				", speedHorizontal=" + speedHorizontal +
				", speedVertical=" + speedVertical +
				", latitude=" + latitude +
				", longitude=" + longitude +
				", altitudeBarometric=" + altitudeBarometric +
				", altitudeGeodetic=" + altitudeGeodetic +
				", heightReference=" + heightReference +
				", height=" + height +
				", horizontalAccuracy=" + horizontalAccuracy +
				", verticalAccuracy=" + verticalAccuracy +
				", barometerAccuracy=" + barometerAccuracy +
				", speedAccuracy=" + speedAccuracy +
				", timestamp=" + timestamp +
				", timestampAccuracy=" + timestampAccuracy +
				'}';
	}
}