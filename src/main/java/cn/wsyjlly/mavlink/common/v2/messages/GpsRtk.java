package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.RtkBaselineCoordinateSystem;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 127,
		messagePayloadLength = 35,
		description = "RTK GPS data. Gives information on the relative baseline calculation the GPS is reporting"
)
public class GpsRtk implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Time since boot of last baseline message received.", units = "ms")
	private long timeLastBaselineMs;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Identification of connected RTK receiver.")
	private short rtkReceiverId;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2, description = "GPS Week Number of last baseline")
	private int wn;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 4, typeSize = 4, streamLength = 4, description = "GPS Time of Week of last baseline", units = "ms")
	private long tow;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1, description = "GPS-specific health report for RTK data.")
	private short rtkHealth;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 1, description = "Rate of baseline messages being received by GPS", units = "Hz")
	private short rtkRate;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 7, typeSize = 1, streamLength = 1, description = "Current number of sats used for RTK calculation.")
	private short nsats;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 8, typeSize = 1, streamLength = 1, description = "Coordinate system of baseline", enum0 = RtkBaselineCoordinateSystem.class)
	private short baselineCoordsType;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 9, typeSize = 4, streamLength = 4, description = "Current baseline in ECEF x or NED north component.", units = "mm")
	private int baselineAMm;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 10, typeSize = 4, streamLength = 4, description = "Current baseline in ECEF y or NED east component.", units = "mm")
	private int baselineBMm;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 11, typeSize = 4, streamLength = 4, description = "Current baseline in ECEF z or NED down component.", units = "mm")
	private int baselineCMm;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 12, typeSize = 4, streamLength = 4, description = "Current estimate of baseline accuracy.")
	private long accuracy;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 13, typeSize = 4, streamLength = 4, description = "Current number of integer ambiguity hypotheses.")
	private int iarNumHypotheses;

	private final int messagePayloadLength = 35;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public GpsRtk(long timeLastBaselineMs, short rtkReceiverId, int wn, long tow, short rtkHealth, short rtkRate, short nsats, short baselineCoordsType, int baselineAMm, int baselineBMm, int baselineCMm, long accuracy, int iarNumHypotheses) {
		this.timeLastBaselineMs = timeLastBaselineMs;
		this.rtkReceiverId = rtkReceiverId;
		this.wn = wn;
		this.tow = tow;
		this.rtkHealth = rtkHealth;
		this.rtkRate = rtkRate;
		this.nsats = nsats;
		this.baselineCoordsType = baselineCoordsType;
		this.baselineAMm = baselineAMm;
		this.baselineBMm = baselineBMm;
		this.baselineCMm = baselineCMm;
		this.accuracy = accuracy;
		this.iarNumHypotheses = iarNumHypotheses;
	}

	public GpsRtk(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 35！");
		}
		messagePayload(messagePayload);
	}

	public GpsRtk(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeLastBaselineMs = byteArray.getUnsignedInt32(0);
		rtkReceiverId = byteArray.getUnsignedInt8(4);
		wn = byteArray.getUnsignedInt16(5);
		tow = byteArray.getUnsignedInt32(7);
		rtkHealth = byteArray.getUnsignedInt8(11);
		rtkRate = byteArray.getUnsignedInt8(12);
		nsats = byteArray.getUnsignedInt8(13);
		baselineCoordsType = byteArray.getUnsignedInt8(14);
		baselineAMm = byteArray.getInt32(15);
		baselineBMm = byteArray.getInt32(19);
		baselineCMm = byteArray.getInt32(23);
		accuracy = byteArray.getUnsignedInt32(27);
		iarNumHypotheses = byteArray.getInt32(31);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeLastBaselineMs,0);
		byteArray.putUnsignedInt8(rtkReceiverId,4);
		byteArray.putUnsignedInt16(wn,5);
		byteArray.putUnsignedInt32(tow,7);
		byteArray.putUnsignedInt8(rtkHealth,11);
		byteArray.putUnsignedInt8(rtkRate,12);
		byteArray.putUnsignedInt8(nsats,13);
		byteArray.putUnsignedInt8(baselineCoordsType,14);
		byteArray.putInt32(baselineAMm,15);
		byteArray.putInt32(baselineBMm,19);
		byteArray.putInt32(baselineCMm,23);
		byteArray.putUnsignedInt32(accuracy,27);
		byteArray.putInt32(iarNumHypotheses,31);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final GpsRtk setTimeLastBaselineMs(long timeLastBaselineMs) {
		this.timeLastBaselineMs = timeLastBaselineMs;
		return this;
	}

	public final long getTimeLastBaselineMs() {
		return timeLastBaselineMs;
	}

	public final GpsRtk setRtkReceiverId(short rtkReceiverId) {
		this.rtkReceiverId = rtkReceiverId;
		return this;
	}

	public final short getRtkReceiverId() {
		return rtkReceiverId;
	}

	public final GpsRtk setWn(int wn) {
		this.wn = wn;
		return this;
	}

	public final int getWn() {
		return wn;
	}

	public final GpsRtk setTow(long tow) {
		this.tow = tow;
		return this;
	}

	public final long getTow() {
		return tow;
	}

	public final GpsRtk setRtkHealth(short rtkHealth) {
		this.rtkHealth = rtkHealth;
		return this;
	}

	public final short getRtkHealth() {
		return rtkHealth;
	}

	public final GpsRtk setRtkRate(short rtkRate) {
		this.rtkRate = rtkRate;
		return this;
	}

	public final short getRtkRate() {
		return rtkRate;
	}

	public final GpsRtk setNsats(short nsats) {
		this.nsats = nsats;
		return this;
	}

	public final short getNsats() {
		return nsats;
	}

	public final GpsRtk setBaselineCoordsType(short baselineCoordsType) {
		this.baselineCoordsType = baselineCoordsType;
		return this;
	}

	public final short getBaselineCoordsType() {
		return baselineCoordsType;
	}

	public final GpsRtk setBaselineAMm(int baselineAMm) {
		this.baselineAMm = baselineAMm;
		return this;
	}

	public final int getBaselineAMm() {
		return baselineAMm;
	}

	public final GpsRtk setBaselineBMm(int baselineBMm) {
		this.baselineBMm = baselineBMm;
		return this;
	}

	public final int getBaselineBMm() {
		return baselineBMm;
	}

	public final GpsRtk setBaselineCMm(int baselineCMm) {
		this.baselineCMm = baselineCMm;
		return this;
	}

	public final int getBaselineCMm() {
		return baselineCMm;
	}

	public final GpsRtk setAccuracy(long accuracy) {
		this.accuracy = accuracy;
		return this;
	}

	public final long getAccuracy() {
		return accuracy;
	}

	public final GpsRtk setIarNumHypotheses(int iarNumHypotheses) {
		this.iarNumHypotheses = iarNumHypotheses;
		return this;
	}

	public final int getIarNumHypotheses() {
		return iarNumHypotheses;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			GpsRtk other = (GpsRtk)o;
			if (!Objects.deepEquals(this.timeLastBaselineMs, other.timeLastBaselineMs)) {
				return false;
			} else if (!Objects.deepEquals(this.rtkReceiverId, other.rtkReceiverId)) {
				return false;
			} else if (!Objects.deepEquals(this.wn, other.wn)) {
				return false;
			} else if (!Objects.deepEquals(this.tow, other.tow)) {
				return false;
			} else if (!Objects.deepEquals(this.rtkHealth, other.rtkHealth)) {
				return false;
			} else if (!Objects.deepEquals(this.rtkRate, other.rtkRate)) {
				return false;
			} else if (!Objects.deepEquals(this.nsats, other.nsats)) {
				return false;
			} else if (!Objects.deepEquals(this.baselineCoordsType, other.baselineCoordsType)) {
				return false;
			} else if (!Objects.deepEquals(this.baselineAMm, other.baselineAMm)) {
				return false;
			} else if (!Objects.deepEquals(this.baselineBMm, other.baselineBMm)) {
				return false;
			} else if (!Objects.deepEquals(this.baselineCMm, other.baselineCMm)) {
				return false;
			} else if (!Objects.deepEquals(this.accuracy, other.accuracy)) {
				return false;
			} else {
				return Objects.deepEquals(this.iarNumHypotheses, other.iarNumHypotheses);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeLastBaselineMs);
		result = 31 * result + Objects.hashCode(this.rtkReceiverId);
		result = 31 * result + Objects.hashCode(this.wn);
		result = 31 * result + Objects.hashCode(this.tow);
		result = 31 * result + Objects.hashCode(this.rtkHealth);
		result = 31 * result + Objects.hashCode(this.rtkRate);
		result = 31 * result + Objects.hashCode(this.nsats);
		result = 31 * result + Objects.hashCode(this.baselineCoordsType);
		result = 31 * result + Objects.hashCode(this.baselineAMm);
		result = 31 * result + Objects.hashCode(this.baselineBMm);
		result = 31 * result + Objects.hashCode(this.baselineCMm);
		result = 31 * result + Objects.hashCode(this.accuracy);
		result = 31 * result + Objects.hashCode(this.iarNumHypotheses);
		return result;
	}

	@Override
	public String toString() {
		return "GpsRtk{" +
				"timeLastBaselineMs=" + timeLastBaselineMs +
				", rtkReceiverId=" + rtkReceiverId +
				", wn=" + wn +
				", tow=" + tow +
				", rtkHealth=" + rtkHealth +
				", rtkRate=" + rtkRate +
				", nsats=" + nsats +
				", baselineCoordsType=" + baselineCoordsType +
				", baselineAMm=" + baselineAMm +
				", baselineBMm=" + baselineBMm +
				", baselineCMm=" + baselineCMm +
				", accuracy=" + accuracy +
				", iarNumHypotheses=" + iarNumHypotheses +
				'}';
	}
}