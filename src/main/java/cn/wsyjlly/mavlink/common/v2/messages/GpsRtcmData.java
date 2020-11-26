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
		id = 233,
		messagePayloadLength = 182,
		description = "RTCM message for injecting into the onboard GPS (used for DGPS)"
)
public class GpsRtcmData implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "LSB: 1 means message is fragmented, next 2 bits are the fragment ID, the remaining 5 bits are used for the sequence ID. Messages are only to be flushed to the GPS when the entire message has been reconstructed on the autopilot. The fragment ID specifies which order the fragments should be assembled into a buffer, while the sequence ID is used to detect a mismatch between different buffers. The buffer is considered fully reconstructed when either all 4 fragments are present, or all the fragments before the first fragment with a non full payload is received. This management is used to ensure that normal GPS operation doesn't corrupt RTCM data, and to recover from a unreliable transport delivery order.")
	private short flags;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "data length", units = "bytes")
	private short len;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 180, description = "RTCM message (may be fragmented)")
	private short[] data = new short[180];

	private final int messagePayloadLength = 182;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public GpsRtcmData(short flags, short len, short[] data) {
		this.flags = flags;
		this.len = len;
		this.data = data;
	}

	public GpsRtcmData(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 182！");
		}
		messagePayload(messagePayload);
	}

	public GpsRtcmData(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		flags = byteArray.getUnsignedInt8(0);
		len = byteArray.getUnsignedInt8(1);
		data = byteArray.getUnsignedInt8Array(2,180);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(flags,0);
		byteArray.putUnsignedInt8(len,1);
		byteArray.putUnsignedInt8Array(data,2);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final GpsRtcmData setFlags(short flags) {
		this.flags = flags;
		return this;
	}

	public final short getFlags() {
		return flags;
	}

	public final GpsRtcmData setLen(short len) {
		this.len = len;
		return this;
	}

	public final short getLen() {
		return len;
	}

	public final GpsRtcmData setData(short[] data) {
		this.data = data;
		return this;
	}

	public final short[] getData() {
		return data;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			GpsRtcmData other = (GpsRtcmData)o;
			if (!Objects.deepEquals(this.flags, other.flags)) {
				return false;
			} else if (!Objects.deepEquals(this.len, other.len)) {
				return false;
			} else {
				return Objects.deepEquals(this.data, other.data);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.flags);
		result = 31 * result + Objects.hashCode(this.len);
		result = 31 * result + Objects.hashCode(this.data);
		return result;
	}

	@Override
	public String toString() {
		return "GpsRtcmData{" +
				"flags=" + flags +
				", len=" + len +
				", data=" + Arrays.toString(data) +
				'}';
	}
}