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
		id = 231,
		messagePayloadLength = 40,
		description = "Wind covariance estimate from vehicle."
)
public class WindCov implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4, description = "Wind in X (NED) direction", units = "m/s")
	private float windX;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4, description = "Wind in Y (NED) direction", units = "m/s")
	private float windY;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "Wind in Z (NED) direction", units = "m/s")
	private float windZ;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Variability of the wind in XY. RMS of a 1 Hz lowpassed wind estimate.", units = "m/s")
	private float varHoriz;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Variability of the wind in Z. RMS of a 1 Hz lowpassed wind estimate.", units = "m/s")
	private float varVert;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "Altitude (MSL) that this measurement was taken at", units = "m")
	private float windAlt;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "Horizontal speed 1-STD accuracy", units = "m")
	private float horizAccuracy;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4, description = "Vertical speed 1-STD accuracy", units = "m")
	private float vertAccuracy;

	private final int messagePayloadLength = 40;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public WindCov(BigInteger timeUsec, float windX, float windY, float windZ, float varHoriz, float varVert, float windAlt, float horizAccuracy, float vertAccuracy) {
		this.timeUsec = timeUsec;
		this.windX = windX;
		this.windY = windY;
		this.windZ = windZ;
		this.varHoriz = varHoriz;
		this.varVert = varVert;
		this.windAlt = windAlt;
		this.horizAccuracy = horizAccuracy;
		this.vertAccuracy = vertAccuracy;
	}

	public WindCov(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 40！");
		}
		messagePayload(messagePayload);
	}

	public WindCov(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		windX = byteArray.getFloat(8);
		windY = byteArray.getFloat(12);
		windZ = byteArray.getFloat(16);
		varHoriz = byteArray.getFloat(20);
		varVert = byteArray.getFloat(24);
		windAlt = byteArray.getFloat(28);
		horizAccuracy = byteArray.getFloat(32);
		vertAccuracy = byteArray.getFloat(36);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putFloat(windX,8);
		byteArray.putFloat(windY,12);
		byteArray.putFloat(windZ,16);
		byteArray.putFloat(varHoriz,20);
		byteArray.putFloat(varVert,24);
		byteArray.putFloat(windAlt,28);
		byteArray.putFloat(horizAccuracy,32);
		byteArray.putFloat(vertAccuracy,36);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final WindCov setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final WindCov setWindX(float windX) {
		this.windX = windX;
		return this;
	}

	public final float getWindX() {
		return windX;
	}

	public final WindCov setWindY(float windY) {
		this.windY = windY;
		return this;
	}

	public final float getWindY() {
		return windY;
	}

	public final WindCov setWindZ(float windZ) {
		this.windZ = windZ;
		return this;
	}

	public final float getWindZ() {
		return windZ;
	}

	public final WindCov setVarHoriz(float varHoriz) {
		this.varHoriz = varHoriz;
		return this;
	}

	public final float getVarHoriz() {
		return varHoriz;
	}

	public final WindCov setVarVert(float varVert) {
		this.varVert = varVert;
		return this;
	}

	public final float getVarVert() {
		return varVert;
	}

	public final WindCov setWindAlt(float windAlt) {
		this.windAlt = windAlt;
		return this;
	}

	public final float getWindAlt() {
		return windAlt;
	}

	public final WindCov setHorizAccuracy(float horizAccuracy) {
		this.horizAccuracy = horizAccuracy;
		return this;
	}

	public final float getHorizAccuracy() {
		return horizAccuracy;
	}

	public final WindCov setVertAccuracy(float vertAccuracy) {
		this.vertAccuracy = vertAccuracy;
		return this;
	}

	public final float getVertAccuracy() {
		return vertAccuracy;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			WindCov other = (WindCov)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.windX, other.windX)) {
				return false;
			} else if (!Objects.deepEquals(this.windY, other.windY)) {
				return false;
			} else if (!Objects.deepEquals(this.windZ, other.windZ)) {
				return false;
			} else if (!Objects.deepEquals(this.varHoriz, other.varHoriz)) {
				return false;
			} else if (!Objects.deepEquals(this.varVert, other.varVert)) {
				return false;
			} else if (!Objects.deepEquals(this.windAlt, other.windAlt)) {
				return false;
			} else if (!Objects.deepEquals(this.horizAccuracy, other.horizAccuracy)) {
				return false;
			} else {
				return Objects.deepEquals(this.vertAccuracy, other.vertAccuracy);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.windX);
		result = 31 * result + Objects.hashCode(this.windY);
		result = 31 * result + Objects.hashCode(this.windZ);
		result = 31 * result + Objects.hashCode(this.varHoriz);
		result = 31 * result + Objects.hashCode(this.varVert);
		result = 31 * result + Objects.hashCode(this.windAlt);
		result = 31 * result + Objects.hashCode(this.horizAccuracy);
		result = 31 * result + Objects.hashCode(this.vertAccuracy);
		return result;
	}

	@Override
	public String toString() {
		return "WindCov{" +
				"timeUsec=" + timeUsec +
				", windX=" + windX +
				", windY=" + windY +
				", windZ=" + windZ +
				", varHoriz=" + varHoriz +
				", varVert=" + varVert +
				", windAlt=" + windAlt +
				", horizAccuracy=" + horizAccuracy +
				", vertAccuracy=" + vertAccuracy +
				'}';
	}
}