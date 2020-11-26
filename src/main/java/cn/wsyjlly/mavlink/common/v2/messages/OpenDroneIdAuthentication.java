package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavOdidAuthType;
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
		id = 12902,
		messagePayloadLength = 53,
		description = "Data for filling the OpenDroneID Authentication message. The Authentication Message defines a field that can provide a means of authenticity for the identity of the UAS (Unmanned Aircraft System). The Authentication message can have two different formats. Five data pages are supported. For data page 0, the fields PageCount, Length and TimeStamp are present and AuthData is only 17 bytes. For data page 1 through 4, PageCount, Length and TimeStamp are not present and the size of AuthData is 23 bytes."
)
public class OpenDroneIdAuthentication implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID (0 for broadcast).")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID (0 for broadcast).")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 20, description = "Only used for drone ID data received from other UAs. See detailed description at https://mavlink.io/en/services/opendroneid.html.")
	private short[] idOrMac = new short[20];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "Indicates the type of authentication.", enum0 = MavOdidAuthType.class)
	private short authenticationType;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1, description = "Allowed range is 0 - 4.")
	private short dataPage;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 1, description = "This field is only present for page 0. Allowed range is 0 - 5.")
	private short pageCount;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 7, typeSize = 1, streamLength = 1, description = "This field is only present for page 0. Total bytes of authentication_data from all data pages. Allowed range is 0 - 109 (17 + 23*4).", units = "bytes")
	private short length;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 8, typeSize = 4, streamLength = 4, description = "This field is only present for page 0. 32 bit Unix Timestamp in seconds since 00:00:00 01/01/2019.", units = "s")
	private long timestamp;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 9, typeSize = 1, streamLength = 23, description = "Opaque authentication data. For page 0, the size is only 17 bytes. For other pages, the size is 23 bytes. Shall be filled with nulls in the unused portion of the field.")
	private short[] authenticationData = new short[23];

	private final int messagePayloadLength = 53;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public OpenDroneIdAuthentication(short targetSystem, short targetComponent, short[] idOrMac, short authenticationType, short dataPage, short pageCount, short length, long timestamp, short[] authenticationData) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.idOrMac = idOrMac;
		this.authenticationType = authenticationType;
		this.dataPage = dataPage;
		this.pageCount = pageCount;
		this.length = length;
		this.timestamp = timestamp;
		this.authenticationData = authenticationData;
	}

	public OpenDroneIdAuthentication(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 53！");
		}
		messagePayload(messagePayload);
	}

	public OpenDroneIdAuthentication(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		idOrMac = byteArray.getUnsignedInt8Array(2,20);
		authenticationType = byteArray.getUnsignedInt8(22);
		dataPage = byteArray.getUnsignedInt8(23);
		pageCount = byteArray.getUnsignedInt8(24);
		length = byteArray.getUnsignedInt8(25);
		timestamp = byteArray.getUnsignedInt32(26);
		authenticationData = byteArray.getUnsignedInt8Array(30,23);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putUnsignedInt8Array(idOrMac,2);
		byteArray.putUnsignedInt8(authenticationType,22);
		byteArray.putUnsignedInt8(dataPage,23);
		byteArray.putUnsignedInt8(pageCount,24);
		byteArray.putUnsignedInt8(length,25);
		byteArray.putUnsignedInt32(timestamp,26);
		byteArray.putUnsignedInt8Array(authenticationData,30);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final OpenDroneIdAuthentication setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final OpenDroneIdAuthentication setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final OpenDroneIdAuthentication setIdOrMac(short[] idOrMac) {
		this.idOrMac = idOrMac;
		return this;
	}

	public final short[] getIdOrMac() {
		return idOrMac;
	}

	public final OpenDroneIdAuthentication setAuthenticationType(short authenticationType) {
		this.authenticationType = authenticationType;
		return this;
	}

	public final short getAuthenticationType() {
		return authenticationType;
	}

	public final OpenDroneIdAuthentication setDataPage(short dataPage) {
		this.dataPage = dataPage;
		return this;
	}

	public final short getDataPage() {
		return dataPage;
	}

	public final OpenDroneIdAuthentication setPageCount(short pageCount) {
		this.pageCount = pageCount;
		return this;
	}

	public final short getPageCount() {
		return pageCount;
	}

	public final OpenDroneIdAuthentication setLength(short length) {
		this.length = length;
		return this;
	}

	public final short getLength() {
		return length;
	}

	public final OpenDroneIdAuthentication setTimestamp(long timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	public final long getTimestamp() {
		return timestamp;
	}

	public final OpenDroneIdAuthentication setAuthenticationData(short[] authenticationData) {
		this.authenticationData = authenticationData;
		return this;
	}

	public final short[] getAuthenticationData() {
		return authenticationData;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			OpenDroneIdAuthentication other = (OpenDroneIdAuthentication)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.idOrMac, other.idOrMac)) {
				return false;
			} else if (!Objects.deepEquals(this.authenticationType, other.authenticationType)) {
				return false;
			} else if (!Objects.deepEquals(this.dataPage, other.dataPage)) {
				return false;
			} else if (!Objects.deepEquals(this.pageCount, other.pageCount)) {
				return false;
			} else if (!Objects.deepEquals(this.length, other.length)) {
				return false;
			} else if (!Objects.deepEquals(this.timestamp, other.timestamp)) {
				return false;
			} else {
				return Objects.deepEquals(this.authenticationData, other.authenticationData);
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
		result = 31 * result + Objects.hashCode(this.idOrMac);
		result = 31 * result + Objects.hashCode(this.authenticationType);
		result = 31 * result + Objects.hashCode(this.dataPage);
		result = 31 * result + Objects.hashCode(this.pageCount);
		result = 31 * result + Objects.hashCode(this.length);
		result = 31 * result + Objects.hashCode(this.timestamp);
		result = 31 * result + Objects.hashCode(this.authenticationData);
		return result;
	}

	@Override
	public String toString() {
		return "OpenDroneIdAuthentication{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", idOrMac=" + Arrays.toString(idOrMac) +
				", authenticationType=" + authenticationType +
				", dataPage=" + dataPage +
				", pageCount=" + pageCount +
				", length=" + length +
				", timestamp=" + timestamp +
				", authenticationData=" + Arrays.toString(authenticationData) +
				'}';
	}
}