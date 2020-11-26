package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
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
		id = 390,
		messagePayloadLength = 238,
		description = "Hardware status sent by an onboard computer."
)
public class OnboardComputerStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 2, typeSize = 4, streamLength = 4, description = "Time since system boot.", units = "ms")
	private long uptime;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Type of the onboard computer: 0: Mission computer primary, 1: Mission computer backup 1, 2: Mission computer backup 2, 3: Compute node, 4-5: Compute spares, 6-9: Payload computers.")
	private short type;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 8, description = "CPU usage on the component in percent (100 - idle). A value of UINT8_MAX implies the field is unused.")
	private short[] cpuCores = new short[8];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 10, description = "Combined CPU usage as the last 10 slices of 100 MS (a histogram). This allows to identify spikes in load that max out the system, but only for a short amount of time. A value of UINT8_MAX implies the field is unused.")
	private short[] cpuCombined = new short[10];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 4, description = "GPU usage on the component in percent (100 - idle). A value of UINT8_MAX implies the field is unused.")
	private short[] gpuCores = new short[4];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 7, typeSize = 1, streamLength = 10, description = "Combined GPU usage as the last 10 slices of 100 MS (a histogram). This allows to identify spikes in load that max out the system, but only for a short amount of time. A value of UINT8_MAX implies the field is unused.")
	private short[] gpuCombined = new short[10];

	@MavlinkMessageParam(mavlinkType = "int8_t", position = 8, typeSize = 1, streamLength = 1, description = "Temperature of the board. A value of INT8_MAX implies the field is unused.", units = "degC")
	private byte temperatureBoard;

	@MavlinkMessageParam(mavlinkType = "int8_t", position = 9, typeSize = 1, streamLength = 8, description = "Temperature of the CPU core. A value of INT8_MAX implies the field is unused.", units = "degC")
	private byte[] temperatureCore = new byte[8];

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 10, typeSize = 2, streamLength = 8, description = "Fan speeds. A value of INT16_MAX implies the field is unused.", units = "rpm")
	private short[] fanSpeed = new short[4];

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 11, typeSize = 4, streamLength = 4, description = "Amount of used RAM on the component system. A value of UINT32_MAX implies the field is unused.", units = "MiB")
	private long ramUsage;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 12, typeSize = 4, streamLength = 4, description = "Total amount of RAM on the component system. A value of UINT32_MAX implies the field is unused.", units = "MiB")
	private long ramTotal;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 13, typeSize = 4, streamLength = 16, description = "Storage type: 0: HDD, 1: SSD, 2: EMMC, 3: SD card (non-removable), 4: SD card (removable). A value of UINT32_MAX implies the field is unused.")
	private long[] storageType = new long[4];

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 14, typeSize = 4, streamLength = 16, description = "Amount of used storage space on the component system. A value of UINT32_MAX implies the field is unused.", units = "MiB")
	private long[] storageUsage = new long[4];

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 15, typeSize = 4, streamLength = 16, description = "Total amount of storage space on the component system. A value of UINT32_MAX implies the field is unused.", units = "MiB")
	private long[] storageTotal = new long[4];

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 16, typeSize = 4, streamLength = 24, description = "Link type: 0-9: UART, 10-19: Wired network, 20-29: Wifi, 30-39: Point-to-point proprietary, 40-49: Mesh proprietary")
	private long[] linkType = new long[6];

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 17, typeSize = 4, streamLength = 24, description = "Network traffic from the component system. A value of UINT32_MAX implies the field is unused.", units = "KiB/s")
	private long[] linkTxRate = new long[6];

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 18, typeSize = 4, streamLength = 24, description = "Network traffic to the component system. A value of UINT32_MAX implies the field is unused.", units = "KiB/s")
	private long[] linkRxRate = new long[6];

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 19, typeSize = 4, streamLength = 24, description = "Network capacity from the component system. A value of UINT32_MAX implies the field is unused.", units = "KiB/s")
	private long[] linkTxMax = new long[6];

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 20, typeSize = 4, streamLength = 24, description = "Network capacity to the component system. A value of UINT32_MAX implies the field is unused.", units = "KiB/s")
	private long[] linkRxMax = new long[6];

	private final int messagePayloadLength = 238;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public OnboardComputerStatus(BigInteger timeUsec, long uptime, short type, short[] cpuCores, short[] cpuCombined, short[] gpuCores, short[] gpuCombined, byte temperatureBoard, byte[] temperatureCore, short[] fanSpeed, long ramUsage, long ramTotal, long[] storageType, long[] storageUsage, long[] storageTotal, long[] linkType, long[] linkTxRate, long[] linkRxRate, long[] linkTxMax, long[] linkRxMax) {
		this.timeUsec = timeUsec;
		this.uptime = uptime;
		this.type = type;
		this.cpuCores = cpuCores;
		this.cpuCombined = cpuCombined;
		this.gpuCores = gpuCores;
		this.gpuCombined = gpuCombined;
		this.temperatureBoard = temperatureBoard;
		this.temperatureCore = temperatureCore;
		this.fanSpeed = fanSpeed;
		this.ramUsage = ramUsage;
		this.ramTotal = ramTotal;
		this.storageType = storageType;
		this.storageUsage = storageUsage;
		this.storageTotal = storageTotal;
		this.linkType = linkType;
		this.linkTxRate = linkTxRate;
		this.linkRxRate = linkRxRate;
		this.linkTxMax = linkTxMax;
		this.linkRxMax = linkRxMax;
	}

	public OnboardComputerStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 238！");
		}
		messagePayload(messagePayload);
	}

	public OnboardComputerStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		uptime = byteArray.getUnsignedInt32(8);
		type = byteArray.getUnsignedInt8(12);
		cpuCores = byteArray.getUnsignedInt8Array(13,8);
		cpuCombined = byteArray.getUnsignedInt8Array(21,10);
		gpuCores = byteArray.getUnsignedInt8Array(31,4);
		gpuCombined = byteArray.getUnsignedInt8Array(35,10);
		temperatureBoard = byteArray.getInt8(45);
		temperatureCore = byteArray.getInt8Array(46,8);
		fanSpeed = byteArray.getInt16Array(54,4);
		ramUsage = byteArray.getUnsignedInt32(62);
		ramTotal = byteArray.getUnsignedInt32(66);
		storageType = byteArray.getUnsignedInt32Array(70,4);
		storageUsage = byteArray.getUnsignedInt32Array(86,4);
		storageTotal = byteArray.getUnsignedInt32Array(102,4);
		linkType = byteArray.getUnsignedInt32Array(118,6);
		linkTxRate = byteArray.getUnsignedInt32Array(142,6);
		linkRxRate = byteArray.getUnsignedInt32Array(166,6);
		linkTxMax = byteArray.getUnsignedInt32Array(190,6);
		linkRxMax = byteArray.getUnsignedInt32Array(214,6);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putUnsignedInt32(uptime,8);
		byteArray.putUnsignedInt8(type,12);
		byteArray.putUnsignedInt8Array(cpuCores,13);
		byteArray.putUnsignedInt8Array(cpuCombined,21);
		byteArray.putUnsignedInt8Array(gpuCores,31);
		byteArray.putUnsignedInt8Array(gpuCombined,35);
		byteArray.putInt8(temperatureBoard,45);
		byteArray.putInt8Array(temperatureCore,46);
		byteArray.putInt16Array(fanSpeed,54);
		byteArray.putUnsignedInt32(ramUsage,62);
		byteArray.putUnsignedInt32(ramTotal,66);
		byteArray.putUnsignedInt32Array(storageType,70);
		byteArray.putUnsignedInt32Array(storageUsage,86);
		byteArray.putUnsignedInt32Array(storageTotal,102);
		byteArray.putUnsignedInt32Array(linkType,118);
		byteArray.putUnsignedInt32Array(linkTxRate,142);
		byteArray.putUnsignedInt32Array(linkRxRate,166);
		byteArray.putUnsignedInt32Array(linkTxMax,190);
		byteArray.putUnsignedInt32Array(linkRxMax,214);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final OnboardComputerStatus setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final OnboardComputerStatus setUptime(long uptime) {
		this.uptime = uptime;
		return this;
	}

	public final long getUptime() {
		return uptime;
	}

	public final OnboardComputerStatus setType(short type) {
		this.type = type;
		return this;
	}

	public final short getType() {
		return type;
	}

	public final OnboardComputerStatus setCpuCores(short[] cpuCores) {
		this.cpuCores = cpuCores;
		return this;
	}

	public final short[] getCpuCores() {
		return cpuCores;
	}

	public final OnboardComputerStatus setCpuCombined(short[] cpuCombined) {
		this.cpuCombined = cpuCombined;
		return this;
	}

	public final short[] getCpuCombined() {
		return cpuCombined;
	}

	public final OnboardComputerStatus setGpuCores(short[] gpuCores) {
		this.gpuCores = gpuCores;
		return this;
	}

	public final short[] getGpuCores() {
		return gpuCores;
	}

	public final OnboardComputerStatus setGpuCombined(short[] gpuCombined) {
		this.gpuCombined = gpuCombined;
		return this;
	}

	public final short[] getGpuCombined() {
		return gpuCombined;
	}

	public final OnboardComputerStatus setTemperatureBoard(byte temperatureBoard) {
		this.temperatureBoard = temperatureBoard;
		return this;
	}

	public final byte getTemperatureBoard() {
		return temperatureBoard;
	}

	public final OnboardComputerStatus setTemperatureCore(byte[] temperatureCore) {
		this.temperatureCore = temperatureCore;
		return this;
	}

	public final byte[] getTemperatureCore() {
		return temperatureCore;
	}

	public final OnboardComputerStatus setFanSpeed(short[] fanSpeed) {
		this.fanSpeed = fanSpeed;
		return this;
	}

	public final short[] getFanSpeed() {
		return fanSpeed;
	}

	public final OnboardComputerStatus setRamUsage(long ramUsage) {
		this.ramUsage = ramUsage;
		return this;
	}

	public final long getRamUsage() {
		return ramUsage;
	}

	public final OnboardComputerStatus setRamTotal(long ramTotal) {
		this.ramTotal = ramTotal;
		return this;
	}

	public final long getRamTotal() {
		return ramTotal;
	}

	public final OnboardComputerStatus setStorageType(long[] storageType) {
		this.storageType = storageType;
		return this;
	}

	public final long[] getStorageType() {
		return storageType;
	}

	public final OnboardComputerStatus setStorageUsage(long[] storageUsage) {
		this.storageUsage = storageUsage;
		return this;
	}

	public final long[] getStorageUsage() {
		return storageUsage;
	}

	public final OnboardComputerStatus setStorageTotal(long[] storageTotal) {
		this.storageTotal = storageTotal;
		return this;
	}

	public final long[] getStorageTotal() {
		return storageTotal;
	}

	public final OnboardComputerStatus setLinkType(long[] linkType) {
		this.linkType = linkType;
		return this;
	}

	public final long[] getLinkType() {
		return linkType;
	}

	public final OnboardComputerStatus setLinkTxRate(long[] linkTxRate) {
		this.linkTxRate = linkTxRate;
		return this;
	}

	public final long[] getLinkTxRate() {
		return linkTxRate;
	}

	public final OnboardComputerStatus setLinkRxRate(long[] linkRxRate) {
		this.linkRxRate = linkRxRate;
		return this;
	}

	public final long[] getLinkRxRate() {
		return linkRxRate;
	}

	public final OnboardComputerStatus setLinkTxMax(long[] linkTxMax) {
		this.linkTxMax = linkTxMax;
		return this;
	}

	public final long[] getLinkTxMax() {
		return linkTxMax;
	}

	public final OnboardComputerStatus setLinkRxMax(long[] linkRxMax) {
		this.linkRxMax = linkRxMax;
		return this;
	}

	public final long[] getLinkRxMax() {
		return linkRxMax;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			OnboardComputerStatus other = (OnboardComputerStatus)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.uptime, other.uptime)) {
				return false;
			} else if (!Objects.deepEquals(this.type, other.type)) {
				return false;
			} else if (!Objects.deepEquals(this.cpuCores, other.cpuCores)) {
				return false;
			} else if (!Objects.deepEquals(this.cpuCombined, other.cpuCombined)) {
				return false;
			} else if (!Objects.deepEquals(this.gpuCores, other.gpuCores)) {
				return false;
			} else if (!Objects.deepEquals(this.gpuCombined, other.gpuCombined)) {
				return false;
			} else if (!Objects.deepEquals(this.temperatureBoard, other.temperatureBoard)) {
				return false;
			} else if (!Objects.deepEquals(this.temperatureCore, other.temperatureCore)) {
				return false;
			} else if (!Objects.deepEquals(this.fanSpeed, other.fanSpeed)) {
				return false;
			} else if (!Objects.deepEquals(this.ramUsage, other.ramUsage)) {
				return false;
			} else if (!Objects.deepEquals(this.ramTotal, other.ramTotal)) {
				return false;
			} else if (!Objects.deepEquals(this.storageType, other.storageType)) {
				return false;
			} else if (!Objects.deepEquals(this.storageUsage, other.storageUsage)) {
				return false;
			} else if (!Objects.deepEquals(this.storageTotal, other.storageTotal)) {
				return false;
			} else if (!Objects.deepEquals(this.linkType, other.linkType)) {
				return false;
			} else if (!Objects.deepEquals(this.linkTxRate, other.linkTxRate)) {
				return false;
			} else if (!Objects.deepEquals(this.linkRxRate, other.linkRxRate)) {
				return false;
			} else if (!Objects.deepEquals(this.linkTxMax, other.linkTxMax)) {
				return false;
			} else {
				return Objects.deepEquals(this.linkRxMax, other.linkRxMax);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.uptime);
		result = 31 * result + Objects.hashCode(this.type);
		result = 31 * result + Objects.hashCode(this.cpuCores);
		result = 31 * result + Objects.hashCode(this.cpuCombined);
		result = 31 * result + Objects.hashCode(this.gpuCores);
		result = 31 * result + Objects.hashCode(this.gpuCombined);
		result = 31 * result + Objects.hashCode(this.temperatureBoard);
		result = 31 * result + Objects.hashCode(this.temperatureCore);
		result = 31 * result + Objects.hashCode(this.fanSpeed);
		result = 31 * result + Objects.hashCode(this.ramUsage);
		result = 31 * result + Objects.hashCode(this.ramTotal);
		result = 31 * result + Objects.hashCode(this.storageType);
		result = 31 * result + Objects.hashCode(this.storageUsage);
		result = 31 * result + Objects.hashCode(this.storageTotal);
		result = 31 * result + Objects.hashCode(this.linkType);
		result = 31 * result + Objects.hashCode(this.linkTxRate);
		result = 31 * result + Objects.hashCode(this.linkRxRate);
		result = 31 * result + Objects.hashCode(this.linkTxMax);
		result = 31 * result + Objects.hashCode(this.linkRxMax);
		return result;
	}

	@Override
	public String toString() {
		return "OnboardComputerStatus{" +
				"timeUsec=" + timeUsec +
				", uptime=" + uptime +
				", type=" + type +
				", cpuCores=" + Arrays.toString(cpuCores) +
				", cpuCombined=" + Arrays.toString(cpuCombined) +
				", gpuCores=" + Arrays.toString(gpuCores) +
				", gpuCombined=" + Arrays.toString(gpuCombined) +
				", temperatureBoard=" + temperatureBoard +
				", temperatureCore=" + Arrays.toString(temperatureCore) +
				", fanSpeed=" + Arrays.toString(fanSpeed) +
				", ramUsage=" + ramUsage +
				", ramTotal=" + ramTotal +
				", storageType=" + Arrays.toString(storageType) +
				", storageUsage=" + Arrays.toString(storageUsage) +
				", storageTotal=" + Arrays.toString(storageTotal) +
				", linkType=" + Arrays.toString(linkType) +
				", linkTxRate=" + Arrays.toString(linkTxRate) +
				", linkRxRate=" + Arrays.toString(linkRxRate) +
				", linkTxMax=" + Arrays.toString(linkTxMax) +
				", linkRxMax=" + Arrays.toString(linkRxMax) +
				'}';
	}
}