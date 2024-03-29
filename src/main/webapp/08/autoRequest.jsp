<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta http-equiv="Refresh" content="5;url=https://www.naver.com"> -->
<title>08/autoRequest.jsp</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/app/08/autoRequest.js?<%=System.currentTimeMillis()%>"></script>
</head>
<body>
<h4>주기적으로 갱신되는 자원에 대한 자동 요청</h4>
<h4 id="timeArea"></h4>
<input type="text" name="dummy"/>
<pre>
	1. response header : Refresh (동기 요청으로 document 를 갱신하는 경우 활용.)
		<%--
			response.setIntHeader("Refresh", 1);
		--%>
		
	2. html meta : http-equiv="Refresh", content="second;location..."
	3. JS scheduling : setInterval(주기적인 반복 작업), setTimeout(지연 설정)
</pre>
</body>
</html>
















