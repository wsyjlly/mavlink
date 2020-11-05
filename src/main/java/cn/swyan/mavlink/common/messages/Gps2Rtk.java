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
		id = 128,
		messagePayloadLength = 35,
		description = "RTK GPS data. Gives information on the relative baseline calculation the GPS is reporting"
)
public class Gps2Rtk implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4)
	private long timeLastBaselineMs;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1)
	private short rtkReceiverId;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2)
	private int wn;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 4, typeSize = 4, streamLength = 4)
	private long tow;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1)
	private short rtkHealth;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 1)
	private short rtkRate;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 7, typeSize = 1, streamLength = 1)
	private short nsats;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 8, typeSize = 1, streamLength = 1)
	private short baselineCoordsType;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 9, typeSize = 4, streamLength = 4)
	private int baselineAMm;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 10, typeSize = 4, streamLength = 4)
	private int baselineBMm;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 11, typeSize = 4, streamLength = 4)
	private int baselineCMm;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 12, typeSize = 4, streamLength = 4)
	private long accuracy;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 13, typeSize = 4, streamLength = 4)
	private int iarNumHypotheses;

	private final int messagePayloadLength = 35;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public Gps2Rtk(long timeLastBaselineMs, short rtkReceiverId, int wn, long tow, short rtkHealth, short rtkRate, short nsats, short baselineCoordsType, int baselineAMm, int baselineBMm, int baselineCMm, long accuracy, int iarNumHypotheses) {
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

	public Gps2Rtk(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 35！");
		}
		messagePayload(messagePayload);
	}

	public Gps2Rtk(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.timeLastBaselineMs = byteArray.getUnsignedInt32(0);
		this.rtkReceiverId = byteArray.getUnsignedInt8(4);
		this.wn = byteArray.getUnsignedInt16(5);
		this.tow = byteArray.getUnsignedInt32(7);
		this.rtkHealth = byteArray.getUnsignedInt8(11);
		this.rtkRate = byteArray.getUnsignedInt8(12);
		this.nsats = byteArray.getUnsignedInt8(13);
		this.baselineCoordsType = byteArray.getUnsignedInt8(14);
		this.baselineAMm = byteArray.getInt32(15);
		this.baselineBMm = byteArray.getInt32(19);
		this.baselineCMm = byteArray.getInt32(23);
		this.accuracy = byteArray.getUnsignedInt32(27);
		this.iarNumHypotheses = byteArray.getInt32(31);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final Gps2Rtk setTimeLastBaselineMs(long timeLastBaselineMs) {
		this.timeLastBaselineMs = timeLastBaselineMs;
		return this;
	}

	public final long getTimeLastBaselineMs() {
		return timeLastBaselineMs;
	}

	public final Gps2Rtk setRtkReceiverId(short rtkReceiverId) {
		this.rtkReceiverId = rtkReceiverId;
		return this;
	}

	public final short getRtkReceiverId() {
		return rtkReceiverId;
	}

	public final Gps2Rtk setWn(int wn) {
		this.wn = wn;
		return this;
	}

	public final int getWn() {
		return wn;
	}

	public final Gps2Rtk setTow(long tow) {
		this.tow = tow;
		return this;
	}

	public final long getTow() {
		return tow;
	}

	public final Gps2Rtk setRtkHealth(short rtkHealth) {
		this.rtkHealth = rtkHealth;
		return this;
	}

	public final short getRtkHealth() {
		return rtkHealth;
	}

	public final Gps2Rtk setRtkRate(short rtkRate) {
		this.rtkRate = rtkRate;
		return this;
	}

	public final short getRtkRate() {
		return rtkRate;
	}

	public final Gps2Rtk setNsats(short nsats) {
		this.nsats = nsats;
		return this;
	}

	public final short getNsats() {
		return nsats;
	}

	public final Gps2Rtk setBaselineCoordsType(short baselineCoordsType) {
		this.baselineCoordsType = baselineCoordsType;
		return this;
	}

	public final short getBaselineCoordsType() {
		return baselineCoordsType;
	}

	public final Gps2Rtk setBaselineAMm(int baselineAMm) {
		this.baselineAMm = baselineAMm;
		return this;
	}

	public final int getBaselineAMm() {
		return baselineAMm;
	}

	public final Gps2Rtk setBaselineBMm(int baselineBMm) {
		this.baselineBMm = baselineBMm;
		return this;
	}

	public final int getBaselineBMm() {
		return baselineBMm;
	}

	public final Gps2Rtk setBaselineCMm(int baselineCMm) {
		this.baselineCMm = baselineCMm;
		return this;
	}

	public final int getBaselineCMm() {
		return baselineCMm;
	}

	public final Gps2Rtk setAccuracy(long accuracy) {
		this.accuracy = accuracy;
		return this;
	}

	public final long getAccuracy() {
		return accuracy;
	}

	public final Gps2Rtk setIarNumHypotheses(int iarNumHypotheses) {
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
			Gps2Rtk other = (Gps2Rtk)o;
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
		return "Gps2Rtk{" +
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