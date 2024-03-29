package kr.or.ddit.basetech.designpattern.templatemethod.material;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class TemplateClass {
	public final void template() {
		stepOne();
		stepTwo();
		stepThree();
	}
	
	private void stepOne() {
		log.info("첫번째 단계 작업");
	}
	
	protected abstract void stepTwo(); 
	
	private void stepThree() {
		log.info("첫번째 단계 작업");
	}
}
