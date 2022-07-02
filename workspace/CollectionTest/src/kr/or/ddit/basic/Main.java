package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class RoomSystem{
	
	String input = "";
	Map<Integer, Room> map = new HashMap<Integer, Room>();
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
	public void start() {
		
		room_settings();
		
		while(true) {
			System.out.println("*********************************************");
			System.out.println("\t 호텔문을 열었습니다. 어서오세요.");
			System.out.println("*********************************************");
			
			System.out.println("-----------------------------------------------------------");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1. 체크인   2. 체크아웃   3. 객실상태   4.업무종료");
			System.out.println("-----------------------------------------------------------");
			System.out.print("선택 >> ");
			try {
				input = bf.readLine();
			}catch(Exception e) {}
		
			if(input.equals("1")) {
				check_in();
			}else if(input.equals("2")) {
				check_out();
			}else if(input.equals("3")) {
				room_status();
			}else if(input.equals("4")) {
				System.out.println("안녕히 가세요 다음에 또 오세요.");
				break;
			}else {
				System.out.println("입력이 올바르지 않습니다. 다시 입력해주세요.");
			}
			
		}
		
	}
	
	
	public void check_in() {
		System.out.println("----------------------------------------------");
		System.out.println("체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println("* 201~209 : 싱글룸");
		System.out.println("* 301~309 : 더블룸");
		System.out.println("* 401~409 : 스위트룸");
		System.out.print("방번호 입력 >> ");
		try {
			input = bf.readLine();
		}catch(Exception e) {}
		
		if(map.containsKey(Integer.parseInt(input))) { // 올바른 방번호를 입력 했는지 검사
			if(map.get(Integer.parseInt(input)).getName() == null) { // 해당 방번호에 이름이 없는지 검사(예약가능한 방인지 확인)
				System.out.println("누구를 체크인 하시겠습니까?");
				System.out.print("이름 입력 >> ");
				String name = "";
				try {
					name = bf.readLine();
					
					map.get(Integer.parseInt(input)).setName(name);
					
				}catch(Exception e) {}				
			}else {
				System.out.println(input + "객실은 이미 손님이 있습니다.");
			}
			
		}else {
			System.out.println(input + "호 객실은 존재하지 않습니다.");
		}
		
		
	}
	
	public void check_out() {
		int room_num = 0;
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃 작업");
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.print("방번호 입력 >> ");
		try {
			room_num = Integer.parseInt(bf.readLine());
			if(map.containsKey(room_num)) {
				if(map.get(room_num).getName() != null) {
					String name = map.get(room_num).getName();
					System.out.println(room_num + "호 객실의 " + name + "님 체크아웃을 완료하였습니다.");
					map.get(room_num).setName(null);
				}else {
					System.out.println(room_num + "호 객실에 체크인 한 사람이 없습니다.");
				}
			}else {
				System.out.println(room_num + "호 객실은 존재하지 않습니다.");
			}
		}catch(Exception e) {}
	}
	
	public void room_status() {
		System.out.println("----------------------------------------------");
		System.out.println("                       현재 객실 상태                                         ");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호             방 종류             투숙객 이름");
		
		Set<Integer> set = map.keySet();
		List<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()) {
			int key = iter.next();
			String room_kind = map.get(key).getRoom_kind();
			String name = map.get(key).getName();
			if(name == null) {
				name = "-";
			}
			System.out.println(key + "\t   \t" + room_kind + "\t   \t" + name);
		
		}
		
	}
	
	
	public void room_settings() {
		
		map.put(201, new Room(201,"싱글룸"));
		map.put(202, new Room(202,"싱글룸"));
		map.put(203, new Room(203,"싱글룸"));
		map.put(204, new Room(204,"싱글룸"));
		map.put(205, new Room(205,"싱글룸"));
		map.put(206, new Room(206,"싱글룸"));
		map.put(207, new Room(207,"싱글룸"));
		map.put(208, new Room(208,"싱글룸"));
		map.put(209, new Room(208,"싱글룸"));
		
		map.put(301, new Room(301,"더블룸"));
		map.put(302, new Room(302,"더블룸"));
		map.put(303, new Room(208,"더블룸"));
		map.put(304, new Room(208,"더블룸"));
		map.put(305, new Room(208,"더블룸"));
		map.put(306, new Room(208,"더블룸"));
		map.put(307, new Room(208,"더블룸"));
		map.put(308, new Room(208,"더블룸"));
		map.put(309, new Room(208,"더블룸"));
		
		map.put(401, new Room(401,"스위트룸"));
		map.put(402, new Room(402,"스위트룸"));
		map.put(403, new Room(403,"스위트룸"));
		map.put(404, new Room(404,"스위트룸"));
		map.put(405, new Room(405,"스위트룸"));
		map.put(406, new Room(406,"스위트룸"));
		map.put(407, new Room(407,"스위트룸"));
		map.put(408, new Room(408,"스위트룸"));
		map.put(409, new Room(409,"스위트룸"));
		
			
	}
	
	
	
	
}


class Room{
	
	private int room_num;
	private String room_kind;
	private String name;
	
	
	public Room() {}
	
	public Room(int room_num, String room_kind) {
		
		this.room_num = room_num;
		this.room_kind = room_kind;
	
	}
	public int getRoom_num() {
		return room_num;
	}
	public void setRoom_num(int room_num) {
		this.room_num = room_num;
	}
	public String getRoom_kind() {
		return room_kind;
	}
	public void setRoom_kind(String room_kind) {
		this.room_kind = room_kind;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}

public class Main {
	public static void main(String[] args) {
		RoomSystem rs = new RoomSystem();
		
		rs.start();
		
	}
}
