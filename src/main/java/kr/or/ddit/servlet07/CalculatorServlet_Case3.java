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
@WebServlet("/07/case3/calculator.do")
public class CalculatorServlet_Case3 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int status = validate(req);
		String accept = req.getHeader("accept");
		
		if(status == HttpServletResponse.SC_OK) {
			String view = null;
			if(accept.contains("json")) {
				view = "/jsonView.do";
			}else {
				view = "/WEB-INF/views/07/calculateView.jsp";
			}
			req.getRequestDispatcher(view).forward(req, resp);	
			
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











