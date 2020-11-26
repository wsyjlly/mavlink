package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavLandedState;
import cn.wsyjlly.mavlink.common.v2.enums.EstimatorStatusFlags;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.util.Arrays;
import java.math.BigInteger;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 286,
		messagePayloadLength = 53,
		description = "Low level message containing autopilot state relevant for a gimbal device. This message is to be sent from the gimbal manager to the gimbal device component. The data of this message server for the gimbal's estimator corrections in particular horizon compensation, as well as the autopilot's control intention e.g. feed forward angular control in z-axis."
)
public class AutopilotStateForGimbalDevice implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 3, typeSize = 8, streamLength = 8, description = "Timestamp (time since system boot).", units = "us")
	private BigInteger timeBootUs;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 16, description = "Quaternion components of autopilot attitude: w, x, y, z (1 0 0 0 is the null-rotation, Hamilton convention).")
	private float[] q = new float[4];

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 5, typeSize = 4, streamLength = 4, description = "Estimated delay of the attitude data.", units = "us")
	private long qEstimatedDelayUs;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "X Speed in NED (North, East, Down).", units = "m/s")
	private float vx;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "Y Speed in NED (North, East, Down).", units = "m/s")
	private float vy;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "Z Speed in NED (North, East, Down).", units = "m/s")
	private float vz;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 9, typeSize = 4, streamLength = 4, description = "Estimated delay of the speed data.", units = "us")
	private long vEstimatedDelayUs;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4, description = "Feed forward Z component of angular velocity, positive is yawing to the right, NaN to be ignored. This is to indicate if the autopilot is actively yawing.", units = "rad/s")
	private float feedForwardAngularVelocityZ;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 11, typeSize = 2, streamLength = 2, description = "Bitmap indicating which estimator outputs are valid.", enum0 = EstimatorStatusFlags.class)
	private int estimatorStatus;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 12, typeSize = 1, streamLength = 1, description = "The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown.", enum0 = MavLandedState.class)
	private short landedState;

	private final int messagePayloadLength = 53;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public AutopilotStateForGimbalDevice(short targetSystem, short targetComponent, BigInteger timeBootUs, float[] q, long qEstimatedDelayUs, float vx, float vy, float vz, long vEstimatedDelayUs, float feedForwardAngularVelocityZ, int estimatorStatus, short landedState) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.timeBootUs = timeBootUs;
		this.q = q;
		this.qEstimatedDelayUs = qEstimatedDelayUs;
		this.vx = vx;
		this.vy = vy;
		this.vz = vz;
		this.vEstimatedDelayUs = vEstimatedDelayUs;
		this.feedForwardAngularVelocityZ = feedForwardAngularVelocityZ;
		this.estimatorStatus = estimatorStatus;
		this.landedState = landedState;
	}

	public AutopilotStateForGimbalDevice(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 53！");
		}
		messagePayload(messagePayload);
	}

	public AutopilotStateForGimbalDevice(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		timeBootUs = byteArray.getUnsignedInt64(2);
		q = byteArray.getFloatArray(10,4);
		qEstimatedDelayUs = byteArray.getUnsignedInt32(26);
		vx = byteArray.getFloat(30);
		vy = byteArray.getFloat(34);
		vz = byteArray.getFloat(38);
		vEstimatedDelayUs = byteArray.getUnsignedInt32(42);
		feedForwardAngularVelocityZ = byteArray.getFloat(46);
		estimatorStatus = byteArray.getUnsignedInt16(50);
		landedState = byteArray.getUnsignedInt8(52);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putUnsignedInt64(timeBootUs,2);
		byteArray.putFloatArray(q,10);
		byteArray.putUnsignedInt32(qEstimatedDelayUs,26);
		byteArray.putFloat(vx,30);
		byteArray.putFloat(vy,34);
		byteArray.putFloat(vz,38);
		byteArray.putUnsignedInt32(vEstimatedDelayUs,42);
		byteArray.putFloat(feedForwardAngularVelocityZ,46);
		byteArray.putUnsignedInt16(estimatorStatus,50);
		byteArray.putUnsignedInt8(landedState,52);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final AutopilotStateForGimbalDevice setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final AutopilotStateForGimbalDevice setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final AutopilotStateForGimbalDevice setTimeBootUs(BigInteger timeBootUs) {
		this.timeBootUs = timeBootUs;
		return this;
	}

	public final BigInteger getTimeBootUs() {
		return timeBootUs;
	}

	public final AutopilotStateForGimbalDevice setQ(float[] q) {
		this.q = q;
		return this;
	}

	public final float[] getQ() {
		return q;
	}

	public final AutopilotStateForGimbalDevice setQEstimatedDelayUs(long qEstimatedDelayUs) {
		this.qEstimatedDelayUs = qEstimatedDelayUs;
		return this;
	}

	public final long getQEstimatedDelayUs() {
		return qEstimatedDelayUs;
	}

	public final AutopilotStateForGimbalDevice setVx(float vx) {
		this.vx = vx;
		return this;
	}

	public final float getVx() {
		return vx;
	}

	public final AutopilotStateForGimbalDevice setVy(float vy) {
		this.vy = vy;
		return this;
	}

	public final float getVy() {
		return vy;
	}

	public final AutopilotStateForGimbalDevice setVz(float vz) {
		this.vz = vz;
		return this;
	}

	public final float getVz() {
		return vz;
	}

	public final AutopilotStateForGimbalDevice setVEstimatedDelayUs(long vEstimatedDelayUs) {
		this.vEstimatedDelayUs = vEstimatedDelayUs;
		return this;
	}

	public final long getVEstimatedDelayUs() {
		return vEstimatedDelayUs;
	}

	public final AutopilotStateForGimbalDevice setFeedForwardAngularVelocityZ(float feedForwardAngularVelocityZ) {
		this.feedForwardAngularVelocityZ = feedForwardAngularVelocityZ;
		return this;
	}

	public final float getFeedForwardAngularVelocityZ() {
		return feedForwardAngularVelocityZ;
	}

	public final AutopilotStateForGimbalDevice setEstimatorStatus(int estimatorStatus) {
		this.estimatorStatus = estimatorStatus;
		return this;
	}

	public final int getEstimatorStatus() {
		return estimatorStatus;
	}

	public final AutopilotStateForGimbalDevice setLandedState(short landedState) {
		this.landedState = landedState;
		return this;
	}

	public final short getLandedState() {
		return landedState;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			AutopilotStateForGimbalDevice other = (AutopilotStateForGimbalDevice)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.timeBootUs, other.timeBootUs)) {
				return false;
			} else if (!Objects.deepEquals(this.q, other.q)) {
				return false;
			} else if (!Objects.deepEquals(this.qEstimatedDelayUs, other.qEstimatedDelayUs)) {
				return false;
			} else if (!Objects.deepEquals(this.vx, other.vx)) {
				return false;
			} else if (!Objects.deepEquals(this.vy, other.vy)) {
				return false;
			} else if (!Objects.deepEquals(this.vz, other.vz)) {
				return false;
			} else if (!Objects.deepEquals(this.vEstimatedDelayUs, other.vEstimatedDelayUs)) {
				return false;
			} else if (!Objects.deepEquals(this.feedForwardAngularVelocityZ, other.feedForwardAngularVelocityZ)) {
				return false;
			} else if (!Objects.deepEquals(this.estimatorStatus, other.estimatorStatus)) {
				return false;
			} else {
				return Objects.deepEquals(this.landedState, other.landedState);
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
		result = 31 * result + Objects.hashCode(this.timeBootUs);
		result = 31 * result + Objects.hashCode(this.q);
		result = 31 * result + Objects.hashCode(this.qEstimatedDelayUs);
		result = 31 * result + Objects.hashCode(this.vx);
		result = 31 * result + Objects.hashCode(this.vy);
		result = 31 * result + Objects.hashCode(this.vz);
		result = 31 * result + Objects.hashCode(this.vEstimatedDelayUs);
		result = 31 * result + Objects.hashCode(this.feedForwardAngularVelocityZ);
		result = 31 * result + Objects.hashCode(this.estimatorStatus);
		result = 31 * result + Objects.hashCode(this.landedState);
		return result;
	}

	@Override
	public String toString() {
		return "AutopilotStateForGimbalDevice{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", timeBootUs=" + timeBootUs +
				", q=" + Arrays.toString(q) +
				", qEstimatedDelayUs=" + qEstimatedDelayUs +
				", vx=" + vx +
				", vy=" + vy +
				", vz=" + vz +
				", vEstimatedDelayUs=" + vEstimatedDelayUs +
				", feedForwardAngularVelocityZ=" + feedForwardAngularVelocityZ +
				", estimatorStatus=" + estimatorStatus +
				", landedState=" + landedState +
				'}';
	}
}