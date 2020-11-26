package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.WifiConfigApResponse;
import cn.wsyjlly.mavlink.common.v2.enums.WifiConfigApMode;
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
		id = 299,
		messagePayloadLength = 98,
		description = "Configure WiFi AP SSID, password, and mode. This message is re-emitted as an acknowledgement by the AP. The message may also be explicitly requested using MAV_CMD_REQUEST_MESSAGE"
)
public class WifiConfigAp implements Message {
	@MavlinkMessageParam(mavlinkType = "char", position = 1, typeSize = 1, streamLength = 32, description = "Name of Wi-Fi network (SSID). Blank to leave it unchanged when setting. Current SSID when sent back as a response.")
	private String ssid;

	@MavlinkMessageParam(mavlinkType = "char", position = 2, typeSize = 1, streamLength = 64, description = "Password. Blank for an open AP. MD5 hash when message is sent back as a response.")
	private String password;

	@MavlinkMessageParam(mavlinkType = "int8_t", position = 3, typeSize = 1, streamLength = 1, description = "WiFi Mode.", enum0 = WifiConfigApMode.class)
	private byte mode;

	@MavlinkMessageParam(mavlinkType = "int8_t", position = 4, typeSize = 1, streamLength = 1, description = "Message acceptance response (sent back to GS).", enum0 = WifiConfigApResponse.class)
	private byte response;

	private final int messagePayloadLength = 98;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public WifiConfigAp(String ssid, String password, byte mode, byte response) {
		this.ssid = ssid;
		this.password = password;
		this.mode = mode;
		this.response = response;
	}

	public WifiConfigAp(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 98！");
		}
		messagePayload(messagePayload);
	}

	public WifiConfigAp(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		ssid = byteArray.getChars(0,32);
		password = byteArray.getChars(32,64);
		mode = byteArray.getInt8(96);
		response = byteArray.getInt8(97);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putChars(ssid,0);
		byteArray.putChars(password,32);
		byteArray.putInt8(mode,96);
		byteArray.putInt8(response,97);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final WifiConfigAp setSsid(String ssid) {
		this.ssid = ssid;
		return this;
	}

	public final String getSsid() {
		return ssid;
	}

	public final WifiConfigAp setPassword(String password) {
		this.password = password;
		return this;
	}

	public final String getPassword() {
		return password;
	}

	public final WifiConfigAp setMode(byte mode) {
		this.mode = mode;
		return this;
	}

	public final byte getMode() {
		return mode;
	}

	public final WifiConfigAp setResponse(byte response) {
		this.response = response;
		return this;
	}

	public final byte getResponse() {
		return response;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			WifiConfigAp other = (WifiConfigAp)o;
			if (!Objects.deepEquals(this.ssid, other.ssid)) {
				return false;
			} else if (!Objects.deepEquals(this.password, other.password)) {
				return false;
			} else if (!Objects.deepEquals(this.mode, other.mode)) {
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
		result = 31 * result + Objects.hashCode(this.ssid);
		result = 31 * result + Objects.hashCode(this.password);
		result = 31 * result + Objects.hashCode(this.mode);
		result = 31 * result + Objects.hashCode(this.response);
		return result;
	}

	@Override
	public String toString() {
		return "WifiConfigAp{" +
				"ssid=" + ssid +
				", password=" + password +
				", mode=" + mode +
				", response=" + response +
				'}';
	}
}