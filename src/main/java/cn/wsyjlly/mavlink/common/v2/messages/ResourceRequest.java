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
		id = 142,
		messagePayloadLength = 243,
		description = "The autopilot is requesting a resource (file, binary, other type of data)"
)
public class ResourceRequest implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "Request ID. This ID should be re-used when sending back URI contents")
	private short requestId;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "The type of requested URI. 0 = a file via URL. 1 = a UAVCAN binary")
	private short uriType;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 120, description = "The requested unique resource identifier (URI). It is not necessarily a straight domain name (depends on the URI type enum)")
	private short[] uri = new short[120];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "The way the autopilot wants to receive the URI. 0 = MAVLink FTP. 1 = binary stream.")
	private short transferType;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 120, description = "The storage path the autopilot wants the URI to be stored in. Will only be valid if the transfer_type has a storage associated (e.g. MAVLink FTP).")
	private short[] storage = new short[120];

	private final int messagePayloadLength = 243;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ResourceRequest(short requestId, short uriType, short[] uri, short transferType, short[] storage) {
		this.requestId = requestId;
		this.uriType = uriType;
		this.uri = uri;
		this.transferType = transferType;
		this.storage = storage;
	}

	public ResourceRequest(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 243！");
		}
		messagePayload(messagePayload);
	}

	public ResourceRequest(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		requestId = byteArray.getUnsignedInt8(0);
		uriType = byteArray.getUnsignedInt8(1);
		uri = byteArray.getUnsignedInt8Array(2,120);
		transferType = byteArray.getUnsignedInt8(122);
		storage = byteArray.getUnsignedInt8Array(123,120);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(requestId,0);
		byteArray.putUnsignedInt8(uriType,1);
		byteArray.putUnsignedInt8Array(uri,2);
		byteArray.putUnsignedInt8(transferType,122);
		byteArray.putUnsignedInt8Array(storage,123);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ResourceRequest setRequestId(short requestId) {
		this.requestId = requestId;
		return this;
	}

	public final short getRequestId() {
		return requestId;
	}

	public final ResourceRequest setUriType(short uriType) {
		this.uriType = uriType;
		return this;
	}

	public final short getUriType() {
		return uriType;
	}

	public final ResourceRequest setUri(short[] uri) {
		this.uri = uri;
		return this;
	}

	public final short[] getUri() {
		return uri;
	}

	public final ResourceRequest setTransferType(short transferType) {
		this.transferType = transferType;
		return this;
	}

	public final short getTransferType() {
		return transferType;
	}

	public final ResourceRequest setStorage(short[] storage) {
		this.storage = storage;
		return this;
	}

	public final short[] getStorage() {
		return storage;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ResourceRequest other = (ResourceRequest)o;
			if (!Objects.deepEquals(this.requestId, other.requestId)) {
				return false;
			} else if (!Objects.deepEquals(this.uriType, other.uriType)) {
				return false;
			} else if (!Objects.deepEquals(this.uri, other.uri)) {
				return false;
			} else if (!Objects.deepEquals(this.transferType, other.transferType)) {
				return false;
			} else {
				return Objects.deepEquals(this.storage, other.storage);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.requestId);
		result = 31 * result + Objects.hashCode(this.uriType);
		result = 31 * result + Objects.hashCode(this.uri);
		result = 31 * result + Objects.hashCode(this.transferType);
		result = 31 * result + Objects.hashCode(this.storage);
		return result;
	}

	@Override
	public String toString() {
		return "ResourceRequest{" +
				"requestId=" + requestId +
				", uriType=" + uriType +
				", uri=" + Arrays.toString(uri) +
				", transferType=" + transferType +
				", storage=" + Arrays.toString(storage) +
				'}';
	}
}