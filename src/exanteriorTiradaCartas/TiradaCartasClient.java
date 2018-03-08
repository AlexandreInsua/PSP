package exanteriorTiradaCartas;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class TiradaCartasClient {
	private final String[] valores = { "A","K","Q","J","10","9" };
	ConsoleInterface userInterface = new ConsoleInterface();
	boolean continueRunning = true;
	MulticastSocket socket;
	InetAddress multicastIP;
	int port;
	float puntos=0;

	public void init(final String strIp, final int portValue) throws SocketException, IOException {
		multicastIP = InetAddress.getByName(strIp);
		port = portValue;
		socket = new MulticastSocket(port);
	}

	public void runClient() throws IOException {
		DatagramPacket packet;
		final byte[] receivedData = new byte[1024];
		// activamos la subscripcion
		socket.joinGroup(multicastIP);

		// El cliente atiende el puerto hasta que decide finalizar.
		while (continueRunning) {
			userInterface = new ConsoleInterface();
			userInterface.showMessage("Tirada: ");
			
				// creacion del paquete para recibir los datos
				packet = new DatagramPacket(receivedData, 1024);
				// Espera de los datos. Max 5 seg
				socket.setSoTimeout(50000);
				try {
					// Espera de los datos.
					socket.receive(packet);
					// procesamiento de los datos recibidos y obtencion de la
					// respuesta
					continueRunning = getData(packet.getData());

				} catch (final SocketTimeoutException e) {
					// Se ha excedido el tiempo de espera y queremos saber que
					// se ha de hacer
					userInterface.showMessage("Se ha perdido la conexion con el servidor.");
					continueRunning = timeoutExceeded();
				}
			
			userInterface.showMessage("");
		}
		// Se cancela la subscripcion
		socket.leaveGroup(multicastIP);
		close();
	}

	public void close() {
		if (socket != null && !socket.isClosed()) {
			socket.close();
		}
	}

	protected boolean getData(final byte[] data) {
		boolean ret = true;
		
		int[] temp = new int[5];
		try {
			temp = getInt(data);
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int a;
		for (int i = 0; i < 5; i++) {
			a = temp[i]; 
			userInterface.showMessage(valores[a]);

		}

		userInterface.showMessage("Tira otro jugador?(pulsa s)");
						
			ret = userInterface.read() != 'n';
		
		return ret;
	}

	protected boolean timeoutExceeded() {
		return false;
	}

	private void processError(final IOException ex) {
		userInterface.showError(ex);
	}

	private int[] getInt(final byte[] data) throws IOException {
		final int[] ret = new int[5];
		final DataInputStream dataIn = new DataInputStream(new ByteArrayInputStream(data));
		for(int i = 0; i < 5; i++) {
		      ret[i] = dataIn.readInt();
		}
		try {
			dataIn.close();
		} catch (final IOException ex) {
			System.out.println("Error");
		}
		return ret;
	}
}