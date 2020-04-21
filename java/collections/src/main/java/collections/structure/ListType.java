package collections.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import collections.structure.base.BaseType;

public class ListType extends BaseType {

	private static final Logger LOG = LoggerFactory.getLogger(ListType.class);
	
	public void arrayList() {
		
		ArrayList<String> sources = new ArrayList<>();
		
		sources.add("111");
		sources.add("222");
		sources.add("333");
		
		super.print(sources);
		
		int indexOf = sources.indexOf("222");	// 1
//		int indexOf = sources.indexOf("3");		// -1
		LOG.debug("indexOf = {}", indexOf);
		
		Object[] arrObj = sources.toArray();
		for(int n=0; n<arrObj.length; n++) {
			LOG.debug("[{}] -> {}", n, arrObj[n]);
		}
		
		LOG.debug("\n");
		
		String[] arrStr = new String[sources.size()];
		{	/* ArrayList<String> to String[] */
			sources.toArray(arrStr);
			for(int n=0; n<arrStr.length; n++) {
				LOG.debug("[{}] -> {}", n, arrStr[n]);
			}
		}
		
		LOG.debug("\n");
		
		{	/* Object[] to String[] */
			arrStr = Arrays.stream(arrObj).toArray(String[]::new);
			for(int n=0; n<arrStr.length; n++) {
				LOG.debug("[{}] -> {}", n, arrStr[n]);
			}
		}
		
		LOG.debug("\n");
		
		List<String> subList = sources.subList(1, 2);
		super.print(subList);
		
	}
	
	public static void main(String[] args) {
		new ListType().arrayList();
	}
}
