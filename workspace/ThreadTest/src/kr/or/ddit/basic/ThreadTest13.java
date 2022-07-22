package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 10마리의 말들이 경주하는 경마 프로그램 작성하기
 * 
 * 말은 Horse라는 이름의 쓰레드 클래스로 작성하는데
 * 이 클래스는 말이름(String), 등수(int), 현재위치(int)를 멤버변수로 갖는다.
 * 그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬 기준이 있다.
 * (Comparable 인터페이스 구현)
 * 
 * 경기 구간은 1~50구간으로 되어 있다.
 * 말의 현재 위치는 현재 말이 달리고 있는 현재의 구간 값이 저장된다.
 * 
 * 경기가 진행되는 동안에는 중간 중간에 각 말들의 위치를 나타내시오.
 * 예)
 * 말이름01 : --->-------------------------------------
 * 말이름02 : ---------------------->------------------
 * ...
 * 말이름10 : ->---------------------------------------
 * 
 * 경기가 끝나면 등수 순으로 정렬하여 출력한다.
 * 
 */

public class ThreadTest13 {

	public static void main(String[] args) {
		Horse[] horse = new Horse[] {
				
				new Horse ("1번말"),
				new Horse ("2번말"),
				new Horse ("3번말"),
				new Horse ("4번말"),
				new Horse ("5번말"),
				new Horse ("6번말"),
				new Horse ("7번말"),
				new Horse ("8번말"),
				new Horse ("9번말"),
				new Horse ("10번말")				
		};
		
		playState state = new playState(horse);
		
		for(Horse h : horse) {
			h.start();
		}
		state.start();
		
		for(Horse h : horse) {
			try {
				h.join();
			}catch(InterruptedException e) {
				
			}
		}
		try {
			state.join();
		}catch(InterruptedException e) {
			
		}
		System.out.println();
		System.out.println("경기가 끝났습니다.");
		System.out.println();
		
		Arrays.sort(horse);
		
		System.out.println("경기결과");
		for(Horse h : horse) {
			System.out.println(h);
		}
		
		
	}

}

class Horse extends Thread implements Comparable<Horse> {
	public static int currentRank = 0;
	private String horseName;
	private int rank;
	private int location;

	public Horse(String horseName) {
		this.horseName = horseName;

	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "경주마" + horseName + "은" + rank + "등 입니다.";
	}

	@Override
	public int compareTo(Horse h) {
		return Integer.compare(rank, h.getRank());
	}

	@Override
	public void run() {
		for (int i = 1; i <= 50; i++) {
			location = i;
			try {
				Thread.sleep((int) (Math.random() * 400));
			} catch (InterruptedException e) {
			}
		}
		rank = ++Horse.currentRank;
	}
}

class playState extends Thread {
	private Horse[] horse;

	public playState(Horse[] horse) {
		this.horse = horse;
	}

	@Override
	public void run() {
		while (true) {
			if (Horse.currentRank == horse.length)
				break;
			else {
				for (int i = 1; i <= 10; i++) {
					System.out.println();
				}
				for (int i = 0; i < horse.length; i++) {
					System.out.print(horse[i].getHorseName() + " : ");
					for (int j = 1; j <= 50; j++) {
						if (horse[i].getLocation() == j) {
							System.out.print(">");
						} else {
							System.out.print("-");
						}
					}
					System.out.println();
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {

				}
			}
		}
		
	}

}