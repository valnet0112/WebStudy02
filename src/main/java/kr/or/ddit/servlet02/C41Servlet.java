package kr.or.ddit.servlet02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@WebServlet("*.c41")
public class C41Servlet extends HttpServlet{
	private ServletContext application;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application = getServletContext();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html;charset=UTF-8");
		
		try {
			String templateSource = readTemplate(req);
			StringBuffer html = new StringBuffer();
			
			html.append(mergeDataAndTemplate(req, templateSource));
			
			try(
					PrintWriter out = resp.getWriter();
			){
				out.println(html);
			}
		}catch (FileNotFoundException e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
		}
		
	}

	private String mergeDataAndTemplate(HttpServletRequest req, String templateSource) {
		// Collection View
		Enumeration<String> names = req.getAttributeNames();
		while (names.hasMoreElements()) {
			String key = (String) names.nextElement();
			templateSource = templateSource.replace("#"+key+"#", req.getAttribute(key).toString());
			
		}
		
		return templateSource;
	}

	private String readTemplate(HttpServletRequest req) throws FileNotFoundException, IOException, ServletException {
		// /WebStudy01/01/sample.c41
		String tmplUrl = req.getRequestURI();
		
		System.out.printf("servlet path : %s\n", req.getServletPath());
		System.out.printf("request URI : %s\n", req.getRequestURI());
		
		String contextPath = getServletContext().getContextPath();
		String regex = contextPath + "([\\w_/]+)" + "\\.c41";
		Pattern regexp = Pattern.compile(regex);
		Matcher matcher = regexp.matcher(tmplUrl);
		
		if(matcher.find()) {
			String filePathPart = matcher.group(1);
			tmplUrl = filePathPart+".c41";
			
			// d:/~~~~~/01/imageFormsfasdf.c41
			String tmplFSPath = getServletContext().getRealPath(tmplUrl);
			File templateFile = new File(tmplFSPath);
			
			if(!templateFile.exists()) {
				throw new FileNotFoundException(String.format(" %s 파일 없다.", tmplUrl));
			}
			
			try(
					FileReader reader = new FileReader(templateFile);
					BufferedReader br = new BufferedReader(reader);
			){
				String tmp = null;
				StringBuffer template = new StringBuffer();
				while((tmp=br.readLine())!=null) {
					template.append(tmp);
					template.append("\n");
				}
				return template.toString();
			} // try end
		} else {
			throw new ServletException("정규식을 파싱해서 c41 파일의 위치를 찾는 과정의 예외 발생");
		}// if(matcher.find()) end
	}                                                             
}











