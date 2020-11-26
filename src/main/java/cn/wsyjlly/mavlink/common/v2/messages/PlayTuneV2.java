package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.TuneFormat;
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
		id = 400,
		messagePayloadLength = 254,
		description = "Play vehicle tone/tune (buzzer). Supersedes message PLAY_TUNE."
)
public class PlayTuneV2 implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 3, typeSize = 4, streamLength = 4, description = "Tune format", enum0 = TuneFormat.class)
	private long format;

	@MavlinkMessageParam(mavlinkType = "char", position = 4, typeSize = 1, streamLength = 248, description = "Tune definition as a NULL-terminated string.")
	private String tune;

	private final int messagePayloadLength = 254;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public PlayTuneV2(short targetSystem, short targetComponent, long format, String tune) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.format = format;
		this.tune = tune;
	}

	public PlayTuneV2(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 254！");
		}
		messagePayload(messagePayload);
	}

	public PlayTuneV2(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		format = byteArray.getUnsignedInt32(2);
		tune = byteArray.getChars(6,248);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putUnsignedInt32(format,2);
		byteArray.putChars(tune,6);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final PlayTuneV2 setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final PlayTuneV2 setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final PlayTuneV2 setFormat(long format) {
		this.format = format;
		return this;
	}

	public final long getFormat() {
		return format;
	}

	public final PlayTuneV2 setTune(String tune) {
		this.tune = tune;
		return this;
	}

	public final String getTune() {
		return tune;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			PlayTuneV2 other = (PlayTuneV2)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.format, other.format)) {
				return false;
			} else {
				return Objects.deepEquals(this.tune, other.tune);
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
		result = 31 * result + Objects.hashCode(this.format);
		result = 31 * result + Objects.hashCode(this.tune);
		return result;
	}

	@Override
	public String toString() {
		return "PlayTuneV2{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", format=" + format +
				", tune=" + tune +
				'}';
	}
}