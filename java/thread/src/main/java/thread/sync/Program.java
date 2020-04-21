package thread.sync;

import java.util.HashMap;
import java.util.Map;

public class Program {

	public static void main(String[] args) {
		
		Map<String, Object> param = new HashMap<>();
		Integer loop = 1000;
		
		Thread t1 = new MyThread(loop, param);
		Thread t2 = new MyThread(loop, param); 
		
		t1.start();
		t2.start();
	}
}
