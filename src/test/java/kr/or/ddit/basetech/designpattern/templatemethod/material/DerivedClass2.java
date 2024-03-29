package kr.or.ddit.basetech.designpattern.templatemethod.material;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DerivedClass2 extends TemplateClass {

	@Override
	protected void stepTwo() {
		log.info("두번째 단계 작업 - B 방식");

	}

}
