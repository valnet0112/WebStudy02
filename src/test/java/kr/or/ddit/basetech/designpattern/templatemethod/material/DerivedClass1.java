package kr.or.ddit.basetech.designpattern.templatemethod.material;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DerivedClass1 extends TemplateClass {

	@Override
	protected void stepTwo() {
		log.info("두번째 단계 작업- A 방식");
	}

}
