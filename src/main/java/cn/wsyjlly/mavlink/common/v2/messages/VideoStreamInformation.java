package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.VideoStreamStatusFlags;
import cn.wsyjlly.mavlink.common.v2.enums.VideoStreamType;
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
		id = 269,
		messagePayloadLength = 213,
		description = "Information about video stream. It may be requested using MAV_CMD_REQUEST_MESSAGE, where param2 indicates the video stream id: 0 for all streams, 1 for first, 2 for second, etc."
)
public class VideoStreamInformation implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "Video Stream ID (1 for first, 2 for second, etc.)")
	private short streamId;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Number of streams available.")
	private short count;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Type of stream.", enum0 = VideoStreamType.class)
	private short type;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 4, typeSize = 2, streamLength = 2, description = "Bitmap of stream status flags.", enum0 = VideoStreamStatusFlags.class)
	private int flags;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Frame rate.", units = "Hz")
	private float framerate;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 6, typeSize = 2, streamLength = 2, description = "Horizontal resolution.", units = "pix")
	private int resolutionH;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 7, typeSize = 2, streamLength = 2, description = "Vertical resolution.", units = "pix")
	private int resolutionV;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 8, typeSize = 4, streamLength = 4, description = "Bit rate.", units = "bits/s")
	private long bitrate;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 9, typeSize = 2, streamLength = 2, description = "Video image rotation clockwise.", units = "deg")
	private int rotation;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 10, typeSize = 2, streamLength = 2, description = "Horizontal Field of view.", units = "deg")
	private int hfov;

	@MavlinkMessageParam(mavlinkType = "char", position = 11, typeSize = 1, streamLength = 32, description = "Stream name.")
	private String name;

	@MavlinkMessageParam(mavlinkType = "char", position = 12, typeSize = 1, streamLength = 160, description = "Video stream URI (TCP or RTSP URI ground station should connect to) or port number (UDP port ground station should listen to).")
	private String uri;

	private final int messagePayloadLength = 213;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public VideoStreamInformation(short streamId, short count, short type, int flags, float framerate, int resolutionH, int resolutionV, long bitrate, int rotation, int hfov, String name, String uri) {
		this.streamId = streamId;
		this.count = count;
		this.type = type;
		this.flags = flags;
		this.framerate = framerate;
		this.resolutionH = resolutionH;
		this.resolutionV = resolutionV;
		this.bitrate = bitrate;
		this.rotation = rotation;
		this.hfov = hfov;
		this.name = name;
		this.uri = uri;
	}

	public VideoStreamInformation(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 213！");
		}
		messagePayload(messagePayload);
	}

	public VideoStreamInformation(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		streamId = byteArray.getUnsignedInt8(0);
		count = byteArray.getUnsignedInt8(1);
		type = byteArray.getUnsignedInt8(2);
		flags = byteArray.getUnsignedInt16(3);
		framerate = byteArray.getFloat(5);
		resolutionH = byteArray.getUnsignedInt16(9);
		resolutionV = byteArray.getUnsignedInt16(11);
		bitrate = byteArray.getUnsignedInt32(13);
		rotation = byteArray.getUnsignedInt16(17);
		hfov = byteArray.getUnsignedInt16(19);
		name = byteArray.getChars(21,32);
		uri = byteArray.getChars(53,160);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(streamId,0);
		byteArray.putUnsignedInt8(count,1);
		byteArray.putUnsignedInt8(type,2);
		byteArray.putUnsignedInt16(flags,3);
		byteArray.putFloat(framerate,5);
		byteArray.putUnsignedInt16(resolutionH,9);
		byteArray.putUnsignedInt16(resolutionV,11);
		byteArray.putUnsignedInt32(bitrate,13);
		byteArray.putUnsignedInt16(rotation,17);
		byteArray.putUnsignedInt16(hfov,19);
		byteArray.putChars(name,21);
		byteArray.putChars(uri,53);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final VideoStreamInformation setStreamId(short streamId) {
		this.streamId = streamId;
		return this;
	}

	public final short getStreamId() {
		return streamId;
	}

	public final VideoStreamInformation setCount(short count) {
		this.count = count;
		return this;
	}

	public final short getCount() {
		return count;
	}

	public final VideoStreamInformation setType(short type) {
		this.type = type;
		return this;
	}

	public final short getType() {
		return type;
	}

	public final VideoStreamInformation setFlags(int flags) {
		this.flags = flags;
		return this;
	}

	public final int getFlags() {
		return flags;
	}

	public final VideoStreamInformation setFramerate(float framerate) {
		this.framerate = framerate;
		return this;
	}

	public final float getFramerate() {
		return framerate;
	}

	public final VideoStreamInformation setResolutionH(int resolutionH) {
		this.resolutionH = resolutionH;
		return this;
	}

	public final int getResolutionH() {
		return resolutionH;
	}

	public final VideoStreamInformation setResolutionV(int resolutionV) {
		this.resolutionV = resolutionV;
		return this;
	}

	public final int getResolutionV() {
		return resolutionV;
	}

	public final VideoStreamInformation setBitrate(long bitrate) {
		this.bitrate = bitrate;
		return this;
	}

	public final long getBitrate() {
		return bitrate;
	}

	public final VideoStreamInformation setRotation(int rotation) {
		this.rotation = rotation;
		return this;
	}

	public final int getRotation() {
		return rotation;
	}

	public final VideoStreamInformation setHfov(int hfov) {
		this.hfov = hfov;
		return this;
	}

	public final int getHfov() {
		return hfov;
	}

	public final VideoStreamInformation setName(String name) {
		this.name = name;
		return this;
	}

	public final String getName() {
		return name;
	}

	public final VideoStreamInformation setUri(String uri) {
		this.uri = uri;
		return this;
	}

	public final String getUri() {
		return uri;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			VideoStreamInformation other = (VideoStreamInformation)o;
			if (!Objects.deepEquals(this.streamId, other.streamId)) {
				return false;
			} else if (!Objects.deepEquals(this.count, other.count)) {
				return false;
			} else if (!Objects.deepEquals(this.type, other.type)) {
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
			} else if (!Objects.deepEquals(this.hfov, other.hfov)) {
				return false;
			} else if (!Objects.deepEquals(this.name, other.name)) {
				return false;
			} else {
				return Objects.deepEquals(this.uri, other.uri);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.streamId);
		result = 31 * result + Objects.hashCode(this.count);
		result = 31 * result + Objects.hashCode(this.type);
		result = 31 * result + Objects.hashCode(this.flags);
		result = 31 * result + Objects.hashCode(this.framerate);
		result = 31 * result + Objects.hashCode(this.resolutionH);
		result = 31 * result + Objects.hashCode(this.resolutionV);
		result = 31 * result + Objects.hashCode(this.bitrate);
		result = 31 * result + Objects.hashCode(this.rotation);
		result = 31 * result + Objects.hashCode(this.hfov);
		result = 31 * result + Objects.hashCode(this.name);
		result = 31 * result + Objects.hashCode(this.uri);
		return result;
	}

	@Override
	public String toString() {
		return "VideoStreamInformation{" +
				"streamId=" + streamId +
				", count=" + count +
				", type=" + type +
				", flags=" + flags +
				", framerate=" + framerate +
				", resolutionH=" + resolutionH +
				", resolutionV=" + resolutionV +
				", bitrate=" + bitrate +
				", rotation=" + rotation +
				", hfov=" + hfov +
				", name=" + name +
				", uri=" + uri +
				'}';
	}
}