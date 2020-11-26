package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
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
		id = 335,
		messagePayloadLength = 24,
		description = "Status of the Iridium SBD link."
)
public class IsbdLinkStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timestamp;

	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 2, typeSize = 8, streamLength = 8, description = "Timestamp of the last successful sbd session. The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger lastHeartbeat;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2, description = "Number of failed SBD sessions.")
	private int failedSessions;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 4, typeSize = 2, streamLength = 2, description = "Number of successful SBD sessions.")
	private int successfulSessions;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1, description = "Signal quality equal to the number of bars displayed on the ISU signal strength indicator. Range is 0 to 5, where 0 indicates no signal and 5 indicates maximum signal strength.")
	private short signalQuality;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 1, description = "1: Ring call pending, 0: No call pending.")
	private short ringPending;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 7, typeSize = 1, streamLength = 1, description = "1: Transmission session pending, 0: No transmission session pending.")
	private short txSessionPending;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 8, typeSize = 1, streamLength = 1, description = "1: Receiving session pending, 0: No receiving session pending.")
	private short rxSessionPending;

	private final int messagePayloadLength = 24;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public IsbdLinkStatus(BigInteger timestamp, BigInteger lastHeartbeat, int failedSessions, int successfulSessions, short signalQuality, short ringPending, short txSessionPending, short rxSessionPending) {
		this.timestamp = timestamp;
		this.lastHeartbeat = lastHeartbeat;
		this.failedSessions = failedSessions;
		this.successfulSessions = successfulSessions;
		this.signalQuality = signalQuality;
		this.ringPending = ringPending;
		this.txSessionPending = txSessionPending;
		this.rxSessionPending = rxSessionPending;
	}

	public IsbdLinkStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 24！");
		}
		messagePayload(messagePayload);
	}

	public IsbdLinkStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timestamp = byteArray.getUnsignedInt64(0);
		lastHeartbeat = byteArray.getUnsignedInt64(8);
		failedSessions = byteArray.getUnsignedInt16(16);
		successfulSessions = byteArray.getUnsignedInt16(18);
		signalQuality = byteArray.getUnsignedInt8(20);
		ringPending = byteArray.getUnsignedInt8(21);
		txSessionPending = byteArray.getUnsignedInt8(22);
		rxSessionPending = byteArray.getUnsignedInt8(23);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timestamp,0);
		byteArray.putUnsignedInt64(lastHeartbeat,8);
		byteArray.putUnsignedInt16(failedSessions,16);
		byteArray.putUnsignedInt16(successfulSessions,18);
		byteArray.putUnsignedInt8(signalQuality,20);
		byteArray.putUnsignedInt8(ringPending,21);
		byteArray.putUnsignedInt8(txSessionPending,22);
		byteArray.putUnsignedInt8(rxSessionPending,23);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final IsbdLinkStatus setTimestamp(BigInteger timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	public final BigInteger getTimestamp() {
		return timestamp;
	}

	public final IsbdLinkStatus setLastHeartbeat(BigInteger lastHeartbeat) {
		this.lastHeartbeat = lastHeartbeat;
		return this;
	}

	public final BigInteger getLastHeartbeat() {
		return lastHeartbeat;
	}

	public final IsbdLinkStatus setFailedSessions(int failedSessions) {
		this.failedSessions = failedSessions;
		return this;
	}

	public final int getFailedSessions() {
		return failedSessions;
	}

	public final IsbdLinkStatus setSuccessfulSessions(int successfulSessions) {
		this.successfulSessions = successfulSessions;
		return this;
	}

	public final int getSuccessfulSessions() {
		return successfulSessions;
	}

	public final IsbdLinkStatus setSignalQuality(short signalQuality) {
		this.signalQuality = signalQuality;
		return this;
	}

	public final short getSignalQuality() {
		return signalQuality;
	}

	public final IsbdLinkStatus setRingPending(short ringPending) {
		this.ringPending = ringPending;
		return this;
	}

	public final short getRingPending() {
		return ringPending;
	}

	public final IsbdLinkStatus setTxSessionPending(short txSessionPending) {
		this.txSessionPending = txSessionPending;
		return this;
	}

	public final short getTxSessionPending() {
		return txSessionPending;
	}

	public final IsbdLinkStatus setRxSessionPending(short rxSessionPending) {
		this.rxSessionPending = rxSessionPending;
		return this;
	}

	public final short getRxSessionPending() {
		return rxSessionPending;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			IsbdLinkStatus other = (IsbdLinkStatus)o;
			if (!Objects.deepEquals(this.timestamp, other.timestamp)) {
				return false;
			} else if (!Objects.deepEquals(this.lastHeartbeat, other.lastHeartbeat)) {
				return false;
			} else if (!Objects.deepEquals(this.failedSessions, other.failedSessions)) {
				return false;
			} else if (!Objects.deepEquals(this.successfulSessions, other.successfulSessions)) {
				return false;
			} else if (!Objects.deepEquals(this.signalQuality, other.signalQuality)) {
				return false;
			} else if (!Objects.deepEquals(this.ringPending, other.ringPending)) {
				return false;
			} else if (!Objects.deepEquals(this.txSessionPending, other.txSessionPending)) {
				return false;
			} else {
				return Objects.deepEquals(this.rxSessionPending, other.rxSessionPending);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timestamp);
		result = 31 * result + Objects.hashCode(this.lastHeartbeat);
		result = 31 * result + Objects.hashCode(this.failedSessions);
		result = 31 * result + Objects.hashCode(this.successfulSessions);
		result = 31 * result + Objects.hashCode(this.signalQuality);
		result = 31 * result + Objects.hashCode(this.ringPending);
		result = 31 * result + Objects.hashCode(this.txSessionPending);
		result = 31 * result + Objects.hashCode(this.rxSessionPending);
		return result;
	}

	@Override
	public String toString() {
		return "IsbdLinkStatus{" +
				"timestamp=" + timestamp +
				", lastHeartbeat=" + lastHeartbeat +
				", failedSessions=" + failedSessions +
				", successfulSessions=" + successfulSessions +
				", signalQuality=" + signalQuality +
				", ringPending=" + ringPending +
				", txSessionPending=" + txSessionPending +
				", rxSessionPending=" + rxSessionPending +
				'}';
	}
}