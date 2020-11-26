package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavLandedState;
import cn.wsyjlly.mavlink.common.v2.enums.MavVtolState;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 245,
		messagePayloadLength = 2,
		description = "Provides state for additional features"
)
public class ExtendedSysState implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "The VTOL state if applicable. Is set to MAV_VTOL_STATE_UNDEFINED if UAV is not in VTOL configuration.", enum0 = MavVtolState.class)
	private short vtolState;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown.", enum0 = MavLandedState.class)
	private short landedState;

	private final int messagePayloadLength = 2;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ExtendedSysState(short vtolState, short landedState) {
		this.vtolState = vtolState;
		this.landedState = landedState;
	}

	public ExtendedSysState(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 2！");
		}
		messagePayload(messagePayload);
	}

	public ExtendedSysState(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		vtolState = byteArray.getUnsignedInt8(0);
		landedState = byteArray.getUnsignedInt8(1);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(vtolState,0);
		byteArray.putUnsignedInt8(landedState,1);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ExtendedSysState setVtolState(short vtolState) {
		this.vtolState = vtolState;
		return this;
	}

	public final short getVtolState() {
		return vtolState;
	}

	public final ExtendedSysState setLandedState(short landedState) {
		this.landedState = landedState;
		return this;
	}

	public final short getLandedState() {
		return landedState;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ExtendedSysState other = (ExtendedSysState)o;
			if (!Objects.deepEquals(this.vtolState, other.vtolState)) {
				return false;
			} else {
				return Objects.deepEquals(this.landedState, other.landedState);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.vtolState);
		result = 31 * result + Objects.hashCode(this.landedState);
		return result;
	}

	@Override
	public String toString() {
		return "ExtendedSysState{" +
				"vtolState=" + vtolState +
				", landedState=" + landedState +
				'}';
	}
}