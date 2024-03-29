package kr.or.ddit.common.exception;

import java.sql.SQLException;

/**
 * Persistence layer에서 SQLException이 발생한 경우, 예외 전환 처리에 사용함
 *
 */
public class CustomPersistenceException extends RuntimeException{

   public CustomPersistenceException(SQLException cause) {
      super("DAO에서 쿼리를 실행하거나 쿼리에 파라미터를 전달하거나 쿼리의 실행결과를 바인딩할 때 예외 발생.", cause);
      // TODO Auto-generated constructor stub
   }

}