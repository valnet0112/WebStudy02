<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>10/includeStatic.jsp</title>
</head>
<body>
<%
for(int num=1; num<6; num++){
	out.println("<p>"+ num +"</p>");
}
%>
<%@ include file="printNumber.jsp" %>
<%
for(int num=11; num<16; num++){
	out.println("<p>"+ num +"</p>");
}
%>
<%=sample %>
</body>
</html>










