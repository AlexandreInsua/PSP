package examenAnteriorXemelos;

public class ClientRunner {
	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		TcpCuboClient prg = new TcpCuboClient();

		// atencion a la ip y al puerto
		prg.connect("localhost", ServerRunner.PORT);
	}
}