package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.util.Arrays;
import java.math.BigInteger;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 311,
		messagePayloadLength = 116,
		description = "General information describing a particular UAVCAN node. Please refer to the definition of the UAVCAN service 'uavcan.protocol.GetNodeInfo' for the background information. This message should be emitted by the system whenever a new node appears online, or an existing node reboots. Additionally, it can be emitted upon request from the other end of the MAVLink channel (see MAV_CMD_UAVCAN_GET_NODE_INFO). It is also not prohibited to emit this message unconditionally at a low frequency. The UAVCAN specification is available at http://uavcan.org."
)
public class UavcanNodeInfo implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 2, typeSize = 4, streamLength = 4, description = "Time since the start-up of the node.", units = "s")
	private long uptimeSec;

	@MavlinkMessageParam(mavlinkType = "char", position = 3, typeSize = 1, streamLength = 80, description = "Node name string. For example, 'sapog.px4.io'.")
	private String name;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "Hardware major version number.")
	private short hwVersionMajor;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1, description = "Hardware minor version number.")
	private short hwVersionMinor;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 16, description = "Hardware unique 128-bit ID.")
	private short[] hwUniqueId = new short[16];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 7, typeSize = 1, streamLength = 1, description = "Software major version number.")
	private short swVersionMajor;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 8, typeSize = 1, streamLength = 1, description = "Software minor version number.")
	private short swVersionMinor;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 9, typeSize = 4, streamLength = 4, description = "Version control system (VCS) revision identifier (e.g. git short commit hash). Zero if unknown.")
	private long swVcsCommit;

	private final int messagePayloadLength = 116;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public UavcanNodeInfo(BigInteger timeUsec, long uptimeSec, String name, short hwVersionMajor, short hwVersionMinor, short[] hwUniqueId, short swVersionMajor, short swVersionMinor, long swVcsCommit) {
		this.timeUsec = timeUsec;
		this.uptimeSec = uptimeSec;
		this.name = name;
		this.hwVersionMajor = hwVersionMajor;
		this.hwVersionMinor = hwVersionMinor;
		this.hwUniqueId = hwUniqueId;
		this.swVersionMajor = swVersionMajor;
		this.swVersionMinor = swVersionMinor;
		this.swVcsCommit = swVcsCommit;
	}

	public UavcanNodeInfo(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 116！");
		}
		messagePayload(messagePayload);
	}

	public UavcanNodeInfo(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		uptimeSec = byteArray.getUnsignedInt32(8);
		name = byteArray.getChars(12,80);
		hwVersionMajor = byteArray.getUnsignedInt8(92);
		hwVersionMinor = byteArray.getUnsignedInt8(93);
		hwUniqueId = byteArray.getUnsignedInt8Array(94,16);
		swVersionMajor = byteArray.getUnsignedInt8(110);
		swVersionMinor = byteArray.getUnsignedInt8(111);
		swVcsCommit = byteArray.getUnsignedInt32(112);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putUnsignedInt32(uptimeSec,8);
		byteArray.putChars(name,12);
		byteArray.putUnsignedInt8(hwVersionMajor,92);
		byteArray.putUnsignedInt8(hwVersionMinor,93);
		byteArray.putUnsignedInt8Array(hwUniqueId,94);
		byteArray.putUnsignedInt8(swVersionMajor,110);
		byteArray.putUnsignedInt8(swVersionMinor,111);
		byteArray.putUnsignedInt32(swVcsCommit,112);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final UavcanNodeInfo setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final UavcanNodeInfo setUptimeSec(long uptimeSec) {
		this.uptimeSec = uptimeSec;
		return this;
	}

	public final long getUptimeSec() {
		return uptimeSec;
	}

	public final UavcanNodeInfo setName(String name) {
		this.name = name;
		return this;
	}

	public final String getName() {
		return name;
	}

	public final UavcanNodeInfo setHwVersionMajor(short hwVersionMajor) {
		this.hwVersionMajor = hwVersionMajor;
		return this;
	}

	public final short getHwVersionMajor() {
		return hwVersionMajor;
	}

	public final UavcanNodeInfo setHwVersionMinor(short hwVersionMinor) {
		this.hwVersionMinor = hwVersionMinor;
		return this;
	}

	public final short getHwVersionMinor() {
		return hwVersionMinor;
	}

	public final UavcanNodeInfo setHwUniqueId(short[] hwUniqueId) {
		this.hwUniqueId = hwUniqueId;
		return this;
	}

	public final short[] getHwUniqueId() {
		return hwUniqueId;
	}

	public final UavcanNodeInfo setSwVersionMajor(short swVersionMajor) {
		this.swVersionMajor = swVersionMajor;
		return this;
	}

	public final short getSwVersionMajor() {
		return swVersionMajor;
	}

	public final UavcanNodeInfo setSwVersionMinor(short swVersionMinor) {
		this.swVersionMinor = swVersionMinor;
		return this;
	}

	public final short getSwVersionMinor() {
		return swVersionMinor;
	}

	public final UavcanNodeInfo setSwVcsCommit(long swVcsCommit) {
		this.swVcsCommit = swVcsCommit;
		return this;
	}

	public final long getSwVcsCommit() {
		return swVcsCommit;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			UavcanNodeInfo other = (UavcanNodeInfo)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.uptimeSec, other.uptimeSec)) {
				return false;
			} else if (!Objects.deepEquals(this.name, other.name)) {
				return false;
			} else if (!Objects.deepEquals(this.hwVersionMajor, other.hwVersionMajor)) {
				return false;
			} else if (!Objects.deepEquals(this.hwVersionMinor, other.hwVersionMinor)) {
				return false;
			} else if (!Objects.deepEquals(this.hwUniqueId, other.hwUniqueId)) {
				return false;
			} else if (!Objects.deepEquals(this.swVersionMajor, other.swVersionMajor)) {
				return false;
			} else if (!Objects.deepEquals(this.swVersionMinor, other.swVersionMinor)) {
				return false;
			} else {
				return Objects.deepEquals(this.swVcsCommit, other.swVcsCommit);
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
		result = 31 * result + Objects.hashCode(this.name);
		result = 31 * result + Objects.hashCode(this.hwVersionMajor);
		result = 31 * result + Objects.hashCode(this.hwVersionMinor);
		result = 31 * result + Objects.hashCode(this.hwUniqueId);
		result = 31 * result + Objects.hashCode(this.swVersionMajor);
		result = 31 * result + Objects.hashCode(this.swVersionMinor);
		result = 31 * result + Objects.hashCode(this.swVcsCommit);
		return result;
	}

	@Override
	public String toString() {
		return "UavcanNodeInfo{" +
				"timeUsec=" + timeUsec +
				", uptimeSec=" + uptimeSec +
				", name=" + name +
				", hwVersionMajor=" + hwVersionMajor +
				", hwVersionMinor=" + hwVersionMinor +
				", hwUniqueId=" + Arrays.toString(hwUniqueId) +
				", swVersionMajor=" + swVersionMajor +
				", swVersionMinor=" + swVersionMinor +
				", swVcsCommit=" + swVcsCommit +
				'}';
	}
}