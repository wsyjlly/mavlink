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
		id = 300,
		messagePayloadLength = 22,
		description = "Version and capability of protocol version. This message can be requested with MAV_CMD_REQUEST_MESSAGE and is used as part of the handshaking to establish which MAVLink version should be used on the network. Every node should respond to a request for PROTOCOL_VERSION to enable the handshaking. Library implementers should consider adding this into the default decoding state machine to allow the protocol core to respond directly."
)
public class ProtocolVersion implements Message {
	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 1, typeSize = 2, streamLength = 2)
	private int version;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 2, typeSize = 2, streamLength = 2)
	private int minVersion;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2)
	private int maxVersion;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 8)
	private short specVersionHash;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 8)
	private short libraryVersionHash;

	private final int messagePayloadLength = 22;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ProtocolVersion(int version, int minVersion, int maxVersion, short specVersionHash, short libraryVersionHash) {
		this.version = version;
		this.minVersion = minVersion;
		this.maxVersion = maxVersion;
		this.specVersionHash = specVersionHash;
		this.libraryVersionHash = libraryVersionHash;
	}

	public ProtocolVersion(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 22！");
		}
		messagePayload(messagePayload);
	}

	public ProtocolVersion(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.version = byteArray.getUnsignedInt16(0);
		this.minVersion = byteArray.getUnsignedInt16(2);
		this.maxVersion = byteArray.getUnsignedInt16(4);
		this.specVersionHash = byteArray.getUnsignedInt8(6);
		this.libraryVersionHash = byteArray.getUnsignedInt8(7);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ProtocolVersion setVersion(int version) {
		this.version = version;
		return this;
	}

	public final int getVersion() {
		return version;
	}

	public final ProtocolVersion setMinVersion(int minVersion) {
		this.minVersion = minVersion;
		return this;
	}

	public final int getMinVersion() {
		return minVersion;
	}

	public final ProtocolVersion setMaxVersion(int maxVersion) {
		this.maxVersion = maxVersion;
		return this;
	}

	public final int getMaxVersion() {
		return maxVersion;
	}

	public final ProtocolVersion setSpecVersionHash(short specVersionHash) {
		this.specVersionHash = specVersionHash;
		return this;
	}

	public final short getSpecVersionHash() {
		return specVersionHash;
	}

	public final ProtocolVersion setLibraryVersionHash(short libraryVersionHash) {
		this.libraryVersionHash = libraryVersionHash;
		return this;
	}

	public final short getLibraryVersionHash() {
		return libraryVersionHash;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ProtocolVersion other = (ProtocolVersion)o;
			if (!Objects.deepEquals(this.version, other.version)) {
				return false;
			} else if (!Objects.deepEquals(this.minVersion, other.minVersion)) {
				return false;
			} else if (!Objects.deepEquals(this.maxVersion, other.maxVersion)) {
				return false;
			} else if (!Objects.deepEquals(this.specVersionHash, other.specVersionHash)) {
				return false;
			} else {
				return Objects.deepEquals(this.libraryVersionHash, other.libraryVersionHash);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.version);
		result = 31 * result + Objects.hashCode(this.minVersion);
		result = 31 * result + Objects.hashCode(this.maxVersion);
		result = 31 * result + Objects.hashCode(this.specVersionHash);
		result = 31 * result + Objects.hashCode(this.libraryVersionHash);
		return result;
	}

	@Override
	public String toString() {
		return "ProtocolVersion{" +
				"version=" + version +
				", minVersion=" + minVersion +
				", maxVersion=" + maxVersion +
				", specVersionHash=" + specVersionHash +
				", libraryVersionHash=" + libraryVersionHash +
				'}';
	}
}