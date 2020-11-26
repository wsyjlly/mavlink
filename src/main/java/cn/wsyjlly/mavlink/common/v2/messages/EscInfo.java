package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.EscFailureFlags;
import cn.wsyjlly.mavlink.common.v2.enums.EscConnectionType;
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
		id = 290,
		messagePayloadLength = 42,
		description = "ESC information for lower rate streaming. Recommended streaming rate 1Hz. See ESC_STATUS for higher-rate ESC data."
)
public class EscInfo implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "Index of the first ESC in this message. minValue = 0, maxValue = 60, increment = 4.")
	private short index;

	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 2, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2, description = "Counter of data packets received.")
	private int counter;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "Total number of ESCs in all messages of this type. Message fields with an index higher than this should be ignored because they contain invalid data.")
	private short count;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1, description = "Connection type protocol for all ESC.", enum0 = EscConnectionType.class)
	private short connectionType;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 1, description = "Information regarding online/offline status of each ESC.")
	private short info;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 7, typeSize = 2, streamLength = 8, description = "Bitmap of ESC failure flags.", enum0 = EscFailureFlags.class)
	private int[] failureFlags = new int[4];

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 8, typeSize = 4, streamLength = 16, description = "Number of reported errors by each ESC since boot.")
	private long[] errorCount = new long[4];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 9, typeSize = 1, streamLength = 4, description = "Temperature measured by each ESC. UINT8_MAX if data not supplied by ESC.", units = "degC")
	private short[] temperature = new short[4];

	private final int messagePayloadLength = 42;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public EscInfo(short index, BigInteger timeUsec, int counter, short count, short connectionType, short info, int[] failureFlags, long[] errorCount, short[] temperature) {
		this.index = index;
		this.timeUsec = timeUsec;
		this.counter = counter;
		this.count = count;
		this.connectionType = connectionType;
		this.info = info;
		this.failureFlags = failureFlags;
		this.errorCount = errorCount;
		this.temperature = temperature;
	}

	public EscInfo(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 42！");
		}
		messagePayload(messagePayload);
	}

	public EscInfo(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		index = byteArray.getUnsignedInt8(0);
		timeUsec = byteArray.getUnsignedInt64(1);
		counter = byteArray.getUnsignedInt16(9);
		count = byteArray.getUnsignedInt8(11);
		connectionType = byteArray.getUnsignedInt8(12);
		info = byteArray.getUnsignedInt8(13);
		failureFlags = byteArray.getUnsignedInt16Array(14,4);
		errorCount = byteArray.getUnsignedInt32Array(22,4);
		temperature = byteArray.getUnsignedInt8Array(38,4);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(index,0);
		byteArray.putUnsignedInt64(timeUsec,1);
		byteArray.putUnsignedInt16(counter,9);
		byteArray.putUnsignedInt8(count,11);
		byteArray.putUnsignedInt8(connectionType,12);
		byteArray.putUnsignedInt8(info,13);
		byteArray.putUnsignedInt16Array(failureFlags,14);
		byteArray.putUnsignedInt32Array(errorCount,22);
		byteArray.putUnsignedInt8Array(temperature,38);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final EscInfo setIndex(short index) {
		this.index = index;
		return this;
	}

	public final short getIndex() {
		return index;
	}

	public final EscInfo setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final EscInfo setCounter(int counter) {
		this.counter = counter;
		return this;
	}

	public final int getCounter() {
		return counter;
	}

	public final EscInfo setCount(short count) {
		this.count = count;
		return this;
	}

	public final short getCount() {
		return count;
	}

	public final EscInfo setConnectionType(short connectionType) {
		this.connectionType = connectionType;
		return this;
	}

	public final short getConnectionType() {
		return connectionType;
	}

	public final EscInfo setInfo(short info) {
		this.info = info;
		return this;
	}

	public final short getInfo() {
		return info;
	}

	public final EscInfo setFailureFlags(int[] failureFlags) {
		this.failureFlags = failureFlags;
		return this;
	}

	public final int[] getFailureFlags() {
		return failureFlags;
	}

	public final EscInfo setErrorCount(long[] errorCount) {
		this.errorCount = errorCount;
		return this;
	}

	public final long[] getErrorCount() {
		return errorCount;
	}

	public final EscInfo setTemperature(short[] temperature) {
		this.temperature = temperature;
		return this;
	}

	public final short[] getTemperature() {
		return temperature;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			EscInfo other = (EscInfo)o;
			if (!Objects.deepEquals(this.index, other.index)) {
				return false;
			} else if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.counter, other.counter)) {
				return false;
			} else if (!Objects.deepEquals(this.count, other.count)) {
				return false;
			} else if (!Objects.deepEquals(this.connectionType, other.connectionType)) {
				return false;
			} else if (!Objects.deepEquals(this.info, other.info)) {
				return false;
			} else if (!Objects.deepEquals(this.failureFlags, other.failureFlags)) {
				return false;
			} else if (!Objects.deepEquals(this.errorCount, other.errorCount)) {
				return false;
			} else {
				return Objects.deepEquals(this.temperature, other.temperature);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.index);
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.counter);
		result = 31 * result + Objects.hashCode(this.count);
		result = 31 * result + Objects.hashCode(this.connectionType);
		result = 31 * result + Objects.hashCode(this.info);
		result = 31 * result + Objects.hashCode(this.failureFlags);
		result = 31 * result + Objects.hashCode(this.errorCount);
		result = 31 * result + Objects.hashCode(this.temperature);
		return result;
	}

	@Override
	public String toString() {
		return "EscInfo{" +
				"index=" + index +
				", timeUsec=" + timeUsec +
				", counter=" + counter +
				", count=" + count +
				", connectionType=" + connectionType +
				", info=" + info +
				", failureFlags=" + Arrays.toString(failureFlags) +
				", errorCount=" + Arrays.toString(errorCount) +
				", temperature=" + Arrays.toString(temperature) +
				'}';
	}
}