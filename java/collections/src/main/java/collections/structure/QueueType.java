package collections.structure;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import collections.structure.base.BaseType;

public class QueueType extends BaseType {

	private static final Logger LOG = LoggerFactory.getLogger(QueueType.class);
	
	public void linkedList() {
		
		LinkedList<Integer> sources = new LinkedList<>();
		
		sources.add(5);
		sources.addLast(10);
		sources.addFirst(15);
		sources.add(1, 13);		// add element to [1] index
		super.print(sources);
		
		
		Integer get = sources.get(1);
		LOG.debug("get = {}", get);
		
		
		Integer first = sources.getFirst();
		LOG.debug("first = {}", first);
		
		
		Integer last = sources.getLast();
		LOG.debug("last = {}", last);
		super.print(sources);
		
		Integer peek = sources.peek();
		LOG.debug("peek = {}", peek);
		super.print(sources);
		
		Integer poll = sources.poll();
		LOG.debug("poll = {}", poll);
		super.print(sources);
		
		
		Integer pollLast = sources.pollLast();
		LOG.debug("pollLast = {}", pollLast);
		super.print(sources);
	}
	
	public static void main(String[] args) {
		new QueueType().linkedList();
	}
}
