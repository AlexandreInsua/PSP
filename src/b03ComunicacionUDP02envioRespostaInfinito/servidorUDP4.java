package b03ComunicacionUDP02envioRespostaInfinito;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Servidor UDP que recibe un n�mero de un �nico cliente e devolve ese n�mero elevado
 * ao cubo.
 *
 */
public class servidorUDP4 {

	public static void main(String args[]) throws Exception {

		// Puerto por el que escucha el servidor: 9876
		// z�calo
		DatagramSocket serverSocket = new DatagramSocket(9876);

		// habilitar entrada de datos
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		byte[] recibidos = new byte[1024];
		byte[] enviados = new byte[1024];
		String cadena;

		while (true) {
			System.out.println("Esperando datagrama...");
			// RECIBO DATAGRAMA
			recibidos = new byte[1024];
			DatagramPacket paqRecibido = new DatagramPacket(recibidos, recibidos.length);
			serverSocket.receive(paqRecibido);
			cadena = new String(paqRecibido.getData());
			// DIRECCION ORIGEN
			InetAddress IPOrigen = paqRecibido.getAddress();
			int puerto = paqRecibido.getPort();
			System.out.println("\tOrigen: " + IPOrigen + ":" + puerto);
			System.out.println("\tMensaje recibido: " + cadena.trim());
			// CONVERTIR CADENA A MAY�SCULA
			/*
			 * String mayuscula = cadena.trim().toUpperCase(); enviados =
			 * mayuscula.getBytes();
			 */

			/*
			 * System.out.println("Introduza resposta: "); String cadea = in.readLine();
			 * enviados = cadea.getBytes();
			 */

			cadena = calcularCubo(cadena);
			cadena = "Numero elevado al cubo: " + cadena;

			enviados = cadena.getBytes();

			// ENVIO DATAGRAMA AL CLIENTE

			DatagramPacket paqEnviado = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
			serverSocket.send(paqEnviado);
			// Para terminar
			if (cadena.trim().equals("*"))
				break;
		}

		serverSocket.close();
		System.out.println("Socket cerrado...");

	}

	private static String calcularCubo(String cadena) {
		double  numero = Double.parseDouble(cadena);
		int cubo = (int) Math.pow(numero, 3);

		return cubo+"";
	}

}
