package kr.or.ddit.basic;

import java.util.Scanner;

/*
  로또를 구매하는 프로그램 작성하기
 
 사용자는 로또를 구매할 때 구매할 금액을 입력하고
 입력한 금액에 맞게 로또번호를 출력한다.
 (단, 로또 한장의 금액은 1000원이며 최대 100장까지만 구입할 수 있고,
      거스름돈도 계산하여 출력한다.)

   ==========================
            Lotto 프로그램
   --------------------------
    1. Lotto 구입
    2. 프로그램 종료
   ==========================       
   메뉴선택 : 1  <-- 입력
         
    Lotto 구입 시작
       
   (1000원에 로또번호 하나입니다.)
   금액 입력 : 2500  <-- 입력
         
   행운의 로또번호는 아래와 같습니다.
   로또번호1 : 2,3,4,5,6,7
   로또번호2 : 20,21,22,23,24,25
         
   받은 금액은 2500원이고 거스름돈은 500원입니다.

   ==========================
            Lotto 프로그램
   --------------------------
    1. Lotto 구입
    2. 프로그램 종료
   ==========================       
   메뉴선택 : 1  <-- 입력
         
    Lotto 구입 시작
       
   (1000원에 로또번호 하나입니다.)
   금액 입력 : 900  <-- 입력
   
   입력 금액이 너무 적습니다. 로또번호 구입 실패!!!

   ==========================
            Lotto 프로그램
   --------------------------
    1. Lotto 구입
    2. 프로그램 종료
   ==========================       
   메뉴선택 : 1  <-- 입력
         
    Lotto 구입 시작
       
   (1000원에 로또번호 하나입니다.)
   금액 입력 : 101000  <-- 입력
   
   입력 금액이 너무 많습니다. 로또번호 구입 실패!!!
         
       ==========================
            Lotto 프로그램
   --------------------------
     1. Lotto 구입
     2. 프로그램 종료
   ==========================       
   메뉴선택 : 2  <-- 입력
      
   감사합니다
 */
public class Lotto {

   public static void main(String[] args) {
      
      // 사람 입장 
      int balance = 0; // 고객이 가지고 있는 금액
   
      
      
      Scanner sc = new Scanner(System.in);

      boolean run = true;

      while (run) {
         System.out.println("===========================");
         System.out.println("        Lotto 프로그램        ");
         System.out.println("---------------------------");
         System.out.println("1. Lotto 구입");
         System.out.println("2. 프로그램 종료");
         
         int choiceInput = sc.nextInt();
         
         if (choiceInput == 1) {

            System.out.println("===========================");
            System.out.println("메뉴선택 : " + choiceInput);
            
            // 로또 시스템 호출
//            (1000원에 로또번호 하나입니다.)
//            금액 입력 : 101000  <-- 입력
            System.out.println("(1000원에 로또번호 하나입니다.)");
            System.out.print("금액 입력 : ");
            balance = sc.nextInt();
            
            if(balance >= 1000 && balance <= 1000000) {
               LottoSystem los = new LottoSystem(); // LottoSystem 객체 생성
               // 살 수 있다는 조건
               // buy() 호출
               
               int change = los.buy(balance);
               System.out.println("거스름돈은 " + change + "원 입니다.");
               
            }else {
               System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!!");
               continue;
            }
               
            
         } else if (choiceInput == 2) {

            System.out.println("============================");
            System.out.println("메뉴선택 : " + choiceInput);
            System.out.println();
            System.out.println("감사합니다.");
            run = false;
         }

      }
   }
}