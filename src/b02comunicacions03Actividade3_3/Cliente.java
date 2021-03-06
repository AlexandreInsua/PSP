package b02comunicacions03Actividade3_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Clase cliente que crea infinitos clientes que env�an e reciben un sa�do ao servidor.
 * 
 */
public class Cliente {
	public static void main(String[] args) {

		String host = "localhost";
		Socket cliente ;
		// String host = "192.168.1.41"; // cristian

		// String host = "192.168.1.112"; // Araceli

		// String host = "192.168.1.150"; // Aaroon
		
		// String host = "localhost";
		
		int porto = 6000;
		int clienteContador = 1;
		while (true) {
			System.err.println("Programa cliente iniciado...");
			try {
				cliente = new Socket(host, porto);

				// CREA FLUXO DE SAIDA AO SERVIDOR
				DataOutputStream fluxoSaida = new DataOutputStream(cliente.getOutputStream());

				// ENVIO UN SALUDO AO SERVIDOR
				fluxoSaida.writeUTF("Enviado do cliente: " + clienteContador);

				// CREA FLUXO DE ENTRADA AO SERVIDOR
				DataInputStream fluxoEntrada = new DataInputStream(cliente.getInputStream());

				// O SERVIDOR ENVIA UNHA MENSAXE
				System.out.println("Recibindo do servidor: \n\t" + fluxoEntrada.readUTF());

				// PECHAR STREAM E SOCKETS
				fluxoEntrada.close();
				fluxoSaida.close();
				cliente.close();

			} catch (IOException e) {

				e.printStackTrace();
			}
			clienteContador ++;
		}

	}
}
