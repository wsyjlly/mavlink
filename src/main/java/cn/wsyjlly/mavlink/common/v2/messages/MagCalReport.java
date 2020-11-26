package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MagCalStatus;
import cn.wsyjlly.mavlink.common.v2.enums.MavSensorOrientation;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 192,
		messagePayloadLength = 54,
		description = "Reports results of completed compass calibration. Sent until MAG_CAL_ACK received."
)
public class MagCalReport implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "Compass being calibrated.")
	private short compassId;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Bitmask of compasses being calibrated.")
	private short calMask;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Calibration Status.", enum0 = MagCalStatus.class)
	private short calStatus;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "0=requires a MAV_CMD_DO_ACCEPT_MAG_CAL, 1=saved to parameters.")
	private short autosaved;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "RMS milligauss residuals.", units = "mgauss")
	private float fitness;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "X offset.")
	private float ofsX;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "Y offset.")
	private float ofsY;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "Z offset.")
	private float ofsZ;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4, description = "X diagonal (matrix 11).")
	private float diagX;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4, description = "Y diagonal (matrix 22).")
	private float diagY;

	@MavlinkMessageParam(mavlinkType = "float", position = 11, typeSize = 4, streamLength = 4, description = "Z diagonal (matrix 33).")
	private float diagZ;

	@MavlinkMessageParam(mavlinkType = "float", position = 12, typeSize = 4, streamLength = 4, description = "X off-diagonal (matrix 12 and 21).")
	private float offdiagX;

	@MavlinkMessageParam(mavlinkType = "float", position = 13, typeSize = 4, streamLength = 4, description = "Y off-diagonal (matrix 13 and 31).")
	private float offdiagY;

	@MavlinkMessageParam(mavlinkType = "float", position = 14, typeSize = 4, streamLength = 4, description = "Z off-diagonal (matrix 32 and 23).")
	private float offdiagZ;

	@MavlinkMessageParam(mavlinkType = "float", position = 15, typeSize = 4, streamLength = 4, description = "Confidence in orientation (higher is better).")
	private float orientationConfidence;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 16, typeSize = 1, streamLength = 1, description = "orientation before calibration.", enum0 = MavSensorOrientation.class)
	private short oldOrientation;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 17, typeSize = 1, streamLength = 1, description = "orientation after calibration.", enum0 = MavSensorOrientation.class)
	private short newOrientation;

	@MavlinkMessageParam(mavlinkType = "float", position = 18, typeSize = 4, streamLength = 4, description = "field radius correction factor")
	private float scaleFactor;

	private final int messagePayloadLength = 54;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public MagCalReport(short compassId, short calMask, short calStatus, short autosaved, float fitness, float ofsX, float ofsY, float ofsZ, float diagX, float diagY, float diagZ, float offdiagX, float offdiagY, float offdiagZ, float orientationConfidence, short oldOrientation, short newOrientation, float scaleFactor) {
		this.compassId = compassId;
		this.calMask = calMask;
		this.calStatus = calStatus;
		this.autosaved = autosaved;
		this.fitness = fitness;
		this.ofsX = ofsX;
		this.ofsY = ofsY;
		this.ofsZ = ofsZ;
		this.diagX = diagX;
		this.diagY = diagY;
		this.diagZ = diagZ;
		this.offdiagX = offdiagX;
		this.offdiagY = offdiagY;
		this.offdiagZ = offdiagZ;
		this.orientationConfidence = orientationConfidence;
		this.oldOrientation = oldOrientation;
		this.newOrientation = newOrientation;
		this.scaleFactor = scaleFactor;
	}

	public MagCalReport(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 54！");
		}
		messagePayload(messagePayload);
	}

	public MagCalReport(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		compassId = byteArray.getUnsignedInt8(0);
		calMask = byteArray.getUnsignedInt8(1);
		calStatus = byteArray.getUnsignedInt8(2);
		autosaved = byteArray.getUnsignedInt8(3);
		fitness = byteArray.getFloat(4);
		ofsX = byteArray.getFloat(8);
		ofsY = byteArray.getFloat(12);
		ofsZ = byteArray.getFloat(16);
		diagX = byteArray.getFloat(20);
		diagY = byteArray.getFloat(24);
		diagZ = byteArray.getFloat(28);
		offdiagX = byteArray.getFloat(32);
		offdiagY = byteArray.getFloat(36);
		offdiagZ = byteArray.getFloat(40);
		orientationConfidence = byteArray.getFloat(44);
		oldOrientation = byteArray.getUnsignedInt8(48);
		newOrientation = byteArray.getUnsignedInt8(49);
		scaleFactor = byteArray.getFloat(50);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(compassId,0);
		byteArray.putUnsignedInt8(calMask,1);
		byteArray.putUnsignedInt8(calStatus,2);
		byteArray.putUnsignedInt8(autosaved,3);
		byteArray.putFloat(fitness,4);
		byteArray.putFloat(ofsX,8);
		byteArray.putFloat(ofsY,12);
		byteArray.putFloat(ofsZ,16);
		byteArray.putFloat(diagX,20);
		byteArray.putFloat(diagY,24);
		byteArray.putFloat(diagZ,28);
		byteArray.putFloat(offdiagX,32);
		byteArray.putFloat(offdiagY,36);
		byteArray.putFloat(offdiagZ,40);
		byteArray.putFloat(orientationConfidence,44);
		byteArray.putUnsignedInt8(oldOrientation,48);
		byteArray.putUnsignedInt8(newOrientation,49);
		byteArray.putFloat(scaleFactor,50);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final MagCalReport setCompassId(short compassId) {
		this.compassId = compassId;
		return this;
	}

	public final short getCompassId() {
		return compassId;
	}

	public final MagCalReport setCalMask(short calMask) {
		this.calMask = calMask;
		return this;
	}

	public final short getCalMask() {
		return calMask;
	}

	public final MagCalReport setCalStatus(short calStatus) {
		this.calStatus = calStatus;
		return this;
	}

	public final short getCalStatus() {
		return calStatus;
	}

	public final MagCalReport setAutosaved(short autosaved) {
		this.autosaved = autosaved;
		return this;
	}

	public final short getAutosaved() {
		return autosaved;
	}

	public final MagCalReport setFitness(float fitness) {
		this.fitness = fitness;
		return this;
	}

	public final float getFitness() {
		return fitness;
	}

	public final MagCalReport setOfsX(float ofsX) {
		this.ofsX = ofsX;
		return this;
	}

	public final float getOfsX() {
		return ofsX;
	}

	public final MagCalReport setOfsY(float ofsY) {
		this.ofsY = ofsY;
		return this;
	}

	public final float getOfsY() {
		return ofsY;
	}

	public final MagCalReport setOfsZ(float ofsZ) {
		this.ofsZ = ofsZ;
		return this;
	}

	public final float getOfsZ() {
		return ofsZ;
	}

	public final MagCalReport setDiagX(float diagX) {
		this.diagX = diagX;
		return this;
	}

	public final float getDiagX() {
		return diagX;
	}

	public final MagCalReport setDiagY(float diagY) {
		this.diagY = diagY;
		return this;
	}

	public final float getDiagY() {
		return diagY;
	}

	public final MagCalReport setDiagZ(float diagZ) {
		this.diagZ = diagZ;
		return this;
	}

	public final float getDiagZ() {
		return diagZ;
	}

	public final MagCalReport setOffdiagX(float offdiagX) {
		this.offdiagX = offdiagX;
		return this;
	}

	public final float getOffdiagX() {
		return offdiagX;
	}

	public final MagCalReport setOffdiagY(float offdiagY) {
		this.offdiagY = offdiagY;
		return this;
	}

	public final float getOffdiagY() {
		return offdiagY;
	}

	public final MagCalReport setOffdiagZ(float offdiagZ) {
		this.offdiagZ = offdiagZ;
		return this;
	}

	public final float getOffdiagZ() {
		return offdiagZ;
	}

	public final MagCalReport setOrientationConfidence(float orientationConfidence) {
		this.orientationConfidence = orientationConfidence;
		return this;
	}

	public final float getOrientationConfidence() {
		return orientationConfidence;
	}

	public final MagCalReport setOldOrientation(short oldOrientation) {
		this.oldOrientation = oldOrientation;
		return this;
	}

	public final short getOldOrientation() {
		return oldOrientation;
	}

	public final MagCalReport setNewOrientation(short newOrientation) {
		this.newOrientation = newOrientation;
		return this;
	}

	public final short getNewOrientation() {
		return newOrientation;
	}

	public final MagCalReport setScaleFactor(float scaleFactor) {
		this.scaleFactor = scaleFactor;
		return this;
	}

	public final float getScaleFactor() {
		return scaleFactor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			MagCalReport other = (MagCalReport)o;
			if (!Objects.deepEquals(this.compassId, other.compassId)) {
				return false;
			} else if (!Objects.deepEquals(this.calMask, other.calMask)) {
				return false;
			} else if (!Objects.deepEquals(this.calStatus, other.calStatus)) {
				return false;
			} else if (!Objects.deepEquals(this.autosaved, other.autosaved)) {
				return false;
			} else if (!Objects.deepEquals(this.fitness, other.fitness)) {
				return false;
			} else if (!Objects.deepEquals(this.ofsX, other.ofsX)) {
				return false;
			} else if (!Objects.deepEquals(this.ofsY, other.ofsY)) {
				return false;
			} else if (!Objects.deepEquals(this.ofsZ, other.ofsZ)) {
				return false;
			} else if (!Objects.deepEquals(this.diagX, other.diagX)) {
				return false;
			} else if (!Objects.deepEquals(this.diagY, other.diagY)) {
				return false;
			} else if (!Objects.deepEquals(this.diagZ, other.diagZ)) {
				return false;
			} else if (!Objects.deepEquals(this.offdiagX, other.offdiagX)) {
				return false;
			} else if (!Objects.deepEquals(this.offdiagY, other.offdiagY)) {
				return false;
			} else if (!Objects.deepEquals(this.offdiagZ, other.offdiagZ)) {
				return false;
			} else if (!Objects.deepEquals(this.orientationConfidence, other.orientationConfidence)) {
				return false;
			} else if (!Objects.deepEquals(this.oldOrientation, other.oldOrientation)) {
				return false;
			} else if (!Objects.deepEquals(this.newOrientation, other.newOrientation)) {
				return false;
			} else {
				return Objects.deepEquals(this.scaleFactor, other.scaleFactor);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.compassId);
		result = 31 * result + Objects.hashCode(this.calMask);
		result = 31 * result + Objects.hashCode(this.calStatus);
		result = 31 * result + Objects.hashCode(this.autosaved);
		result = 31 * result + Objects.hashCode(this.fitness);
		result = 31 * result + Objects.hashCode(this.ofsX);
		result = 31 * result + Objects.hashCode(this.ofsY);
		result = 31 * result + Objects.hashCode(this.ofsZ);
		result = 31 * result + Objects.hashCode(this.diagX);
		result = 31 * result + Objects.hashCode(this.diagY);
		result = 31 * result + Objects.hashCode(this.diagZ);
		result = 31 * result + Objects.hashCode(this.offdiagX);
		result = 31 * result + Objects.hashCode(this.offdiagY);
		result = 31 * result + Objects.hashCode(this.offdiagZ);
		result = 31 * result + Objects.hashCode(this.orientationConfidence);
		result = 31 * result + Objects.hashCode(this.oldOrientation);
		result = 31 * result + Objects.hashCode(this.newOrientation);
		result = 31 * result + Objects.hashCode(this.scaleFactor);
		return result;
	}

	@Override
	public String toString() {
		return "MagCalReport{" +
				"compassId=" + compassId +
				", calMask=" + calMask +
				", calStatus=" + calStatus +
				", autosaved=" + autosaved +
				", fitness=" + fitness +
				", ofsX=" + ofsX +
				", ofsY=" + ofsY +
				", ofsZ=" + ofsZ +
				", diagX=" + diagX +
				", diagY=" + diagY +
				", diagZ=" + diagZ +
				", offdiagX=" + offdiagX +
				", offdiagY=" + offdiagY +
				", offdiagZ=" + offdiagZ +
				", orientationConfidence=" + orientationConfidence +
				", oldOrientation=" + oldOrientation +
				", newOrientation=" + newOrientation +
				", scaleFactor=" + scaleFactor +
				'}';
	}
}