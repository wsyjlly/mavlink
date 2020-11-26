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
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkMessage(
		id = 300,
		messagePayloadLength = 22,
		description = "Version and capability of protocol version. This message can be requested with MAV_CMD_REQUEST_MESSAGE and is used as part of the handshaking to establish which MAVLink version should be used on the network. Every node should respond to a request for PROTOCOL_VERSION to enable the handshaking. Library implementers should consider adding this into the default decoding state machine to allow the protocol core to respond directly."
)
public class ProtocolVersion implements Message {
	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 1, typeSize = 2, streamLength = 2, description = "Currently active MAVLink version number * 100: v1.0 is 100, v2.0 is 200, etc.")
	private int version;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 2, typeSize = 2, streamLength = 2, description = "Minimum MAVLink version supported")
	private int minVersion;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2, description = "Maximum MAVLink version supported (set to the same value as version by default)")
	private int maxVersion;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 8, description = "The first 8 bytes (not characters printed in hex!) of the git hash.")
	private short[] specVersionHash = new short[8];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 8, description = "The first 8 bytes (not characters printed in hex!) of the git hash.")
	private short[] libraryVersionHash = new short[8];

	private final int messagePayloadLength = 22;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ProtocolVersion(int version, int minVersion, int maxVersion, short[] specVersionHash, short[] libraryVersionHash) {
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
		version = byteArray.getUnsignedInt16(0);
		minVersion = byteArray.getUnsignedInt16(2);
		maxVersion = byteArray.getUnsignedInt16(4);
		specVersionHash = byteArray.getUnsignedInt8Array(6,8);
		libraryVersionHash = byteArray.getUnsignedInt8Array(14,8);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt16(version,0);
		byteArray.putUnsignedInt16(minVersion,2);
		byteArray.putUnsignedInt16(maxVersion,4);
		byteArray.putUnsignedInt8Array(specVersionHash,6);
		byteArray.putUnsignedInt8Array(libraryVersionHash,14);
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

	public final ProtocolVersion setSpecVersionHash(short[] specVersionHash) {
		this.specVersionHash = specVersionHash;
		return this;
	}

	public final short[] getSpecVersionHash() {
		return specVersionHash;
	}

	public final ProtocolVersion setLibraryVersionHash(short[] libraryVersionHash) {
		this.libraryVersionHash = libraryVersionHash;
		return this;
	}

	public final short[] getLibraryVersionHash() {
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
				", specVersionHash=" + Arrays.toString(specVersionHash) +
				", libraryVersionHash=" + Arrays.toString(libraryVersionHash) +
				'}';
	}
}