package examenAnteriorXemelos;

public class ServerRunner {

	// puerto zocalo conexion normal
	public final static int PORT = 9995;
	// puerto que espera peticion de cierre
	static int CLOSE_PORT = 9999;

	public static void main(String[] args) {
		TcpCuboServer server = new TcpCuboServer();
		server.init(PORT, CLOSE_PORT);
		server.listen();
	}
}