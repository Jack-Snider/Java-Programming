package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookService {
	Scanner sc = new Scanner(System.in);
	String input;
	HashMap<String, Phone> map = new HashMap();
	public String FileName="d:/d_other/phoneData.dat";

	public void join() { // 정보등록메소드 map.put(,)이용

		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.print("이 름 : ");
		input = sc.nextLine();
		if (map.containsKey(input)) {
			System.out.println(input + "님은 이미 등록된 사람입니다.");
		} else {
			System.out.print("전화번호  : ");
			String ph = sc.nextLine();
			System.out.print("주 소 : ");
			String ad = sc.nextLine();
			Phone p = new Phone(input, ph, ad);

			map.put(input, p);
			System.out.println("등록이 완료 되었습니다.");
		}
	}

	public void rename() {// 전화번호수정
		System.out.print("수정 할 이름입력 : ");
		input = sc.nextLine();

		if (map.containsKey(input)) {
			System.out.print("수정 할 번호 입력 :");
			String tel = sc.nextLine();
			map.get(input).setTel(tel);
			System.out.println("수정이 완료 되었습니다.");
		} else {
			System.out.println("등록된 정보가 없습니다.");
		}
	}

	public void delete() {// 전화번호삭제 map.remove()이용

		System.out.print("삭제 할 이름입력 : ");
		input = sc.nextLine();

		if (map.containsKey(input)) {
			map.remove(input);
			System.out.println("삭제가 완료 되었습니다.");
		} else {
			System.out.println("등록된 정보가 없습니다.");
		}
	}

	public void search() {// 전화번호검색 map.get()이용

		System.out.print("검색 할 이름입력 : ");
		input = sc.nextLine();
		if (map.containsKey(input)) {
			System.out.println(map.get(input));
		} else {
			System.out.println("등록된 정보가 없습니다.");
		}

	}

	public void view() {// 전화번호 전체 출력

		Set<String> keySet = map.keySet();

		// Iterator<String> it = keySet.iterator();

		System.out.println("--------------------------");
		System.out.println("--------전체회원정보----------");
		for (String key : keySet) {
			Phone value = map.get(key);
			System.out.println(value);
		}
	}
	public void save() {
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FileName));
			oos.writeObject(map);
			System.out.println("저장이 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(oos!=null);
			try {
				oos.close();				
			}catch(IOException e) {
				
			}
		}
		boolean a =false;
	}
	public void load(){
		File file = new File(FileName);
		if(!file.exists()) {
			return;
		}
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			
			map = (HashMap<String, Phone>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			return;
		}finally {
			if(ois!=null)
				try {
					ois.close();
				}catch(IOException e) {
					
				}
		}
		return;
	}
	
}