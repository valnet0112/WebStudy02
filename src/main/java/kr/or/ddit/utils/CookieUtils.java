package kr.or.ddit.utils;

import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * request 를 통해 재전송된 쿠키를 검색하는 유틸리티
 *
 */
public class CookieUtils {
	public static Cookie findCookie(HttpServletRequest request, String name) {
		return Optional.ofNullable(request.getCookies())
				.map(ca->Arrays.stream(ca))
				.orElse(Stream.empty())
				.filter(c->name.equals(c.getName()))
				.findFirst()
				.orElse(null);
	}
	
	public static String findCookieValue(HttpServletRequest request, String name){
		return Optional.ofNullable(findCookie(request, name))
				.map(c->{
					try {
						return URLDecoder.decode(c.getValue(), "UTF-8");
					}catch (Exception e) {
						throw new RuntimeException(e);
					}
				}).orElse(null);
	}
}




















