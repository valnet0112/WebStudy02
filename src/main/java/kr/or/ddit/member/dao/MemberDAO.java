package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.vo.MemberVO;

/**
 * 회원 관리(CRUD)용 Persistence Layer
 *
 */
public interface MemberDAO {
   /**
    * 인증 처리를 위해 회원 정보 조회
    * @param memId 사용자가 입력한 정보를 가진 VO
    * @return  persistent한 형태로 저장되어 있던 정보를 가진 VO, 없으면 null 반환
    */
   public MemberVO selectMemberForAuth(String memId);
   /**
    * 신규 등록
    * @param member
    * @return 등록된 레코드수 > 0 ? 성공
    */
   public int insertMember(MemberVO member);
   /**
    * 회원 정보 조회
    * @param memId 조회할 회원의 아이디
    * @return 존재하지 않는 경우, null 반환.
    */
   public MemberVO selectMember(String memId);
   /**
    * 회원 목록 조회, 차후 검색과 페이징 적용.
    * @return 존재하지 않는 경우, list.size()==0
    */
   public List<MemberVO> selectMemberList();
   /**
    * 회원 정보 수정
    * @param member
    * @return 수정된 레코드수 > 0 ? 성공
    */
   public int updateMember(MemberVO member);
   /**
    * 회원 정보 삭제(???)
    * @param memId
    * @return 삭제된 레코드수 > 0? 성공
    */
   public int deleteMember(String memId);
   
}



