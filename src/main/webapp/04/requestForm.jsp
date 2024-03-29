<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>입력 UI</h4>
<form action="formProcess.do" method="post" enctype="application/x-www-form-urlencoded">
	<pre>
		<input type="text" name="textParam" placeholder="문자열"/>
		<input type="number" name="numParam" placeholder="숫자"/>
		<input type="date" name="dateParam" placeholder="숫자"/>
		<input type="datetime-local" name="dateTimeParam" placeholder="숫자"/>
		<label><input type="radio" name="radio" value="RADIO1"/>RADIO1</label>
		<input type="radio" name="radio" id="radio2" value="RADIO2"/><label for="radio2">RADIO2</label>
		<input type="checkbox" name="checkbox" value="CHECK1"/>CHECK1
		<input type="checkbox" name="checkbox" value="CHECK2"/>CHECK2
		<input type="checkbox" name="checkbox" value="CHECK3"/>CHECK3
		<select name="singleSel">
			<option value>선택</option>
			<option value="selValue1">text1</option>
			<option value="selValue2">text2</option>
		</select>
		<select name="multiSel" multiple>
			<option value="selValue1" label="text1" />
			<option value="selValue2" label="text2" />
			<option value="selValue3" label="text3" />
		</select>
		<textarea name="textArea"></textarea>
		<button type="submit">전송</button>
		<button type="reset">취소</button>
		<button type="button">일반버튼</button>
	</pre>
</form>
</body>
</html>








