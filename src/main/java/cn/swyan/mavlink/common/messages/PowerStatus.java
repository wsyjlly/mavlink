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
		id = 125,
		messagePayloadLength = 6,
		description = "Power supply status"
)
public class PowerStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 1, typeSize = 2, streamLength = 2)
	private int vcc;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 2, typeSize = 2, streamLength = 2)
	private int vservo;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2)
	private int flags;

	private final int messagePayloadLength = 6;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public PowerStatus(int vcc, int vservo, int flags) {
		this.vcc = vcc;
		this.vservo = vservo;
		this.flags = flags;
	}

	public PowerStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 6！");
		}
		messagePayload(messagePayload);
	}

	public PowerStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.vcc = byteArray.getUnsignedInt16(0);
		this.vservo = byteArray.getUnsignedInt16(2);
		this.flags = byteArray.getUnsignedInt16(4);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final PowerStatus setVcc(int vcc) {
		this.vcc = vcc;
		return this;
	}

	public final int getVcc() {
		return vcc;
	}

	public final PowerStatus setVservo(int vservo) {
		this.vservo = vservo;
		return this;
	}

	public final int getVservo() {
		return vservo;
	}

	public final PowerStatus setFlags(int flags) {
		this.flags = flags;
		return this;
	}

	public final int getFlags() {
		return flags;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			PowerStatus other = (PowerStatus)o;
			if (!Objects.deepEquals(this.vcc, other.vcc)) {
				return false;
			} else if (!Objects.deepEquals(this.vservo, other.vservo)) {
				return false;
			} else {
				return Objects.deepEquals(this.flags, other.flags);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.vcc);
		result = 31 * result + Objects.hashCode(this.vservo);
		result = 31 * result + Objects.hashCode(this.flags);
		return result;
	}

	@Override
	public String toString() {
		return "PowerStatus{" +
				"vcc=" + vcc +
				", vservo=" + vservo +
				", flags=" + flags +
				'}';
	}
}