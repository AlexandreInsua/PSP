package examenAnteriorXemelos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TcpCuboServer {

	private int port;
	private boolean end = false;
	private int closePort;

	// METODO QUE INICIALIZA EL SERVIDOR
	public void init(int port, int closePort) {
		this.port = port;
		this.closePort = closePort;
	}

	// METODO DE ESCUCHA DEL SOCKET SERVER
	public void listen() {

		// DECLARA EL SOCKETSERVER Y EL SERVER
		ServerSocket serverSocket;
		Socket clientSocket;

		// CREA EL SOCKET SERVER
		try {
			serverSocket = new ServerSocket(port);

			// BUCLE DE ESCUCHA INFINITA
			while (!end) {

				// ACEPTA LA CONEXION
				clientSocket = serverSocket.accept();

				// COMPRUEBA SI ES LA SEÑAL DE CIERRE; SI NO LO ES SIGUE

				if (isClosingSignal(clientSocket)) {
					end = true;
				} else {
					// Procesamos la petición del cliente.
					proccesClientRequest(clientSocket);

					// Cerramos el socket temporal para atender al cliente
					closeClient(clientSocket);
				}
			} // del while

			// cerramos el serversocket principal
			if (serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
		} catch (IOException ex) {
			Logger.getLogger(TcpCuboServer.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// METODO PARA DECIDIR SI SEGUIMOS O CERRAMOS
	public boolean isClosingSignal(Socket clientSocket) {
		InetAddress inetAddress = clientSocket.getInetAddress();
		boolean ret = (inetAddress.isLoopbackAddress() || inetAddress.isSiteLocalAddress())
				&& clientSocket.getPort() == closePort;
		return ret;
	}

	// METODO DE LECTURA Y ESCRITURA
	protected void proccesClientRequest(Socket clientSocket) {

		// SUPONEMOS a FALSO
		boolean farewellMessage = false;

		// CADENA DONDE ALMACENAMOS EL MENSAJE DEL CLIENTE
		String clientMessage = "";

		// BUFFER DE ENTADA Y SALIDA
		BufferedReader in = null;
		PrintStream out = null;

		try {
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out = new PrintStream(clientSocket.getOutputStream());

			do {
				// Procesamos el mensaje del cliente y generamos la respuesta.
				// Si clientMessage esta VACIA generaremos el mensaje de
				// bienvenida

				// CREA LA CADENA A ENVIAR LLAMANDO A proccessData y pasandole
				// el mensaje que llega del cliente
				String dataToSend = processData(clientMessage);

				// ENVIA LA CADENA
				out.println(dataToSend);
				// COMPRUEBA EL ENVIO
				out.flush();
				// MUESTRA LA CADENA del CLIENTE
				clientMessage = in.readLine();

				// COMPRUEBA SI DICHA CADENA ES LA DE CIERRE
				farewellMessage = isFarewellMessage(clientMessage);

			} while (!farewellMessage);// del do -- while

		} // del try
		catch (IOException ex) {
			Logger.getLogger(TcpCuboServer.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// METODO PARA CERRAR EL CLIENTE
	protected void closeClient(Socket clientSocket) {

		// Si falla el cierre del zocalo no podemos hacer mucho mas
		// salvo sacar a pantalla un logger del problema.

		try {
			// cerramos todos los recursos
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
			// Guardamos la informacion del error con un objeto Logger
			Logger.getLogger(TcpCuboServer.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// METODO QUE DEVUELVE LA CADENA PARA ENVIAR
	protected String processData(String clientMessage) {
		String messageToSend;
		String [] mes = new String[2];
		String sonGemeloss="";
		if (clientMessage.length() == 0) {
			// generar missatge de benvinguda
			messageToSend = "Hola bienvenido al servidor que calcula si dos números son gemelos. Envia dos números semarados por una coma (,)"
					+ " 's' si quieres abandonar la conexión.";
		} else {
			try {
				mes=clientMessage.split(",");
				int a =Integer.parseInt( mes[0]);
				int b = Integer.parseInt(mes[1]);
				if(sonGemelos(a,b)){
					sonGemeloss="Son gemelos";
				}else{
					sonGemeloss= "No son gemelos";
				}
				
				messageToSend = "Los números "+a+" y "+b+" "+sonGemeloss;
			} catch (NumberFormatException ex) {
				messageToSend = "No has enviado ningún número. Si quiere calcular otro cubo introduzca el número."
						+ "Si quiere salir envie el caracter 's'.";
			}
		}

		// CADENA A ENVIAR
		return messageToSend;
	}
	private boolean sonGemelos(int a, int b){
		if(!esPrimo(a)){
			return false;
		}else if(!esPrimo(b)){
			return false;
		}else if((a-b)==2){
			return true;
		}else if((b-a)==2){
			return true;
		}
		return false;
	}
    public static boolean esPrimo(int numero){
        int contador = 2;
        boolean primo=true;
        while ((primo) && (contador!=numero)){
          if (numero % contador == 0)
            primo = false;
          contador++;
        }
        return primo;
      }
	// METODO PARA COMPROBAR SI ES EL MENSAJE DE DESPEDIDA pasandole la cadena
	// que viene del cliente
	protected boolean isFarewellMessage(String clientMessage) {
		return (clientMessage == null || clientMessage.length() > 0 && (clientMessage.charAt(0) == 's')
				|| (clientMessage.charAt(0) == 'S'));
	}

}