package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.CompMetadataType;
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
		id = 395,
		messagePayloadLength = 156,
		description = "Information about a component. For camera components instead use CAMERA_INFORMATION, and for autopilots use AUTOPILOT_VERSION. Components including GCSes should consider supporting requests of this message via MAV_CMD_REQUEST_MESSAGE."
)
public class ComponentInformation implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp (time since system boot).", units = "ms")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 2, typeSize = 4, streamLength = 4, description = "The type of metadata being requested.", enum0 = CompMetadataType.class)
	private long metadataType;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 3, typeSize = 4, streamLength = 4, description = "Unique uid for this metadata which a gcs can use for created cached metadata and understanding whether it's cache it up to date or whether it needs to download new data.")
	private long metadataUid;

	@MavlinkMessageParam(mavlinkType = "char", position = 4, typeSize = 1, streamLength = 70, description = "Component definition URI. If prefix mavlinkftp:// file is downloaded from vehicle over mavlink ftp protocol. If prefix http[s]:// file is downloaded over internet. Files are json format. They can end in .gz to indicate file is in gzip format.")
	private String metadataUri;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 5, typeSize = 4, streamLength = 4, description = "Unique uid for the translation file associated with the metadata.")
	private long translationUid;

	@MavlinkMessageParam(mavlinkType = "char", position = 6, typeSize = 1, streamLength = 70, description = "The translations for strings within the metadata file. If null the either do not exist or may be included in the metadata file itself. The translations specified here supercede any which may be in the metadata file itself. The uri format is the same as component_metadata_uri . Files are in Json Translation spec format. Empty string indicates no tranlsation file.")
	private String translationUri;

	private final int messagePayloadLength = 156;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ComponentInformation(long timeBootMs, long metadataType, long metadataUid, String metadataUri, long translationUid, String translationUri) {
		this.timeBootMs = timeBootMs;
		this.metadataType = metadataType;
		this.metadataUid = metadataUid;
		this.metadataUri = metadataUri;
		this.translationUid = translationUid;
		this.translationUri = translationUri;
	}

	public ComponentInformation(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 156！");
		}
		messagePayload(messagePayload);
	}

	public ComponentInformation(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeBootMs = byteArray.getUnsignedInt32(0);
		metadataType = byteArray.getUnsignedInt32(4);
		metadataUid = byteArray.getUnsignedInt32(8);
		metadataUri = byteArray.getChars(12,70);
		translationUid = byteArray.getUnsignedInt32(82);
		translationUri = byteArray.getChars(86,70);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeBootMs,0);
		byteArray.putUnsignedInt32(metadataType,4);
		byteArray.putUnsignedInt32(metadataUid,8);
		byteArray.putChars(metadataUri,12);
		byteArray.putUnsignedInt32(translationUid,82);
		byteArray.putChars(translationUri,86);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ComponentInformation setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final ComponentInformation setMetadataType(long metadataType) {
		this.metadataType = metadataType;
		return this;
	}

	public final long getMetadataType() {
		return metadataType;
	}

	public final ComponentInformation setMetadataUid(long metadataUid) {
		this.metadataUid = metadataUid;
		return this;
	}

	public final long getMetadataUid() {
		return metadataUid;
	}

	public final ComponentInformation setMetadataUri(String metadataUri) {
		this.metadataUri = metadataUri;
		return this;
	}

	public final String getMetadataUri() {
		return metadataUri;
	}

	public final ComponentInformation setTranslationUid(long translationUid) {
		this.translationUid = translationUid;
		return this;
	}

	public final long getTranslationUid() {
		return translationUid;
	}

	public final ComponentInformation setTranslationUri(String translationUri) {
		this.translationUri = translationUri;
		return this;
	}

	public final String getTranslationUri() {
		return translationUri;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ComponentInformation other = (ComponentInformation)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.metadataType, other.metadataType)) {
				return false;
			} else if (!Objects.deepEquals(this.metadataUid, other.metadataUid)) {
				return false;
			} else if (!Objects.deepEquals(this.metadataUri, other.metadataUri)) {
				return false;
			} else if (!Objects.deepEquals(this.translationUid, other.translationUid)) {
				return false;
			} else {
				return Objects.deepEquals(this.translationUri, other.translationUri);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeBootMs);
		result = 31 * result + Objects.hashCode(this.metadataType);
		result = 31 * result + Objects.hashCode(this.metadataUid);
		result = 31 * result + Objects.hashCode(this.metadataUri);
		result = 31 * result + Objects.hashCode(this.translationUid);
		result = 31 * result + Objects.hashCode(this.translationUri);
		return result;
	}

	@Override
	public String toString() {
		return "ComponentInformation{" +
				"timeBootMs=" + timeBootMs +
				", metadataType=" + metadataType +
				", metadataUid=" + metadataUid +
				", metadataUri=" + metadataUri +
				", translationUid=" + translationUid +
				", translationUri=" + translationUri +
				'}';
	}
}