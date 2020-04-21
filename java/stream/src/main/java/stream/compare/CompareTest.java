package stream.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompareTest {

	private static final Logger LOG = LoggerFactory.getLogger(CompareTest.class);
	
	
	public static void main(String[] args) {
		new CompareTest().comparator();
//		new CompareTest().comparing();
	}

	private void comparing() {
		
		List<Movie> sources = Arrays.asList(
		        new Movie("Lord of the rings", 8.8, true),
		        new Movie("Back to the future", 8.5, false),
		        new Movie("Carlito's way", 7.9, true),
		        new Movie("Pulp fiction", 8.9, false));
		
		List<Movie> sorted = sources.stream().sorted(Comparator.comparing(Movie::getName).reversed()
										.thenComparing(Comparator.comparing(Movie::getRating)).reversed())
										.collect(Collectors.toList());
		
		LOG.debug(sorted.toString());
	}
	
	private void comparator() {
		
		List<Integer> sources = new ArrayList<>();
		{
			sources.add(5);
			sources.add(55);
			sources.add(25);
			sources.add(45);
			sources.add(35);
			sources.add(95);
			sources.add(15);
			sources.add(45);
			sources.add(65);
		}
		
		Comparator<Integer> c = (Integer o1, Integer o2) -> o1 > o2? 1 : -1;
		{	/* [ Method.1 ] */
//			List<Integer> sorted = sources.stream().sorted(c).collect(Collectors.toList());
			List<Integer> sorted = sources.stream().sorted().collect(Collectors.toList());
			LOG.debug(sorted.toString());
		}
		
		{	/* [ Method.2 ] */
//			sources.sort(c);
			sources.sort(Comparator.naturalOrder());
			LOG.debug(sources.toString());
		}
		
		{	/* [ Method.3] */
			List<Integer> sorted = sources.stream().sorted(Comparator.comparing(i -> i.hashCode())).collect(Collectors.toList());
			LOG.debug(sorted.toString());
		}
		
		{	/* Reverse Ordering */
//			List<Integer> sorted = sources.stream().sorted(Comparator.comparing(i -> i.hashCode()).reversed()).collect(Collectors.toList());
			List<Integer> sorted = sources.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
			LOG.debug(sorted.toString());
		}
		
		{	/* List<Map> 컬렉션 정렬하기 */
			List<Map<String, Object>> mSource = new ArrayList<>();
			String orderingKey = "orderingKeyName";
			
			mSource.stream().sorted(Comparator.comparing(m -> (Double) ((Map) m).get(orderingKey))).collect(Collectors.toList());
			mSource.stream().sorted(Comparator.comparing(m -> (Double) ((Map) m).get(orderingKey)).reversed()).collect(Collectors.toCollection(ArrayList::new));
		}
	}
}
