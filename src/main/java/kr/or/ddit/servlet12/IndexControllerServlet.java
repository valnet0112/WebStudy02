package kr.or.ddit.servlet12;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index.do")
public class IndexControllerServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * String contentPage = "/WEB-INF/views/index.jsp";
		 * 
		 * req.setAttribute("contentPage", contentPage);
		 * 
		 * String view = "/WEB-INF/views/layout.jsp";
		 * req.getRequestDispatcher(view).forward(req, resp);
		 */
		String logicalViewName = "index";
		req.getRequestDispatcher("/"+logicalViewName+".miles").forward(req, resp);
	}
}
