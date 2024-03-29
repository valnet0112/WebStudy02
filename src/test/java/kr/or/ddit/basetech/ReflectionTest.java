package kr.or.ddit.basetech;

import static org.junit.jupiter.api.Assertions.*;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.AbstractConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import kr.or.ddit.utils.PopulateUtils;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

/**
 * reflection
 *  : 객체(instance)로부터 객체의 타입, 속성, 메소드등의 조건(구조)를 역으로 분해하는 작업. 
 *
 */
@Slf4j
@TestMethodOrder(MethodOrderer.MethodName.class)
class ReflectionTest {
	static Object target;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		MemberVO tmp = new MemberVO();
		tmp.setMemId("a001");
		tmp.setMemPass("1111");
		tmp.setMemMileage(2000);
//		tmp.setMemBir(LocalDate.now());
		target = tmp;
	}

	@Test
	void test1() {
		Class<?> targetType = target.getClass();
		log.info("target type : {}", targetType);
	}
	
	@Test
	void test2() throws NoSuchMethodException, SecurityException, IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> targetType = target.getClass();
		Field[] fields = targetType.getDeclaredFields();
		for(Field single : fields) {
			String propertyName = single.getName();
			Class<?> propertyType = single.getType();
//			Method getter = targetType.getDeclaredMethod("getMemId");
//			Method setter = targetType.getDeclaredMethod("setMemId", String.class);
			PropertyDescriptor pd = new PropertyDescriptor(propertyName, targetType);
			Method getter = pd.getReadMethod();
//			target.getMemId();
			Object propertyValue = getter.invoke(target);
			log.info("{} {} = {}", propertyType.getSimpleName(), propertyName, propertyValue);
		}
	}
	
	@Test
	void test3() throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> targetType = target.getClass();
		Field[] fields = targetType.getDeclaredFields();
		for(Field single : fields) {
			String propertyName = single.getName();
			Class<?> propertyType = single.getType();
			PropertyDescriptor pd = new PropertyDescriptor(propertyName, targetType);
			Method setter = pd.getWriteMethod();
			if(propertyType.equals(String.class)) {
				String tmpData = "임의변경값";
				setter.invoke(target, tmpData);
			}
		}
	}

	@Test
	void test4() throws NoSuchMethodException, SecurityException, IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> targetType = target.getClass();
		Field[] fields = targetType.getDeclaredFields();
		System.out.println("===================================================");
		for(Field single : fields) {
			String propertyName = single.getName();
			Class<?> propertyType = single.getType();
//			Method getter = targetType.getDeclaredMethod("getMemId");
//			Method setter = targetType.getDeclaredMethod("setMemId", String.class);
			PropertyDescriptor pd = new PropertyDescriptor(propertyName, targetType);
			Method getter = pd.getReadMethod();
//			target.getMemId();
			Object propertyValue = getter.invoke(target);
			log.info("{} {} = {}", propertyType.getSimpleName(), propertyName, propertyValue);
		}
	}
	
	@Test
	void test5() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		String value = BeanUtils.getProperty(target, "memId");
		log.info("{}", value);
		BeanUtils.setProperty(target, "memId", "임의변경값");
		value = BeanUtils.getProperty(target, "memId");
		log.info("{}", value);
	}
	
	@Test
	void test6() throws IllegalAccessException, InvocationTargetException {
		MemberVO member = new MemberVO();
		Map<String, String> parameterMap = new HashMap<>();
		parameterMap.put("memId", "a001");
		parameterMap.put("memPass", "1111");
		parameterMap.put("memName", "김은대");
		parameterMap.put("memMileage", "1000");
		parameterMap.put("memBir", "2023-12-19T11:00");
		parameterMap.put("memMemorialday", "2023-12-19");
		
		PopulateUtils.populate(member, parameterMap);
		log.info("{}", member);
	}
}









