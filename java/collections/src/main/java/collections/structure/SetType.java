package collections.structure;

import java.util.HashSet;
import java.util.LinkedHashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import collections.structure.base.BaseType;

public class SetType extends BaseType {

	private static final Logger LOG = LoggerFactory.getLogger(SetType.class);
	
	public void hashSet() {
		
		/* Key 기준 오름 차순 정렬되어 보관 */
		HashSet<Object> sources = new HashSet<>();
		
		sources.add(5);
		sources.add("b");
		sources.add(0);
		sources.add("a");
		
		Object elem = new Object();
		sources.add(elem);
		
		Integer elemInt = new Integer(55);
		sources.add(elemInt);
		
		super.print(sources);
		
		boolean contains5 = sources.contains(5);
		LOG.debug("contains 5? -> {}", contains5);
		
		boolean contains6 = sources.contains(6);
		LOG.debug("contains 6? -> {}", contains6);
		
		boolean containsElem = sources.contains(elem);
		LOG.debug("contains elem? -> {}", containsElem);
		
		boolean containsInt = sources.contains(elemInt);
		LOG.debug("contains Int? -> {}", containsInt);
		
		boolean contain55 = sources.contains(new Integer(55));
		LOG.debug("contains 55? -> {}", contain55);
		
		LOG.debug("hashCode = {}, {}", new Integer(54).hashCode(), new Integer(55).hashCode());
	}
	
	public void linkedHashSet() {
		
		/* 입력 순서대로 정렬되어 보관 */
		LinkedHashSet<Object> sources = new LinkedHashSet<>();
		
		sources.add(5);
		sources.add("b");
		sources.add(0);
		sources.add("a");
		
		Object elem = new Object();
		sources.add(elem);
		
		super.print(sources);
	}
	
	public static void main(String[] args) {
//		new SetType().hashSet();
		new SetType().linkedHashSet();
	}
}
