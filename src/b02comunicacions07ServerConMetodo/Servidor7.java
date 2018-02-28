package b02comunicacions07ServerConMetodo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor7 {

	public static void main(String[] args) {

		int numeroPorto = 6000;
		try {
			ServerSocket servidor = new ServerSocket(numeroPorto);
			String cad = "";
			System.out.println("Esperando conexión");
			Socket clienteConectado = servidor.accept();
			System.out.println("Cliente conectado");

			// CREO FLUJO DE SALIDA AL CLIENTE
			PrintWriter fsalida = new PrintWriter(clienteConectado.getOutputStream(), true);
			// CREO FLUJO DE ENTRADA DEL CLIENTE
			BufferedReader fentrada = new BufferedReader(new InputStreamReader(clienteConectado.getInputStream()));
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			while ((cad = fentrada.readLine()) != null) {
				if (cad.equals("*")) {
					System.out.println("O cliente corta a conexión");

					break;
				}
				System.out.println("cliente enviou" + cad);
				fsalida.println(elevarCubo(cad));

			}
			// CERRAR STREAMS Y SOCKETS
			System.out.println("Cerrando conexión...");
			fentrada.close();
			fsalida.close();
			clienteConectado.close();
			servidor.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String elevarCubo(String c) {
		String resultado;
		int aux;
		aux = Integer.parseInt(c);
		aux = (int) Math.pow(aux, 3);
		resultado = aux + "";
		return resultado + "";

	}
}
