package thread.sync;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyThread extends Thread {

	private static final Logger LOG = LoggerFactory.getLogger(MyThread.class);
	
	private static final String LOCK = "ITERATION_LOCK";
	
	private Integer MAX_COUNT = 0;
	
	private Integer summation = 0;
	
	private Map<String, Object> param = null;
	
	public MyThread(Integer count) {
		this.MAX_COUNT = count;
	}
	
	public MyThread(Integer count, Map<String, Object> param) {
		this(count);
		this.param = param;
	}
	
	@Override
	public void run() {
//		this.sycronizeMethod();
		this.sycronizeSharedObject();
	}
	
	private synchronized void sycronizeMethod() {
		
		/*
		 * 해당 메소드를 synchronzie 하더라도, 해당 클래스(MyThread)의 인스턴스가 다르면 의미 없음.
		 */
		
		for(int n=0; n<MAX_COUNT; n++) {
			this.summation += n;
			LOG.debug("index = {}", n);
		}
		
		LOG.debug("result = {}", this.summation);
	}
	
	private void sycronizeSharedObject() {
		
		/*
		 * 각 쓰레드(MyThread) 인스턴스가 다른 경우에 내부 메소드에서 동기화가 필요한 경우, 동기화할 데이터에 synchronzie를 걸어야 의도한데로 돌아감.
		 */
		
//		synchronized (MyThread.class) {	// -> ??, 동기화 처리 가능
//		synchronized (this.param) {		// -> 공유 데이터(=param) 임으로, 동기화 처리 가능
		synchronized(this.LOCK) {		// -> static 변수로 동기화 처리 가능 	 
			
			for(int n=0; n<MAX_COUNT; n++) {
				this.summation += n;
				LOG.debug("index = {}", n);
			}
			LOG.debug("result = {}", this.summation);
			
		}
		
	}
}
