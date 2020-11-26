package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 257,
		messagePayloadLength = 9,
		description = "Report button state change."
)
public class ButtonChange implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp (time since system boot).", units = "ms")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 2, typeSize = 4, streamLength = 4, description = "Time of last change of button state.", units = "ms")
	private long lastChangeMs;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Bitmap for state of buttons.")
	private short state;

	private final int messagePayloadLength = 9;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ButtonChange(long timeBootMs, long lastChangeMs, short state) {
		this.timeBootMs = timeBootMs;
		this.lastChangeMs = lastChangeMs;
		this.state = state;
	}

	public ButtonChange(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 9！");
		}
		messagePayload(messagePayload);
	}

	public ButtonChange(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeBootMs = byteArray.getUnsignedInt32(0);
		lastChangeMs = byteArray.getUnsignedInt32(4);
		state = byteArray.getUnsignedInt8(8);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeBootMs,0);
		byteArray.putUnsignedInt32(lastChangeMs,4);
		byteArray.putUnsignedInt8(state,8);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ButtonChange setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final ButtonChange setLastChangeMs(long lastChangeMs) {
		this.lastChangeMs = lastChangeMs;
		return this;
	}

	public final long getLastChangeMs() {
		return lastChangeMs;
	}

	public final ButtonChange setState(short state) {
		this.state = state;
		return this;
	}

	public final short getState() {
		return state;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ButtonChange other = (ButtonChange)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.lastChangeMs, other.lastChangeMs)) {
				return false;
			} else {
				return Objects.deepEquals(this.state, other.state);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeBootMs);
		result = 31 * result + Objects.hashCode(this.lastChangeMs);
		result = 31 * result + Objects.hashCode(this.state);
		return result;
	}

	@Override
	public String toString() {
		return "ButtonChange{" +
				"timeBootMs=" + timeBootMs +
				", lastChangeMs=" + lastChangeMs +
				", state=" + state +
				'}';
	}
}