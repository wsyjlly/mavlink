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
		id = 70,
		messagePayloadLength = 38,
		description = "The RAW values of the RC channels sent to the MAV to override info received from the RC radio. A value of UINT16_MAX means no change to that channel. A value of 0 means control of that channel should be released back to the RC radio. The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%. Individual receivers/transmitters might violate this specification."
)
public class RcChannelsOverride implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2, description = "RC channel 1 value. A value of UINT16_MAX means to ignore this field.", units = "us")
	private int chan1Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 4, typeSize = 2, streamLength = 2, description = "RC channel 2 value. A value of UINT16_MAX means to ignore this field.", units = "us")
	private int chan2Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 5, typeSize = 2, streamLength = 2, description = "RC channel 3 value. A value of UINT16_MAX means to ignore this field.", units = "us")
	private int chan3Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 6, typeSize = 2, streamLength = 2, description = "RC channel 4 value. A value of UINT16_MAX means to ignore this field.", units = "us")
	private int chan4Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 7, typeSize = 2, streamLength = 2, description = "RC channel 5 value. A value of UINT16_MAX means to ignore this field.", units = "us")
	private int chan5Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 8, typeSize = 2, streamLength = 2, description = "RC channel 6 value. A value of UINT16_MAX means to ignore this field.", units = "us")
	private int chan6Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 9, typeSize = 2, streamLength = 2, description = "RC channel 7 value. A value of UINT16_MAX means to ignore this field.", units = "us")
	private int chan7Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 10, typeSize = 2, streamLength = 2, description = "RC channel 8 value. A value of UINT16_MAX means to ignore this field.", units = "us")
	private int chan8Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 11, typeSize = 2, streamLength = 2, description = "RC channel 9 value. A value of 0 or UINT16_MAX means to ignore this field.", units = "us")
	private int chan9Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 12, typeSize = 2, streamLength = 2, description = "RC channel 10 value. A value of 0 or UINT16_MAX means to ignore this field.", units = "us")
	private int chan10Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 13, typeSize = 2, streamLength = 2, description = "RC channel 11 value. A value of 0 or UINT16_MAX means to ignore this field.", units = "us")
	private int chan11Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 14, typeSize = 2, streamLength = 2, description = "RC channel 12 value. A value of 0 or UINT16_MAX means to ignore this field.", units = "us")
	private int chan12Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 15, typeSize = 2, streamLength = 2, description = "RC channel 13 value. A value of 0 or UINT16_MAX means to ignore this field.", units = "us")
	private int chan13Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 16, typeSize = 2, streamLength = 2, description = "RC channel 14 value. A value of 0 or UINT16_MAX means to ignore this field.", units = "us")
	private int chan14Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 17, typeSize = 2, streamLength = 2, description = "RC channel 15 value. A value of 0 or UINT16_MAX means to ignore this field.", units = "us")
	private int chan15Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 18, typeSize = 2, streamLength = 2, description = "RC channel 16 value. A value of 0 or UINT16_MAX means to ignore this field.", units = "us")
	private int chan16Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 19, typeSize = 2, streamLength = 2, description = "RC channel 17 value. A value of 0 or UINT16_MAX means to ignore this field.", units = "us")
	private int chan17Raw;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 20, typeSize = 2, streamLength = 2, description = "RC channel 18 value. A value of 0 or UINT16_MAX means to ignore this field.", units = "us")
	private int chan18Raw;

	private final int messagePayloadLength = 38;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public RcChannelsOverride(short targetSystem, short targetComponent, int chan1Raw, int chan2Raw, int chan3Raw, int chan4Raw, int chan5Raw, int chan6Raw, int chan7Raw, int chan8Raw, int chan9Raw, int chan10Raw, int chan11Raw, int chan12Raw, int chan13Raw, int chan14Raw, int chan15Raw, int chan16Raw, int chan17Raw, int chan18Raw) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.chan1Raw = chan1Raw;
		this.chan2Raw = chan2Raw;
		this.chan3Raw = chan3Raw;
		this.chan4Raw = chan4Raw;
		this.chan5Raw = chan5Raw;
		this.chan6Raw = chan6Raw;
		this.chan7Raw = chan7Raw;
		this.chan8Raw = chan8Raw;
		this.chan9Raw = chan9Raw;
		this.chan10Raw = chan10Raw;
		this.chan11Raw = chan11Raw;
		this.chan12Raw = chan12Raw;
		this.chan13Raw = chan13Raw;
		this.chan14Raw = chan14Raw;
		this.chan15Raw = chan15Raw;
		this.chan16Raw = chan16Raw;
		this.chan17Raw = chan17Raw;
		this.chan18Raw = chan18Raw;
	}

	public RcChannelsOverride(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 38！");
		}
		messagePayload(messagePayload);
	}

	public RcChannelsOverride(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		chan1Raw = byteArray.getUnsignedInt16(2);
		chan2Raw = byteArray.getUnsignedInt16(4);
		chan3Raw = byteArray.getUnsignedInt16(6);
		chan4Raw = byteArray.getUnsignedInt16(8);
		chan5Raw = byteArray.getUnsignedInt16(10);
		chan6Raw = byteArray.getUnsignedInt16(12);
		chan7Raw = byteArray.getUnsignedInt16(14);
		chan8Raw = byteArray.getUnsignedInt16(16);
		chan9Raw = byteArray.getUnsignedInt16(18);
		chan10Raw = byteArray.getUnsignedInt16(20);
		chan11Raw = byteArray.getUnsignedInt16(22);
		chan12Raw = byteArray.getUnsignedInt16(24);
		chan13Raw = byteArray.getUnsignedInt16(26);
		chan14Raw = byteArray.getUnsignedInt16(28);
		chan15Raw = byteArray.getUnsignedInt16(30);
		chan16Raw = byteArray.getUnsignedInt16(32);
		chan17Raw = byteArray.getUnsignedInt16(34);
		chan18Raw = byteArray.getUnsignedInt16(36);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putUnsignedInt16(chan1Raw,2);
		byteArray.putUnsignedInt16(chan2Raw,4);
		byteArray.putUnsignedInt16(chan3Raw,6);
		byteArray.putUnsignedInt16(chan4Raw,8);
		byteArray.putUnsignedInt16(chan5Raw,10);
		byteArray.putUnsignedInt16(chan6Raw,12);
		byteArray.putUnsignedInt16(chan7Raw,14);
		byteArray.putUnsignedInt16(chan8Raw,16);
		byteArray.putUnsignedInt16(chan9Raw,18);
		byteArray.putUnsignedInt16(chan10Raw,20);
		byteArray.putUnsignedInt16(chan11Raw,22);
		byteArray.putUnsignedInt16(chan12Raw,24);
		byteArray.putUnsignedInt16(chan13Raw,26);
		byteArray.putUnsignedInt16(chan14Raw,28);
		byteArray.putUnsignedInt16(chan15Raw,30);
		byteArray.putUnsignedInt16(chan16Raw,32);
		byteArray.putUnsignedInt16(chan17Raw,34);
		byteArray.putUnsignedInt16(chan18Raw,36);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final RcChannelsOverride setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final RcChannelsOverride setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final RcChannelsOverride setChan1Raw(int chan1Raw) {
		this.chan1Raw = chan1Raw;
		return this;
	}

	public final int getChan1Raw() {
		return chan1Raw;
	}

	public final RcChannelsOverride setChan2Raw(int chan2Raw) {
		this.chan2Raw = chan2Raw;
		return this;
	}

	public final int getChan2Raw() {
		return chan2Raw;
	}

	public final RcChannelsOverride setChan3Raw(int chan3Raw) {
		this.chan3Raw = chan3Raw;
		return this;
	}

	public final int getChan3Raw() {
		return chan3Raw;
	}

	public final RcChannelsOverride setChan4Raw(int chan4Raw) {
		this.chan4Raw = chan4Raw;
		return this;
	}

	public final int getChan4Raw() {
		return chan4Raw;
	}

	public final RcChannelsOverride setChan5Raw(int chan5Raw) {
		this.chan5Raw = chan5Raw;
		return this;
	}

	public final int getChan5Raw() {
		return chan5Raw;
	}

	public final RcChannelsOverride setChan6Raw(int chan6Raw) {
		this.chan6Raw = chan6Raw;
		return this;
	}

	public final int getChan6Raw() {
		return chan6Raw;
	}

	public final RcChannelsOverride setChan7Raw(int chan7Raw) {
		this.chan7Raw = chan7Raw;
		return this;
	}

	public final int getChan7Raw() {
		return chan7Raw;
	}

	public final RcChannelsOverride setChan8Raw(int chan8Raw) {
		this.chan8Raw = chan8Raw;
		return this;
	}

	public final int getChan8Raw() {
		return chan8Raw;
	}

	public final RcChannelsOverride setChan9Raw(int chan9Raw) {
		this.chan9Raw = chan9Raw;
		return this;
	}

	public final int getChan9Raw() {
		return chan9Raw;
	}

	public final RcChannelsOverride setChan10Raw(int chan10Raw) {
		this.chan10Raw = chan10Raw;
		return this;
	}

	public final int getChan10Raw() {
		return chan10Raw;
	}

	public final RcChannelsOverride setChan11Raw(int chan11Raw) {
		this.chan11Raw = chan11Raw;
		return this;
	}

	public final int getChan11Raw() {
		return chan11Raw;
	}

	public final RcChannelsOverride setChan12Raw(int chan12Raw) {
		this.chan12Raw = chan12Raw;
		return this;
	}

	public final int getChan12Raw() {
		return chan12Raw;
	}

	public final RcChannelsOverride setChan13Raw(int chan13Raw) {
		this.chan13Raw = chan13Raw;
		return this;
	}

	public final int getChan13Raw() {
		return chan13Raw;
	}

	public final RcChannelsOverride setChan14Raw(int chan14Raw) {
		this.chan14Raw = chan14Raw;
		return this;
	}

	public final int getChan14Raw() {
		return chan14Raw;
	}

	public final RcChannelsOverride setChan15Raw(int chan15Raw) {
		this.chan15Raw = chan15Raw;
		return this;
	}

	public final int getChan15Raw() {
		return chan15Raw;
	}

	public final RcChannelsOverride setChan16Raw(int chan16Raw) {
		this.chan16Raw = chan16Raw;
		return this;
	}

	public final int getChan16Raw() {
		return chan16Raw;
	}

	public final RcChannelsOverride setChan17Raw(int chan17Raw) {
		this.chan17Raw = chan17Raw;
		return this;
	}

	public final int getChan17Raw() {
		return chan17Raw;
	}

	public final RcChannelsOverride setChan18Raw(int chan18Raw) {
		this.chan18Raw = chan18Raw;
		return this;
	}

	public final int getChan18Raw() {
		return chan18Raw;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			RcChannelsOverride other = (RcChannelsOverride)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.chan1Raw, other.chan1Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan2Raw, other.chan2Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan3Raw, other.chan3Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan4Raw, other.chan4Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan5Raw, other.chan5Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan6Raw, other.chan6Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan7Raw, other.chan7Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan8Raw, other.chan8Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan9Raw, other.chan9Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan10Raw, other.chan10Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan11Raw, other.chan11Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan12Raw, other.chan12Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan13Raw, other.chan13Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan14Raw, other.chan14Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan15Raw, other.chan15Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan16Raw, other.chan16Raw)) {
				return false;
			} else if (!Objects.deepEquals(this.chan17Raw, other.chan17Raw)) {
				return false;
			} else {
				return Objects.deepEquals(this.chan18Raw, other.chan18Raw);
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
		result = 31 * result + Objects.hashCode(this.chan1Raw);
		result = 31 * result + Objects.hashCode(this.chan2Raw);
		result = 31 * result + Objects.hashCode(this.chan3Raw);
		result = 31 * result + Objects.hashCode(this.chan4Raw);
		result = 31 * result + Objects.hashCode(this.chan5Raw);
		result = 31 * result + Objects.hashCode(this.chan6Raw);
		result = 31 * result + Objects.hashCode(this.chan7Raw);
		result = 31 * result + Objects.hashCode(this.chan8Raw);
		result = 31 * result + Objects.hashCode(this.chan9Raw);
		result = 31 * result + Objects.hashCode(this.chan10Raw);
		result = 31 * result + Objects.hashCode(this.chan11Raw);
		result = 31 * result + Objects.hashCode(this.chan12Raw);
		result = 31 * result + Objects.hashCode(this.chan13Raw);
		result = 31 * result + Objects.hashCode(this.chan14Raw);
		result = 31 * result + Objects.hashCode(this.chan15Raw);
		result = 31 * result + Objects.hashCode(this.chan16Raw);
		result = 31 * result + Objects.hashCode(this.chan17Raw);
		result = 31 * result + Objects.hashCode(this.chan18Raw);
		return result;
	}

	@Override
	public String toString() {
		return "RcChannelsOverride{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", chan1Raw=" + chan1Raw +
				", chan2Raw=" + chan2Raw +
				", chan3Raw=" + chan3Raw +
				", chan4Raw=" + chan4Raw +
				", chan5Raw=" + chan5Raw +
				", chan6Raw=" + chan6Raw +
				", chan7Raw=" + chan7Raw +
				", chan8Raw=" + chan8Raw +
				", chan9Raw=" + chan9Raw +
				", chan10Raw=" + chan10Raw +
				", chan11Raw=" + chan11Raw +
				", chan12Raw=" + chan12Raw +
				", chan13Raw=" + chan13Raw +
				", chan14Raw=" + chan14Raw +
				", chan15Raw=" + chan15Raw +
				", chan16Raw=" + chan16Raw +
				", chan17Raw=" + chan17Raw +
				", chan18Raw=" + chan18Raw +
				'}';
	}
}