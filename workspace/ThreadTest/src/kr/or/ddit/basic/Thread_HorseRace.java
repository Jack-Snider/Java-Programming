package kr.or.ddit.basic;

import java.util.Arrays;

public class Thread_HorseRace {

	public static void main(String[] args) {

		Horse[] horseArr = new Horse[] { 
				new Horse("요한"), new Horse("구자"),
				new Horse("유리"), new Horse("유영"),
				new Horse("은비"), new Horse("정식"),
				new Horse("찬솔"), new Horse("무곤"),
				new Horse("혜연"), new Horse("지수") 
				};

		GameState gs = new GameState(horseArr);

		// 말들의 달리기 시작...
		for (Horse h : horseArr) {
			h.start();
		}

		gs.start(); // 경주 상태를 나타내는 쓰레드 시작

		// 말들의 경주가 모두 끝날때까지 기다린다.
		try {
			for (Horse h : horseArr) {
				h.join(); // horse의 모든 스레드가 종료될때까지 기다린다.
			}
			
			// horse의 스레드가 모두 종료된 후, 출력을 위한 GameState의 스레드 객체가 종료될때 까지 기다린다.
			gs.join(); 
			
		} catch (InterruptedException e) {
			// TODO: handle exception
		}

		System.out.println();
		System.out.println("경기가 끝났습니다.");
		System.out.println();

		// 등수의 오름차순으로 정렬하기
		Arrays.sort(horseArr);

		System.out.println("경기 결과");
		for (Horse h : horseArr) {
			System.out.println(h);
		}

	}

}

// 말은 Horse라는 이름의 쓰레드 클래스로 작성하는데
// 이 클래스는 말이름(String), 등수(int), 현재위치(int)를 맴버변수로 갖는다.
// 그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬 기준이 있다.
class Horse extends Thread implements Comparable<Horse> {

	// 말의 등수를 구할 때 사용할 변수
	public static int currentRank = 0;

	private String horseName; // 말이름
	private int rank; // 등수
	private int location; // 현재 위치

	// 생성자
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

	// 등수의 오름차순 정렬 기준 만들기
	@Override
	public int compareTo(Horse h) {
		return Integer.compare(rank, h.getRank());
	}

	@Override
	public String toString() {
		return "경주마  " + horseName + "은(는) " + rank + "등 입니다.";
	}

	// 말이 달리기하는 부분을 쓰레드로 처리한다.
	@Override
	public void run() {
		// 경기 구간은 1~50구간으로 되어 있다.
		// 말의 현재위치는 현재 말이 달리고 있는 현재의 구간 값이 저장된다.
		for (int i = 1; i <= 50; i++) {
			location = i; // 말의 현재 위치를 location에 저장
			try {
				Thread.sleep((int) (Math.random() * 500));
			} catch (InterruptedException e) {}
		}

		// 한 마리의 말이 경주가 끝나면 등수를 구해서 저장한다.
		currentRank++;
		this.rank = currentRank;
	}

}

/*
 * 
 * 경기가 진행되는 동안에는 중간 중간에 각 말들의 위치를 나타내시오 예) 말이름01 :
 * ------>----------------------------- 말이름02 :
 * ---------------->------------------- ... 말이름10 :
 * ----------------------->-------------
 */
// 경기 중 말들의 현재 위치를 나타내는 쓰레드
class GameState extends Thread {

	private Horse[] horses; // 경기에 참가한 말들의 정보가 저장될 변수

	public GameState(Horse[] horses) {
		this.horses = horses;
	}

	@Override
	public void run() {

		// 경기가 언제 끝날지 모르니, 일단 무한루프로 시작
		while (true) {
			// 말들의 모든 경기가 끝났는지 여부 검사
			if (Horse.currentRank == horses.length) {
				// 말들의 랭크가 말의 마리수만큼 찍히면 마지막 말이 들어왔다는 뜻이므로
				// 경기가 끝났음을 알 수 있다.
				break;
			}

			for (int i = 1; i <= 10; i++) {
				System.out.println();
			}

			for (int i = 0; i < horses.length; i++) {
				System.out.print(horses[i].getHorseName() + " : ");
				for (int j = 1; j <= 50; j++) {
					// 말의 현재 위치를 찾아서 표시한다.
					if (horses[i].getLocation() == j) {
						System.out.print(">");
					}
					else {
						System.out.print("-");
					}
					
//					if(j == 50) {
//						System.out.println(horses[i].getRank() + "등!!");
//					}
					
				}
				if(horses[i].getRank() > 0) {
					System.out.print("  " + horses[i].getRank() + "등!");					
				}
				System.out.println(); // 그 다음말이 출력되기 위한 줄바꿈
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}

		}

	}

}
