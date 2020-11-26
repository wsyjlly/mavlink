package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
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
		id = 256,
		messagePayloadLength = 42,
		description = "Setup a MAVLink2 signing key. If called with secret_key of all zero and zero initial_timestamp will disable signing"
)
public class SetupSigning implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "system id of the target")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "component ID of the target")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 32, description = "signing key")
	private short[] secretKey = new short[32];

	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 4, typeSize = 8, streamLength = 8, description = "initial timestamp")
	private BigInteger initialTimestamp;

	private final int messagePayloadLength = 42;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public SetupSigning(short targetSystem, short targetComponent, short[] secretKey, BigInteger initialTimestamp) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.secretKey = secretKey;
		this.initialTimestamp = initialTimestamp;
	}

	public SetupSigning(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 42！");
		}
		messagePayload(messagePayload);
	}

	public SetupSigning(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		secretKey = byteArray.getUnsignedInt8Array(2,32);
		initialTimestamp = byteArray.getUnsignedInt64(34);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putUnsignedInt8Array(secretKey,2);
		byteArray.putUnsignedInt64(initialTimestamp,34);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final SetupSigning setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final SetupSigning setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final SetupSigning setSecretKey(short[] secretKey) {
		this.secretKey = secretKey;
		return this;
	}

	public final short[] getSecretKey() {
		return secretKey;
	}

	public final SetupSigning setInitialTimestamp(BigInteger initialTimestamp) {
		this.initialTimestamp = initialTimestamp;
		return this;
	}

	public final BigInteger getInitialTimestamp() {
		return initialTimestamp;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			SetupSigning other = (SetupSigning)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.secretKey, other.secretKey)) {
				return false;
			} else {
				return Objects.deepEquals(this.initialTimestamp, other.initialTimestamp);
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
		result = 31 * result + Objects.hashCode(this.secretKey);
		result = 31 * result + Objects.hashCode(this.initialTimestamp);
		return result;
	}

	@Override
	public String toString() {
		return "SetupSigning{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", secretKey=" + Arrays.toString(secretKey) +
				", initialTimestamp=" + initialTimestamp +
				'}';
	}
}