<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.PropertyVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h4>JDBC(Java DataBase Connectivity)</h4>
<pre>
	1. 드라이버를 빌드패스(classpath)에 추가
	2. 드라이버 로딩(driver class loading)
	3. 드라이버를 통해 Connection 수립
	4. 쿼리 객체(statement)
		- Statement
		- PreparedStatement
		- CallableStatement
	5. 쿼리 작성(DDL, DML, TCL), 실행
		- ResultSet executeQuery
		- int executeUpdate
	6. 실행 결과 집합의 사용 : cursor 기반의 데이터(record, tuple)를 포인터를 통해 접근함.
	7. 사용한 모든 자원의 release.
</pre>
<%
	List<PropertyVO> propList = (List) request.getAttribute("propList");
%>
<table class="table table-borderedd">
	<thead>
		<tr>
			<th>PROPERTY_NAME</th>
			<th>PROPERTY_VALUE</th>
			<th>DESCRIPTION</th>
		</tr>
	</thead>
	<tbody>
	<%
		for(PropertyVO propVO : propList){
			%>
			<tr>
				<td><%=propVO.getPropertyName() %></td>
				<td><%=propVO.getPropertyValue() %></td>
				<td><%=propVO.getDescription() %></td>
			</tr>
			<%
		}
	%>
	</tbody>
</table>
<script>
	console.log($);
</script>










