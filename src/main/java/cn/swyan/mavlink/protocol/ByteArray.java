package cn.swyan.mavlink.protocol;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

/**
 * Author YSW
 */
public class ByteArray {
	private final byte[] bytes;

	public ByteArray(byte[] bytes) {
		this.bytes = bytes;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public byte getInt8(int offset) {
		return (byte) this.getLong(offset, 1);
	}

	public short getUnsignedInt8(int offset) {
		return (short) this.getLong(offset, 1);
	}

	public ByteArray putInt8(int value, int offset) {
		return this.putLong((byte) value, offset, 1);
	}

	public ByteArray putUnsignedInt8(int value, int offset) {
		return this.putLong(value, offset, 1);
	}

	public short getInt16(int offset) {
		return (short) this.getLong(offset, 2);
	}

	public int getUnsignedInt16(int offset) {
		return (int) this.getLong(offset, 2);
	}

	public ByteArray putInt16(int value, int offset) {
		return this.putLong((short) value, offset, 2);
	}

	public ByteArray putUnsignedInt16(int value, int offset) {
		return this.putLong(value, offset, 2);
	}

	public int getUnsignedInt24(int offset) {
		return (int) this.getLong(offset, 3);
	}

	public ByteArray putUnsignedInt24(int value, int offset) {
		return this.putLong(value, offset, 3);
	}

	public int getInt32(int offset) {
		return (int) this.getLong(offset, 4);
	}

	public long getUnsignedInt32(int offset) {
		return this.getLong(offset, 4);
	}

	public ByteArray putInt32(long value, int offset) {
		return this.putLong((int) value, offset, 4);
	}

	public ByteArray putUnsignedInt32(long value, int offset) {
		return this.putLong(value, offset, 4);
	}

	public long getUnsignedInt48(int offset) {
		return this.getLong(offset, 6);
	}

	public ByteArray putUnsignedInt48(long value, int offset) {
		return this.putLong(value, offset, 6);
	}

	public int getInt64(int offset) {
		return (int) this.getLong(offset, 4);
	}

	public BigInteger getUnsignedInt64(int offset) {
		long aLong = this.getLong(offset, 8);
		if (aLong < 0) {
			return new BigInteger(String.valueOf(0x7FFFFFFFFFFFFFFFL))
					.add(BigInteger.valueOf(0x7FFFFFFFFFFFFFFFL))
					.add(BigInteger.valueOf(aLong))
					.add(BigInteger.valueOf(2));
		}
		return new BigInteger(String.valueOf(aLong));
	}

	public ByteArray putInt64(long value, int offset) {
		return this.putLong(value, offset, 8);
	}

	public ByteArray putUnsignedInt64(long value, int offset) {
		return this.putLong(value, offset, 8);
	}

	public float getFloat(int offset) {
		int intBits = (int) this.getLong(offset, 4);
		return Float.intBitsToFloat(intBits);
	}

	public ByteArray putFloat(float value, int offset) {
		int intBits = Float.floatToIntBits(value);
		return this.putLong(intBits, offset, 4);
	}

	public double getDouble(int offset) {
		long longBits = this.getLong(offset, 4);
		return Double.longBitsToDouble(longBits);
	}

	public ByteArray putDouble(long value, int offset) {
		long longBits = Double.doubleToLongBits(value);
		return this.putLong(longBits, offset, 8);
	}

	public String getChars(int offset, int size) {
		byte[] value = new byte[size];
		if (size >= 0) {
			System.arraycopy(this.bytes, offset, value, 0, size);
		}
		return new String(value, StandardCharsets.UTF_8);
	}

	public ByteArray putChars(String value, int offset) {
		byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
		System.arraycopy(bytes, 0, this.bytes, offset, bytes.length);
		return this;
	}

	public byte[] slice(int offset, int size) {
		byte[] value = new byte[size];
		System.arraycopy(this.bytes, offset, value, 0, size);
		return value;
	}

	/**
	 * 小端转大端解析
	 * long型共占用8个字节，byte占用一个字节
	 * byte数组第一位占long型的第8位
	 * byte数组第二位占long型的第7位
	 * byte数组第三位占long型的第6位
	 * byte数组第四位占long型的第5位
	 * byte数组第五位占long型的第4位
	 * byte数组第六位占long型的第3位
	 * byte数组第七位占long型的第2位
	 * byte数组第八位占long型的第1位
	 *
	 * @param offset 偏移量
	 * @param size   字节数量
	 * @return long型整数
	 */
	public long getLong(int offset, int size) {
		long value = 0L;
		for (int i = 0; i < size; ++i) {
			value |= ((long) this.bytes[offset + i] & 0xFF) << i * 8;
		}
		return value;
	}

	public ByteArray putLong(long value, int offset, int size) {
		for (int i = 0; i < size; ++i) {
			this.bytes[offset + i] = (byte) ((int) (value >> i * 8 & 0xFF));
		}
		return this;
	}

	public int length() {
		return this.bytes.length;
	}
}
