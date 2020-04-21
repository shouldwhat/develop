package collections.structure.base;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseType {

	private static final Logger LOG = LoggerFactory.getLogger(BaseType.class);
	
	public void print(Collection collection) {
		
		LOG.debug("----------------------------------------------------");
		int index = 0;
		for(Object elem : collection) {
			LOG.debug("[{}] -> {}", index++, elem);
		}
		LOG.debug("----------------------------------------------------\n");
	}
}
