package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoSystem {

   
   
   // 로또를 구입하는 메소드
   public int buy(int balance) {
      // buy메소드는 사용자의 현재 보유금액을 매개변수로 받는다.
      
      List<Integer> lotto = new ArrayList<Integer>();
      
      int count = balance / 1000;
      
      for(int i = 0; i < count; i++) {
         lotto.addAll(createLottoNum());
         
      }
      
      
      int change = balance % 1000;
      
      System.out.println("행운의 로또번호는 아래와 같습니다.");
      int index = 1;
      for(int i = 0; i < lotto.size(); i++) {
         if(i % 6 == 0) {
            System.out.println();
            System.out.print("로또번호" + index + " : ");
            index++;
         }
            System.out.print(lotto.get(i) + " ");
                        
         
      }
      
      System.out.println();
      
      return change;
   }
   
   
   // 로또 번호 생성하는 메소드
   public List<Integer> createLottoNum() {
            
      /*
       * set을 이용해서 중복되지 않는 로또 생성
       * 번호를 생성해서 lotto에 저장     
       */
      Set<Integer> lotto_num = new HashSet<Integer>();
      
      for(int i = 0; lotto_num.size() < 6; i++) {
         
         int number = (int)(Math.random() * 45 + 1);
         lotto_num.add(number);
      }
      
      
      List<Integer> lot = new ArrayList<Integer>(lotto_num);
      
      return lot; 
   }
   
   
   
   
   
}


