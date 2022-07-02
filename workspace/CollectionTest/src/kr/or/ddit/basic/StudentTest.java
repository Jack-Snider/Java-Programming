package kr.or.ddit.basic;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class StudentTest {

	public static void setRank(List<Student> list) {
		
		int rank = 1;
		for(int i = 0; i < list.size(); i++) {
			
			Student student = (Student) list.get(i);
			
			for(int j = 0; j < list.size(); j++) {
				Student std = (Student)list.get(j);
				if((int) student.getSum() < std.getSum()) {
					rank++;
				}
			}
			student.setRank(rank);
			rank = 1;
		}
		
	}
	
	
	public static void main(String[] args) {

		List<Student> list = new LinkedList<Student>();
		
		list.add(new Student("20187099","최현우",50,60,70,180,0));
		list.add(new Student("20187100","홍길동",45,32,22,99,0));
		list.add(new Student("20187101","하재관",0,0,0,0,0));
		list.add(new Student("20187102","강은비",70,80,90,240,0));
		list.add(new Student("20187103","홍무곤",70,73,85,228,0));
		list.add(new Student("20187104","정요한",90,80,87,257,0));
		
		setRank(list); // 순위계산해서 반영
		
		// 순위 반영된거 확인
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}

		
		Collections.sort(list);
		System.out.println("내부 정렬 후 ... "); 
		for(Student std : list) {
			System.out.println(std);
		}
		System.out.println("----------------------------------------------------");
		
		
		System.out.println("외부 정렬 후 ... ");
		Collections.sort(list, new Outside()); 
		for(Student std : list) {
			System.out.println(std);
		}
		System.out.println("----------------------------------------------------");
		
		
		
		
	}

}


class Outside implements Comparator<Student>{

	@Override
	public int compare(Student std1, Student std2) {
		// TODO Auto-generated method stub
		// 총점 ==>  외부 정렬 기준
		Integer std = std1.getSum();
		return  std.compareTo(std2.getSum()) * -1;
	}
	
}



class Student implements Comparable<Student>{
	
	private String id;
	private String name;
	private int korean;
	private int english;
	private int math;
	private int sum;
	private int rank;
	
	public Student(String id, String name, int korean, int english, int math, int sum, int rank) {
		super();
		this.id = id;
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
		this.sum = sum;
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", korean=" + korean + ", english=" + english + ", math=" + math
				+ ", sum=" + sum + ", rank=" + rank + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public int compareTo(Student std) {
		// TODO Auto-generated method stub
		return this.getId().compareTo(std.getId());
	}
	
	
	
	
	
}