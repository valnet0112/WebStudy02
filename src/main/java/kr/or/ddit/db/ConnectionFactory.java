package kr.or.ddit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Factory Object Pattern = Factory Method Pattern : 객체 생성만을 전담하는 객체를 별도로 운영하는 패턴
 *
 */
public class ConnectionFactory {
   
   private static String url;
   private static String user;
   private static String password;
   private static DataSource dataSource;

   //static block (클래스로더에 의해 이 클래스가 로딩될때 딱 1번 실행되는 블럭)
   static {
      ResourceBundle dbInfo = ResourceBundle.getBundle("kr/or/ddit/db/dbInfo");
      url = dbInfo.getString("url");
      user = dbInfo.getString("user");
      password = dbInfo.getString("password");
      
      BasicDataSource bds = new BasicDataSource();
      dataSource = bds;
      bds.setDriverClassName(dbInfo.getString("driverClassName"));
      bds.setUrl(url);
      bds.setUsername(user);
      bds.setPassword(password);
      bds.setInitialSize(Integer.parseInt(dbInfo.getString("initialSize")));
      bds.setMaxWaitMillis(Long.parseLong(dbInfo.getString("maxWait")));
      bds.setMaxTotal(Integer.parseInt(dbInfo.getString("maxTotal")));
      bds.setMaxIdle(Integer.parseInt(dbInfo.getString("maxIdle")));
//      try {
//         Class.forName(dbInfo.getString("driverClassName")); //Qualified name
//      } catch (ClassNotFoundException e) {
//         throw new RuntimeException(e);
//      } 
   }//End of static block
   
   public static Connection getConnection() throws SQLException{
//      Connection conn = DriverManager.getConnection(url, user, password);
      Connection conn = dataSource.getConnection();
      return conn;
   }
}