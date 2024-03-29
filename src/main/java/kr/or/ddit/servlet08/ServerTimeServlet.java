package kr.or.ddit.servlet08;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import kr.or.ddit.enumpkg.MediaType;

@WebServlet("/08/serverTime.do")
public class ServerTimeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setIntHeader("Refresh", 1); // 비동기 요청에서는 의미 없음.
		
		ZonedDateTime model = ZonedDateTime.now();
		Locale locale = req.getLocale();
		
		req.setAttribute("now", model);
		String view = "/jsonView.do";
		req.getRequestDispatcher(view).forward(req, resp);
	}
}

















