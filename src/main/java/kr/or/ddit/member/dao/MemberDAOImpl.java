package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import kr.or.ddit.common.exception.CustomPersistenceException;
import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.mapper.SampleDataMapper;
import kr.or.ddit.mapper.SampleTemplateMapper;
import kr.or.ddit.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {
   
   private SampleDataMapper mapper = new SampleDataMapper();

   //template method pattern 으로 중복코드를 해결 예정 (커넥션생성, 쿼리객체 생성, 쿼리파라미터 셋팅, 쿼리 실행, 자원 닫기, 예외처리)
   @Override
   public MemberVO selectMemberForAuth(String memId) {
      StringBuffer sql = new StringBuffer();
      sql.append(" SELECT MEM_ID, MEM_PASS, MEM_NAME, MEM_MAIL, MEM_HP   ");
      sql.append(" FROM MEMBER                                           ");
      sql.append(" WHERE MEM_ID = ? AND MEM_DELETE IS NULL "); //AND MEM_DELETE IS NULL -> 이 조건으로 탈퇴여부가 이미 true 즉,
                                                //탈퇴했지만 db에서 아직 삭제되지 않은 상태의 회원을 로그인 하지 못하게 막고있음.
      
      return mapper.selectOne(sql.toString(), MemberVO.class, new String[] {memId});
   }

//   template method pattern 으로 해결 예정
   @Override
   public int insertMember(MemberVO member) {
      StringBuffer sql = new StringBuffer();
      sql.append(" INSERT INTO member (           ");
      sql.append("        mem_id,                 ");
      sql.append("        mem_pass,               ");
      sql.append("        mem_name,               ");
      sql.append("        mem_regno1,             ");
      sql.append("        mem_regno2,             ");
      sql.append("        mem_bir,                ");
      sql.append("        mem_zip,                ");
      sql.append("        mem_add1,               ");
      sql.append("        mem_add2,               ");
      sql.append("        mem_hometel,            ");
      sql.append("        mem_comtel,             ");
      sql.append("        mem_hp,                 ");
      sql.append("        mem_mail,               ");
      sql.append("        mem_job,                ");
      sql.append("        mem_like,               ");
      sql.append("        mem_memorial,           ");
      sql.append("        mem_memorialday,        ");
      sql.append("        mem_mileage             ");
      sql.append("    ) VALUES (                  ");
      sql.append("        ?,                      ");
      sql.append("        ?,                      ");
      sql.append("        ?,                      ");
      sql.append("        ?,                      ");
      sql.append("        ?,                      ");
      sql.append("        ?,                      ");
      sql.append("        ?,                      ");
      sql.append("        ?,                      ");
      sql.append("        ?,                      ");
      sql.append("        ?,                      ");
      sql.append("        ?,                      ");
      sql.append("        ?,                      ");
      sql.append("        ?,                      ");
      sql.append("        ?,                      ");
      sql.append("        ?,                      ");
      sql.append("        ?,                      ");
      sql.append("        ?,                      ");
      sql.append("        1000                    ");
      sql.append("    )                   ");
      
      try(
         Connection conn = ConnectionFactory.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql.toString());
      ){
         int idx = 1;
         pstmt.setString(idx++, member.getMemId());
         pstmt.setString(idx++, member.getMemPass());
         pstmt.setString(idx++, member.getMemName());
         pstmt.setString(idx++, member.getMemRegno1());
         pstmt.setString(idx++, member.getMemRegno2());
         
         if(member.getMemBir()!=null) {
            pstmt.setTimestamp(idx++, Timestamp.valueOf(member.getMemBir()));
         }else {
            pstmt.setTimestamp(idx++, null);
         }
         
         pstmt.setString(idx++, member.getMemZip());
         pstmt.setString(idx++, member.getMemAdd1());
         pstmt.setString(idx++, member.getMemAdd2());
         pstmt.setString(idx++, member.getMemHometel());
         pstmt.setString(idx++, member.getMemComtel());
         pstmt.setString(idx++, member.getMemHp());
         pstmt.setString(idx++, member.getMemMail());
         pstmt.setString(idx++, member.getMemJob());
         pstmt.setString(idx++, member.getMemLike());
         pstmt.setString(idx++, member.getMemMemorial());
         if(member.getMemMemorialday()!=null) {
            pstmt.setDate(idx++, Date.valueOf(member.getMemMemorialday()));
         }else {
            pstmt.setDate(idx++, null);
         }
         return pstmt.executeUpdate();
         
      }catch (SQLException e) {
         throw new CustomPersistenceException(e);
      }
   }

   @Override
   public MemberVO selectMember(String memId) {
      StringBuffer sql = new StringBuffer();
      sql.append(" SELECT                                                  ");
      sql.append("     mem_id,    mem_pass,    mem_name,                   ");
      sql.append("     mem_regno1,    mem_regno2,    mem_bir,              ");
      sql.append("     mem_zip,    mem_add1,    mem_add2,                  ");
      sql.append("     mem_hometel,    mem_comtel,    mem_hp,              ");
      sql.append("     mem_mail,    mem_job,    mem_like,                  ");
      sql.append("     mem_memorial,    mem_memorialday,    mem_mileage,   ");
      sql.append("     mem_delete                                          ");
      sql.append(" FROM    member                                          ");
      sql.append(" where mem_id = ?                                        ");
      
      return mapper.selectOne(sql.toString(), MemberVO.class, new String[] {memId});
   }

   @Override
   public List<MemberVO> selectMemberList() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public int updateMember(MemberVO member) {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public int deleteMember(String memId) {
      // TODO Auto-generated method stub
      return 0;
   }

}