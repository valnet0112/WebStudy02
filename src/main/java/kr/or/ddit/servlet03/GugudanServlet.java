package kr.or.ddit.servlet03;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/case4/gugudan.do")
public class GugudanServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String minParam = request.getParameter("minDan");
		String maxParam = request.getParameter("maxDan");
		int status = 200;
		int minDan = 2;
		if(minParam!=null && !minParam.trim().isEmpty()){
			try{
				minDan = Integer.parseInt(minParam);
			}catch(NumberFormatException e){
				status = 400;
			}
		}
		int maxDan = 13;
		if(maxParam!=null && !maxParam.trim().isEmpty()){
			try{
				maxDan = Integer.parseInt(maxParam);
			}catch(NumberFormatException e){
				status = 400;
			}
		}
		
		if(status!=200){
			response.sendError(status);
			return;
		}
		
		request.setAttribute("minDan", minDan);
		request.setAttribute("maxDan", maxDan);
		
		String view = "/WEB-INF/views/02/gugudan.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}
}













