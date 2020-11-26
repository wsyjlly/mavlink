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
		id = 249,
		messagePayloadLength = 36,
		description = "Send raw controller memory. The use of this message is discouraged for normal packets, but a quite efficient way for testing new messages and getting experimental debug output."
)
public class MemoryVect implements Message {
	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 1, typeSize = 2, streamLength = 2, description = "Starting address of the debug variables")
	private int address;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Version code of the type variable. 0=unknown, type ignored and assumed int16_t. 1=as below")
	private short ver;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Type code of the memory variables. for ver = 1: 0=16 x int16_t, 1=16 x uint16_t, 2=16 x Q15, 3=16 x 1Q14")
	private short type;

	@MavlinkMessageParam(mavlinkType = "int8_t", position = 4, typeSize = 1, streamLength = 32, description = "Memory contents at specified address")
	private byte[] value = new byte[32];

	private final int messagePayloadLength = 36;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public MemoryVect(int address, short ver, short type, byte[] value) {
		this.address = address;
		this.ver = ver;
		this.type = type;
		this.value = value;
	}

	public MemoryVect(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 36！");
		}
		messagePayload(messagePayload);
	}

	public MemoryVect(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		address = byteArray.getUnsignedInt16(0);
		ver = byteArray.getUnsignedInt8(2);
		type = byteArray.getUnsignedInt8(3);
		value = byteArray.getInt8Array(4,32);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt16(address,0);
		byteArray.putUnsignedInt8(ver,2);
		byteArray.putUnsignedInt8(type,3);
		byteArray.putInt8Array(value,4);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final MemoryVect setAddress(int address) {
		this.address = address;
		return this;
	}

	public final int getAddress() {
		return address;
	}

	public final MemoryVect setVer(short ver) {
		this.ver = ver;
		return this;
	}

	public final short getVer() {
		return ver;
	}

	public final MemoryVect setType(short type) {
		this.type = type;
		return this;
	}

	public final short getType() {
		return type;
	}

	public final MemoryVect setValue(byte[] value) {
		this.value = value;
		return this;
	}

	public final byte[] getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			MemoryVect other = (MemoryVect)o;
			if (!Objects.deepEquals(this.address, other.address)) {
				return false;
			} else if (!Objects.deepEquals(this.ver, other.ver)) {
				return false;
			} else if (!Objects.deepEquals(this.type, other.type)) {
				return false;
			} else {
				return Objects.deepEquals(this.value, other.value);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.address);
		result = 31 * result + Objects.hashCode(this.ver);
		result = 31 * result + Objects.hashCode(this.type);
		result = 31 * result + Objects.hashCode(this.value);
		return result;
	}

	@Override
	public String toString() {
		return "MemoryVect{" +
				"address=" + address +
				", ver=" + ver +
				", type=" + type +
				", value=" + Arrays.toString(value) +
				'}';
	}
}