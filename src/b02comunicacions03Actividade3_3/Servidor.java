package b02comunicacions03Actividade3_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase Server que automaticamente recibe saudos e devolve resposta a infinitos clientes.
 *
 */
public class Servidor {

	public static void main(String[] args) throws IOException {
		int numeroPuerto = 6000;// Puerto
		ServerSocket servidor = new ServerSocket(numeroPuerto);

		int cliente = 0;

		while (true) {
			Socket clienteConectado = null;

			System.out.println("Esperando al cliente.....");

			clienteConectado = servidor.accept();

			// CREO FLUJO DE ENTRADA DEL CLIENTE
			InputStream entrada = null;
			entrada = clienteConectado.getInputStream();

			DataInputStream flujoEntrada = new DataInputStream(entrada);

			// EL CLIENTE ME ENVIA UN MENSAJE
			System.out.println("Recibiendo del CLIENTE: "+cliente +"  \n\t" + flujoEntrada.readUTF());

			// CREO FLUJO DE SALIDA, AL CLIENTE
			OutputStream salida = null;
			salida = clienteConectado.getOutputStream();
			DataOutputStream flujoSalida = new DataOutputStream(salida);

			// ENVIO UN SALUDO AL CLIENTE
			flujoSalida.writeUTF("Saludos al " + cliente + " cliente");

			// CERRAR STREAMS X SOCKETS
			entrada.close();
			flujoEntrada.close();
			salida.close();
			flujoSalida.close();
			clienteConectado.close();

			cliente++;
		}
	}
}
