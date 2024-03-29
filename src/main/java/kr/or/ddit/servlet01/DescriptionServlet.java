package kr.or.ddit.servlet01;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 서블릿 스펙
 * 	: 웹상에서 발생하는 요청을 받고, 그에 대한 동적인 응답을 생성할 수 있는 객체의 요건 --> HttpServlet.
 * 
 * 개발 단계
 * 1. HttpServlet 상속 클래스 구현.
 * 2. doXXX callback 메소드 재정의
 * $("#example").on("click", function(event){alert(message);})
 * 	서블릿의 callback 메소드 종류
 *  1) lifecycle callback : init, destroy - 컨테이너가 기본적으로 싱글턴으로 객체를 관리하므로 어플리케이션 내에서 한번 실행됨.
 *  		init : 특별한 설정(loadOnStartup)이 없는한 최초의 요청이 발생하면 실행됨.
 *  2) request callback : 
 *  	service : 컨테이너에 의해 직접 호출되는 callback 
 *  	doXXX : service 메소드내에서 현재 요청의 method 를 판단한 후 실행되는 분기 메소드.
 * 
 * 3. 서블릿 등록.
 * 		web.xml : servlet->servlet-name(simple name), servlet-class(qualified name)
 * 4. 서블릿 매핑.
 * 		web.xml : servlet-mapping->serlvet-name, url-pattern
 * 
 * 5. 서버 재구동
 * 
 * ** 서블릿 스펙에서 제공되는 객체의 종류
 * 1. HttpServletRequest : client 와 요청에 대한 모든 정보를 캡슐화한 객체.
 * 2. HttpServletResponse : 서버에서 client 로 전송되는 모든 정보를 캡슐화한 객체.
 * 			ex) response content, content metadata(response header)
 * 3. ServletConfig : 하나의 서블릿에 대한 설정 정보를 캡슐화한 객체. 서블릿 하나당 하나씩 인스턴스가 존재함.
 * 4. ServletContext : 현재 실행중인 어플리케이션과 서버에 대한 정보를 캡슐화한 객체로, 어플리케이션 내에 하나의 싱글턴 인스턴스만 존재함.
 * 5. HttpSession : 한사람의 클라이언트 혹은 하나의 에이전트에 대한 고유 정보를 캡슐화한 객체. 
 * 
 *
 */
public class DescriptionServlet extends HttpServlet{
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String value = config.getInitParameter("dummy");
		System.out.printf("%s 초기화 되었음., param value : %s \n", this.getClass().getName(), value);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("=======================================");
		System.out.println("super.service 이전 코드");
//		super.service(req, resp);
		System.out.println("super.service 이후 코드");
		System.out.println("=======================================");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 메소드 실행");
		resp.getWriter().println("desc servlet");
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.printf("%s 소멸 되었음.\n", this.getClass().getName());
	}
	
}













