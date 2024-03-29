package kr.or.ddit.mbti.exception;

/**
 * MBTI 유형이 존재하지 않을때 발생시킬 예외.
 *
 */
public class MbtiNotFoundException extends RuntimeException{

	public MbtiNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MbtiNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public MbtiNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MbtiNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MbtiNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
