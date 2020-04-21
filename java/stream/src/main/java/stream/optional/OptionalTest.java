package stream.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OptionalTest {

	private static final Logger LOG = LoggerFactory.getLogger(OptionalTest.class);
	
	public static void main(String[] args) {
		new OptionalTest().optional();
	}

	private void optional() {
		
		Map<String, Object> sourceMap = new HashMap<>();
		sourceMap.put("a", "에이");
	
		Map<String, Object> r1 = Optional.ofNullable(sourceMap).orElseGet(HashMap::new);
		LOG.debug("{}", r1);
		
		Map<String, Object> r2 = (Map<String, Object>) Optional.ofNullable(null).orElseGet(HashMap::new);
		LOG.debug("{}", r2 == null);
	}
	
}
