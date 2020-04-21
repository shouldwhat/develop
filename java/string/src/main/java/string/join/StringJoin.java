package string.join;

import java.util.Arrays;
import java.util.StringJoiner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringJoin {

	private static final Logger LOG = LoggerFactory.getLogger(StringJoin.class);
	
	public static void main(String[] args) {
//		new StringJoin().join();
		new StringJoin().stringJoiner();
	}

	private void stringJoiner() {
		
		String prefix = "a";
		String postfix = "b";
		
		StringJoiner joiner = new StringJoiner("=", prefix, postfix);
		joiner.add("AAA");
		joiner.add("BBB");
		LOG.debug(joiner.toString());	// aAAA=BBBb
		
		joiner = new StringJoiner("=");
		joiner.add("CCC");
		joiner.add("DDDD");
		LOG.debug(joiner.toString());	// CCC=DDDD
	}

	private void join() {
		
		String dash = "-";
		
		String joinCharSeq = String.join(dash, "a", "b", "c");
		LOG.debug(joinCharSeq);						// a-b-c
		
		String joinArray = String.join(dash, Arrays.asList("c", "b", "e"));
		LOG.debug(joinArray);						// c-b-e
		
		LOG.debug("wonkyu".join("-", "o", "n"));	// not working
	}
}
