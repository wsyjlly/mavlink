package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavCmd;
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
		id = 332,
		messagePayloadLength = 239,
		description = "Describe a trajectory using an array of up-to 5 waypoints in the local frame (MAV_FRAME_LOCAL_NED)."
)
public class TrajectoryRepresentationWaypoints implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Number of valid points (up-to 5 waypoints are possible)")
	private short validPoints;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 20, description = "X-coordinate of waypoint, set to NaN if not being used", units = "m")
	private float[] posX = new float[5];

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 20, description = "Y-coordinate of waypoint, set to NaN if not being used", units = "m")
	private float[] posY = new float[5];

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 20, description = "Z-coordinate of waypoint, set to NaN if not being used", units = "m")
	private float[] posZ = new float[5];

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 20, description = "X-velocity of waypoint, set to NaN if not being used", units = "m/s")
	private float[] velX = new float[5];

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 20, description = "Y-velocity of waypoint, set to NaN if not being used", units = "m/s")
	private float[] velY = new float[5];

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 20, description = "Z-velocity of waypoint, set to NaN if not being used", units = "m/s")
	private float[] velZ = new float[5];

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 20, description = "X-acceleration of waypoint, set to NaN if not being used", units = "m/s/s")
	private float[] accX = new float[5];

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 20, description = "Y-acceleration of waypoint, set to NaN if not being used", units = "m/s/s")
	private float[] accY = new float[5];

	@MavlinkMessageParam(mavlinkType = "float", position = 11, typeSize = 4, streamLength = 20, description = "Z-acceleration of waypoint, set to NaN if not being used", units = "m/s/s")
	private float[] accZ = new float[5];

	@MavlinkMessageParam(mavlinkType = "float", position = 12, typeSize = 4, streamLength = 20, description = "Yaw angle, set to NaN if not being used", units = "rad")
	private float[] posYaw = new float[5];

	@MavlinkMessageParam(mavlinkType = "float", position = 13, typeSize = 4, streamLength = 20, description = "Yaw rate, set to NaN if not being used", units = "rad/s")
	private float[] velYaw = new float[5];

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 14, typeSize = 2, streamLength = 10, description = "Scheduled action for each waypoint, UINT16_MAX if not being used.", enum0 = MavCmd.class)
	private int[] command = new int[5];

	private final int messagePayloadLength = 239;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public TrajectoryRepresentationWaypoints(BigInteger timeUsec, short validPoints, float[] posX, float[] posY, float[] posZ, float[] velX, float[] velY, float[] velZ, float[] accX, float[] accY, float[] accZ, float[] posYaw, float[] velYaw, int[] command) {
		this.timeUsec = timeUsec;
		this.validPoints = validPoints;
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		this.velX = velX;
		this.velY = velY;
		this.velZ = velZ;
		this.accX = accX;
		this.accY = accY;
		this.accZ = accZ;
		this.posYaw = posYaw;
		this.velYaw = velYaw;
		this.command = command;
	}

	public TrajectoryRepresentationWaypoints(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 239！");
		}
		messagePayload(messagePayload);
	}

	public TrajectoryRepresentationWaypoints(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		validPoints = byteArray.getUnsignedInt8(8);
		posX = byteArray.getFloatArray(9,5);
		posY = byteArray.getFloatArray(29,5);
		posZ = byteArray.getFloatArray(49,5);
		velX = byteArray.getFloatArray(69,5);
		velY = byteArray.getFloatArray(89,5);
		velZ = byteArray.getFloatArray(109,5);
		accX = byteArray.getFloatArray(129,5);
		accY = byteArray.getFloatArray(149,5);
		accZ = byteArray.getFloatArray(169,5);
		posYaw = byteArray.getFloatArray(189,5);
		velYaw = byteArray.getFloatArray(209,5);
		command = byteArray.getUnsignedInt16Array(229,5);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putUnsignedInt8(validPoints,8);
		byteArray.putFloatArray(posX,9);
		byteArray.putFloatArray(posY,29);
		byteArray.putFloatArray(posZ,49);
		byteArray.putFloatArray(velX,69);
		byteArray.putFloatArray(velY,89);
		byteArray.putFloatArray(velZ,109);
		byteArray.putFloatArray(accX,129);
		byteArray.putFloatArray(accY,149);
		byteArray.putFloatArray(accZ,169);
		byteArray.putFloatArray(posYaw,189);
		byteArray.putFloatArray(velYaw,209);
		byteArray.putUnsignedInt16Array(command,229);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final TrajectoryRepresentationWaypoints setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final TrajectoryRepresentationWaypoints setValidPoints(short validPoints) {
		this.validPoints = validPoints;
		return this;
	}

	public final short getValidPoints() {
		return validPoints;
	}

	public final TrajectoryRepresentationWaypoints setPosX(float[] posX) {
		this.posX = posX;
		return this;
	}

	public final float[] getPosX() {
		return posX;
	}

	public final TrajectoryRepresentationWaypoints setPosY(float[] posY) {
		this.posY = posY;
		return this;
	}

	public final float[] getPosY() {
		return posY;
	}

	public final TrajectoryRepresentationWaypoints setPosZ(float[] posZ) {
		this.posZ = posZ;
		return this;
	}

	public final float[] getPosZ() {
		return posZ;
	}

	public final TrajectoryRepresentationWaypoints setVelX(float[] velX) {
		this.velX = velX;
		return this;
	}

	public final float[] getVelX() {
		return velX;
	}

	public final TrajectoryRepresentationWaypoints setVelY(float[] velY) {
		this.velY = velY;
		return this;
	}

	public final float[] getVelY() {
		return velY;
	}

	public final TrajectoryRepresentationWaypoints setVelZ(float[] velZ) {
		this.velZ = velZ;
		return this;
	}

	public final float[] getVelZ() {
		return velZ;
	}

	public final TrajectoryRepresentationWaypoints setAccX(float[] accX) {
		this.accX = accX;
		return this;
	}

	public final float[] getAccX() {
		return accX;
	}

	public final TrajectoryRepresentationWaypoints setAccY(float[] accY) {
		this.accY = accY;
		return this;
	}

	public final float[] getAccY() {
		return accY;
	}

	public final TrajectoryRepresentationWaypoints setAccZ(float[] accZ) {
		this.accZ = accZ;
		return this;
	}

	public final float[] getAccZ() {
		return accZ;
	}

	public final TrajectoryRepresentationWaypoints setPosYaw(float[] posYaw) {
		this.posYaw = posYaw;
		return this;
	}

	public final float[] getPosYaw() {
		return posYaw;
	}

	public final TrajectoryRepresentationWaypoints setVelYaw(float[] velYaw) {
		this.velYaw = velYaw;
		return this;
	}

	public final float[] getVelYaw() {
		return velYaw;
	}

	public final TrajectoryRepresentationWaypoints setCommand(int[] command) {
		this.command = command;
		return this;
	}

	public final int[] getCommand() {
		return command;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			TrajectoryRepresentationWaypoints other = (TrajectoryRepresentationWaypoints)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.validPoints, other.validPoints)) {
				return false;
			} else if (!Objects.deepEquals(this.posX, other.posX)) {
				return false;
			} else if (!Objects.deepEquals(this.posY, other.posY)) {
				return false;
			} else if (!Objects.deepEquals(this.posZ, other.posZ)) {
				return false;
			} else if (!Objects.deepEquals(this.velX, other.velX)) {
				return false;
			} else if (!Objects.deepEquals(this.velY, other.velY)) {
				return false;
			} else if (!Objects.deepEquals(this.velZ, other.velZ)) {
				return false;
			} else if (!Objects.deepEquals(this.accX, other.accX)) {
				return false;
			} else if (!Objects.deepEquals(this.accY, other.accY)) {
				return false;
			} else if (!Objects.deepEquals(this.accZ, other.accZ)) {
				return false;
			} else if (!Objects.deepEquals(this.posYaw, other.posYaw)) {
				return false;
			} else if (!Objects.deepEquals(this.velYaw, other.velYaw)) {
				return false;
			} else {
				return Objects.deepEquals(this.command, other.command);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.validPoints);
		result = 31 * result + Objects.hashCode(this.posX);
		result = 31 * result + Objects.hashCode(this.posY);
		result = 31 * result + Objects.hashCode(this.posZ);
		result = 31 * result + Objects.hashCode(this.velX);
		result = 31 * result + Objects.hashCode(this.velY);
		result = 31 * result + Objects.hashCode(this.velZ);
		result = 31 * result + Objects.hashCode(this.accX);
		result = 31 * result + Objects.hashCode(this.accY);
		result = 31 * result + Objects.hashCode(this.accZ);
		result = 31 * result + Objects.hashCode(this.posYaw);
		result = 31 * result + Objects.hashCode(this.velYaw);
		result = 31 * result + Objects.hashCode(this.command);
		return result;
	}

	@Override
	public String toString() {
		return "TrajectoryRepresentationWaypoints{" +
				"timeUsec=" + timeUsec +
				", validPoints=" + validPoints +
				", posX=" + Arrays.toString(posX) +
				", posY=" + Arrays.toString(posY) +
				", posZ=" + Arrays.toString(posZ) +
				", velX=" + Arrays.toString(velX) +
				", velY=" + Arrays.toString(velY) +
				", velZ=" + Arrays.toString(velZ) +
				", accX=" + Arrays.toString(accX) +
				", accY=" + Arrays.toString(accY) +
				", accZ=" + Arrays.toString(accZ) +
				", posYaw=" + Arrays.toString(posYaw) +
				", velYaw=" + Arrays.toString(velYaw) +
				", command=" + Arrays.toString(command) +
				'}';
	}
}