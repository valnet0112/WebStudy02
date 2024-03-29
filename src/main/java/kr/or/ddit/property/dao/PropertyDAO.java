package kr.or.ddit.property.dao;

import java.util.List;

import kr.or.ddit.vo.PropertyVO;

/**
 * DAO(Data Access Object) : 데이터의 출처를 대상으로 CRUD 수행하는 객체.
 * .properties 파일과 Database_properties 뷰 라는 2개의 데이터 출처에 대해
 * 공통적인 접근 방법을 정의하는 추상화.
 *
 */
public interface PropertyDAO {
	public int insertProperty(PropertyVO newProp);
	public List<PropertyVO> selectProperties();
	public PropertyVO selectProperty(String propertyName);
	public int updateProperty(PropertyVO modifyProp);
	public int deleteProperty(String propertyName);
}
















