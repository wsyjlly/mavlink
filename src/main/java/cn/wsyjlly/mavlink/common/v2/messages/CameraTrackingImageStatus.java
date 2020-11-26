package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.CameraTrackingMode;
import cn.wsyjlly.mavlink.common.v2.enums.CameraTrackingStatusFlags;
import cn.wsyjlly.mavlink.common.v2.enums.CameraTrackingTargetData;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 275,
		messagePayloadLength = 31,
		description = "Camera tracking status, sent while in active tracking. Use MAV_CMD_SET_MESSAGE_INTERVAL to define message interval."
)
public class CameraTrackingImageStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "Current tracking status", enum0 = CameraTrackingStatusFlags.class)
	private short trackingStatus;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Current tracking mode", enum0 = CameraTrackingMode.class)
	private short trackingMode;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Defines location of target data", enum0 = CameraTrackingTargetData.class)
	private short targetData;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "Current tracked point x value if CAMERA_TRACKING_POINT (normalized 0..1, 0 is left, 1 is right), NAN if unknown")
	private float pointX;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Current tracked point y value if CAMERA_TRACKING_POINT (normalized 0..1, 0 is top, 1 is bottom), NAN if unknown")
	private float pointY;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Current tracked radius if CAMERA_TRACKING_POINT (normalized 0..1, 0 is image left, 1 is image right), NAN if unknown")
	private float radius;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "Current tracked rectangle top x value if CAMERA_TRACKING_RECTANGLE (normalized 0..1, 0 is left, 1 is right), NAN if unknown")
	private float recTopX;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "Current tracked rectangle top y value if CAMERA_TRACKING_RECTANGLE (normalized 0..1, 0 is top, 1 is bottom), NAN if unknown")
	private float recTopY;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4, description = "Current tracked rectangle bottom x value if CAMERA_TRACKING_RECTANGLE (normalized 0..1, 0 is left, 1 is right), NAN if unknown")
	private float recBottomX;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4, description = "Current tracked rectangle bottom y value if CAMERA_TRACKING_RECTANGLE (normalized 0..1, 0 is top, 1 is bottom), NAN if unknown")
	private float recBottomY;

	private final int messagePayloadLength = 31;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public CameraTrackingImageStatus(short trackingStatus, short trackingMode, short targetData, float pointX, float pointY, float radius, float recTopX, float recTopY, float recBottomX, float recBottomY) {
		this.trackingStatus = trackingStatus;
		this.trackingMode = trackingMode;
		this.targetData = targetData;
		this.pointX = pointX;
		this.pointY = pointY;
		this.radius = radius;
		this.recTopX = recTopX;
		this.recTopY = recTopY;
		this.recBottomX = recBottomX;
		this.recBottomY = recBottomY;
	}

	public CameraTrackingImageStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 31！");
		}
		messagePayload(messagePayload);
	}

	public CameraTrackingImageStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		trackingStatus = byteArray.getUnsignedInt8(0);
		trackingMode = byteArray.getUnsignedInt8(1);
		targetData = byteArray.getUnsignedInt8(2);
		pointX = byteArray.getFloat(3);
		pointY = byteArray.getFloat(7);
		radius = byteArray.getFloat(11);
		recTopX = byteArray.getFloat(15);
		recTopY = byteArray.getFloat(19);
		recBottomX = byteArray.getFloat(23);
		recBottomY = byteArray.getFloat(27);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(trackingStatus,0);
		byteArray.putUnsignedInt8(trackingMode,1);
		byteArray.putUnsignedInt8(targetData,2);
		byteArray.putFloat(pointX,3);
		byteArray.putFloat(pointY,7);
		byteArray.putFloat(radius,11);
		byteArray.putFloat(recTopX,15);
		byteArray.putFloat(recTopY,19);
		byteArray.putFloat(recBottomX,23);
		byteArray.putFloat(recBottomY,27);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final CameraTrackingImageStatus setTrackingStatus(short trackingStatus) {
		this.trackingStatus = trackingStatus;
		return this;
	}

	public final short getTrackingStatus() {
		return trackingStatus;
	}

	public final CameraTrackingImageStatus setTrackingMode(short trackingMode) {
		this.trackingMode = trackingMode;
		return this;
	}

	public final short getTrackingMode() {
		return trackingMode;
	}

	public final CameraTrackingImageStatus setTargetData(short targetData) {
		this.targetData = targetData;
		return this;
	}

	public final short getTargetData() {
		return targetData;
	}

	public final CameraTrackingImageStatus setPointX(float pointX) {
		this.pointX = pointX;
		return this;
	}

	public final float getPointX() {
		return pointX;
	}

	public final CameraTrackingImageStatus setPointY(float pointY) {
		this.pointY = pointY;
		return this;
	}

	public final float getPointY() {
		return pointY;
	}

	public final CameraTrackingImageStatus setRadius(float radius) {
		this.radius = radius;
		return this;
	}

	public final float getRadius() {
		return radius;
	}

	public final CameraTrackingImageStatus setRecTopX(float recTopX) {
		this.recTopX = recTopX;
		return this;
	}

	public final float getRecTopX() {
		return recTopX;
	}

	public final CameraTrackingImageStatus setRecTopY(float recTopY) {
		this.recTopY = recTopY;
		return this;
	}

	public final float getRecTopY() {
		return recTopY;
	}

	public final CameraTrackingImageStatus setRecBottomX(float recBottomX) {
		this.recBottomX = recBottomX;
		return this;
	}

	public final float getRecBottomX() {
		return recBottomX;
	}

	public final CameraTrackingImageStatus setRecBottomY(float recBottomY) {
		this.recBottomY = recBottomY;
		return this;
	}

	public final float getRecBottomY() {
		return recBottomY;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			CameraTrackingImageStatus other = (CameraTrackingImageStatus)o;
			if (!Objects.deepEquals(this.trackingStatus, other.trackingStatus)) {
				return false;
			} else if (!Objects.deepEquals(this.trackingMode, other.trackingMode)) {
				return false;
			} else if (!Objects.deepEquals(this.targetData, other.targetData)) {
				return false;
			} else if (!Objects.deepEquals(this.pointX, other.pointX)) {
				return false;
			} else if (!Objects.deepEquals(this.pointY, other.pointY)) {
				return false;
			} else if (!Objects.deepEquals(this.radius, other.radius)) {
				return false;
			} else if (!Objects.deepEquals(this.recTopX, other.recTopX)) {
				return false;
			} else if (!Objects.deepEquals(this.recTopY, other.recTopY)) {
				return false;
			} else if (!Objects.deepEquals(this.recBottomX, other.recBottomX)) {
				return false;
			} else {
				return Objects.deepEquals(this.recBottomY, other.recBottomY);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.trackingStatus);
		result = 31 * result + Objects.hashCode(this.trackingMode);
		result = 31 * result + Objects.hashCode(this.targetData);
		result = 31 * result + Objects.hashCode(this.pointX);
		result = 31 * result + Objects.hashCode(this.pointY);
		result = 31 * result + Objects.hashCode(this.radius);
		result = 31 * result + Objects.hashCode(this.recTopX);
		result = 31 * result + Objects.hashCode(this.recTopY);
		result = 31 * result + Objects.hashCode(this.recBottomX);
		result = 31 * result + Objects.hashCode(this.recBottomY);
		return result;
	}

	@Override
	public String toString() {
		return "CameraTrackingImageStatus{" +
				"trackingStatus=" + trackingStatus +
				", trackingMode=" + trackingMode +
				", targetData=" + targetData +
				", pointX=" + pointX +
				", pointY=" + pointY +
				", radius=" + radius +
				", recTopX=" + recTopX +
				", recTopY=" + recTopY +
				", recBottomX=" + recBottomX +
				", recBottomY=" + recBottomY +
				'}';
	}
}