package kr.or.ddit.servlet02;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * 클라이언트의 요청이 처리되는 단계
 * 1. 요청을 접수
 * 2. 요청한 데이터 생성
 * 3. 데이터를 컨텐츠로 만들고, 응답으로 전송
 * 
 * Model1 아키텍처 : 1~3단계가 하나의 서블릿이나 JSP 에 의해 처리되는 구조.
 * Model2 아키텍처 : 1~2단계의 처리 객체와 3단계의 처리 객체가 분리된 구조.
 *
 */
@WebServlet("/now_case4.do")
public class NowServlet_Case4 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("today", LocalDate.now());
		req.setAttribute("now", LocalDateTime.now());
		
		req.getRequestDispatcher("/01/nowView.c41").forward(req, resp);
	}
}










