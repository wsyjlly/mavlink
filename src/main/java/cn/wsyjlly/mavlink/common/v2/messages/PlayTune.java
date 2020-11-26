package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
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
		id = 258,
		messagePayloadLength = 232,
		description = "Control vehicle tone generation (buzzer)."
)
public class PlayTune implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "char", position = 3, typeSize = 1, streamLength = 30, description = "tune in board specific format")
	private String tune;

	@MavlinkMessageParam(mavlinkType = "char", position = 4, typeSize = 1, streamLength = 200, description = "tune extension (appended to tune)")
	private String tune2;

	private final int messagePayloadLength = 232;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public PlayTune(short targetSystem, short targetComponent, String tune, String tune2) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.tune = tune;
		this.tune2 = tune2;
	}

	public PlayTune(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 232！");
		}
		messagePayload(messagePayload);
	}

	public PlayTune(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		tune = byteArray.getChars(2,30);
		tune2 = byteArray.getChars(32,200);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putChars(tune,2);
		byteArray.putChars(tune2,32);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final PlayTune setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final PlayTune setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final PlayTune setTune(String tune) {
		this.tune = tune;
		return this;
	}

	public final String getTune() {
		return tune;
	}

	public final PlayTune setTune2(String tune2) {
		this.tune2 = tune2;
		return this;
	}

	public final String getTune2() {
		return tune2;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			PlayTune other = (PlayTune)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.tune, other.tune)) {
				return false;
			} else {
				return Objects.deepEquals(this.tune2, other.tune2);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.targetSystem);
		result = 31 * result + Objects.hashCode(this.targetComponent);
		result = 31 * result + Objects.hashCode(this.tune);
		result = 31 * result + Objects.hashCode(this.tune2);
		return result;
	}

	@Override
	public String toString() {
		return "PlayTune{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", tune=" + tune +
				", tune2=" + tune2 +
				'}';
	}
}