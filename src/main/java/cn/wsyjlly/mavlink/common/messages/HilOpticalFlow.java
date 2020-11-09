package cn.wsyjlly.mavlink.common.messages;

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
 * Date 2020.11.09 - 03:37
 **********************************/

@MavlinkMessage(
		id = 114,
		messagePayloadLength = 44,
		description = "Simulated optical flow from a flow sensor (e.g. PX4FLOW or optical mouse sensor)"
)
public class HilOpticalFlow implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8)
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1)
	private short sensorId;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 3, typeSize = 4, streamLength = 4)
	private long integrationTimeUs;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4)
	private float integratedX;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4)
	private float integratedY;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4)
	private float integratedXgyro;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4)
	private float integratedYgyro;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4)
	private float integratedZgyro;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 9, typeSize = 2, streamLength = 2)
	private short temperature;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 10, typeSize = 1, streamLength = 1)
	private short quality;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 11, typeSize = 4, streamLength = 4)
	private long timeDeltaDistanceUs;

	@MavlinkMessageParam(mavlinkType = "float", position = 12, typeSize = 4, streamLength = 4)
	private float distance;

	private final int messagePayloadLength = 44;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public HilOpticalFlow(BigInteger timeUsec, short sensorId, long integrationTimeUs, float integratedX, float integratedY, float integratedXgyro, float integratedYgyro, float integratedZgyro, short temperature, short quality, long timeDeltaDistanceUs, float distance) {
		this.timeUsec = timeUsec;
		this.sensorId = sensorId;
		this.integrationTimeUs = integrationTimeUs;
		this.integratedX = integratedX;
		this.integratedY = integratedY;
		this.integratedXgyro = integratedXgyro;
		this.integratedYgyro = integratedYgyro;
		this.integratedZgyro = integratedZgyro;
		this.temperature = temperature;
		this.quality = quality;
		this.timeDeltaDistanceUs = timeDeltaDistanceUs;
		this.distance = distance;
	}

	public HilOpticalFlow(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 44！");
		}
		messagePayload(messagePayload);
	}

	public HilOpticalFlow(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.timeUsec = byteArray.getUnsignedInt64(0);
		this.sensorId = byteArray.getUnsignedInt8(8);
		this.integrationTimeUs = byteArray.getUnsignedInt32(9);
		this.integratedX = byteArray.getFloat(13);
		this.integratedY = byteArray.getFloat(17);
		this.integratedXgyro = byteArray.getFloat(21);
		this.integratedYgyro = byteArray.getFloat(25);
		this.integratedZgyro = byteArray.getFloat(29);
		this.temperature = byteArray.getInt16(33);
		this.quality = byteArray.getUnsignedInt8(35);
		this.timeDeltaDistanceUs = byteArray.getUnsignedInt32(36);
		this.distance = byteArray.getFloat(40);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final HilOpticalFlow setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final HilOpticalFlow setSensorId(short sensorId) {
		this.sensorId = sensorId;
		return this;
	}

	public final short getSensorId() {
		return sensorId;
	}

	public final HilOpticalFlow setIntegrationTimeUs(long integrationTimeUs) {
		this.integrationTimeUs = integrationTimeUs;
		return this;
	}

	public final long getIntegrationTimeUs() {
		return integrationTimeUs;
	}

	public final HilOpticalFlow setIntegratedX(float integratedX) {
		this.integratedX = integratedX;
		return this;
	}

	public final float getIntegratedX() {
		return integratedX;
	}

	public final HilOpticalFlow setIntegratedY(float integratedY) {
		this.integratedY = integratedY;
		return this;
	}

	public final float getIntegratedY() {
		return integratedY;
	}

	public final HilOpticalFlow setIntegratedXgyro(float integratedXgyro) {
		this.integratedXgyro = integratedXgyro;
		return this;
	}

	public final float getIntegratedXgyro() {
		return integratedXgyro;
	}

	public final HilOpticalFlow setIntegratedYgyro(float integratedYgyro) {
		this.integratedYgyro = integratedYgyro;
		return this;
	}

	public final float getIntegratedYgyro() {
		return integratedYgyro;
	}

	public final HilOpticalFlow setIntegratedZgyro(float integratedZgyro) {
		this.integratedZgyro = integratedZgyro;
		return this;
	}

	public final float getIntegratedZgyro() {
		return integratedZgyro;
	}

	public final HilOpticalFlow setTemperature(short temperature) {
		this.temperature = temperature;
		return this;
	}

	public final short getTemperature() {
		return temperature;
	}

	public final HilOpticalFlow setQuality(short quality) {
		this.quality = quality;
		return this;
	}

	public final short getQuality() {
		return quality;
	}

	public final HilOpticalFlow setTimeDeltaDistanceUs(long timeDeltaDistanceUs) {
		this.timeDeltaDistanceUs = timeDeltaDistanceUs;
		return this;
	}

	public final long getTimeDeltaDistanceUs() {
		return timeDeltaDistanceUs;
	}

	public final HilOpticalFlow setDistance(float distance) {
		this.distance = distance;
		return this;
	}

	public final float getDistance() {
		return distance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			HilOpticalFlow other = (HilOpticalFlow)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.sensorId, other.sensorId)) {
				return false;
			} else if (!Objects.deepEquals(this.integrationTimeUs, other.integrationTimeUs)) {
				return false;
			} else if (!Objects.deepEquals(this.integratedX, other.integratedX)) {
				return false;
			} else if (!Objects.deepEquals(this.integratedY, other.integratedY)) {
				return false;
			} else if (!Objects.deepEquals(this.integratedXgyro, other.integratedXgyro)) {
				return false;
			} else if (!Objects.deepEquals(this.integratedYgyro, other.integratedYgyro)) {
				return false;
			} else if (!Objects.deepEquals(this.integratedZgyro, other.integratedZgyro)) {
				return false;
			} else if (!Objects.deepEquals(this.temperature, other.temperature)) {
				return false;
			} else if (!Objects.deepEquals(this.quality, other.quality)) {
				return false;
			} else if (!Objects.deepEquals(this.timeDeltaDistanceUs, other.timeDeltaDistanceUs)) {
				return false;
			} else {
				return Objects.deepEquals(this.distance, other.distance);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.sensorId);
		result = 31 * result + Objects.hashCode(this.integrationTimeUs);
		result = 31 * result + Objects.hashCode(this.integratedX);
		result = 31 * result + Objects.hashCode(this.integratedY);
		result = 31 * result + Objects.hashCode(this.integratedXgyro);
		result = 31 * result + Objects.hashCode(this.integratedYgyro);
		result = 31 * result + Objects.hashCode(this.integratedZgyro);
		result = 31 * result + Objects.hashCode(this.temperature);
		result = 31 * result + Objects.hashCode(this.quality);
		result = 31 * result + Objects.hashCode(this.timeDeltaDistanceUs);
		result = 31 * result + Objects.hashCode(this.distance);
		return result;
	}

	@Override
	public String toString() {
		return "HilOpticalFlow{" +
				"timeUsec=" + timeUsec +
				", sensorId=" + sensorId +
				", integrationTimeUs=" + integrationTimeUs +
				", integratedX=" + integratedX +
				", integratedY=" + integratedY +
				", integratedXgyro=" + integratedXgyro +
				", integratedYgyro=" + integratedYgyro +
				", integratedZgyro=" + integratedZgyro +
				", temperature=" + temperature +
				", quality=" + quality +
				", timeDeltaDistanceUs=" + timeDeltaDistanceUs +
				", distance=" + distance +
				'}';
	}
}