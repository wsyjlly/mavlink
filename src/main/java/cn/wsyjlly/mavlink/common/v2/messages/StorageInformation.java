package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.StorageStatus;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 261,
		messagePayloadLength = 27,
		description = "Information about a storage medium. This message is sent in response to a request with MAV_CMD_REQUEST_MESSAGE and whenever the status of the storage changes (STORAGE_STATUS). Use MAV_CMD_REQUEST_MESSAGE.param2 to indicate the index/id of requested storage: 0 for all, 1 for first, 2 for second, etc."
)
public class StorageInformation implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp (time since system boot).", units = "ms")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Storage ID (1 for first, 2 for second, etc.)")
	private short storageId;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Number of storage devices")
	private short storageCount;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "Status of storage", enum0 = StorageStatus.class)
	private short status;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Total capacity. If storage is not ready (STORAGE_STATUS_READY) value will be ignored.", units = "MiB")
	private float totalCapacity;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Used capacity. If storage is not ready (STORAGE_STATUS_READY) value will be ignored.", units = "MiB")
	private float usedCapacity;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "Available storage capacity. If storage is not ready (STORAGE_STATUS_READY) value will be ignored.", units = "MiB")
	private float availableCapacity;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "Read speed.", units = "MiB/s")
	private float readSpeed;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4, description = "Write speed.", units = "MiB/s")
	private float writeSpeed;

	private final int messagePayloadLength = 27;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public StorageInformation(long timeBootMs, short storageId, short storageCount, short status, float totalCapacity, float usedCapacity, float availableCapacity, float readSpeed, float writeSpeed) {
		this.timeBootMs = timeBootMs;
		this.storageId = storageId;
		this.storageCount = storageCount;
		this.status = status;
		this.totalCapacity = totalCapacity;
		this.usedCapacity = usedCapacity;
		this.availableCapacity = availableCapacity;
		this.readSpeed = readSpeed;
		this.writeSpeed = writeSpeed;
	}

	public StorageInformation(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 27！");
		}
		messagePayload(messagePayload);
	}

	public StorageInformation(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeBootMs = byteArray.getUnsignedInt32(0);
		storageId = byteArray.getUnsignedInt8(4);
		storageCount = byteArray.getUnsignedInt8(5);
		status = byteArray.getUnsignedInt8(6);
		totalCapacity = byteArray.getFloat(7);
		usedCapacity = byteArray.getFloat(11);
		availableCapacity = byteArray.getFloat(15);
		readSpeed = byteArray.getFloat(19);
		writeSpeed = byteArray.getFloat(23);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeBootMs,0);
		byteArray.putUnsignedInt8(storageId,4);
		byteArray.putUnsignedInt8(storageCount,5);
		byteArray.putUnsignedInt8(status,6);
		byteArray.putFloat(totalCapacity,7);
		byteArray.putFloat(usedCapacity,11);
		byteArray.putFloat(availableCapacity,15);
		byteArray.putFloat(readSpeed,19);
		byteArray.putFloat(writeSpeed,23);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final StorageInformation setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final StorageInformation setStorageId(short storageId) {
		this.storageId = storageId;
		return this;
	}

	public final short getStorageId() {
		return storageId;
	}

	public final StorageInformation setStorageCount(short storageCount) {
		this.storageCount = storageCount;
		return this;
	}

	public final short getStorageCount() {
		return storageCount;
	}

	public final StorageInformation setStatus(short status) {
		this.status = status;
		return this;
	}

	public final short getStatus() {
		return status;
	}

	public final StorageInformation setTotalCapacity(float totalCapacity) {
		this.totalCapacity = totalCapacity;
		return this;
	}

	public final float getTotalCapacity() {
		return totalCapacity;
	}

	public final StorageInformation setUsedCapacity(float usedCapacity) {
		this.usedCapacity = usedCapacity;
		return this;
	}

	public final float getUsedCapacity() {
		return usedCapacity;
	}

	public final StorageInformation setAvailableCapacity(float availableCapacity) {
		this.availableCapacity = availableCapacity;
		return this;
	}

	public final float getAvailableCapacity() {
		return availableCapacity;
	}

	public final StorageInformation setReadSpeed(float readSpeed) {
		this.readSpeed = readSpeed;
		return this;
	}

	public final float getReadSpeed() {
		return readSpeed;
	}

	public final StorageInformation setWriteSpeed(float writeSpeed) {
		this.writeSpeed = writeSpeed;
		return this;
	}

	public final float getWriteSpeed() {
		return writeSpeed;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			StorageInformation other = (StorageInformation)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.storageId, other.storageId)) {
				return false;
			} else if (!Objects.deepEquals(this.storageCount, other.storageCount)) {
				return false;
			} else if (!Objects.deepEquals(this.status, other.status)) {
				return false;
			} else if (!Objects.deepEquals(this.totalCapacity, other.totalCapacity)) {
				return false;
			} else if (!Objects.deepEquals(this.usedCapacity, other.usedCapacity)) {
				return false;
			} else if (!Objects.deepEquals(this.availableCapacity, other.availableCapacity)) {
				return false;
			} else if (!Objects.deepEquals(this.readSpeed, other.readSpeed)) {
				return false;
			} else {
				return Objects.deepEquals(this.writeSpeed, other.writeSpeed);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeBootMs);
		result = 31 * result + Objects.hashCode(this.storageId);
		result = 31 * result + Objects.hashCode(this.storageCount);
		result = 31 * result + Objects.hashCode(this.status);
		result = 31 * result + Objects.hashCode(this.totalCapacity);
		result = 31 * result + Objects.hashCode(this.usedCapacity);
		result = 31 * result + Objects.hashCode(this.availableCapacity);
		result = 31 * result + Objects.hashCode(this.readSpeed);
		result = 31 * result + Objects.hashCode(this.writeSpeed);
		return result;
	}

	@Override
	public String toString() {
		return "StorageInformation{" +
				"timeBootMs=" + timeBootMs +
				", storageId=" + storageId +
				", storageCount=" + storageCount +
				", status=" + status +
				", totalCapacity=" + totalCapacity +
				", usedCapacity=" + usedCapacity +
				", availableCapacity=" + availableCapacity +
				", readSpeed=" + readSpeed +
				", writeSpeed=" + writeSpeed +
				'}';
	}
}