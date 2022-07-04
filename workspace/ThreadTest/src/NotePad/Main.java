package NotePad;

<<<<<<< HEAD
public class Main {
	
	public static void main(String[] args) {

		
	}
=======
class Account {

    int balance = 1000;
 
    public void withdraw(int money){
    
        if(balance >= money){
        
            try{
                Thread.sleep(1000);
            }catch(Exception e) { }
                balance -= money;
        }
    }
}

class Bank extends Thread{

    static Account obj = new Account();
    public Bank() { }
    public Bank(String name) { super(name); }
    
    public void run(){
    
        while(true){
        
            // 멀티 스레드 
            synchronized(obj){
            
                int money = (int)(Math.random() * 3 + 1) *100;
                if(obj.balance >= money){
                
                    System.out.println(getName() + " : 원본의 balance : " + obj.balance);
                    System.out.println(getName() + ": 찾는 금액 : " + money);
                    obj.withdraw(money);
                    System.out.println(getName() + " : 수정된 balance : " + obj.balance);
                }else{
                    System.out.println("잔액 부족");
                    break;
                }
                
            }
        }
    }
}

public class Main {

    public static void main(String args[]){
    
        Bank t1 = new Bank("ATM");
        Bank t2 = new Bank("은행");
        
        t1.start();
        t2.start();
    }
>>>>>>> e90cd1908778b5dcb007ea48f003d02a839944bd
}
