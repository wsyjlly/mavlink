package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavEstimatorType;
import cn.wsyjlly.mavlink.common.v2.enums.MavFrame;
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
		id = 331,
		messagePayloadLength = 232,
		description = "Odometry message to communicate odometry information with an external interface. Fits ROS REP 147 standard for aerial vehicles (http://www.ros.org/reps/rep-0147.html)."
)
public class Odometry implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Coordinate frame of reference for the pose data.", enum0 = MavFrame.class)
	private short frameId;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Coordinate frame of reference for the velocity in free space (twist) data.", enum0 = MavFrame.class)
	private short childFrameId;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "X Position", units = "m")
	private float x;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Y Position", units = "m")
	private float y;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Z Position", units = "m")
	private float z;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 16, description = "Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation)")
	private float[] q = new float[4];

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "X linear speed", units = "m/s")
	private float vx;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4, description = "Y linear speed", units = "m/s")
	private float vy;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4, description = "Z linear speed", units = "m/s")
	private float vz;

	@MavlinkMessageParam(mavlinkType = "float", position = 11, typeSize = 4, streamLength = 4, description = "Roll angular speed", units = "rad/s")
	private float rollspeed;

	@MavlinkMessageParam(mavlinkType = "float", position = 12, typeSize = 4, streamLength = 4, description = "Pitch angular speed", units = "rad/s")
	private float pitchspeed;

	@MavlinkMessageParam(mavlinkType = "float", position = 13, typeSize = 4, streamLength = 4, description = "Yaw angular speed", units = "rad/s")
	private float yawspeed;

	@MavlinkMessageParam(mavlinkType = "float", position = 14, typeSize = 4, streamLength = 84, description = "Row-major representation of a 6x6 pose cross-covariance matrix upper right triangle (states: x, y, z, roll, pitch, yaw; first six entries are the first ROW, next five entries are the second ROW, etc.). If unknown, assign NaN value to first element in the array.")
	private float[] poseCovariance = new float[21];

	@MavlinkMessageParam(mavlinkType = "float", position = 15, typeSize = 4, streamLength = 84, description = "Row-major representation of a 6x6 velocity cross-covariance matrix upper right triangle (states: vx, vy, vz, rollspeed, pitchspeed, yawspeed; first six entries are the first ROW, next five entries are the second ROW, etc.). If unknown, assign NaN value to first element in the array.")
	private float[] velocityCovariance = new float[21];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 16, typeSize = 1, streamLength = 1, description = "Estimate reset counter. This should be incremented when the estimate resets in any of the dimensions (position, velocity, attitude, angular speed). This is designed to be used when e.g an external SLAM system detects a loop-closure and the estimate jumps.")
	private short resetCounter;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 17, typeSize = 1, streamLength = 1, description = "Type of estimator that is providing the odometry.", enum0 = MavEstimatorType.class)
	private short estimatorType;

	private final int messagePayloadLength = 232;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public Odometry(BigInteger timeUsec, short frameId, short childFrameId, float x, float y, float z, float[] q, float vx, float vy, float vz, float rollspeed, float pitchspeed, float yawspeed, float[] poseCovariance, float[] velocityCovariance, short resetCounter, short estimatorType) {
		this.timeUsec = timeUsec;
		this.frameId = frameId;
		this.childFrameId = childFrameId;
		this.x = x;
		this.y = y;
		this.z = z;
		this.q = q;
		this.vx = vx;
		this.vy = vy;
		this.vz = vz;
		this.rollspeed = rollspeed;
		this.pitchspeed = pitchspeed;
		this.yawspeed = yawspeed;
		this.poseCovariance = poseCovariance;
		this.velocityCovariance = velocityCovariance;
		this.resetCounter = resetCounter;
		this.estimatorType = estimatorType;
	}

	public Odometry(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 232！");
		}
		messagePayload(messagePayload);
	}

	public Odometry(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		frameId = byteArray.getUnsignedInt8(8);
		childFrameId = byteArray.getUnsignedInt8(9);
		x = byteArray.getFloat(10);
		y = byteArray.getFloat(14);
		z = byteArray.getFloat(18);
		q = byteArray.getFloatArray(22,4);
		vx = byteArray.getFloat(38);
		vy = byteArray.getFloat(42);
		vz = byteArray.getFloat(46);
		rollspeed = byteArray.getFloat(50);
		pitchspeed = byteArray.getFloat(54);
		yawspeed = byteArray.getFloat(58);
		poseCovariance = byteArray.getFloatArray(62,21);
		velocityCovariance = byteArray.getFloatArray(146,21);
		resetCounter = byteArray.getUnsignedInt8(230);
		estimatorType = byteArray.getUnsignedInt8(231);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putUnsignedInt8(frameId,8);
		byteArray.putUnsignedInt8(childFrameId,9);
		byteArray.putFloat(x,10);
		byteArray.putFloat(y,14);
		byteArray.putFloat(z,18);
		byteArray.putFloatArray(q,22);
		byteArray.putFloat(vx,38);
		byteArray.putFloat(vy,42);
		byteArray.putFloat(vz,46);
		byteArray.putFloat(rollspeed,50);
		byteArray.putFloat(pitchspeed,54);
		byteArray.putFloat(yawspeed,58);
		byteArray.putFloatArray(poseCovariance,62);
		byteArray.putFloatArray(velocityCovariance,146);
		byteArray.putUnsignedInt8(resetCounter,230);
		byteArray.putUnsignedInt8(estimatorType,231);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final Odometry setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final Odometry setFrameId(short frameId) {
		this.frameId = frameId;
		return this;
	}

	public final short getFrameId() {
		return frameId;
	}

	public final Odometry setChildFrameId(short childFrameId) {
		this.childFrameId = childFrameId;
		return this;
	}

	public final short getChildFrameId() {
		return childFrameId;
	}

	public final Odometry setX(float x) {
		this.x = x;
		return this;
	}

	public final float getX() {
		return x;
	}

	public final Odometry setY(float y) {
		this.y = y;
		return this;
	}

	public final float getY() {
		return y;
	}

	public final Odometry setZ(float z) {
		this.z = z;
		return this;
	}

	public final float getZ() {
		return z;
	}

	public final Odometry setQ(float[] q) {
		this.q = q;
		return this;
	}

	public final float[] getQ() {
		return q;
	}

	public final Odometry setVx(float vx) {
		this.vx = vx;
		return this;
	}

	public final float getVx() {
		return vx;
	}

	public final Odometry setVy(float vy) {
		this.vy = vy;
		return this;
	}

	public final float getVy() {
		return vy;
	}

	public final Odometry setVz(float vz) {
		this.vz = vz;
		return this;
	}

	public final float getVz() {
		return vz;
	}

	public final Odometry setRollspeed(float rollspeed) {
		this.rollspeed = rollspeed;
		return this;
	}

	public final float getRollspeed() {
		return rollspeed;
	}

	public final Odometry setPitchspeed(float pitchspeed) {
		this.pitchspeed = pitchspeed;
		return this;
	}

	public final float getPitchspeed() {
		return pitchspeed;
	}

	public final Odometry setYawspeed(float yawspeed) {
		this.yawspeed = yawspeed;
		return this;
	}

	public final float getYawspeed() {
		return yawspeed;
	}

	public final Odometry setPoseCovariance(float[] poseCovariance) {
		this.poseCovariance = poseCovariance;
		return this;
	}

	public final float[] getPoseCovariance() {
		return poseCovariance;
	}

	public final Odometry setVelocityCovariance(float[] velocityCovariance) {
		this.velocityCovariance = velocityCovariance;
		return this;
	}

	public final float[] getVelocityCovariance() {
		return velocityCovariance;
	}

	public final Odometry setResetCounter(short resetCounter) {
		this.resetCounter = resetCounter;
		return this;
	}

	public final short getResetCounter() {
		return resetCounter;
	}

	public final Odometry setEstimatorType(short estimatorType) {
		this.estimatorType = estimatorType;
		return this;
	}

	public final short getEstimatorType() {
		return estimatorType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			Odometry other = (Odometry)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.frameId, other.frameId)) {
				return false;
			} else if (!Objects.deepEquals(this.childFrameId, other.childFrameId)) {
				return false;
			} else if (!Objects.deepEquals(this.x, other.x)) {
				return false;
			} else if (!Objects.deepEquals(this.y, other.y)) {
				return false;
			} else if (!Objects.deepEquals(this.z, other.z)) {
				return false;
			} else if (!Objects.deepEquals(this.q, other.q)) {
				return false;
			} else if (!Objects.deepEquals(this.vx, other.vx)) {
				return false;
			} else if (!Objects.deepEquals(this.vy, other.vy)) {
				return false;
			} else if (!Objects.deepEquals(this.vz, other.vz)) {
				return false;
			} else if (!Objects.deepEquals(this.rollspeed, other.rollspeed)) {
				return false;
			} else if (!Objects.deepEquals(this.pitchspeed, other.pitchspeed)) {
				return false;
			} else if (!Objects.deepEquals(this.yawspeed, other.yawspeed)) {
				return false;
			} else if (!Objects.deepEquals(this.poseCovariance, other.poseCovariance)) {
				return false;
			} else if (!Objects.deepEquals(this.velocityCovariance, other.velocityCovariance)) {
				return false;
			} else if (!Objects.deepEquals(this.resetCounter, other.resetCounter)) {
				return false;
			} else {
				return Objects.deepEquals(this.estimatorType, other.estimatorType);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.frameId);
		result = 31 * result + Objects.hashCode(this.childFrameId);
		result = 31 * result + Objects.hashCode(this.x);
		result = 31 * result + Objects.hashCode(this.y);
		result = 31 * result + Objects.hashCode(this.z);
		result = 31 * result + Objects.hashCode(this.q);
		result = 31 * result + Objects.hashCode(this.vx);
		result = 31 * result + Objects.hashCode(this.vy);
		result = 31 * result + Objects.hashCode(this.vz);
		result = 31 * result + Objects.hashCode(this.rollspeed);
		result = 31 * result + Objects.hashCode(this.pitchspeed);
		result = 31 * result + Objects.hashCode(this.yawspeed);
		result = 31 * result + Objects.hashCode(this.poseCovariance);
		result = 31 * result + Objects.hashCode(this.velocityCovariance);
		result = 31 * result + Objects.hashCode(this.resetCounter);
		result = 31 * result + Objects.hashCode(this.estimatorType);
		return result;
	}

	@Override
	public String toString() {
		return "Odometry{" +
				"timeUsec=" + timeUsec +
				", frameId=" + frameId +
				", childFrameId=" + childFrameId +
				", x=" + x +
				", y=" + y +
				", z=" + z +
				", q=" + Arrays.toString(q) +
				", vx=" + vx +
				", vy=" + vy +
				", vz=" + vz +
				", rollspeed=" + rollspeed +
				", pitchspeed=" + pitchspeed +
				", yawspeed=" + yawspeed +
				", poseCovariance=" + Arrays.toString(poseCovariance) +
				", velocityCovariance=" + Arrays.toString(velocityCovariance) +
				", resetCounter=" + resetCounter +
				", estimatorType=" + estimatorType +
				'}';
	}
}