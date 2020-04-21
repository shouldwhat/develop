package completableFuture.future;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FutureTest {

	public void testSequentialThreadChain() {
		
		System.out.println("[START] testSequentialThreadChain() ");
		
		try {
			
			String chainResult = CompletableFuture.completedFuture("[origin]")
					.thenApply(pastResult -> thread1(pastResult))
					.thenApply(pastResult -> thread2(pastResult))
					.get();
			
			System.out.println(chainResult);
			
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void testSupplyAsync() throws InterruptedException, ExecutionException {
		
		CompletableFuture<String> sec5Async = CompletableFuture.supplyAsync(this::sleep5sec);
		CompletableFuture<String> sec3Async = CompletableFuture.supplyAsync(this::sleep3sec);
		
		String sec5Output = sec5Async.get();
		System.out.println(sec5Output);
		
		String sec3Output = sec3Async.get();
		System.out.println(sec3Output);
		
		/* 
		 * result output
		 * {
		 * 		"call sleep3sec"
		 *		"call sleep5sec"
		 * }
		 */
	}
	
	public void testListStreamAsync() {
		
		List<CompletableFuture<String>> futureList = null;
		futureList = IntStream.range(0, 5)
				.mapToObj(i -> CompletableFuture.supplyAsync(() -> sleep5sec()))
				.collect(Collectors.toList());
		
		List<String> resultList = futureList.stream().map(CompletableFuture::join).collect(Collectors.toList());
		System.out.println(resultList);
	}
	
	private String thread1(String param) {
		String msg = "[thread1 appended]";
		System.out.println(msg);
		return param + msg;
	}
	
	private String thread2(String param) {
		String msg = "[thread2 appended]";
		System.out.println(msg);
		return param + msg;
	}
	
	private String sleep5sec() {
		
		try {
			
			System.out.println("call sleep5sec");
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "this is output of 'sleep5sec function'";
	}
	
	private String sleep3sec() {
		
		try {
			
			System.out.println("call sleep3sec");
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "this is output of 'sleep3sec function'";
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		try {
			FutureTest futureTest = new FutureTest();
//			futureTest.testSupplyAsync();
//			futureTest.testListStreamAsync();
			futureTest.testSequentialThreadChain();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
