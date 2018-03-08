package examenAnteriorXemelos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TcpCuboClient {

	ConsoleInterface userInterface = new ConsoleInterface();

	public void connect(String address, int port) {

		String serverData;
		String request;
		boolean continueConnected = true;
		Socket socket = null;
		BufferedReader in;
		PrintStream out;

		try {

			// instancia el socket y los flujos de entrada y salida
			socket = new Socket(InetAddress.getByName(address), port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintStream(socket.getOutputStream());

			// El cliente atiende el puerto HASTA QUE DECIDE FINALIZAR.
			while (continueConnected) {
				serverData = in.readLine();

				if (serverData != null) {
					// Si se desconecta el servidor regresara null

					// procesamiento de los datos recibidos y obtención de una
					// nuevaa petición
					request = getRequest(serverData);

					// envio de la petición
					out.println(request);
					// ASEGURESE QUE ACABA CON UN FINAL DE LINEA
					out.flush();
					// ASEGURESE QUE SE ENVIA

					// Comprobamos si la petición es un petición de finalización
					// y en caso
					// de que lo sea nos preparamos para salir del bucle
					continueConnected = !mustFinish(request);
				} else {
					reportError("El servidor se ha DESCONECTADO", null);
					continueConnected = false;
				}
			}
			close(socket);
		} catch (UnknownHostException ex) {
			reportError("Error de connexión. No existe el host", ex);
		} catch (IOException ex) {
			reportError("Error de connexión indefinido", ex);
		}
	}

	private void close(Socket socket) {
		// Si falla el cierre del zocalo no podemos hacer mucho mas
		// salvo sacar a pantalla un logger del problema.

		try {
			// cierre de todos los recursos
			if (socket != null && !socket.isClosed()) {
				if (!socket.isInputShutdown()) {
					socket.shutdownInput();
				}
				if (!socket.isOutputShutdown()) {
					socket.shutdownOutput();
				}
				socket.close();
			}
		} catch (IOException ex) {
			// Guardamos la informacion del error con un objeto Logger
			Logger.getLogger(TcpCuboClient.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// METODO DE LECTURA Y ESCRITURA
	protected String getRequest(String serverData) {
		String ret;
		userInterface.showMessage(serverData);
		ret = userInterface.readLine();
		return ret;
	}

	// METODO QUE COMPRUEBA SI DEBE FIANLIZAR CON s Ó S
	protected boolean mustFinish(String request) {
		return (request.length() > 0 && (request.charAt(0) == 's' || request.charAt(0) == 'S'));
	}

	// METODO PARA SACAR A PANTALLA LOS MENSAJES DE ERROR USANDO LA CONSOLA
	protected void reportError(String message, Exception ex) {
		if (ex == null) {
			userInterface.showError(message);
		} else {
			userInterface.showError(message, ex);
		}
	}
}