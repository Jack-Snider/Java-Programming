package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Hotel {

	public static void main(String[] args) {
		Management mag = new Management();
		mag.checkIn();
		
	}

}

class Management {
	private HashMap<Integer, room> room;
	Scanner sc = new Scanner(System.in);
	
	
	public Management() {
		room = new HashMap<Integer, room>();
		for(int i=201; i<=209; i++) {
			room.put(i, new room(i,"싱글룸","-"));
		}
		for(int i=301; i<=309; i++) {
			room.put(i, new room(i,"더블룸","-"));
		}
		for(int i=401; i<=409; i++) {
			room.put(i, new room(i,"스위트룸","-"));
		}
	}
	
	void checkIn() {
		System.out.println("*********************************************\r\n"
				+ "       호텔문을 열었습니다. 어서오십시요.\r\n"
				+ "*********************************************");
		while(true) {
			System.out.println("-----------------------------------------------------------\r\n"
					+ "어떤 업무를 하시겠습니까?\r\n"
					+ "1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료\r\n"
					+ "-----------------------------------------------------------");
			System.out.println("선택>>");
			int input = sc.nextInt();
			
			switch(input) {
				case 1 :
					System.out.println("----------------------------------------------\r\n"
							+ "   체크인 작업\r\n"
							+ "----------------------------------------------\r\n"
							+ " * 201~209 : 싱글룸\r\n"
							+ " * 301~309 : 더블룸\r\n"
							+ " * 401~409 : 스위트룸\r\n"
							+ "----------------------------------------------");
					System.out.println("방 번호 입력 >>");
					int put = sc.nextInt();
					if(room.containsKey(put)) {
						System.out.println("누구를 체크인 하시겠습니까?");
						System.out.println("이름 입력 >>");
						String user = sc.next();
						if(room.get(put).getUser().equals("-")) {
							room.get(put).setUser(user);
							System.out.println("체크인이 완료되었습니다.");
						}else{
							System.out.println(put +"호 객실은 이미 손님이 있습니다.");
							
						}
					}else{
						System.out.println(put + "호 객실은 존재하지 않습니다.");
					}
					break;
				
				case 2 :
					System.out.println("----------------------------------------------\r\n"
							+ "   체크아웃 작업\r\n"
							+ "----------------------------------------------\r\n"
							+ "체크아웃 할 방 번호를 입력하세요.");
					System.out.println("방번호 입력 >>");
					int checkOut = sc.nextInt();
					if(room.containsKey(checkOut)) {
						if(room.get(checkOut).getUser().equals("-")) {
							System.out.println(checkOut + "호 객실에는 체크인 한 사람이 없습니다.");
						}else{
							System.out.println(checkOut + "호 객실의 " +room.get(checkOut).getUser()  + 
									"님 체크아웃을 완료하였습니다.");
							room.get(checkOut).setUser("-");																					
						}
					}else{
						System.out.println("호 객실은 존재하지 않습니다.");
					}					
					break;
					
				case 3 :
					Collection<room> values = room.values();
					ArrayList<room> list = new ArrayList<room>(values);
					System.out.println("----------------------------------------------\r\n"
							+ "		현재 객실 상태\r\n"
							+ "----------------------------------------------\r\n"
							+ "방 번호	 방 종류	 투숙객 이름\r\n"
							+ "----------------------------------------------");
					Collections.sort(list);
					for(room r : list) {
						System.out.println(r);
					}
					break;
					
				case 4 :
					System.out.println("*********************************************\r\n"
							+ "       호텔문을 닫았습니다.\r\n"
							+ "*********************************************");
					System.exit(0);
					break;
				
			}
		}
	}
}


class room implements Comparable<room> {
	private int roomNum;
	private String roomClass;
	private String user;

	public room() {}
	
	public room(int roomNum, String roomClass, String user) {
		super();
		this.roomNum = roomNum;
		this.roomClass = roomClass;
		this.user = user;
	}
	public String toString() {
		return "[객실 번호 : " + roomNum + ", 객실 종류 : " + roomClass + ", 이용자 : " + user + "]";
		
	}
	

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getRoomClass() {
		return roomClass;
	}

	public void setRoomClass(String roomClass) {
		this.roomClass = roomClass;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public int compareTo(room o) {
		return Integer.compare(this.roomNum, o.roomNum);
	}
}