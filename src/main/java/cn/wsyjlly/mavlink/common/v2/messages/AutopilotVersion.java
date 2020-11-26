package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavProtocolCapability;
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
		id = 148,
		messagePayloadLength = 78,
		description = "Version and capability of autopilot software. This should be emitted in response to a request with MAV_CMD_REQUEST_MESSAGE."
)
public class AutopilotVersion implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Bitmap of capabilities", enum0 = MavProtocolCapability.class)
	private BigInteger capabilities;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 2, typeSize = 4, streamLength = 4, description = "Firmware version number")
	private long flightSwVersion;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 3, typeSize = 4, streamLength = 4, description = "Middleware version number")
	private long middlewareSwVersion;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 4, typeSize = 4, streamLength = 4, description = "Operating system version number")
	private long osSwVersion;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 5, typeSize = 4, streamLength = 4, description = "HW / board version (last 8 bytes should be silicon ID, if any)")
	private long boardVersion;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 8, description = "Custom version field, commonly the first 8 bytes of the git hash. This is not an unique identifier, but should allow to identify the commit using the main version number even for very large code bases.")
	private short[] flightCustomVersion = new short[8];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 7, typeSize = 1, streamLength = 8, description = "Custom version field, commonly the first 8 bytes of the git hash. This is not an unique identifier, but should allow to identify the commit using the main version number even for very large code bases.")
	private short[] middlewareCustomVersion = new short[8];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 8, typeSize = 1, streamLength = 8, description = "Custom version field, commonly the first 8 bytes of the git hash. This is not an unique identifier, but should allow to identify the commit using the main version number even for very large code bases.")
	private short[] osCustomVersion = new short[8];

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 9, typeSize = 2, streamLength = 2, description = "ID of the board vendor")
	private int vendorId;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 10, typeSize = 2, streamLength = 2, description = "ID of the product")
	private int productId;

	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 11, typeSize = 8, streamLength = 8, description = "UID if provided by hardware (see uid2)")
	private BigInteger uid;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 12, typeSize = 1, streamLength = 18, description = "UID if provided by hardware (supersedes the uid field. If this is non-zero, use this field, otherwise use uid)")
	private short[] uid2 = new short[18];

	private final int messagePayloadLength = 78;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public AutopilotVersion(BigInteger capabilities, long flightSwVersion, long middlewareSwVersion, long osSwVersion, long boardVersion, short[] flightCustomVersion, short[] middlewareCustomVersion, short[] osCustomVersion, int vendorId, int productId, BigInteger uid, short[] uid2) {
		this.capabilities = capabilities;
		this.flightSwVersion = flightSwVersion;
		this.middlewareSwVersion = middlewareSwVersion;
		this.osSwVersion = osSwVersion;
		this.boardVersion = boardVersion;
		this.flightCustomVersion = flightCustomVersion;
		this.middlewareCustomVersion = middlewareCustomVersion;
		this.osCustomVersion = osCustomVersion;
		this.vendorId = vendorId;
		this.productId = productId;
		this.uid = uid;
		this.uid2 = uid2;
	}

	public AutopilotVersion(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 78！");
		}
		messagePayload(messagePayload);
	}

	public AutopilotVersion(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		capabilities = byteArray.getUnsignedInt64(0);
		flightSwVersion = byteArray.getUnsignedInt32(8);
		middlewareSwVersion = byteArray.getUnsignedInt32(12);
		osSwVersion = byteArray.getUnsignedInt32(16);
		boardVersion = byteArray.getUnsignedInt32(20);
		flightCustomVersion = byteArray.getUnsignedInt8Array(24,8);
		middlewareCustomVersion = byteArray.getUnsignedInt8Array(32,8);
		osCustomVersion = byteArray.getUnsignedInt8Array(40,8);
		vendorId = byteArray.getUnsignedInt16(48);
		productId = byteArray.getUnsignedInt16(50);
		uid = byteArray.getUnsignedInt64(52);
		uid2 = byteArray.getUnsignedInt8Array(60,18);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(capabilities,0);
		byteArray.putUnsignedInt32(flightSwVersion,8);
		byteArray.putUnsignedInt32(middlewareSwVersion,12);
		byteArray.putUnsignedInt32(osSwVersion,16);
		byteArray.putUnsignedInt32(boardVersion,20);
		byteArray.putUnsignedInt8Array(flightCustomVersion,24);
		byteArray.putUnsignedInt8Array(middlewareCustomVersion,32);
		byteArray.putUnsignedInt8Array(osCustomVersion,40);
		byteArray.putUnsignedInt16(vendorId,48);
		byteArray.putUnsignedInt16(productId,50);
		byteArray.putUnsignedInt64(uid,52);
		byteArray.putUnsignedInt8Array(uid2,60);
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

	public final AutopilotVersion setFlightSwVersion(long flightSwVersion) {
		this.flightSwVersion = flightSwVersion;
		return this;
	}

	public final long getFlightSwVersion() {
		return flightSwVersion;
	}

	public final AutopilotVersion setMiddlewareSwVersion(long middlewareSwVersion) {
		this.middlewareSwVersion = middlewareSwVersion;
		return this;
	}

	public final long getMiddlewareSwVersion() {
		return middlewareSwVersion;
	}

	public final AutopilotVersion setOsSwVersion(long osSwVersion) {
		this.osSwVersion = osSwVersion;
		return this;
	}

	public final long getOsSwVersion() {
		return osSwVersion;
	}

	public final AutopilotVersion setBoardVersion(long boardVersion) {
		this.boardVersion = boardVersion;
		return this;
	}

	public final long getBoardVersion() {
		return boardVersion;
	}

	public final AutopilotVersion setFlightCustomVersion(short[] flightCustomVersion) {
		this.flightCustomVersion = flightCustomVersion;
		return this;
	}

	public final short[] getFlightCustomVersion() {
		return flightCustomVersion;
	}

	public final AutopilotVersion setMiddlewareCustomVersion(short[] middlewareCustomVersion) {
		this.middlewareCustomVersion = middlewareCustomVersion;
		return this;
	}

	public final short[] getMiddlewareCustomVersion() {
		return middlewareCustomVersion;
	}

	public final AutopilotVersion setOsCustomVersion(short[] osCustomVersion) {
		this.osCustomVersion = osCustomVersion;
		return this;
	}

	public final short[] getOsCustomVersion() {
		return osCustomVersion;
	}

	public final AutopilotVersion setVendorId(int vendorId) {
		this.vendorId = vendorId;
		return this;
	}

	public final int getVendorId() {
		return vendorId;
	}

	public final AutopilotVersion setProductId(int productId) {
		this.productId = productId;
		return this;
	}

	public final int getProductId() {
		return productId;
	}

	public final AutopilotVersion setUid(BigInteger uid) {
		this.uid = uid;
		return this;
	}

	public final BigInteger getUid() {
		return uid;
	}

	public final AutopilotVersion setUid2(short[] uid2) {
		this.uid2 = uid2;
		return this;
	}

	public final short[] getUid2() {
		return uid2;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			AutopilotVersion other = (AutopilotVersion)o;
			if (!Objects.deepEquals(this.capabilities, other.capabilities)) {
				return false;
			} else if (!Objects.deepEquals(this.flightSwVersion, other.flightSwVersion)) {
				return false;
			} else if (!Objects.deepEquals(this.middlewareSwVersion, other.middlewareSwVersion)) {
				return false;
			} else if (!Objects.deepEquals(this.osSwVersion, other.osSwVersion)) {
				return false;
			} else if (!Objects.deepEquals(this.boardVersion, other.boardVersion)) {
				return false;
			} else if (!Objects.deepEquals(this.flightCustomVersion, other.flightCustomVersion)) {
				return false;
			} else if (!Objects.deepEquals(this.middlewareCustomVersion, other.middlewareCustomVersion)) {
				return false;
			} else if (!Objects.deepEquals(this.osCustomVersion, other.osCustomVersion)) {
				return false;
			} else if (!Objects.deepEquals(this.vendorId, other.vendorId)) {
				return false;
			} else if (!Objects.deepEquals(this.productId, other.productId)) {
				return false;
			} else if (!Objects.deepEquals(this.uid, other.uid)) {
				return false;
			} else {
				return Objects.deepEquals(this.uid2, other.uid2);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.capabilities);
		result = 31 * result + Objects.hashCode(this.flightSwVersion);
		result = 31 * result + Objects.hashCode(this.middlewareSwVersion);
		result = 31 * result + Objects.hashCode(this.osSwVersion);
		result = 31 * result + Objects.hashCode(this.boardVersion);
		result = 31 * result + Objects.hashCode(this.flightCustomVersion);
		result = 31 * result + Objects.hashCode(this.middlewareCustomVersion);
		result = 31 * result + Objects.hashCode(this.osCustomVersion);
		result = 31 * result + Objects.hashCode(this.vendorId);
		result = 31 * result + Objects.hashCode(this.productId);
		result = 31 * result + Objects.hashCode(this.uid);
		result = 31 * result + Objects.hashCode(this.uid2);
		return result;
	}

	@Override
	public String toString() {
		return "AutopilotVersion{" +
				"capabilities=" + capabilities +
				", flightSwVersion=" + flightSwVersion +
				", middlewareSwVersion=" + middlewareSwVersion +
				", osSwVersion=" + osSwVersion +
				", boardVersion=" + boardVersion +
				", flightCustomVersion=" + Arrays.toString(flightCustomVersion) +
				", middlewareCustomVersion=" + Arrays.toString(middlewareCustomVersion) +
				", osCustomVersion=" + Arrays.toString(osCustomVersion) +
				", vendorId=" + vendorId +
				", productId=" + productId +
				", uid=" + uid +
				", uid2=" + Arrays.toString(uid2) +
				'}';
	}
}