package javaMail;

import java.util.Properties;               // 문자열을 Properties스트림에 저장하거나 스트림에서 로드할 수 있습니다.
import javax.mail.Message;                  // 전자 메일 메시지를 모델링하는 추상 클래스입니다.
import javax.mail.MessagingException;         // 예외처리
import javax.mail.PasswordAuthentication;      // Authenticator에서 사용하는 데이터 홀더입니다. 사용자 이름과 암호를 위한 저장소입니다.
import javax.mail.Session;                  // API의 키 클래스입니다. 세션 객체의 생성자는 private입니다. 따라서 별도의 Session객체를 가져오는 메서드를 제공합니다.
import javax.mail.Transport;               // 메시지 전송 메커니즘을 모델링하는 추상 클래스입니다. send()메서드를 호출해서 전송할 수 있다.
import javax.mail.internet.InternetAddress;      // RFC822구문을 사용하는 인터넷 이메일 주소를 나타냅니다. 기본 user@host.domain
import javax.mail.internet.MimeMessage;         // MIME유형과 헤더를 이해하는 전자 메일 메시지입니다. (MIME유형은 문서의 종류를 나타낸다)

public class SendEmail {

   public static void main(String[] args) {
      String host = "smtp.naver.com";               // SMTP 서비스를 해주는 메일 사이트
      final String user = "dlddu20@naver.com";      // 송신 계정 이메일
      final String password = "";                 // 송신 계정 비밀번호

      String to = "wjdtlr526@naver.com";            // 수신 계정 이메일

      
      Properties props = new Properties();      // 자바에서는 보통 Properties 파일에 설정정보를 저장합니다. (파일 입출력을 지원하고, key와 value 형식으로 작성된 프로퍼티 파일을 저장할 때 유용하다)
      props.put("mail.smtp.host", host);         //"mail.smtp.host"은 이메일 발송을 처리해줄 STMP 서버를 나타냅니다.
      props.put("mail.smtp.auth", "true");      // SMTP-AUTH를 확인하여 SMTP 서버에 접속할 수 있는 권한 취득
      
      
      // 세션 : 클라이언트 별로 서버에 저장되는 정보 (
      // 사용자 컴퓨터에 저장되던 쿠키와 다르게 서버에 저장되므로, 비교적 보안이 필요한 데이터는 쿠키보다 세션에 저장한다.
      // 서버가 종료되거나 유효기간이 지나면 사라진다.
      Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {   // Properties에 저장되어있는 설정 값을 getDefaultInstance() 메소드로 저장하여 세션 생성. Authenticator는 메일 서버의 메일 리소스를 보호하는 데 사용되는 추상 클래스입니다.
         protected PasswordAuthentication getPasswordAuthentication() {                  // 사용자 이름과 암호를 생성자에 전달하는 하위 클래스 PasswordAuthentication을 만듭니다.
            return new PasswordAuthentication(user, password);                        // 세션 객체를 생성할 때 세션에 인증자를 등록해야 합니다.
            
         }
      });

      // Compose the message
      try {
         MimeMessage message = new MimeMessage(session);
         
         // 발신자 셋팅
         message.setFrom(new InternetAddress(user));   // SMTP 발신자 이메일 주소
         
         // 수신자 셋팅
         // RecipientType = 받는사람 유형 (그룹, 사용자, 사서함, 폴더 등등)
         // InternetAddress(받는사람 메일)
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Subject
         // 메일 제목
         message.setSubject("[Subject] Java Mail Test");

         // Text
         // 메일 내용
         message.setText("Simple mail test..");

         // send the message
         // 메일 전송
         Transport.send(message);
         
         // 전송완료 출력 메세지
         System.out.println("message sent successfully...");

      } catch (MessagingException e) {
         e.printStackTrace();
      }
   }   

}