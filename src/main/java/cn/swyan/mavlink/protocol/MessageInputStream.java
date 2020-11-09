package cn.swyan.mavlink.protocol;

import java.io.IOException;
import java.io.InputStream;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.03 - 16:43
 **********************************/

public class MessageInputStream extends InputStream {

	protected byte[] byteBuffer;

	protected int readIndex;

	protected int mark = 0;

	protected int length;

	public MessageInputStream(byte[] byteBuffer) {
		this.byteBuffer = byteBuffer;
		this.readIndex = 0;
		this.length = byteBuffer.length;
	}

	public MessageInputStream(byte[] byteBuffer, int offset, int length) {
		this.byteBuffer = byteBuffer;
		this.readIndex = offset;
		this.length = Math.min(offset + length, byteBuffer.length);
		this.mark = offset;
	}

	@Override
	public synchronized int read() {
		return (readIndex < length) ? (byteBuffer[readIndex++] & 0xff) : -1;
	}

	public synchronized int directRead() {
		return (readIndex < length) ? (byteBuffer[readIndex + 1] & 0xff) : -1;
	}

	@Override
	public synchronized int read(byte[] targetByteArray, int offset, int length) {
		if (targetByteArray == null) {
			throw new NullPointerException();
		} else if (offset < 0 || length < 0 || length > targetByteArray.length - offset) {
			throw new IndexOutOfBoundsException();
		}
		if (readIndex >= this.length) {
			return -1;
		}
		int avail = this.length - readIndex;
		if (length > avail) {
			length = avail;
		}
		if (length <= 0) {
			return 0;
		}
		System.arraycopy(byteBuffer, readIndex, targetByteArray, offset, length);
		readIndex += length;
		return length;
	}

	@Override
	public synchronized long skip(long n) {
		long k = length - readIndex;
		if (n < k) {
			k = n < 0 ? 0 : n;
		}
		readIndex += k;
		return k;
	}

	@Override
	public synchronized int available() {
		return length - readIndex;
	}

	public synchronized void readIndex(int index) {
		readIndex = index;
	}

	public synchronized int readIndex() {
		return readIndex;
	}

	public void mark() {
		mark = readIndex;
	}

	@Override
	public synchronized void reset() {
		readIndex = mark;
	}

	@Override
	public void close() throws IOException {
	}
}
