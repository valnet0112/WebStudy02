<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.stream.Stream"%>
<%@page import="kr.or.ddit.enumpkg.OperatorType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath() %>/resources/js/app/07/calculateForm_case3.js?<%=System.currentTimeMillis() %>"></script>
</head>
<body>
<h4>parameter 전송하고 HTML/JSON 수신</h4>
<input type="radio" name="accept" value="text/html" data-fn-name="fnHtml"/>HTML
<input type="radio" name="accept" value="application/json" data-fn-name="fnJson"/>JSON

<form id="calForm" method="post" enctype="application/x-www-form-urlencoded" 
action="<%=request.getContextPath() %>/07/case3/calculator.do">
	<input type="number" name="left" placeholder="좌측피연산자"/>
	<select name="operator">
		<%=
			Stream.of(OperatorType.values())
				.map(o->String.format("<option value='%s' label='%c' />", o.name(), o.getSign()))
				.collect(Collectors.joining("\n"))
		%>
	</select>
	<input type="number" name="right" placeholder="우측피연산자"/>
	<button type="submit">=</button>
</form>
<div id="resultArea"></div>
</body>
</html>
















