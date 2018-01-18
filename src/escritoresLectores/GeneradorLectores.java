package escritoresLectores;




public class GeneradorLectores extends Thread {
    private double tMedioLlegada;
    private int tLeyendo;
    private int tMaxSimulacion;
    private Aleatorio aleatorio;
    private Monitor monitor;
    public GeneradorLectores (double tllegada, int tleyendo,
			      int tmax, int semilla, Monitor m){
        tMedioLlegada = tllegada;
        tLeyendo = tleyendo;
        tMaxSimulacion = tmax;
        aleatorio = new Aleatorio(semilla);
        monitor = m;
    }
    
    /**
     *
     */
    public void run()
    {
        System.out.println("Empezando la generación de lectores");
	try {
	    while (true) {
		int sigLector = aleatorio.poisson(tMedioLlegada);
		this.sleep(sigLector*1000);
                Lector lector = new Lector(Simulador.sigUsuario(), tLeyendo, monitor);
		System.out.println("generado "+lector);
                lector.start();
	    } 
	} catch ( InterruptedException e ) {}
        System.out.println("Simulación lectores finalizada");
    }
}// GeneradorLectores
