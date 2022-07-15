package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*

   /*
   회원 관리 프로그램을 작성하시오. (MYMEMBER 테이블 이용)
   
   아래 메뉴의 기능을 모두 구현하시오. (CRUD기능 구현하기)
   
   메뉴예시)
      -- 작업 선택 --
      1. 자료 추가                     --> INSERT      (C)
      2. 자료 삭제                     --> DELETE      (D)
      3. 자료 수정                     --> UPDATE   (U)
      4. 전체 자료 출력               --> SELECT      (R)
      0. 작업 끝.
   --------------------
   작업선택 > 
   
   처리조건)
   1) 자료 추가에서 '회원ID'는 중복되지 않는다.(중복되면 다시 입력받는다.)
   2) 자료 삭제는 '회원ID'를 입력 받아서 처리한다.
   3) 자료 수정에서는 '회원ID'는 변경하지 않는다.   
   
   4) 자료 수정2 ==> 원하는 항목만 선택해서 수정되도록 한다.
     
     MVC패턴에 대하여 조사해오기
   
*/

public class JdbcTest06 {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		new JdbcTest06().memberStart();

	}

	public void getConnection() {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(

					"jdbc:oracle:thin:@192.168.143.14.1521:xe", "ddit", "java"

			);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	// 자원을 반납하는 메소드
	private void disConnect() {

		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}

	}

	public void memberStart() {

		while (true) {
			int choice = displayMenu();
			switch (choice) {
			case 1: // 추가
				insertMember();
				break;
			case 2: // 삭제
				deleteMember();
				break;
			case 3: // 수정
				updateMember();
				break;
			case 4: // 전체 출력
				displayMember();
				break;
			case 5:
				updateMember2();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다 ... ");
				return;
			default:
				System.out.println("작업 번호를 잘못 입력했습니다.");
				System.out.println("다시 입력하세요.");

			}
		}

	}

	// 메뉴를 출력하고 작업 번호를 입력 받아 반환하는 메소드
	private int displayMenu() {

		System.out.println();
		System.out.println("---------------------------");
		System.out.println("      1. 자   료   추   가");
		System.out.println("      2. 자   료   삭   제");
		System.out.println("      3. 자   료   수   정");
		System.out.println("      4. 전체   자료   출력");
		System.out.println("      5. 자   료   수   정   2");
		System.out.println("      0. 작   업   끝");
		System.out.print("   원하는 작업 선택 >> ");

		return scan.nextInt();

	}

	// 회원 정보를 수정하는 메소드 ==> 원하는 항목만 수정하기
	private void updateMember2() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요. ");

		System.out.println("회원ID >> ");
		String id = scan.next();

		int count = getMemberIdCount(id);

		if (count == 0) { // 없는 회원이면...
			System.out.println(id + "은(는) 없는 회원ID 입니다.");
			System.out.println("수정 작업을 종료합니다.");
			return;
		}

		int num;
		String field = null; // 수정할 항목의 컬럼명이 저장될 변수
		String title = null; // 수정할 항목을 입력 받을 때 사용할 메시지(항목명)

		do {
			System.out.println();
			System.out.println("수정할 항목을 선택하세요");
			System.out.println("1.비밀번호    2.회원이름     3.전화번호    4.회원주소");
			System.out.println("----------------------------------------------");
			System.out.println("수정할 항목 선택 >> ");
			num = scan.nextInt();

			switch (num) {
			case 1:
				field = "mem_pass";
				title = "비밀번호";
				break;
			case 2:
				field = "mem_name";
				title = "회원이름";
				break;
			case 3:
				field = "mem_tel";
				title = "전화번호";
				break;
			case 4:
				field = "mem_addr";
				title = "회원주소 ";
				break;
			default:
				System.out.println("다시선택하세요");
				break;
			}

		} while (num < 1 || num > 4);

		System.out.println();

		scan.nextLine();
		System.out.println("새로운 " + title + " >> ");
		String data = scan.nextLine();

		try {
			conn = DBUtil.getConnection();

			String sql = "update mymember set " + field + " = where mem_id = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, data);
			pstmt.setString(2, id);

			int cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println("수정 작업 성공!!!");
			} else {
				System.out.println("수정 작업 실패~~~");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}

	// 회원 정보를 수정하는 메소드
	// 자료 수정에서 '회원ID'는 변경되지 않는다.
	private void updateMember() {

		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요. ");

		System.out.println("회원ID >> ");
		String id = scan.next();

		int count = getMemberIdCount(id);

		if (count == 0) { // 없는 회원이면...
			System.out.println(id + "은(는) 없는 회원ID 입니다.");
			System.out.println("수정 작업을 종료합니다.");
			return;
		}

		System.out.println();
		System.out.print("새로운 회원 비밀번호 >> ");
		String newPass = scan.next();

		System.out.print("새로운 회원이름 >> ");
		String newName = scan.next();

		System.out.print("새로운 전화번호 >> ");
		String newTel = scan.next();

		scan.nextLine(); // 입력 버퍼 비우기
		System.out.print("새로운 회원주소 >> ");
		String newAddr = scan.nextLine();

		try {
			conn = DBUtil.getConnection();

			String sql = "UPDATE MYMEMBER SET " + " MEM_PASS = ? , MEM_NAME = ?, " + " MEM_TEL = ? , MEM_ADDR = ? "
					+ "WHERE MEM_ID = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPass);
			pstmt.setString(2, newName);
			pstmt.setString(3, newTel);
			pstmt.setString(4, newAddr);

			int cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println(id + " 회원 정보 수정 완료!!!");
			} else {
				System.out.println(id + " 회원 정보 수정 실패~~~");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

	}

	// 회원 정보를 삭제하는 메소드
	// 자료 삭제는 '회원id'를 입력 받아서 처리한다.
	private void deleteMember() {

		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요");
		System.out.print("회원 ID >> ");
		String id = scan.next();

		try {

			conn = DBUtil.getConnection();

			String sql = "DELETE FROM MYMEMBER WHERE MEM_ID = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			int cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println(id + " 회원 정보 삭제 성공");
			} else {
				System.out.println(id + " 회원은 없는 회원이거나 삭제에 실패했습니다...");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

	}

	// 전체 회원 정보를 출력하는 메소드
	private void displayMember() {

		System.out.println();
		System.out.println("--------------------------------------------");
		System.out.println("   ID         비밀번호         이름         전화번호         주소");
		System.out.println("--------------------------------------------");

		try {

			conn = DBUtil.getConnection();

			String sql = "SELECT * FROM MYMEMBER";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				String id = rs.getString("MEM_ID");
				String pass = rs.getString("MEM_PASS");
				String name = rs.getString("MEM_NAME");
				String tel = rs.getString("MEM_TEL");
				String addr = rs.getString("MEM_ADDR");

				System.out.println(id + "\t" + pass + "\t" + name + "\t" + tel + "\t" + addr);

			}
			System.out.println("-------------------------------------------");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

	}

	// 회원 정보를 추가하는 메소드
	// 자료 추가에서 '회원 ID'는 중복되지 않는다. (중복되면 다시 입력 받는다.)
	private void insertMember() {

		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요.");

		int count = 0;
		String memId = null;
		do {
			System.out.print("회원 ID >> ");
			memId = scan.next();

			count = getMemberIdCount(memId);

			if (count > 0) {
				System.out.println(memId + "은(는) 이미 등록된 회원ID 입니다.");
				System.out.println("다른 회원 ID를 입력하세요.");
			}

		} while (count > 0);

		System.out.print("비밀번호 >> ");
		String pass = scan.next();

		System.out.print("회원이름 >> ");
		String name = scan.next();

		System.out.print("전화번호 >> ");
		String tel = scan.next();

		System.out.print("회원주소 >> ");
		String addr = scan.next();

		try {

			conn = DBUtil.getConnection();

			String sql = "INSERT INTO MYMEMBER " + "(MEM_ID, MEM_PASS, MEM_NAME, MEM_TEL, MEM_ADDR) "
					+ " VALUES (?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, pass);
			pstmt.setString(3, name);
			pstmt.setString(4, tel);
			pstmt.setString(5, addr);

			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				System.out.println(memId + " 회원 정보 추가 완료!!");
			} else {
				System.out.println(memId + " 회원 정보 추가 실패!!");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}// insertMember메소드 끝

	// 회원ID를 인수값으로 받아서 해당 회원ID의 개수를 반환하는 메소드
	private int getMemberIdCount(String memId) {
		int count = 0;
		try {

			conn = DBUtil.getConnection();

			String sql = " SELECT COUNT(*) CNT FROM MYMEMBER " + " WHERE MEM_ID = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt("CNT");
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}

		return count;

	}

}
