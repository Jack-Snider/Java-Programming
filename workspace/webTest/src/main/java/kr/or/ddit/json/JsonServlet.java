package kr.or.ddit.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

// Ajax의 응답데이터를 JSON으로 보내주는 서블릿
@WebServlet("/jsonServlet.do")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// JSON형식으로 응답할 때의 설정 방법
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//-------------------------------------
		String choice = request.getParameter("choice");
		
		Gson gson = new Gson(); // Gson객체 생성
		
		String jsonData = null; // 처리용 데이터를 JSON형 식의 문자열로 반환한다.
		
		switch(choice) {
        case "str":   // 문자열 응답
           String temp = "안녕하세요";
           jsonData = gson.toJson(temp);   // 자바용 데이터를 JSON형식의 문자열로 변환한다.
           break;
           
        case "array":
        	int[] arr = {100,200,300,400,500};
        	jsonData = gson.toJson(arr);
        	break;
        	
        case "obj":
        	SampleVO sample = new SampleVO(101,"Jack Snider");
        	jsonData = gson.toJson(sample);
        	break;
        	
        case "list":
        	ArrayList<SampleVO> samList = new ArrayList<SampleVO>();
        	samList.add(new SampleVO(201,"이순신"));
        	samList.add(new SampleVO(202,"강감찬"));
        	samList.add(new SampleVO(203,"변학도"));
        	samList.add(new SampleVO(204,"일지매"));
        	jsonData = gson.toJson(samList);
        	break;
      
        case "map":
        	HashMap<String,String> map = new HashMap<String,String>();
        	map.put("name", "성춘향");
        	map.put("tel", "010-1234-5678");
        	map.put("addr", "대전시 중구 오류동");
        	jsonData = gson.toJson(map);
        	break;
        	
		}
		
     
	    System.out.println("jsonData => " + jsonData);
	    out.write(jsonData);   // JSON형식의 문자열을 응답데이터로 출력한다.
	    response.flushBuffer();
	
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
