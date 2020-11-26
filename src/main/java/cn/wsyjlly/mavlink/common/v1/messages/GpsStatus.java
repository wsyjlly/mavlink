package cn.wsyjlly.mavlink.common.v1.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.util.Arrays;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkMessage(
		id = 25,
		messagePayloadLength = 101,
		description = "The positioning status, as reported by GPS. This message is intended to display status information about each satellite visible to the receiver. See message GLOBAL_POSITION for the global position estimate. This message can contain information for up to 20 satellites."
)
public class GpsStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "Number of satellites visible")
	private short satellitesVisible;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 20, description = "Global satellite ID")
	private short[] satellitePrn = new short[20];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 20, description = "0: Satellite not used, 1: used for localization")
	private short[] satelliteUsed = new short[20];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 20, description = "Elevation (0: right on top of receiver, 90: on the horizon) of satellite")
	private short[] satelliteElevation = new short[20];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 20, description = "Direction of satellite, 0: 0 deg, 255: 360 deg.")
	private short[] satelliteAzimuth = new short[20];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 20, description = "Signal to noise ratio of satellite")
	private short[] satelliteSnr = new short[20];

	private final int messagePayloadLength = 101;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public GpsStatus(short satellitesVisible, short[] satellitePrn, short[] satelliteUsed, short[] satelliteElevation, short[] satelliteAzimuth, short[] satelliteSnr) {
		this.satellitesVisible = satellitesVisible;
		this.satellitePrn = satellitePrn;
		this.satelliteUsed = satelliteUsed;
		this.satelliteElevation = satelliteElevation;
		this.satelliteAzimuth = satelliteAzimuth;
		this.satelliteSnr = satelliteSnr;
	}

	public GpsStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 101！");
		}
		messagePayload(messagePayload);
	}

	public GpsStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		satellitesVisible = byteArray.getUnsignedInt8(0);
		satellitePrn = byteArray.getUnsignedInt8Array(1,20);
		satelliteUsed = byteArray.getUnsignedInt8Array(21,20);
		satelliteElevation = byteArray.getUnsignedInt8Array(41,20);
		satelliteAzimuth = byteArray.getUnsignedInt8Array(61,20);
		satelliteSnr = byteArray.getUnsignedInt8Array(81,20);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(satellitesVisible,0);
		byteArray.putUnsignedInt8Array(satellitePrn,1);
		byteArray.putUnsignedInt8Array(satelliteUsed,21);
		byteArray.putUnsignedInt8Array(satelliteElevation,41);
		byteArray.putUnsignedInt8Array(satelliteAzimuth,61);
		byteArray.putUnsignedInt8Array(satelliteSnr,81);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final GpsStatus setSatellitesVisible(short satellitesVisible) {
		this.satellitesVisible = satellitesVisible;
		return this;
	}

	public final short getSatellitesVisible() {
		return satellitesVisible;
	}

	public final GpsStatus setSatellitePrn(short[] satellitePrn) {
		this.satellitePrn = satellitePrn;
		return this;
	}

	public final short[] getSatellitePrn() {
		return satellitePrn;
	}

	public final GpsStatus setSatelliteUsed(short[] satelliteUsed) {
		this.satelliteUsed = satelliteUsed;
		return this;
	}

	public final short[] getSatelliteUsed() {
		return satelliteUsed;
	}

	public final GpsStatus setSatelliteElevation(short[] satelliteElevation) {
		this.satelliteElevation = satelliteElevation;
		return this;
	}

	public final short[] getSatelliteElevation() {
		return satelliteElevation;
	}

	public final GpsStatus setSatelliteAzimuth(short[] satelliteAzimuth) {
		this.satelliteAzimuth = satelliteAzimuth;
		return this;
	}

	public final short[] getSatelliteAzimuth() {
		return satelliteAzimuth;
	}

	public final GpsStatus setSatelliteSnr(short[] satelliteSnr) {
		this.satelliteSnr = satelliteSnr;
		return this;
	}

	public final short[] getSatelliteSnr() {
		return satelliteSnr;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			GpsStatus other = (GpsStatus)o;
			if (!Objects.deepEquals(this.satellitesVisible, other.satellitesVisible)) {
				return false;
			} else if (!Objects.deepEquals(this.satellitePrn, other.satellitePrn)) {
				return false;
			} else if (!Objects.deepEquals(this.satelliteUsed, other.satelliteUsed)) {
				return false;
			} else if (!Objects.deepEquals(this.satelliteElevation, other.satelliteElevation)) {
				return false;
			} else if (!Objects.deepEquals(this.satelliteAzimuth, other.satelliteAzimuth)) {
				return false;
			} else {
				return Objects.deepEquals(this.satelliteSnr, other.satelliteSnr);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.satellitesVisible);
		result = 31 * result + Objects.hashCode(this.satellitePrn);
		result = 31 * result + Objects.hashCode(this.satelliteUsed);
		result = 31 * result + Objects.hashCode(this.satelliteElevation);
		result = 31 * result + Objects.hashCode(this.satelliteAzimuth);
		result = 31 * result + Objects.hashCode(this.satelliteSnr);
		return result;
	}

	@Override
	public String toString() {
		return "GpsStatus{" +
				"satellitesVisible=" + satellitesVisible +
				", satellitePrn=" + Arrays.toString(satellitePrn) +
				", satelliteUsed=" + Arrays.toString(satelliteUsed) +
				", satelliteElevation=" + Arrays.toString(satelliteElevation) +
				", satelliteAzimuth=" + Arrays.toString(satelliteAzimuth) +
				", satelliteSnr=" + Arrays.toString(satelliteSnr) +
				'}';
	}
}