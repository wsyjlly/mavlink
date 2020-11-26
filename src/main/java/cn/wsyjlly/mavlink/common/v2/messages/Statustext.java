package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavSeverity;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.util.Arrays;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 253,
		messagePayloadLength = 54,
		description = "Status text message. These messages are printed in yellow in the COMM console of QGroundControl. WARNING: They consume quite some bandwidth, so use only for important status and error messages. If implemented wisely, these messages are buffered on the MCU and sent only at a limited rate (e.g. 10 Hz)."
)
public class Statustext implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "Severity of status. Relies on the definitions within RFC-5424.", enum0 = MavSeverity.class)
	private short severity;

	@MavlinkMessageParam(mavlinkType = "char", position = 2, typeSize = 1, streamLength = 50, description = "Status text message, without null termination character")
	private String text;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2, description = "Unique (opaque) identifier for this statustext message. May be used to reassemble a logical long-statustext message from a sequence of chunks. A value of zero indicates this is the only chunk in the sequence and the message can be emitted immediately.")
	private int id;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "This chunk's sequence number; indexing is from zero. Any null character in the text field is taken to mean this was the last chunk.")
	private short chunkSeq;

	private final int messagePayloadLength = 54;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public Statustext(short severity, String text, int id, short chunkSeq) {
		this.severity = severity;
		this.text = text;
		this.id = id;
		this.chunkSeq = chunkSeq;
	}

	public Statustext(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 54！");
		}
		messagePayload(messagePayload);
	}

	public Statustext(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		severity = byteArray.getUnsignedInt8(0);
		text = byteArray.getChars(1,50);
		id = byteArray.getUnsignedInt16(51);
		chunkSeq = byteArray.getUnsignedInt8(53);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(severity,0);
		byteArray.putChars(text,1);
		byteArray.putUnsignedInt16(id,51);
		byteArray.putUnsignedInt8(chunkSeq,53);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final Statustext setSeverity(short severity) {
		this.severity = severity;
		return this;
	}

	public final short getSeverity() {
		return severity;
	}

	public final Statustext setText(String text) {
		this.text = text;
		return this;
	}

	public final String getText() {
		return text;
	}

	public final Statustext setId(int id) {
		this.id = id;
		return this;
	}

	public final int getId() {
		return id;
	}

	public final Statustext setChunkSeq(short chunkSeq) {
		this.chunkSeq = chunkSeq;
		return this;
	}

	public final short getChunkSeq() {
		return chunkSeq;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			Statustext other = (Statustext)o;
			if (!Objects.deepEquals(this.severity, other.severity)) {
				return false;
			} else if (!Objects.deepEquals(this.text, other.text)) {
				return false;
			} else if (!Objects.deepEquals(this.id, other.id)) {
				return false;
			} else {
				return Objects.deepEquals(this.chunkSeq, other.chunkSeq);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.severity);
		result = 31 * result + Objects.hashCode(this.text);
		result = 31 * result + Objects.hashCode(this.id);
		result = 31 * result + Objects.hashCode(this.chunkSeq);
		return result;
	}

	@Override
	public String toString() {
		return "Statustext{" +
				"severity=" + severity +
				", text=" + text +
				", id=" + id +
				", chunkSeq=" + chunkSeq +
				'}';
	}
}