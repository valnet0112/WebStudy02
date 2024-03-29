<%@page import="java.text.MessageFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
long factorial(int operand){
	if(operand<=0){
		throw new IllegalArgumentException("팩토리얼 연산은 양수만 처리 가능.");
	}
	if(operand==1){
		return 1;
	}else{
		return operand*factorial(operand-1);
	}
}
%>
<%
String param = request.getParameter("operand");
if(param==null || param.trim().isEmpty() || !param.matches("\\d{1,3}")){
	response.sendError(HttpServletResponse.SC_BAD_REQUEST, "필수 파라미터가 누락됐거나, 파라미터의 데이터타입이 정상적이지 않음.");
	return;
}else {
	int operand = Integer.parseInt(param);
	try{
		long result = factorial(operand);
		// 	for(int tmp = operand; tmp >= 1; tmp--){
		// 		result *= tmp;
		// 	}
		String expression = MessageFormat.format("{0} != {1}", operand, result);
		request.setAttribute("expression", expression);
	}catch(IllegalArgumentException e){
		response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
		return;
	}
}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4><%=request.getAttribute("expression") %></h4>
</body>
</html>