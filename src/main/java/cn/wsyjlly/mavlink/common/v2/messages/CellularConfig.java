package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.CellularConfigResponse;
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
		id = 336,
		messagePayloadLength = 84,
		description = "Configure cellular modems. This message is re-emitted as an acknowledgement by the modem. The message may also be explicitly requested using MAV_CMD_REQUEST_MESSAGE."
)
public class CellularConfig implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "Enable/disable LTE. 0: setting unchanged, 1: disabled, 2: enabled. Current setting when sent back as a response.")
	private short enableLte;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Enable/disable PIN on the SIM card. 0: setting unchanged, 1: disabled, 2: enabled. Current setting when sent back as a response.")
	private short enablePin;

	@MavlinkMessageParam(mavlinkType = "char", position = 3, typeSize = 1, streamLength = 16, description = "PIN sent to the SIM card. Blank when PIN is disabled. Empty when message is sent back as a response.")
	private String pin;

	@MavlinkMessageParam(mavlinkType = "char", position = 4, typeSize = 1, streamLength = 16, description = "New PIN when changing the PIN. Blank to leave it unchanged. Empty when message is sent back as a response.")
	private String newPin;

	@MavlinkMessageParam(mavlinkType = "char", position = 5, typeSize = 1, streamLength = 32, description = "Name of the cellular APN. Blank to leave it unchanged. Current APN when sent back as a response.")
	private String apn;

	@MavlinkMessageParam(mavlinkType = "char", position = 6, typeSize = 1, streamLength = 16, description = "Required PUK code in case the user failed to authenticate 3 times with the PIN. Empty when message is sent back as a response.")
	private String puk;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 7, typeSize = 1, streamLength = 1, description = "Enable/disable roaming. 0: setting unchanged, 1: disabled, 2: enabled. Current setting when sent back as a response.")
	private short roaming;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 8, typeSize = 1, streamLength = 1, description = "Message acceptance response (sent back to GS).", enum0 = CellularConfigResponse.class)
	private short response;

	private final int messagePayloadLength = 84;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public CellularConfig(short enableLte, short enablePin, String pin, String newPin, String apn, String puk, short roaming, short response) {
		this.enableLte = enableLte;
		this.enablePin = enablePin;
		this.pin = pin;
		this.newPin = newPin;
		this.apn = apn;
		this.puk = puk;
		this.roaming = roaming;
		this.response = response;
	}

	public CellularConfig(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 84！");
		}
		messagePayload(messagePayload);
	}

	public CellularConfig(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		enableLte = byteArray.getUnsignedInt8(0);
		enablePin = byteArray.getUnsignedInt8(1);
		pin = byteArray.getChars(2,16);
		newPin = byteArray.getChars(18,16);
		apn = byteArray.getChars(34,32);
		puk = byteArray.getChars(66,16);
		roaming = byteArray.getUnsignedInt8(82);
		response = byteArray.getUnsignedInt8(83);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(enableLte,0);
		byteArray.putUnsignedInt8(enablePin,1);
		byteArray.putChars(pin,2);
		byteArray.putChars(newPin,18);
		byteArray.putChars(apn,34);
		byteArray.putChars(puk,66);
		byteArray.putUnsignedInt8(roaming,82);
		byteArray.putUnsignedInt8(response,83);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final CellularConfig setEnableLte(short enableLte) {
		this.enableLte = enableLte;
		return this;
	}

	public final short getEnableLte() {
		return enableLte;
	}

	public final CellularConfig setEnablePin(short enablePin) {
		this.enablePin = enablePin;
		return this;
	}

	public final short getEnablePin() {
		return enablePin;
	}

	public final CellularConfig setPin(String pin) {
		this.pin = pin;
		return this;
	}

	public final String getPin() {
		return pin;
	}

	public final CellularConfig setNewPin(String newPin) {
		this.newPin = newPin;
		return this;
	}

	public final String getNewPin() {
		return newPin;
	}

	public final CellularConfig setApn(String apn) {
		this.apn = apn;
		return this;
	}

	public final String getApn() {
		return apn;
	}

	public final CellularConfig setPuk(String puk) {
		this.puk = puk;
		return this;
	}

	public final String getPuk() {
		return puk;
	}

	public final CellularConfig setRoaming(short roaming) {
		this.roaming = roaming;
		return this;
	}

	public final short getRoaming() {
		return roaming;
	}

	public final CellularConfig setResponse(short response) {
		this.response = response;
		return this;
	}

	public final short getResponse() {
		return response;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			CellularConfig other = (CellularConfig)o;
			if (!Objects.deepEquals(this.enableLte, other.enableLte)) {
				return false;
			} else if (!Objects.deepEquals(this.enablePin, other.enablePin)) {
				return false;
			} else if (!Objects.deepEquals(this.pin, other.pin)) {
				return false;
			} else if (!Objects.deepEquals(this.newPin, other.newPin)) {
				return false;
			} else if (!Objects.deepEquals(this.apn, other.apn)) {
				return false;
			} else if (!Objects.deepEquals(this.puk, other.puk)) {
				return false;
			} else if (!Objects.deepEquals(this.roaming, other.roaming)) {
				return false;
			} else {
				return Objects.deepEquals(this.response, other.response);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.enableLte);
		result = 31 * result + Objects.hashCode(this.enablePin);
		result = 31 * result + Objects.hashCode(this.pin);
		result = 31 * result + Objects.hashCode(this.newPin);
		result = 31 * result + Objects.hashCode(this.apn);
		result = 31 * result + Objects.hashCode(this.puk);
		result = 31 * result + Objects.hashCode(this.roaming);
		result = 31 * result + Objects.hashCode(this.response);
		return result;
	}

	@Override
	public String toString() {
		return "CellularConfig{" +
				"enableLte=" + enableLte +
				", enablePin=" + enablePin +
				", pin=" + pin +
				", newPin=" + newPin +
				", apn=" + apn +
				", puk=" + puk +
				", roaming=" + roaming +
				", response=" + response +
				'}';
	}
}