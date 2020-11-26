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
		id = 8,
		messagePayloadLength = 36,
		description = "Status generated in each node in the communication chain and injected into MAVLink stream."
)
public class LinkNodeStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (time since system boot).", units = "ms")
	private BigInteger timestamp;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Remaining free transmit buffer space", units = "%")
	private short txBuf;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Remaining free receive buffer space", units = "%")
	private short rxBuf;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 4, typeSize = 4, streamLength = 4, description = "Transmit rate", units = "bytes/s")
	private long txRate;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 5, typeSize = 4, streamLength = 4, description = "Receive rate", units = "bytes/s")
	private long rxRate;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 6, typeSize = 2, streamLength = 2, description = "Number of bytes that could not be parsed correctly.", units = "bytes")
	private int rxParseErr;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 7, typeSize = 2, streamLength = 2, description = "Transmit buffer overflows. This number wraps around as it reaches UINT16_MAX", units = "bytes")
	private int txOverflows;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 8, typeSize = 2, streamLength = 2, description = "Receive buffer overflows. This number wraps around as it reaches UINT16_MAX", units = "bytes")
	private int rxOverflows;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 9, typeSize = 4, streamLength = 4, description = "Messages sent")
	private long messagesSent;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 10, typeSize = 4, streamLength = 4, description = "Messages received (estimated from counting seq)")
	private long messagesReceived;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 11, typeSize = 4, streamLength = 4, description = "Messages lost (estimated from counting seq)")
	private long messagesLost;

	private final int messagePayloadLength = 36;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public LinkNodeStatus(BigInteger timestamp, short txBuf, short rxBuf, long txRate, long rxRate, int rxParseErr, int txOverflows, int rxOverflows, long messagesSent, long messagesReceived, long messagesLost) {
		this.timestamp = timestamp;
		this.txBuf = txBuf;
		this.rxBuf = rxBuf;
		this.txRate = txRate;
		this.rxRate = rxRate;
		this.rxParseErr = rxParseErr;
		this.txOverflows = txOverflows;
		this.rxOverflows = rxOverflows;
		this.messagesSent = messagesSent;
		this.messagesReceived = messagesReceived;
		this.messagesLost = messagesLost;
	}

	public LinkNodeStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 36！");
		}
		messagePayload(messagePayload);
	}

	public LinkNodeStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timestamp = byteArray.getUnsignedInt64(0);
		txBuf = byteArray.getUnsignedInt8(8);
		rxBuf = byteArray.getUnsignedInt8(9);
		txRate = byteArray.getUnsignedInt32(10);
		rxRate = byteArray.getUnsignedInt32(14);
		rxParseErr = byteArray.getUnsignedInt16(18);
		txOverflows = byteArray.getUnsignedInt16(20);
		rxOverflows = byteArray.getUnsignedInt16(22);
		messagesSent = byteArray.getUnsignedInt32(24);
		messagesReceived = byteArray.getUnsignedInt32(28);
		messagesLost = byteArray.getUnsignedInt32(32);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timestamp,0);
		byteArray.putUnsignedInt8(txBuf,8);
		byteArray.putUnsignedInt8(rxBuf,9);
		byteArray.putUnsignedInt32(txRate,10);
		byteArray.putUnsignedInt32(rxRate,14);
		byteArray.putUnsignedInt16(rxParseErr,18);
		byteArray.putUnsignedInt16(txOverflows,20);
		byteArray.putUnsignedInt16(rxOverflows,22);
		byteArray.putUnsignedInt32(messagesSent,24);
		byteArray.putUnsignedInt32(messagesReceived,28);
		byteArray.putUnsignedInt32(messagesLost,32);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final LinkNodeStatus setTimestamp(BigInteger timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	public final BigInteger getTimestamp() {
		return timestamp;
	}

	public final LinkNodeStatus setTxBuf(short txBuf) {
		this.txBuf = txBuf;
		return this;
	}

	public final short getTxBuf() {
		return txBuf;
	}

	public final LinkNodeStatus setRxBuf(short rxBuf) {
		this.rxBuf = rxBuf;
		return this;
	}

	public final short getRxBuf() {
		return rxBuf;
	}

	public final LinkNodeStatus setTxRate(long txRate) {
		this.txRate = txRate;
		return this;
	}

	public final long getTxRate() {
		return txRate;
	}

	public final LinkNodeStatus setRxRate(long rxRate) {
		this.rxRate = rxRate;
		return this;
	}

	public final long getRxRate() {
		return rxRate;
	}

	public final LinkNodeStatus setRxParseErr(int rxParseErr) {
		this.rxParseErr = rxParseErr;
		return this;
	}

	public final int getRxParseErr() {
		return rxParseErr;
	}

	public final LinkNodeStatus setTxOverflows(int txOverflows) {
		this.txOverflows = txOverflows;
		return this;
	}

	public final int getTxOverflows() {
		return txOverflows;
	}

	public final LinkNodeStatus setRxOverflows(int rxOverflows) {
		this.rxOverflows = rxOverflows;
		return this;
	}

	public final int getRxOverflows() {
		return rxOverflows;
	}

	public final LinkNodeStatus setMessagesSent(long messagesSent) {
		this.messagesSent = messagesSent;
		return this;
	}

	public final long getMessagesSent() {
		return messagesSent;
	}

	public final LinkNodeStatus setMessagesReceived(long messagesReceived) {
		this.messagesReceived = messagesReceived;
		return this;
	}

	public final long getMessagesReceived() {
		return messagesReceived;
	}

	public final LinkNodeStatus setMessagesLost(long messagesLost) {
		this.messagesLost = messagesLost;
		return this;
	}

	public final long getMessagesLost() {
		return messagesLost;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			LinkNodeStatus other = (LinkNodeStatus)o;
			if (!Objects.deepEquals(this.timestamp, other.timestamp)) {
				return false;
			} else if (!Objects.deepEquals(this.txBuf, other.txBuf)) {
				return false;
			} else if (!Objects.deepEquals(this.rxBuf, other.rxBuf)) {
				return false;
			} else if (!Objects.deepEquals(this.txRate, other.txRate)) {
				return false;
			} else if (!Objects.deepEquals(this.rxRate, other.rxRate)) {
				return false;
			} else if (!Objects.deepEquals(this.rxParseErr, other.rxParseErr)) {
				return false;
			} else if (!Objects.deepEquals(this.txOverflows, other.txOverflows)) {
				return false;
			} else if (!Objects.deepEquals(this.rxOverflows, other.rxOverflows)) {
				return false;
			} else if (!Objects.deepEquals(this.messagesSent, other.messagesSent)) {
				return false;
			} else if (!Objects.deepEquals(this.messagesReceived, other.messagesReceived)) {
				return false;
			} else {
				return Objects.deepEquals(this.messagesLost, other.messagesLost);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timestamp);
		result = 31 * result + Objects.hashCode(this.txBuf);
		result = 31 * result + Objects.hashCode(this.rxBuf);
		result = 31 * result + Objects.hashCode(this.txRate);
		result = 31 * result + Objects.hashCode(this.rxRate);
		result = 31 * result + Objects.hashCode(this.rxParseErr);
		result = 31 * result + Objects.hashCode(this.txOverflows);
		result = 31 * result + Objects.hashCode(this.rxOverflows);
		result = 31 * result + Objects.hashCode(this.messagesSent);
		result = 31 * result + Objects.hashCode(this.messagesReceived);
		result = 31 * result + Objects.hashCode(this.messagesLost);
		return result;
	}

	@Override
	public String toString() {
		return "LinkNodeStatus{" +
				"timestamp=" + timestamp +
				", txBuf=" + txBuf +
				", rxBuf=" + rxBuf +
				", txRate=" + txRate +
				", rxRate=" + rxRate +
				", rxParseErr=" + rxParseErr +
				", txOverflows=" + txOverflows +
				", rxOverflows=" + rxOverflows +
				", messagesSent=" + messagesSent +
				", messagesReceived=" + messagesReceived +
				", messagesLost=" + messagesLost +
				'}';
	}
}