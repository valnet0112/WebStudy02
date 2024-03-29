package kr.or.ddit.member.service;

import javax.management.RuntimeErrorException;

import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.member.exception.AuthenticateException;
import kr.or.ddit.vo.MemberVO;

public class AuthenticateServiceImpl implements AuthenticateService {
	private MemberDAO dao = new MemberDAOImpl();
	
	@Override
	public MemberVO authenticate(MemberVO inputData) {
		boolean auth = false;
		MemberVO saved = dao.selectMemberForAuth(inputData.getMemId());
		if(saved!=null) {
			String inputPass = inputData.getMemPass();
			String savedPass = saved.getMemPass();
			auth = savedPass.equals(inputPass);
		}
		if(!auth) throw new AuthenticateException(inputData.getMemId());
		return saved;
	}

}
