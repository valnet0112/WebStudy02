<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>08/cacheControl.jsp</title>
</head>
<body>
<h4>캐시 제어</h4>
<h4>캐싱하지 않는 방법</h4>
<pre>
	Cache : 자원이 네트워크를 통해 전송되는 동안 발생하는 부하와 latency time 을 줄이기 위한 저장 데이터 형태.
	
	: Pragma(http 1.0), Cache-Control(http 1.1), Expires(version 무관, Date(long)).. 응답 헤더로 캐시 제어.
	response.setHeader(name, value), setIntHeader(name, int value), setDateHeader(name, long value)
	response.addHeader(name, value), addIntHeader(name, int value), addDateHeader(name, long value)
	<%
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
	%>
</pre>
</body>
</html>











