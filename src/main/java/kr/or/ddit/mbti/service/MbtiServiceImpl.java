package kr.or.ddit.mbti.service;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import kr.or.ddit.mbti.dao.InMemoryMbtiDAOImpl;
import kr.or.ddit.mbti.dao.MbtiDAO;
import kr.or.ddit.mbti.exception.MbtiNotFoundException;
import kr.or.ddit.vo.MbtiVO;

public class MbtiServiceImpl implements MbtiService {
	private MbtiDAO dao = new InMemoryMbtiDAOImpl();

	@Override
	public Set<Entry<String, String>> retrieveEntrySet() {
		return dao.selectMbtiList().stream()
				.map(vo->new SimpleEntry<String,String>(vo.getType(), vo.getTitle()))
				.collect(Collectors.toSet());
	}

	@Override
	public Map<String, String> retrieveEntryMap() {
		return dao.selectMbtiList().stream()
				.collect(Collectors.toMap(MbtiVO::getType, MbtiVO::getTitle));
	}

	@Override
	public MbtiVO retrieveMbti(String type) {
		MbtiVO vo = dao.selectMbti(type);
		if(vo==null) {
			throw new MbtiNotFoundException(String.format("%s 유형이 없음.", type));
		}
		return vo;
	}

}







