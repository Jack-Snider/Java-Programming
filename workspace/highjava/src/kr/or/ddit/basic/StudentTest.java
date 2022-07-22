package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * - 고급자바,20220622 

   문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는
   Student클래스를 만든다. 이 Student클래스의 생성자에서는
   학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서 초기화
   처리를 한다.
   
   이 Student객체는 List에 저장하여 관리한다.
   List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는
   내부 정렬 기준을 구현하고,
   총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬되는
   외부 정렬 기준 클래스를 작성하여 정렬된 결과를 출력하시오.
   (단, 등수는 학생관리를 처리하는 클래스에서 구하도록 하는데
   List에 전체 데이터가 추가된 후에 처리되도록 한다.
   클래스명 : StudentTest )
 */
public class StudentTest {

   public static void main(String[] args) {
      
      ArrayList<Student> list = new ArrayList<Student>();
      
      list.add(new Student(20160746, "윤정식", 80, 76, 88));
      list.add(new Student(20110331, "이원걸", 96, 85, 97));
      list.add(new Student(20150366, "오용택", 85, 70, 90));
      list.add(new Student(20120241, "김호겸", 50, 99, 42));
      list.add(new Student(20150472, "조수빈", 50, 99, 42));
      list.add(new Student(20148422, "이찬솔", 50, 99, 42));
      list.add(new Student(20150467, "우디르", 40, 30, 80));
      TestDesc.setGrade(list);
      
      System.out.println("[정렬전]");
      for(Student stu : list) {
         System.out.println(stu);
      }
      
      System.out.println("\n-------------------------------------------------\n");
      
      Collections.sort(list);
      System.out.println("[학번 오름차순 정렬후]");
      for(Student stu : list) {
         System.out.println(stu);
      }
      
      System.out.println("\n-------------------------------------------------\n");
      
      Collections.sort(list, new TestDesc());
      
      System.out.println("[총점 내림차순 정렬후]");
      for(Student stu : list) {
         System.out.println(stu);
      }
   }
   
}

class Student implements Comparable<Student>{
   
   private int student_no;
   private String student_name;
   private int korean_score;
   private int english_score;
   private int math_score;
   private int total_score;
   private int grade;
   
   public Student(int student_no, String student_name, int korean_score, int english_score, int math_score) {
      super();
      this.student_no = student_no;
      this.student_name = student_name;
      this.korean_score = korean_score;
      this.english_score = english_score;
      this.math_score = math_score;
      this.total_score = korean_score + english_score + math_score;
   }

   public int getStudent_no() {
      return student_no;
   }

   public void setStudent_no(int student_no) {
      this.student_no = student_no;
   }

   public String getStudent_name() {
      return student_name;
   }

   public void setStudent_name(String student_name) {
      this.student_name = student_name;
   }

   public int getKorean_score() {
      return korean_score;
   }

   public void setKorean_score(int korean_score) {
      this.korean_score = korean_score;
   }

   public int getEnglish_score() {
      return english_score;
   }

   public void setEnglish_score(int english_score) {
      this.english_score = english_score;
   }

   public int getMath_score() {
      return math_score;
   }

   public void setMath_score(int math_score) {
      this.math_score = math_score;
   }

   public int getTotal_score() {
      return total_score;
   }

   public void setTotal_score(int total_score) {
      this.total_score = total_score;
   }

   public int getGrade() {
      return grade;
   }

   public void setGrade(int grade) {
      this.grade = grade;
   }

   @Override
   public String toString() {
      return "Student [student_no=" + student_no + ", student_name=" + student_name + ", korean_score=" + korean_score
            + ", english_score=" + english_score + ", math_score=" + math_score + ", total_score=" + total_score
            + ", grade=" + grade + "]";
   }

   @Override
   public int compareTo(Student student) {
      return Integer.compare(this.student_no, student.student_no);
   }
   
}


class TestDesc implements Comparator<Student>{

   @Override
   public int compare(Student forward, Student backward) {
      if(forward.getTotal_score() == backward.getTotal_score()) {               // 총점이 같으면 이름순으로 오름차순
         return forward.getStudent_name().compareTo(backward.getStudent_name());
      }
      return Integer.compare(forward.getTotal_score(), backward.getTotal_score()) * -1;      //총점 내림차순
   }
   
public static void setGrade(ArrayList<Student> list) {
      
      for(int i=0;i<list.size();i++) {
         int index = 1;
         int temp = list.get(i).getTotal_score();
         
         for(int j=0;j<list.size();j++) {
            if(list.get(j).getTotal_score() > temp) {
               index++;
            }
         }
         list.get(i).setGrade(index);
      }
   }
   
}