<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>10/flowControl.jsp</title>
</head>
<body>
<h4>페이지 이동 구조</h4>
<pre>
	Http : ConnectLess, StateLess
	
	1. 요청 분기(request dispatch) : 원본 요청을 가지고 분기하는 서버사이드 이동 구조.(RequestDispatcher 사용)
		1) forward : request 와 response 처리자가 분리되는 구조(Model2 에서 주로 활용).
		2) include : 최종 응답의 형태가 2개의 이상의 jsp 파일이 한개의 페이지를 구성하는 형태로 응답 전송(A+B, 페이지 모듈화 구조).
			** include 시점과 대상의 차이에 따른 분류
			- 정적 내포 : jsp 파일에 대해 서블릿 소스가 파싱되는 시점에, 소스 파일 자체를 내포함.
			- 동적 내포 : runtime 에 실행 결과를 내포함.
		
		<%
			request.setAttribute("sampleAttr", "도착지인 B쪽으로 전달할 모델");
			String path = "/02/standard.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(path);
// 			rd.forward(request, response);			
// 			rd.include(request, response);
// 			pageContext.include(path);
		%>
		<jsp:include page="<%=path %>" />
	2. Redirect : body 가 없는 3XX(Location) 응답이 전송되면서, 원본 요청이 사라지고(StateLess),
				클라이언트로부터 Location 방향으로 새로운 요청이 발생하는 구조.
				1) 자원의 위치를 재지정할때.
				2) 자원(URI)을 대상으로 어떤 행위(POST)를 수행 한 후, 해당 행위로 인해 갱신된 자원을 새로 요청(GET)하는 구조.
					POST -> redirect -> GET : PRG pattern 에서 주로 활용됨.
	<%--
		String location = request.getContextPath() + "/02/standard.jsp";
		response.sendRedirect(location);
	--%>
</pre>
</body>
</html>










