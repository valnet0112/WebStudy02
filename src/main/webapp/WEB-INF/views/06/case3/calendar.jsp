<%@page import="kr.or.ddit.vo.CalendarVO"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.stream.Stream"%>
<%@page import="java.time.Month"%>
<%@page import="java.util.Optional"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.TextStyle"%>
<%@page import="java.time.DayOfWeek"%>
<%@page import="java.time.temporal.WeekFields"%>
<%@page import="java.time.YearMonth"%>
<%@page import="java.time.ZonedDateTime"%>
<%@page import="java.util.Locale"%>
<%@page import="java.time.format.FormatStyle"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CalendarVO calVO = (CalendarVO)request.getAttribute("calendar");
	YearMonth beforeMonth = calVO.getBeforeMonth();
	ZonedDateTime current = calVO.getCurrent();
	LocalDate firstDate = calVO.getFirstDate();
	DayOfWeek firstDOW = calVO.getFirstDOW();
	FormatStyle fullStyle = calVO.getFormatStyle();
	Locale locale = calVO.getLocale();
	YearMonth nextMonth = calVO.getNextMonth();
	int offset = calVO.getOffset();
	YearMonth thisMonth = calVO.getThisMonth();
	
%>   

 
<h4><%=current.format(DateTimeFormatter.ofLocalizedDateTime(fullStyle, fullStyle).withLocale(locale)) %></h4>
<h4>

<a class="control-a" href="javascript:;" data-year="<%=beforeMonth.getYear() %>" data-month="<%=beforeMonth.getMonthValue()%>">전달</a>

<%=thisMonth.format(DateTimeFormatter.ofPattern("yyyy, MMMM", locale)) %>

<a class="control-a" href="javascript:;" data-year="<%=nextMonth.getYear() %>" data-month="<%=nextMonth.getMonthValue()%>">다음달</a>

</h4>


<table class="clz1 clz2">
<%
out.println("<thead>");
for(int col=0; col<7; col++){
	DayOfWeek tmp = firstDOW.plus(col);
	out.println(
		String.format("<th>%s</th>", tmp.getDisplayName(TextStyle.FULL, locale))	
	);
}
out.println("</thead>");
out.println("<tbody>");
LocalDate tmpDate = firstDate.minusDays(offset);
for(int row=1; row<=6; row++){
	out.println("<tr>");
	for(int col=1; col<=7; col++){
		YearMonth tmpMonth = YearMonth.from(tmpDate);
		String clz = tmpMonth.isBefore(thisMonth) ? "before" :
						tmpMonth.isAfter(thisMonth) ? "after" : "this-month";
		clz += " " + tmpDate.getDayOfWeek().name().toLowerCase();
		out.println(
			String.format("<td class='%2$s'>%1$d</td>", tmpDate.getDayOfMonth(), clz)	
		);
		tmpDate = tmpDate.plusDays(1);
	}
	out.println("</tr>");
}
out.println("</tbody>");
%>
</table>
