package b02comunicacions03clienteServidor;

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
			System.out.println("Recibindo do cliente: \n\t" + fluxoEntrada.readUTF());
			
			// CREO DO FLUXO DE SAÍDA AO CLIENTE
			OutputStream saida = null;
			saida = clienteConectado.getOutputStream();
			DataOutputStream fluxoSaida = new DataOutputStream(saida);
			
			// ENVIO UN SAÚDO AO CLIENTE
			fluxoSaida.writeUTF("Saúdos a Nona de Alexandre ;)");
			
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
