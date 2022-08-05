package kr.or.ddit.file.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.file.service.FileinfoServiceImpl;
import kr.or.ddit.file.service.IFileinfoService;
import kr.or.ddit.vo.FileinfoVO;


@WebServlet("/images/imageSrcView.do")
public class ImageSrcView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 파라미터로 넘어온 파일 변호를 받는다.
		String strFileNo = request.getParameter("fileno");
		int fileNo = Integer.parseInt(strFileNo);
		
		// 파일 번호를 이용하여 DB에서 해당 파일 정보를 가져온다.
		IFileinfoService service = FileinfoServiceImpl.getInstance();
		FileinfoVO fvo = service.getFileinfo(fileNo);
		
		// 이미지 파일이 저장된 폴더 경로
		String filePath = "d:/d_other/uploadFiles";
		
		// 파일 정보에서 실제 저장된 파일명을 지정한다.
		File file = new File(filePath, fvo.getSave_file_name());
		
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		if(file.exists()){ // 이미지 파일이 있을 때...
			try {
				// 풀력문 스트림객체 생성
				bout = new BufferedOutputStream(response.getOutputStream());
				
				//파일 입력응용 스트림 객체 생성
				bin = new BufferedInputStream(new FileInputStream(file));
				
				byte[] temp = new byte[1024];
				int len = 0;
				while( (len = bin.read(temp)) > 0 ) {
					bout.write(temp, 0, len);
				}
				
				bout.flush();
				
				
			} catch (Exception e) {
				System.out.println("입출력 오류 : " + e.getMessage());;
			} finally {
				if(bin != null) try {bin.close();} catch(IOException e) {}
	            if(bout != null) try {bout.close();} catch(IOException e) {}
			}
			
			
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
