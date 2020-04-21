package collections.structure;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import collections.structure.base.BaseType;

public class StackType extends BaseType {

	private static final Logger LOG = LoggerFactory.getLogger(StackType.class);
	
	public void linkedList() {
		
		LinkedList<Integer> sources = new LinkedList<>();
		
		sources.push(5);
		sources.push(50);
		sources.push(2);
		sources.push(25);
		sources.push(3);
		sources.push(90);
		super.print(sources);
		
		Integer pop = sources.pop();
		LOG.debug("pop = {}", pop);
		super.print(sources);
		
		sources.push(300);
		super.print(sources);
		
		Integer remove = sources.remove();
		LOG.debug("remove = {}", remove);
		super.print(sources);

		Integer[] arrInt = sources.stream().toArray(Integer[]::new);
		for(int index = 0; index<arrInt.length; index++) {
			LOG.debug("[{}] -> {}", index, arrInt[index]);
		}
	}
	
	public static void main(String[] args) {
		new StackType().linkedList();
	}
}
