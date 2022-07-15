package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

// 이 스레드는 소켓을 통해서 메세지를 보내는 역할만 담당한다.
public class Sender extends Thread{
	private Socket socket;
	private DataOutputStream dout;
	private String name; // 대화명
	private Scanner scan;
	
	// 생성자
	public Sender(Socket socket) {
		this.socket =  socket;
		scan = new Scanner(System.in);
		
		System.out.print("대화명 입력 >>> ");
		name = scan.nextLine();
		
		try {
			dout = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Sender(Socket socket, File file) {
		this.socket =  socket;
		scan = new Scanner(System.in);
		
		System.out.println("연결이 완료되었습니다.!!");
		
		System.out.print("대화명 입력 >>> ");
		name = scan.nextLine();
		
		
		try {
			
			dout = new DataOutputStream(socket.getOutputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(dout != null) {
			try {
				
				dout.writeUTF(name + " : " + scan.nextLine());
				
			} catch (IOException e) {
				
			}
		}
	}
}
