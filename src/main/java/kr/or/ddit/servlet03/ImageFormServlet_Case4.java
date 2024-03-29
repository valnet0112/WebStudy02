package kr.or.ddit.servlet03;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
@WebServlet("/case4/imageForm.do")
public class ImageFormServlet_Case4 extends HttpServlet{
	private ServletContext application;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application = getServletContext();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html;charset=UTF-8");
		
		
		
		
		
		String imageFolderPath = application.getInitParameter("imageFolderPath");
		File imageFolder = new File(imageFolderPath);
		
		File[] imageFiles = imageFolder.listFiles((d,n)->
			Optional.ofNullable(application.getMimeType(n))
					.filter((m)->m.startsWith("image/"))
					.isPresent()
		);
		

		String cPath = req.getContextPath();
		
		String options = Stream.of(imageFiles)
								.map(f->String.format("<option value='%1$s'>%1$s</option>", f.getName()))
								.collect(Collectors.joining("\n"));
		
		req.setAttribute("cPath", cPath);
		req.setAttribute("options", options);
		
		req.getRequestDispatcher("/02/imageForm.jsp").forward(req, resp);
	}

}











