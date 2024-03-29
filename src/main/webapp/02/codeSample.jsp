<%@page import="java.util.stream.Collectors"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.Optional"%>
<%@page import="java.util.stream.Stream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[] array = {"element1", "element2", "element3"};
%>
<ul>
	<%
		for(String tmp : array){
		%>
		<li><%=tmp %></li>
		<%	
		}	
	%>
	
</ul>
<ul>
<%
	StringBuffer liTags = new StringBuffer();
	for(String tmp : array){
		liTags.append(String.format("<li>%s</li>", tmp));
	}
	out.println(liTags);
%>
<%--=liTags --%>
</ul>
<ul>
	<%=
		Stream.of(array)
				.map(t->String.format("<li>%s</li>", t))
				.collect(Collectors.joining("\n"))
	%>
</ul>
</body>
</html>










