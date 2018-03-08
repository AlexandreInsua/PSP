package exanteriorTiradaCartas;

import java.io.IOException;

public class ClientRunner {
	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		try {
			TiradaCartasClient prg = new TiradaCartasClient();
			prg.init("224.0.0.1", ServerRunner.PORT);
			prg.runClient();
		} catch (IOException ex) {
			System.out.println("Error recibiendo/enviando");
		}
	}
}