package kr.or.ddit.servlet07;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.enumpkg.OperatorType;
import kr.or.ddit.vo.CalculatorVO;

@WebServlet("/07/case4/calculator.do")
public class CalculatorServlet_Case4 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int status = validate(req);
		
		if(status == HttpServletResponse.SC_OK) {
			String view = "/WEB-INF/views/07/calculateView.jsp";
			req.getRequestDispatcher(view).forward(req, resp);			
		}else {
			resp.sendError(status);
		}
	}

	private int validate(HttpServletRequest req) {
		
		int status = HttpServletResponse.SC_OK;
		
		try(
			InputStream is = req.getInputStream();	
		) {
			// 역직렬화, 언마샬링
			ObjectMapper objectMapper = new ObjectMapper();
			CalculatorVO calVO = objectMapper.readValue(is, CalculatorVO.class);
			
			req.setAttribute("calculator", calVO);
		}catch (Exception e) {
			status = HttpServletResponse.SC_BAD_REQUEST;
		}
		return status;
	}
}











