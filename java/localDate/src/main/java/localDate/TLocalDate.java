package localDate;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TLocalDate {

	private static final Logger LOG = LoggerFactory.getLogger(TLocalDate.class);
	
	public static void main(String[] args) {
		new TLocalDate().localDate();
	}

	private void localDate() {
		
		LocalDate now = LocalDate.now();
		LOG.debug("now = {}", now);
		
		int year = now.getYear();
		LOG.debug("year = {}", year);
		
		int month = now.getMonth().getValue();
		LOG.debug("mont = {}", month);
		
		int day = now.getDayOfMonth();
		LOG.debug("day = {}", day);
		
		LOG.debug("---------------------------------------------------------");
		
		LocalDate today = LocalDate.now();
		LOG.debug("today = {} ~ {}", today, today.plusDays(1));
		LOG.debug("yesterday = {} ~ {}", today.minusDays(1), today);
		
		LocalDate lastMonth = today.minusMonths(1); 
		LOG.debug("last-month = {} ~ {}", LocalDate.of(lastMonth.getYear(), lastMonth.getMonthValue(), 1), LocalDate.of(today.getYear(), today.getMonthValue(), 1));
		
		LocalDate lastYear = today.minusYears(1);
		LOG.debug("last-year = {} ~ {}", LocalDate.of(lastYear.getYear(), 1, 1), LocalDate.of(today.getYear(), 1, 1));
		
	}
}
