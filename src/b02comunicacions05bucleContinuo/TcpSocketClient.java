package b02comunicacions05bucleContinuo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TcpSocketClient {

	public void connect(String address, int puerto) {
		String serverData;
		String request;
		boolean continueConnected = true;
		Socket socket;
		BufferedReader in;
		PrintStream out;
		try {
			socket = new Socket(InetAddress.getByName(address), puerto);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintStream(socket.getOutputStream());
			// El cliente atiende el puerto hasta que decide finalizar
			while (continueConnected) {
				serverData = in.readLine();
				// Procesamiento de los datos recibidos y obtención de una nueva petición
				request = getRequest(serverData);
				// Envío de la petición
				out.println(request);
				// aseguramos que termina con un final de línea
				out.flush();
				// aseguramos que se envía
				// Comprobamos si la petición es un petición de finalización y en caso Que lo
				// sea nos preparamos para salir del bucle
				continueConnected = mustFinish(request);
			}
			close(socket);
		} catch (UnknownHostException ex) {
			reportError("Error de conexión. No existe el host", ex);
		} catch (IOException ex) {
			reportError("Error de conexión indefinido", ex);
		}

	}
	
	private void reportError(String string, IOException ex) {	
	}

	private boolean mustFinish(String request) {
		return false;
	}

	private String getRequest(String serverData) {
		return null;
	}

	private void close(Socket socket) {
		// Si falla el cierre no podemos hacer mucho, sólo grabar
		// El problema
		try {
		// Cierre de todos los recursos
		if (socket != null && !socket.isClosed()) {
		if ( !socket.isInputShutdown()) {
		socket.shutdownInput();
		}
		if (!socket.isOutputShutdown()) {
		socket.shutdownOutput();
		}
		
		socket.close();
		}
		} catch ( IOException ex ) {
		// Registramos el error con un objeto Logger
		Logger.getLogger(TcpSocketClient.class.getName()).log(Level.SEVERE,
		null, ex);
		}
		}
}
