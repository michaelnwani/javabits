// brand new date and time API under the java.time package.
// built on the Joda-Time library
import java.time.*;
import java.time.temporal.*;
import java.time.format.*;
import java.util.Date;
import java.util.Locale;
public class DateClient {
	public static void main(String[] args) {
		
		// lots of static Factory methods
		
		Clock clock = Clock.systemDefaultZone();
		long millis = clock.millis();
		
		// Instant's represent an Instantaneous point in time
		// (e.g. the Unix EPOCH)
		// can also be used to create the old legacy Date objects
		Instant instant = clock.instant();
		Date legacyDate = Date.from(instant); // legacy java.util.Date;
		
		// Timezones are represented by a ZoneId
		// prints all available timezone ids
		System.out.println(ZoneId.getAvailableZoneIds());
		
		ZoneId zone1 = ZoneId.of("Europe/Berlin");
		ZoneId zone2 = ZoneId.of("Brazil/East");
		System.out.println(zone1.getRules());
		System.out.println(zone2.getRules());
		
		// LocalTime represents a time without a timezone
		LocalTime now1 = LocalTime.now(zone1);
		LocalTime now2 = LocalTime.now(zone2);
		
		System.out.println(now1.isBefore(now2)); // 'false'
		
		long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
		long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
		
		System.out.println(hoursBetween);   // '-3'
		System.out.println(minutesBetween); // '-239'
		
		LocalTime late = LocalTime.of(23, 59, 59);
		System.out.println(late); // '23:59:59'
		
		DateTimeFormatter germanFormatter = 
			DateTimeFormatter
				.ofLocalizedTime(FormatStyle.SHORT)
				.withLocale(Locale.GERMAN);
		
		LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
		System.out.println(leetTime); // '13:37'
		
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
		LocalDate yesterday = tomorrow.minusDays(2);
		
		LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
		DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
		System.out.println(dayOfWeek); // 'FRIDAY'
		
		// parsing a LocalDate from a string
		germanFormatter = 
			DateTimeFormatter
				.ofLocalizedDate(FormatStyle.MEDIUM)
					.withLocale(Locale.GERMAN);
		
		LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
		System.out.println(xmas); // 2014-12-24
		
		//LocalDateTime represents a date-time; works similar to LocalTime
		// + LocalDate
		LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
		dayOfWeek = sylvester.getDayOfWeek();
		System.out.println(dayOfWeek);		// 'WEDNESDAY'
		
		Month month = sylvester.getMonth();
		System.out.println(month);			// 'DECEMBER'
		
		long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
		System.out.println(minuteOfDay);	// '1439'
		
		instant = sylvester.atZone(ZoneId.systemDefault()).toInstant();
		legacyDate = Date.from(instant);
		System.out.println(legacyDate); 	// 'Wed Dec 31 23:59:59 CET 2014'
		
		DateTimeFormatter formatter = 
			DateTimeFormatter.ofPattern("MMM dd, yyyy - HH:mm");
		LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
		String string = formatter.format(parsed);
		System.out.println(string);			// 'Nov 03, 2014 - 07:13'
	}
}






