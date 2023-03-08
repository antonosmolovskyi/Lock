package lock;

import java.util.HashMap;
import java.util.Random;

public class MainDictionary {

	private static final SafeDictionary safeDictionary = new SafeDictionary();
	
	private static HashMap<String, String> map = new HashMap<>();
	
	public static void main(String[] args) {
		

	}
	static void initMap() {
		map.put("Java", "The best one!!");
		map.put("Hello world", "Stop this, pls");
		map.put("Anton", "genius");
		map.put("Ukraine", "really best one!");
	}
	
	static class Reader implements Runnable {
		public void run() {
			while(true) {
				System.out.println(Thread.currentThread().getName() + ", is reading value");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	static class Writer implements Runnable {
		Random random = new Random();
		Object[] value = map.keySet().toArray(new String[0]);
		
		@Override
		public void run() {
			while(true) {
				System.out.println(Thread.currentThread().getName() + ", is reading value");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}

}
