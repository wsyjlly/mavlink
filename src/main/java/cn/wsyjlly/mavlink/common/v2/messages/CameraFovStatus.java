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
		id = 271,
		messagePayloadLength = 52,
		description = "Information about the field of view of a camera. Can be requested with a MAV_CMD_REQUEST_MESSAGE command."
)
public class CameraFovStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp (time since system boot).", units = "ms")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 2, typeSize = 4, streamLength = 4, description = "Latitude of camera (INT32_MAX if unknown).", units = "degE7")
	private int latCamera;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 3, typeSize = 4, streamLength = 4, description = "Longitude of camera (INT32_MAX if unknown).", units = "degE7")
	private int lonCamera;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 4, typeSize = 4, streamLength = 4, description = "Altitude (MSL) of camera (INT32_MAX if unknown).", units = "mm")
	private int altCamera;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 5, typeSize = 4, streamLength = 4, description = "Latitude of center of image (INT32_MAX if unknown, INT32_MIN if at infinity, not intersecting with horizon).", units = "degE7")
	private int latImage;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 6, typeSize = 4, streamLength = 4, description = "Longitude of center of image (INT32_MAX if unknown, INT32_MIN if at infinity, not intersecting with horizon).", units = "degE7")
	private int lonImage;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 7, typeSize = 4, streamLength = 4, description = "Altitude (MSL) of center of image (INT32_MAX if unknown, INT32_MIN if at infinity, not intersecting with horizon).", units = "mm")
	private int altImage;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 16, description = "Quaternion of camera orientation (w, x, y, z order, zero-rotation is 1, 0, 0, 0)")
	private float[] q = new float[4];

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4, description = "Horizontal field of view (NaN if unknown).", units = "deg")
	private float hfov;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4, description = "Vertical field of view (NaN if unknown).", units = "deg")
	private float vfov;

	private final int messagePayloadLength = 52;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public CameraFovStatus(long timeBootMs, int latCamera, int lonCamera, int altCamera, int latImage, int lonImage, int altImage, float[] q, float hfov, float vfov) {
		this.timeBootMs = timeBootMs;
		this.latCamera = latCamera;
		this.lonCamera = lonCamera;
		this.altCamera = altCamera;
		this.latImage = latImage;
		this.lonImage = lonImage;
		this.altImage = altImage;
		this.q = q;
		this.hfov = hfov;
		this.vfov = vfov;
	}

	public CameraFovStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 52！");
		}
		messagePayload(messagePayload);
	}

	public CameraFovStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeBootMs = byteArray.getUnsignedInt32(0);
		latCamera = byteArray.getInt32(4);
		lonCamera = byteArray.getInt32(8);
		altCamera = byteArray.getInt32(12);
		latImage = byteArray.getInt32(16);
		lonImage = byteArray.getInt32(20);
		altImage = byteArray.getInt32(24);
		q = byteArray.getFloatArray(28,4);
		hfov = byteArray.getFloat(44);
		vfov = byteArray.getFloat(48);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeBootMs,0);
		byteArray.putInt32(latCamera,4);
		byteArray.putInt32(lonCamera,8);
		byteArray.putInt32(altCamera,12);
		byteArray.putInt32(latImage,16);
		byteArray.putInt32(lonImage,20);
		byteArray.putInt32(altImage,24);
		byteArray.putFloatArray(q,28);
		byteArray.putFloat(hfov,44);
		byteArray.putFloat(vfov,48);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final CameraFovStatus setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final CameraFovStatus setLatCamera(int latCamera) {
		this.latCamera = latCamera;
		return this;
	}

	public final int getLatCamera() {
		return latCamera;
	}

	public final CameraFovStatus setLonCamera(int lonCamera) {
		this.lonCamera = lonCamera;
		return this;
	}

	public final int getLonCamera() {
		return lonCamera;
	}

	public final CameraFovStatus setAltCamera(int altCamera) {
		this.altCamera = altCamera;
		return this;
	}

	public final int getAltCamera() {
		return altCamera;
	}

	public final CameraFovStatus setLatImage(int latImage) {
		this.latImage = latImage;
		return this;
	}

	public final int getLatImage() {
		return latImage;
	}

	public final CameraFovStatus setLonImage(int lonImage) {
		this.lonImage = lonImage;
		return this;
	}

	public final int getLonImage() {
		return lonImage;
	}

	public final CameraFovStatus setAltImage(int altImage) {
		this.altImage = altImage;
		return this;
	}

	public final int getAltImage() {
		return altImage;
	}

	public final CameraFovStatus setQ(float[] q) {
		this.q = q;
		return this;
	}

	public final float[] getQ() {
		return q;
	}

	public final CameraFovStatus setHfov(float hfov) {
		this.hfov = hfov;
		return this;
	}

	public final float getHfov() {
		return hfov;
	}

	public final CameraFovStatus setVfov(float vfov) {
		this.vfov = vfov;
		return this;
	}

	public final float getVfov() {
		return vfov;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			CameraFovStatus other = (CameraFovStatus)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.latCamera, other.latCamera)) {
				return false;
			} else if (!Objects.deepEquals(this.lonCamera, other.lonCamera)) {
				return false;
			} else if (!Objects.deepEquals(this.altCamera, other.altCamera)) {
				return false;
			} else if (!Objects.deepEquals(this.latImage, other.latImage)) {
				return false;
			} else if (!Objects.deepEquals(this.lonImage, other.lonImage)) {
				return false;
			} else if (!Objects.deepEquals(this.altImage, other.altImage)) {
				return false;
			} else if (!Objects.deepEquals(this.q, other.q)) {
				return false;
			} else if (!Objects.deepEquals(this.hfov, other.hfov)) {
				return false;
			} else {
				return Objects.deepEquals(this.vfov, other.vfov);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeBootMs);
		result = 31 * result + Objects.hashCode(this.latCamera);
		result = 31 * result + Objects.hashCode(this.lonCamera);
		result = 31 * result + Objects.hashCode(this.altCamera);
		result = 31 * result + Objects.hashCode(this.latImage);
		result = 31 * result + Objects.hashCode(this.lonImage);
		result = 31 * result + Objects.hashCode(this.altImage);
		result = 31 * result + Objects.hashCode(this.q);
		result = 31 * result + Objects.hashCode(this.hfov);
		result = 31 * result + Objects.hashCode(this.vfov);
		return result;
	}

	@Override
	public String toString() {
		return "CameraFovStatus{" +
				"timeBootMs=" + timeBootMs +
				", latCamera=" + latCamera +
				", lonCamera=" + lonCamera +
				", altCamera=" + altCamera +
				", latImage=" + latImage +
				", lonImage=" + lonImage +
				", altImage=" + altImage +
				", q=" + Arrays.toString(q) +
				", hfov=" + hfov +
				", vfov=" + vfov +
				'}';
	}
}