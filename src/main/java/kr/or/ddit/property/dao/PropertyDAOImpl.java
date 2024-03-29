package kr.or.ddit.property.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.common.exception.CustomPersistenceException;
import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.vo.PropertyVO;

public class PropertyDAOImpl implements PropertyDAO {

	@Override
	public int insertProperty(PropertyVO newProp) {
		StringBuffer sql = new StringBuffer();
	      sql.append(" INSERT INTO TB_PROPERTIES(property_name, property_value, description) ");
	      sql.append(" VALUES( ?, ?, ?) ");
	      
	      try (Connection conn = ConnectionFactory.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
	            pstmt.setString(1, newProp.getPropertyName());
	            pstmt.setString(2, newProp.getPropertyValue());
	            pstmt.setString(3, newProp.getDescription());
	            
	         return pstmt.executeUpdate();
	      } catch (SQLException e) {
	         throw new CustomPersistenceException(e);
	      }
	}

	@Override
	public List<PropertyVO> selectProperties() {
		StringBuffer sql = new StringBuffer();

		sql.append(" SELECT PROPERTY_NAME, PROPERTY_VALUE, DESCRIPTION, PROP_DATE, PROP_TIMESTAMP ");
		sql.append(" FROM TB_PROPERTIES ");

		List<PropertyVO> propList = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement();) {
			ResultSet rs = stmt.executeQuery(sql.toString());
			while (rs.next()) {
				PropertyVO propVO = new PropertyVO();
				propList.add(propVO);
				propVO.setPropertyName(rs.getString("PROPERTY_NAME"));
				propVO.setPropertyValue(rs.getString("PROPERTY_VALUE"));
				propVO.setDescription(rs.getString("DESCRIPTION"));
				Date propDate = rs.getDate("PROP_DATE");
				propVO.setPropDate(propDate.toLocalDate());
				Timestamp propTimeStamp = rs.getTimestamp("PROP_TIMESTAMP");
				propVO.setPropTimestamp(propTimeStamp.toLocalDateTime());
			}
			return propList;
		} catch (SQLException e) {
			throw new CustomPersistenceException(e);
		}
	}

	@Override
	public PropertyVO selectProperty(String propertyName) {
		StringBuffer sql = new StringBuffer();

		sql.append(" SELECT PROPERTY_NAME, PROPERTY_VALUE, DESCRIPTION, PROP_DATE, PROP_TIMESTAMP ");
		sql.append(" FROM TB_PROPERTIES ");
		sql.append(String.format(" WHERE PROPERTY_NAME = '%s' ", propertyName));

		PropertyVO propVO = null;
		try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement();) {
			ResultSet rs = stmt.executeQuery(sql.toString());
			if (rs.next()) {
				propVO = new PropertyVO();
				propVO.setPropertyName(rs.getString("PROPERTY_NAME"));
				propVO.setPropertyValue(rs.getString("PROPERTY_VALUE"));
				propVO.setDescription(rs.getString("DESCRIPTION"));
				Date propDate = rs.getDate("PROP_DATE");
				propVO.setPropDate(propDate.toLocalDate());
				Timestamp propTimeStamp = rs.getTimestamp("PROP_TIMESTAMP");
				propVO.setPropTimestamp(propTimeStamp.toLocalDateTime());
			}
			return propVO;
		} catch (SQLException e) {
			throw new CustomPersistenceException(e);
		}
	}

	@Override
	public int updateProperty(PropertyVO modifyProp) {
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE TB_PROPERTIES    ");
		sql.append(" SET                     ");
		sql.append(" PROPERTY_VALUE = ? ,    ");
		sql.append(" DESCRIPTION = ?        ");
		sql.append(" WHERE PROPERTY_NAME= ?  ");

		try (Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setString(1, modifyProp.getPropertyValue());
			pstmt.setString(2, modifyProp.getDescription());
			pstmt.setString(3, modifyProp.getPropertyName()); // ab' OR '1'='1
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int deleteProperty(String propertyName) {
		StringBuffer sql = new StringBuffer();
		sql.append( " DELETE FROM TB_PROPERTIES ");
		sql.append( " WHERE PROPERTY_NAME = ? ");
		
		try (Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setString(1, propertyName);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}