package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.math.BigInteger;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 264,
		messagePayloadLength = 28,
		description = "Information about flight since last arming."
)
public class FlightInformation implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp (time since system boot).", units = "ms")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 2, typeSize = 8, streamLength = 8, description = "Timestamp at arming (time since UNIX epoch) in UTC, 0 for unknown", units = "us")
	private BigInteger armingTimeUtc;

	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 3, typeSize = 8, streamLength = 8, description = "Timestamp at takeoff (time since UNIX epoch) in UTC, 0 for unknown", units = "us")
	private BigInteger takeoffTimeUtc;

	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 4, typeSize = 8, streamLength = 8, description = "Universally unique identifier (UUID) of flight, should correspond to name of log files")
	private BigInteger flightUuid;

	private final int messagePayloadLength = 28;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public FlightInformation(long timeBootMs, BigInteger armingTimeUtc, BigInteger takeoffTimeUtc, BigInteger flightUuid) {
		this.timeBootMs = timeBootMs;
		this.armingTimeUtc = armingTimeUtc;
		this.takeoffTimeUtc = takeoffTimeUtc;
		this.flightUuid = flightUuid;
	}

	public FlightInformation(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 28！");
		}
		messagePayload(messagePayload);
	}

	public FlightInformation(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeBootMs = byteArray.getUnsignedInt32(0);
		armingTimeUtc = byteArray.getUnsignedInt64(4);
		takeoffTimeUtc = byteArray.getUnsignedInt64(12);
		flightUuid = byteArray.getUnsignedInt64(20);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeBootMs,0);
		byteArray.putUnsignedInt64(armingTimeUtc,4);
		byteArray.putUnsignedInt64(takeoffTimeUtc,12);
		byteArray.putUnsignedInt64(flightUuid,20);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final FlightInformation setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final FlightInformation setArmingTimeUtc(BigInteger armingTimeUtc) {
		this.armingTimeUtc = armingTimeUtc;
		return this;
	}

	public final BigInteger getArmingTimeUtc() {
		return armingTimeUtc;
	}

	public final FlightInformation setTakeoffTimeUtc(BigInteger takeoffTimeUtc) {
		this.takeoffTimeUtc = takeoffTimeUtc;
		return this;
	}

	public final BigInteger getTakeoffTimeUtc() {
		return takeoffTimeUtc;
	}

	public final FlightInformation setFlightUuid(BigInteger flightUuid) {
		this.flightUuid = flightUuid;
		return this;
	}

	public final BigInteger getFlightUuid() {
		return flightUuid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			FlightInformation other = (FlightInformation)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.armingTimeUtc, other.armingTimeUtc)) {
				return false;
			} else if (!Objects.deepEquals(this.takeoffTimeUtc, other.takeoffTimeUtc)) {
				return false;
			} else {
				return Objects.deepEquals(this.flightUuid, other.flightUuid);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeBootMs);
		result = 31 * result + Objects.hashCode(this.armingTimeUtc);
		result = 31 * result + Objects.hashCode(this.takeoffTimeUtc);
		result = 31 * result + Objects.hashCode(this.flightUuid);
		return result;
	}

	@Override
	public String toString() {
		return "FlightInformation{" +
				"timeBootMs=" + timeBootMs +
				", armingTimeUtc=" + armingTimeUtc +
				", takeoffTimeUtc=" + takeoffTimeUtc +
				", flightUuid=" + flightUuid +
				'}';
	}
}