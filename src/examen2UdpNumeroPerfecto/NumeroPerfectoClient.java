package examen2UdpNumeroPerfecto;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class NumeroPerfectoClient {
	
	public static final int STR_DATO = 0;


	public static final String[] STR_RESPUESTA = { "IMPERFECTO", "PERFECTO" };

	// INSTANCIA UN OBJETO INTERFAZ DE CONSOLA PARA MAIPULAR DATOS
	ConsoleInterface consoleInterface = new ConsoleInterface();

	InetAddress serverIP;
	int serverPort;
	DatagramSocket socket;
	int attemp = 0;

	public void init(String host, int port) throws SocketException, UnknownHostException {
		serverIP = InetAddress.getByName(host);
		serverPort = port;
		socket = new DatagramSocket();
	}

	public void runClient() throws IOException {

		int receivedData;
		int[] data;

		data = getFirstRequest();

		while (mustContinue(data)) {
			byte[] sendingData = getBytes(data, data.length);
			DatagramPacket packet = new DatagramPacket(sendingData, sendingData.length, serverIP, serverPort);

			socket.send(packet);

			packet = new DatagramPacket(new byte[1024], 1024);

			//METODO PARA DESCONECTAR SI SE PASA UNT IEMPO DE ESPERA
			socket.setSoTimeout(5000);
			try {

				socket.receive(packet);

				receivedData = getInt(packet.getData());

				data = getDataToRequest(receivedData);
			} catch (SocketTimeoutException e) {
				data = timeoutExceeded(packet);
				System.out.println("error al enviar");
			}
		}
		close();
	}

	public void close() {
		if (socket != null && !socket.isClosed()) {
			socket.close();
		}
	}

	//METODO PARA GESTIONAR LA INFORMACION DESDE EL CLIENTE
	protected int[] getDataToRequest(int receivedData) {
		int[] ret;
		showResponse(receivedData);
		if (consoleInterface.readYesNo("¿Quiere introducir otro número?: ", 'S', ConsoleInterface.TO_UPPPER_CASE)) {
			System.out.println();
			ret = getRequest();
		} else {
			ret = new int[] { -1 };
		}
		return ret;
	}

	protected int[] getFirstRequest() {
		showFirstMessage();
		return getRequest();
	}

	protected boolean mustContinue(int[] sendingData) {
		return (sendingData.length != 1 || sendingData[0] != -1);
	}

	protected int[] timeoutExceeded(DatagramPacket datagram) throws IOException {
		int[] ret;
		if (attemp < 3) {
			attemp++;
			ret = getInts(datagram.getData(), 3);
		} else {
			ret = new int[] { -1 };
		}
		return ret;
	}

	//METODO PRINCIPAL DE PETICION DE DATOS AL USUARIO
	private int[] getRequest() {
		int[] ret = new int[1];
		ret[STR_DATO] = consoleInterface.readInt("Escribe un número entero positivo:");
		System.out.println();
		return ret;
	}
//METOD PRIONCIPAL PARA DAR RESPUESTA AL USUARIO
	private void showResponse(int r) {
		System.out.print("El número introducido es: ");
		System.out.println(STR_RESPUESTA[r]);
		System.out.println();
	}
//MENSAJE DE APERTURA DEL CLIENTE
	private void showFirstMessage() {
		System.out.println(" BUSCADOR DE NÚMEROS PERFECTOS");
		System.out.println("----------------------------------");
		System.out.println();
	}

	private byte[] getBytes(int[] data, int length) {
		byte[] ret;
		ByteArrayOutputStream arrayOut = new ByteArrayOutputStream();
		DataOutputStream dataOut = new DataOutputStream(arrayOut);
		for (int i = 0; i < length; i++) {
			try {
				dataOut.writeInt(data[i]);
			} catch (IOException ex) {
				System.out.println("Error");
			}
		}
		ret = arrayOut.toByteArray();
		try {
			dataOut.close();
		} catch (IOException ex) {
			System.out.println("Error");
		}
		return ret;
	}

	private byte[] getBytes(int data) {
		byte[] ret;
		ByteArrayOutputStream arrayOut = new ByteArrayOutputStream();
		DataOutputStream dataOut = new DataOutputStream(arrayOut);
		try {
			dataOut.writeInt(data);
		} catch (IOException ex) {
			/* No error */}
		ret = arrayOut.toByteArray();
		try {
			dataOut.close();
		} catch (IOException ex) {
			System.out.println("Error");
		}
		return ret;
	}

	private int getInt(byte[] data) throws IOException {
		int ret;
		DataInputStream dataIn = new DataInputStream(new ByteArrayInputStream(data));
		ret = dataIn.readInt();
		try {
			dataIn.close();
		} catch (IOException ex) {
			System.out.println("Error");
		}
		return ret;
	}

	private int[] getInts(byte[] data, int size) throws IOException {
		int[] ret = new int[size];
		DataInputStream dataIn = new DataInputStream(new ByteArrayInputStream(data));
		for (int i = 0; i < size; i++) {
			ret[i] = dataIn.readInt();
		}
		try {
			dataIn.close();
		} catch (IOException ex) {
			System.out.println("Error");
		}
		return ret;
	}
}
