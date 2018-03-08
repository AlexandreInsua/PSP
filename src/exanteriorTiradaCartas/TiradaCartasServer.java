package exanteriorTiradaCartas;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

public class TiradaCartasServer {
	ConsoleInterface console = new ConsoleInterface();
	MulticastSocket socket;
	InetAddress multicastIP;
	int port;
	boolean continueRunning = true;
	TiradaCartasSimulator simulator;

	public void init(final String strIp, final int portValue) throws SocketException, IOException {
		multicastIP = InetAddress.getByName(strIp);
		port = portValue;
		socket = new MulticastSocket(portValue);
		simulator = new TiradaCartasSimulator();
	}

	public void runServer() throws IOException, InterruptedException {
		DatagramPacket packet;
		byte[] sendingData;
		// El servidor hace envíos continuos mientras sea necesario
		while (continueRunning) {
			// Obtención de los datos a enviar. Supondremos la existencia de un
			// Método específico para las diferentes aplicaciones
				sendingData = getNextData();
				// Crear un paquete para enviar los datos obtenidos
				packet = new DatagramPacket(sendingData, sendingData.length, multicastIP, port);
				// Envío de los datos
				socket.send(packet);
			}
			try {
				Thread.sleep(100000);
			} catch (final InterruptedException ex) {

			}

			continueRunning = !transmissionFinished();
		
	}

	private boolean transmissionFinished() {
		boolean ret = false;
		
			ret = console.read() == 'n';
		
		return ret;
	}

	private byte[] getNextData() {
		final int[] temp = new int[5];
		for (int i = 0; i < 5; i++) {
			temp[i]=simulator.getTirada();
		}
		// System.out.println(temp);
		return getBytes(temp);
	}

	public void close() {
		if (socket != null && !socket.isClosed()) {
			socket.close();
		}
	}

	private byte[] getBytes(final int[] data) {
		byte[] ret;
		final ByteArrayOutputStream arrayOut = new ByteArrayOutputStream();
		final DataOutputStream dataOut = new DataOutputStream(arrayOut);

		try {
			for(int i = 0; i < 5; i++) {
				dataOut.writeInt(data[i]);
			}
		} catch (final IOException ex) {
			/* No hay error */
		}

		ret = arrayOut.toByteArray();

		try {
			dataOut.close();
		} catch (final IOException ex) {
			System.out.println("ERROR");
		}

		return ret;
	}

	private int getInt(final byte[] data) throws IOException {
		int ret;
		final DataInputStream dataIn = new DataInputStream(new ByteArrayInputStream(data));
		ret = dataIn.readInt();

		try {
			dataIn.close();
		} catch (final IOException ex) {
			System.out.println("ERROR");
		}

		return ret;
	}
}