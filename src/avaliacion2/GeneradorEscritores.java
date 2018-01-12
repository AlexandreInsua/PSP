package avaliacion2;

public class GeneradorEscritores extends Thread {
	private double tMedioLlegada;
	private int tEscribiendo;
	private int tMaxSimulacion;
	private Aleatorio aleatorio;
	private Monitor monitor;

	public GeneradorEscritores(double tllegada, int tescribiendo, int tmax, int semilla, Monitor m) {
		tMedioLlegada = tllegada;
		tEscribiendo = tescribiendo;
		tMaxSimulacion = tmax;

		aleatorio = new Aleatorio(semilla);
		monitor = m;
	}

	/**
	 *
	 */
	public void run() {
		System.out.println("Empezando la generación de escritores");
		try {
			while (true) {
				// Chamamos ao un método estadístico de tipo promedio de poisson
				int sigEscritor = aleatorio.poisson(tMedioLlegada);
				this.sleep(sigEscritor * 1000);
				Escritor escritor = new Escritor(Simulador.sigUsuario(), tEscribiendo, monitor);
				System.out.println("Generado " + escritor);
				escritor.start();
			}
		} catch (InterruptedException e) {
		}
		System.out.println("Simulación escritores finalizada");
	}
}// GeneradorEscritores
