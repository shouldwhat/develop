package stream.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FunctionTest {

	private static final Logger LOG = LoggerFactory.getLogger(FunctionTest.class);
	
	public static void main(String[] args) {
		new FunctionTest().flatMap();
	}

	private void flatMap() {
		
		/*
		 * flatMap : 동일 타입의 stream을 하나로 병합
		 */
		
		{	/* [Sample.1] */
			List<String> sources = Arrays.asList("hello", "world", "my", "name", "is", "wonkyu");
			List<Character> collect = sources.stream().flatMap(src -> charStream(src)).collect(Collectors.toList());
			
			LOG.debug(collect.toString());
		}
		
		
		{	/* [Sample.2] */
			Map<String, Object> mapSources = new HashMap<>();
			
			List<Map<String, Object>> elemList1 = IntStream.range(1, 4).mapToObj(index -> {
				
				Map<String, Object> elem = new HashMap<>();
				elem.put("name", "won");
				elem.put("age", index);
				return elem;
				
			}).collect(Collectors.toList());
			
			List<Map<String, Object>> elemList2 = IntStream.range(1, 4).mapToObj(index -> {
				
				Map<String, Object> elem = new HashMap<>();
				elem.put("name", "kyu");
				elem.put("age", index);
				return elem;
				
			}).collect(Collectors.toList());
			
			mapSources.put("elems1", elemList1);
			mapSources.put("elems2", elemList2);
			
			LOG.debug("`e` mapSources = {}", mapSources);
			
			List<Map<String, Object>> result = mapSources.entrySet().stream()
					.flatMap(entry -> Stream.of((Map<String, Object>)entry.getValue()))
					.collect(Collectors.toList());
			
			LOG.debug("`e` flatMap = {}", result);
		}
	}

	private Stream<Character> charStream(String src) {
		
		List<Character> result = new ArrayList<>();
		for (char c : src.toCharArray()) {
			result.add(c);
		}
		return result.stream();
	}
}
