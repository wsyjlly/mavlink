package cn.wsyjlly.mavlink.common.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.09 - 03:37
 **********************************/

@MavlinkMessage(
		id = 131,
		messagePayloadLength = 255,
		description = "RTK GPS data. Gives information on the relative baseline calculation the GPS is reporting"
)
public class EncapsulatedData implements Message {
	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 1, typeSize = 2, streamLength = 2)
	private int seqnr;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 253)
	private short data;

	private final int messagePayloadLength = 255;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public EncapsulatedData(int seqnr, short data) {
		this.seqnr = seqnr;
		this.data = data;
	}

	public EncapsulatedData(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 255！");
		}
		messagePayload(messagePayload);
	}

	public EncapsulatedData(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.seqnr = byteArray.getUnsignedInt16(0);
		this.data = byteArray.getUnsignedInt8(2);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final EncapsulatedData setSeqnr(int seqnr) {
		this.seqnr = seqnr;
		return this;
	}

	public final int getSeqnr() {
		return seqnr;
	}

	public final EncapsulatedData setData(short data) {
		this.data = data;
		return this;
	}

	public final short getData() {
		return data;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			EncapsulatedData other = (EncapsulatedData)o;
			if (!Objects.deepEquals(this.seqnr, other.seqnr)) {
				return false;
			} else {
				return Objects.deepEquals(this.data, other.data);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.seqnr);
		result = 31 * result + Objects.hashCode(this.data);
		return result;
	}

	@Override
	public String toString() {
		return "EncapsulatedData{" +
				"seqnr=" + seqnr +
				", data=" + data +
				'}';
	}
}