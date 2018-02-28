package b02comunicacions06bucleContinuoMellorado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor6 {

	public static void main(String[] args) {

		int numeroPorto = 6000;
		try {
			ServerSocket servidor = new ServerSocket(numeroPorto);
			String cad = "";
			System.out.println("Esperando conexión");
			Socket clienteConectado = servidor.accept();
			System.out.println("Cliente conectado");

			// CREO FLUJO DE SALIDA AL CLIENTE
			PrintWriter fsalida =   new PrintWriter(clienteConectado.getOutputStream(), true);
			// CREO FLUJO DE ENTRADA DEL CLIENTE
			BufferedReader fentrada = new BufferedReader(new InputStreamReader(clienteConectado.getInputStream()));
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			while ((cad = fentrada.readLine()) != null) {

				int numero = Integer.parseInt(cad);
				
				String r = elevarCubo(numero)+"";
				
				// recibo cad del cliente
				System.out.println("Server: " + cad);
				System.out.println("escribe");
				
				r = in.readLine();
				
				
				fsalida.println(r); // envio cadena al cliente
				

				if (cad.equals("*"))
					break;
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

	private static int elevarCubo(int numero) {
		
		return numero*numero*numero;
	}

}
