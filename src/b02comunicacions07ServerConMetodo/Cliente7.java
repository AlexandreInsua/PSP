package b02comunicacions07ServerConMetodo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente7 {
	public static void main(String[] args) throws IOException {
		String host = "localhost";
		//String host = "192.168.1.147";
		int Puerto = 6000;// puerto remoto
		Socket Cliente = new Socket(host, Puerto);
		// CREO FLUJO DE SALIDA AL SERVIDOR
		PrintWriter fsalida = new PrintWriter(Cliente.getOutputStream(), true);
		// CREO FLUJO DE ENTRADA AL SERVIDOR
		BufferedReader fentrada = new BufferedReader(new InputStreamReader(Cliente.getInputStream()));
		// FLUJO PARA ENTRADA ESTANDAR
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String cadena, resposta = "";
		System.out.print("Introduce número: ");
		cadena = in.readLine();// lectura por teclado
		while (cadena != null) {
			
			fsalida.println(cadena); // envio cadena al servidor
			resposta = fentrada.readLine(); // recibo cadena del servidor
			System.out.println("Número al cubo: " + resposta);
			
			System.out.print("Introduce otro número: ");
			cadena = in.readLine();// lectura por teclado
		}
		fsalida.close();
		fentrada.close();
		System.out.println("Fin del envío... ");
		in.close();
		Cliente.close();
	}
}