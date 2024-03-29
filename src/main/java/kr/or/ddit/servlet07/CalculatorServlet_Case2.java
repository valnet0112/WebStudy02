package kr.or.ddit.servlet07;

import java.io.IOException;
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

/**
 * 응답을 JSON 으로 전송하기 위해 , Marshalling , Serialization 필요함.
 *
 */
@WebServlet("/07/case2/calculator.do")
public class CalculatorServlet_Case2 extends HttpServlet {
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
		String left = req.getParameter("left");
		String right = req.getParameter("right");
		String operator = req.getParameter("operator");
		int status = HttpServletResponse.SC_OK;
		
		try {
			double leftOp = Double.parseDouble(left);
			double rightOp = Double.parseDouble(right);
			OperatorType operatorType = OperatorType.valueOf(operator);
			
			CalculatorVO calVO = new CalculatorVO(leftOp, rightOp, operatorType);
			req.setAttribute("calculator", calVO);
		}catch (Exception e) {
			status = HttpServletResponse.SC_BAD_REQUEST;
		}
		return status;
	}
}











