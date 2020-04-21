package stream.parallel;

import java.util.concurrent.TimeUnit;
import java.util.function.IntConsumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParallelStreamTest {

	private static final Logger LOG = LoggerFactory.getLogger(ParallelStreamTest.class);

	public static void main(String[] args) {
		new ParallelStreamTest().parallelStream();
	}

	private void parallelStream() {

		/*
		 * java.util.concurrent.ForkJoinPool.common.parallelism
		 * 0 : 1 코어
		 * 1 : 2 코어
		 * 3 : 4 코어
		 * 7 : 8 코어 
		 */
		
		Supplier<IntStream> sourceFactory = () -> IntStream.of(1, 2, 3, 4, 5, 6, 7, 8);

		IntConsumer doSomething = ParallelStreamTest::sleepAndPrint;

		{
			LOG.debug("------------------------------------------------------");
			LOG.debug("------------------------------------ 1 core processing");
			final long startTime = System.currentTimeMillis();
			
			sourceFactory.get()
				.forEach(doSomething);
			
			LOG.debug("duration -> [{}]\n", System.currentTimeMillis() - startTime);
		}
		
		
		{
			LOG.debug("------------------------------------------------------");
			LOG.debug("------------------------- 8 core processing [parallel]");
			final long startTime = System.currentTimeMillis();
			
			/* 8코어 사용 */
			System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "1");	
			
			sourceFactory.get()
				.parallel()
				.forEach(doSomething);
			
			LOG.debug("duration -> [{}]\n", System.currentTimeMillis() - startTime);
		}
		
		
		{
			LOG.debug("------------------------------------------------------");
			LOG.debug("------------------------- 8 core processing [parallel]");
			final long startTime = System.currentTimeMillis();
			
			/* 4코어 사용 */
			System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "3");
			
			sourceFactory.get()
				.parallel()
				.forEach(doSomething);
			
			LOG.debug("duration -> [{}]\n", System.currentTimeMillis() - startTime);
		}
		
		
		{
			LOG.debug("------------------------------------------------------");
			LOG.debug("------------------------- 8 core processing [parallel]");
			final long startTime = System.currentTimeMillis();
			
			/* 2코어 사용 */
			System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "8");
			
			sourceFactory.get()
				.parallel()
				.forEach(doSomething);
			
			LOG.debug("duration -> [{}]\n", System.currentTimeMillis() - startTime);
		}
	}
	
	private static void sleepAndPrint(int i) {
		try {
			TimeUnit.SECONDS.sleep(1);
			LOG.debug("i -> [{}]", i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
