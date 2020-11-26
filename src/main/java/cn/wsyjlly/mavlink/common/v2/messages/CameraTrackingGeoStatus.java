package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.CameraTrackingStatusFlags;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 276,
		messagePayloadLength = 49,
		description = "Camera tracking status, sent while in active tracking. Use MAV_CMD_SET_MESSAGE_INTERVAL to define message interval."
)
public class CameraTrackingGeoStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "Current tracking status", enum0 = CameraTrackingStatusFlags.class)
	private short trackingStatus;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 2, typeSize = 4, streamLength = 4, description = "Latitude of tracked object", units = "degE7")
	private int lat;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 3, typeSize = 4, streamLength = 4, description = "Longitude of tracked object", units = "degE7")
	private int lon;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "Altitude of tracked object(AMSL, WGS84)", units = "m")
	private float alt;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Horizontal accuracy. NAN if unknown", units = "m")
	private float hAcc;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Vertical accuracy. NAN if unknown", units = "m")
	private float vAcc;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "North velocity of tracked object. NAN if unknown", units = "m/s")
	private float velN;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "East velocity of tracked object. NAN if unknown", units = "m/s")
	private float velE;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4, description = "Down velocity of tracked object. NAN if unknown", units = "m/s")
	private float velD;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4, description = "Velocity accuracy. NAN if unknown", units = "m/s")
	private float velAcc;

	@MavlinkMessageParam(mavlinkType = "float", position = 11, typeSize = 4, streamLength = 4, description = "Distance between camera and tracked object. NAN if unknown", units = "m")
	private float dist;

	@MavlinkMessageParam(mavlinkType = "float", position = 12, typeSize = 4, streamLength = 4, description = "Heading in radians, in NED. NAN if unknown", units = "rad")
	private float hdg;

	@MavlinkMessageParam(mavlinkType = "float", position = 13, typeSize = 4, streamLength = 4, description = "Accuracy of heading, in NED. NAN if unknown", units = "rad")
	private float hdgAcc;

	private final int messagePayloadLength = 49;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public CameraTrackingGeoStatus(short trackingStatus, int lat, int lon, float alt, float hAcc, float vAcc, float velN, float velE, float velD, float velAcc, float dist, float hdg, float hdgAcc) {
		this.trackingStatus = trackingStatus;
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
		this.hAcc = hAcc;
		this.vAcc = vAcc;
		this.velN = velN;
		this.velE = velE;
		this.velD = velD;
		this.velAcc = velAcc;
		this.dist = dist;
		this.hdg = hdg;
		this.hdgAcc = hdgAcc;
	}

	public CameraTrackingGeoStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 49！");
		}
		messagePayload(messagePayload);
	}

	public CameraTrackingGeoStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		trackingStatus = byteArray.getUnsignedInt8(0);
		lat = byteArray.getInt32(1);
		lon = byteArray.getInt32(5);
		alt = byteArray.getFloat(9);
		hAcc = byteArray.getFloat(13);
		vAcc = byteArray.getFloat(17);
		velN = byteArray.getFloat(21);
		velE = byteArray.getFloat(25);
		velD = byteArray.getFloat(29);
		velAcc = byteArray.getFloat(33);
		dist = byteArray.getFloat(37);
		hdg = byteArray.getFloat(41);
		hdgAcc = byteArray.getFloat(45);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(trackingStatus,0);
		byteArray.putInt32(lat,1);
		byteArray.putInt32(lon,5);
		byteArray.putFloat(alt,9);
		byteArray.putFloat(hAcc,13);
		byteArray.putFloat(vAcc,17);
		byteArray.putFloat(velN,21);
		byteArray.putFloat(velE,25);
		byteArray.putFloat(velD,29);
		byteArray.putFloat(velAcc,33);
		byteArray.putFloat(dist,37);
		byteArray.putFloat(hdg,41);
		byteArray.putFloat(hdgAcc,45);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final CameraTrackingGeoStatus setTrackingStatus(short trackingStatus) {
		this.trackingStatus = trackingStatus;
		return this;
	}

	public final short getTrackingStatus() {
		return trackingStatus;
	}

	public final CameraTrackingGeoStatus setLat(int lat) {
		this.lat = lat;
		return this;
	}

	public final int getLat() {
		return lat;
	}

	public final CameraTrackingGeoStatus setLon(int lon) {
		this.lon = lon;
		return this;
	}

	public final int getLon() {
		return lon;
	}

	public final CameraTrackingGeoStatus setAlt(float alt) {
		this.alt = alt;
		return this;
	}

	public final float getAlt() {
		return alt;
	}

	public final CameraTrackingGeoStatus setHAcc(float hAcc) {
		this.hAcc = hAcc;
		return this;
	}

	public final float getHAcc() {
		return hAcc;
	}

	public final CameraTrackingGeoStatus setVAcc(float vAcc) {
		this.vAcc = vAcc;
		return this;
	}

	public final float getVAcc() {
		return vAcc;
	}

	public final CameraTrackingGeoStatus setVelN(float velN) {
		this.velN = velN;
		return this;
	}

	public final float getVelN() {
		return velN;
	}

	public final CameraTrackingGeoStatus setVelE(float velE) {
		this.velE = velE;
		return this;
	}

	public final float getVelE() {
		return velE;
	}

	public final CameraTrackingGeoStatus setVelD(float velD) {
		this.velD = velD;
		return this;
	}

	public final float getVelD() {
		return velD;
	}

	public final CameraTrackingGeoStatus setVelAcc(float velAcc) {
		this.velAcc = velAcc;
		return this;
	}

	public final float getVelAcc() {
		return velAcc;
	}

	public final CameraTrackingGeoStatus setDist(float dist) {
		this.dist = dist;
		return this;
	}

	public final float getDist() {
		return dist;
	}

	public final CameraTrackingGeoStatus setHdg(float hdg) {
		this.hdg = hdg;
		return this;
	}

	public final float getHdg() {
		return hdg;
	}

	public final CameraTrackingGeoStatus setHdgAcc(float hdgAcc) {
		this.hdgAcc = hdgAcc;
		return this;
	}

	public final float getHdgAcc() {
		return hdgAcc;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			CameraTrackingGeoStatus other = (CameraTrackingGeoStatus)o;
			if (!Objects.deepEquals(this.trackingStatus, other.trackingStatus)) {
				return false;
			} else if (!Objects.deepEquals(this.lat, other.lat)) {
				return false;
			} else if (!Objects.deepEquals(this.lon, other.lon)) {
				return false;
			} else if (!Objects.deepEquals(this.alt, other.alt)) {
				return false;
			} else if (!Objects.deepEquals(this.hAcc, other.hAcc)) {
				return false;
			} else if (!Objects.deepEquals(this.vAcc, other.vAcc)) {
				return false;
			} else if (!Objects.deepEquals(this.velN, other.velN)) {
				return false;
			} else if (!Objects.deepEquals(this.velE, other.velE)) {
				return false;
			} else if (!Objects.deepEquals(this.velD, other.velD)) {
				return false;
			} else if (!Objects.deepEquals(this.velAcc, other.velAcc)) {
				return false;
			} else if (!Objects.deepEquals(this.dist, other.dist)) {
				return false;
			} else if (!Objects.deepEquals(this.hdg, other.hdg)) {
				return false;
			} else {
				return Objects.deepEquals(this.hdgAcc, other.hdgAcc);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.trackingStatus);
		result = 31 * result + Objects.hashCode(this.lat);
		result = 31 * result + Objects.hashCode(this.lon);
		result = 31 * result + Objects.hashCode(this.alt);
		result = 31 * result + Objects.hashCode(this.hAcc);
		result = 31 * result + Objects.hashCode(this.vAcc);
		result = 31 * result + Objects.hashCode(this.velN);
		result = 31 * result + Objects.hashCode(this.velE);
		result = 31 * result + Objects.hashCode(this.velD);
		result = 31 * result + Objects.hashCode(this.velAcc);
		result = 31 * result + Objects.hashCode(this.dist);
		result = 31 * result + Objects.hashCode(this.hdg);
		result = 31 * result + Objects.hashCode(this.hdgAcc);
		return result;
	}

	@Override
	public String toString() {
		return "CameraTrackingGeoStatus{" +
				"trackingStatus=" + trackingStatus +
				", lat=" + lat +
				", lon=" + lon +
				", alt=" + alt +
				", hAcc=" + hAcc +
				", vAcc=" + vAcc +
				", velN=" + velN +
				", velE=" + velE +
				", velD=" + velD +
				", velAcc=" + velAcc +
				", dist=" + dist +
				", hdg=" + hdg +
				", hdgAcc=" + hdgAcc +
				'}';
	}
}