package lock;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SafeDictionary {
	private final Map<String, String> map = new TreeMap<>();
	private final ReentrantReadWriteLock readWritelock = new ReentrantReadWriteLock();
	private final Lock readLock = readWritelock.readLock();
	private final Lock writeLock = readWritelock.readLock();
	
	public String get(String key) {
		readLock.lock();
		try {
			return map.get(key);
		} finally {
			readLock.unlock();
		}
	}
	public String put(String key, String value) {
		writeLock.lock();
		try {
			return map.put(key, value);
		} finally {
			writeLock.unlock();
		}
	}
	public void clear() {
		writeLock.lock();
		try {
			map.clear();
		} finally {
			writeLock.unlock();
		}
	}
}
