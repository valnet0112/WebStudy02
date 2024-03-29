<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<pre>
message = ${message }
member = ${member }
contentPage = <%=request.getAttribute("contentPage")%>, ${contentPage }
errors = ${errors}
</pre>
<form method="post">
   <table>
      <tr>
         <th>회원아이디</th>
         <td><input type="text" name="memId" required
            value="${member.memId}" class="form-control" /><span
            class="text-danger">${errors.memId}</span></td>
      </tr>
      <tr>
         <th>비밀번호</th>
         <td><input type="text" name="memPass" required
            value="${member.memPass}" class="form-control" /><span
            class="text-danger">${errors.memPass}</span></td>
      </tr>
      <tr>
         <th>이름</th>
         <td><input type="text" name="memName" value="${member.memName}"
            class="form-control" /><span class="text-danger">${errors.memName}</span></td>
      </tr>
      <tr>
         <th>주민번호1</th>
         <td><input type="text" name="memRegno1"
            value="${member.memRegno1}" class="form-control" /><span
            class="text-danger">${errors.memRegno1}</span></td>
      </tr>
      <tr>
         <th>주민번호2</th>
         <td><input type="text" name="memRegno2"
            value="${member.memRegno2}" class="form-control" /><span
            class="text-danger">${errors.memRegno2}</span></td>
      </tr>
      <tr>
         <th>생일</th>
         <td><input type="datetime-local" name="memBir" value="${member.memBir}"
            class="form-control" /><span class="text-danger">${errors.memBir}</span></td>
      </tr>
      <tr>
         <th>우편번호</th>
         <td><input type="text" name="memZip" required
            value="${member.memZip}" class="form-control" /><span
            class="text-danger">${errors.memZip}</span></td>
      </tr>
      <tr>
         <th>주소1</th>
         <td><input type="text" name="memAdd1" required
            value="${member.memAdd1}" class="form-control" /><span
            class="text-danger">${errors.memAdd1}</span></td>
      </tr>
      <tr>
         <th>주소2</th>
         <td><input type="text" name="memAdd2" required
            value="${member.memAdd2}" class="form-control" /><span
            class="text-danger">${errors.memAdd2}</span></td>
      </tr>
      <tr>
         <th>집전번</th>
         <td><input type="text" name="memHometel"
            value="${member.memHometel}" class="form-control" /><span
            class="text-danger">${errors.memHometel}</span></td>
      </tr>
      <tr>
         <th>회사전번</th>
         <td><input type="text" name="memComtel"
            value="${member.memComtel}" class="form-control" /><span
            class="text-danger">${errors.memComtel}</span></td>
      </tr>
      <tr>
         <th>휴대폰</th>
         <td><input type="text" name="memHp" required
            value="${member.memHp}" class="form-control" /><span
            class="text-danger">${errors.memHp}</span></td>
      </tr>
      <tr>
         <th>이메일</th>
         <td><input type="text" name="memMail" value="${member.memMail}"
            class="form-control" /><span class="text-danger">${errors.memMail}</span></td>
      </tr>
      <tr>
         <th>직업</th>
         <td><input type="text" name="memJob" value="${member.memJob}"
            class="form-control" /><span class="text-danger">${errors.memJob}</span></td>
      </tr>
      <tr>
         <th>취미</th>
         <td><input type="text" name="memLike" value="${member.memLike}"
            class="form-control" /><span class="text-danger">${errors.memLike}</span></td>
      </tr>
      <tr>
         <th>기념일</th>
         <td><input type="text" name="memMemorial"
            value="${member.memMemorial}" class="form-control" /><span
            class="text-danger">${errors.memMemorial}</span></td>
      </tr>
      <tr>
         <th>기념일자</th>
         <td><input type="date" name="memMemorialday"
            value="${member.memMemorialday}" class="form-control" /><span
            class="text-danger">${errors.memMemorialday}</span></td>
      </tr>
      <tr>
         <th>마일리지</th>
         <td>1000</td>
      </tr>
      <tr>
         <td colspan="2">
            <button type="submit" class="btn btn-primary">전송</button>
            <button type="reset" class="btn btn-danger">취소</button>
         </td>
      </tr>
   </table>
</form>









