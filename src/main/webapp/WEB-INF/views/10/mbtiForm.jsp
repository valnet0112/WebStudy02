<%@page import="kr.or.ddit.utils.CookieUtils"%>
<%@page import="java.util.Objects"%>
<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.stream.Stream"%>
<%@page import="java.util.Optional"%>
<%@ page contentType="text/html; charset=UTF-8" %>

	<%
		String mbtiCookieValue = CookieUtils.findCookieValue(request, "mbtiCookie");
	%>
    <form action="<%=request.getContextPath()%>/10/mbti" onchange="this.requestSubmit();">
        <select name="type" data-init-value="<%=Objects.toString(mbtiCookieValue, "") %>">
            
        </select>
    </form>
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/app/10/mbtiForm.js"></script>













