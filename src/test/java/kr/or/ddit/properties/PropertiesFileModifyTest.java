package kr.or.ddit.properties;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import org.junit.jupiter.api.Test;

import kr.or.ddit.servlet08.ServerTimeServlet;

class PropertiesFileModifyTest {

	@Test
	void test() throws URISyntaxException, FileNotFoundException, IOException {
		String logicalPath = "/kr/or/ddit/message/message-common_en.properties";
		URL realPath = ServerTimeServlet.class.getResource(logicalPath);
		File file = new File(realPath.toURI());
		
		Properties properties = new Properties();
		try(
			FileInputStream fis = new FileInputStream(file);	
		){
			properties.load(fis);
		}
		
		properties.setProperty("cop.sms.trnsmitCn", "newValue");
		properties.remove("cop.ntceEndde");
		
		try(
			FileOutputStream fos = new FileOutputStream(file);	
		){
			properties.store(fos, "추가한 데이터.");
		}
	}

}

















