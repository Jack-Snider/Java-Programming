package kr.or.ddit.zippro.config;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import javax.annotation.Resources;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {
	private static SqlMapClient smc;
	
	static {
		Charset charset = Charset.forName("UTF-8");
		Resources.setCharset(charset);
		
		Reader rd = null;
		try {
			rd = Resources.getResourceAsReader("kr/or/ddit/zippro/config/sqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//스트림 닫기
			if(rd!=null)try {rd.close();}catch(IOException e) {}
		}
	}
	
	public static SqlMapClient getsqlMapClient() {
		return smc;
	}
}
