package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavOdidClassEu;
import cn.wsyjlly.mavlink.common.v2.enums.MavOdidCategoryEu;
import cn.wsyjlly.mavlink.common.v2.enums.MavOdidOperatorLocationType;
import cn.wsyjlly.mavlink.common.v2.enums.MavOdidClassificationType;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.util.Arrays;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 12904,
		messagePayloadLength = 46,
		description = "Data for filling the OpenDroneID System message. The System Message contains general system information including the operator location and possible aircraft group information."
)
public class OpenDroneIdSystem implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID (0 for broadcast).")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID (0 for broadcast).")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 20, description = "Only used for drone ID data received from other UAs. See detailed description at https://mavlink.io/en/services/opendroneid.html.")
	private short[] idOrMac = new short[20];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "Specifies the operator location type.", enum0 = MavOdidOperatorLocationType.class)
	private short operatorLocationType;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1, description = "Specifies the classification type of the UA.", enum0 = MavOdidClassificationType.class)
	private short classificationType;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 6, typeSize = 4, streamLength = 4, description = "Latitude of the operator. If unknown: 0 (both Lat/Lon).", units = "degE7")
	private int operatorLatitude;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 7, typeSize = 4, streamLength = 4, description = "Longitude of the operator. If unknown: 0 (both Lat/Lon).", units = "degE7")
	private int operatorLongitude;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 8, typeSize = 2, streamLength = 2, description = "Number of aircraft in the area, group or formation (default 1).")
	private int areaCount;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 9, typeSize = 2, streamLength = 2, description = "Radius of the cylindrical area of the group or formation (default 0).", units = "m")
	private int areaRadius;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4, description = "Area Operations Ceiling relative to WGS84. If unknown: -1000 m.", units = "m")
	private float areaCeiling;

	@MavlinkMessageParam(mavlinkType = "float", position = 11, typeSize = 4, streamLength = 4, description = "Area Operations Floor relative to WGS84. If unknown: -1000 m.", units = "m")
	private float areaFloor;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 12, typeSize = 1, streamLength = 1, description = "When classification_type is MAV_ODID_CLASSIFICATION_TYPE_EU, specifies the category of the UA.", enum0 = MavOdidCategoryEu.class)
	private short categoryEu;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 13, typeSize = 1, streamLength = 1, description = "When classification_type is MAV_ODID_CLASSIFICATION_TYPE_EU, specifies the class of the UA.", enum0 = MavOdidClassEu.class)
	private short classEu;

	private final int messagePayloadLength = 46;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public OpenDroneIdSystem(short targetSystem, short targetComponent, short[] idOrMac, short operatorLocationType, short classificationType, int operatorLatitude, int operatorLongitude, int areaCount, int areaRadius, float areaCeiling, float areaFloor, short categoryEu, short classEu) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.idOrMac = idOrMac;
		this.operatorLocationType = operatorLocationType;
		this.classificationType = classificationType;
		this.operatorLatitude = operatorLatitude;
		this.operatorLongitude = operatorLongitude;
		this.areaCount = areaCount;
		this.areaRadius = areaRadius;
		this.areaCeiling = areaCeiling;
		this.areaFloor = areaFloor;
		this.categoryEu = categoryEu;
		this.classEu = classEu;
	}

	public OpenDroneIdSystem(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 46！");
		}
		messagePayload(messagePayload);
	}

	public OpenDroneIdSystem(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		idOrMac = byteArray.getUnsignedInt8Array(2,20);
		operatorLocationType = byteArray.getUnsignedInt8(22);
		classificationType = byteArray.getUnsignedInt8(23);
		operatorLatitude = byteArray.getInt32(24);
		operatorLongitude = byteArray.getInt32(28);
		areaCount = byteArray.getUnsignedInt16(32);
		areaRadius = byteArray.getUnsignedInt16(34);
		areaCeiling = byteArray.getFloat(36);
		areaFloor = byteArray.getFloat(40);
		categoryEu = byteArray.getUnsignedInt8(44);
		classEu = byteArray.getUnsignedInt8(45);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putUnsignedInt8Array(idOrMac,2);
		byteArray.putUnsignedInt8(operatorLocationType,22);
		byteArray.putUnsignedInt8(classificationType,23);
		byteArray.putInt32(operatorLatitude,24);
		byteArray.putInt32(operatorLongitude,28);
		byteArray.putUnsignedInt16(areaCount,32);
		byteArray.putUnsignedInt16(areaRadius,34);
		byteArray.putFloat(areaCeiling,36);
		byteArray.putFloat(areaFloor,40);
		byteArray.putUnsignedInt8(categoryEu,44);
		byteArray.putUnsignedInt8(classEu,45);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final OpenDroneIdSystem setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final OpenDroneIdSystem setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final OpenDroneIdSystem setIdOrMac(short[] idOrMac) {
		this.idOrMac = idOrMac;
		return this;
	}

	public final short[] getIdOrMac() {
		return idOrMac;
	}

	public final OpenDroneIdSystem setOperatorLocationType(short operatorLocationType) {
		this.operatorLocationType = operatorLocationType;
		return this;
	}

	public final short getOperatorLocationType() {
		return operatorLocationType;
	}

	public final OpenDroneIdSystem setClassificationType(short classificationType) {
		this.classificationType = classificationType;
		return this;
	}

	public final short getClassificationType() {
		return classificationType;
	}

	public final OpenDroneIdSystem setOperatorLatitude(int operatorLatitude) {
		this.operatorLatitude = operatorLatitude;
		return this;
	}

	public final int getOperatorLatitude() {
		return operatorLatitude;
	}

	public final OpenDroneIdSystem setOperatorLongitude(int operatorLongitude) {
		this.operatorLongitude = operatorLongitude;
		return this;
	}

	public final int getOperatorLongitude() {
		return operatorLongitude;
	}

	public final OpenDroneIdSystem setAreaCount(int areaCount) {
		this.areaCount = areaCount;
		return this;
	}

	public final int getAreaCount() {
		return areaCount;
	}

	public final OpenDroneIdSystem setAreaRadius(int areaRadius) {
		this.areaRadius = areaRadius;
		return this;
	}

	public final int getAreaRadius() {
		return areaRadius;
	}

	public final OpenDroneIdSystem setAreaCeiling(float areaCeiling) {
		this.areaCeiling = areaCeiling;
		return this;
	}

	public final float getAreaCeiling() {
		return areaCeiling;
	}

	public final OpenDroneIdSystem setAreaFloor(float areaFloor) {
		this.areaFloor = areaFloor;
		return this;
	}

	public final float getAreaFloor() {
		return areaFloor;
	}

	public final OpenDroneIdSystem setCategoryEu(short categoryEu) {
		this.categoryEu = categoryEu;
		return this;
	}

	public final short getCategoryEu() {
		return categoryEu;
	}

	public final OpenDroneIdSystem setClassEu(short classEu) {
		this.classEu = classEu;
		return this;
	}

	public final short getClassEu() {
		return classEu;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			OpenDroneIdSystem other = (OpenDroneIdSystem)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.idOrMac, other.idOrMac)) {
				return false;
			} else if (!Objects.deepEquals(this.operatorLocationType, other.operatorLocationType)) {
				return false;
			} else if (!Objects.deepEquals(this.classificationType, other.classificationType)) {
				return false;
			} else if (!Objects.deepEquals(this.operatorLatitude, other.operatorLatitude)) {
				return false;
			} else if (!Objects.deepEquals(this.operatorLongitude, other.operatorLongitude)) {
				return false;
			} else if (!Objects.deepEquals(this.areaCount, other.areaCount)) {
				return false;
			} else if (!Objects.deepEquals(this.areaRadius, other.areaRadius)) {
				return false;
			} else if (!Objects.deepEquals(this.areaCeiling, other.areaCeiling)) {
				return false;
			} else if (!Objects.deepEquals(this.areaFloor, other.areaFloor)) {
				return false;
			} else if (!Objects.deepEquals(this.categoryEu, other.categoryEu)) {
				return false;
			} else {
				return Objects.deepEquals(this.classEu, other.classEu);
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
		result = 31 * result + Objects.hashCode(this.idOrMac);
		result = 31 * result + Objects.hashCode(this.operatorLocationType);
		result = 31 * result + Objects.hashCode(this.classificationType);
		result = 31 * result + Objects.hashCode(this.operatorLatitude);
		result = 31 * result + Objects.hashCode(this.operatorLongitude);
		result = 31 * result + Objects.hashCode(this.areaCount);
		result = 31 * result + Objects.hashCode(this.areaRadius);
		result = 31 * result + Objects.hashCode(this.areaCeiling);
		result = 31 * result + Objects.hashCode(this.areaFloor);
		result = 31 * result + Objects.hashCode(this.categoryEu);
		result = 31 * result + Objects.hashCode(this.classEu);
		return result;
	}

	@Override
	public String toString() {
		return "OpenDroneIdSystem{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", idOrMac=" + Arrays.toString(idOrMac) +
				", operatorLocationType=" + operatorLocationType +
				", classificationType=" + classificationType +
				", operatorLatitude=" + operatorLatitude +
				", operatorLongitude=" + operatorLongitude +
				", areaCount=" + areaCount +
				", areaRadius=" + areaRadius +
				", areaCeiling=" + areaCeiling +
				", areaFloor=" + areaFloor +
				", categoryEu=" + categoryEu +
				", classEu=" + classEu +
				'}';
	}
}