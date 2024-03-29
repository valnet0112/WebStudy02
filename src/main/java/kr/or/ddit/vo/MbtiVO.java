package kr.or.ddit.vo;

import java.io.Serializable;

/**
 * 하나의 MBTI 유형에 대한 정보를 캡슐화한 객체(VO, JavaBean, DataTransferObject, Model, Info).
 * 
 * 자바빈 규약
 * 1. 값을 저장할 수 있는 프로퍼티 제공
 * 2. 프로퍼티에 대한 캡슐화
 * 3. 캡슐화된 프로퍼티에 대해 인터페이스 지원(getter/setter) : get[set]프로퍼티네임의 첫글자를 대문자로한 프로퍼티명(capitalized property name)
 * 4. 프로퍼티 상태 확인 인터페이스 지원(toString)
 * 5. 객체의 상태를 비교할 수 있는 인터페이스 지원(equals, compareTo)
 * 6. 직렬화 지원.
 *
 */
public class MbtiVO implements Serializable{
	public MbtiVO() {
		super();
	}
	
	public MbtiVO(String type, String title, String logicalPath) {
		super();
		this.type = type;
		this.title = title;
		this.logicalPath = logicalPath;
	}

	private String type;
	private String title;
	private String logicalPath;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLogicalPath() {
		return logicalPath;
	}
	public void setLogicalPath(String logicalPath) {
		this.logicalPath = logicalPath;
	}
	@Override
	public String toString() {
		return "MbtiVO [type=" + type + ", title=" + title + ", logicalPath=" + logicalPath + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MbtiVO other = (MbtiVO) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
}
