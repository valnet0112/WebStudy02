package kr.or.ddit.miles;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 페이지 모듈화 구조에서 일정한 레이아웃이 반복적으로 적용되는 경우를 해결하는 프레임워크
 * *.miles 형태의 확장자 매핑을 이용해서 요청 분기구조 형태로 이동하는 뷰를 일괄적으로 처리.
 *
 */
@WebServlet("*.miles")
public class MilesDispatcherServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String regex =req.getContextPath() + "/(\\S+).miles";    // \\s 문자하나 \\S 공백이아닌문자
				
		String uri = req.getRequestURI();
		
		Pattern regexp =  Pattern.compile(regex);
		Matcher matcher = regexp.matcher(uri);
		if(matcher.find()) {
			String logicalViewName = matcher.group(1);
			String viewPath =  "/WEB-INF/views/" + logicalViewName + ".jsp";
			req.setAttribute("contentPage", viewPath);
			req.getRequestDispatcher("/WEB-INF/views/layout.jsp").forward(req, resp);
		}else {
			resp.sendError(404, " 실제 뷰 레이어를 검색하지 못했다.");
		}
		
	}
}
