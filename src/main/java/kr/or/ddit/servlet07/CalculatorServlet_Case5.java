package kr.or.ddit.servlet07;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.enumpkg.MediaType;
import kr.or.ddit.enumpkg.OperatorType;
import kr.or.ddit.vo.CalculatorVO;

@WebServlet("/07/case5/calculator.do")
public class CalculatorServlet_Case5 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int status = validate(req);
		
		if(status == HttpServletResponse.SC_OK) {
			// 마샬링, 직렬화
			resp.setContentType(MediaType.APPLICATION_JSON_VALUE);
			CalculatorVO calVO =  (CalculatorVO) req.getAttribute("calculator");
			try(
					PrintWriter writer = resp.getWriter();
			){
				new ObjectMapper().writeValue(writer, calVO);
			}
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











