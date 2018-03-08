package exanteriorTiradaCartas;

import java.io.IOException;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerRunner {
	public final static int PORT = 9995;

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		TiradaCartasServer server = new TiradaCartasServer();
		try {
			server.init("224.0.0.1", PORT);
			server.runServer();
		} catch (SocketException ex) {
			Logger.getLogger(ServerRunner.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(ServerRunner.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			server.close();
		}
	}
}
