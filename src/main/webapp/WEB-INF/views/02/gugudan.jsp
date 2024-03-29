<%@page import="java.text.MessageFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
StringBuffer gugudan(int min, int max){
	StringBuffer trTags = new StringBuffer();
	for(int dan=min; dan<=max; dan++){
		trTags.append("<tr>");
		for(int mul=1; mul<=9; mul++){
			trTags.append(MessageFormat.format("<td>{0}*{1}={2}</td>", dan, mul, dan*mul));
		}
		trTags.append("</tr>");
	}
	return trTags;
}
%>  
<%
	int minDan = (Integer)request.getAttribute("minDan");
	int maxDan = (Integer)request.getAttribute("maxDan");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	table{
		border-collapse: collapse;
	}
	td{
		border: 1px solid black;
	}
</style>
<title>Insert title here</title>
</head>
<body>
<!-- 2단부터 9단까지의 구구단을 table 태그로 출력하시오. -->
<!-- 단, 하나의 tr 에서 하나의 단을 출력하는 8*9 table. -->
<form name="gugudanForm">
	<input type="number" name="minDan" min="2" max="13" placeholder="최소단" />
	<select name="maxDan">
		<%
			for(int number=2; number<=13; number++){
				out.println(
					MessageFormat.format("<option value=''{0}''>{0}단</option>", number)	
				);
			}
		%>
	</select>
	<button type="submit">구구단줫!</button>
</form>
<table>
	<%=gugudan(minDan, maxDan) %>
</table>
<table>
<%
	StringBuffer trTags = new StringBuffer();
	for(int dan=minDan; dan<=maxDan; dan++){
		trTags.append("<tr>");
		for(int mul=1; mul<=9; mul++){
			trTags.append(MessageFormat.format("<td>{0}*{1}={2}</td>", dan, mul, dan*mul));
		}
		trTags.append("</tr>");
	}
	out.println(trTags);
%>
</table>
<script>
	document.gugudanForm.minDan.value = <%=minDan%>;
	document.gugudanForm.maxDan.value = <%=maxDan%>;
</script>
</body>
</html>










