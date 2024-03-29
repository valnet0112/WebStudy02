package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.common.exception.PKNotFoundException;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private MemberDAO dao = new MemberDAOImpl();

	@Override
	public ServiceResult createMember(MemberVO member) {
		ServiceResult result = null;
		if(dao.selectMember(member.getMemId())==null) {
			result =  dao.insertMember(member) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}else {
			result = ServiceResult.PKDUPLICATED;
		}
		return result;
	}

	@Override
	public MemberVO retrieveMember(String memId) {
		MemberVO member = dao.selectMember(memId);
		if(member==null)
			throw new PKNotFoundException(String.format("%s 에 해당하는 사용자 없음.", memId));
		return member;
	}

	@Override
	public List<MemberVO> retrieveMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult modifyMember(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult removeMember(MemberVO inputData) {
		// TODO Auto-generated method stub
		return null;
	}

}
