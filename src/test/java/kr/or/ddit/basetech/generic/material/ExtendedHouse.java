package kr.or.ddit.basetech.generic.material;

public class ExtendedHouse extends SampleHouse<Child, Parent>{
	public <C> C casting2(Class<C> castingType){
		return (C) getPerson();
	}
	
	public static <T,C> C casting3(T target, Class<C> castingType) {
		return (C) target;
	}
}
