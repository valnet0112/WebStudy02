package kr.or.ddit.member.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kr.or.ddit.common.exception.CustomPersistenceException;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class MemberDAOTest {

	static MemberDAO dao;
	MemberVO inputData;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao = new MemberDAOImpl();
	}

	@BeforeEach
	void setUp() {
		inputData = new MemberVO();
		inputData.setMemId("a001");
	}

	@Test
	void testSelectMemberForAuth() {
		MemberVO saved = dao.selectMemberForAuth("a001");
		assertNotNull(saved);
	}

	@Test
	void testSelectMember() {
		MemberVO a001 = dao.selectMember("a001");
		log.info("a001 의 탈퇴 여부 : {}", a001.isMemDelete());
		MemberVO d001 = dao.selectMember("d001");
		log.info("d001 의 탈퇴 여부 : {}", d001.isMemDelete());
	}

	@Test
	void testInsertMember() {
		MemberVO newMem = new MemberVO();
		assertThrows(CustomPersistenceException.class, () -> {
			dao.insertMember(newMem);
		});
	}

}
