package collections.structure;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import collections.structure.base.BaseType;

public class HashTableType extends BaseType {

	private static final Logger LOG = LoggerFactory.getLogger(HashTableType.class);
	
	public void hashMap() {
		
		/* Key 기준 오름 차순 정렬되어 보관 */
		HashMap<String, Object> sources = new HashMap<>();

		/* Key의 hashCode 값으로 테이블에 저장 */
		sources.put("A", "a");
		sources.put("B", "b");
		sources.put("D", "d");
		sources.put("C", "c");
		sources.put("B", "bb");
		super.print(sources.entrySet());
		
		/* Key의 hashCode 값으로 변환하여 테이블에서 조회 */
		Object a = sources.get("A");
		LOG.debug("a = {}", a);
		
		Object b = sources.get("b");
		LOG.debug("b = {}", b);
		
		b = sources.getOrDefault("b", 0);
		LOG.debug("b = {}", b);
	}
	
	public void linkedHashMap() {
		
		/* 입력 순서대로 정렬되어 보관 */
		LinkedHashMap<String, Object> sources = new LinkedHashMap<>();
		sources.put("A", "a");
		sources.put("B", "b");
		sources.put("D", "d");
		sources.put("C", "c");
		sources.put("B", "bb");
		super.print(sources.entrySet());
	}
	
	public static void main(String[] args) {
		new HashTableType().hashMap();
//		new HashTableType().linkedHashMap();
	}
}
