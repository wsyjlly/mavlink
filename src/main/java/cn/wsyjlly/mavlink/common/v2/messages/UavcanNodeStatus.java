package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.UavcanNodeHealth;
import cn.wsyjlly.mavlink.common.v2.enums.UavcanNodeMode;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.math.BigInteger;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 310,
		messagePayloadLength = 17,
		description = "General status information of an UAVCAN node. Please refer to the definition of the UAVCAN message 'uavcan.protocol.NodeStatus' for the background information. The UAVCAN specification is available at http://uavcan.org."
)
public class UavcanNodeStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 2, typeSize = 4, streamLength = 4, description = "Time since the start-up of the node.", units = "s")
	private long uptimeSec;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Generalized node health status.", enum0 = UavcanNodeHealth.class)
	private short health;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "Generalized operating mode.", enum0 = UavcanNodeMode.class)
	private short mode;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1, description = "Not used currently.")
	private short subMode;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 6, typeSize = 2, streamLength = 2, description = "Vendor-specific status information.")
	private int vendorSpecificStatusCode;

	private final int messagePayloadLength = 17;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public UavcanNodeStatus(BigInteger timeUsec, long uptimeSec, short health, short mode, short subMode, int vendorSpecificStatusCode) {
		this.timeUsec = timeUsec;
		this.uptimeSec = uptimeSec;
		this.health = health;
		this.mode = mode;
		this.subMode = subMode;
		this.vendorSpecificStatusCode = vendorSpecificStatusCode;
	}

	public UavcanNodeStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 17！");
		}
		messagePayload(messagePayload);
	}

	public UavcanNodeStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		uptimeSec = byteArray.getUnsignedInt32(8);
		health = byteArray.getUnsignedInt8(12);
		mode = byteArray.getUnsignedInt8(13);
		subMode = byteArray.getUnsignedInt8(14);
		vendorSpecificStatusCode = byteArray.getUnsignedInt16(15);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putUnsignedInt32(uptimeSec,8);
		byteArray.putUnsignedInt8(health,12);
		byteArray.putUnsignedInt8(mode,13);
		byteArray.putUnsignedInt8(subMode,14);
		byteArray.putUnsignedInt16(vendorSpecificStatusCode,15);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final UavcanNodeStatus setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final UavcanNodeStatus setUptimeSec(long uptimeSec) {
		this.uptimeSec = uptimeSec;
		return this;
	}

	public final long getUptimeSec() {
		return uptimeSec;
	}

	public final UavcanNodeStatus setHealth(short health) {
		this.health = health;
		return this;
	}

	public final short getHealth() {
		return health;
	}

	public final UavcanNodeStatus setMode(short mode) {
		this.mode = mode;
		return this;
	}

	public final short getMode() {
		return mode;
	}

	public final UavcanNodeStatus setSubMode(short subMode) {
		this.subMode = subMode;
		return this;
	}

	public final short getSubMode() {
		return subMode;
	}

	public final UavcanNodeStatus setVendorSpecificStatusCode(int vendorSpecificStatusCode) {
		this.vendorSpecificStatusCode = vendorSpecificStatusCode;
		return this;
	}

	public final int getVendorSpecificStatusCode() {
		return vendorSpecificStatusCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			UavcanNodeStatus other = (UavcanNodeStatus)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.uptimeSec, other.uptimeSec)) {
				return false;
			} else if (!Objects.deepEquals(this.health, other.health)) {
				return false;
			} else if (!Objects.deepEquals(this.mode, other.mode)) {
				return false;
			} else if (!Objects.deepEquals(this.subMode, other.subMode)) {
				return false;
			} else {
				return Objects.deepEquals(this.vendorSpecificStatusCode, other.vendorSpecificStatusCode);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.uptimeSec);
		result = 31 * result + Objects.hashCode(this.health);
		result = 31 * result + Objects.hashCode(this.mode);
		result = 31 * result + Objects.hashCode(this.subMode);
		result = 31 * result + Objects.hashCode(this.vendorSpecificStatusCode);
		return result;
	}

	@Override
	public String toString() {
		return "UavcanNodeStatus{" +
				"timeUsec=" + timeUsec +
				", uptimeSec=" + uptimeSec +
				", health=" + health +
				", mode=" + mode +
				", subMode=" + subMode +
				", vendorSpecificStatusCode=" + vendorSpecificStatusCode +
				'}';
	}
}