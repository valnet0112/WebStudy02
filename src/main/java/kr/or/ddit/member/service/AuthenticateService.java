package kr.or.ddit.member.service;

import kr.or.ddit.member.exception.AuthenticateException;
import kr.or.ddit.vo.MemberVO;

/**
 * 인증 처리를 위한 Business Logic Layer
 */
public interface AuthenticateService {
	/**
	 * 인증 여부를 결정하는 로직
	 * 
	 * @param inputData 사용자의 입력 데이터
	 * @return 인증 실패시 {@link AuthenticateException} 발생.
	 */
	public MemberVO authenticate(MemberVO inputData);
}
