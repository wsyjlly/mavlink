package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.VideoStreamStatusFlags;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 270,
		messagePayloadLength = 19,
		description = "Information about the status of a video stream. It may be requested using MAV_CMD_REQUEST_MESSAGE."
)
public class VideoStreamStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "Video Stream ID (1 for first, 2 for second, etc.)")
	private short streamId;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 2, typeSize = 2, streamLength = 2, description = "Bitmap of stream status flags", enum0 = VideoStreamStatusFlags.class)
	private int flags;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4, description = "Frame rate", units = "Hz")
	private float framerate;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 4, typeSize = 2, streamLength = 2, description = "Horizontal resolution", units = "pix")
	private int resolutionH;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 5, typeSize = 2, streamLength = 2, description = "Vertical resolution", units = "pix")
	private int resolutionV;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 6, typeSize = 4, streamLength = 4, description = "Bit rate", units = "bits/s")
	private long bitrate;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 7, typeSize = 2, streamLength = 2, description = "Video image rotation clockwise", units = "deg")
	private int rotation;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 8, typeSize = 2, streamLength = 2, description = "Horizontal Field of view", units = "deg")
	private int hfov;

	private final int messagePayloadLength = 19;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public VideoStreamStatus(short streamId, int flags, float framerate, int resolutionH, int resolutionV, long bitrate, int rotation, int hfov) {
		this.streamId = streamId;
		this.flags = flags;
		this.framerate = framerate;
		this.resolutionH = resolutionH;
		this.resolutionV = resolutionV;
		this.bitrate = bitrate;
		this.rotation = rotation;
		this.hfov = hfov;
	}

	public VideoStreamStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 19！");
		}
		messagePayload(messagePayload);
	}

	public VideoStreamStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		streamId = byteArray.getUnsignedInt8(0);
		flags = byteArray.getUnsignedInt16(1);
		framerate = byteArray.getFloat(3);
		resolutionH = byteArray.getUnsignedInt16(7);
		resolutionV = byteArray.getUnsignedInt16(9);
		bitrate = byteArray.getUnsignedInt32(11);
		rotation = byteArray.getUnsignedInt16(15);
		hfov = byteArray.getUnsignedInt16(17);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(streamId,0);
		byteArray.putUnsignedInt16(flags,1);
		byteArray.putFloat(framerate,3);
		byteArray.putUnsignedInt16(resolutionH,7);
		byteArray.putUnsignedInt16(resolutionV,9);
		byteArray.putUnsignedInt32(bitrate,11);
		byteArray.putUnsignedInt16(rotation,15);
		byteArray.putUnsignedInt16(hfov,17);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final VideoStreamStatus setStreamId(short streamId) {
		this.streamId = streamId;
		return this;
	}

	public final short getStreamId() {
		return streamId;
	}

	public final VideoStreamStatus setFlags(int flags) {
		this.flags = flags;
		return this;
	}

	public final int getFlags() {
		return flags;
	}

	public final VideoStreamStatus setFramerate(float framerate) {
		this.framerate = framerate;
		return this;
	}

	public final float getFramerate() {
		return framerate;
	}

	public final VideoStreamStatus setResolutionH(int resolutionH) {
		this.resolutionH = resolutionH;
		return this;
	}

	public final int getResolutionH() {
		return resolutionH;
	}

	public final VideoStreamStatus setResolutionV(int resolutionV) {
		this.resolutionV = resolutionV;
		return this;
	}

	public final int getResolutionV() {
		return resolutionV;
	}

	public final VideoStreamStatus setBitrate(long bitrate) {
		this.bitrate = bitrate;
		return this;
	}

	public final long getBitrate() {
		return bitrate;
	}

	public final VideoStreamStatus setRotation(int rotation) {
		this.rotation = rotation;
		return this;
	}

	public final int getRotation() {
		return rotation;
	}

	public final VideoStreamStatus setHfov(int hfov) {
		this.hfov = hfov;
		return this;
	}

	public final int getHfov() {
		return hfov;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			VideoStreamStatus other = (VideoStreamStatus)o;
			if (!Objects.deepEquals(this.streamId, other.streamId)) {
				return false;
			} else if (!Objects.deepEquals(this.flags, other.flags)) {
				return false;
			} else if (!Objects.deepEquals(this.framerate, other.framerate)) {
				return false;
			} else if (!Objects.deepEquals(this.resolutionH, other.resolutionH)) {
				return false;
			} else if (!Objects.deepEquals(this.resolutionV, other.resolutionV)) {
				return false;
			} else if (!Objects.deepEquals(this.bitrate, other.bitrate)) {
				return false;
			} else if (!Objects.deepEquals(this.rotation, other.rotation)) {
				return false;
			} else {
				return Objects.deepEquals(this.hfov, other.hfov);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.streamId);
		result = 31 * result + Objects.hashCode(this.flags);
		result = 31 * result + Objects.hashCode(this.framerate);
		result = 31 * result + Objects.hashCode(this.resolutionH);
		result = 31 * result + Objects.hashCode(this.resolutionV);
		result = 31 * result + Objects.hashCode(this.bitrate);
		result = 31 * result + Objects.hashCode(this.rotation);
		result = 31 * result + Objects.hashCode(this.hfov);
		return result;
	}

	@Override
	public String toString() {
		return "VideoStreamStatus{" +
				"streamId=" + streamId +
				", flags=" + flags +
				", framerate=" + framerate +
				", resolutionH=" + resolutionH +
				", resolutionV=" + resolutionV +
				", bitrate=" + bitrate +
				", rotation=" + rotation +
				", hfov=" + hfov +
				'}';
	}
}