package kr.or.ddit.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 회원 관리용 Domain Layer
 *
 */
@Data
@EqualsAndHashCode(of = "memId")
@NoArgsConstructor
public class MemberVO implements Serializable {
	
	public MemberVO(String memId, String memPass) {
		super();
		this.memId = memId;
		this.memPass = memPass;
	}
	
	private String memId;
	private String memPass;
	private String memName;
	@JsonIgnore
	@ToString.Exclude
	private transient String memRegno1;
	@JsonIgnore
	@ToString.Exclude
	private transient String memRegno2;
	private LocalDateTime memBir;
	private String memZip;
	private String memAdd1;
	private String memAdd2;
	private String memHometel;
	private String memComtel;
	private String memHp;
	private String memMail;
	private String memJob;
	private String memLike;
	private String memMemorial;
	private LocalDate memMemorialday;
	private Integer memMileage;
	private boolean memDelete;
}







