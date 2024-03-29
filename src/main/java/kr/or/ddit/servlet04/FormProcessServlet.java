package kr.or.ddit.servlet04;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/04/formProcess.do")
public class FormProcessServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Enumeration<String> paramNames = req.getParameterNames();
		Map<String, String[]> paramterMap = req.getParameterMap();
		System.out.println("===========case1=================");
		for(Entry<String, String[]>  entry : paramterMap.entrySet()) {
			String paramName = entry.getKey();
			String[] paramValues = entry.getValue();
			System.out.printf("%s : %s\n", paramName, Arrays.toString(paramValues));
		}
		
		System.out.println("===========case2=================");
		paramterMap.forEach((k,v)->System.out.printf("%s : %s\n", k, Arrays.toString(v)));
		
		System.out.println("===========case3=================");
		String textParam = req.getParameter("textParam");
		int numParam = Optional.ofNullable(req.getParameter("numParam"))
										.map(np->new Integer(np))
										.orElse(-1);
		System.out.printf("number param : %d\n", numParam);
		LocalDate dateParam = Optional.ofNullable(req.getParameter("dateParam"))
										.map(dp->LocalDate.parse(dp))
										.orElseThrow(()->new RuntimeException("data parameter 누락"));
		System.out.printf("date param : %s\n", dateParam);
		LocalDateTime dateTimeParam = Optional.ofNullable(req.getParameter("dateTimeParam"))
										.map(dtp->LocalDateTime.parse(dtp))
										.orElseGet(()->LocalDateTime.now());
		System.out.printf("date time param : %1$tY-%1$tM-%1$td %1$tH:%1$tm \n", dateTimeParam);
		
		String[] checkbox = req.getParameterValues("checkbox");
	}
}

















