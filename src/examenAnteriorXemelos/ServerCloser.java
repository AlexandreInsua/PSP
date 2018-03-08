package examenAnteriorXemelos;

//codigo para cerrar el serversocket del servidor (el que escucha seguido)
//ojo no cierra los zocalos de las conexiones con el cliente
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerCloser {

	// ip y puerto
	String address;
	int port;

	/**
	 * El constructor permite configurar las instancias con una direccion y un
	 * puerto donde SE ENCUENTRA EL SERVIDOR.
	 * 
	 * @param address
	 * @param port
	 */

	public ServerCloser(String address, int port) {
		this.address = address;
		this.port = port;
	}

	public static void main(String[] args) {

		// OJO CON LA IP Y EL PUERTO
		ServerCloser programa = new ServerCloser("localhost", ServerRunner.PORT);
		programa.init();
	}

	/**
	 * Envia la instrucción para CERRAR EL SERVIDOR.
	 */

	public void init() {

		Socket socket = null;

		try {
			socket = new Socket(InetAddress.getByName(address), port, InetAddress.getLocalHost(),
					ServerRunner.CLOSE_PORT);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			out.write("CERRANDO EL SERVIDOR... ");
			out.newLine();
			out.flush();
			close(socket);
		} catch (IOException ex) {

			Logger.getLogger(ServerCloser.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void close(Socket socket) {

		// Si falla el cierre no podemos hacer mucho mas
		// salvo sacar a pantalla un logger del problema.

		try {
			// Cierre de TODOS los recursos
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
}