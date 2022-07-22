package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.net.Socket;

public class Receiver extends Thread {
	private Socket socket;
	private DataInputStream din;

	// 생성자
	public Receiver(Socket socket) {
		this.socket = socket;

		try {
			din = new DataInputStream(socket.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		while (din != null) {
			try {
				System.out.println(din.readUTF());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
