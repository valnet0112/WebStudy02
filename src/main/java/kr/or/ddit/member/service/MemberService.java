package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.MemberVO;

/**
 * 
 * 회원 관리용(crud)용 business logic layer
 * @author PC-05
 *
 */
public interface MemberService {
	/**
	 * 회원 가입처리
	 * @param member
	 * @return PKDUPLICATED, OK, FAIL
	 */
	public ServiceResult createMember(MemberVO member);
	/**회원정보 상세 조회
	 * @param memId 조회할 회원의 primary key
	 * @return 존재하지 않는 경우, {@linkt PKNotFoundException}
	 */
	public MemberVO retrieveMember(String memId);
	/**
	 * 회원 목록 조회ㅏ(관리좌용)
	 * @return
	 */
	 
	public List<MemberVO> retrieveMemberList();
	
	/**
	 * 회원 정보 수정
	 * @param member
	 * @return INVALIDPASSWORD, OK, FAIL
	 */
	public ServiceResult modifyMember(MemberVO member);
	
	
	public ServiceResult removeMember(MemberVO inputData);
	
}
