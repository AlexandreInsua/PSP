package b02comunicacions04clienteServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		int numeroPorto = 6000;
		try {
			ServerSocket servidor = new ServerSocket(numeroPorto);
			Socket clienteConectado = null;
			System.out.println("Agardando a un cliente...");
			clienteConectado = servidor.accept();
			

						
			//CREA FLUXO DE ENTRADA DO CLIENTE	
			InputStream entrada = null;
			entrada = clienteConectado.getInputStream();
			DataInputStream fluxoEntrada = new  DataInputStream(entrada);
			
			// O CLIENTE ENVIA UNHA MENSAXE
			System.out.println("Recibindo do cliente : \n\t" + fluxoEntrada.readUTF());
			
			// CREO DO FLUXO DE SAÍDA AO CLIENTE
			OutputStream saida = null;
			saida = clienteConectado.getOutputStream();
			DataOutputStream fluxoSaida = new DataOutputStream(saida);
			
			// ENVIO UN SAÚDO AO CLIENTE
			fluxoSaida.writeUTF("Saúdos ao cliente 1 de Alexandre ;)");
			
			
			Socket clienteConectado2 = null;
			clienteConectado2 = servidor.accept();
			InputStream entrada2 = null;
			entrada2 = clienteConectado2.getInputStream();
			DataInputStream flujoEntrada2 = new DataInputStream(entrada2);
			System.out.println("Recibiendo del CLIENTE: \n\t" + flujoEntrada2.readUTF());
			OutputStream salida2 = null;
			salida2 = clienteConectado2.getOutputStream();
			DataOutputStream flujoSalida2 = new DataOutputStream(salida2);
			flujoSalida2.writeUTF("Saludos cliente 2 de Alexandre");
			
			// PECHAR STREAMS E SOCKETS
			entrada.close();
			fluxoEntrada.close();
			saida.close();
			fluxoSaida.close();
			clienteConectado.close();
			servidor.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
