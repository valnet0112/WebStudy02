package kr.or.ddit.servlet06;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.FormatStyle;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.vo.CalendarVO;

/**
 * Model2 + MVC
 *  serlvet (Model+Controller : request 처리자)
 *  	1. 요청을 받고, - @WebServlet (web.xml servlet-mapping)
 *  	2. 요청을 분석하고, 검증. (request line, header, body)..
 *  	3. Model 생성
 *  	4. Model을 전달 및 공유 - setAttribute(name, value)
 *  	5. view layer 선택 
 *  	6. 제어의 이동(controller -> view) - forward
 *  jsp (View : response 처리자)
 *  	1. Model 확보 - getAttribute(name)
 *  	2. model 을 content 로..
 *
 */
@WebServlet
public class CalendarServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/WEB-INF/views/06/case3/calendarForm.jsp";
		req.getRequestDispatcher(view).forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Locale locale = Optional.ofNullable(request.getParameter("locale"))
				.filter(lp->!lp.trim().isEmpty())
				.map(lp->Locale.forLanguageTag(lp))
				.orElse(Locale.getDefault());

		ZoneId zone = ZoneId.systemDefault();
		
		//LocalDateTime current = LocalDateTime.now(zone);
		ZonedDateTime current = ZonedDateTime.now(zone);
		FormatStyle fullStyle = FormatStyle.FULL;
		
		
		int targetYear = Optional.ofNullable(request.getParameter("year"))
						.map(yp->new Integer(yp))
						.orElse(YearMonth.from(current).getYear());
		YearMonth thisMonth = Optional.ofNullable(request.getParameter("month"))
						.map(mp->YearMonth.of(targetYear, Integer.parseInt(mp)))
						.orElse(YearMonth.from(current));
		
		YearMonth beforeMonth = thisMonth.minusMonths(1);
		YearMonth nextMonth = thisMonth.plusMonths(1);
		
		WeekFields weekFields = WeekFields.of(locale);
		DayOfWeek firstDOW = weekFields.getFirstDayOfWeek();
		LocalDate firstDate = thisMonth.atDay(1);
		int firstDateDOW = firstDate.get(weekFields.dayOfWeek());
		int offset = firstDateDOW - 1;
		
		CalendarVO calVO = new CalendarVO();
		calVO.setBeforeMonth(beforeMonth);
		calVO.setCurrent(current);
		calVO.setFirstDate(firstDate);
		calVO.setFirstDOW(firstDOW);
		calVO.setFormatStyle(fullStyle);
		calVO.setLocale(locale);
		calVO.setNextMonth(nextMonth);
		calVO.setOffset(offset);
		calVO.setThisMonth(thisMonth);
		
		request.setAttribute("calendar", calVO);
		String view = "/WEB-INF/views/06/case3/calendar.jsp";
		request.getRequestDispatcher(view).forward(request, response);		
	}
}







