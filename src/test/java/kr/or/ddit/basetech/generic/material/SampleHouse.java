package kr.or.ddit.basetech.generic.material;

import lombok.Data;

@Data
/**
 * 
 * 타입변수 T와 C의 구체적 타입은 정적 메소드인 casting3이 호출될때 인자들에 의해 결정됨.
 * @param <T>
 * @param <C>
 */
public class SampleHouse<T,C> {
	private T person;
	
	public C casting1(){
		return (C) person;
	}
}
