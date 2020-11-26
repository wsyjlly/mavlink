package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.FenceMitigate;
import cn.wsyjlly.mavlink.common.v2.enums.FenceBreach;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 162,
		messagePayloadLength = 9,
		description = "Status of geo-fencing. Sent in extended status stream when fencing enabled."
)
public class FenceStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "Breach status (0 if currently inside fence, 1 if outside).")
	private short breachStatus;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 2, typeSize = 2, streamLength = 2, description = "Number of fence breaches.")
	private int breachCount;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Last breach type.", enum0 = FenceBreach.class)
	private short breachType;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 4, typeSize = 4, streamLength = 4, description = "Time (since boot) of last breach.", units = "ms")
	private long breachTime;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1, description = "Active action to prevent fence breach", enum0 = FenceMitigate.class)
	private short breachMitigation;

	private final int messagePayloadLength = 9;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public FenceStatus(short breachStatus, int breachCount, short breachType, long breachTime, short breachMitigation) {
		this.breachStatus = breachStatus;
		this.breachCount = breachCount;
		this.breachType = breachType;
		this.breachTime = breachTime;
		this.breachMitigation = breachMitigation;
	}

	public FenceStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 9！");
		}
		messagePayload(messagePayload);
	}

	public FenceStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		breachStatus = byteArray.getUnsignedInt8(0);
		breachCount = byteArray.getUnsignedInt16(1);
		breachType = byteArray.getUnsignedInt8(3);
		breachTime = byteArray.getUnsignedInt32(4);
		breachMitigation = byteArray.getUnsignedInt8(8);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(breachStatus,0);
		byteArray.putUnsignedInt16(breachCount,1);
		byteArray.putUnsignedInt8(breachType,3);
		byteArray.putUnsignedInt32(breachTime,4);
		byteArray.putUnsignedInt8(breachMitigation,8);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final FenceStatus setBreachStatus(short breachStatus) {
		this.breachStatus = breachStatus;
		return this;
	}

	public final short getBreachStatus() {
		return breachStatus;
	}

	public final FenceStatus setBreachCount(int breachCount) {
		this.breachCount = breachCount;
		return this;
	}

	public final int getBreachCount() {
		return breachCount;
	}

	public final FenceStatus setBreachType(short breachType) {
		this.breachType = breachType;
		return this;
	}

	public final short getBreachType() {
		return breachType;
	}

	public final FenceStatus setBreachTime(long breachTime) {
		this.breachTime = breachTime;
		return this;
	}

	public final long getBreachTime() {
		return breachTime;
	}

	public final FenceStatus setBreachMitigation(short breachMitigation) {
		this.breachMitigation = breachMitigation;
		return this;
	}

	public final short getBreachMitigation() {
		return breachMitigation;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			FenceStatus other = (FenceStatus)o;
			if (!Objects.deepEquals(this.breachStatus, other.breachStatus)) {
				return false;
			} else if (!Objects.deepEquals(this.breachCount, other.breachCount)) {
				return false;
			} else if (!Objects.deepEquals(this.breachType, other.breachType)) {
				return false;
			} else if (!Objects.deepEquals(this.breachTime, other.breachTime)) {
				return false;
			} else {
				return Objects.deepEquals(this.breachMitigation, other.breachMitigation);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.breachStatus);
		result = 31 * result + Objects.hashCode(this.breachCount);
		result = 31 * result + Objects.hashCode(this.breachType);
		result = 31 * result + Objects.hashCode(this.breachTime);
		result = 31 * result + Objects.hashCode(this.breachMitigation);
		return result;
	}

	@Override
	public String toString() {
		return "FenceStatus{" +
				"breachStatus=" + breachStatus +
				", breachCount=" + breachCount +
				", breachType=" + breachType +
				", breachTime=" + breachTime +
				", breachMitigation=" + breachMitigation +
				'}';
	}
}