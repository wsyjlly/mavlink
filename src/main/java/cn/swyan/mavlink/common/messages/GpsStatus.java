package cn.swyan.mavlink.common.messages;

import cn.swyan.mavlink.annotation.MavlinkMessage;
import cn.swyan.mavlink.annotation.MavlinkMessageParam;
import cn.swyan.mavlink.common.Message;
import cn.swyan.mavlink.protocol.ByteArray;
import cn.swyan.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 **********************************/

@MavlinkMessage(
		id = 25,
		messagePayloadLength = 101,
		description = "The positioning status, as reported by GPS. This message is intended to display status information about each satellite visible to the receiver. See message GLOBAL_POSITION for the global position estimate. This message can contain information for up to 20 satellites."
)
public class GpsStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1)
	private short satellitesVisible;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 20)
	private short satellitePrn;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 20)
	private short satelliteUsed;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 20)
	private short satelliteElevation;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 20)
	private short satelliteAzimuth;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 20)
	private short satelliteSnr;

	private final int messagePayloadLength = 101;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public GpsStatus(short satellitesVisible, short satellitePrn, short satelliteUsed, short satelliteElevation, short satelliteAzimuth, short satelliteSnr) {
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
		this.satellitesVisible = byteArray.getUnsignedInt8(0);
		this.satellitePrn = byteArray.getUnsignedInt8(1);
		this.satelliteUsed = byteArray.getUnsignedInt8(2);
		this.satelliteElevation = byteArray.getUnsignedInt8(3);
		this.satelliteAzimuth = byteArray.getUnsignedInt8(4);
		this.satelliteSnr = byteArray.getUnsignedInt8(5);
	}

	@Override
	public byte[] messagePayload() {
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

	public final GpsStatus setSatellitePrn(short satellitePrn) {
		this.satellitePrn = satellitePrn;
		return this;
	}

	public final short getSatellitePrn() {
		return satellitePrn;
	}

	public final GpsStatus setSatelliteUsed(short satelliteUsed) {
		this.satelliteUsed = satelliteUsed;
		return this;
	}

	public final short getSatelliteUsed() {
		return satelliteUsed;
	}

	public final GpsStatus setSatelliteElevation(short satelliteElevation) {
		this.satelliteElevation = satelliteElevation;
		return this;
	}

	public final short getSatelliteElevation() {
		return satelliteElevation;
	}

	public final GpsStatus setSatelliteAzimuth(short satelliteAzimuth) {
		this.satelliteAzimuth = satelliteAzimuth;
		return this;
	}

	public final short getSatelliteAzimuth() {
		return satelliteAzimuth;
	}

	public final GpsStatus setSatelliteSnr(short satelliteSnr) {
		this.satelliteSnr = satelliteSnr;
		return this;
	}

	public final short getSatelliteSnr() {
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
				", satellitePrn=" + satellitePrn +
				", satelliteUsed=" + satelliteUsed +
				", satelliteElevation=" + satelliteElevation +
				", satelliteAzimuth=" + satelliteAzimuth +
				", satelliteSnr=" + satelliteSnr +
				'}';
	}
}