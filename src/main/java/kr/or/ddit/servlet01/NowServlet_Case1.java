package kr.or.ddit.servlet01;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 클라이언트가 /now.do 라는 요청을 보냈을때, 
 * 현재 서버의 시각을 <h4> 태그로 보여주는 컨텐츠를 구성할 것.
 */
@WebServlet("/now_case1.do")
public class NowServlet_Case1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String html = "<html><body><h4>"+ new Date() +"</h4></body></html>";
		resp.getWriter().print(html);
	}

}












