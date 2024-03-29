package kr.or.ddit.time;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

class Java8TimeAPITest {

	@Test
	void test() {
		System.out.println("test case run");
		// epoch time : 1970.01.01.00:00:00 이후의 밀리 세컨드로 시간을 연산하는 방식
		System.out.printf("java 8버전 이전 : %s\n", new Date());
		System.out.printf("java 8버전 이전 : %s\n", Calendar.getInstance());
		
		System.out.printf("java 8버전 이후 : %s\n", LocalDate.now());
		System.out.printf("java 8버전 이후 : %s\n", LocalDateTime.now());
	}

}














