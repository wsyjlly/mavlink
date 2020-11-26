package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.CameraCapFlags;
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
		id = 259,
		messagePayloadLength = 235,
		description = "Information about a camera. Can be requested with a MAV_CMD_REQUEST_MESSAGE command."
)
public class CameraInformation implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp (time since system boot).", units = "ms")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 32, description = "Name of the camera vendor")
	private short[] vendorName = new short[32];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 32, description = "Name of the camera model")
	private short[] modelName = new short[32];

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 4, typeSize = 4, streamLength = 4, description = "Version of the camera firmware, encoded as: (Dev & 0xff) << 24 | (Patch & 0xff) << 16 | (Minor & 0xff) << 8 | (Major & 0xff)")
	private long firmwareVersion;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Focal length", units = "mm")
	private float focalLength;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Image sensor size horizontal", units = "mm")
	private float sensorSizeH;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "Image sensor size vertical", units = "mm")
	private float sensorSizeV;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 8, typeSize = 2, streamLength = 2, description = "Horizontal image resolution", units = "pix")
	private int resolutionH;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 9, typeSize = 2, streamLength = 2, description = "Vertical image resolution", units = "pix")
	private int resolutionV;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 10, typeSize = 1, streamLength = 1, description = "Reserved for a lens ID")
	private short lensId;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 11, typeSize = 4, streamLength = 4, description = "Bitmap of camera capability flags.", enum0 = CameraCapFlags.class)
	private long flags;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 12, typeSize = 2, streamLength = 2, description = "Camera definition version (iteration)")
	private int camDefinitionVersion;

	@MavlinkMessageParam(mavlinkType = "char", position = 13, typeSize = 1, streamLength = 140, description = "Camera definition URI (if any, otherwise only basic functions will be available). HTTP- (http://) and MAVLink FTP- (mavlinkftp://) formatted URIs are allowed (and both must be supported by any GCS that implements the Camera Protocol).")
	private String camDefinitionUri;

	private final int messagePayloadLength = 235;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public CameraInformation(long timeBootMs, short[] vendorName, short[] modelName, long firmwareVersion, float focalLength, float sensorSizeH, float sensorSizeV, int resolutionH, int resolutionV, short lensId, long flags, int camDefinitionVersion, String camDefinitionUri) {
		this.timeBootMs = timeBootMs;
		this.vendorName = vendorName;
		this.modelName = modelName;
		this.firmwareVersion = firmwareVersion;
		this.focalLength = focalLength;
		this.sensorSizeH = sensorSizeH;
		this.sensorSizeV = sensorSizeV;
		this.resolutionH = resolutionH;
		this.resolutionV = resolutionV;
		this.lensId = lensId;
		this.flags = flags;
		this.camDefinitionVersion = camDefinitionVersion;
		this.camDefinitionUri = camDefinitionUri;
	}

	public CameraInformation(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 235！");
		}
		messagePayload(messagePayload);
	}

	public CameraInformation(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeBootMs = byteArray.getUnsignedInt32(0);
		vendorName = byteArray.getUnsignedInt8Array(4,32);
		modelName = byteArray.getUnsignedInt8Array(36,32);
		firmwareVersion = byteArray.getUnsignedInt32(68);
		focalLength = byteArray.getFloat(72);
		sensorSizeH = byteArray.getFloat(76);
		sensorSizeV = byteArray.getFloat(80);
		resolutionH = byteArray.getUnsignedInt16(84);
		resolutionV = byteArray.getUnsignedInt16(86);
		lensId = byteArray.getUnsignedInt8(88);
		flags = byteArray.getUnsignedInt32(89);
		camDefinitionVersion = byteArray.getUnsignedInt16(93);
		camDefinitionUri = byteArray.getChars(95,140);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeBootMs,0);
		byteArray.putUnsignedInt8Array(vendorName,4);
		byteArray.putUnsignedInt8Array(modelName,36);
		byteArray.putUnsignedInt32(firmwareVersion,68);
		byteArray.putFloat(focalLength,72);
		byteArray.putFloat(sensorSizeH,76);
		byteArray.putFloat(sensorSizeV,80);
		byteArray.putUnsignedInt16(resolutionH,84);
		byteArray.putUnsignedInt16(resolutionV,86);
		byteArray.putUnsignedInt8(lensId,88);
		byteArray.putUnsignedInt32(flags,89);
		byteArray.putUnsignedInt16(camDefinitionVersion,93);
		byteArray.putChars(camDefinitionUri,95);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final CameraInformation setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final CameraInformation setVendorName(short[] vendorName) {
		this.vendorName = vendorName;
		return this;
	}

	public final short[] getVendorName() {
		return vendorName;
	}

	public final CameraInformation setModelName(short[] modelName) {
		this.modelName = modelName;
		return this;
	}

	public final short[] getModelName() {
		return modelName;
	}

	public final CameraInformation setFirmwareVersion(long firmwareVersion) {
		this.firmwareVersion = firmwareVersion;
		return this;
	}

	public final long getFirmwareVersion() {
		return firmwareVersion;
	}

	public final CameraInformation setFocalLength(float focalLength) {
		this.focalLength = focalLength;
		return this;
	}

	public final float getFocalLength() {
		return focalLength;
	}

	public final CameraInformation setSensorSizeH(float sensorSizeH) {
		this.sensorSizeH = sensorSizeH;
		return this;
	}

	public final float getSensorSizeH() {
		return sensorSizeH;
	}

	public final CameraInformation setSensorSizeV(float sensorSizeV) {
		this.sensorSizeV = sensorSizeV;
		return this;
	}

	public final float getSensorSizeV() {
		return sensorSizeV;
	}

	public final CameraInformation setResolutionH(int resolutionH) {
		this.resolutionH = resolutionH;
		return this;
	}

	public final int getResolutionH() {
		return resolutionH;
	}

	public final CameraInformation setResolutionV(int resolutionV) {
		this.resolutionV = resolutionV;
		return this;
	}

	public final int getResolutionV() {
		return resolutionV;
	}

	public final CameraInformation setLensId(short lensId) {
		this.lensId = lensId;
		return this;
	}

	public final short getLensId() {
		return lensId;
	}

	public final CameraInformation setFlags(long flags) {
		this.flags = flags;
		return this;
	}

	public final long getFlags() {
		return flags;
	}

	public final CameraInformation setCamDefinitionVersion(int camDefinitionVersion) {
		this.camDefinitionVersion = camDefinitionVersion;
		return this;
	}

	public final int getCamDefinitionVersion() {
		return camDefinitionVersion;
	}

	public final CameraInformation setCamDefinitionUri(String camDefinitionUri) {
		this.camDefinitionUri = camDefinitionUri;
		return this;
	}

	public final String getCamDefinitionUri() {
		return camDefinitionUri;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			CameraInformation other = (CameraInformation)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.vendorName, other.vendorName)) {
				return false;
			} else if (!Objects.deepEquals(this.modelName, other.modelName)) {
				return false;
			} else if (!Objects.deepEquals(this.firmwareVersion, other.firmwareVersion)) {
				return false;
			} else if (!Objects.deepEquals(this.focalLength, other.focalLength)) {
				return false;
			} else if (!Objects.deepEquals(this.sensorSizeH, other.sensorSizeH)) {
				return false;
			} else if (!Objects.deepEquals(this.sensorSizeV, other.sensorSizeV)) {
				return false;
			} else if (!Objects.deepEquals(this.resolutionH, other.resolutionH)) {
				return false;
			} else if (!Objects.deepEquals(this.resolutionV, other.resolutionV)) {
				return false;
			} else if (!Objects.deepEquals(this.lensId, other.lensId)) {
				return false;
			} else if (!Objects.deepEquals(this.flags, other.flags)) {
				return false;
			} else if (!Objects.deepEquals(this.camDefinitionVersion, other.camDefinitionVersion)) {
				return false;
			} else {
				return Objects.deepEquals(this.camDefinitionUri, other.camDefinitionUri);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeBootMs);
		result = 31 * result + Objects.hashCode(this.vendorName);
		result = 31 * result + Objects.hashCode(this.modelName);
		result = 31 * result + Objects.hashCode(this.firmwareVersion);
		result = 31 * result + Objects.hashCode(this.focalLength);
		result = 31 * result + Objects.hashCode(this.sensorSizeH);
		result = 31 * result + Objects.hashCode(this.sensorSizeV);
		result = 31 * result + Objects.hashCode(this.resolutionH);
		result = 31 * result + Objects.hashCode(this.resolutionV);
		result = 31 * result + Objects.hashCode(this.lensId);
		result = 31 * result + Objects.hashCode(this.flags);
		result = 31 * result + Objects.hashCode(this.camDefinitionVersion);
		result = 31 * result + Objects.hashCode(this.camDefinitionUri);
		return result;
	}

	@Override
	public String toString() {
		return "CameraInformation{" +
				"timeBootMs=" + timeBootMs +
				", vendorName=" + Arrays.toString(vendorName) +
				", modelName=" + Arrays.toString(modelName) +
				", firmwareVersion=" + firmwareVersion +
				", focalLength=" + focalLength +
				", sensorSizeH=" + sensorSizeH +
				", sensorSizeV=" + sensorSizeV +
				", resolutionH=" + resolutionH +
				", resolutionV=" + resolutionV +
				", lensId=" + lensId +
				", flags=" + flags +
				", camDefinitionVersion=" + camDefinitionVersion +
				", camDefinitionUri=" + camDefinitionUri +
				'}';
	}
}