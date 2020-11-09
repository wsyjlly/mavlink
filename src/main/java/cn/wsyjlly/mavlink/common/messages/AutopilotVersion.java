package cn.wsyjlly.mavlink.common.messages;

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
 * Date 2020.11.09 - 03:37
 **********************************/

@MavlinkMessage(
		id = 148,
		messagePayloadLength = 20,
		description = "Version and capability of autopilot software"
)
public class AutopilotVersion implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8)
	private BigInteger capabilities;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 2, typeSize = 4, streamLength = 4)
	private long version;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 8)
	private short customVersion;

	private final int messagePayloadLength = 20;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public AutopilotVersion(BigInteger capabilities, long version, short customVersion) {
		this.capabilities = capabilities;
		this.version = version;
		this.customVersion = customVersion;
	}

	public AutopilotVersion(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 20！");
		}
		messagePayload(messagePayload);
	}

	public AutopilotVersion(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.capabilities = byteArray.getUnsignedInt64(0);
		this.version = byteArray.getUnsignedInt32(8);
		this.customVersion = byteArray.getUnsignedInt8(12);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final AutopilotVersion setCapabilities(BigInteger capabilities) {
		this.capabilities = capabilities;
		return this;
	}

	public final BigInteger getCapabilities() {
		return capabilities;
	}

	public final AutopilotVersion setVersion(long version) {
		this.version = version;
		return this;
	}

	public final long getVersion() {
		return version;
	}

	public final AutopilotVersion setCustomVersion(short customVersion) {
		this.customVersion = customVersion;
		return this;
	}

	public final short getCustomVersion() {
		return customVersion;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			AutopilotVersion other = (AutopilotVersion)o;
			if (!Objects.deepEquals(this.capabilities, other.capabilities)) {
				return false;
			} else if (!Objects.deepEquals(this.version, other.version)) {
				return false;
			} else {
				return Objects.deepEquals(this.customVersion, other.customVersion);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.capabilities);
		result = 31 * result + Objects.hashCode(this.version);
		result = 31 * result + Objects.hashCode(this.customVersion);
		return result;
	}

	@Override
	public String toString() {
		return "AutopilotVersion{" +
				"capabilities=" + capabilities +
				", version=" + version +
				", customVersion=" + customVersion +
				'}';
	}
}