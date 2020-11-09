package cn.wsyjlly.mavlink.protocol.util;

import java.nio.charset.StandardCharsets;

/**********************************
 * Author YSW
 * Description CrcX25
 * Date 2020.10.28 - 14:14
 **********************************/

public class CrcX25 {
	private int crc = 65535;

	public CrcX25() {
	}

	public void accumulate(String str) {
		this.accumulate(str.getBytes(StandardCharsets.UTF_8));
	}

	public void accumulate(byte[] bytes) {
		this.accumulate(bytes, 0, bytes.length);
	}

	public void accumulate(byte[] bytes, int offset, int length) {
		for(int i = offset; i < length; ++i) {
			this.accumulate(bytes[i]);
		}

	}

	public void accumulate(int b) {
		b ^= this.crc & 255;
		b ^= b << 4 & 255;
		b &= 255;
		this.crc = this.crc >> 8 ^ b << 8 ^ b << 3 ^ b >> 4;
	}

	public int get() {
		return this.crc & '\uffff';
	}
}

