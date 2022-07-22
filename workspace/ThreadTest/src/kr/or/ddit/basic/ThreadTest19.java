package kr.or.ddit.basic;

public class ThreadTest19 {

   public static void main(String[] args) {
      DataBox box = new DataBox();
      
      ProducerThread th1=new ProducerThread(box);
      ConsumerThread th2 = new ConsumerThread(box);
      
      th1.start();
      th2.start();
   }

}

//데이터를 공통으로 사용하는 클래스
class DataBox{
   private String data;
   
   // data변수 값이 null이면 data 변수에 문자열이 저장될 때까지 기다리고 data 변수에 값이 있으면 해당 문자열을 반환한다.
   // 반환 후에는 data 변수 값을 null로 변경한다.
   public synchronized String getData() {
      
      if(data==null) {
         try {
            wait();
         } catch (InterruptedException e) {
         }
      }else {
         
      }
      String temp=data;
      
      System.out.println("스레드에서 읽은 데이터: "+data);
      
      data=null;
      
      notify();
      
      return temp;
      //return data; 후에 data=null;로 작성하면 return문 이후의 코드는 실행되지 않기 때문에 위와 같이 작성.
   }
   //data 변수에 값이 있으면 data변수 값이 null이 될 때까지 기다린다.
   public synchronized void setData(String data) {
      if(this.data!=null) {
         try {
            wait();
         } catch (InterruptedException e) {
         }
      }
      
      
      this.data = data;
      
      System.out.println("Thread에서 새로 저장한 데이터: "+data);
      
      notify();
   }

}
//데이터를 넣어주는 스레드(공급용 스레드)
class ProducerThread extends Thread{
   private DataBox dataBox;
   
   public ProducerThread(DataBox dataBox) {
      this.dataBox=dataBox;
   }
   
   @Override
   public void run() {
      for(int i=1; i<=3; i++) {
         dataBox.setData("공급 데이터: "+i);
      }
   }
   
}
//데이터를 꺼내서 사용하는 스레드(소비용 스레드)
class ConsumerThread extends Thread{
   private DataBox dataBox;
   
   public ConsumerThread(DataBox dataBox) {
      this.dataBox=dataBox;
   }
   
   @Override
   public void run() {
      for(int i=1; i<=3; i++) {
         String result=dataBox.getData();
      }
   }
   
}


