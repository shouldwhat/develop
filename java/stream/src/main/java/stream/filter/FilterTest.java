package stream.filter;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilterTest {

	private static final Logger LOG = LoggerFactory.getLogger(FilterTest.class);
	
	public static void main(String[] args) {
		new FilterTest().filter();
	}

	private void filter() {
		
		List<Person> sources = Arrays.asList(
                new Person("won", 21),
                new Person("kyu", 25),
                new Person("kim", 28)
        );
		
		Person kyu = sources.stream()
				.filter(person -> StringUtils.equals("kyus", person.getName()))
				.findAny()
				.orElseGet(() -> new Person("not exist", 0));
//				.orElse(null);
		LOG.debug("{}", kyu);
		
		boolean isAbsent = sources.stream()
				.anyMatch(person -> StringUtils.equals("kyu", person.getName()));
		LOG.debug("{}", isAbsent);
		
		sources.stream()
		.filter(person -> person.getAge() > 20)
		.findFirst()
		.ifPresent(person -> System.out.println(person.toString()) );
		
		/* 최소 나이 찾기 */
		sources.stream().mapToInt(Person::getAge).min().ifPresent(System.out::print);
		
		/* 최대 나이 찾기 */
		sources.stream().mapToInt(Person::getAge).max().ifPresent(System.out::print);
		
		/* 평균 나이 계산 */
		sources.stream().mapToInt(Person::getAge).average().ifPresent(System.out::print);
		
		/* 통계 계산 */
		IntSummaryStatistics summaryStatistics = sources.stream().mapToInt(Person::getAge).summaryStatistics();
		LOG.debug("sum = {}", summaryStatistics.getSum());
		LOG.debug("min = {}", summaryStatistics.getMin());
		LOG.debug("max = {}", summaryStatistics.getMax());
		LOG.debug("aver = {}", summaryStatistics.getAverage());
		
		/* Collection to Array */
		Person[] arrPerson = sources.stream().toArray(Person[]::new);
		LOG.debug("size = {}", arrPerson.length);
	}
}
