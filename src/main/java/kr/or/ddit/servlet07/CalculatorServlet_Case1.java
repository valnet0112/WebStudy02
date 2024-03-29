package kr.or.ddit.servlet07;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.enumpkg.OperatorType;
import kr.or.ddit.vo.CalculatorVO;

@WebServlet("/07/case1/calculator.do")
public class CalculatorServlet_Case1 extends HttpServlet {
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











