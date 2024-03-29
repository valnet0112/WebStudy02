package kr.or.ddit.bean;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.PropertyVO;

class JavaBeanTest {

	@Test
	void test1() {
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		System.out.printf("obj1==obj2 : %b\n", obj1==obj2);
		System.out.printf("obj1.equals(obj2) : %b\n", obj1.equals(obj2));
	}
	
	@Test
	void test2() {
		PropertyVO vo1 = new PropertyVO();
		vo1.setPropertyName("newProp");
		PropertyVO vo2 = new PropertyVO();
		vo2.setPropertyName("newProp");
		
		System.out.printf("vo1==vo2 %b\n", vo1==vo2);
		System.out.printf("vo1.equals(vo2) %b\n", vo1.equals(vo2));
	}

	@Test
	void test3() {
		String str1 = "value";
		String str2 = "value";
		String str3 = new String("value");
		String str4 = new String("value");
		
		System.out.printf("str1==str2 : %b\n", str1==str2); // true
		System.out.printf("str1==str3 : %b\n", str1==str3); // false
		
		System.out.printf("str1.equals(str3) : %b\n", str1.equals(str3)); // true
		System.out.printf("str3.equals(str4) : %b\n", str3.equals(str4)); // true
		
		System.out.printf("str3==str4 : %b\n", str3==str4); // false
		
	}
}












