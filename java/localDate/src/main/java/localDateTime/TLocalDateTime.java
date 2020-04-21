package localDateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TLocalDateTime {

	private static final Logger LOG = LoggerFactory.getLogger(TLocalDateTime.class);
	
	public static void main(String[] args) {
		new TLocalDateTime().localDateTime();
	}

	private void localDateTime() {
		
		LocalDateTime today = LocalDateTime.now();
		LOG.debug("today = {} ~ {}", today, today.plusDays(1));
		LOG.debug("yesterday = {} ~ {}", today.minusDays(1), today);
		
		LocalDateTime lastMonth = today.minusMonths(1); 
		LOG.debug("last-month = {} ~ {}", LocalDate.of(lastMonth.getYear(), lastMonth.getMonthValue(), 1), LocalDateTime.of(today.getYear(), today.getMonthValue(), 1, 0, 0));
		
		LocalDateTime lastYear = today.minusYears(1);
		LOG.debug("last-year = {} ~ {}", LocalDate.of(lastYear.getYear(), 1, 1), LocalDateTime.of(today.getYear(), 1, 1, 0, 0));
	}
}