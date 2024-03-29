package kr.or.ddit.mapper;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.commons.lang3.text.WordUtils;

import com.fasterxml.jackson.databind.deser.impl.PropertyValue;

import kr.or.ddit.vo.MemberVO;

public class SampleDataMapper extends SampleTemplateMapper {
   //Result Type 은 경우에따라 달라질 수 있음.
   //리플렉션 코드로 바꿔보자
   
   private String snakeTocamel(String snake) {
      //init.cap() ?
      //1)"A"+snake =>  Amem_Id   2) _ 를 "" 으로 변경
      return   WordUtils.capitalizeFully("A"+snake, '_').replace("_", "").substring(1); 
      
   }
   
   
   @Override
   protected <E> E resultSetToModel(ResultSet rs, Class<E> resultType) throws SQLException {
//      MemberVO saved = new MemberVO();
//      saved.setMemId(rs.getString("MEM_ID"));
//      saved.setMemPass(rs.getString("MEM_PASS"));
//      saved.setMemName(rs.getString("MEM_NAME"));
//      saved.setMemMail(rs.getString("MEM_MAIL"));
//      saved.setMemHp(rs.getString("MEM_HP"));
//      return (E) saved;
   try {
      Object result = resultType.newInstance();// MemberVO생성
      ResultSetMetaData rsmd=rs.getMetaData();// 커서에 대한 정보
      int columnCount = rsmd.getColumnCount(); // 조회한 컬럼 수 
      
      for(int i =1; i<=columnCount; i++) {
         String columnName = rsmd.getColumnName(i);//MEM_ID
         String propertyName = snakeTocamel(columnName);//memId
         try {
            PropertyDescriptor pd = new PropertyDescriptor(propertyName, resultType);
            Method  setter = pd.getWriteMethod();
            Class<?> propertyType = pd.getPropertyType();
            Object propertyValue = null;
            if(propertyType.equals(boolean.class)) {
            	propertyValue = rs.getBoolean(columnName);
            }else if(propertyType.equals(Integer.class)) {
            	propertyValue = rs.getInt(columnName);
            }else if(propertyType.equals(LocalDateTime.class)) {
            	Timestamp tmp = rs.getTimestamp(columnName);
            	propertyValue = tmp==null? null : tmp.toLocalDateTime();
            }else if(propertyType.equals(LocalDate.class)) {
            	Date tmp = rs.getDate(columnName);
            	propertyValue = tmp==null? null : tmp.toLocalDate();
            }else if(propertyType.equals(String.class)) {
            	propertyValue =  rs.getString(columnName);
            }else {
            	throw new SQLException("타입 변환이 불가능한 타입임.");
            }
            
            setter.invoke(result, propertyValue);
            
         } catch (IntrospectionException | IllegalArgumentException | InvocationTargetException e) {
            throw new SQLException(e);
         }
      }
      
      return (E) result;//마지막줄 
   } catch (InstantiationException | IllegalAccessException e) {
      throw new SQLException(e);
      
   }
   }

}