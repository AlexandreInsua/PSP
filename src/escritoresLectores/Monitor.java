package escritoresLectores;

public class Monitor {
	private int escrEsperando; // numero escritores agardando;
	private int numLect; // numero lectores lendo
	private int numEscr; // número escritores lendo

	/*
	 * escrEsperando >= numEscr 0 <= numEscr <= 1 numLect=>0 numlect > 0 --->
	 * numEsc = 0
	 */

	public Monitor() {
		escrEsperando = 0;
		numLect = 0;
		numEscr = 0;
	}

	
	
	public int getEscrEsperando() {
		return escrEsperando;
	}



	public void setEscrEsperando(int escrEsperando) {
		this.escrEsperando = escrEsperando;
	}



	// mentres houber un escritor lendo ou esperando para escribir, os lectores
	// espreas
	public synchronized void permisoLer() throws InterruptedException {
		// este if dálle prioridade aos escritores 
		/*if (numEscr==0){
			wait();
		}*/
		while (numEscr > 0 || escrEsperando > 0) {
			wait();
		}
		numLect++;
	}

	public synchronized void finLer() {
		numLect--;
		if (numLect == 0) {
			notifyAll();
		}

	}

	// mentres haxa lectores agarda, logo escribe
	public synchronized void permisoEscribir() throws InterruptedException {
		escrEsperando--;
		while (numLect > 0 || numEscr > 0) {
			wait();
		}
		numEscr++;
	}

	public synchronized void finEscribir() {
		numEscr--;
		notifyAll();
	}

	@Override
	public String toString() {
		return "nl:" + numLect + ", ne:" + numEscr + ", ee:" + escrEsperando;
	}

}
