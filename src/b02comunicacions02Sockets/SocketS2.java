package b02comunicacions02Sockets;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Clase cliente
 */

public class SocketS2 {
	public static void main(String[] args) {
		String host = "localhost";
		int porto = 6000;

		try {
			// Abrir socket
			Socket cliente = new Socket(host, porto);
			InetAddress i = cliente.getInetAddress();
			System.out.println("Porto local: " + cliente.getLocalPort());
			System.out.println("Porto remoto: " + cliente.getPort());
			System.out.println("Host remoto: " + i.getHostName().toString());
			System.out.println("IP host remoto: " + i.getHostAddress().toString());
			cliente.close();

		} catch (UnknownHostException e) {

			e.printStackTrace();

		} catch (ConnectException ce) {

			ce.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
