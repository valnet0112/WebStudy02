package kr.or.ddit.basetech.designpattern.templatemethod.material;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class TemplateMethodPatternTest {

	@Test
	void test() {
		TemplateClass[] array = new TemplateClass[] {new DerivedClass1(), new DerivedClass2()};
		Arrays.stream(array)
				.forEach(dc->dc.template());
	}

}
