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
		id = 5,
		messagePayloadLength = 28,
		description = "Request to control this MAV"
)
public class ChangeOperatorControl implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System the GCS requests control for")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "0: request control of this MAV, 1: Release control of this MAV")
	private short controlRequest;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "0: key as plaintext, 1-255: future, different hashing/encryption variants. The GCS should in general use the safest mode possible initially and then gradually move down the encryption level if it gets a NACK message indicating an encryption mismatch.", units = "rad")
	private short version;

	@MavlinkMessageParam(mavlinkType = "char", position = 4, typeSize = 1, streamLength = 25, description = "Password / Key, depending on version plaintext or encrypted. 25 or less characters, NULL terminated. The characters may involve A-Z, a-z, 0-9, and '!?,.-'")
	private String passkey;

	private final int messagePayloadLength = 28;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ChangeOperatorControl(short targetSystem, short controlRequest, short version, String passkey) {
		this.targetSystem = targetSystem;
		this.controlRequest = controlRequest;
		this.version = version;
		this.passkey = passkey;
	}

	public ChangeOperatorControl(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 28！");
		}
		messagePayload(messagePayload);
	}

	public ChangeOperatorControl(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		controlRequest = byteArray.getUnsignedInt8(1);
		version = byteArray.getUnsignedInt8(2);
		passkey = byteArray.getChars(3,25);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(controlRequest,1);
		byteArray.putUnsignedInt8(version,2);
		byteArray.putChars(passkey,3);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ChangeOperatorControl setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final ChangeOperatorControl setControlRequest(short controlRequest) {
		this.controlRequest = controlRequest;
		return this;
	}

	public final short getControlRequest() {
		return controlRequest;
	}

	public final ChangeOperatorControl setVersion(short version) {
		this.version = version;
		return this;
	}

	public final short getVersion() {
		return version;
	}

	public final ChangeOperatorControl setPasskey(String passkey) {
		this.passkey = passkey;
		return this;
	}

	public final String getPasskey() {
		return passkey;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ChangeOperatorControl other = (ChangeOperatorControl)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.controlRequest, other.controlRequest)) {
				return false;
			} else if (!Objects.deepEquals(this.version, other.version)) {
				return false;
			} else {
				return Objects.deepEquals(this.passkey, other.passkey);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.targetSystem);
		result = 31 * result + Objects.hashCode(this.controlRequest);
		result = 31 * result + Objects.hashCode(this.version);
		result = 31 * result + Objects.hashCode(this.passkey);
		return result;
	}

	@Override
	public String toString() {
		return "ChangeOperatorControl{" +
				"targetSystem=" + targetSystem +
				", controlRequest=" + controlRequest +
				", version=" + version +
				", passkey=" + passkey +
				'}';
	}
}