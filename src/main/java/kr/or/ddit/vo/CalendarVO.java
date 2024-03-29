package kr.or.ddit.vo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.time.format.FormatStyle;
import java.util.Locale;

public class CalendarVO {
	private YearMonth thisMonth;
	private YearMonth beforeMonth;
	private YearMonth nextMonth;
	
	private Locale locale;
	private ZonedDateTime current;
	
	private FormatStyle formatStyle;
	
	private int offset;
	private DayOfWeek firstDOW;
	
	private LocalDate firstDate;

	public YearMonth getThisMonth() {
		return thisMonth;
	}

	public void setThisMonth(YearMonth thisMonth) {
		this.thisMonth = thisMonth;
	}

	public YearMonth getBeforeMonth() {
		return beforeMonth;
	}

	public void setBeforeMonth(YearMonth beforeMonth) {
		this.beforeMonth = beforeMonth;
	}

	public YearMonth getNextMonth() {
		return nextMonth;
	}

	public void setNextMonth(YearMonth nextMonth) {
		this.nextMonth = nextMonth;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public ZonedDateTime getCurrent() {
		return current;
	}

	public void setCurrent(ZonedDateTime current) {
		this.current = current;
	}

	public FormatStyle getFormatStyle() {
		return formatStyle;
	}

	public void setFormatStyle(FormatStyle formatStyle) {
		this.formatStyle = formatStyle;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public DayOfWeek getFirstDOW() {
		return firstDOW;
	}

	public void setFirstDOW(DayOfWeek firstDOW) {
		this.firstDOW = firstDOW;
	}

	public LocalDate getFirstDate() {
		return firstDate;
	}

	public void setFirstDate(LocalDate firstDate) {
		this.firstDate = firstDate;
	}
	
	
}
