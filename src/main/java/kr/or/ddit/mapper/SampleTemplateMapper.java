package kr.or.ddit.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.common.exception.CustomPersistenceException;
import kr.or.ddit.db.ConnectionFactory;

public abstract class SampleTemplateMapper {
   
   public final  <E>  E selectOne(String sql, Class<E> resultType, String[] parameters) {
      try(
               Connection conn = getConnection();
               PreparedStatement pstmt = createStatement(conn, sql);
            ){
         
               for(int i=0; i<parameters.length; i++)
               {
                  
                  pstmt.setString(i+1, parameters[i]);
                  
               }
         
               ResultSet rs = pstmt.executeQuery();
               E result = null;
               
               if(rs.next())
               {
                  
                  result = resultSetToModel(rs, resultType);
                  
               }
               return result;
             
            }catch(SQLException e) {
               throw new CustomPersistenceException(e);
            }
   } 
   public final <E> List<E> selectList(String sql, Class<E> resultType) {
      List<E> list = new ArrayList<>();
      try(
         Connection conn = getConnection();
         PreparedStatement pstmt = createStatement(conn, sql);
      ){
         ResultSet rs = pstmt.executeQuery();
         while(rs.next()) {
            list.add(resultSetToModel(rs, resultType));
            
         }
         return list;
      }catch(SQLException e) {
         throw new CustomPersistenceException(e);
      }
   }
   
   protected abstract <E> E resultSetToModel(ResultSet rs, Class<E> resultType) throws SQLException;
   
   private Connection getConnection() throws SQLException {
      return ConnectionFactory.getConnection();
   }
   
   private PreparedStatement createStatement(Connection conn, String sql) throws SQLException{
      return conn.prepareStatement(sql);
   }
   
}