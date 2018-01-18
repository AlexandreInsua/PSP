package escritoresLectores;

public class Simulador {
	private static int numUsuario = -1;
	private static long horaInicio;

	public synchronized static int sigUsuario() {
		numUsuario++;
		return numUsuario;
	}

	public Simulador(double tllegadaLec, double tllegadaEscr, int tleyendo, int tescribiendo, int tMax)
			throws InterruptedException {
		Monitor monitor = new Monitor();
		GeneradorLectores generaLectores = new GeneradorLectores(tllegadaLec, tleyendo, tMax, 1111, monitor);
		GeneradorEscritores generaEscritores = new GeneradorEscritores(tllegadaEscr, tescribiendo, tMax, 3333, monitor);
		
		generaEscritores.start();
		generaLectores.start();
	
		horaInicio = System.currentTimeMillis();
		Thread.sleep(tMax * 1000);
		generaLectores.interrupt();
		generaEscritores.interrupt();
		generaLectores.join();
		generaEscritores.join();
	}

	public static void main(String[] args) throws InterruptedException {
		Simulador s = new Simulador(3, 3, 1, 2, 30);
	}
}
