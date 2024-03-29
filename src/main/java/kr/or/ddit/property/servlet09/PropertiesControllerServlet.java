package kr.or.ddit.property.servlet09;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Properties;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import kr.or.ddit.property.dao.InMemoryPropertyDAOImpl;
import kr.or.ddit.property.dao.PropertyDAO;
import kr.or.ddit.property.service.PropertyService;
import kr.or.ddit.property.service.PropertyServiceImpl;
import kr.or.ddit.servlet08.ServerTimeServlet;
import kr.or.ddit.vo.PropertyVO;

/**
 * 요청의 목적 : 서버사이드의 자원을 대상으로 어떤 행위를 수행하기 위함.
 * 	자원의 식별(명사) : URI
 *  어떤 행위(동사) : request method
 * 
 * RESTful URI 구조 표현
 *  /09/property GET : 전체 조회
 *  /09/property/fail.common.msg GET : 한건 조회
 *  /09/property POST : 등록
 *  /09/property/fail.common.msg PUT : 한건 수정
 *  /09/property/fail.common.msg DELETE : 한건 삭제
 *  /09/property DELETE : 전체 삭제
 *
 */
@WebServlet({"/09/property", "/09/property/*"})
public class PropertiesControllerServlet extends HttpServlet{
	private PropertyService service = new PropertyServiceImpl();
	
	private int list(HttpServletRequest req) {
		Function<PropertyVO, String> resolve = PropertyVO::getPropertyName;
		Set<String> keySet= service.retrieveKeySet();
		req.setAttribute("keySet", keySet);
		return 200;
	}
	private int single(String propertyName, HttpServletRequest req){
			PropertyVO property = service.retrieveProperty(propertyName);
			int status = 200;
			if(property==null) {
				status = 404;
			}else {
				req.setAttribute("property", property);
			}
			return status;
	}
	
	private String getPropertyName(HttpServletRequest req) throws UnsupportedEncodingException {
		String propertyName = null;
		String requestURI = req.getRequestURI(); // ex) /WebStudy01/09/property, /WebStudy01/09/property/code
		
		String regex = "\\S*/09/property/(\\S+)";
		Pattern ptrn = Pattern.compile(regex);
		Matcher matcher = ptrn.matcher(requestURI);
		
		if(matcher.find()) {
			propertyName = URLDecoder.decode(matcher.group(1), "UTF-8");
		}
		return propertyName;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String propertyName = getPropertyName(req);
		int status;
		if(propertyName!=null) {
			status = single(propertyName, req);
		}else {
			status = list(req);
		}
		
		if(status==200) {
			String view = "/jsonView.do";
			req.getRequestDispatcher(view).forward(req, resp);
		}else {
			resp.sendError(status);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(
			InputStream is = req.getInputStream();
		){
			PropertyVO newProp = new ObjectMapper().readValue(is, PropertyVO.class);
			boolean success = service.createProperty(newProp);
			if(success) {
				resp.sendRedirect(req.getContextPath() + "/09/property");
			}else {
				
			}
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(
			InputStream is = req.getInputStream();
		){
			PropertyVO modifyProp = new ObjectMapper().registerModule(new JavaTimeModule()).readValue(is, PropertyVO.class);
			boolean success = service.updateProperty(modifyProp);
			req.setAttribute("success", success);
			String view = "/jsonView.do";
			req.getRequestDispatcher(view).forward(req, resp);
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String propertyName = getPropertyName(req);
		int status;
		if(propertyName!=null) {
			boolean success = service.deleteProperty(propertyName);
			req.setAttribute("success", success);
			String view = "/jsonView.do";
			req.getRequestDispatcher(view).forward(req, resp);
		}else {
			resp.sendError(400);
		}
	}
}

















