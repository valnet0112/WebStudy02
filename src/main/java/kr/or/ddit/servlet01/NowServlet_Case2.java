package kr.or.ddit.servlet01;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/now_case2.do")
public class NowServlet_Case2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String html = "<html>";
		html += "<body>";
		html += "<h4>"+ new Date() +"</h4>";
		html += "</body>";
		html += "</html>";
		resp.getWriter().print(html);
	}
}
