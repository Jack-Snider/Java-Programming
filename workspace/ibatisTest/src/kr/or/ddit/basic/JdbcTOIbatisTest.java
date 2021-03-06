package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.vo.LprodVO;

// JdbcTest프로젝트에 있는 JdbcTest05.java를 iBatis로 처리되도록 하시오.
public class JdbcToIbatisTest {

	public static void main(String[] args) {
		/*
		    * LPROD테이블에 새로운 데이터를 추가하기
		    * 
		    * - lprod_gu와 lprod_nm은 직접 입력 받아서 처리하고, lprod_id는 현재의 lprod_id 중 제일 큰 값보다 1
		    * 크게해서 처리한다. 
		    * - 그리고 입력받은 lprod_gu가 이미 등록되어 있는 데이터면 다시 입력 받아서 처리한다.
		    * 
		    */
		Scanner scanner = new Scanner(System.in);
	      try {
	         
	         Charset charset = Charset.forName("utf-8");
	         Resources.setCharset(charset);
	         Reader rd = Resources.getResourceAsReader("kr/or/ddit/config/sqlMapConfig.xml");

	         SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
	         
	         rd.close();
	         
	         LprodVO lprodVo = null;
	         
	         String lprod_gu;
	         String lprod_nm;
	         
	         while (true) {
	            System.out.print("lprod_gu : ");
	            lprod_gu = scanner.next();
	            System.out.print("lprod_nm : ");
	            lprod_nm = scanner.next();
	            
	            lprodVo = (LprodVO)smc.queryForObject("jdbc.getLprod", lprod_gu);
	            
	            if(lprodVo==null) {
	               break;
	            }else {
	               System.out.println("already exist...");
	            }
	            
	         }
	         
	         lprodVo = new LprodVO();
	         lprodVo.setLprod_gu(lprod_gu);
	         lprodVo.setLprod_nm(lprod_nm);
	         
	         int result = smc.update("jdbc.insertLprod",lprodVo);
	         
	         if(result > 0) {
	            System.out.println("insert success...");
	         }else {
	            System.out.println("insert failed...");
	         }

	      } catch (SQLException e) {
	         e.printStackTrace();
	         // TODO: handle exception
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } 
	   }
}