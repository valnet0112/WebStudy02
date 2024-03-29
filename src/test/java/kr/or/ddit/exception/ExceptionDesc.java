package kr.or.ddit.exception;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

/**
 * 예외 : 프로그램의 실행 중 예측하지 않은 상태에서 발생하는 모든 상황에 대한 통칭.
 * 
 * Throwable
 * 	1. Error : 시스템 디폴트 상황처럼 개발자가 코드로 해결할 수 없는 모든 상황.
 *  2. Exception : 필요하다면, 의도적으로 발생시킬 수도 있고, 원하는 형태로 처리가 가능한 상황.
 *  	1) checked exception(Exception) : 처리하지 않으면, 컴파일 에러를 발생시키는 예외 ex)IOException, SQLException
 *  	2) unChecked exception(RuntimeException) : 직접 처리하지 않아도, 자동으로 최종 JVM 에게 까지 전달(throw)되는 예외.
 *  			ex) NullPointerException, ArithmeticException, IllegalArgumentException
 *  
 *  * 예외처리
 *  1. 예외 회피 : throws, 호출자에게 예외를 떠넘기는 구조.
 *  
 *  try(
 *  	with closable resource
 *  ){
 *  	예외 발생 코드
 *  }catch(예외 타입 |... |...|... e){
 *  
 *  }finally{
 *  	메소드 종료 전
 *  }
 *  2. 예외 전환 : 발생한 예외의 종류를 전혀 다른 형태의 예외로 변경
 *  			(checked exception -> unchecked exception 전환)
 *  3. 예외 복구 : 배치 처리에서 주로 활용됨.
 *  
 *  custom exception 활용 구조. (throw)
 *  1. 예외 클래스 정의(extends Exception:checked, extends RuntimeException:unchecked)
 *  2. throw new 예외생성자
 *
 */
class ExceptionDesc {

	@Test
	void first(){
//		second();
		System.out.println("first method");
		try {
			StringBuffer sb = makeSb();
			System.out.println(sb.toString());
		}catch (NullPointerException e) {
			e.printStackTrace();
			System.err.println("왜 StringBuffer를 null 로 반환햇!");
		}
	}
	
	StringBuffer makeSb() {
		return null;
	}
	
	private void second(){
		try {
			third();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		System.out.println("sencod method");
	}
	
	private void third() throws IOException {
		if(1==1) {
			throw new IOException("강제 발생 예외");
		}
		System.out.println("third method");
	}
}













