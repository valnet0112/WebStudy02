package kr.or.ddit.servlet04;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.enumpkg.MediaType;

/**
 * Model2 아키텍처
 *  : SRP(단일 책임의 원칙)에 따라 request 에 대한 처리자와 response 처리자를 분리하는 구조.
 *  
 *   MVC(Model View Controller) : 하나의 어플리케이션을 구조화할때 역할별로 3개 이상의 레이어를 분리하는 구조.
 *   
 *   request(Model + Controller) / response(View)
 *
 */
@WebServlet("/case2/factorial.do")
public class FactorialServlet extends HttpServlet{
	long factorial(int operand){
		if(operand<=0){
			throw new IllegalArgumentException("팩토리얼 연산은 양수만 처리 가능.");
		}
		if(operand==1){
			return 1;
		}else{
			return operand*factorial(operand-1);
		}
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int status = 200;
		String message = null;
		String accept = request.getHeader("accept");
		String param = request.getParameter("operand");
		if(param==null || param.trim().isEmpty() || !param.matches("\\d{1,3}")){
			status = HttpServletResponse.SC_BAD_REQUEST;
			message = "필수 파라미터가 누락됐거나, 파라미터의 데이터타입이 정상적이지 않음.";
		}else {
			int operand = Integer.parseInt(param);
			try{
				long result = factorial(operand);
				// 	for(int tmp = operand; tmp >= 1; tmp--){
				// 		result *= tmp;
				// 	}
				String expression = MessageFormat.format("{0} != {1}", operand, result);
				request.setAttribute("expression", expression);
			}catch(IllegalArgumentException e){
				status = HttpServletResponse.SC_BAD_REQUEST;
				message = e.getMessage();
			}
		}
		
		if(status==200) {
			if(accept.contains("json")) {
				response.setContentType(MediaType.APPLICATION_JSON.getMimeType());
				String expression = (String) request.getAttribute("expression");
				// marshalling : native 언어로 표현된 데이터를 공통 메시지 교환 형식(xml, json)으로 변환하는 작업.
				String jsonContent = String.format("{\"%s\":\"%s\"}", "expression", expression);
				try(
					PrintWriter out = response.getWriter();
				){
					out.print(jsonContent);
				}
			}else {
				String view = "/WEB-INF/views/03/factorial.jsp";
				request.getRequestDispatcher(view).forward(request, response);
			}
		}else {
			response.sendError(status, message);
		}
	}
}












