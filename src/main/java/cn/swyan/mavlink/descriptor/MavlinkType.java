package cn.swyan.mavlink.descriptor;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.10.26 - 14:39
 **********************************/

public class MavlinkType {
	private final Class<?> type;
	private final String mavlinkType;
	private final boolean isArray;
	private final boolean isUnsigned;
	private final int length;
	private final int arrayLength;
	private final int streamLength;
	private static final Map<String, Type> TYPE_MAP = new HashMap<>(11);

	static {
		TYPE_MAP.put("int8_t", Type.INT8);
		TYPE_MAP.put("uint8_t", Type.UINT8);
		TYPE_MAP.put("int16_t", Type.INT16);
		TYPE_MAP.put("uint16_t", Type.UINT16);
		TYPE_MAP.put("int32_t", Type.INT32);
		TYPE_MAP.put("uint32_t", Type.UINT32);
		TYPE_MAP.put("int64_t", Type.INT64);
		TYPE_MAP.put("uint64_t", Type.UINT64);
		TYPE_MAP.put("char", Type.CHAR);
		TYPE_MAP.put("float", Type.FLOAT);
		TYPE_MAP.put("double", Type.DOUBLE);
	}

	MavlinkType(String mavlinkType){
		int arrayStartIndex = mavlinkType.indexOf('[');
		int arrayEndIndex = mavlinkType.indexOf(']');
		isArray = arrayStartIndex != -1 && arrayEndIndex != -1;
		isUnsigned = mavlinkType.startsWith("u");
		if (arrayStartIndex != -1 ^ arrayEndIndex != -1){
			throw new IllegalArgumentException();
		}
		if (isArray){
			this.mavlinkType = mavlinkType.substring(0, arrayStartIndex);
		} else {
			String mavlinkVersion = "uint8_t_mavlink_version";
			if (mavlinkType.equals(mavlinkVersion)) {
				this.mavlinkType = "uint8_t";
			}else {
				this.mavlinkType = mavlinkType;
			}
		}
		if (!(TYPE_MAP.containsKey(this.mavlinkType))){
			throw new IllegalArgumentException("Unknown type: " + mavlinkType);
		}
		
		Type enumType = TYPE_MAP.get(this.mavlinkType);
		type = enumType.getClazz();
		length = enumType.getLength();
		if (isArray){
			arrayLength = Integer.parseInt(mavlinkType.substring(arrayStartIndex + 1, arrayEndIndex));
			streamLength = length * arrayLength;
		} else {
			arrayLength = 0;
			streamLength = length;
		}
	}

	public static MavlinkType of(String mavlinkType){
		return new MavlinkType(mavlinkType);
	}

	enum Type {
		/**
		 * MavlinkType
		 */
		INT8(1, byte.class),
		UINT8(1, short.class),
		INT16(2, short.class),
		UINT16(2, int.class),
		INT32(4, int.class),
		UINT32(4, long.class),
		INT64(8, long.class),
		UINT64(8, BigInteger.class),
		FLOAT(4, float.class),
		DOUBLE(8, double.class),
		CHAR(1, char.class);
		private final int length;
		private final Class<?> clazz;
		Type(int length, Class<?> clazz) {
			  this.length = length;
			  this.clazz = clazz;
		}
		public int getLength() {
			return length;
		}
		public Class<?> getClazz() {
			return clazz;
		}
	}

	public Class<?> getType() {
		return type;
	}

	public String getTypeName() {
		return type.getSimpleName();
	}

	public String getMavlinkType() {
		return mavlinkType;
	}

	public boolean isArray() {
		return isArray;
	}

	public boolean isUnsigned() {
		return isUnsigned;
	}

	public int getArrayLength() {
		return arrayLength;
	}

	public int getLength() {
		return length;
	}

	public int getStreamLength() {
		return streamLength;
	}
}
