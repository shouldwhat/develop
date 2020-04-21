package stream.iteration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import stream.optional.OptionalTest;

public class InstreamTest {

private static final Logger LOG = LoggerFactory.getLogger(OptionalTest.class);
	
	public static void main(String[] args) {
		new InstreamTest().iterator();
	}

	private void iterator() {
		
		List<String> collected = null;
		collected = IntStream.range(0, 5)
				.mapToObj(i -> String.format("%s", i))
				.collect(Collectors.toList());
		
		LOG.debug("{}", collected);
	}
}
