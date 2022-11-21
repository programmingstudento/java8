package com.study;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class DateLearn {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2019, 10, 1);
		int day = date.getDayOfMonth();
		Month month = date.getMonth();
		int year = date.getYear();
		DayOfWeek weekday = date.getDayOfWeek();
		System.out.println(date + " " + day + " " + month + " " + year + " " + weekday);
		System.out.println(date.get(ChronoField.YEAR) + " " + date.get(ChronoField.MONTH_OF_YEAR) + " "
				+ date.get(ChronoField.DAY_OF_MONTH) + " " + date.getLong(ChronoField.PROLEPTIC_MONTH));

		LocalTime localTime = LocalTime.parse("09:20:20");
		System.out.println(localTime.get(ChronoField.HOUR_OF_AMPM) + " " + localTime.get(ChronoField.MINUTE_OF_HOUR)
				+ " " + localTime.get(ChronoField.SECOND_OF_MINUTE));

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM YY", Locale.ENGLISH);
		System.out.println(dateTimeFormatter.format(date));

		LocalDateTime.now();
		LocalDateTime one = LocalDateTime.now(ZoneId.of("Singapore"));
		System.out.println(one);

		ZoneId.getAvailableZoneIds().forEach(System.out::println);
	}
}
