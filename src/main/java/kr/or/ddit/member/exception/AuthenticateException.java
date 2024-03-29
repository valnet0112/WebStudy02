package kr.or.ddit.member.exception;

public class AuthenticateException extends RuntimeException {

   public AuthenticateException(String memId) {
      super(String.format("%s 인증 처리 중 문제 발생", memId));
   }

   public AuthenticateException(Throwable cause) {
      super(cause);
   }

}