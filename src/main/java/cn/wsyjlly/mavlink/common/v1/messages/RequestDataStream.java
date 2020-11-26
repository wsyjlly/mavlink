package cn.wsyjlly.mavlink.common.v1.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkMessage(
		id = 66,
		messagePayloadLength = 6,
		description = "The PPM values of the RC channels received. The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%. Individual receivers/transmitters might violate this specification."
)
public class RequestDataStream implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "The target requested to send the message stream.")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "The target requested to send the message stream.")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "The ID of the requested data stream")
	private short reqStreamId;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 4, typeSize = 2, streamLength = 2, description = "The requested interval between two messages of this type")
	private int reqMessageRate;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1, description = "1 to start sending, 0 to stop sending.")
	private short startStop;

	private final int messagePayloadLength = 6;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public RequestDataStream(short targetSystem, short targetComponent, short reqStreamId, int reqMessageRate, short startStop) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.reqStreamId = reqStreamId;
		this.reqMessageRate = reqMessageRate;
		this.startStop = startStop;
	}

	public RequestDataStream(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 6！");
		}
		messagePayload(messagePayload);
	}

	public RequestDataStream(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		reqStreamId = byteArray.getUnsignedInt8(2);
		reqMessageRate = byteArray.getUnsignedInt16(3);
		startStop = byteArray.getUnsignedInt8(5);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putUnsignedInt8(reqStreamId,2);
		byteArray.putUnsignedInt16(reqMessageRate,3);
		byteArray.putUnsignedInt8(startStop,5);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final RequestDataStream setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final RequestDataStream setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final RequestDataStream setReqStreamId(short reqStreamId) {
		this.reqStreamId = reqStreamId;
		return this;
	}

	public final short getReqStreamId() {
		return reqStreamId;
	}

	public final RequestDataStream setReqMessageRate(int reqMessageRate) {
		this.reqMessageRate = reqMessageRate;
		return this;
	}

	public final int getReqMessageRate() {
		return reqMessageRate;
	}

	public final RequestDataStream setStartStop(short startStop) {
		this.startStop = startStop;
		return this;
	}

	public final short getStartStop() {
		return startStop;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			RequestDataStream other = (RequestDataStream)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.reqStreamId, other.reqStreamId)) {
				return false;
			} else if (!Objects.deepEquals(this.reqMessageRate, other.reqMessageRate)) {
				return false;
			} else {
				return Objects.deepEquals(this.startStop, other.startStop);
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
		result = 31 * result + Objects.hashCode(this.reqStreamId);
		result = 31 * result + Objects.hashCode(this.reqMessageRate);
		result = 31 * result + Objects.hashCode(this.startStop);
		return result;
	}

	@Override
	public String toString() {
		return "RequestDataStream{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", reqStreamId=" + reqStreamId +
				", reqMessageRate=" + reqMessageRate +
				", startStop=" + startStop +
				'}';
	}
}