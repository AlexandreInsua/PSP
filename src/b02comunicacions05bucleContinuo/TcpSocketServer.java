package b02comunicacions05bucleContinuo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TcpSocketServer {
	static final int PORT = 9090;
	private boolean end = false;

	public void listen() {
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		try {
			serverSocket = new ServerSocket(PORT);
			while (!end) {
				clientSocket = serverSocket.accept();
				// Procesamos la petición del cliente
				proccesClientRequest(clientSocket);
				// Cerramos el zócalo temporal para atender al cliente
				closeClient(clientSocket);
			}
			// Cerramos el zócalo principal
			if (serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
		} catch (IOException ex) {
			Logger.getLogger(TcpSocketServer.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void proccesClientRequest(Socket clientSocket) {
		boolean farewellMessage = false;
		String clientMessage = "";
		BufferedReader in = null;
		PrintStream out = null;
		try {
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out = new PrintStream(clientSocket.getOutputStream());
			do {
				// Procesamos el mensaje del cliente y generamos la respuesta. Si
				// ClientMessage está vacía generaremos el mensaje de bienvenida
				String dataToSend = processData(clientMessage);
				out.println(dataToSend);
				out.flush();
				clientMessage = in.readLine();
				farewellMessage = isFarewellMessage(clientMessage);
			} while ((clientMessage) != null && !farewellMessage);
		} catch (IOException ex) {
			Logger.getLogger(TcpSocketServer.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private boolean isFarewellMessage(String clientMessage) {
		// TODO Auto-generated method stub
		return false;
	}

	private String processData(String clientMessage) {
		// TODO Auto-generated method stub
		return null;
	}

	private void closeClient(Socket clientSocket) {
		// Si falla el cierre no podemos hacer mucho, sólo grabar
		// El problema
		try {
			// Cierre de todos los recursos
			if (clientSocket != null && !clientSocket.isClosed()) {
				if (!clientSocket.isInputShutdown()) {
					clientSocket.shutdownInput();
				}
				if (!clientSocket.isOutputShutdown()) {
					clientSocket.shutdownOutput();
				}
				clientSocket.close();
			}
		} catch (IOException ex) {
			// Registramos el error con un objeto Logger
			Logger.getLogger(TcpSocketServer.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	
	
}