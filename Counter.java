package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
	private Integer counter = 0;
	private Lock lock;
	public Counter(Lock lock) {
		this.lock = lock;
	}

	public void inc() {
		lock.lock();
		this.counter++;
		lock.unlock();
	}
	public void dec() {
		lock.lock();
		this.counter--;
		lock.unlock();
	}
	public int getCounter() {
		return this.counter;
	}
}
