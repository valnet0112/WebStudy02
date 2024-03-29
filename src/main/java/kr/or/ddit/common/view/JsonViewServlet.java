package kr.or.ddit.common.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import kr.or.ddit.enumpkg.MediaType;

/**
 * JSON response content 를 전송하는 view layer
 *
 */
@WebServlet("/jsonView.do")
public class JsonViewServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType(MediaType.APPLICATION_JSON_VALUE);
		
		ObjectMapper objectMapper = new ObjectMapper()
									.registerModule(new JavaTimeModule())
									.disable(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS)
									.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		
		Map<String, Object> nativeData = new HashMap<>();
		Enumeration<String> attrNames = req.getAttributeNames();
		while (attrNames.hasMoreElements()) {
			String modelName = (String) attrNames.nextElement();
			Object model = req.getAttribute(modelName);
			nativeData.put(modelName, model);
		}
		
		try(
			PrintWriter out = resp.getWriter();	
		){
			objectMapper.writeValue(out, nativeData);
		}
	}
}


















