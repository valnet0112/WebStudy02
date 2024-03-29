<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>
<!-- ex) 3! = 6 -->
<!-- 1. operand 라는 유일 파라미터(1이상의 양수)를 입력받고(factorialForm.jsp), -->
<!-- 	유효하지 않는 파라미터에 대해서는 bad request 를 응답으로 전송함. -->
<!-- 2. factorial.jsp 를 이용해 파라미터를 받고 재귀호출(recursive call) 구조를 활용하여 팩토리얼 연산 처리. -->
<!-- 3. 해당 연산의 결과는 다음과 같은 메시지로 출력 -->
<!-- 	<h4>3! = 6</h4> -->

<%--<form  action="./case1/factorial.jsp" method="get">--%>
<input type="radio" name="accept" value="json"/>json
<input type="radio" name="accept" value="html" checked />html
<form  action="../case2/factorial.do" method="get">
<input type="number" name="operand" min="1" placeholder="3!"/>
<button type="submit">전송</button>
</form>
<div id="resultArea"></div>
<script>
// 	function submitHandler(event){
// 		event.preventDefault();
		
// 		return false;
// 	}
	let successes = {
			json:function(resp){
				$resultArea.html(resp.expression);
			},
			html:function(resp){
				$resultArea.html(resp);
			} 
	}

	let $resultArea = $(resultArea);
	$("form:first").on("submit", function(event){
		event.preventDefault();
		// 동기 요청을 비동기 요청으로 전환
		let url = this.action;
		let method = this.method;
		let queryString = $(this).serialize();
		console.log("serialized query string : ", queryString);
		let settings = {
			url:url
			, method:method
			, data:queryString  // ==> query string 형태의 문자열로 전환됨.(serializing)
			, error:function(jqXHR, status, err){
				
			}
		};
		
		settings.dataType = $("[name=accept]:checked").val() ?? "html";
		
		settings.success = successes[settings.dataType];
		
		$.ajax(settings);
		
		return false;
	});
</script>
</body>
</html>











