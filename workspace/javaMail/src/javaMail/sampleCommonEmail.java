package javaMail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

public class sampleCommonEmail {

   public static void main(String[] args) {
      
       SimpleEmail email = new SimpleEmail();
       try {
          email.setCharset("euc-kr");           // 한글 인코딩을 위한 설정 
          email.setHostName("smtp.naver.com");  // SMTP 서버를 지정
          email.setSmtpPort(587);              // SMTP 포트번호 지정 (465, 587)
          email.setAuthenticator(new DefaultAuthenticator("dlddu20", ""));    // SMTP 메일 아이디, 비밀번호 검사
          email.addTo("wjdtlr526@naver.com", "윤정식"); // 수신자를 추가
          email.setFrom("dlddu20@naver.com", "윤정식"); // 보내는 사람 지정
          email.setSubject("텍스트 테스트 메일입니다."); // 메일 제목
          email.setContent("테스트 메일의 내용입니다.", "text/plain; charset=euc-kr");      // 본문 내용, 인코딩 설정
          email.send(); // 메일 발송
          System.out.println("메일발송 완료");
      } catch (Exception e) {
         e.printStackTrace();
      }
      
   }

}