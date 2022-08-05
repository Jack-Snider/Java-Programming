package kr.or.ddit.file.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.file.service.FileinfoServiceImpl;
import kr.or.ddit.file.service.IFileinfoService;
import kr.or.ddit.vo.FileinfoVO;

/*
    - Servlet 3.0이상에서 파일 업로드를 하려면 서블릿에 @MultipartConfig 애노테이션을 설정해야 한다.
    - @MultipartConfig 애노테이션에서 설정할 변수들...
    1) location : 업로드한 파일이 임시적으로 저장될 경로 지정 (기본값 : "")
    2) fileSizeThreshold : 이 속성에 지정한 값보다 큰 파일이 전송되면 location에 지정한
    임시 디렉토리에 저장한다. (단위 : byte, 기본값 : 0 (무조건 임시 디렉토리 사용))
    3) maxFileSize : 1개 파일의 최대 크기 (단위 : byte, 기본값 : -1L (무제한))
    4) maxRequestSize : 서버로 전송되는 Request객체의 전체 최대 크기 (모든파일크기 + formData)
    (단위 : byte, 기본값 : -1L (무제한))
 */

@WebServlet("/fileUpload.do")
@MultipartConfig(
   fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 30,
   maxRequestSize = 1024 * 1024 * 100
)
public class FileUpload extends HttpServlet {
   
   private static final long serialVersionUID = 1L;
      
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      // 업로드된 파일들이 저장될 폴더 설정 ==> 서버쪽의 파일 경로
      String uploadPath = "d:/d_other/uploadFiles";
      
      // 저장할 폴더가 없으면 새로 만든다.
      File f = new File(uploadPath);
      if(!f.exists()) {
         f.mkdirs();
      }
      
      // 파일이 아닌 일반 데이터는 getParameter()메서드나 getParameterValues()메서드를 이용해서 구한다.
      String userName = request.getParameter("username");
      System.out.println("일반 파라미터 값 : " + userName);
      //-----------------------------------------------------------------------------
      // 수신 받은 파일 데이터 처리하기
      String fileName = ""; // 전송된 파일명이 저장될 변수 선언
      
      // Upload한 파일 목록이 저장된 List객체 생성
      List<FileinfoVO> fileList = new ArrayList<FileinfoVO>();
      
      /*
         - Servlet 3.0이상에서 새롭게 추가된 Upload용 메서드
         1) request.getParts() ==> 전체 Part객체를 Collection에 담아서 반환한다.
         2) request.getPart("Part이름") ==> 지정된 'Part이름'을 가진 개별 Part객체를 반환한다.
          'Part이름'은 <form>태그 안의 입력요소의 name속성값으로 구별한다.
       */
      
      // 전체 Part객체 개수만큼 반복처리
      for(Part part : request.getParts()) {
         fileName = getFileName(part);
         // 찾은 파일명이 공백문자("")이면 이것은 파일이 아닌 일반 파라미터라는 의미이다.
         if(!"".equals(fileName)) {   // 파일인지 검사
            // 파일 정보가 저장될 VO객체 생성
            FileinfoVO fvo = new FileinfoVO();
            fvo.setFile_writer(userName);   // 작성자 셋팅
            fvo.setOrigin_file_name(fileName);   // 원래의 파일명 셋팅
            
            // 실제 저장되는 파일이름이 중복되는 것을 방지하기 위해서 UUID를 이용해서
            // 중복되지 않는 파일명을 만든다.
            String saveFileName = UUID.randomUUID().toString();
            
            // 새로 만들어진 저장파일명을 VO에 셋팅한다.
            fvo.setSave_file_name(saveFileName);
            
            // part.getSize()메서드 ==> upload된 파일의 크기를 반환(단위:byte)
            
            // byte단위의 파일 크기를 KB단위로 변환해서 VO에 셋팅
            fvo.setFile_size((long)(Math.ceil(part.getSize()/1024.0)));
            
            try {
               // upload된 파일을 서버의 저장 폴더에 저장하기
               // part.write()메서드 ==> upload된 파일을 저장하는 메서드
               part.write(uploadPath + File.separator + saveFileName); // 파일 저장
            } catch (Exception e) {
               e.printStackTrace();
            }
            fileList.add(fvo);   // upload된 파일 정보를 List에 추가하기
         }   // if문 끝...
      }   // for문 끝....
      // 업로드가 완료된 후에 업로드된 파일 정보를 DB에 추가한다.
      IFileinfoService service = FileinfoServiceImpl.getInstance();
      // List에 저장된 파일 정보들을 하나씩 DB에 추가하기
      for(FileinfoVO fileVo : fileList) {
         service.insertFileinfo(fileVo);
      }
      
      // DB에 추가작업이 완료된 후 파일 목록을 보여주는 페이지로 이동한다.
      response.sendRedirect(request.getContextPath()+"/fileList.do");
      
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

   //---------------------------------------------------------------------------------------------------------------------
   /*
       - Part객체의 구조
       1) 파일이 아닌 일반 데이터일 경우
       --------------23498asdsdqwekffg      ==> Part영역을 구분하는 구분선
       content-disposition: form-data; name="username"      ==> 파라미터 명
             ==> 빈줄
       hong   ==> 파라미터값
    */
   
   /*
        2) 파일일 경우
        --------------23498asdsdqwekffg      ==> Part영역을 구분하는 구분선
        content-disposition: form-data; name="uploadfile1"; filename="test1.txt"   ==> 파일정보
        content-type: text/plain      ==>   파일의 종류
                                ==> 빈줄
        abce1234안녕하세요               ==> 파일 내용
    */
   
   // Part구조 안에서 파일명을 찾는 메서드
   private String getFileName(Part part) {
      String fileName = "";
      
      // content-disposition헤더 정보 구하기
      String headerValue = part.getHeader("content-disposition"); // -> 값 : form-data; name="uploadfile1"; filename="test1.txt"
      String[] items = headerValue.split(";");
      for(String item : items) {
         if(item.trim().startsWith("filename")) {
            fileName = item.substring(item.indexOf("=")+2, item.length()-1);
         }
      }
      return fileName;
   }
   
}