<%@page import="kr.or.ddit.servlet05.BrowserType"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 클라이언트의 브라우저 종류를 확인하고, -->
<!-- 다음과 같은 메시지를 출력할 것. -->
<!-- <h4>당신의 브라우저는 "크롬|엣지|웨일"입니다.</h4> -->
<%
String agent = request.getHeader("user-agent");
agent = agent.toUpperCase();
String messagePattern = "<h4>당신의 브라우저는 %s 입니다.</h4>";
String browserName = null;

/* if(agent.contains("EDG")){
	browserName = "엣지";
}else if(agent.contains("WHALE")){
	browserName = "웨일";
}else if(agent.contains("CHROME")){
	browserName = "크롬";
}else if(agent.contains("SAFARI")){
	browserName = "사파리";
}else{
	browserName = "기타등등";
} */

/* Map<String,String> browserType = new LinkedHashMap<>();
browserType.put("EDG", "엣지");
browserType.put("WHALE", "웨일");
browserType.put("CHROME", "크롬");
browserType.put("SAFARI", "사파리");
browserType.put("OTHER", "기타등등");

browserName = browserType.get("OTHER");
for(Entry<String,String> entry : browserType.entrySet()){
	if(agent.contains(entry.getKey())){
		browserName = entry.getValue();
		break;
	}
} */

/* browserName = BrowserType.OTHER.getBrowserName();
for( BrowserType tmp : BrowserType.values() ){
	if(agent.contains(tmp.name())){
		browserName = tmp.getBrowserName();
		break;
	}
} */

browserName = BrowserType.findBrowserName(request.getHeader("user-agent"));
%>
<%=String.format(messagePattern, browserName) %>
<h4><%=BrowserType.findBrowserType(agent).getBrowserName() %></h4>
</body>
</html>











