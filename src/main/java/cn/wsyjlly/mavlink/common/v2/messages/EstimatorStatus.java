package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.EstimatorStatusFlags;
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
		id = 230,
		messagePayloadLength = 42,
		description = "Estimator status message including flags, innovation test ratios and estimated accuracies. The flags message is an integer bitmask containing information on which EKF outputs are valid. See the ESTIMATOR_STATUS_FLAGS enum definition for further information. The innovation test ratios show the magnitude of the sensor innovation divided by the innovation check threshold. Under normal operation the innovation test ratios should be below 0.5 with occasional values up to 1.0. Values greater than 1.0 should be rare under normal operation and indicate that a measurement has been rejected by the filter. The user should be notified if an innovation test ratio greater than 1.0 is recorded. Notifications for values in the range between 0.5 and 1.0 should be optional and controllable by the user."
)
public class EstimatorStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 2, typeSize = 2, streamLength = 2, description = "Bitmap indicating which EKF outputs are valid.", enum0 = EstimatorStatusFlags.class)
	private int flags;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4, description = "Velocity innovation test ratio")
	private float velRatio;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "Horizontal position innovation test ratio")
	private float posHorizRatio;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Vertical position innovation test ratio")
	private float posVertRatio;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Magnetometer innovation test ratio")
	private float magRatio;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "Height above terrain innovation test ratio")
	private float haglRatio;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "True airspeed innovation test ratio")
	private float tasRatio;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4, description = "Horizontal position 1-STD accuracy relative to the EKF local origin", units = "m")
	private float posHorizAccuracy;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4, description = "Vertical position 1-STD accuracy relative to the EKF local origin", units = "m")
	private float posVertAccuracy;

	private final int messagePayloadLength = 42;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public EstimatorStatus(BigInteger timeUsec, int flags, float velRatio, float posHorizRatio, float posVertRatio, float magRatio, float haglRatio, float tasRatio, float posHorizAccuracy, float posVertAccuracy) {
		this.timeUsec = timeUsec;
		this.flags = flags;
		this.velRatio = velRatio;
		this.posHorizRatio = posHorizRatio;
		this.posVertRatio = posVertRatio;
		this.magRatio = magRatio;
		this.haglRatio = haglRatio;
		this.tasRatio = tasRatio;
		this.posHorizAccuracy = posHorizAccuracy;
		this.posVertAccuracy = posVertAccuracy;
	}

	public EstimatorStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 42！");
		}
		messagePayload(messagePayload);
	}

	public EstimatorStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		flags = byteArray.getUnsignedInt16(8);
		velRatio = byteArray.getFloat(10);
		posHorizRatio = byteArray.getFloat(14);
		posVertRatio = byteArray.getFloat(18);
		magRatio = byteArray.getFloat(22);
		haglRatio = byteArray.getFloat(26);
		tasRatio = byteArray.getFloat(30);
		posHorizAccuracy = byteArray.getFloat(34);
		posVertAccuracy = byteArray.getFloat(38);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putUnsignedInt16(flags,8);
		byteArray.putFloat(velRatio,10);
		byteArray.putFloat(posHorizRatio,14);
		byteArray.putFloat(posVertRatio,18);
		byteArray.putFloat(magRatio,22);
		byteArray.putFloat(haglRatio,26);
		byteArray.putFloat(tasRatio,30);
		byteArray.putFloat(posHorizAccuracy,34);
		byteArray.putFloat(posVertAccuracy,38);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final EstimatorStatus setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final EstimatorStatus setFlags(int flags) {
		this.flags = flags;
		return this;
	}

	public final int getFlags() {
		return flags;
	}

	public final EstimatorStatus setVelRatio(float velRatio) {
		this.velRatio = velRatio;
		return this;
	}

	public final float getVelRatio() {
		return velRatio;
	}

	public final EstimatorStatus setPosHorizRatio(float posHorizRatio) {
		this.posHorizRatio = posHorizRatio;
		return this;
	}

	public final float getPosHorizRatio() {
		return posHorizRatio;
	}

	public final EstimatorStatus setPosVertRatio(float posVertRatio) {
		this.posVertRatio = posVertRatio;
		return this;
	}

	public final float getPosVertRatio() {
		return posVertRatio;
	}

	public final EstimatorStatus setMagRatio(float magRatio) {
		this.magRatio = magRatio;
		return this;
	}

	public final float getMagRatio() {
		return magRatio;
	}

	public final EstimatorStatus setHaglRatio(float haglRatio) {
		this.haglRatio = haglRatio;
		return this;
	}

	public final float getHaglRatio() {
		return haglRatio;
	}

	public final EstimatorStatus setTasRatio(float tasRatio) {
		this.tasRatio = tasRatio;
		return this;
	}

	public final float getTasRatio() {
		return tasRatio;
	}

	public final EstimatorStatus setPosHorizAccuracy(float posHorizAccuracy) {
		this.posHorizAccuracy = posHorizAccuracy;
		return this;
	}

	public final float getPosHorizAccuracy() {
		return posHorizAccuracy;
	}

	public final EstimatorStatus setPosVertAccuracy(float posVertAccuracy) {
		this.posVertAccuracy = posVertAccuracy;
		return this;
	}

	public final float getPosVertAccuracy() {
		return posVertAccuracy;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			EstimatorStatus other = (EstimatorStatus)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.flags, other.flags)) {
				return false;
			} else if (!Objects.deepEquals(this.velRatio, other.velRatio)) {
				return false;
			} else if (!Objects.deepEquals(this.posHorizRatio, other.posHorizRatio)) {
				return false;
			} else if (!Objects.deepEquals(this.posVertRatio, other.posVertRatio)) {
				return false;
			} else if (!Objects.deepEquals(this.magRatio, other.magRatio)) {
				return false;
			} else if (!Objects.deepEquals(this.haglRatio, other.haglRatio)) {
				return false;
			} else if (!Objects.deepEquals(this.tasRatio, other.tasRatio)) {
				return false;
			} else if (!Objects.deepEquals(this.posHorizAccuracy, other.posHorizAccuracy)) {
				return false;
			} else {
				return Objects.deepEquals(this.posVertAccuracy, other.posVertAccuracy);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.flags);
		result = 31 * result + Objects.hashCode(this.velRatio);
		result = 31 * result + Objects.hashCode(this.posHorizRatio);
		result = 31 * result + Objects.hashCode(this.posVertRatio);
		result = 31 * result + Objects.hashCode(this.magRatio);
		result = 31 * result + Objects.hashCode(this.haglRatio);
		result = 31 * result + Objects.hashCode(this.tasRatio);
		result = 31 * result + Objects.hashCode(this.posHorizAccuracy);
		result = 31 * result + Objects.hashCode(this.posVertAccuracy);
		return result;
	}

	@Override
	public String toString() {
		return "EstimatorStatus{" +
				"timeUsec=" + timeUsec +
				", flags=" + flags +
				", velRatio=" + velRatio +
				", posHorizRatio=" + posHorizRatio +
				", posVertRatio=" + posVertRatio +
				", magRatio=" + magRatio +
				", haglRatio=" + haglRatio +
				", tasRatio=" + tasRatio +
				", posHorizAccuracy=" + posHorizAccuracy +
				", posVertAccuracy=" + posVertAccuracy +
				'}';
	}
}