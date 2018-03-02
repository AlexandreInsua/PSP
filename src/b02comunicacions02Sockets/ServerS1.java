package b02comunicacions02Sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase cliente que prepara dous zócalo para 2 clientes
 */

public class ServerS1 {
	public static void main(String[] args) {
		int porto = 6000;
		ServerSocket servidor = null;
		try {
			servidor = new ServerSocket(porto);
			System.out.println("Escoitando no porto " + servidor.getLocalPort());

			/* Simula un par de clientes */

			Socket cliente1 = servidor.accept();

			// realizar accións con cliente 1

			Socket cliente2 = servidor.accept();

			// realizar accións con cliente 2

			servidor.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
