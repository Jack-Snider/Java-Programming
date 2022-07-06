package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookTest {

	/*
	 * 
	 * 문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 만들고 Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
	 * 
	 * 조건)- Map의 구조는 key값을 '이름'으로 사용하고, value값으로 'Phone클래스의 인스턴스'로 한다.
	 * 
	 * 
	 * -추가조건) 
	 * 1)	'6. 전화번호 저장' 메뉴를 추가하고 구현한다.
	 * 		(저장파일명은 'phoneData.dat' 로 한다)
	 * 
	 * 2)	프로그램이 시작될 때 '저장된 파일'이 있으면 그 데이터를 읽어와
	 * 		Map에 세팅한다.
	 * 
	 * 3)	프로그램을 종료할 때 Map의 데이터가 수정되거나 
	 * 		추가 또는 삭제되었으면 데이터를 저장한 후 종료되도록 한다.
	 * 
	 * - 아래의 메뉴를 구성하고 기능을작성한다. ------------------ 1. 전화번호 등록 2. 전화번호 수정 3. 전화번호 삭제
	 * 4. 전화번호 검색 5. 전화번호 전체 출력 0. 프로그램 종료 ------------------
	 * 
	 * - 위 기능 중 삭제, 검색 기능은 '이름'을 입력받아서 처리한다. 실행예시) ------------------ 1. 전화번호 등록 2.
	 * 전화번호 수정 3. 전화번호 삭제 4. 전화번호 검색 5. 전화번호 전체 출력 0. 프로그램 종료 ------------------
	 * 번호입력 >> 1
	 * 
	 * 새롭게 등록할 전화번호 정보를 입력하세요. 이 름 >> 홍길동 전화번호 >> 010-1111-1111 주 소 >> 대전시 중구 오류동
	 * 
	 * '홍길동' 전화번호 정보 등록 완료
	 * 
	 * ------------------ 1. 전화번호 등록 2. 전화번호 수정 3. 전화번호 삭제 4. 전화번호 검색 5. 전화번호 전체 출력
	 * 0. 프로그램 종료 ------------------ 번호입력 >> 1
	 * 
	 * 새롭게 등록할 전화번호 정보를 입력하세요. 이 름 >> 홍길동
	 * 
	 * '홍길동'은 이미 등록된 사람입니다.
	 * 
	 * ------------------ 1. 전화번호 등록 2. 전화번호 수정 3. 전화번호 삭제 4. 전화번호 검색 5. 전화번호 전체 출력
	 * 0. 프로그램 종료 ------------------ 번호입력 >> 5
	 * 
	 * ======================================================================= 번호 이
	 * 름 전화번호 주 소
	 * ======================================================================= 1 홍길동
	 * 010-1111-1111 대전시 중구 오류동
	 * =======================================================================
	 * 
	 * ------------------ 1. 전화번호 등록 2. 전화번호 수정 3. 전화번호 삭제 4. 전화번호 검색 5. 전화번호 전체 출력
	 * 0. 프로그램 종료 ------------------ 번호입력 >> 0
	 * 
	 * 프로그램을 종료합니다.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	static Map<String, Phone> map = new HashMap<String, Phone>();
	Scanner sc = new Scanner(System.in);

	
	public void settings() {
		/*
		 * 2)	프로그램이 시작될 때 '저장된 파일'이 있으면 그 데이터를 읽어와
	 * 		Map에 세팅한다.
		 * 
		 */
		
		File f = new File("d:/d_other/phoneData.dat");
		if(f.exists()) {
			
		}
		
	}
	
	
	public void insert_phone_number() {
		/*
		 * 
		 * 새롭게 등록할 전화번호 정보를 입력하세요. 이 름 >> 홍길동 전화번호 >> 010-1111-1111 주 소 >> 대전시 중구 오류동
		 * 
		 * '홍길동' 전화번호 정보 등록 완료
		 * 
		 * 
		 */

		Phone p = null;
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = sc.nextLine();
		
		if(map.containsKey(name)) {
			System.out.println("이미 등록된 이름입니다.");
		}else {
			System.out.print("전화번호 >> ");
			String phone_num = sc.nextLine();
			System.out.print("주소 >> ");
			String address = sc.nextLine();
			p = new Phone(name, address, phone_num);
			map.put(p.getName(), p);
		}

	}

	public void update_phone_number() {
		
		System.out.print("이름을 입력해주세요 >> ");
		String name = sc.next();
		System.out.print("변경할 번호를 입력해주세요 >> ");
		String phone_num = sc.next();
		
		Set<String> keySet = map.keySet(); // map의 키값들을 set으로 바꿔줌
		Iterator<String> it = keySet.iterator(); // 그 set을 이터레이터로 바꿔줌
		
		map.get(name).setPhone_num(phone_num);;
		
		
		
	}

	public void delete_phone_number() {
		// 3. 전화번호 삭제
		
		System.out.print("이름을 입력해주세요 >> ");
		String name = sc.next();
		
		map.remove(name);
		
		System.out.println("삭제가 완료되었습니다.");
		
	}

	public void select_phone_number() {
		
		// 4. 전화번호 검색
		System.out.print("이름을 입력해주세요 >> ");
		String name = sc.next();
		
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		
		if(it.hasNext()) {
			String key = name;
			Phone value = map.get(key);
			
			System.out.println(" =======================================================================");
			System.out.println("번호         	이    름         	전화번호             	주      소");
			
			System.out.println("1" + "\t	" + value.getName() + "\t	" + value.getPhone_num() + "\t	" + value.getAddress());
			
		}
		
		System.out.println("삭제가 완료되었습니다.");
		
	}

	public void select_all_phone_number() {
		/*
		 * 
		 * 번호입력 >> 5
		 * 
		 * ======================================================================= 번호 이
		 * 름 전화번호 주 소
		 * ======================================================================= 1 홍길동
		 * 010-1111-1111 대전시 중구 오류동
		 * =======================================================================
		 * 
		 */

		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();

		int i = 1;
		System.out.println(" =======================================================================");
		System.out.println("번호         	이    름         	전화번호             	주      소");
		while (it.hasNext()) {
			String key = it.next();
			Phone value = map.get(key);

			System.out.println(i + "\t	" + value.getName() + "\t	" + value.getPhone_num() + "\t	" + value.getAddress());
			i++;
		}
		System.out.println(" =======================================================================");
	}
	
	public void store_data() {
		/*
		 -추가조건) 
	 * 1)	'6. 전화번호 저장' 메뉴를 추가하고 구현한다.
	 * 		(저장파일명은 'phoneData.dat' 로 한다)
	 * 
	 * 2)	프로그램이 시작될 때 '저장된 파일'이 있으면 그 데이터를 읽어와
	 * 		Map에 세팅한다.
	 * 
	 * 3)	프로그램을 종료할 때 Map의 데이터가 수정되거나 
	 * 		추가 또는 삭제되었으면 데이터를 저장한 후 종료되도록 한다.
		 */
		
		// 출력용 스트림 객체 생성
		try {
			FileOutputStream fout = 
					new FileOutputStream("d:/d_other/phoneData.dat");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			ObjectOutputStream oout = new ObjectOutputStream(bout);
			
			
			
			System.out.println("저장을 하기 시작합니다...");
			for(int i = 5; i >= 1; i--) {
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
				
			}
			// 이터레이터로 다 불러와서 하나씩 저장해야함.
			Set<String> keySet = map.keySet();
			Iterator<String> it = keySet.iterator();
			
			for(String name : keySet) {
				
				Phone p = map.get(name);
				
				String tmp = 
						"Name : " + p.getName() + " Address : " + p.getAddress() 
						+ " Phone Number : " + p.getPhone_num() + " \n";
				
				oout.writeObject(tmp);
				
			}
			
		
			System.out.println("저장이 완료되었습니다.");
			oout.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		
	}



	public static void main(String[] args) {

		System.out.println("프로그램 시작");
		PhoneBookTest pbt = new PhoneBookTest();

		Scanner sc = new Scanner(System.in);

		boolean isRun = true;
		while (true) {
			
			if(!isRun) {
				System.out.println("프로그램을 종료합니다...");
				break;
			}
			
			System.out.println("------------------");
			System.out.println("1. 전화번호 등록");
			System.out.println("2. 전화번호 수정");
			System.out.println("3. 전화번호 삭제");
			System.out.println("4. 전화번호 검색");
			System.out.println("5. 전화번호 전체 출력");
			System.out.println("6. 전화번호 저장");
			System.out.println("0. 프로그램 종료");
			System.out.println("------------------");
			System.out.print("번호입력 >> ");

			int n = sc.nextInt();

			switch (n) {
			case 1:
				pbt.insert_phone_number();
				break;
			case 2:
				pbt.update_phone_number();
				break;
			case 3:
				pbt.delete_phone_number();
				break;
			case 4:
				pbt.select_phone_number();
				break;
			case 5:
				pbt.select_all_phone_number();
				break;
			case 6:
				pbt.store_data();
				break;
			case 0:
				isRun = false;
				sc.close();
			default:
				System.out.println("올바른 입력 형식이 아닙니다.");
				break;
			}


		
			
		}

//		Phone p1 = new Phone("크리스탈","대덕인재개발원 403호","010-1234-5678");
//		map.put(p1.getName(), p1);
//		
//		Phone p2 = new Phone("헝디","대전 동구 가양동 160-37 302호","010-4321-9876");
//		map.put(p2.getName(), p2);
//		
//		Phone p3 = new Phone("2유영","충북 옥천군 군서면 월전2길 23-109","010-7412-3698");
//		map.put(p3.getName(), p3);
//		
//		Phone p4 = new Phone("요하네스","대전 동구 자양동","010-8521-9635");
//		map.put(p4.getName(), p4);

	}
}

class Phone {

	/*
	 * 문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 만들고 Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
	 */

	private String name;
	private String address;
	private String phone_num;

	@Override
	public String toString() {
		return "Phone [name=" + name + ", address=" + address + ", phone_num=" + phone_num + "]";
	}

	public Phone() {
	}

	public Phone(String name, String address, String phone_num) {
		this.name = name;
		this.address = address;
		this.phone_num = phone_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

}
