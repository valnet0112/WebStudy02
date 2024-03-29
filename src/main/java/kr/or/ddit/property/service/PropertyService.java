package kr.or.ddit.property.service;

import java.util.List;
import java.util.Set;

import kr.or.ddit.vo.PropertyVO;

/**
 * 프로퍼티 정보를 관리하기 위한 business logic layer
 *
 */
public interface PropertyService {
	public boolean createProperty(PropertyVO newProp);
	public PropertyVO retrieveProperty(String propertyName);
	public List<PropertyVO> retrieveProperties();
	public Set<String> retrieveKeySet();
	public boolean updateProperty(PropertyVO modifyProp);
	public boolean deleteProperty(String propetyName);
}
