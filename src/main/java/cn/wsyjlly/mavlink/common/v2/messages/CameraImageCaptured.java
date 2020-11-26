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
		id = 263,
		messagePayloadLength = 255,
		description = "Information about a captured image. This is emitted every time a message is captured. It may be re-requested using MAV_CMD_REQUEST_MESSAGE, using param2 to indicate the sequence number for the missing image."
)
public class CameraImageCaptured implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp (time since system boot).", units = "ms")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 2, typeSize = 8, streamLength = 8, description = "Timestamp (time since UNIX epoch) in UTC. 0 for unknown.", units = "us")
	private BigInteger timeUtc;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Deprecated/unused. Component IDs are used to differentiate multiple cameras.")
	private short cameraId;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 4, typeSize = 4, streamLength = 4, description = "Latitude where image was taken", units = "degE7")
	private int lat;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 5, typeSize = 4, streamLength = 4, description = "Longitude where capture was taken", units = "degE7")
	private int lon;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 6, typeSize = 4, streamLength = 4, description = "Altitude (MSL) where image was taken", units = "mm")
	private int alt;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 7, typeSize = 4, streamLength = 4, description = "Altitude above ground", units = "mm")
	private int relativeAlt;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 16, description = "Quaternion of camera orientation (w, x, y, z order, zero-rotation is 1, 0, 0, 0)")
	private float[] q = new float[4];

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 9, typeSize = 4, streamLength = 4, description = "Zero based index of this image (i.e. a new image will have index CAMERA_CAPTURE_STATUS.image count -1)")
	private int imageIndex;

	@MavlinkMessageParam(mavlinkType = "int8_t", position = 10, typeSize = 1, streamLength = 1, description = "Boolean indicating success (1) or failure (0) while capturing this image.")
	private byte captureResult;

	@MavlinkMessageParam(mavlinkType = "char", position = 11, typeSize = 1, streamLength = 205, description = "URL of image taken. Either local storage or http://foo.jpg if camera provides an HTTP interface.")
	private String fileUrl;

	private final int messagePayloadLength = 255;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public CameraImageCaptured(long timeBootMs, BigInteger timeUtc, short cameraId, int lat, int lon, int alt, int relativeAlt, float[] q, int imageIndex, byte captureResult, String fileUrl) {
		this.timeBootMs = timeBootMs;
		this.timeUtc = timeUtc;
		this.cameraId = cameraId;
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
		this.relativeAlt = relativeAlt;
		this.q = q;
		this.imageIndex = imageIndex;
		this.captureResult = captureResult;
		this.fileUrl = fileUrl;
	}

	public CameraImageCaptured(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 255！");
		}
		messagePayload(messagePayload);
	}

	public CameraImageCaptured(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeBootMs = byteArray.getUnsignedInt32(0);
		timeUtc = byteArray.getUnsignedInt64(4);
		cameraId = byteArray.getUnsignedInt8(12);
		lat = byteArray.getInt32(13);
		lon = byteArray.getInt32(17);
		alt = byteArray.getInt32(21);
		relativeAlt = byteArray.getInt32(25);
		q = byteArray.getFloatArray(29,4);
		imageIndex = byteArray.getInt32(45);
		captureResult = byteArray.getInt8(49);
		fileUrl = byteArray.getChars(50,205);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeBootMs,0);
		byteArray.putUnsignedInt64(timeUtc,4);
		byteArray.putUnsignedInt8(cameraId,12);
		byteArray.putInt32(lat,13);
		byteArray.putInt32(lon,17);
		byteArray.putInt32(alt,21);
		byteArray.putInt32(relativeAlt,25);
		byteArray.putFloatArray(q,29);
		byteArray.putInt32(imageIndex,45);
		byteArray.putInt8(captureResult,49);
		byteArray.putChars(fileUrl,50);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final CameraImageCaptured setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final CameraImageCaptured setTimeUtc(BigInteger timeUtc) {
		this.timeUtc = timeUtc;
		return this;
	}

	public final BigInteger getTimeUtc() {
		return timeUtc;
	}

	public final CameraImageCaptured setCameraId(short cameraId) {
		this.cameraId = cameraId;
		return this;
	}

	public final short getCameraId() {
		return cameraId;
	}

	public final CameraImageCaptured setLat(int lat) {
		this.lat = lat;
		return this;
	}

	public final int getLat() {
		return lat;
	}

	public final CameraImageCaptured setLon(int lon) {
		this.lon = lon;
		return this;
	}

	public final int getLon() {
		return lon;
	}

	public final CameraImageCaptured setAlt(int alt) {
		this.alt = alt;
		return this;
	}

	public final int getAlt() {
		return alt;
	}

	public final CameraImageCaptured setRelativeAlt(int relativeAlt) {
		this.relativeAlt = relativeAlt;
		return this;
	}

	public final int getRelativeAlt() {
		return relativeAlt;
	}

	public final CameraImageCaptured setQ(float[] q) {
		this.q = q;
		return this;
	}

	public final float[] getQ() {
		return q;
	}

	public final CameraImageCaptured setImageIndex(int imageIndex) {
		this.imageIndex = imageIndex;
		return this;
	}

	public final int getImageIndex() {
		return imageIndex;
	}

	public final CameraImageCaptured setCaptureResult(byte captureResult) {
		this.captureResult = captureResult;
		return this;
	}

	public final byte getCaptureResult() {
		return captureResult;
	}

	public final CameraImageCaptured setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
		return this;
	}

	public final String getFileUrl() {
		return fileUrl;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			CameraImageCaptured other = (CameraImageCaptured)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.timeUtc, other.timeUtc)) {
				return false;
			} else if (!Objects.deepEquals(this.cameraId, other.cameraId)) {
				return false;
			} else if (!Objects.deepEquals(this.lat, other.lat)) {
				return false;
			} else if (!Objects.deepEquals(this.lon, other.lon)) {
				return false;
			} else if (!Objects.deepEquals(this.alt, other.alt)) {
				return false;
			} else if (!Objects.deepEquals(this.relativeAlt, other.relativeAlt)) {
				return false;
			} else if (!Objects.deepEquals(this.q, other.q)) {
				return false;
			} else if (!Objects.deepEquals(this.imageIndex, other.imageIndex)) {
				return false;
			} else if (!Objects.deepEquals(this.captureResult, other.captureResult)) {
				return false;
			} else {
				return Objects.deepEquals(this.fileUrl, other.fileUrl);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeBootMs);
		result = 31 * result + Objects.hashCode(this.timeUtc);
		result = 31 * result + Objects.hashCode(this.cameraId);
		result = 31 * result + Objects.hashCode(this.lat);
		result = 31 * result + Objects.hashCode(this.lon);
		result = 31 * result + Objects.hashCode(this.alt);
		result = 31 * result + Objects.hashCode(this.relativeAlt);
		result = 31 * result + Objects.hashCode(this.q);
		result = 31 * result + Objects.hashCode(this.imageIndex);
		result = 31 * result + Objects.hashCode(this.captureResult);
		result = 31 * result + Objects.hashCode(this.fileUrl);
		return result;
	}

	@Override
	public String toString() {
		return "CameraImageCaptured{" +
				"timeBootMs=" + timeBootMs +
				", timeUtc=" + timeUtc +
				", cameraId=" + cameraId +
				", lat=" + lat +
				", lon=" + lon +
				", alt=" + alt +
				", relativeAlt=" + relativeAlt +
				", q=" + Arrays.toString(q) +
				", imageIndex=" + imageIndex +
				", captureResult=" + captureResult +
				", fileUrl=" + fileUrl +
				'}';
	}
}