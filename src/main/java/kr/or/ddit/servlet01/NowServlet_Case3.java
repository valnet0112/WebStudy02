package kr.or.ddit.servlet01;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/now_case3.do")
public class NowServlet_Case3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentLength(5);
//		resp.setCharacterEncoding("UTF-8");
		//MIME(~Extension) : 파일의 확장자로부터 파일의 종류를 유추하는 방식을 미디어 서비스의 전송 컨텐츠의 종류를 표현하는 문자열.
//			MAIN_TYPE/SUB_TYPE;charset=encoding , ex) text/html, text/javascript, application/json, application/xml
		String mime = "text/html;charset=UTF-8";
		resp.setContentType(mime);
		StringBuffer html = new StringBuffer();
		html.append("<html>");
		html.append("<body>");
		html.append(String.format("<h4>오늘 날짜 : %s</h4>", LocalDate.now()));
		html.append(String.format("<h4>현재 시각 : %s</h4>", LocalDateTime.now()));
		html.append("</body>");
		html.append("</html>");
		resp.getWriter().print(html);
	}
}
