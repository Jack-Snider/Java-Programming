package kr.or.ddit.basic;
// FileTest02
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class File_Path {
	
	public static void main(String[] args) {
	
		File f1 = new File("d:/d_other/test.txt");
		System.out.println(f1.getName() + "의 크기 : " + f1.length() + "bytes");
		
		System.out.println("path : " + f1.getPath());
		System.out.println("absolutePath : " + f1.getAbsolutePath());
		
		System.out.println("----------------------------------");
		
		// 자바 프로그램의 실행 위치 구하기
		
		// 방법1 => File객체 이용하기(상대경로를 절대경로로 변환하기)
		File f2 = new File("."); // . 혹은 ""과 같이 빈칸은 현재 경로를 의미한다.
		System.out.println("path : " + f2.getPath());
		System.out.println("File객체 absolutePath : " + f2.getAbsolutePath());
		System.out.println();
		
		// 방법2 => Path객체 이용하기(상대경로를 절대경로로 변환하기)
		Path myPath = Paths.get("");
		System.out.println("Path객체 absolutedPath : " + myPath.toAbsolutePath().toString());
		System.out.println();
		
		// 방법3 => System.getProperty("user.dir")명령 이용하기
		System.out.println(System.getProperty("user.dir"));
		System.out.println();
		
	}
}
