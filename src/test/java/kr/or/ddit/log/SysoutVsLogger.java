package kr.or.ddit.log;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SysoutVsLogger {
   private static final Logger log = LoggerFactory.getLogger(SysoutVsLogger.class);
   
   @Test
   void testLogging() {
      byte[] array = new byte[1024000];
      for(int i = 0; i<array.length; i++) {
         array[i] = (byte) (Math.random() * 10);
      }
      log.info("배열의 값 확인 : {}",array); //{}는 message argument
   }
   
   @Test
   void testSysout() {
      byte[] array = new byte[1024000];
      for(int i = 0; i<array.length; i++) {
         array[i] = (byte) (Math.random() * 10);
      }
      System.out.println(Arrays.toString(array));
   }
}
//프로세싱타임 vs 레이턴시타임