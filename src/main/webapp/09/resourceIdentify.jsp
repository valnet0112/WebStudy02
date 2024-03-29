<%@page import="kr.or.ddit.servlet08.ServerTimeServlet"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>09/resourceIdentify.jsp</title>
</head>
<body>
<h4>자원의 종류와 종류에 따른 식별 방법</h4>
<pre>
	자원의 위치와 접근 방법에 따라 3가지 분류.
	1. file system resource : 파일시스템상의 절대경로(물리경로)를 사용해서 접근 가능.
		ex) D:\01.medias\images\ala.jpg
		<%
			File fsRes = new File("D:\\01.medias\\images\\ala.jpg");
			out.println(fsRes.length());
		%>
	2. web resource : URL 이라는 논리 주소의 형태로 접근 가능.
		ex) https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png
		ex) http://localhost/WebStudy01/resources/images/ala.jpg
									  /resources/images/ala.jpg
		<%
			String logicalPath = "/resources/images/ala.jpg";
			String realPath = application.getRealPath(logicalPath);
			out.println("real path : "+realPath);
			File webRes = new File(realPath);
			out.println(webRes.length());
		%>							  
	3. classpath resource : classpath 이후의 경로부터 시작되는 qualified name 의 형태로 접근 가능.
		ex) kr/or/ddit/images/ala.jpg
		<%
			//A a = new A();
// 			logicalPath = "kr/or/ddit/images/ala.jpg";
// 			ClassLoader classLoader = ClassLoader.getSystemClassLoader();
// 			ClassLoader classLoader = ServerTimeServlet.class.getClassLoader();
// 			URL url = classLoader.getResource(logicalPath);
			logicalPath = "/kr/or/ddit/images/ala.jpg";
			URL url = ServerTimeServlet.class.getResource(logicalPath);
			out.println(url);
			File cpRes = new File(url.toURI());
			out.println(cpRes.length());
		%>
</pre>
<h4>URI vs URL</h4>
URI (Uniform Resource Identifier) : 자원의 식별방법
URL (Uniform Resource Locator) : 자원을 식별할때 위치를 기준으로 식별하는 방식.
URN (Uniform Resource Naming) : 자원을 식별할때 명명된 이름으로 식별하는 방식.
URC (Uniform Resource Content) : 자원을 식별할때 해당 자원이 가진 컨텐츠의 특성으로 식별하는 방식.

URL - 절대경로 (window.location 의 속성들은 생략 가능.)
protocol://ip[domain]:port/context/depth..../resourceName

client side : context path 를 포함한 경로 형태.
server side : context path 이후의 경로만 사용함.

<img src="http://localhost/WebStudy01/resources/images/ala.jpg" />
<img src="//localhost/WebStudy01/resources/images/ala.jpg" />
<img src="/WebStudy01/resources/images/ala.jpg" />
<img src="<%=request.getContextPath() %>/resources/images/ala.jpg" />

상대경로 : 현재 문서의 출처를 기준으로 자원의 위치가 상대적으로 표현됨.
<img src="../resources/images/ala.jpg" /> 
</body>
</html>






























