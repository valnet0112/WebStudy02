package kr.or.ddit.mbti.dao;

import java.util.List;

import kr.or.ddit.vo.MbtiVO;

public interface MbtiDAO {
	/**
	 * 전체 MBTI 유형 조회
	 * @return .size()==0 일 수 있음.
	 */
	public List<MbtiVO> selectMbtiList();
	
	/** 
	 * 하나의 MBTI 유형 조회
	 * @param type 조회할 MBTI 유형
	 * @return 해당 MBTI 가 존재하지 않으면, null 반환.
	 */
	public MbtiVO selectMbti(String type);
}
