package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.CellularStatusFlag;
import cn.wsyjlly.mavlink.common.v2.enums.CellularNetworkFailedReason;
import cn.wsyjlly.mavlink.common.v2.enums.CellularNetworkRadioType;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 334,
		messagePayloadLength = 10,
		description = "Report current used cellular network status"
)
public class CellularStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "Cellular modem status", enum0 = CellularStatusFlag.class)
	private short status;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Failure reason when status in in CELLUAR_STATUS_FAILED", enum0 = CellularNetworkFailedReason.class)
	private short failureReason;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Cellular network radio type: gsm, cdma, lte...", enum0 = CellularNetworkRadioType.class)
	private short type;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "Signal quality in percent. If unknown, set to UINT8_MAX")
	private short quality;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 5, typeSize = 2, streamLength = 2, description = "Mobile country code. If unknown, set to UINT16_MAX")
	private int mcc;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 6, typeSize = 2, streamLength = 2, description = "Mobile network code. If unknown, set to UINT16_MAX")
	private int mnc;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 7, typeSize = 2, streamLength = 2, description = "Location area code. If unknown, set to 0")
	private int lac;

	private final int messagePayloadLength = 10;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public CellularStatus(short status, short failureReason, short type, short quality, int mcc, int mnc, int lac) {
		this.status = status;
		this.failureReason = failureReason;
		this.type = type;
		this.quality = quality;
		this.mcc = mcc;
		this.mnc = mnc;
		this.lac = lac;
	}

	public CellularStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 10！");
		}
		messagePayload(messagePayload);
	}

	public CellularStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		status = byteArray.getUnsignedInt8(0);
		failureReason = byteArray.getUnsignedInt8(1);
		type = byteArray.getUnsignedInt8(2);
		quality = byteArray.getUnsignedInt8(3);
		mcc = byteArray.getUnsignedInt16(4);
		mnc = byteArray.getUnsignedInt16(6);
		lac = byteArray.getUnsignedInt16(8);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(status,0);
		byteArray.putUnsignedInt8(failureReason,1);
		byteArray.putUnsignedInt8(type,2);
		byteArray.putUnsignedInt8(quality,3);
		byteArray.putUnsignedInt16(mcc,4);
		byteArray.putUnsignedInt16(mnc,6);
		byteArray.putUnsignedInt16(lac,8);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final CellularStatus setStatus(short status) {
		this.status = status;
		return this;
	}

	public final short getStatus() {
		return status;
	}

	public final CellularStatus setFailureReason(short failureReason) {
		this.failureReason = failureReason;
		return this;
	}

	public final short getFailureReason() {
		return failureReason;
	}

	public final CellularStatus setType(short type) {
		this.type = type;
		return this;
	}

	public final short getType() {
		return type;
	}

	public final CellularStatus setQuality(short quality) {
		this.quality = quality;
		return this;
	}

	public final short getQuality() {
		return quality;
	}

	public final CellularStatus setMcc(int mcc) {
		this.mcc = mcc;
		return this;
	}

	public final int getMcc() {
		return mcc;
	}

	public final CellularStatus setMnc(int mnc) {
		this.mnc = mnc;
		return this;
	}

	public final int getMnc() {
		return mnc;
	}

	public final CellularStatus setLac(int lac) {
		this.lac = lac;
		return this;
	}

	public final int getLac() {
		return lac;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			CellularStatus other = (CellularStatus)o;
			if (!Objects.deepEquals(this.status, other.status)) {
				return false;
			} else if (!Objects.deepEquals(this.failureReason, other.failureReason)) {
				return false;
			} else if (!Objects.deepEquals(this.type, other.type)) {
				return false;
			} else if (!Objects.deepEquals(this.quality, other.quality)) {
				return false;
			} else if (!Objects.deepEquals(this.mcc, other.mcc)) {
				return false;
			} else if (!Objects.deepEquals(this.mnc, other.mnc)) {
				return false;
			} else {
				return Objects.deepEquals(this.lac, other.lac);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.status);
		result = 31 * result + Objects.hashCode(this.failureReason);
		result = 31 * result + Objects.hashCode(this.type);
		result = 31 * result + Objects.hashCode(this.quality);
		result = 31 * result + Objects.hashCode(this.mcc);
		result = 31 * result + Objects.hashCode(this.mnc);
		result = 31 * result + Objects.hashCode(this.lac);
		return result;
	}

	@Override
	public String toString() {
		return "CellularStatus{" +
				"status=" + status +
				", failureReason=" + failureReason +
				", type=" + type +
				", quality=" + quality +
				", mcc=" + mcc +
				", mnc=" + mnc +
				", lac=" + lac +
				'}';
	}
}