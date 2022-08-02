package kr.or.ddit.basic;

import org.apache.log4j.Logger;

public class Log4jTest {
	
	// Logger클래스의 인스턴스를 받아온다.
	// 변수를 static으로 한 이유는 static메소드에서도 사용하기 위해서
	static Logger logger = Logger.getLogger(Log4jTest.class);
	
	public static void main(String ... args) {
	
		// log기록을 남기는 방법
		// 형식1) Logger객체변수.로그레벨명("출력할 메세지");
		// 형식2) Logger객체변수.log(Level.로그레벨명, "출력할 메세지");
		logger.trace("이것은 레벨이 Trace인 출력 내용입니다.");
		logger.debug("이것은 레벨이 debug인 출력 내용입니다.");
		logger.info("이것은 레벨이 info인 출력 내용입니다.");
		logger.warn("이것은 레벨이 warn인 출력 내용입니다.");
		logger.error("이것은 레벨이 error인 출력 내용입니다.");
		logger.fatal("이것은 레벨이 fatal인 출력 내용입니다.");
		
		
		
	}
	 
}
