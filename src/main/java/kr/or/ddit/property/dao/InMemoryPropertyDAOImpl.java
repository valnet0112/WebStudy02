package kr.or.ddit.property.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import kr.or.ddit.servlet08.ServerTimeServlet;
import kr.or.ddit.vo.PropertyVO;

/**
 *  .properties 파일을 출처로 하는 dao 구현체.
 *
 */
public class InMemoryPropertyDAOImpl implements PropertyDAO {
	private Properties properties;

	public InMemoryPropertyDAOImpl(String logicalPath) {
		super();
		URL realPath = this.getClass().getResource(logicalPath);
		try {
			File file = new File(realPath.toURI());
			properties = new Properties();
			try(
				FileInputStream fis = new FileInputStream(file);	
			){
				properties.load(fis);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int insertProperty(PropertyVO newProp) {
		properties.setProperty(newProp.getPropertyName(), newProp.getPropertyValue());
		return 1;
	}

	@Override
	public List<PropertyVO> selectProperties() {
		return properties.entrySet().stream()
						.map(en->{
							PropertyVO vo = new PropertyVO();
							vo.setPropertyName(en.getKey().toString());
							vo.setPropertyValue(en.getValue().toString());
							return vo;
						}).collect(Collectors.toList());
	}

	@Override
	public PropertyVO selectProperty(String propertyName) {
		return Optional.ofNullable(properties.getProperty(propertyName))
							.map(pv->{
								PropertyVO vo = new PropertyVO();
								vo.setPropertyName(propertyName);
								vo.setPropertyValue(pv);
								return vo;
							}).orElse(null);
	}

	@Override
	public int updateProperty(PropertyVO modifyProp) {
		if(properties.containsKey(modifyProp.getPropertyName())) {
			properties.setProperty(modifyProp.getPropertyName(), modifyProp.getPropertyValue());
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public int deleteProperty(String propertyName) {
		return properties.remove(propertyName) != null ? 1 : 0;
	}

}













