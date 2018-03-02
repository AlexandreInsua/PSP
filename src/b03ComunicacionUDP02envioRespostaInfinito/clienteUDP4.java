package b03ComunicacionUDP02envioRespostaInfinito;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Clase Cliente UDP que envía un número a un Servidor UDP e recibe ese mesmo
 * número elevado ao cubo. Funciona indefinidamente.
 *
 */
public class clienteUDP4 {

	public static void main(String[] args) throws Exception {
		// fluxo de entrada
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// zócalo
		DatagramSocket clientSocket = new DatagramSocket();

		byte[] enviados = new byte[1024];
		byte[] recibidos = new byte[1024];

		 InetAddress IPServidor = InetAddress.getLocalHost();

		int puerto = 9876;
		// Pide mensaxe
		System.out.println("Introduce un numero: ");
		String cadena = in.readLine();

		do {
			// transforma en bytes a string
			enviados = cadena.getBytes();

			System.out.println("Enviando " + enviados.length + " bytes al servidor.");
			// para mandar un detagrama hai que marcar un array de bytes, a súa lonxitude ,
			// ip e porto
			DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);
			// chama o método do zócal e o envia
			clientSocket.send(envio);

			// crea un paquete para a recepción
			DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
			System.out.println("Esperando datagrama...");
			clientSocket.receive(recibo);
			// Extraio do paquete os datos e os paso a unha cadea
			String mayuscula = new String(recibo.getData());

			InetAddress IPOrigen = recibo.getAddress();
			int puertoOrigen = recibo.getPort();
			System.out.println("\t Procedente de: " + IPOrigen + ": " + puertoOrigen);
			System.out.println("\t Datos: " + mayuscula.trim());
			
			System.out.println("Introduce un numero: ");
		 cadena = in.readLine();
		} while (!cadena.equals("*"));

		clientSocket.close();
	}

}
