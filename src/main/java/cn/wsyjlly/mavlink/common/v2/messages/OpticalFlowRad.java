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
		id = 106,
		messagePayloadLength = 44,
		description = "Optical flow from an angular rate flow sensor (e.g. PX4FLOW or mouse sensor)"
)
public class OpticalFlowRad implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Sensor ID")
	private short sensorId;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 3, typeSize = 4, streamLength = 4, description = "Integration time. Divide integrated_x and integrated_y by the integration time to obtain average flow. The integration time also indicates the.", units = "us")
	private long integrationTimeUs;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "Flow around X axis (Sensor RH rotation about the X axis induces a positive flow. Sensor linear motion along the positive Y axis induces a negative flow.)", units = "rad")
	private float integratedX;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Flow around Y axis (Sensor RH rotation about the Y axis induces a positive flow. Sensor linear motion along the positive X axis induces a positive flow.)", units = "rad")
	private float integratedY;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "RH rotation around X axis", units = "rad")
	private float integratedXgyro;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "RH rotation around Y axis", units = "rad")
	private float integratedYgyro;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "RH rotation around Z axis", units = "rad")
	private float integratedZgyro;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 9, typeSize = 2, streamLength = 2, description = "Temperature", units = "cdegC")
	private short temperature;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 10, typeSize = 1, streamLength = 1, description = "Optical flow quality / confidence. 0: no valid flow, 255: maximum quality")
	private short quality;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 11, typeSize = 4, streamLength = 4, description = "Time since the distance was sampled.", units = "us")
	private long timeDeltaDistanceUs;

	@MavlinkMessageParam(mavlinkType = "float", position = 12, typeSize = 4, streamLength = 4, description = "Distance to the center of the flow field. Positive value (including zero): distance known. Negative value: Unknown distance.", units = "m")
	private float distance;

	private final int messagePayloadLength = 44;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public OpticalFlowRad(BigInteger timeUsec, short sensorId, long integrationTimeUs, float integratedX, float integratedY, float integratedXgyro, float integratedYgyro, float integratedZgyro, short temperature, short quality, long timeDeltaDistanceUs, float distance) {
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

	public OpticalFlowRad(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 44！");
		}
		messagePayload(messagePayload);
	}

	public OpticalFlowRad(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		sensorId = byteArray.getUnsignedInt8(8);
		integrationTimeUs = byteArray.getUnsignedInt32(9);
		integratedX = byteArray.getFloat(13);
		integratedY = byteArray.getFloat(17);
		integratedXgyro = byteArray.getFloat(21);
		integratedYgyro = byteArray.getFloat(25);
		integratedZgyro = byteArray.getFloat(29);
		temperature = byteArray.getInt16(33);
		quality = byteArray.getUnsignedInt8(35);
		timeDeltaDistanceUs = byteArray.getUnsignedInt32(36);
		distance = byteArray.getFloat(40);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putUnsignedInt8(sensorId,8);
		byteArray.putUnsignedInt32(integrationTimeUs,9);
		byteArray.putFloat(integratedX,13);
		byteArray.putFloat(integratedY,17);
		byteArray.putFloat(integratedXgyro,21);
		byteArray.putFloat(integratedYgyro,25);
		byteArray.putFloat(integratedZgyro,29);
		byteArray.putInt16(temperature,33);
		byteArray.putUnsignedInt8(quality,35);
		byteArray.putUnsignedInt32(timeDeltaDistanceUs,36);
		byteArray.putFloat(distance,40);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final OpticalFlowRad setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final OpticalFlowRad setSensorId(short sensorId) {
		this.sensorId = sensorId;
		return this;
	}

	public final short getSensorId() {
		return sensorId;
	}

	public final OpticalFlowRad setIntegrationTimeUs(long integrationTimeUs) {
		this.integrationTimeUs = integrationTimeUs;
		return this;
	}

	public final long getIntegrationTimeUs() {
		return integrationTimeUs;
	}

	public final OpticalFlowRad setIntegratedX(float integratedX) {
		this.integratedX = integratedX;
		return this;
	}

	public final float getIntegratedX() {
		return integratedX;
	}

	public final OpticalFlowRad setIntegratedY(float integratedY) {
		this.integratedY = integratedY;
		return this;
	}

	public final float getIntegratedY() {
		return integratedY;
	}

	public final OpticalFlowRad setIntegratedXgyro(float integratedXgyro) {
		this.integratedXgyro = integratedXgyro;
		return this;
	}

	public final float getIntegratedXgyro() {
		return integratedXgyro;
	}

	public final OpticalFlowRad setIntegratedYgyro(float integratedYgyro) {
		this.integratedYgyro = integratedYgyro;
		return this;
	}

	public final float getIntegratedYgyro() {
		return integratedYgyro;
	}

	public final OpticalFlowRad setIntegratedZgyro(float integratedZgyro) {
		this.integratedZgyro = integratedZgyro;
		return this;
	}

	public final float getIntegratedZgyro() {
		return integratedZgyro;
	}

	public final OpticalFlowRad setTemperature(short temperature) {
		this.temperature = temperature;
		return this;
	}

	public final short getTemperature() {
		return temperature;
	}

	public final OpticalFlowRad setQuality(short quality) {
		this.quality = quality;
		return this;
	}

	public final short getQuality() {
		return quality;
	}

	public final OpticalFlowRad setTimeDeltaDistanceUs(long timeDeltaDistanceUs) {
		this.timeDeltaDistanceUs = timeDeltaDistanceUs;
		return this;
	}

	public final long getTimeDeltaDistanceUs() {
		return timeDeltaDistanceUs;
	}

	public final OpticalFlowRad setDistance(float distance) {
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
			OpticalFlowRad other = (OpticalFlowRad)o;
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
		return "OpticalFlowRad{" +
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