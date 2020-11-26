package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 262,
		messagePayloadLength = 22,
		description = "Information about the status of a capture. Can be requested with a MAV_CMD_REQUEST_MESSAGE command."
)
public class CameraCaptureStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp (time since system boot).", units = "ms")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Current status of image capturing (0: idle, 1: capture in progress, 2: interval set but idle, 3: interval set and capture in progress)")
	private short imageStatus;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Current status of video capturing (0: idle, 1: capture in progress)")
	private short videoStatus;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "Image capture interval", units = "s")
	private float imageInterval;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 5, typeSize = 4, streamLength = 4, description = "Time since recording started", units = "ms")
	private long recordingTimeMs;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Available storage capacity.", units = "MiB")
	private float availableCapacity;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 7, typeSize = 4, streamLength = 4, description = "Total number of images captured ('forever', or until reset using MAV_CMD_STORAGE_FORMAT).")
	private int imageCount;

	private final int messagePayloadLength = 22;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public CameraCaptureStatus(long timeBootMs, short imageStatus, short videoStatus, float imageInterval, long recordingTimeMs, float availableCapacity, int imageCount) {
		this.timeBootMs = timeBootMs;
		this.imageStatus = imageStatus;
		this.videoStatus = videoStatus;
		this.imageInterval = imageInterval;
		this.recordingTimeMs = recordingTimeMs;
		this.availableCapacity = availableCapacity;
		this.imageCount = imageCount;
	}

	public CameraCaptureStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 22！");
		}
		messagePayload(messagePayload);
	}

	public CameraCaptureStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeBootMs = byteArray.getUnsignedInt32(0);
		imageStatus = byteArray.getUnsignedInt8(4);
		videoStatus = byteArray.getUnsignedInt8(5);
		imageInterval = byteArray.getFloat(6);
		recordingTimeMs = byteArray.getUnsignedInt32(10);
		availableCapacity = byteArray.getFloat(14);
		imageCount = byteArray.getInt32(18);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeBootMs,0);
		byteArray.putUnsignedInt8(imageStatus,4);
		byteArray.putUnsignedInt8(videoStatus,5);
		byteArray.putFloat(imageInterval,6);
		byteArray.putUnsignedInt32(recordingTimeMs,10);
		byteArray.putFloat(availableCapacity,14);
		byteArray.putInt32(imageCount,18);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final CameraCaptureStatus setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final CameraCaptureStatus setImageStatus(short imageStatus) {
		this.imageStatus = imageStatus;
		return this;
	}

	public final short getImageStatus() {
		return imageStatus;
	}

	public final CameraCaptureStatus setVideoStatus(short videoStatus) {
		this.videoStatus = videoStatus;
		return this;
	}

	public final short getVideoStatus() {
		return videoStatus;
	}

	public final CameraCaptureStatus setImageInterval(float imageInterval) {
		this.imageInterval = imageInterval;
		return this;
	}

	public final float getImageInterval() {
		return imageInterval;
	}

	public final CameraCaptureStatus setRecordingTimeMs(long recordingTimeMs) {
		this.recordingTimeMs = recordingTimeMs;
		return this;
	}

	public final long getRecordingTimeMs() {
		return recordingTimeMs;
	}

	public final CameraCaptureStatus setAvailableCapacity(float availableCapacity) {
		this.availableCapacity = availableCapacity;
		return this;
	}

	public final float getAvailableCapacity() {
		return availableCapacity;
	}

	public final CameraCaptureStatus setImageCount(int imageCount) {
		this.imageCount = imageCount;
		return this;
	}

	public final int getImageCount() {
		return imageCount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			CameraCaptureStatus other = (CameraCaptureStatus)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.imageStatus, other.imageStatus)) {
				return false;
			} else if (!Objects.deepEquals(this.videoStatus, other.videoStatus)) {
				return false;
			} else if (!Objects.deepEquals(this.imageInterval, other.imageInterval)) {
				return false;
			} else if (!Objects.deepEquals(this.recordingTimeMs, other.recordingTimeMs)) {
				return false;
			} else if (!Objects.deepEquals(this.availableCapacity, other.availableCapacity)) {
				return false;
			} else {
				return Objects.deepEquals(this.imageCount, other.imageCount);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeBootMs);
		result = 31 * result + Objects.hashCode(this.imageStatus);
		result = 31 * result + Objects.hashCode(this.videoStatus);
		result = 31 * result + Objects.hashCode(this.imageInterval);
		result = 31 * result + Objects.hashCode(this.recordingTimeMs);
		result = 31 * result + Objects.hashCode(this.availableCapacity);
		result = 31 * result + Objects.hashCode(this.imageCount);
		return result;
	}

	@Override
	public String toString() {
		return "CameraCaptureStatus{" +
				"timeBootMs=" + timeBootMs +
				", imageStatus=" + imageStatus +
				", videoStatus=" + videoStatus +
				", imageInterval=" + imageInterval +
				", recordingTimeMs=" + recordingTimeMs +
				", availableCapacity=" + availableCapacity +
				", imageCount=" + imageCount +
				'}';
	}
}