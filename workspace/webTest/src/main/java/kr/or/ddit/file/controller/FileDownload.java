package kr.or.ddit.file.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.file.service.FileinfoServiceImpl;
import kr.or.ddit.file.service.IFileinfoService;
import kr.or.ddit.vo.FileinfoVO;

/**
 * Servlet implementation class FileDownload
 */
@WebServlet( "/fileDownload.do" )
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding( "utf-8" );
		response.setCharacterEncoding( "utf-8" );
		
		// 파라미터로 넘어온 파일번호 받는다.
		String strFileNo = request.getParameter( "fileno" );
		int fileNo = Integer.parseInt( strFileNo );
		
		// 파일 번호를 이용하여 DB에서 
		IFileinfoService service = FileinfoServiceImpl.getInstance();
		FileinfoVO fvo = service.getFileinfo( fileNo );
		
		// 업로드될 파일들이 저장될 폴더 설정 ==> 서버쪽의 파일 경로
		String uploadPath = "d:/d_other/uploadFiles";
		
		// 저장된 폴더가 없으면 새로 만든다.
		File f = new File( uploadPath );
		if(!f.exists()) {
			f.mkdirs();
		}
		
		// 다운로드할 파일의 File객체 생성 ==> 저장 파일명으로 저장한다.
		File downFile = new File( f, fvo.getSave_file_name() );
		
		if(downFile.exists()) { // 파일이 있을 때
			// ContentType 설정
			response.setContentType( "application/octet-stream; charset=utf-8" );
			
			// Response에 content-disposition 헤더 속성을 설정한다.
			String headerKey = "content-disposition";
			
			// 이곳에는 다운로드할 때 
			String headerValue = 
					"attachment; " + getEncodingFileName(request,fvo.getOrigin_file_name()); 
			
			response.setHeader(headerKey, headerValue);
			
			BufferedInputStream bin = null;
			BufferedOutputStream bout = null;
			
			try {
				// 출력용 스트림 객체 생성 ==> response객체 이용
				bout = new BufferedOutputStream(response.getOutputStream());
				
				// 파일 입력용 스트림 객체 생성
				bin = new BufferedInputStream(new FileInputStream(downFile));

				byte[] temp = new byte[1024];
				int len = 0;
				
				// byte배열을 이용하여 파일 내용을 읽어서 출력용 스트림으로 출력한다.
				while( (len = bin.read( temp )) > 0 ) {
					bout.write( temp, 0, len );
				}
				bout.flush();
				
			} catch (Exception e) {
				System.out.println("입출력 오류 : " + e.getMessage());
			} finally {
				if( bout != null ) try { bout.close(); } catch( IOException e) {};
				if( bin != null ) try { bin.close(); } catch( IOException e) {};
			}
			
		}else { // 파일이 없을 때
			response.setCharacterEncoding( "utf-8");
			response.setContentType( "text/html; charset=utf-8" );
			response.getWriter().println( "<h3>" + fvo.getOrigin_file_name() + "파일이 존재하지 않습니다." );
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	// 다운로드 파일명이 한글일 때 한글이 깨지는 것을 방지하는 메소드
	private String getEncodingFileName(HttpServletRequest request, String fileName) {
		String encodedFileName = "";
		String userAgent = request.getHeader("User-Agent");
		
		try {
			// MSIE 버전 10이하의 웹브라우저
			if(userAgent.contains("MSIE") || userAgent.contains("Trident")) {
				encodedFileName =	"filename=\"" + URLEncoder.encode(fileName,"utf-8").replaceAll("\\+", "\\ ") + "\"";						
			}else {
				encodedFileName = "filename*=UTF-8''" +
						URLEncoder.encode(fileName, "utf-8").replaceAll("\\+", "%20");
			}
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("지원하지 않는 인코딩 방식입니다.");
		}
		
		return encodedFileName;
		
	}
	
}




























