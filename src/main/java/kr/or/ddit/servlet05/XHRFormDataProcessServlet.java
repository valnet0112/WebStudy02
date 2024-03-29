package kr.or.ddit.servlet05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.enumpkg.MediaType;

@WebServlet("/05/formDataProcess.do")
public class XHRFormDataProcessServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		req.getParameterMap().forEach((k,v)->{
			System.out.printf("%s : %s\n", k, Arrays.toString(v));
		});
		Map<String, String[]> paramterMap = req.getParameterMap();
		String html = paramterMap.entrySet().stream()
											.map(en->String.format("%s : %s\n", en.getKey(), Arrays.toString(en.getValue())))
											.collect(Collectors.joining("\n"));
		resp.setContentType(MediaType.TEXT_HTML_VALUE);
		try(
			PrintWriter out = resp.getWriter();	
		){
			out.print(html);
		}
	}
}












